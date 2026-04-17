package com.kh.spring09.controller;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.MemberExitDao;
import com.kh.spring09.dao.MemberHistoryDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.MemberExitDto;
import com.kh.spring09.dto.MemberHistoryDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberExitDao memberExitDao;
	@Autowired
	private MemberHistoryDao memberHistoryDao;
	
		//회원정보 등록(일반)
		@GetMapping("/join")
		public String join() {
			return "member/join";
		}
		@PostMapping("/join")
		public String join(@ModelAttribute MemberDto memberDto) {
			memberDao.insert(memberDto);
			return "redirect:./joinFinish";
		//	return "redirect:/member/joinFinish";
		}
		
		@RequestMapping("/joinFinish")
		public String joinComplete() {
			return "member/joinFinish";
		}
	
		//로그인
		@GetMapping("/login")
		public String login() {
			return "member/login";
		}
		@PostMapping("/login")
		public String login(@ModelAttribute MemberDto memberDto, 
								HttpSession session, // 세션을 사용하겠다 요청
//								@RequestHeader("User-Agent") String userAgent, //헤더값 읽기 - 이걸론 IP를 알 수 없음
								HttpServletRequest request//요청 정보를 모두 가져오기
								) { // 아이디 비밀번호 존재
			//[1] 사용자가 입력한 아이디를 이용하여  DB에 대상이 존재하는지 조회
			//MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId());
			MemberExitDto findMemberDto = memberExitDao.selectOne(memberDto.getMemberId());
			if(findMemberDto == null) {
				return "redirect:./login?error"; // 아이디 없음 (redirect는 GET으로만 간다.)
			}
			//[2] 비밀번호 확인
			//boolean isPasswordValid = memberDto의 비밀번호 == findMemberDto의 비밀번호;
			boolean isPasswordValid = memberDto.getMemberPassword().equals(findMemberDto.getMemberPassword());
			
			if(!isPasswordValid) {
				return "redirect:./login?error"; // 비밀번호 불일치;
			}
			
			//[3] 이 회원의 member_block 상태가 Y라면 차단
			if(findMemberDto.getMemberBlock().equals("Y")) {
				return "redirect:./block";
			}
			//[4] 탈퇴 예정인 회원이라면 로그인을 취소하고 안내페이지로 이동
			if(findMemberDto.isWaitForDelete()) {
				return "redirect:./waiting";//삭제예정 안내 페이지로 이동
				
			}
			
			//[5] 차단되지 않았다면 로그인 성공 
			//-로그인 시간을 갱신
			memberDao.updateMemberLogin(findMemberDto.getMemberId());
			//-로그인 이력 생성
			MemberHistoryDto memberHistoryDto = new MemberHistoryDto();
			memberHistoryDto.setMemberHistoryOrigin(findMemberDto.getMemberId());//아이디
			memberHistoryDto.setMemberHistoryAddress(request.getRemoteAddr()); //IP
			memberHistoryDto.setMemberHistoryAgent(request.getHeader("User-Agent")); //Agent
			memberHistoryDao.insert(memberHistoryDto);
			
			//- 세션(HttpSession)에 로그인 되었음을 표시
			session.setAttribute("loginId", findMemberDto.getMemberId());
			session.setAttribute("loginLevel", findMemberDto.getMemberLevel());
			
			//[6] 비밀번호 변경한 시간을 비교해서 일정시간 이상이면 비밀번호 변경 안내 페이지를 리다이렉트 <-> 리다이렉트를 안붙이면 포워드(forword)상태
			// 비밀번호를 변경한지 30일이 지난 계정은 로그인 성공시 비밀번호 변경 안내를 추가
			Timestamp last = findMemberDto.getMemberChange(); // 가장 최근 로그인한 시각
			if(last == null) {//바꾼적 없으면
				last = findMemberDto.getMemberJoin(); // 그럼 가입일로 하자
			}
			LocalDateTime lastChange = last.toLocalDateTime(); // 위에서 계산한 시간과
			LocalDateTime current = LocalDateTime.now(); // 현재 시각과의
			Duration duration = Duration.between(lastChange, current); //차이를 구해라!
			if(duration.toDays() >= 1) {// 비밀번호 변경한지 일정시간(ex: 1시간)
				return "redirect:./notice"; // 비밀번호 변경 알림 페이지로 이동
			}
			
			return "redirect:/";
		}
		
		//로그아웃(회원 전용 기능)
		//- 로그인 시 세션에 저장한 정보를 제거하는 작업
		@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.removeAttribute("loginId");
			session.removeAttribute("loginLevel");
			return "redirect:/";
		}
		
		@RequestMapping("/block")
		public String block() {
			return "member/block";
		}
		@RequestMapping("/waiting")
		public String waiting() {
			return "member/waiting";
		}
	
		//마이페이지(회원 전용 기능)
		//- 세션에 들어있는 아이디를 이용해서 현재 회원의 모든 정보를 화면에 전달
		@RequestMapping("/mypage")
		public String mypage(HttpSession session, Model model) {
			//session에 존재하는 현재 사용자 영역에 저장된 loginId라는 이름의 값을 불러오세요!
			String loginId = (String) session.getAttribute("loginId");
			
			//개인정보 조회 후 첨부
			MemberDto memberDto = memberDao.selectOne(loginId);
			model.addAttribute("memberDto",memberDto);
			
			//로그인 이력 조회 후 첨부
			List<MemberHistoryDto> loginHistory = 
									memberHistoryDao.selectList(loginId, 1, 10);
			model.addAttribute("loginHistory",loginHistory);
			
			return "member/mypage";
		}
		
		@RequestMapping("/history")
		public String history(HttpSession session, Model model,
							@RequestParam(required = false) String beginDate,
							@RequestParam(required = false) String endDate,
							@RequestParam(required = false, defaultValue = "1") int page,
							@RequestParam(required = false, defaultValue = "20") int size) {
			String loginId = (String) session.getAttribute("loginId");
			
			int endRow = page * size;
			//int beginRow = endRow - (size - 1);
			int beginRow = (page - 1) * size + 1;
			
			List<MemberHistoryDto> loginHistory = 
					memberHistoryDao.selectList(loginId, beginDate, endDate, beginRow, endRow);
			
			model.addAttribute("loginHistory", loginHistory);
			
			return "member/history";
		}
		
		//비밀번호 변경
		@GetMapping("/password")
		public String password() {
			return "member/password";
		}
		
		@PostMapping("/password")
		public String password(@RequestParam String originPw,
				               @RequestParam String changePw, HttpSession session) {
			//[1] 동일한 비밀번호로 변경을 시도하는 경우 차단
			if(originPw == changePw) {
				return "redirect:./password?error";
			}
			
			String loginId = (String) session.getAttribute("loginId");
			MemberDto memberDto = memberDao.selectOne(loginId);
			
			//[2] 기존 비밀번호가 일치하지 않는 경우는 차단
			
			boolean isPasswordValid = originPw.equals(memberDto.getMemberPassword());
			if(!isPasswordValid) {
				return "redirect:./password?error";	
			}
			//[3] 1, 2번을 통과했다면 비밀번호 변경 처리를 수행
			memberDto.setMemberPassword(changePw); // 기존 정보에서 비밀번호만 바꾸고
			memberDao.updateMemberPassword(memberDto); //변경을 요청한다.
			return "redirect:./passwordFinish";
		}
		@RequestMapping("/passwordFinish")
		public String passwordFinish() {
			return "member/passwordFinish";
		}
		
		// 개인정보 조회
		@RequestMapping("/detail")
		public String detail(@RequestParam String memberId, Model model) {
			MemberDto memberDto = memberDao.selectOne(memberId);
			model.addAttribute("memberDto",memberDto);
			return "member/detail";
		}
		
		//개인정보 수정 변경 (회원 전용 기능 - 무조건 session이 있어야함) // mypage와 동일한 패턴
		@GetMapping("/edit")
		public String edit(HttpSession session, Model model) { // 얘들은 그 어떤 어노테이션을 쓰면 안됨, 스프링에서 가져오는 데이터이 이기 때문
			String loginId = (String) session.getAttribute("loginId"); // spring에서는 아무것도 담으라고 Object로 되어있기 때문에 다운캐스팅이 자주 일어난다
			//loginId는 null값일 수 가 절대 없음? why? 로그인을 한 사람만 이 창으로 들어올 수 있기 때문
			MemberDto memberDto = memberDao.selectOne(loginId);
			model.addAttribute("memberDto", memberDto);
		    return "member/edit";
		}
		
		@PostMapping("/edit")
		public String edit(HttpSession session, @ModelAttribute MemberDto memberDto) {
		    String loginId = (String) session.getAttribute("loginId");
		    
		    //비밀번호 검사 후 차단 코드
		    MemberDto findMemberDto = memberDao.selectOne(loginId);
		    boolean valid = findMemberDto.getMemberPassword().equals(memberDto.getMemberPassword());
		    if (!valid) {
		    	return "redirect:./edit?error"; // 비번 틀리면 바로 퇴장
		    }
		    
		    //개인정보 변경 처리
		    memberDto.setMemberId(loginId);
		    memberDao.update(memberDto);  // 로그인된 사용자이기 때문에 수정이 안된다는 경우는 없다 // 시스템을 믿는다
		    return "redirect:./mypage"; // 메인으로 이동
		}
		
		//회원탈퇴 매핑(회원 전용 기능)
		@GetMapping("/goodbye")
		public String goodbye() {
		    return "member/goodbye";
		}
		
		@PostMapping("/goodbye")
		public String goodbye(HttpSession session, @RequestParam String memberPassword) {
			String loginId = (String) session.getAttribute("loginId");
		    MemberDto findMemberDto = memberDao.selectOne(loginId);
		  
		    
		    boolean valid = findMemberDto.getMemberPassword().equals(memberPassword);
		    if (!valid) {
		    	return "redirect:./goodbye?error"; // 비번 틀리면 비밀번호 입력페이지로
		    }
		    // 비밀번호가 맞으면 
			// 회원탈퇴 회원탈퇴와 로그아웃은 반드시 같이 실행되어야 한다. 아주 강한 결합도를 가지고 있음(강결합)
			//memberDao.delete(loginId); // 회원의 모든 데이터가 다 사라지는 일이 발생 (복구불가)
			memberExitDao.insert(loginId);
			
			// 로그아웃
			//session.invalidate(); //세션 파괴 명령 -> 동일 정보로 재가입 시, 신규사용자가 되어버림 
			//세션 청소 명령
			session.removeAttribute("loginId");
			session.removeAttribute("loginLevel");
			
			
			return "redirect:./goodbyeFinish";
		}
		
		@RequestMapping("/goodbyeFinish")
		public String goodbyeFinish() {
			return "member/goodbyeFinish";
		}
		
		
		//삭제
		@RequestMapping("/delete")
		public String delete(@RequestParam String memberId) {
			MemberDto memberDto = memberDao.selectOne(memberId);
			if(memberDto == null) {
				throw new TargetNotfoundException("존재하지 않는 회원");
			}
			memberDao.delete(memberId);
			return "redirect:./list";
		}
		
		
		@RequestMapping("/notice")
		public String notice() {
			return "member/notice";
		}
		
		
		@RequestMapping("/later")
		public String later(HttpSession session, Model model) {
			String loginId = (String) session.getAttribute("loginId"); //로그인 아이디를 찾고
			MemberDto memberDto = memberDao.selectOne(loginId); // 회원정보를 불러와서
			memberDao.updateMemberPassword(memberDto); //그대로 업데이트(시간만 바뀜)
			return "redirect:/"; //메인페이지로 리다이렉트
		}
}

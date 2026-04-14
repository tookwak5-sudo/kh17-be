package com.kh.spring09.controller;

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
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
		//회원정보 등록(일반)
		@GetMapping("/join")
		public String join() {
			return "/WEB-INF/views/member/join.jsp";
		}
		@PostMapping("/join")
		public String join(@ModelAttribute MemberDto memberDto) {
			memberDao.insert(memberDto);
			return "redirect:./joinFinish";
	//		return "redirect:/member/joinFinish";
		}
		
		@RequestMapping("/joinFinish")
		public String joinComplete() {
			return "/WEB-INF/views/member/joinFinish.jsp";
		}
	
		//로그인
		@GetMapping("/login")
		public String login() {
			return "/WEB-INF/views/member/login.jsp";
		}
		@PostMapping("/login")
		public String login(@ModelAttribute MemberDto memberDto, HttpSession session) { // 아이디 비밀번호 존재
			//[1] 사용자가 입력한 아이디를 이용하여  DB에 대상이 존재하는지 조회
			MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId());
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
			
			//[4] 차단되지 않았다면 로그인 성공
			//-로그인 시간을 갱신
			memberDao.updateMemberLogin(findMemberDto.getMemberId());
			
			//- 세션(HttpSession)에 로그인 되었음을 표시
			session.setAttribute("loginId", findMemberDto.getMemberId());
			session.setAttribute("loginLevel", findMemberDto.getMemberLevel());
			
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
			return "/WEB-INF/views/member/block.jsp";
		}
	
		//마이페이지(회원 전용 기능)
		//- 세션에 들어있는 아이디를 이용해서 현재 회원의 모든 정보를 화면에 전달
		@RequestMapping("/mypage")
		public String mypage(HttpSession session, Model model) {
			//session에 존재하는 현재 사용자 영역에 저장된 loginId라는 이름의 값을 불러오세요!
			String loginId = (String) session.getAttribute("loginId");
			MemberDto memberDto = memberDao.selectOne(loginId);
			
			model.addAttribute("memberDto",memberDto);
			return "/WEB-INF/views/member/mypage.jsp";
		}
		
		//비밀번호 변경
		@GetMapping("/password")
		public String password() {
			return "/WEB-INF/views/member/password.jsp";
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
			return "/WEB-INF/views/member/passwordFinish.jsp";
		}
		
		//개인정보 수정 변경 (회원 전용 기능 - 무조건 session이 있어야함) // mypage와 동일한 패턴
		@GetMapping("/edit")
		public String edit(HttpSession session, Model model) { // 얘들은 그 어떤 어노테이션을 쓰면 안됨, 스프링에서 가져오는 데이터이 이기 때문
			String loginId = (String) session.getAttribute("loginId"); // spring에서는 아무것도 담으라고 Object로 되어있기 때문에 다운캐스팅이 자주 일어난다
			//loginId는 null값일 수 가 절대 없음? why? 로그인을 한 사람만 이 창으로 들어올 수 있기 때문
			MemberDto memberDto = memberDao.selectOne(loginId);
			model.addAttribute("memberDto", memberDto);
		    return "/WEB-INF/views/member/edit.jsp";
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
		
		//회원탈퇴 매핑(회원 저뇽ㅇ 기능)
		@GetMapping("/goodbye")
		public String goodbye() {
		    return "/WEB-INF/views/member/goodbye.jsp";
		}
		
		@PostMapping("/goodbye")
		public String goodbye(HttpSession session, @RequestParam String memberPassword) {
			String loginId = (String) session.getAttribute("loginId");
			//비밀번호 검사 후 차단 코드
		    MemberDto findMemberDto = memberDao.selectOne(loginId);
		    boolean valid = findMemberDto.getMemberPassword().equals(memberPassword);
		    if (!valid) {
		    	return "redirect:./goodbye?error"; // 비번 틀리면 비밀번호 입력페이지로
		    }
		    // 비밀번호가 맞으면 
			// 회원탈퇴 회원탈퇴와 로그아웃은 반드시 같이 실행되어야 한다. 아주 강한 결합도를 가지고 있음(강결합)
			memberDao.delete(loginId);
			
			// 로그아웃
			//session.invalidate(); //세션 파괴 명령 -> 동일 정보로 재가입 시, 신규사용자가 되어버림 
			//세션 청소 명령
			session.removeAttribute("loginId");
			session.removeAttribute("loginLevel");
			
			
			return "redirect:./goodbyeFinish";
		}
		
		@RequestMapping("/goodbyeFinish")
		public String goodbyeFinish() {
			return "/WEB-INF/views/member/goodbyeFinish.jsp";
		}
		
		//목록 및 검색
		@RequestMapping("/list")
		public String list(Model model,
						@RequestParam(required = false) String column,
						@RequestParam(required = false) String keyword) {
			List<MemberDto> list = memberDao.selectList(column, keyword);
			
			model.addAttribute("list",list);
			
			return "/WEB-INF/views/member/list.jsp";
		}
		
		//상세조회
		@RequestMapping("/detail")
		public String detail(Model model, @RequestParam String memberId) {
			MemberDto memberDto = memberDao.selectOne(memberId);
			if(memberDto == null) {
				throw new TargetNotfoundException("존재하지 않는 회원");
			}
			model.addAttribute("memberDto", memberDto);
			return "/WEB-INF/views/member/detail.jsp";
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
}

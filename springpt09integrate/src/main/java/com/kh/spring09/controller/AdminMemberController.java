package com.kh.spring09.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.MemberExitDao;
import com.kh.spring09.dao.MemberHistoryDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.dto.MemberExitDto;
import com.kh.spring09.dto.MemberHistoryDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.service.AttachService;


@Controller
@RequestMapping("/admin/member")
public class AdminMemberController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberExitDao memberExitDao;
	@Autowired
	private MemberHistoryDao memberHistoryDao;
	@Autowired
	private AttachService attachService;
	
			//검색
			@RequestMapping("/list")
			public String list(Model model, 
							@RequestParam(required = false) String column,
							@RequestParam(required = false) String keyword
							) {
				List<MemberDto> list = memberDao.selectList(column, keyword);
				model.addAttribute("list",list);
					
				return "admin/member/list";
			}
			
//			@RequestMapping("/detail/{memberId}")
//			public String detail(@PathVariable String memberId, Model model) {
			@RequestMapping("/detail")
			public String detail(@RequestParam String memberId, Model model) {
				
				MemberExitDto memberDto = memberExitDao.selectOne(memberId);
//				if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
//				if(memberDto.getMemberLevel().equals("마스터")) throw new GetOutException();
				model.addAttribute("memberDto",memberDto);
				
				//로그인 이력 조회 후 첨부
				List<MemberHistoryDto> loginHistory = 
										memberHistoryDao.selectList(memberId, 1, 10);
				model.addAttribute("loginHistory",loginHistory);
				
				return "admin/member/detail";
			}
			
			@RequestMapping("/block")
			public String block(@RequestParam String memberId, Model model) {
				MemberDto memberDto = memberDao.selectOne(memberId); // 없을수도 있음
//				if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
				
				String current = memberDto.getMemberBlock(); //현재 상태를 불러온다
				String future = current.equals("Y") ? "N" : "Y";
				memberDto.setMemberBlock(future);
				memberDao.updateMemberBlock(memberDto); //객체로 아이디와 차단상태를 전달
				//memberDao.updateMemberBlock(memberId, future); //문자열 두개로 아이다와 차단상태를 전환
				model.addAttribute("memberDto",memberDto);
				
				return "redirect:./detail?memberId="+memberId;
			}
			
			//회원정보 변경
			@GetMapping("/edit")
			public String edit(@RequestParam String memberId, Model model) { // 얘들은 그 어떤 어노테이션을 쓰면 안됨, 스프링에서 가져오는 데이터이 이기 때문
				MemberDto memberDto = memberDao.selectOne(memberId); // 정보를 조회해서
//				if(memberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
				model.addAttribute("memberDto", memberDto);  // 여기선 memberExitDto를 쓸 필요가 없는게, 관리자가 지운다기 보다는 접근을 못하게 가능 
				return "admin/member/edit";
			}
			
			@PostMapping("/edit")
			public String edit(@ModelAttribute MemberDto memberDto,@RequestParam MultipartFile attach) throws IOException, Exception {
//				MemberDto findMemberDto = memberDao.selectOne(memberDto.getMemberId());
//			    if(findMemberDto == null) throw new TargetNotfoundException("존재하지 않는 회원");
//				memberDao.update(memberDto); //쓰면 안됨(등급과 포인트가 수정되지 않음) -> 기존걸 고치거나 신규기능을 만들기 -> 기존걸 고치는건 지양, 새로운걸 만들기!
			    
			    memberDao.updateByMaster(memberDto);
			    
			  //첨부파일이 있다면 기존 거 제거 후 신규 등록
				if(!attach.isEmpty()) {
					try {
						int attachNo = memberDao.searchProfile(memberDto.getMemberId()); // 원래 깃발번호
						attachService.delete(attachNo); //지워
					}catch(Exception e){/*없어으면 기존 깃발이 없다*/}
					
					int attachNo = attachService.save(attach);// 새로 지정해
					memberDao.connect(memberDto.getMemberId(), attachNo);
				}
			    
			    
			    return "redirect:./detail?memberId=" + memberDto.getMemberId(); // 메인으로 이동
			}
	
}

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
	
	
//	//회원정보 등록(관리자)
//	@GetMapping("/insert")
//	public String insert() {
//		return "/WEB-INF/views/member/insert.jsp";
//	}
//	@PostMapping("/insert")
//	public String insert(@ModelAttribute MemberDto memberDto) {
//		memberDao.insert(memberDto);
//		
//		return "redirect:./insertComplete";
//	}
//	
//	@RequestMapping("/insertComplete")
//	public String insertComplete() {
//		return "/WEB-INF/views/member/insertComplete.jsp";
//	}
	
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
		public String login(@ModelAttribute MemberDto memberDto) { // 아이디 비밀번호 존재
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
			
			//[4] 차단되지 않았다면 로그인 성공
			//-로그인 시간을 갱신
			memberDao.updateMemberLogin(findMemberDto.getMemberId());
			return "redirect:/";
		}
		
//		@PostMapping("/login")
//		public String login(@ModelAttribute MemberDto inputDto, HttpSession session) {
//			// 사용자가 입력한 아이디로 DB조회
//			MemberDto findDto = memberDao.selectOne(inputDto.getMemberId());
//			
//			// 일치여부 확인
//			if(findDto != null && inputDto.getMemberPassword().equals(findDto.getMemberPassword())) {
//				session.setAttribute("loginId", findDto.getMemberId());
//				session.setAttribute("loginLevel", findDto.getMemberLevel());
//				return "redirect:/";
//			}
//			else {
//				//로그인 실패
//				return "redirect:./login?error";
//			}
//		}
	
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
	
	//수정
	@GetMapping("/edit")
	public String edit(@RequestParam String memberId, Model model) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		if(memberDto == null) {
			throw new TargetNotfoundException("존재하지 않는 회원");
		}
		
		model.addAttribute("memberDto", memberDto);
		return "/WEB-INF/views/member/edit.jsp";
	}
	
	@PostMapping("/edit")
	public String edit(@ModelAttribute MemberDto memberDto) {
		memberDao.update(memberDto);
		return "redirect:./detail?memberNo="+ memberDto.getMemberId();
	}
	
	
	
	
}

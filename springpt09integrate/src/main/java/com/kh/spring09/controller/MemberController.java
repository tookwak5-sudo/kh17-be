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

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/insert")
	public String insert() {
		return "/WEB-INF/views/member/insert.jsp";
	}
	@PostMapping("/insert")
	public String insert(@ModelAttribute MemberDto memberDto) {
		memberDao.insert(memberDto);
		return "redirect:./insertComplete";
	}
	
	@RequestMapping("/insertComplete")
	public String insertComplete() {
		return "/WEB-INF/views/member/insertComplete.jsp";
	}
	
	@RequestMapping("/list")
	public String list(Model model,
					@RequestParam(required = false) String column,
					@RequestParam(required = false) String keyword) {
		List<MemberDto> list = memberDao.selectList(column, keyword);
		
		model.addAttribute("list",list);
		return "/WEB-INF/views/member/list.jsp";
	}
}

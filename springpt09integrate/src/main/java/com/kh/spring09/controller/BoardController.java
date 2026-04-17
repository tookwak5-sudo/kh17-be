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

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	//게시글 작성(등록)
	@GetMapping("/writer")
	public String writer() {
		return "board/writer";
	}
	@PostMapping("/writer")
	public String writer(HttpSession session
							,@ModelAttribute BoardDto boardDto) {
		String loginId = (String) session.getAttribute("loginId");
		boardDto.setBoardWriter(loginId);
		
		int findNo = boardDao.sequence();
		boardDto.setBoardNo(findNo);
		boardDao.write(boardDto);
		return "redirect:./detail?boardNo=" + (boardDto.getBoardNo() + 1);
	}
	
	//게시글 목록
//	@RequestMapping("/list")
//	public String list(HttpSession session, Model model,
//					@RequestParam(required=false) String column,
//					@RequestParam(required=false) String keyword) {
//		String loginId = (String) session.getAttribute("loginId");
//		List<BoardDto> list = boardDao.selectList(column, keyword);
//		model.addAttribute("list",list);
//		model.addAttribute("loginId", loginId);
//		return "board/list";
//	}
	
	@RequestMapping("/list")
	public String list(HttpSession session, Model model,
					@RequestParam(required=false) String column,
					@RequestParam(required=false) String keyword) {
		String loginId = (String) session.getAttribute("loginId");
		List<BoardDto> list = boardDao.selectList(column, keyword);
		
		
		model.addAttribute("list",list);
		model.addAttribute("loginId", loginId);
		return "board/list";
	}
	
	//게시글 상세조회
	@RequestMapping("/detail")
	public String detail(Model model, HttpSession session,
						@RequestParam int boardNo) {
		String loginId = (String) session.getAttribute("loginId");
		BoardDto boardDto = boardDao.selectOne(boardNo);
		
		if(boardDto == null) {
	        return "redirect:list"; // 혹은 에러 페이지
	    }
		model.addAttribute("boardDto", boardDto);
	    model.addAttribute("loginId", loginId);
	    
	    return "board/detail";
	}
	
	//게시글 수정
	@GetMapping("/edit")
	public String edit(HttpSession session
						,@RequestParam int boardNo, Model model) {
		String loginId = (String) session.getAttribute("loginId");
		BoardDto boardDto = boardDao.selectOne(boardNo);
		
		model.addAttribute("boardDto",boardDto);
		model.addAttribute("loginId", loginId);
		return "board/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto) {
		
		boardDao.edit(boardDto);
		return "redirect:./detail?boardNo=" + boardDto.getBoardNo();
	}
	//삭제
	@RequestMapping("/delete")
	public String delete(HttpSession session,
						@RequestParam int boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		boardDao.delete(boardNo);
		return "redirect:./list";
	}
}

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
	
	
	//목록 매핑
	@RequestMapping("/list")
	public String list(Model model,
					@RequestParam(required=false) String column,
					@RequestParam(required=false) String keyword) {
		List<BoardDto> list = boardDao.selectList(column, keyword);
		
		
		model.addAttribute("list",list);
		return "board/list";
	}
	
	//게시글 상세조회
	@RequestMapping("/detail")
	public String detail(Model model,
						@RequestParam long boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException();//없을 수도 있기 때문에
	    
		//통과 했다면
		model.addAttribute("boardDto", boardDto);
	    
	    //이전글과 다음글을 조회하여 첨부
	    model.addAttribute("prevBoardDto", boardDao.selectPreviousOne(boardNo));
	    model.addAttribute("nextBoardDto", boardDao.selectNextOne(boardNo));
	    
	    return "board/detail";
	}
	
	//등록 매핑
		@GetMapping("/writer")
		public String writer() {
			return "board/writer";
		}
		@PostMapping("/writer")
		public String writer(HttpSession session
							,@ModelAttribute BoardDto boardDto) {
			//[1] 작성자 아이디 추출
			String loginId = (String) session.getAttribute("loginId");
			
			//[2] 글 번호 생성
			long boardNo = boardDao.sequence();
			
			//[3] 정보 취합 후 등록 요청
			boardDto.setBoardWriter(loginId);
			boardDto.setBoardNo(boardNo);
			boardDao.insert(boardDto);
			
			//[4] 상세페이지로 리다이렉트
			return "redirect:./detail?boardNo=" + boardNo;
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

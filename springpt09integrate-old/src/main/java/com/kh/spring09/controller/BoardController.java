package com.kh.spring09.controller;

import java.util.ArrayList;
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
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.vo.PageVo;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardDao boardDao;
	
	
	//목록 및 검색 매핑
	@RequestMapping("/list")
	public String list(Model model, @ModelAttribute PageVo pageVo) {
		//공지사항 게시글
//		List<BoardDto> noticeList = boardDao.selectList("board_head","공지");
		List<BoardDto> noticeList = boardDao.selectNoticeList();
		
		//일반 게시글 (공지사항도 포함되어 있음)
		List<BoardDto> boardList = boardDao.selectList(pageVo);
		
		//두 개를 합쳐서 전달
		List<BoardDto> list = new ArrayList<>();
		list.addAll(noticeList); //공지사항 먼저
		list.addAll(boardList); //게시글은 나중에
		
		model.addAttribute("list",list);
		model.addAttribute("noticeCount", noticeList.size());//공지사항 개수를 전달
		
		//페이징을 위해 추가로 전달할 값이 있다면 전달해야 한다
		int count = boardDao.count(pageVo);
		pageVo.setCount(count);//데이터 개수 설정
		model.addAttribute("pageVo", pageVo);
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
		
		//[+추가] 작성한 글이 "공지"라면 관리자, 즉 "마스터"인지를 반드시 확인
		if(boardDto.getBoardHead() != null && boardDto.getBoardHead().equals("공지")) {
			String loginLevel = (String)session.getAttribute("loginLevel");
			if(!loginLevel.equals("master")) {
				throw new GetOutException();
			}
		}
			
		//[2] 글 번호 생성
		long boardNo = boardDao.sequence();
		
		//[3] 정보 취합 후 필요한 항목을 계산하고(새글/답글) 등록 요청
		boardDto.setBoardWriter(loginId);
		boardDto.setBoardNo(boardNo);
		
		if(boardDto.getBoardParent() == null) { //새글
			boardDto.setBoardGroup(boardNo);//그룹번호를 글번호로 설정하세요
			//boardDto.setBoardParent(null); //상위 글번호를 null로 설정
			//boardDto.setBoardDepth(0L); //차수를 0으로 설정
		}
		else {// 답글
			BoardDto findBoardDto = boardDao.selectOne(boardDto.getBoardParent()); //
			boardDto.setBoardGroup(findBoardDto.getBoardGroup()); // 원본글과 동일한 그룹
		  //boardDto.setBoardParent(findBoardDto.getBoardParent()); // 원본글의 글번호
			boardDto.setBoardDepth(findBoardDto.getBoardDepth()+1); // 원본글의 차수 + 1
		}
		
		
		boardDao.insert(boardDto);
		
		//[4] 상세페이지로 리다이렉트
		return "redirect:./detail?boardNo=" + boardNo;
	}
	//삭제
	@RequestMapping("/delete")
	public String delete(HttpSession session, @RequestParam long boardNo) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		boardDao.delete(boardNo);
		return "redirect:./list";
	}
	
	//게시글 수정
	@GetMapping("/edit")
	public String edit(@RequestParam long boardNo, Model model) {
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		
		model.addAttribute("boardDto",boardDto);
		return "board/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BoardDto boardDto, HttpSession session) {

		//[+추가] 작성한 글이 "공지"라면 관리자, 즉 "마스터"인지를 반드시 확인
		if(boardDto.getBoardHead() != null && boardDto.getBoardHead().equals("공지")) {
			String loginLevel = (String)session.getAttribute("loginLevel");
			if(!loginLevel.equals("master")) {
				throw new GetOutException();
			}
		}
		// interceptor에서 처리할 예정 굳이 안써도 됨
		BoardDto findBoardDto = boardDao.selectOne(boardDto.getBoardNo());
		if(findBoardDto == null) throw new TargetNotfoundException("존재하지 않는 게시글");
		
		boardDao.update(boardDto);
		return "redirect:./detail?boardNo=" + boardDto.getBoardNo();
	}
	
}

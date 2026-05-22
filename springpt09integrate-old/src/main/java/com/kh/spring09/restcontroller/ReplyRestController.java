package com.kh.spring09.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.dto.ReplyDto;
import com.kh.spring09.vo.ReplyVO;

import jakarta.servlet.http.HttpSession;

//CrossOrigin 외부일 경우
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private BoardDao boardDao;
	//등록
	@PostMapping("/write")
	public void write(@ModelAttribute ReplyDto replyDto, HttpSession session ) {
		//origin하고 writer은 무조건 가져와야함
		long replyNo = replyDao.sequence();
		String loginId = (String)session.getAttribute("loginId");
		
		replyDto.setReplyNo(replyNo);
		replyDto.setReplyWriter(loginId);
		
		replyDao.insert(replyDto);
	}
	
	// 댓글 목록
	//- 조회한 결과만 보내는게 아니라 해당글의 작성자인지 아닌지를 판정해서 정보를 추가한다
	//- 작성자본인이라는건 "boardWriter" 와 "replyWriter"가 null이 아닌데 같은 경우를 말한다
	//- 소유자라는건 "loginId"와 "replyWriter"가 null이 아닌데 같은 경우를 말한다
	@PostMapping("/list")
	public List<ReplyVO> list(@RequestParam long replyOrigin, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId"); // null일 수도 있음
		BoardDto boardDto = boardDao.selectOne(replyOrigin);
		
		List<ReplyDto> list = replyDao.selectList(replyOrigin); // 댓글 목록 조회
		List<ReplyVO> newList = new ArrayList<>();
		for(ReplyDto replyDto : list) {
			boolean writer = boardDto.getBoardWriter() != null
					 	&& boardDto.getBoardWriter().equals(replyDto.getReplyWriter());
			boolean owner = loginId != null && loginId.equals(replyDto.getReplyWriter());
			
			newList.add(ReplyVO.builder()
						.replyNo(replyDto.getReplyNo())//번호를 옮겨담는다
						.replyWriter(replyDto.getReplyWriter())//작성자를 옮겨담는다
						.replyContent(replyDto.getReplyContent())
						.replyOrigin(replyDto.getReplyOrigin())
						.replyWtime(replyDto.getReplyWtime())
						.replyEtime(replyDto.getReplyEtime())
						.writer(writer) // 작성자 여부를 계산
						.owner(owner) // 소유자 여부를 계산
					.build());
		}
//		return replyDao.selectList(replyOrigin);
		return newList;
	}
	
	// 댓글 삭제
	@PostMapping("/delete")
	public void delete(@RequestParam long replyNo) {
		replyDao.delete(replyNo);
	}
	
	//댓글수정
	@PostMapping("/edit")
	public void edit(@ModelAttribute ReplyDto replyDto) {
		replyDao.update(replyDto);
	}
}

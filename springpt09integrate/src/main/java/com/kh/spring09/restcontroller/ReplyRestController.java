package com.kh.spring09.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.ReplyDto;

import jakarta.servlet.http.HttpSession;

//CrossOrigin 외부일 경우
@RestController
@RequestMapping("/rest/reply")
public class ReplyRestController {
	@Autowired
	private ReplyDao replyDao;
	
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
	@PostMapping("/list")
	public List<ReplyDto> list(@RequestParam long replyOrigin) {
		return replyDao.selectList(replyOrigin);
	}
	
}

package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.ReplyDao;
import com.kh.spring09.dto.ReplyDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.TargetNotfoundException;
import com.kh.spring09.exception.WhoAreYouException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표 : 본인 소유의 댓글일 경우만 수정 삭제로 들어갈 수 있도록 처리
@Service
public class ReplyOwnerInterceptor implements HandlerInterceptor {
	@Autowired
	private ReplyDao replyDao;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//[1] 파라미터에 replyNo가 없으면 차단
		String replyNoStr = request.getParameter("replyNo");
		
		if(replyNoStr == null) {
			throw new TargetNotfoundException("존재하지 않는 댓글");
		}
		
		//[2]비회원일 경우 제거
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		if(loginId == null) {
			throw new WhoAreYouException();
		}
		
		//[3] 댓글이 없어도 차단
		long replyNo = Long.parseLong(replyNoStr);
		ReplyDto replyDto =replyDao.selectOne(replyNo);
		if(replyDto == null) {
			throw new TargetNotfoundException("존재하지 않는 댓글");
		}
		
		//[4] 작성자가 없으면 차단
		if(replyDto.getReplyWriter() == null) {
			throw new GetOutException(); // 회원이면 나가요
		}
		
		//[5] 소유자가 아니면 차단
		if(!loginId.equals(replyDto.getReplyWriter())) {
			throw new GetOutException();
		}
		
		return true;
	}
}

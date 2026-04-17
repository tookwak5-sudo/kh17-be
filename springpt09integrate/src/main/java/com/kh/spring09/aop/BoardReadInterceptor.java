package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 글을 읽을 때마다 조회수가 1씩 증가//회원 비회원 구분없이
@Service
public class BoardReadInterceptor implements HandlerInterceptor{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//파라미터에서 boardNo추출
		String boardNoStr = request.getParameter("boardNo");
		
		if(boardNoStr == null) {
			throw new IllegalArgumentException("잘못된 형식의 요청");
		}
		
		int boardNo = Integer.parseInt(boardNoStr);
		
		
        // DAO를 통해 조회수를 1 증가시킵니다.
        boardDao.editReadcount(boardNo);
		
		
		return true;
	}
	
}

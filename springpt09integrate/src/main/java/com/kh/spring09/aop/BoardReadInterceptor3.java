package com.kh.spring09.aop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표 :
//- 세션(HttpSession)을 이용해서 읽은 글의 번호를 관리하겠다
//- (1) 세션에 memory라는 이름의 저장소가 있다고 가정 (저장소는 HashSet)
//- (2) 세션에서 memory 저장소를 꺼낸다
//- (3) 2번에서 저장소가 없으면 신규 생성한다
//- (4) 현재 읽으려는 글번호가 memory저장소에 존재하는 지 확인
//- (5-1) 만약 존재한다면 조회수 증가 처리
//- (5-2) 만약 존재하지 않는다면 저장소에 번호를 등록하고 조회수 증가 처리 후 통과
@Service
public class BoardReadInterceptor3 implements HandlerInterceptor{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//파라미터에서 boardNo를 찾아서 해당글의 조회수를 증가
		String boardNoStr = request.getParameter("boardNo");
		
		//[1] boradNo가 없을 경우 - 처리를 쉽게 하기 위해 String으로 booardNo를 받아오기
		if(boardNoStr == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
		
		//[2] boardNo가 유효하지 않는 번호인 경우 제거
		long boardNo = Integer.parseInt(boardNoStr);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		if(boardDto == null) {
			throw new TargetNotfoundException("존재하지 않는 게시글");
		}
		
		//[3] 세션의 memory 항목을 조사하여 조회수 여부를 판정하겠다
		HttpSession session = request.getSession();
		Set<Long> memory = (Set<Long>) session.getAttribute("memory");
		if(memory == null) {// 없으면 
			memory = new HashSet<>(); // 신규생성
		}
		
		//[6] 조회수 증가 처리
        boardDao.updateBoardReadcount(boardNo);
		
		// 조회수가 올라가든 안올라가든 무조건 통과
		return true;
	}
}

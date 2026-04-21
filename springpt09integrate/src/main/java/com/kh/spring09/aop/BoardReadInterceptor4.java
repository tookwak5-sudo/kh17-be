package com.kh.spring09.aop;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.BoardReadDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.TargetNotfoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//목표 :
//- 데이터베이스(DBMS)를 이용해서 조회 이력을 저장하고 중복을 차단합니다
//- 아이디를 기반으로 하기 때문에 세션이 달라도 차단이 된다
@Service
public class BoardReadInterceptor4 implements HandlerInterceptor{
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private BoardReadDao boardReadDao;
	
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
		
		//[3] 비회원인 경우 제거
		HttpSession session = request.getSession();
		String loginId = (String) session.getAttribute("loginId");
		if(loginId == null) {
			return true;
		}
		
		//[4] DB에 조회이력이 있으면 제거
		int count = boardReadDao.count(loginId, boardNo);
		if(count > 0) {//기록이 1개 이상이면
			return true;// 지나가세요
		}
		//[5] DB 조회이력을 생성
		boardReadDao.insert(loginId, boardNo);
		
		//[6] 조회수 증가 처리 // 이제 중복되는 느낌이 있지만, 반정규화 느낌으로 그냥 놔둔다
        boardDao.updateBoardReadcount(boardNo);
		
		// 조회수가 올라가든 안올라가든 무조건 통과
		return true;
	}
}

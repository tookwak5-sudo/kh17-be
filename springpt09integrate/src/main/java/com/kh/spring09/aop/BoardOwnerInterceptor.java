package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dto.BoardDto;
import com.kh.spring09.exception.GetOutException;
import com.kh.spring09.exception.WhoAreYouException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//소유자의 접근만을 허용하는 인터셉터
@Service	
public class BoardOwnerInterceptor implements HandlerInterceptor{
	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// boolean값으로 와서 같으면 통과 다르면 불통
		//[1] 세션 획득
		HttpSession session = request.getSession();
		
		//[2] 로그인 관련 정보와 boardNo를 획득
		String loginId = (String) session.getAttribute("loginId");
		String boardStr = request.getParameter("boardNo");
		
		//[3] 글 번호로 selectOne통해서 정보를 다 가져오기
		int boardNo = Integer.parseInt(boardStr);
		BoardDto boardDto = boardDao.selectOne(boardNo);
		
		//[4] 비회원이거나 작성자랑 아이디랑 다르면
		if(boardDto == null || !boardDto.getBoardWriter().equals(loginId)) {
			throw new GetOutException();
		}
		
		return true;
	}
	
}

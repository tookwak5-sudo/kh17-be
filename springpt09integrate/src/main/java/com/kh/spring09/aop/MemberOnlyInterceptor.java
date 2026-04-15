package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//비회원의 접근을 차단하는 인터셉터
//비회원이란? HttpSession에 loginId와 loginLevel이 존재하지 않는 사용자 컨셉은 회원은 통과시키는데 비회원이란 장애물들을 제거하는 방식
@Service // 스프링에는 등록완료
public class MemberOnlyInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션이 어딨지? 컨트롤러에선 매개변수에 선언만 하면 주는데, 여긴 상속받았기 때문에 절대로 지켜야한다.
		//세션은 사실 사용자 정보(HttpServletRequest)에 숨어있기 때문에 꺼내서 사용해야 한다
		//스프링에선 자주 쓸거같은 HttpSession을 선언만 하면 이용할 수 있도록 컨트롤러에게 특혜를 준 것
		HttpSession session = request.getSession();
		
		String loginId = (String) session.getAttribute("loginId"); //아이디 추출
		String loginLevel = (String) session.getAttribute("memberLevel"); //등급 추출
		
		if(loginId == null || loginLevel == null) {
			return false; //차단 -> 차단하는 경우의 수가 적을 수록 코드가 쉬워짐!
		}
		
		return true; //통과
	}
	
}

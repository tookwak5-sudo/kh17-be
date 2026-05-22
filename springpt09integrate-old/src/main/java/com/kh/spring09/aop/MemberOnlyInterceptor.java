package com.kh.spring09.aop;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import com.kh.spring09.exception.WhoAreYouException;

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
		String loginLevel = (String) session.getAttribute("loginLevel"); //등급 추출
		
		if(loginId == null || loginLevel == null) {
			// 차단만 하면 사용자에게는 아무런 화면도 나오지 않으므로 플랜 B를 알려주고 차단시켜야 한다
			// 1. 다른 매핑으로 리다이렉트 (ex : 로그인 페이지) 
//			response.sendRedirect("/member/login"); // 정석적인 Java EE의 코드  리다이렉트 메세지를 보내고
			
			// 2. Http 상태메시지를 발송
			//response.sendError(401); // 미인증 상태코드 발송 spring이 구조적으로 400번때를 건드리기가 어려움 400번때는 spring의 어떤 도구에서도 처리하기 힘들기 때문
//			return false; //차단 -> 차단하는 경우의 수가 적을 수록 코드가 쉬워짐!  차단
			
			// 3. 예외로 처리
			throw new WhoAreYouException();
			
			//Controller였다면
			//return "redirect:/member/login"; // 이라 쓰면 되지만, 반환형이 boolean이라 차단과 통과만 알려줄 수 있음)
		}
		return true; //통과
	}
}

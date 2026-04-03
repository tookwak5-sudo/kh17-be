package com.kh.spring04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//메인페이지 및 최초 방문용 페이지들을 보관하는 컨트롤러
// [제 1규칙 : 제어반전, Inversion of Control] 스프링은 "등록"되지 않은건 도와주지 않는다
//등록은 @를 이용한 Annotation으로 설정한다
@RestController//바로 아래있는 녀석을 RestController로 등록해주세요!
public class HomeController {
	
	// 기본주소(http://localhost:8080) 빼고 /로 들어오면 이 메소드를 실행해서 나온거 보여줘	
	@RequestMapping("/") 	// 원래는 괄호안에 (value = "/")
	public String home() {
		return "컨트롤러 테스트!";
	}
	
	//똑같은 주소가 2개면 켜져있어도 켜진게 아니다 (에러)
//	@RequestMapping("/")
//	public String copy() {
//		return "같은주소지";
//	}
	
	//주소 외에도 ? 뒤에 있는 데이터를 받을 수 있다. (쿼리 파라미터라 부른다)
	//매개변수를 만들면 쿼리 파라미터가 있어야 된다는 뜻
	//Annotation을 이용해서 명확하게 의미설정이 가능 (@RequestParam)
	@RequestMapping("/test")
	public String test(@RequestParam int a, @RequestParam int b) {
		int c = a + b;
		return "테스트 결과 : " + c;
	}
	
}

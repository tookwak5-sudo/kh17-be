package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController // 기존의 등록(화면 없이 데이터를 전달해주겠어)
@Controller // new registor(화면 출력)
public class HomeController {
	@RequestMapping("/welcome")
	public String welcome() {
		//webapp뒤의 경로를 '/'부터 작성 (슬.래.쉬.부.터.!.) 
		return "/WEB-INF/views/welcome.jsp";
	}
}

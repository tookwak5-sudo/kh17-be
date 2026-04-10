package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//공용주소는 주지 않음
public class HomeController {
	//메인 페이지를 가장 짧은 주소로 만들려면?
	//아무것도 안쓰거나 "/" 아무것도 안써도 "/"임
	@RequestMapping("/")  
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
}

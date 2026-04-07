package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
	@RequestMapping("/test01")
	public String test01() {
		return "/WEB-INF/views/exam/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String test02() {
		return "/WEB-INF/views/exam/test02.jsp";	
	}
	
	@RequestMapping("/test03")
	public String test03() {
		return "/WEB-INF/views/exam/test03.jsp";
	}
}

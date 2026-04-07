package com.kh.spring08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {
	@RequestMapping("/test01")
	public String exam01() {
		return "/WEB-INF/views/exam/test01.jsp";
	}
	
	@RequestMapping("/test02")
	public String exam02() {
		return "/WEB-INF/views/exam/test02.jsp";	
	}
}

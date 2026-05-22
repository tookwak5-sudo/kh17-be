package com.kh.spring09.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/stat")
public class AdminStatController {
	@RequestMapping("/")
	public String home() {
		//return "/WEB-INF/views/admin/stat/home.jsp";
		return "admin/stat/home"; //ViewResolver적용후
	}
}

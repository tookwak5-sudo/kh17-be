package com.kh.spring11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 목표 :  /views/**를 /static/index.html로 전달(Forward)하기 위한 컨트롤러 <-> Redirect
@Controller
@RequestMapping("/views")
public class ReactForwardController {
	@GetMapping("/**")
	public String forward() {
		return "forward:/index.html";
	}
}

package com.kh.spring08.controller;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp")
public class JspController {
	//화면에 전달해야할 데이터가 있다면 모델(Model)을 매개변수에 선언하고 데이터 추가
	@RequestMapping("/test01")
	public String test01(Model model) {
		//model에 원하는 데이터를 "이름을 붙여서" 전달
		//model.attrubute("이름", 값); (String, Object) ?? 자바의 맵하고 유사
		model.addAttribute("message", "Hello MVC Pattern!");
		Random r = new Random();
		int dice = r.nextInt(6) + 1;
		model.addAttribute("dice", dice);
		int lotto = r.nextInt(45) + 1;
		model.addAttribute("lotto", lotto);
		return "/WEB-INF/views/jsp/test01.jsp";
	}

}

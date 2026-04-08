package com.kh.spring01;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@RequestMapping("/hello")
	public String hello() {
		return "welcome to Spring Boot!";
	}
	@RequestMapping("/hi")
	
	public String hi(){
		return "안녕하세요! 반갑습니다";
	}
}

package com.kh.spring10.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController //@Controller + @ResponseBody = @RestController 데이터만 반환하는 컨트롤러
public class HomeRestController {
	@RequestMapping("/")
	public String home() {
		return "Server is running...";
	}
}

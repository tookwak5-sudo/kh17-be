package com.kh.exam.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"com.kh.exam.controller"})
	
public class ErrorController {
	@ExceptionHandler(Exception.class)
	public String error(Exception e, Model model) {
		e.printStackTrace(); //오류 로그를 서버에 출력하고
		model.addAttribute("message", e.getMessage()); // 메세지 화면에 전달하고
		return "error/500";
	}
}

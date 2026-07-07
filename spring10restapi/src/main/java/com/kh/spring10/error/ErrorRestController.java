package com.kh.spring10.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(annotations = {RestController.class})
@RestControllerAdvice(basePackages = {"com.kh.spring10.controller"})
public class ErrorRestController {
	
	@ExceptionHandler(TargetNotfoundException.class)
	public ResponseEntity<String> notFound() {
//		return ResponseEntity.notFound().build();
		return ResponseEntity.status(404).build();
	}
}

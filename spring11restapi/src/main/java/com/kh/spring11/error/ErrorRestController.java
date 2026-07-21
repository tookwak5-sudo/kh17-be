package com.kh.spring11.error;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtValidationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice(annotations = {RestController.class})
@RestControllerAdvice(basePackages = {"com.kh.spring10.controller"})
public class ErrorRestController {
	
	@ExceptionHandler(JwtValidationException.class)
	public ResponseEntity<String> invalidJwtToken() {
		return ResponseEntity.status(401).body("not authorized");
	}
	
	@ExceptionHandler(TargetNotfoundException.class)
	public ResponseEntity<String> notFound() {
//		return ResponseEntity.notFound().build();
		return ResponseEntity.status(404).body("Target not found");
	}
}

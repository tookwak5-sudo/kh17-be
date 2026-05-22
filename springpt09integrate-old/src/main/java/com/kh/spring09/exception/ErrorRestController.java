package com.kh.spring09.exception;

import org.springframework.core.Ordered;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


// 예외만 전담하여 처리하는 도구

//@RestControllerAdvice(annotations = {RestController.class})

@RestControllerAdvice(basePackages = {"com.kh.spring09.restcontroller"})
//@Order(Ordered.HIGHEST_PRECEDENCE) //가장 높은 우선순위 부여
public class ErrorRestController {
	
	//컨트롤러에서 예외가 생기면 그 예외에 대한 처리를 수행하는 매핑
	@ExceptionHandler(Exception.class)
	//public String error(Exception e, Model model) { //model은 jsp전달하는 녀석 필요없음
	public ResponseEntity<String> error(Exception e) {
		e.printStackTrace(); //오류 로그를 서버에 출력하고
		return ResponseEntity.status(500).build();
	}
	
	@ExceptionHandler(TargetNotfoundException.class)
	public ResponseEntity<String> notFound(Exception e) {
		return ResponseEntity.status(404).build(); //상태메세지
//		return ResponseEntity.notFound().build(); // 상태코드
	}
	@ExceptionHandler(WhoAreYouException.class)
	public ResponseEntity<String> unauthorize(Exception e) {
		return ResponseEntity.status(401).build(); //상태메세지
		
	}
	@ExceptionHandler(GetOutException.class)
	public ResponseEntity<String> forbidden(Exception e) {
		return ResponseEntity.status(403).build(); //상태메세지
	}
}

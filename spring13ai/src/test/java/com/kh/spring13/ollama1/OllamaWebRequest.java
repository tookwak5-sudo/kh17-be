package com.kh.spring13.ollama1;

//레코드(record) 
//- 기본 클래스(DTO 형태)를 최소한의 코드로 만들 수 있도록 개발된 클래스
//- 실무 사용은 조심할 것(안쓰는 경우가 99.9999%)
//- 커스텀은 어렵지만 기본형을 가장 빠르게 구현할 수 있음
public record OllamaWebRequest (
	String model,
	String prompt,
	boolean stream
) {
	
}

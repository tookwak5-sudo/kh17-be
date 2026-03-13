package oop.inherit3;

//서브클래스(하위클래스)
//-extends 키워드를 통해 상위클래스 1개 선택
public class ChromeBrowser extends Browser {
	//추가되느 내용만 구현
	public void develop() {
		System.out.println("개발자도구 기능 실행");
	}
	public void chromeStore() {
		System.out.println("크롬상점 기능 실행");
	}
}

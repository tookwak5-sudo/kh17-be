package io;

import java.util.Scanner;

public class Test02표준입력 {
	public static void main(String[] args) {
		//표준 입력
		// - 표준 입력 통로(System.in)를 사용하여 키보드로 입력한 글자를 전달받는 작업
		// - 프로그램은 필요에 따라 사용자에게 문자열, 정수, 실수 등을 입력하도록 요구할 수 있다.
		// - 기계적인 구조보다 데이터 관점에서 처리하기 우해 보조도구(Scanner)를 사용
		
		// - 보조 도구 생성 (import 필요, ctrl + shift + o)
		// - 참조형 데이터이며 Scanner가 형태이고 sc가 리모컨 이름
		// - new 오른쪽에 있는걸 새로 만들라는 의미(동적할당 연산자)
		Scanner sc = new Scanner(System.in); 
		
		//입력은 sc를 이용하여 원하는 데이터를 받을 수 있는 명령을 실행한다.
		// - 정수 : sc.nextInt(), sc.nextLong()
		// - 실수 : sc.nextFloat(), sc.nextDouble()
		// - 논리 : sc.nextBoolean()
		// - 문자열 : sc.next()
		
		System.out.println("숫자 한 개를 입력하세요"); // 1. 안내문
		int number = sc.nextInt(); 								// 2. 정수 입력
		System.out.println("입력하신 숫자는" + number + "입니다."); // 3. 결과 멘트 출력
		
		System.out.println("숫자 한 개를 입력하세용");
		float number2 = sc.nextFloat();
		System.out.println("입력하신 숫자는" + number2 + "입니다."); //f는 개발자에게만 필요한 것, 바깥에서 입력할 때는 필요하지 않다.
	}
}	

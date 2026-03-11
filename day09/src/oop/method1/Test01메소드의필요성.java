package oop.method1;

public class Test01메소드의필요성 {
	public static void main(String[] args) {
		//객체 : 의미있는 묶음
		//객체 생성
		Student a = new Student();
		Student b = new Student();
		
		//객체 초기화
		a.init("홍길동", 70); // a를 주인공으로 해서 init에 저장된 코드를 실행하며 "홍길동", 70을 순서대로 넘겨라
		b.init("장보고", 100);// b를 주인공으로 해서 init에 저장된 코드를 실행하며 "장보고", 100을 순서대로 넘겨라
		
		
		//객체 정보 출력
		//-a를 주인공으로 해서 show에 저장된 코드를 실행해라!
		a.show();
		//-b를 주인공으로 해서 show에 저장된 코드를 실행해라!
		b.show();
	
	}
}

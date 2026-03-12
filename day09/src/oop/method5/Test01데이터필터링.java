package oop.method5;

public class Test01데이터필터링 {
	public static void main(String[] args) {
		Student a = new Student();
		
		a.init("테스트", -50, 160, 70);
		a.show();
		
	//	a.korean = 50; //차단 불가
		a.setKorean(-40);
	// 문제 1 : 값을 하나만 바꾸기가 어렵다.
	//	a.init("테스트", -50, -60, 70);
	// 문제 2 : 값에 조건을 걸기가 어렵다.
		a.show();
	}
}
			
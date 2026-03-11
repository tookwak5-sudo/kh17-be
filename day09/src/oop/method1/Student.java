package oop.method1;

public class Student {
	//멤버 필드(변수) : 데이터 저장
	String name;
	int score;
	
	//멤버 메소드 : 자주 쓰는 코드를 저장
	// - 기본모양 : void 이름(준비물) {코드}
	// - this : 주인공(여기에 들어오게 되는 리모컨은)
	void init(String name, int score) { // 정보설정하는 메소드
		this.name = name;
		this.score = score;
	}
	void show() { // 정보를 출력하는 메소드
		System.out.println("<학생 정보>");
		System.out.println("이름 : " + this.name);
		System.out.println("점수 : " + this.score + "점");
		System.out.println("-----------------------");
	}
}

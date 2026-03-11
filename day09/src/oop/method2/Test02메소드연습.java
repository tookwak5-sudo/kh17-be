package oop.method2;

public class Test02메소드연습 {
	public static void main(String[] args) {
		//객체 생성
		Olympics p1 = new Olympics();
		Olympics p2 = new Olympics();
		Olympics p3 = new Olympics();
		
		//객체정보 초기화
		p1.init(1, "미국", 40, 44, 42);
		p2.init(2, "중국", 40, 27, 24);
		p3.init(3, "일본", 20, 12, 13);
		
		//객체정보 출력
		p1.show();
		p2.show();
		p3.show();
	}
}

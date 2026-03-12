package oop.constructor2;

public class Test01생성자연습 {
	public static void main(String[] args) {
		UserInfo p1 = new UserInfo("테스트유저1", "전사", 1000000, 88);
		UserInfo p2 = new UserInfo("테스트유저2", "마법사", 500000, 40);
		UserInfo p3 = new UserInfo("테스트유저3", "궁수", 0, 1);
		
//		p1.init("테스트유저1", "전사", 1000000, 88);
//		p2.init("테스트유저2", "마법사", 500000, 50);
//		p3.init("테스트유저3", "궁수", 1, 0);
		
		p1.show();
		p2.show();
		p3.show();
		
	}
}

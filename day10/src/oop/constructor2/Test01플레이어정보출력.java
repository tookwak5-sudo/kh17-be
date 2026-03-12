package oop.constructor2;

public class Test01플레이어정보출력 {
	public static void main(String[] args) {
		Player p1 = new Player("테스트유저1", "전사", 1000000L, 88);
		Player p2 = new Player("테스트유저2", "마법사", 500000L, 40);
	//	Player p3 = new Player("테스트유저3", "궁수", 0);
		Player p3 = new Player("테스트유저3", "궁수", 0, 1);
		
//		p1.init("테스트유저1", "전사", 1000000, 88);
//		p2.init("테스트유저2", "마법사", 500000, 50);
//		p3.init("테스트유저3", "궁수", 1, 0);
		
		p1.show();
		p2.show();
		p3.show();
		
	}
}

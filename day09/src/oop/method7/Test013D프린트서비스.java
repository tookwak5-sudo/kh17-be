package oop.method7;

public class Test013D프린트서비스 {
	public static void main(String[] args) {
		//객체(인스턴스) 생성
		PrintService2 a = new PrintService2();
		PrintService2 b = new PrintService2();
		PrintService2 c = new PrintService2();
		PrintService2 d = new PrintService2();
		
		//객체 초기화
		a.init("고강도 PLA 필라멘트", "재품", 24, 25000, "일반");
		b.init("노즐 세트", "소모품", 48, 15000, "퀵");
		c.init("출력물 전용 베드", "부품", 72, 45000, "일반");
		d.init("맞춤형 출력물 제작", "출력", 120, 100000, "방문수령");
		// 출력
		a.show();
		b.show();
		c.show();
		d.show();
	}
}

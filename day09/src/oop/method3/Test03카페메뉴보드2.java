package oop.method3;

public class Test03카페메뉴보드2 {
	public static void main(String[] args) {
		//객체 생성
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		Product p4 = new Product();
		
		//객체 초기화
		p1.init("음료", "아메리카노", 2500, true); // 행사중
		p2.init("음료", "고구마라떼", 3000); // 언급하지 않으면 행사중이 아님
		p3.init("디저트", "티라미수", 4000, true); // 행사중
		p4.init("디저트", "마카롱", 2000); // 언급하지 않으면 행사중이 아님
		
		//객체 출력
		p1.show();
		p2.show();
		p3.show();
		p4.show();
	}
}

package oop.method3;

public class Product {
	//멤버 필드(변수) : 데이터
	String category;
	String menu;
	int price;
	boolean sale;
	
	//멤버 메소드 : 기능(코드)
	
	//* 같은 메소드를 다양한 형태로 만들어서 이용을 편하게 만들 수 있다. -> 메소드 오버로딩(method overloading
	            //매개변수 (argument variable)
	void init(String category, String menu,int price) {
		this.category = category;
		this.menu = menu;
		this.price = price;
		//this.event = false; --> 초기값이 false지만 헷갈리지 않기 위해 주석으로라도 표시해주기
	}
	void init(String category, String menu, int price, boolean sale) {
		this.category = category;
		this.menu = menu;
		this.price = price;
		this.sale = sale;
	}
	
	// 할인은 원가를 깎은 것이 아니기 때문에 출력(show)에서 계산을 해줘야함
	void show() {
		System.out.println("카테고리 : " + this.category);
		System.out.print("메뉴 명 : " + this.menu);
		if(this.sale) {
			int discount = this.price * 10 / 100;
			int resultPrice  = this.price - discount;
			System.out.print(" (행사상품)");
			System.out.println();
			System.out.println("가격 : " + resultPrice + "원 (" + this.price + "원, " + discount + "% 할인)");
		}
		else {
			System.out.print("메뉴 명 : " + this.menu);
			System.out.println("가격 : " + this.price + "원");
		}
		System.out.println("---------------");
	}
}

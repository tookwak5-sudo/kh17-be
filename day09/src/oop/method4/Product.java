package oop.method4;

public class Product { // or Item도 괜찮아 보임
	//멤버 필드
	String name;
	String category; //type
	int price;
	int count; // or stock
	int discount;
	boolean dawnDelivery;
	
	//멤버 메소드
	// 오버로딩은 이름은 같되 매개변수의 개수 or 순서 or 형태 등이 달라서 구분이 가능해야 성립함

	void init(String name, String category, int price, int count) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.count = count;
		this.discount = 0;
		this.dawnDelivery = false;
	}
	void init(String name, String category, int price, int count, boolean dawnDelivery) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.count = count;
		this.discount = 0;
		this.dawnDelivery = dawnDelivery;
	}
	void init(String name, String category, int price, int count, int discount) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.count = count;
		this.discount = discount;
		this.dawnDelivery = false;
	}
	void init(String name, String category, int price, int count, int discount, boolean dawnDelivery) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.count = count;
		this.discount = discount;
		this.dawnDelivery = dawnDelivery;
	}
	
	void show() {
		System.out.println("<상품정보>");
		System.out.println("상품명 : " +this.name);
		System.out.println("분류 : " + this.category);
		if(this.discount == 0) {
			System.out.println("가격 : " + this.price + "원");
		}
		else {
			int rate = this.price * this.discount / 100;
			int realPrice = price - rate;
			System.out.println("가격 : " + realPrice + "원 (원래 " + this.price + "원)");
		}
		if(count > 0) {
			System.out.println("재고 : " + this.count);
		}
		else {
			System.out.println("재고없음");
		}
		if(dawnDelivery) {
			System.out.println("새벽배송 여부 : Y");
		}
		System.out.println("------------------");
	}
}


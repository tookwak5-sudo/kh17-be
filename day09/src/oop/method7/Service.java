package oop.method7;

public class Service {
	//멤버 필드(변수)
	String name;
	String category;
	int duration;
	int price;
	String deliveryType;
	
	//세타메소드
	void setName(String name) {
		this.name = name;
	}
	void setCategory(String category) {
		switch(category) {
		//case "재료": case "소모품": case "부품": case "출력":
		case "재료", "소모품", "부품", "출력":
		this.category = category;
		}
	}
	void setDuration(int duration) { // 24시간 단위로만 설정가능
		if(duration < 24) return;
		if(duration % 24 != 0) return;
		this.duration = duration;
	}
	void setPrice(int price) { //가격은 1천원단위 100원 단위는 자동으로 빠짐
		//if(price % 1000 !=0) return;
		this.price =price / 1000 * 1000;
	}
	void setDeliveryType(String deliveryType) {
		switch(deliveryType) {
		case "일반", "퀵", "방문수령":
			this.deliveryType = deliveryType;
		
		}
	}
	
	//일반 메소드
	void init(String name, String category, int duration, int price, String deliveryType) {
		this.setName(name);
		this.setCategory(category);
		this.setDuration(duration);
		this.setPrice(price);
		this.setDeliveryType(deliveryType);
	}
	
	//출력 메소드
	void show() {
		System.out.println("<서비스 목록>");
		System.out.println("부품명 : " + this.name);
		System.out.println("카테고리 : " + this.category);
		System.out.println("제작 소요기간 : " + this.duration + "H");
		System.out.println("단가 : " + this.price + "원");
		System.out.println("배송방식 : " + this.deliveryType);
		System.out.println("--------------------");
	}
}

package oop.method6;

public class Lecture {
	//멤버 필드
	String title;
	String category;
	int duration;
	int price;
	String type;
	
	//세터 메소드
	void setTitle(String title) {
		this.title = title;
	}
	void setCategory(String category) { //이론 실습 시험 3가지중 하나
		switch(category) {
		case "이론": case "실습" : case "시험":
			this.category = category;
		}
	}
	void setDuration(int duration) { //30시간 간격으로 설정가능
		if(duration < 0) return;
		if(duration % 30 != 0) return; 
		this.duration = duration;
	}
	void setPrice(int price) {
		if(price < 0) return;
		if(price % 1000 != 0) return;
		this.price = price;
	}
	void setType(String type) {
		switch(type) {
		case "온라인": case "오프라인" : case "혼합":
			this.type = type;
		}
	}
	
	// 일반 메소드
	void init(String title, String category, int duration, int price) {
		this.init(title, category, duration, price, "오프라인");
	}
	void init(String title, String category, int duration, int price, String type) {
		//this.title = title;
		this.setTitle(title);
		this.setCategory(category);
		this.setDuration(duration);
		this.setPrice(price);
		this.setType(type);
	}
	
	//출력
	void show() {
		System.out.println("<강의정보>");
		System.out.println("강좌명 : " + this.title);
		System.out.println("카테고리 : " + this.category);
		System.out.println("강의시간 : " + this.duration);
		System.out.println("수강료 : " + this.price);
		System.out.println("수업형태 : " + this.type);
	}
}

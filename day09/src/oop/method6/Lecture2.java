package oop.method6;

//온라인강좌 클래스
public class Lecture2 {
	//멤버 필드
	String name; // title
	String category;
	int time; //duration
	int fee; // price
	String type;
	
	//세터 메소드 필드와 동일한 개수 5개 생성 
	//-> 멤버 메소드에 속하지만 엄격히 따지자면 멤버 필드에 의해 생긴 것이기 때문에 필드에 가까운 메소드라 생각
	void setName(String name) {
		this.name = name;
	}
	void setCategory(String category) {
		switch(category) {
		case "이론", "실습", "시험":
			this.category = category;
		}
	}
	void setTime(int time) {
		int timeRule = this.time % 30;
		if(time < 0) return;
		if(timeRule != 0) return;
		this.time = time;
	}
	void setFee(int fee) { //천원단위로만 설정가능
		if(fee < 0) return;
		if(fee % 1000 != 0) return;
		this.fee = fee;
	}
	void setType(String type) {
		switch(type) {
		case "온라인", "오프라인", "혼합":
			this.type = type;
		}
	}
	// -일반메소드
	void init(String name, String category, int time, int fee) {
		this.init(name, category, time, fee, "오프라인");
		
	}
	
	void init(String name, String category, int time, int fee, String type) {
		this.setName(name);
		this.setCategory(category);
		this.setTime(time);
		this.setFee(fee);
		this.setType(type);
	}
	
	void show() {
		System.out.println("<강의 정보>");
		System.out.println("강좌명 : " + this.name);
		System.out.println("카테고리 : " + this.category);
		System.out.println("강의시간 : " + this.time + "H");
		System.out.println("수강료 : " + this.fee + "KRW");
		System.out.println("강의유형 : " + this.type);
	}
}

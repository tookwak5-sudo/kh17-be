package oop.inherit2;

//슈퍼클래스(상위클래스)
//-목적: 비슷한 클래스들의 공통점을 보관하기 위한 클래스
//- 객체 생성이 목적이 아님
public class Phone {
	//휴대폰이라면 가져야 할 공통 필드
	private String color; // 기기 색상
	private String number; // 전화번호
	
	//휴대폰이라면 가져야 할 공통 메소드
	public void call() {
		System.out.println("전화 걸기");
	}
	public void camera() {
		System.out.println("사진 촬영");
	}
	public void sms() {
		System.out.println("문자메세지 전송");
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}

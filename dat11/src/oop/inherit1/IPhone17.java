package oop.inherit1;

//아이폰 17 휴대폰 클래스
public class IPhone17 {
	//멤버필드
	private String color; // 기기 색상
	private String number; // 전화번호
	
	//멤버메소드
	public void call() {
		System.out.println("전화 걸기");
	}
	public void camera() {
		System.out.println("사진 촬영");
	}
	public void sms() {
		System.out.println("문자메세지 전송");
	}
	public void applePay() {
		System.out.println("애플페이 결제");
	}
}

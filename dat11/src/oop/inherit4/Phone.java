package oop.inherit4;

//super class
// - 하위 클래스에서 내 기능들을 어떻게 이용할 것인가를 고민
public class Phone {
	//- 필드 : 접근제한이 두 종류로 나눠짐
	//- private : 이 클래스에서 설정 및 반환을 모두 통제하려 할 경우 사용(절대규칙)
	//-protected : 향후 상속받는 하위클래스에서 자유롭게 접근하여 원하는 형태로 사용 가능
	//private String number
	protected String number;
	protected String color;

	//setter getter는 이곳에 만듦
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
	//메소드
	//- 재정의(Override) 여부를 고려해야함
	//- 금지 시키고 싶으면 final 키워드 추가
	//public final void pay() {
	public void pay() {
		System.out.println("결제 기능");
	}
	
	//생성자
	//반드시 설정될 필드를 지정
	//생성자를 만드는 순간 하위클래스도 동일하게 만들어줘야함
	public Phone(String color) {
		this.color = color;
	}
	public Phone(String color, String number) {
		this.color = color;
		this.number = number;
	}
}

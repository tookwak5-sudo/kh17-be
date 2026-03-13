package oop.inherit4;

//sub class(기존에 우리가 만들던 클래스)
// - 객체를 만들어서 어떤 기능을 이용하게 할 것인가를 고민
public class GalaxyS26 extends Phone {
	//상속받은 메소드를 재정의(Override)
	//- 완전히 똑같게 만들어야함
	public void pay() {
		System.out.println("삼성페이 기능");
	}

	public GalaxyS26(String color, String number) {
		super(color, number);
	}

	public GalaxyS26(String color) {
		super(color);
	}
	
	
}

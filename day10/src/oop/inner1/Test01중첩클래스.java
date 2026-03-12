package oop.inner1;

public class Test01중첩클래스 {
	public static void main(String[] args) {
		Police p = new Police();
		
		p.setName("포돌이");
		
		Gun g = new Gun();
		p.setGun(g);
	}
}

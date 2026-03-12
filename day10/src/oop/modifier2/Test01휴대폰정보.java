package oop.modifier2;

public class Test01휴대폰정보 {
	public static void main(String[] args) {
		Phone2 p1 = new Phone2();
		Phone2 p2 = new Phone2();
		Phone2 p3 = new Phone2();
		Phone2 p4 = new Phone2();
		
		p1.init("갤럭시 S26", 256, "SKT", 1797400, 24);
		p2.init("iPhone 17 Pro", 128, "KT", 1555000, 24);
		p3.init("갤럭시 S26 Ultra", 256, "LG", 1254000, 0);
		p4.init("iPhone 17", 256, "알뜰폰", 1200000, 36);
		
		p1.show();
		p2.show();
		p3.show();
		p4.show();
		
	}
}

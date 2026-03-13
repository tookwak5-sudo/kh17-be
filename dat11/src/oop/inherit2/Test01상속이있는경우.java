package oop.inherit2;

public class Test01상속이있는경우 {
	public static void main(String[] args) {
		GalaxyS26 p1 = new GalaxyS26();
		
		p1.call();
		p1.camera();
		p1.sms();
		p1.samsungPay();
		
		IPhone17 p2 = new IPhone17();
		
		p2.call();
		p2.camera();
		p2.sms();
		p2.applePay();
	}
}

package oop.inherit7;

public class Test01추상클래스연습 {
	public static void main(String[] args) {
		//일반 클래스로 상위클래스를 구현하면 객체 생성이 된다
		//추상 클래스는 객체 생성이 불가능하다 // ++추신 일회용 상속이 따로 있긴함
		//Camera c = new Camera("테스트 카메라", 200000);
		
		DSLRCamera c1 = new DSLRCamera("캐논DSLR 카메라", 1000000);
		c1.show();
		c1.on();
		c1.zoom();
		c1.takePhoto();
		c1.off();
		ActionCamera c2 = new ActionCamera("Action", 3000000);
		c2.show();
		c2.on();
		c2.zoom();
		c2.takePhoto();
		c2.off();
		DroneCamera c3 = new DroneCamera("DJI드론캠", 50000000);
		c3.show();
		c3.on();
		c3.zoom();
		c3.takePhoto();
		c3.off();
	}
}

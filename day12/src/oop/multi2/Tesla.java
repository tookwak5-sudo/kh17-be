package oop.multi2;

public class Tesla extends Vehicle implements Chargable, Autonomous {

	public Tesla(String name) {
		super(name);
	}
	@Override
	public void charge() {
		System.out.println("테슬라 충전 기능");
	}
	@Override
	public void autoDrive() {
		System.out.println("테슬라 자동 주행 기능 사용가능");
	}
	@Override
	public void autoParking() {
		System.out.println("테슬라 자동 주차 기능 사용가능");
	}
	@Override
	public void move() {
		System.out.println("테슬라 주행 시작");
	}
	@Override
	public void startEngine() {
		System.out.println("테슬라 시동 on");
	}
	@Override
	public void stopEngine() {
		System.out.println("테슬라 시동 off");
	}
}

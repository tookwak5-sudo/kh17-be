package oop.multi2;

public class Drone extends Vehicle implements Chargable, Flyable, Autonomous{

	public Drone(String name) {
		super(name);
	}

	@Override
	public void autoDrive() {
		System.out.println("자동 주행 기능 사용가능");
	}

	@Override
	public void autoParking() {
		System.out.println("드론 자동 주차 기능 사용가능");
	}

	@Override
	public void fly() {
		System.out.println("드론 비행가능");
	}

	@Override
	public void charge() {
		System.out.println("드론 충전 기능");
	}

	public void move() {
	//	System.out.println("주행 시작");
		this.fly();
	}
	@Override
	public void startEngine() {
		System.out.println("드론 시동 on");
	}
	@Override
	public void stopEngine() {
		System.out.println("드론 시동 off");
	}

}

package oop.multi2;

public class TankerShip extends Vehicle implements Refuelable, Sailable, Autonomous{

	public TankerShip(String name) {
		super(name);
	}

	@Override
	public void autoDrive() {
		System.out.println("대형 유조선 자동 주행 기능 사용가능");
	}

	@Override
	public void autoParking() {
		System.out.println("대형 유조선 자동 주차 기능 사용가능");
	}

	@Override
	public void sail() {
		System.out.println("대형 유조선 항해가능");
	}

	@Override
	public void refuel() {
		System.out.println("대형 유조선 급유가능");
	}

	public void move() {
		System.out.println("대형 유조선 주행 시작");
	}
	@Override
	public void startEngine() {
		System.out.println("대형 유조선 시동 on");
	}
	@Override
	public void stopEngine() {
		System.out.println("대형 유조선 시동 off");
	}

}

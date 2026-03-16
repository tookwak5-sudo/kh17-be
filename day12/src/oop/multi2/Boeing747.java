package oop.multi2;

public class Boeing747 extends Vehicle implements Refuelable, Flyable{

	public Boeing747(String name) {
		super(name);
	}
	@Override
	public void fly() {
		System.out.println("보잉747 비행가능");
	}
	@Override
	public void refuel() {
		System.out.println("보잉747 급유가능");
	}
	public void move() {
		System.out.println("보잉747 이동 시작");
	}
	@Override
	public void startEngine() {
		System.out.println("보잉747 시동 on");
	}
	@Override
	public void stopEngine() {
		System.out.println("보잉747 시동 off");
	}
}

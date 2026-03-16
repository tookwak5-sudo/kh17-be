package oop.multi2;

public class JetSki extends Vehicle implements Sailable, Refuelable{

	public JetSki(String name) {
		super(name);
	}

	@Override
	public void refuel() {
		System.out.println("제트스키 급유가능");
	}

	@Override
	public void sail() {
		System.out.println("제트스키 항해가능");
	}

	public void move() {
		//System.out.println("주행 시작");
		this.sail();
	}
	@Override
	public void startEngine() {
		System.out.println("제트스키 시동 on");
	}
	@Override
	public void stopEngine() {
		System.out.println("제트스키 시동 off");
	}
	
}

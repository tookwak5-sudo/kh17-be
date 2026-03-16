package oop.multi2;

public abstract class Vehicle {
	
	private String name; //프로텍트도 가능
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//생성자
	public Vehicle(String name) {
		this.setName(name);
	}
	
	// 추상메소드
	public abstract void move();
	public abstract void startEngine();
	public abstract void stopEngine();
}

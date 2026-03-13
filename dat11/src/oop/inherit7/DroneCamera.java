package oop.inherit7;

public class DroneCamera extends Camera {

	public DroneCamera(String name, int resolution) {
		super(name, resolution);
	}

	@Override
	public void on() {
		System.out.println("Drone로고가 나오며 전원 켜짐");
	}

	@Override
	public void off() {
		System.out.println("Drone로고가 나오며 전원 꺼짐");
	}

	@Override
	public void takePhoto() {
		System.out.println("항공촬영을 시작합니다.");		
	}

	@Override
	public void zoom() {
		System.out.println("가까이 이동해서 촬영합니다.");		
	}
	
}

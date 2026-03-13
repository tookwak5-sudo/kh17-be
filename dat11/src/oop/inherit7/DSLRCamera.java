package oop.inherit7;

public class DSLRCamera extends Camera {
	
	public DSLRCamera(String name, int resolution) {
		super(name, resolution);
	}
	@Override
	public void on() {
		System.out.println("DSLR로고가 나오며 전원 켜짐");
	}
	@Override
	public void off() {
		System.out.println("DSLR로고가 나오며 전원 꺼짐");
	}
	@Override
	public void takePhoto() {
		System.out.println("고화질 사진 촬영을 시작합니다.");
	}
	@Override
	public void zoom() {
		System.out.println("광학 줌을 조절합니다.");
	}
}

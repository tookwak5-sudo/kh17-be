package oop.inherit7;

public class ActionCamera extends Camera{

	public ActionCamera(String name, int resolution) {
		super(name, resolution);
	}
	@Override
	public void on() {
		System.out.println("Action로고가 나오며 전원 켜짐");
	}
	@Override
	public void off() {
		System.out.println("Action로고가 나오며 전원 꺼짐");
	}
	@Override
	public void takePhoto() {
		System.out.println("액션캠 촬영을 시작합니다.");
	}
	@Override
	public void zoom() {
		System.out.println("떨림을 방지하며 확대를 시작합니다.");
	}
}

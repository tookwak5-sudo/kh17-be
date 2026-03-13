package oop.inherit6;

public class GalaxyS26 extends Phone{

	@Override
	public void on() {
		System.out.println("삼성 로고 나오며 전원 켜짐");
	}

	@Override
	public void off() {
		System.out.println("삼성 로고가 나오며 전원 꺼짐");
	}

	@Override
	public void call() {
		System.out.println("갤럭시 음성통화 실행");
	}

}

package oop.poly3;

public class MacBook extends NoteBook {

	@Override
	public void power() {
		System.out.println("맥북의 파워 기능을 실행");
	}

	@Override
	public void video() {
		System.out.println("맥북의 비디오 기능을 실행");
	}

	@Override
	public void typing() {
		System.out.println("맥북의 타이핑 기능을 실행");
	}

}

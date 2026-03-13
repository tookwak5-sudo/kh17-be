package oop.inherit6;
// 생성을 위한 클래스 : 일반적인 클래스
// - 추상메소드를 상속받는다면 반.드.시. 재정의를 해야한다.
public class IPhone17 extends Phone{

	@Override
	public void on() {
		System.out.println("사과 로고 나오며 켜짐");
	}
	@Override
	public void off() {
		System.out.println("사과 로고 나오며 꺼짐");
	}
	@Override
	public void call() {
		System.out.println("아이폰 음성통화 실행");
	}

}

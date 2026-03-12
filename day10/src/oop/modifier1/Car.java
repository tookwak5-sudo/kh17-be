package oop.modifier1;

//클래스를 더 안전하게 만들기 위해 접근 제한 개념 추가
// - 
// - private :  class 외부에서 접근을 금지(내부는 가능)
// - 미표시 : 패키지 외부에서 접근을 금지 (내부는 가능)
// - public : 어디서든 접근이 가능
public class Car {
	// 이제부터 필드는 잠금 처리를 한다.
	// - 필드를 이상한 값으로 설정하는 걸 막기 위해서
	private String name;
	private int speed;
	
	// 잠겨있는 필드들을 접근하기 위해 setter + getter 필요
	public void setName(String name) {
		this.name = name;
	}
	public void setSpeed(int speed) {
		if(speed < 0) return;
		this.speed = speed;
	}
	public String getName() {
		return this.name;
	}
	public int getSpeed() {
		return this.speed;
	}
}

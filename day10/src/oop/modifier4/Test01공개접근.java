package oop.modifier4;

import oop.modifier1.Car;

public class Test01공개접근 {
	public static void main(String[] args) {
		//(Q)다른 패키지에 있는 클래스도 여기서 풀 수 있을까?
		
		//oop.modifier1 패키지에 있는 Car 클래스의 객체를 생성
		// - 직접 전체 경로를 알려주며 사용
		//		oop.modifier1.Car c = new oop.modifier1.Car();
		// - import로 경로를 미리 준비시켜 사용
		
		//oop.modifier1.Car c = new oop.modifier1.Car();
		Car c = new Car();
		c.setName("소나타");
	}
}

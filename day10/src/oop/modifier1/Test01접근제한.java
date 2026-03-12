package oop.modifier1;

public class Test01접근제한 {
	public static void main(String[] args) {
		Car a = new Car();
			
		// 차단됨 a.speed = -1000;
		a.setSpeed(500);
		
		//Systempou.println(a.speed); // 차단됨
		System.out.println(a.getSpeed());
	}
}

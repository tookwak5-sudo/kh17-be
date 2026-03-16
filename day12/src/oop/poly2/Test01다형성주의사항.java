package oop.poly2;

public class Test01다형성주의사항 {
	public static void main(String[] args) {
		//Person을 만들어서 Teacher로 업캐스팅하고 차이점 분석
		//= Teacher로 업캐스팅한다 = 출근
		
		Person p = new Person();
		p.drink();
		p.sing();
		p.explain();
		p.exam();
		
		//보관 형태를 변경(Person -> Teacher, 업캐스팅)
		Teacher t = p; // 리모컨을 리모컨에 옮겨 담는다.
//		t.drink(); // 있지만 접근이 불가능해서 사용이 불가능하다
//		t.sing(); // 있지만 접근이 불가능해서 사용이 불가능하다
		t.explain();
		t.exam();
	}
}

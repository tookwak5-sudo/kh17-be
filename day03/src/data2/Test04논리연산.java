package data2;

public class Test04논리연산 {
	public static void main(String[] args) {
		//논리 하나만으로는 무언가 판단하기에는 부족한 경우가 많다.
		// - (예) 청소년? 14세 이상 19세 이하
		
		int age = 13;
		// 14<= age <= 19; 이건 안됨 
		// why?  한 번에 계산이 안됨 // python같은 최신 언어는 가능 java는 안됨
		boolean teen = (age >=14) && (age <= 19); // 자바 방식 (AND) 연산
		System.out.println(teen); // 13세면 앞에 가 F 뒤에가 T가 나오기 때문에 // 반드시 근거가 있어야함
		
		// -(예) 무임승차 65세 이상 / 7세 이하
		
		boolean free = (age >= 65) || (age <= 7);
		System.out.println(free);
	}
}

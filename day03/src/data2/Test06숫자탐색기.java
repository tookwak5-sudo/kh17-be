package data2;

// 1부터 '99'사이의 어떤 숫자 한 개를 'number'라는 이름의 변수에 저장해두고 이 숫자에 '7'이 
// 포함되어 있는지 판정하여 출력하는 프로그램을 구현하세요

public class Test06숫자탐색기 {
	public static void main(String[] args) {
		/*
		// 7이 포함되어 있는지 판정여부
		//입력
		int number = 57;
		//처리
		boolean include7 = (number / 10 == 7) || (number % 10 == 7);
		//출력
		System.out.println(include7); // 7이 포함된 숫자
		*/
		
		// 범위를 제한하는 이유 풀이가 쉬워진다.
		
		//and: 논리 곱 ;     or: 논리 합
		
		// 1의 자리 7  number % 10 == 7
		// 10의 자리 7 (number / 10 == 7)  or (number >= 70 && number <80)  
		
		// 입력
		int number = 71;
		
		// 처리
		int ten = number / 10;  // number의 10의 자리
		int one = number % 10; // number의 1의 자리
		//System.out.println(ten);
		//System.out.println(one);
		
		boolean seven = ten ==7 || one == 7;
		//boolean seven = number / 10 == 7 || number % 10 == 7;
		
		//출력
		System.out.println(seven);
	}
}
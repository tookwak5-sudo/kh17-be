package data2;

public class Test03배수판정 {
	public static void main(String[] args) {
		//배수 판정?
		// - 2의 배수, 3의 배수, 4의 배수...
		// - 나머지 연산으로 판정
		
		int number = 6;
		
		boolean even = number%2 == 0; // 2의 배수 판정식
		
		System.out.println(even);
		
		boolean three = number % 3 == 0; // 3의 배수 판정식
		System.out.println(three);
		
		boolean four = number % 4 == 0; // 4의 배수 판정식
		System.out.println(four);
		
		// 홀수 판정식
		//boolean odd = number % 2 != 0;
		//boolean odd = number % 2 == 1;
		boolean odd = !even; // even이 true인 경우의 반대면 홀수 !(느낌표가 앞에 붙으면 반대, 부정의 의미)
		System.out.println(odd);
	}
}

package data;

public class Test04여러가지숫자 {
		public static void main(String[] args) {
			//정수 : 소수점이 없는 수
			
			// - int는 약 42억개의 숫자 표현 (-21억~21억)
			int a = 2100000000;
			System.out.println(a);
			
			// - long은 약 1800경개의 숫자 표현 (-922경~ 922경)
			//int b = 10000000000; //안들어 가면 더 큰거
			long b = 10000000000L; // 더 큰 변수에 대입
			System.out.println(b);
			
			
			//실수 : 소수점이 있는 수
			float c = 1.2345678901234567890123456789F;
			double d = 1d;
			
			System.out.println(c);
			System.out.println(d);
			
			//정수의 특징
			// - 정수끼리 계산하면 정수가 나온다. (특히 나눗셈)
			
			System.out.println(10 / 3);  // 몫을 구하는 기호
			System.out.println(10 % 3); // 나머지를 구하는 기호
			
			//실수의 특징
			// - 실수가 포함되면 결과가 실수
			System.out.println(10/3d);
			
			
		}
}

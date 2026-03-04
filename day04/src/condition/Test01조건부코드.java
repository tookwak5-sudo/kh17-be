package condition;

public class Test01조건부코드 {
	public static void main(String[] args) {
		// 논리의 확장판 : 조건부 코드
		
		//입력
		int number = 8;
		
		//처리
		boolean odd = number%2 != 0;
		boolean even = number % 2 ==0;

		
		// 출력 // 1. 블럭을 만들고 코드 넣기
		
		if(odd == true){ // odd가  true면 실행되는 블럭
			System.out.println("홀수");
		}
		
		if(even == true){  // even이 true면 실행되는 블럭
			System.out.println("짝수");
		}

		//메뉴에 Run -> Coverage // 유효 코드 찾을 수 있음
	}
}

package array;

import java.util.Scanner;

//사용자에게 10개의 숫자를 입력받아 다음 을 구하시오
public class Test05숫자입력2 {
	public static void main(String[] args) {
		// 입력
		int[] numbers = new int[10];
		
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < numbers.length; i++) {
			System.out.print("숫자 입력");
			//numbers = sc.nextInt(); 가장 많이 실수하는 코드
			numbers[i]= sc.nextInt(); // 올바른 코드
		}
		
		//홀수 개수
		int odd = 0;
		for(int i = 0; i < numbers.length; i++) {
			//if(numbers % 2 == 1) //리모컨 연산 불가
			if(numbers[i] % 2 == 1) {
				//System.out.println("홀수 = " + numbers[i]);
				odd++;
			}
		}
		System.out.println("홀수의 개수 : " + odd + "개");
		
		// 가장 큰 수
		// 변수를 하나 준비해서 0번 위치 값을 넣어두고 1부터 끝까지 값들과 비교해서 더 큰게 나타나면 덮어쓰기 합니다.
		int max = numbers[0];
		for(int i = 1; i < numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			//	System.out.println("max의 값 : " + max);
			}
		}
		System.out.println("max = " + max);
	}
}



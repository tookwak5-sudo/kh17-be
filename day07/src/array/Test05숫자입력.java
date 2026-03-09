package array;

import java.util.Scanner;

//사용자에게 10개의 숫자를 입력받아 다음을 구하시오
public class Test05숫자입력 {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		
			int[] numbers = new int[10];
			
			for(int i = 0; i < numbers.length; i++) { //배열에 10개의 숫자 초기화
				numbers[i] = sc.nextInt();
			}
			
			// 홀수의 개수
			int odd = 0;
			for(int i = 0; i < numbers.length; i++) {
				if(numbers[i] % 2 == 1) {
					odd++;
				}
			}
			
			// 가장 큰 수
			int max = numbers[0];
			for(int i = 1; i < numbers.length; i++) {
				if(max < numbers[i]) {
					max = numbers[i];
				}
			}
		System.out.println("max = " + max);
	}
}

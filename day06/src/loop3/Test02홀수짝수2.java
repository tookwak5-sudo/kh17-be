package loop3;

import java.util.Scanner;

//사용자가 0을 입력할 때까지 무한히 숫자를 입력받아 그동안 입력한 짝수와 홀수의 개수를 출력하세요
//(단, 0은 카운트하지 않습니다)
public class Test02홀수짝수2 {
	public static void main(String[] args) {
		
		//1회의 입력을 통해 홀수 짝수 구분
		Scanner sc = new Scanner(System.in);
		int odd = 0;
		int even = 0;
		
		while(true) {
			System.out.println("숫자 입력(0입력 시 종료");
			int number = sc.nextInt();
			//종료조건
			if(number == 0) break;
			if(number % 2== 0) {
//				System.out.println("짝");
				even++;
			}
			else {
				//System.out.println("홀");
				odd++;
			}
		}
		System.out.println("홀수 = " + odd + "개");
		System.out.println("짝수 = " + even + "개");
	}
}


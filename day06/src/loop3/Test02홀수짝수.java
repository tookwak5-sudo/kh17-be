package loop3;

import java.util.Random;
import java.util.Scanner;

//사용자가 0을 입력할 때까지 무한히 숫자를 입력받아 그동안 입력한 짝수와 홀수의 개수를 출력하세요
//(단, 0은 카운트하지 않습니다)
public class Test02홀수짝수 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int evenCount = 0;
		int oddCount = 0;
		
		while(true) {		
			System.out.print("숫자를 입력하시오 :");
			int number = sc.nextInt();
			if(number !=0) {
				boolean even = number % 2 == 0;
				boolean odd = number % 2 == 1;
				if(even) {
				//	System.out.println("짝수");
					evenCount++;
				}
				else{
				//	System.out.println("홀수");
					oddCount++;
				}
			}
			else {
				System.out.println("<짝수와 홀수의 개수>");
				break;
			}
		}
		System.out.println("짝수 : " + evenCount + "개");
		System.out.println("홀수 : " + oddCount + "개");
	}
}

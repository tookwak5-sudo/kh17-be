package loop2;

import java.util.Scanner;

//사용자에게 숫자를 1개 입력받아서 이 숫자의 약수가 몇개인지 찾아서 출력하기


public class Test02약수찾기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("자연수 입력 : ");
		int number = sc.nextInt();
		int count = 0;
		
		//처리
		for(int i =2; i < number; i++) {
			if(number % i ==0) {
				System.out.println(i);
				count++;				
				break;		
			}
		}
		//출력
		System.out.println(number + "의 약수의 개수는 " + count + "개");
		
		if(count > 0) {
			System.out.println("소수가 아닙니다.");
		}
		else {
			System.out.println("소수 입니다.");
		}
	}	
}

package loop2;

import java.util.Scanner;

//사용자에게 숫자를 1개 입력받아서 이 숫자의 약수가 몇개인지 찾아서 출력하기


public class Test02약수찾기2 {
	public static void main(String[] args) {
		//6의 약수가 몇개에요?
		//→ 6을 1부터 8까지 숫자로 나눈 나머지를 확인해본다.
		int number = 6;
		int count =0;
		for(int i = 1; i<= number; i++) {
			if(number % i == 0) // 나누어 떨어지면
			count++;
		//	System.out.println(number + "% " + i + "=" + number %i);
		}
		System.out.println("약수의 개수 : " + count);
	}
}

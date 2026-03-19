package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리가필요한이유4 {
	public static void main(String[] args) {
		//(ex) N분의 1 계산기
		
		// 자바가 이해하지 못하는 예외(ex: 금액이 0 이하)를 강제로 예외로 처리

		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 : " );
			int money = sc.nextInt();
			if(money <= 0 ) {
				//catch로 가라
				//throw new InputMismatchException();
				throw new Exception(); // 정확한 구분이나 직접 만들거나 큰데다 넣거나 셋 중 하나 골라서
			}
			System.out.print("인원 : ");
			int people = sc.nextInt();
			if(people <= 0) {
				throw new Exception();
			}
			int price = money / people;
			int remain = money % people;
			
			System.out.println("한 명당 " + price + "원 씩 입금해주시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e) {
			System.err.println("입력이 잘못되었습니다");
		}
	}
}

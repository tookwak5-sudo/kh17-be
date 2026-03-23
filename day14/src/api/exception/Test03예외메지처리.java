package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test03예외메지처리 {
	public static void main(String[] args) {
		//(ex) N분의 1 계산기
		
		// 예외 메세지를 커스터마이징하기

		try { //플랜 A
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 : " );
			int money = sc.nextInt();
			if(money < 0 ) {
				throw new Exception("금액은 0 이하일 수 없습니다."); // 정확한 구분이나 직접 만들거나 큰데다 넣거나 셋 중 하나 골라서
			}
			System.out.print("인원 : ");
			int people = sc.nextInt();
			if(people <= 0) {
				throw new Exception("인원은 0이하일 수 없습니다.");
			}
			int price = money / people;
			int remain = money % people;
			
			System.out.println("한 명당 " + price + "원 씩 입금해주시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e) { // 플랜 B
			System.out.println(e); // 예외 정보가 담긴 객체
		//	1. 사용자에게 뭘 보여줄 것인가?
			if(e.getMessage() == null) {
				System.out.println("알수없는 오류가 발생했습니다.");
			}
			else {
				System.err.println("오류 - " + e.getMessage());
			}
			//2. 개발자는 뭘 확인할 수 있게 할 것인가?
		//	e.printStackTrace();
		}
	}
}


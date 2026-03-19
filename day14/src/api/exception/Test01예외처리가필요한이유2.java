package api.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01예외처리가필요한이유2 {
	public static void main(String[] args) {
		//(ex) N분의 1 계산기
		
		//두 가지 문제점을 발견했으므로 그에 따른 플랜 B를 작성
		// try : 플랜 A를 작성하는 공간(이상적인 결과)
		// catch : 플랜 B를 작성하는 공간(문제 유형별로 작성)
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 : " );
			int money = sc.nextInt();
			System.out.print("인원 : ");
			int people = sc.nextInt();
			
			int price = money / people;
			int remain = money % people;
		
			System.out.println("한 명당 " + price + "원 씩 입금해주시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
		}
		catch(ArithmeticException e) { //ArithmeticException에 대한 플랜B
			System.err.println("사람은 1명 이상이어야 합니다");
		}
		catch(InputMismatchException e) { // InputMismatchException에 대한 플랜 B
			System.err.println("올바른 숫자를 입력하세요");
		}
		
		// 추가로 발생하는 문제점 : catch가 너무 많다
	}
}

package api.exception;

import java.util.Scanner;

public class Test01예외처리가필요한이유 {
	public static void main(String[] args) {
		//(ex) N분의 1 계산기
		
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
}

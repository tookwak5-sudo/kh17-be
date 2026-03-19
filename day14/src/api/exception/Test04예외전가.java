package api.exception;

import java.util.Scanner;

public class Test04예외전가 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 : " );
			int money = sc.nextInt();
			System.out.print("인원 : ");
			int people = sc.nextInt();
			
			int price = Calculator.oneOverN(money, people);
			int remain = Calculator.RemainingAmount(price, people);
			System.out.println("한 명당 " + price + "원 씩 입금해주시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}

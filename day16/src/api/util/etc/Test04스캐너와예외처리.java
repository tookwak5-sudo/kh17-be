package api.util.etc;

import java.util.Scanner;

public class Test04스캐너와예외처리 {
	public static void main(String[] args) {
	//(ex) N분의 1 계산기
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("금액 : " );
			int money = sc.nextInt();
			if(money < 0) throw new Exception("금액은 0보다 커야합니다");
			
			System.out.print("인원 : ");
			int people = sc.nextInt();
			if(people <= 0) throw new Exception("인원은 0보다 커야합니다.");
			sc.close(); // 입력이 끝난 시점에 stream(통로)를 닫아줘야함
		
			int price = money / people;
			int remain = money % people;
		
			System.out.println("한 명당 " + price + "원 씩 입금해주시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
}

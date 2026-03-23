package api.util.etc;

import java.util.Scanner;

public class Test04스캐너와예외처리3 {
	public static void main(String[] args) {
		//해결을 위한 시도
		//-예외와 관계없이 마지막에 무조건 실행되는 구문 - finally 구문
		Scanner sc = new Scanner(System.in);
		try {
			System.out.print("금액 : " );
			int money = sc.nextInt();
			if(money < 0) throw new Exception("금액은 0보다 커야합니다");
			
			System.out.print("인원 : ");
			int people = sc.nextInt();
			if(people <= 0) throw new Exception("인원은 0보다 커야합니다.");
		
			int price = money / people;
			int remain = money % people;
		
			System.out.println("한 명당 " + price + "원 씩 입금해주시면 됩니다.");
			System.out.println("자투리금액 : " + remain + "원");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally { // 플랜 A, B 모두 반드시 실행하는 마지막 구문  // 그치만 finally를 쓰는걸 그닥 선호하지 않음
			sc.close();
		}
	}
}

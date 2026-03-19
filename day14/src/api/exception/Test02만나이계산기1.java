package api.exception;

import java.util.Scanner;

public class Test02만나이계산기1 {
	public static void main(String[] args) {
			//플랜A
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일 입력 :");
			String birth = sc.nextLine(); // next나 nextLine 상관없음
			
			int year = Integer.parseInt(birth.substring(0, 4));
			int month = Integer.parseInt(birth.substring(5, 7));
			int time = 12 * year + month;
			
			int currentYear = 2026;
			int currentMonth = 3;
			int current = currentYear * 12 + currentMonth;
			int total = current - time;
			int globalAge = total / 12;
			
			System.out.println("당신의 만나이 :" + globalAge + "세(" + total + "개월)");
		
		
	}
}

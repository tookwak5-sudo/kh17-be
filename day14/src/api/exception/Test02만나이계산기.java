package api.exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02만나이계산기 {
	public static void main(String[] args) {
		
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일 입력 :");
			String birth = sc.nextLine();
			
			String del = birth.replace("-", "");
			StringBuffer buffer = new StringBuffer(); // 문자열에서 \-빼고 숫자전환
			int num = Integer.parseInt(del);
			
			int birthYear = num / 10000;
			int birthMonth = num / 100 % 100;
			int currentYear = LocalDate.now().getYear();
			int currentMonth = LocalDate.now().getMonthValue();
			int currentDay = LocalDate.now().getDayOfMonth();
			
			int currentDiff = currentYear * 12 + currentMonth;
			int birthDiff = birthYear * 12 + birthMonth;
			
			int diff = currentDiff - birthDiff;
			int age = diff / 12;
			int ageMonth = diff % 12;
			System.out.println("당신의 만 나이는 " + age + "세(" + age + "년" + ageMonth + "개월)" );
		
	}
}

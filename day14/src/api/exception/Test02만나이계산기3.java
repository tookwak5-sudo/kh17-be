package api.exception;

import java.time.LocalDate;
import java.util.Scanner;

public class Test02만나이계산기3 {
	public static void main(String[] args) {
			
		try {//플랜B
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일 입력 :");
			String birth = sc.nextLine(); // next나 nextLine 상관없음
			if(!DateCalculate.CheckValid(birth)) { // 유효하지 않은 날짜라면 
				throw new Exception(); // 예외로 던져라!
			}
			
			int year = Integer.parseInt(birth.substring(0, 4));
			int month = Integer.parseInt(birth.substring(5, 7));
			int time = 12 * year + month;
			
			int currentYear = LocalDate.now().getYear();
			int currentMonth = LocalDate.now().getMonthValue();
			int current = currentYear * 12 + currentMonth;
			int total = current - time;
			int globalAge = total / 12;
			
			System.out.println("당신의 만나이 :" + globalAge + "세(" + total + "개월)");
		}
		catch(Exception e) { // 통합 캐치블럭
			System.err.println("입력이 유효하지 않습니다.");
		}
		
	}
}

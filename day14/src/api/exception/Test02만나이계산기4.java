package api.exception;

import java.util.Scanner;

public class Test02만나이계산기4 {
	public static void main(String[] args) {
			
		try {//플랜B
			Scanner sc = new Scanner(System.in);
			System.out.print("생년월일 입력 :");
			String birth = sc.nextLine(); // next나 nextLine 상관없음
			if(!DateCalculate.CheckValid(birth)) { // 유효하지 않은 날짜라면 
				throw new Exception(); // 예외로 던져라!
			}
			int birthDays = DateCalculate.calculateDates(birth);
			int currentDays = DateCalculate.calculateDates("2026-03-18");// 오늘 날짜로 변환해서
			if(currentDays < birthDays){//미래의 날짜라면){
					throw new Exception(); // 예외로 던져라!
			}
			
			int total = currentDays - birthDays;
			int globalAge = total; //- 내가 살아온 동안 만난 윤년 수) / 365;
			
			System.out.println("당신의 만나이 :" + globalAge + "세(" + total + "개월)");
		}
		catch(Exception e) { // 통합 캐치블럭
			System.err.println("입력이 유효하지 않습니다.");
		}
		
	}
}

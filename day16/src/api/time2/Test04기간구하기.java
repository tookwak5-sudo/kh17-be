package api.time2;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Test04기간구하기 {
	public static void main(String[] args) {
		
		LocalDate a = LocalDate.parse("2026-01-01");
		LocalDate b = LocalDate.now();
		
		//(1) Period 사용 (기간 구하기)
		Period p = Period.between(a, b);
		System.out.println(p);
		
		//(2) 단위에 초점을 맞춰서 기간 구하기(연/월/일/시/분/초/밀리초/나노초)
		//- ChronoUnit 이라는 클래스는 열거형(enum) 클래스
		//- 열거형 클래스는 상수만 편하게 쓸 수 있도록 모아놓고 더 이상 생성은 불가능한 클래스
		long days = ChronoUnit.DAYS.between(a, b);
		System.out.println(days);
	}
}

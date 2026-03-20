package api.time2;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Test02날짜만사용 {
	public static void main(String[] args) {
		//LocalDate를 이용한 날짜 제어
		
		//객체 생성
		LocalDate today = LocalDate.now();
		LocalDate end = LocalDate.of(2026, 9, 30); //2026년 9월 30일
		LocalDate end2 = LocalDate.parse("2026-09-30");
		System.out.println("today =" + today);
		System.out.println("end =" + end);
		System.out.println("end2 =" + end2);
		
		//표준 날짜 형식이 아니면?
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate end3 = LocalDate.parse("2026/09/30", f3);//f3형식으로 해석해라
		DateTimeFormatter f4 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate end4 = LocalDate.parse("30/09/2026", f4);//f4형식으로 해석해라
		System.out.println("end3 = " + end3);
		System.out.println("end4 = " + end4);
		
		//end와 end2는 같은날인가요?
		System.out.println(end.equals(end2));
		
		//아직 수료 전 인가요?
		System.out.println(today.isBefore(end));
		System.out.println(end.isAfter(today));
		
		//setter와 getter의 사용 변화 확인
		System.out.println(end.getYear());
		System.out.println(end.getMonthValue());
		System.out.println(end.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));
		System.out.println(end.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN));
		
		//날짜 변화(불변인지 확인)
		LocalDate d1 = today.plusDays(100L); // 오늘의 100일 후
		LocalDate d2 = today.minusDays(100L); // 오늘의 100일 전
		
		System.out.println("today =" + today);
		System.out.println("d1 =" + d1);
		System.out.println("d1 =" + d2);
		
		//윤년 확인
		System.out.println(today.isLeapYear());
		
		//수료일까지 남은 기간
		//즉, today와 end의 차이를 계산해야한다.
		// - 기간(Period) 클래스를 이용하여 처리할 수 있다.
		// - Period는 달력의 칸을 기준으로 계산해서 ?개월 등의 값을 알아낼 수 있다.
		Period p = Period.between(today, end); // today와 end사이의 기간을 구하기
		System.out.println(p.getYears());
		System.out.println(p.getMonths());
		System.out.println(p.getDays());
		
		System.out.println();
	}
}

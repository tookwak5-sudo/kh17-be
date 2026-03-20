package api.time2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;

//월 구독 방식의 서비스이며 비용은 1개월당 12000원이라고 가정합니다.
//사용자에게 연장할 기간 (개월수)를 입력받습니다.
//오늘부터 사용자가 입력한 개월 수 만큼 연장했을 때 발생하는 비용과 만료일자를 계산하여 출력합니다.
//예를들어 오늘이 2026년 3월 20일이고 4개월 연장하겠다고 할 경우 만료일은 2026년 7월 19일입니다.
//단, 만료일이 주말일 경우 가장 가까운 월요일을 만료일자로 설정합니다. (2026년 7월 19일은 일요일이므로 하루 더 연장)

public class Test03기간연장계산기해설3 {
	public static void main(String[] args) {
		//System.out.println("연장할 기간(개월) 입력 : ");
		int addPeriod = 4;
		int pricePerMonth = 12000;
		int pay = pricePerMonth * addPeriod;
		
		LocalDate today = LocalDate.now();
		LocalDate end = today.plusMonths(addPeriod).minusDays(1);
		
		
		DayOfWeek week = end.getDayOfWeek();
		if(week == DayOfWeek.SATURDAY || week == DayOfWeek.SUNDAY) {
			//TempralAdjusters라는 도구 클래스를 사용해서 날짜를 한번에 구한다.
			//-이번달 말일, 다음주 월요일,...
			end = end.with(TemporalAdjusters.next(DayOfWeek.MONDAY)); // 가장가까운 다음 월요일
		}
		System.out.println("예상 만료일 : " + end);
		System.out.println("예상 결제금액 : " + pay + "원");
	}
}

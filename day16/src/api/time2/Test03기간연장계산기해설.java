package api.time2;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

//월 구독 방식의 서비스이며 비용은 1개월당 12000원이라고 가정합니다.
//사용자에게 연장할 기간 (개월수)를 입력받습니다.
//오늘부터 사용자가 입력한 개월 수 만큼 연장했을 때 발생하는 비용과 만료일자를 계산하여 출력합니다.
//예를들어 오늘이 2026년 3월 20일이고 4개월 연장하겠다고 할 경우 만료일은 2026년 7월 19일입니다.
//단, 만료일이 주말일 경우 가장 가까운 월요일을 만료일자로 설정합니다. (2026년 7월 19일은 일요일이므로 하루 더 연장)

public class Test03기간연장계산기해설 {
	public static void main(String[] args) {
		System.out.println("연장할 기간(개월) 입력 : ");
		int addPeriod = 4;
		int pricePerMonth = 12000;
		
		LocalDate today = LocalDate.now();
		int pay = pricePerMonth * addPeriod;
		
		LocalDate end = today.plusMonths(addPeriod).minusDays(1);
		
		String week = end.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
		int count = 0;
		switch(week) {
		case "토" :
			end = end.plusDays(1L);
			count++;
		case "일" :
			end = end.plusDays(1L);
			count++;
		}
		
		System.out.println("예상 만료일 : " + end);
		if(count > 0) {
			System.out.println("["+count + "일 추가서비스]");
		}
		
		
		System.out.println("예상 결제금액 : " + pay + "원");
	}
}

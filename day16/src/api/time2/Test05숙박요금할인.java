package api.time2;
//우리 호텔에서는 다음 기준에 부합하는 사람들은 숙박 요금을 할인해주려고 합니다.

import java.time.LocalDate;
import java.time.Period;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

//공실율이 가장 높은 월요일에 숙박하는 사람들은 숙박하는 월요일의 수마다 5%씩 할인합니다 (최대 50%까지 가능)
//일주일(7일) 이상 장기 투숙객은 별도로 10% 추가 할인을 제공합니다.
//월요일 할인과 장기 투숙객 할인을 모두 적용받으면 최대 60%까지 할인이 가능합니다.

//호텔 숙박요금이 1박에 30만원일 때 체크인 날짜와 체크아웃 날짜를 yyyy-MM-dd 형태로 입력받아 영수증을 출력하세요
public class Test05숙박요금할인 {
	public static void main(String[] args) {
		LocalDate check_In = LocalDate.parse("2026-03-20"); // 체크인 날짜를 오늘로 하자
		LocalDate check_Out = LocalDate.parse("2026-03-22"); 
		
		//Period stay = Period.between(check_In, check_Out);
		long stay = ChronoUnit.DAYS.between(check_In, check_Out); 
		int pay = 300000;
		long price = stay * pay;
		
		float sale1 = 0;
		// 장기 투숙 할인
		if(stay >= 7) {
			sale1 = price * 10 / 100;
		}
		
		
		String week = null;
		int mondayCount = 0;
		// 월요일 수 마다 할인
		for(int i = 1; i <= stay; i++) {
			week = check_Out.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.KOREAN);
			switch(week) {
			case "월":
				mondayCount++;
				break;
			}
		}
		
		System.out.println(week);
		
		
		System.out.println("[ 00숙박 영수증 ]");
		System.out.println("대표자 명 : 김00");
		System.out.println("==============");
		System.out.println("가격 : " + price);
		
		System.out.println("["+ check_In + " ~ " + check_Out + "] (" + stay + "박)");
		
		
	}
}

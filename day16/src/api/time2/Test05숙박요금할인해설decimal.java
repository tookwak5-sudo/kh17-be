package api.time2;
//우리 호텔에서는 다음 기준에 부합하는 사람들은 숙박 요금을 할인해주려고 합니다.

import java.text.DecimalFormat;
import java.text.Format;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//공실율이 가장 높은 월요일에 숙박하는 사람들은 숙박하는 월요일의 수마다 5%씩 할인합니다 (최대 50%까지 가능)
//일주일(7일) 이상 장기 투숙객은 별도로 10% 추가 할인을 제공합니다.
//월요일 할인과 장기 투숙객 할인을 모두 적용받으면 최대 60%까지 할인이 가능합니다.

//호텔 숙박요금이 1박에 30만원일 때 체크인 날짜와 체크아웃 날짜를 yyyy-MM-dd 형태로 입력받아 영수증을 출력하세요
public class Test05숙박요금할인해설decimal {
	public static void main(String[] args) {
		LocalDate check_In = LocalDate.parse("2026-03-20"); // 체크인 날짜를 오늘로 하자
		LocalDate check_Out = LocalDate.parse("2026-05-22"); 
		
		//Period stay = Period.between(check_In, check_Out);
		int stay = (int) ChronoUnit.DAYS.between(check_In, check_Out); 
		int pay = 300000;
		int price = stay * pay;
		
		// 장기 투숙 할인
		int sale1 = stay >= 7 ? 10 : 0;
		
		int mondayCount = 0;
		// 월요일 수 마다 할인
		for(int i = 1; i <= stay; i++) {
				DayOfWeek week = check_In.plusDays(i).getDayOfWeek(); // 체크인 날짜에서 더한 뒤
				if(week == DayOfWeek.MONDAY) { //월요일이면
					mondayCount++;
				}
			}
		int sale2 = Math.min(mondayCount * 5, 50);
		
		// 출력
		//- 출력 시 그룹 처리
		//- ㅠㅐ턴 인식 기능이 있어서 콤마를 하나만 작성하면 그 패턴에 맞게 
		//- #은 해당 자리에 숫자가 없으면 출력을 안함. 0 은 해당자리에 숫자가 없으면 0을 출력
		// - 무적의 패턴 - #,##0.00 
		// - 다만 이문제에선 소숫점이 나올 경우가 없기 때문에 .00 부분을 지워줌
		Format f = new DecimalFormat("#,##0");
		int longStayDiscount = price * sale1 / 100;
		int mondayDiscount = price * sale2 / 100;
		int discount = longStayDiscount + mondayDiscount;
		int result = price - discount;
		System.out.println("[ 00숙박 영수증 ]");
		System.out.println("대표자 명 : 김00");
		System.out.println("=".repeat(30));
		System.out.println("["+ check_In + " ~ " + check_Out + "] (" + stay + "박)");
		System.out.println("=".repeat(30));
		System.out.println("최초 금액 : " + f.format(price));
		System.out.println("장기투숙 할인율 : " + longStayDiscount);
		System.out.println("요일 할인율 : " + mondayDiscount);
		System.out.println("최종 할인율 : " + f.format(discount));
		System.out.println("최종 가격 : " + f.format(result));
		System.out.println("=".repeat(30));
		
	}
}

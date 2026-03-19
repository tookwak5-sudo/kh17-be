package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07급여일계산기2 {
	public static void main(String[] args) {
		//1. 1년치 급여일 출력 (매달 5일에 급여 들어옴) clear
		//2. 급여일이 주말이면 가장 가까운 이전 날짜의 평일에 지급
		// 토 -> 금 / 일 -> 월
		
		int year = 2026;
		int month = 3;
		int day = 1;
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DATE, day);
		
		for(int i = 1; i <= 365; i++) {
			//하루씩 늘어나는데 day가 5면 출력
			c.add(Calendar.DATE, 1);
			Date d = c.getTime();
			Format f = new SimpleDateFormat("y-MM-dd");
			int payDay = c.get(Calendar.DATE);
			
			//주말 찾기
			int week = c.get(Calendar.DAY_OF_WEEK); // 
			
			if(payDay == 5) {
				if(week == Calendar.SATURDAY) {
					c.set(Calendar.DATE, day -1);
					System.out.println(f.format(d));
				}
				else if(week == Calendar.SUNDAY) {
					c.set(Calendar.DATE, day + 1);
					System.out.println(f.format(d));
				}
				else {
					System.out.println(f.format(d));
				}
			}
		}
	}
}

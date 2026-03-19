package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07급여일계산기3 {
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
		
		//출력
		Format f = new SimpleDateFormat("y-MM-dd E");
		
		for(int i = month; i <= month + 12; i++) {
			c.set(year, i, 5);
			
			int week = c.get(Calendar.DAY_OF_WEEK);
			
			if(week == Calendar.SATURDAY) {
				c.add(Calendar.DATE, -1);
			}
			else if(week == Calendar.SUNDAY){
				c.add(Calendar.DATE, 1);
			}
				Date d = c.getTime();
				System.out.println(f.format(d));
		}
	}
}

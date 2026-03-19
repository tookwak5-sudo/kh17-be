package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07급여일계산기5 {
	public static void main(String[] args) {
		//1. 1년치 급여일 출력 (매달 5일에 급여 들어옴) clear
		 
		
		int year = 2026;
		int month = 3;
		int day = 1;
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DATE, day);
		
		for(int i = day; i <= 365; i++) {
			//하루씩 늘어나는데 day가 5면 출력
			c.add(Calendar.DATE, 1);
			int payMonth = c.get(Calendar.DATE);
			int week = c.get(Calendar.DAY_OF_WEEK);
			if(payMonth == 5) {
				Date d = c.getTime();
				Format f = new SimpleDateFormat("y-MM-dd");
				System.out.println(f.format(d));
			}
		}
	}
}

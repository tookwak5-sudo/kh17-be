package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test06기념일계산기 {
	public static void main(String[] args) {
		//입력
		
		int year = 2026;
		int month = 3;
		int day = 19;
		int dDay = 0;
		
		//처리
		Calendar c = Calendar.getInstance();
		for(int i = 1; i <= 365; i++) {
			dDay++;
			day += dDay;
		}
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month - 1);
		c.set(Calendar.DATE, day);
		
		//출력
		Date d = c.getTime();
		Format f = new SimpleDateFormat("y-M-d");
		if(year == 2026) {
			if(dDay % 100 == 0) {
				System.out.println("D +" + dDay + " : " + f.format(d));
			}
		}
		
	}
}

package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test06기념일계산기3 {
	public static void main(String[] args) {
		//입력
		int year = 2026;
		int month = 3;
		int day = 18;
		
		
		//처리
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, day);
		
		//출력
		for(int i = 1; i < 365*2; i++) {
			//100일 뒤로 이동
			c.add(Calendar.DATE, 1);
			//출력
			if(i % 100 == 0 || i % 365 == 0) {
				Date d = c.getTime();
				Format f = new SimpleDateFormat("y년 M월 d일 E요일");
				System.out.println("D +" + i + " : "+ f.format(d));
			}
			
		}
		
	}
}

package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test05달력만들기 {
	public static void main(String[] args) {
		//달력 객체 생성
		Calendar c = Calendar.getInstance();
		
		//날짜 설정
		int year = 2026;
		int month = 1;
		c.set(year, month-1, 1);
		Date d = c.getTime();
		Format f = new SimpleDateFormat("y년 M월");
		System.out.println(f.format(d));
		System.out.println("일\t 월\t 화\t 수\t 목\t 금\t 토\t");
		for(int i = 1; i <= 31; i++) {
			c.set(year, month-1, i);
			Date date = c.getTime();
			Format day = new SimpleDateFormat("d");
			System.out.print(day.format(date) + "\t");
			int week = c.get(Calendar.DAY_OF_WEEK);
			if(week == Calendar.SATURDAY) {
				System.out.println("\r");
			}
		}
		
		
		//날짜 출력
		
	}
}

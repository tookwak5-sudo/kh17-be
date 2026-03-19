package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test05달력만들기5 {
	public static void main(String[] args) {
		
		//입력
		int year = 2026;
		int month = 5;
		
		//처리
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month-1);
		c.set(Calendar.DATE, 1);
		int week = c.get(Calendar.DAY_OF_WEEK);
		//System.out.println("week = " + week);
		
		//-(week-1) 또는 -week + 1 만큼 이동하면 일요일이 나온다
		c.add(Calendar.DATE, -week+1);
		//즉 날짜는 -week + 2
		//c.set(Calendar.DATE, -week + 2);
		//출력
		System.out.println("일\t 월\t 화\t 수\t 목\t 금\t 토\t");
		for(int i = 1; i <= 42; i++) {
			//System.out.print(i);
			System.out.print(c.get(Calendar.DATE));
			System.out.print("\t");
			
			//c.add(Calendar.DATE, 1); // 하루 뒤로 이동
			int day = c.get(Calendar.DATE);//날짜 추출
			c.set(Calendar.DATE, day+ 1);// 다음날로 재설정
			
			if(i % 7 == 0 ) {
				System.out.println();
			}
		}
		
	}
}

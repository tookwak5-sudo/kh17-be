	package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Test06기념일계산기4 {
	public static void main(String[] args) {
		//입력
		int year = 2026;
		int month = 3;
		int day = 18;
		
		int period = 365 * 2; // 보여줄 기간
		int count = period / 100 + period / 365;
		
		//int[] plus = new int[] {100, 200, 300, 365, 400, 500, 600, 700, 730};
		int[] plus = new int[count];
		
		int index = 0;
		for(int i = 100; i <= period; i += 100) { //1단위 날짜 채우고
			plus[index] = i;
			index++;
		}
		for(int i = 365; i <= period; i += 365) { // 365단위 날짜 채우고
			plus[index] = i;
			index++;
		}
		// 정렬
		Arrays.sort(plus);
		
		//처리
		Calendar c = Calendar.getInstance();
		
		for(int i = 0; i < plus.length; i++) {
			c.set(year, month-1, day);
			c.add(Calendar.DATE, plus[i]);
			Date d = c.getTime();
			Format f = new SimpleDateFormat("y년 M월 d일 E요일");
			System.out.println("D +" + plus[i] + " : "+ f.format(d));
		}
		
	}
}

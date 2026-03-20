package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test07급여일계산기해설2 {
	public static void main(String[] args) {
		
		//ex) 급여일이 매월 5일이라고 가정하고 문제를 풀자
		Calendar today = Calendar.getInstance();//현재날짜를 불러옴
		
		Calendar payDay = Calendar.getInstance(); // 급여일을 계산할 도구		
		payDay.set(Calendar.DATE, 5); // 5일로 변경
		
		//계산의 실패를 방지하기 위해 시간을 제거
		today.set(Calendar.HOUR, 0); 
		today.set(Calendar.MINUTE, 0);
		today.set(Calendar.SECOND, 0);
		today.set(Calendar.MILLISECOND, 0);
		
		payDay.set(Calendar.HOUR, 0); 
		payDay.set(Calendar.MINUTE, 0);
		payDay.set(Calendar.SECOND, 0);
		payDay.set(Calendar.MILLISECOND, 0);
		
		Format f = new SimpleDateFormat("y년 M월 d일 E");
		
		if(today.after(payDay)) {
			payDay.add(Calendar.MONTH, 1); // 한달 뒤로
		}
		//12회 반복
		for(int month = 1; month <=12; month++) {
			int week = payDay.get(Calendar.DAY_OF_WEEK);
			switch(week) {
			case Calendar.SUNDAY:
				payDay.add(Calendar.DATE, -1); // 하루 앞으로 이동
			case Calendar.SATURDAY:
				payDay.add(Calendar.DATE, -2); // 하루 앞으로 이동
			}
		}
		
		//출력
		Date d = payDay.getTime();
		System.out.println(f.format(d));
		
		//다음달로 이동
		payDay.add(Calendar.MONTH, 1);
		payDay.set(Calendar.DATE, 5);
	}
}

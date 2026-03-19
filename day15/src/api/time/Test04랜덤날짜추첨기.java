package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
//Calendar 클래스를 사용하여 다음 규칙에 맞는 랜덤한 날짜를 추첨하세요
//
//올해 1월 1일 ~ 12월 31일까지 중 랜덤하게 하루를 추첨하여 출력
//주말(토, 일) 중에서 하루가 나올 때까지 재추첨하여 출력
//출력 형식은 2026년 3월 19일 목 형식으로 출력
public class Test04랜덤날짜추첨기 {
	public static void main(String[] args) {
		Random r = new Random();
		Calendar cal = Calendar.getInstance();
		Format sdf = new SimpleDateFormat("y년 M월 dd일 E");
		int dayOfWeek;
		while(true) {
			int randomDayofYear = r.nextInt(364) + 0;
			cal.set(2026, Calendar.JANUARY, 1);
			cal.set(cal.DAY_OF_YEAR, randomDayofYear);
			dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
			if(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
				break;
			}
			
		}
		System.out.println(sdf.format(cal.getTime()));
		
	}
}

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
public class Test04랜덤날짜추첨기5 {
	public static void main(String[] args) {
		//달력 객체 생성
		Calendar c = Calendar.getInstance();
		
		//날짜 설정
		//- 달력이 유연하다 했으니 월은 1월로 설정하고 일만 1부터 365사이에서 설정!
		//- 윤년을 고려하려면 (1) 연도로 직접계산하던가 (2) 2월로 바꿔서 29일이 있나 보던가
		
		int year = c.get(Calendar.YEAR);
		boolean leap = year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
		int range = leap ? 366: 365;
		
		Random r = new Random();
		
		//주말이 나올때까지 반복
		while(true){
			int day = r.nextInt(range) + 1;
			
			c.set(year, 0, day);
			
			
			int week = c.get(Calendar.DAY_OF_WEEK);
			if(week == Calendar.SATURDAY || week == Calendar.SUNDAY) {
				break;
			}
		}
		//날짜 출력
		Date d = c.getTime();
		Format f = new SimpleDateFormat("y년 M월 d일 E");
		System.out.println(f.format(d));
	}
}

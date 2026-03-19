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
public class Test04랜덤날짜추첨기2 {
	public static void main(String[] args) {
		//달력 객체 생성
		Calendar c = Calendar.getInstance();
		
		//날짜 설정
		//-월과 날을 각각 랜덤으로 출력하면 복잡해짐
		Random r = new Random();
//		int month = r.nextInt(12) + 1;
//		int day = r.nextInt(28, 29, 30, 31) + 1;
		
		//날짜 출력
		Date d = c.getTime();
		Format f = new SimpleDateFormat("y년 M월 d일 E");
		System.out.println(f.format(d));
	}
}

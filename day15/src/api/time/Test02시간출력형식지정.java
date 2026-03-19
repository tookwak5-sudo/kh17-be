package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Test02시간출력형식지정 {
	public static void main(String[] args) {
		//현재 시각
		Date current = new Date(); // 현재 시간이 담긴 객체
	
		// 기본 언어(Locale)를 변경
		//Locale.setDefault(설정할 Locale 객체);
		//Locale.setDefault(Locale.JAPAN);// 지역을 일본으로 설정
		//Locale.setDefault(Locale.JAPANESE);// 언어를 일본으로 설정
		Locale.setDefault(Locale.ENGLISH); // 언어를 영어로 설정
		
		//1번 '2026년 3월 19일 목 오후 12시 12분 20초' // y같은 개수는 가장 최소단위를 생각해라 0003년은 이상
		//SimpleDateFormat f1 = new SimpleDateFormat("y년 M월 d일 목 a h시 m분 s초");
		Format f1 = new SimpleDateFormat("y년 M월 d일 E요일 a h시 m분 s초"); // 언어가 바뀌면 쓸 수없기 때문에 권장하지 않는 방식
		System.out.println(f1.format(current));
		
		// 2번 '2026년 3월 19일 목 오후 12시 12분 20초'
		SimpleDateFormat f2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f2.format(current));
		// 3번
		SimpleDateFormat f3 = new SimpleDateFormat("a h : mm");
		System.out.println(f3.format(current));
	}
}

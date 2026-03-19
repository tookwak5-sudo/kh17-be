package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test05달력만들기4 {
	public static void main(String[] args) {
		//달력 객체 생성
		Calendar c = Calendar.getInstance();
		
		//반복문을 2번써서 7개씩 6번
		System.out.println("일\t 월\t 화\t 수\t 목\t 금\t 토\t");
		for(int i = 1; i <= 6; i++) {
			for(int k = 1; k <= 7; k++) {
				System.out.print(i);
				System.out.print("\t");
			}
				System.out.println();
		}
		
	}
}

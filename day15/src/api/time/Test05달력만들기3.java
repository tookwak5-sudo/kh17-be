package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test05달력만들기3 {
	public static void main(String[] args) {
		//달력 객체 생성
		Calendar c = Calendar.getInstance();
		
		System.out.println("일\t 월\t 화\t 수\t 목\t 금\t 토\t");
		for(int i = 1; i <= 42; i++) {
			System.out.print(i);
			System.out.print("\t");
			
			if(i % 7 == 0 ) {
				System.out.println();
			}
		}
		
	}
}

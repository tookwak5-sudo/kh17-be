package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더클래스4 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		c.set(2000, 0, 367);//한번에
		
		//- 그럼 혹시 getter 메소드는?
		//System.out.pritnln("연도 :" + c.getYear()) // 우리의 상식;
		System.out.println("연도 : " + c.get(Calendar.YEAR)); // Calendar의 형식
		System.out.println("월 : " + (c.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + (c.get(Calendar.DATE)));
		
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
	}
}

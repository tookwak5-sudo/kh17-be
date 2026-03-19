package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더클래스3 {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		
		c.set(2000, 1, 29);//한번에
		
		//지금 c에 설정된 날짜가 윤년인가요?
		//- 아쉽지만 달력을 2월로 변경해서 며칠까지 있는지를 구해야함
		
		boolean leap = c.getActualMaximum(Calendar.DATE) == 29;
		System.out.println("leap = " + leap);
		
		//음력 역시 어려움
		
		//- 그럼 혹시 getter 메소드는?
		
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
	}
}

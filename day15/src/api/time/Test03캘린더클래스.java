package api.time;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test03캘린더클래스 {
	public static void main(String[] args) {
		//Date의 문제점
		//1. 1900년도가 기준이라는 문제
		//2. 시간변경이 어려움(1번으로 인해)
		//3. 월이 1~12가 아니라 0~11로 관리된다
		//4. 같은 이름의 클래스가 또 있어서 혼동됨
		//5. 달력의 종류를 설정할 수 없음
		//해결책 : Calendar 클래스 사용 (3번 빼고 해결)
		//Calender c = new Calendar();//추상 클래스라 생성불가
		//Calendar c = new GregorianCalendar();//업캐스팅하여 생성(권장하지 않음)
		
		Calendar c = Calendar.getInstance(); // 생성 명령 사용(권장)
		System.out.println("c = " + c);
		
		//Calendar은 Date로 변환이 가능
		Date d = c.getTime();
		Format f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(f.format(d));
	}
}

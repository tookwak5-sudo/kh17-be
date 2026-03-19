package api.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01시간구하기 {
	public static void main(String[] args) {
		//1. System 클래스 사용
		long time = System.currentTimeMillis();
		System.out.println("시간 = " + time); // 시계에는 적합하지 않다.
		
		//2. java.util.Date
		Date a = new Date(); // 현재시각
		Date b = new Date(2026, 3, 19); // 2026년 3월 19일?
		System.out.println("a = " + a); // 두가지 문제점 1. 가독성 떨어짐
		System.out.println("b = " + b); // 날짜가 이상하게 나옴 -> api가서 찾아야함
		
		//사람들이 원하는 형식으로 변환해주는 도구의 사용 (java.SimpleDateFormat)
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(a)); // a를 sdf 객체에 설정된 패턴으로 재배치해서 출력!
	}
}

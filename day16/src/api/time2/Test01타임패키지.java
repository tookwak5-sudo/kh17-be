package api.time2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Test01타임패키지 {
	public static void main(String[] args) {
		//java.time패키지
		//- 자바8부터 등장한 신규 시간 관리 도구 모음
		//- Data, Calendar의 불편한 점을 모두 개선
		
		//기존의 문제점과 해결방안
		//1. 월을 0~11로 관리했던것을 1~12로 변경
		//2. setter, getter메소드가 옛날 방식이었으나 이를 현대적으로 항목별로 사용 가능하게 개선했다.
		//3. 윤년을 알기 힘든 구조로 설계되어 있던것을 언제든 확인할 수 있는 메소드를 추가하여 개선했다.
		//4. (중요) 날짜를 가변에서 불변으로 변경 (현대 프로그래밍의 트랜드)
		//5. 서로 다른 두 날짜간의 차이를 구하기가 힘든데, 이를 개선할 수 있는 각종 클래스들을 추가했다.
		//6. (중요) Date나 Calendar은 날짜와 시간을 분리할 수 없는데 이를 각각 다른 클래스로 처리하도록 분리했다.
		//7. Date가 여러개라서 import하기가 불편하기 때문에 다른 이름으로 변경했다.
		
		LocalDate a = LocalDate.now();
		System.out.println("a = " + a); //오늘 (날짜만)
		
		LocalTime b = LocalTime.now();
		System.out.println("b = " + b); //오늘 (시간만)
		
		LocalDateTime c =LocalDateTime.now();
		System.out.println("c = " + c); // 오늘 (날짜와 시간 모두 포함)
	}
}

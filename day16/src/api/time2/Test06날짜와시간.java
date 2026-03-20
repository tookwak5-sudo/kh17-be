package api.time2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test06날짜와시간 {
	public static void main(String[] args) {
		//LocalDateTime : 날짜와 시간이 모두 필요한 경우 // 현재 시간이 필요하다
		//ZoneDateTime : 추가로 타임존 설정이 필요한 경우 // 특정 시간이 필요하다
		
		LocalDateTime t1 = LocalDateTime.now();//현재시각
		LocalDateTime t2 = LocalDateTime.of(2026, 9, 30, 17, 50, 0);
		LocalDateTime t3 = LocalDateTime.parse("2026-09-30T17:50:00");
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime t4 = LocalDateTime.parse("2026-09-30 17:50:00", f);
		
		System.out.println("현재시간 : " + t1);
		System.out.println("현재시간 : " + t2);
		System.out.println("현재시간 : " + t3);
		System.out.println("현재시간 : " + t4.format(f)); //t4를 f에서 정의한 형식으로 출력하세요
		//현재시간 : 2026-03-20T14:18:03.078006300  => iso 표준: T가 공백에 들어감
		
		//시간이 있기 때문에 Duration이라는 클래스로 시간차를 구할 수 있음
		Duration d = Duration.between(t1, t2);
		System.out.println(d.getSeconds() + "초 남음");
		System.out.println("수료까지" + d.toDays() + "일 남음");
		System.out.println("수료까지" + d.toHours() + "시간 남음");
// 모든 시간 파트를 같이 출력 (part로 끝나는 메소드 사용)
		System.out.println("수료까지" + d.toDaysPart() + "일" + d.toHoursPart() + "시간"
									+ d.toMinutesPart() + "분" + d.toSecondsPart() + "초"+d.toMillisPart() );
		
		// with를 이용해서 시간의 특정 항목만 수정
		//- t1과 같은 해 1월 1일로 시간 객체 생성
		LocalDateTime t5 = t1.withMonth(1).withDayOfMonth(1);
		System.out.println("t5 =" + t5);
		
		//t5에서 날짜만 떼어내고 싶다면
		LocalDate t6 = t5.toLocalDate();
		System.out.println("t6 = " + t6);
		
		//Zone설정
		ZonedDateTime zoneTime = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(zoneTime);
		
		//Zone 확인
		ZoneId currentZone = ZoneId.systemDefault(); //현재 시스템의 타임존
		System.out.println("현재 = " + currentZone);
		
		System.out.println("모든 존 =" + ZoneId.getAvailableZoneIds());
	}
}


















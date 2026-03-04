package condition;
//주차장 요금표는 다음과 같습니다.
// 10분당 500원
// 이용시간이 30분 미만이면 무료(회차 적용)

//사용자에게 들어온 시각과 나간시각을 입력받아
//주차시간과 주차요금을 계산하여 출력
// 시간은 '1200'처럼 네자리 정수로 입력
public class Test04주차요금계산기 {
	public static void main(String[] args) {
		
		//입력
		int start = 1200; //현재시간
		int end = 1300; // 나간시간
		int period = 10;
		int periodPrice = 500; // 
		int freeTime = 30; //회차시간
		//처리
		
		int hour = start/100, minute = start %100;				
		int endHour = end / 100, endMinute = end % 100;
		
		int parkTime = (endHour * 60 + endMinute) - (hour* 60 + minute); 
		int parkHour = parkTime / 60;
		int parkMinute = parkTime % 60;
		
		boolean event = parkTime >= freeTime;
		
		int price; // 
		
		//출력
		
		if(event) {
			price = parkTime * periodPrice / period; // 30분이상 주차 시 주차요금 = 주차시간 * 분당요금
		}
		else {
			price = 0;// 30분미만 주차 시 주차요금 = 무료
		}
		
		System.out.println("주차시간 : " + parkHour + "시간 " + parkMinute + "분"); // 주차시간
		System.out.println("주차요금 : " + price +"원");
		 
	}
}

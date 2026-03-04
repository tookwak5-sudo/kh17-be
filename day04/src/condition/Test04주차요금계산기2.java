package condition;
//주차장 요금표는 다음과 같습니다.
// 10분당 500원
// 이용시간이 30분 미만이면 무료(회차 적용)

import java.util.Scanner;

//사용자에게 들어온 시각과 나간시각을 입력받아
//주차시간과 주차요금을 계산하여 출력
// 시간은 '1200'처럼 네자리 정수로 입력
public class Test04주차요금계산기2 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("진입시각: ");
		int in = sc.nextInt();
		System.out.println("진출시각: ");
		int out = sc.nextInt();
		
		int period = 10;
		int periodPrice = 500; // 
		int freeTime = 30; //회차시간
		//처리
		//시간을 분리해서 분으로 변환 후 합친 후 요금 계산
		int inHour = in/100, inMinute = in%100;
		int outHour = out/100, outMinute = out%100;
		
		int inTime = inHour * 60 + inMinute;
		int outTime = outHour * 60 + outMinute;
		int time = outTime - inTime; // 실제주차시간(분)
		
		// 조건과 상관없는 주차시간 먼저 계산
		int hour = time / 60, minute = time % 60;
		
		
		// - 주차요금 계산
		//int price =  //0 or 시간당 500원;
		int price; // 만들긴 하지만 값은 조건에 따라 달라
		if(time < freeTime) {//freeTime 미만이라면
			price = 0;
		}
		else {
			price = time/ period * periodPrice;
		}
		
		//출력
		System.out.println("주차시간: " + hour +"시간" + minute + "분");
		System.out.println("주차요금 : " + price +"원");
	}
}

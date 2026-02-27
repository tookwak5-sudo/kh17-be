package data;

public class Test07주차요금계산기2 {
		
	public static void main(String[] args) {
		//주차시간을 구해야 금액을 구할 수 있으니 시간 먼저 계산

		//입력
		int h1 = 12, m1 = 40; //진입시간
		int h2 = 15, m2 = 20; //진출시간
		
		int period = 10; //단위기간
		int fare = 500; //단위요금
		
		//처리
		int t1 = h1*60 + m1;
		int t2 = h2*60 + m2;
		int time = t2 - t1; // 최종주차시간(분)
		
		int hour = time / 60;
		int minute = time % 60;
				
	 	int price = time / period * fare;  //금액계산
		
		//출력		
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(price);
	}
}

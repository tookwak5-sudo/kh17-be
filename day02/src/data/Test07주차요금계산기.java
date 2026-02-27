package data;

public class Test07주차요금계산기 {
		
	public static void main(String[] args) {
		//주차시간을 구해야 금액을 구할 수 있으니 시간 먼저 계산
	/*	
		//입력
		int h1 = 2;
		int min = 40;
						
		//처리		
		int parkT = h1 * 60 + min; // 주차시간
		int parkF = parkT / 10 * 500; // 주차요금
		
		int parkH = parkT / 60;
		int parkM = parkT % 60;
		System.out.println(parkH);
		System.out.println(parkM);
		
		//출력
		System.out.println(parkT); // 주차시간 2시간 40분 -> 160분 주차
		System.out.println(parkF); // 주차요금 16*500 -> 8000원
*/	
		//입력
		int h1 = 12, m1 = 40; //진입시간
		int h2 = 15, m2 = 20; //진출시간
		
		//처리
		int t1 = h1*60 + m1;
		int t2 = h2*60 + m2;
		int time = t2 - t1; // 최종주차시간(분)
		
		int hour = time / 60;
		int minute = time % 60;
		
		
	 	int price = time / 10 * 500;  //금액계산
		
		//출력		
		System.out.println(hour);
		System.out.println(minute);
		System.out.println(price);
	}
}

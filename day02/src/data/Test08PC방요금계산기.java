package data;

public class Test08PC방요금계산기 {
		public static void main(String[] args) {
			//입력
			int h1 = 12, m1 = 40; // 이용 시작시간
			int h2 = 13, m2 = 0; // 이용 마친 시간
			
			int perhF = 1000; // 1시간 당 요금
			double permF = (double) 1000/60; // 분당요금
	//		System.out.println(permF);
			
			//처리
			int sT = h1*60 + m1; // 이용 시작 시간(분단위)
			int fT = h2*60 + m2; // 이용 마친 시간(분단위)
			
			int useTime = fT - sT; //이용시간(분단위)
					
			double totalFee = permF*useTime; // 분당요금 * 이용시간 = 이용요금 (10의 자리 다 지우기)
			System.out.println(totalFee);
			int fare = (int) totalFee /100 * 100;
			//출력
			System.out.println(useTime); //손님의 이용시간
			//160분 이용 
			System.out.println(fare); // 손님의 pc방 요금
			
		}
}

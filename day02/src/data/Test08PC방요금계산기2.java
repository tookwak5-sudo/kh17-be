package data;

public class Test08PC방요금계산기2 {
		public static void main(String[] args) {
			//입력
			int h1 = 12, m1 = 40; // 이용 시작시간
			int h2 = 13, m2 = 40; // 이용 마친 시간
			
			int perF = 1000; // 1시간 당 요금
			
			
			//처리
			int sT = h1*60 + m1; // 이용 시작 시간(분단위)
			int fT = h2*60 + m2; // 이용 마친 시간(분단위)
			
			int uT = fT - sT; //이용시간(분단위)
					
			int fare = (uT * perF /60) /100 * 100 ; // 이용시간(분단위) * 1시간 당 요금 / 60 
	
			
			//출력
			System.out.println(uT); //손님의 이용시간
			
			//160분 이용 
			System.out.println(fare); // 손님의 pc방 요금
			
		}
}

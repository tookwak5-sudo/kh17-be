package loop2;

public class Test04런닝시간계산기2 {
	public static void main(String[] args) {
		
		int round = 1; //회차
		int time = 20; //시간
		int total = 0; //누적시간
		
		for(int day = 1; day <= 7*4; day++) {
			if(day % 2 !=0) {
				System.out.println(day + "일(" +round+"회차)" +time +"분");
				round++;
				total +=time;
			}
			// 7일마다 5분씩 증가
			if(day % 7 ==0) {
				time +=5;			
			}
		
//			else {
//				System.out.println("휴식");
//			}
		}
		System.out.println("총 운동시간 : " + total + "분");
	}
}

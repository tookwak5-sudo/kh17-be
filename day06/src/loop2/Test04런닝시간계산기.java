package loop2;

public class Test04런닝시간계산기 {
	public static void main(String[] args) {
		//입력
		int time = 20;
		int count = 0;
		int total =0;
		//처리
		
		//출력
		for(int i =1; i<=28; i++) { //일차 
			
			if(i%2 !=0) { // 횟수
				count++;
				System.out.println( count + "회 (" + i + "일차)" + time +"분");
				total +=time;
			}
			if( i% 7 == 0) {
				time += 5;				
			}			
		}
		int hour = total / 60;
		int minute = total % 60;
		
		System.out.println("누적시간 : " + hour + "시간" + minute+"분");
	}
}

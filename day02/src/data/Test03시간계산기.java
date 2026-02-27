package data;

public class Test03시간계산기 {
		
			public static void main(String[] args) {
			// 출력하려는 단위가 중요 , 프로그램은 뒤에서 부터
			    //입력 입력값 대입
				int yMin = 30;				
				int yHour = 1;
				int tMin = 40;
				int tHour = 2; 				
					
				
				//처리 다음 계산
				int yTime = yHour * 60 + yMin;
				int tTime = tHour * 60 + tMin;				
				int Time = yTime + tTime;
				
				//출력 먼저 설정
				System.out.println(Time);
				
			}
}

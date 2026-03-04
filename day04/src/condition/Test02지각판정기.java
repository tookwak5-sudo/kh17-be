package condition;

import java.util.Scanner;

public class Test02지각판정기 {
	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("입실시각 : ");
		int time = sc.nextInt(); // 0905는 8진수이므로 9는 입력이 안됨.
		
		//처리
		int hour = time / 100;
		int minute = time % 100;
		int convert = hour *60 + minute;
		
		int stdHour = 9;
		int stdMinute = 10;
		int standard = stdHour* 60 + stdMinute;
		
		boolean safe = convert <= standard;
		
		
		//출력
		// - 논리에서 true와 같다는 표현은 쓰나마나한 표현이다 (1 = 1+ 0 = 1+ 0 + 0) (5 = 5x1 = 5x1x1) 논리에선 true가 쓰나마나한 코드 
		// - 논리에서 false와 같다는 표현은 반대값을 말하는 표현이다.
		// - (safe가 false와 같다 == sfae가 아니면)
		
		// - 굳이 두 번 물어봐야 둘 중 하나를 출력할 수 있을까? 
		//if(safe == true) 
		//if(convert <= standard)
		if(safe){
			System.out.println("정상 출석입니다.");
		}
		else {
			System.out.println("지각입니다.");
		}		
		/*
		//if(safe == false)
		if(!safe){
			System.out.println("지각입니다.");
		}
		*/
	}
}

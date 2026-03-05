package condition3;

import java.util.Scanner;

// 사용자에게 '월'을 입력받아서 해당하는 월이 몇일까지 있는지 구하여 출력하는 프로그램 만들기
//(단, 2월은 28일로 고정)
//--------------------
//다 하고 시간이 남으신 분은 '연도'를 입력받아 윤년을 계산하여 2월이 28일인지 29일인지 판정하여 나올 수 있도록 만들기

public class Test02날짜계산기3 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 입력");
		int year = sc.nextInt();
		System.out.print("월 입력");
		int month = sc.nextInt(); // 계산이 가능하므로 숫자
		
		//처리
		boolean leap = (year % 400 == 0) || (year % 100 != 0 && year % 4 == 0); // 윤년공식
		
		int days;
		switch(month) {		
		case 2: 
			if(leap) {
				days = 29;
			}
			else {
				days = 28;
			}
			break; 
		case 4: 	case 6:	case 9: case 11:
			days = 30;
			break;
		default: // 1 3 5 7 8 10 12 로 쓰면 다른 예외상황(1~12외의 숫자)이 발생하여 
			       // days의 값이 초기화 되지 않는 경우가 생길 수 있기 때문에 int days = 0;으로 초기화를 시켜야지 
					//오류가 안생긴다.
					//[결론] default를 쓰자
			days = 31;
			break;
		}			
		System.out.println(month + "월은 " + days + "일까지 있습니다.");
	}
}

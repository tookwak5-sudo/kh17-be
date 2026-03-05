package condition3;

import java.util.Scanner;

// 사용자에게 '월'을 입력받아서 해당하는 월이 몇일까지 있는지 구하여 출력하는 프로그램 만들기
//(단, 2월은 28일로 고정)
//--------------------
//다 하고 시간이 남으신 분은 '연도'를 입력받아 윤년을 계산하여 2월이 28일인지 29일인지 판정하여 나올 수 있도록 만들기

public class Test02날짜계산기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("월 : ");
		int month = sc.nextInt();
		System.out.print("년 : ");
		int year = sc.nextInt();
		
		//처리
		
		int day = 0;
		boolean thirtyOne = (month <=7 && month%2 !=0) || (month >7 && month %2 == 0);
		boolean thirty = month > 2;
		boolean leap = (year % 400 == 0) || ((year % 100 !=0) && (year % 4 ==0));
		
		if(thirtyOne) { // 31일인 달
			day = 31;
		}
		else if(thirty){
			day = 30;
		}
		else {
			if(leap) {
				day = 29;
				System.out.println(year +"년 2월은 윤년입니다.");
			}
			else {
				day = 28;
			}			
		}
					
		//출력
		System.out.println(month + "월은 " + day + "일까지 있습니다.");
	}
}

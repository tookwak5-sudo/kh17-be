package condition3;

import java.util.Scanner;

// 사용자에게 '월'을 입력받아서 해당하는 월이 몇일까지 있는지 구하여 출력하는 프로그램 만들기
//(단, 2월은 28일로 고정)
//--------------------
//다 하고 시간이 남으신 분은 '연도'를 입력받아 윤년을 계산하여 2월이 28일인지 29일인지 판정하여 나올 수 있도록 만들기

public class Test02날짜계산기2 {
	public static void main(String[] args) {
		//입력
		
		System.out.print("월 : ");
		int month = 3; // 계산이 가능하므로 숫자
		System.out.print("년 : ");
		int year = 1;
		
		//처리
		
		int days;
		switch(month) {
	//	case 1, 3, 5, 7, 8, 10, 12: 자바 12부터 생긴 문법
	//	case 1: case 3: case 5: case 7: case 8: case 10: case 12: // 자바 11이하 문법은 이렇게
	// switch는 불규칙일 때 if문보다 좋을 때가 있다.		
		case 2: 
			days = 28;
			break;
		case 4: 	case 6:	case 9: case 11:
			days = 30;
			break;
		default:
			days = 31;
			break;
		}		
		//출력
		// 숫자 : 계산을 위한 값 
		// 날짜 : 20260305 x2했을 때 의미가 있으면;; 숫자

		System.out.println(month + "월은 " + days + "일까지 있습니다.");
	}
}

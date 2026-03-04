package io;
import java.util.Scanner;
//사용자에게 '출생년도'와 '월'을 입력받습니다.
//원래 만나이는 생일이 되어야만 1살로 인정하지만 난이도를 낮추기 위해서
//태어난지 12개월이 되면 1살인걸로 변경해서


//위 방식대로 사용자의 만 나이를 구하여 출력하세요.
//연도 입력 해
//2025
//월 입력 해
//3

//만 나이 : 1세 (12개월)

public class Test03만나이계산기 {
	public static void main(String[] args) {
		
		int birthYear = 2025;
		int birthMonth = 4;
		
		int year = 2026;
		int month = 3;
		
		int diffYear = year - birthYear;
		int diff= diffYear * 12 + month - birthMonth;  
	
		int globalAge = diff / 12;
		
		System.out.println("만 나이 :" + globalAge + "세 (" + diff + ")");
		
		/*
		//입력
		Scanner sc = new Scanner(System.in); //sc = 통로 : 에너지가 굉장히 많이 드는 도구 (전기 엄청 잡아먹는 전자제품)
		
		System.out.print("출생년도 4자리 입력 : ");
		int year = sc.nextInt();
		System.out.print("출생월 (1~12) 입력 : ");
		int month = sc.nextInt();
		
		//처리
		int currentYear = 2026;
		int currentMonth = 3;
		
		int total = year * 12 + month;
		int current = currentYear * 12 + currentMonth;
		
		int diff = current - total; // 개월 수
		int globalAge = diff/12;
			
		//출력
		System.out.println("만 나이: " + globalAge + "세  (" + diff + " 개월)" );
		*/
	}
}

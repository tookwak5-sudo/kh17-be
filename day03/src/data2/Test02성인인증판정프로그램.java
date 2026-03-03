package data2;

//이 사용자의 생년월일에서 '연도'만 추출하여 나이를 계산하고 성인인지 아닌지 판정하여 출력
//출력정보 1. 나이 출력  2. 성인 여부 판정 후 출력


public class Test02성인인증판정프로그램 {
	public static void main(String[] args) {
		/*
		//입력
		int now = 20260303;
		int year = 20080409;
		
		//처리
		// -나이 : 태어낸 해부터 현재까지 거쳐온 년도, == 현재년도 - 탄생년도 + 1 == 구간 내 숫자의 개수
		int yearNow = now / 10000; //현재 년도
		int birthYear = year / 10000; // 탄생 년도
		//System.out.println(yearNow);
		//System.out.println(birthYear);
		
		int age = yearNow - birthYear + 1; 		
		boolean adult = age >= 20;
		
		//출력
		System.out.println(age); //나이출력
		System.out.println(adult); // 성인여부 판정 후 출력
		*/
		
		//입력
		int user = 20070303;
		
		//처리
		int year = user / 10000;
		int age = 2026 - year + 1;
		boolean adult = age >= 20;
		
		//출력
		System.out.println(age);
		System.out.println(adult);
		
	}
}	

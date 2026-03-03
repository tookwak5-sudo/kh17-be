package data2;
//한국에서는 다음에 해당하는 사람이 의무적으로 건강검진을 받아야 합니다.
//1. 30세 이상
//2. 짝수년도 출생자 + 짝수년도에 
//3. 홀수년도 출생자 + 홀수년도에

// 어떤 사람의 출생년도와 현재년도가 주어질 때, 건강검진 대상자인지 판정해서 출력
//-(ex) 1998년생은 건강검진 대상자-> false


public class Test07건강검진대상자 {
	public static void main(String[] args) {
		/*
		//입력
		int myBirth = 1994;
		int yearNow = 2025;
		
		int myAge = yearNow - myBirth + 1;
		int birth = myBirth%2;
		int year = yearNow%2;
		
		//처리
		
		boolean evenAge = (myAge >= 30) && (year == 0) && (birth == 0);// 나이가 30세 이상
		boolean oddAge = (myAge >= 30) && (year != 0) && (birth != 0);
		boolean age = evenAge || oddAge;
		
		boolean age = (myAge >=30) && (year == birth);
		//boolean mybirth = birth / 2 == 0; // 짝수년도 출생자일 경우
		//boolean checkYear = year / 2 == 0; // 현재 년도가 짝수년도 일경우
		//실행
		//System.out.println(myAge); 
		//System.out.println(year);
		System.out.println(age);
		
		*/
		//계산 결과만 가지고 조합
		
		//입력
		int birth = 1994;
		int year = 2026;
		
		int age = year - birth + 1; // 한국 나이 계산
		
		
		boolean over30 = age >=30;    //true ? false?
		boolean birthEven = birth % 2 == 0; //ture? false?
		boolean birthOdd =!birthEven; // == !birthEven
		boolean yearEven = year % 2 == 0; //true/false
		boolean yearOdd = !yearEven; // == !yearEven 
		
		//boolean result = 30세이상 && (나머지조건들);
		//boolean result = //30세 이상 && ((짝수년도생 + 짝수년도) || (홀수년도생 + 홀수년도))
		//boolean result = over30 && ((birthEven && yearEven) || (!birthEven && !yearEven));
		boolean result = over30 && ((birthEven && yearEven) || (birthOdd && yearOdd));
		System.out.println(result);
	}
}

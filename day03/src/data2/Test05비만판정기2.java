package data2;

import java.util.Scanner;

public class Test05비만판정기2 {
	public static void main(String[] args) {
		//사용자에게 키(cm)와 체중(kg)을 입력받아(직접입력) 체질량지수(BMI) 수치를 계산하고 과체중 여부 판단.		
		// - 키 180cm, 체중 80kg인 사람의 BMI 수치를 구하여 출력하고 과체중을 판정하여 출력		
		// BMI 수치 =  체중(kg) / 키(m^2);
		/*
		//입력
		double heigh = 1.8; // cm 1.8m
		int weight = 80; 
		//처리
		double bmi = (double) weight / (heigh*heigh); //m^2이므로 1만 곱해주기
		boolean overWeigh = (bmi >= 23) && (bmi <= 24.9);
		//출력
		System.out.println(bmi); // BMI 수치
		System.out.println(overWeigh); // 과체중 여부
		*/
		Scanner sc = new Scanner(System.in);
		
		System.out.println("키(cm) 입력하세용");
		// 1번 문제 : 키와 몸무게를 이용하여 bmi 수치 구하기
		double cm = sc.nextDouble();
		
		System.out.println("체중(kg)을 입력하세용");
		//double cm = 1.8 --> 잘못된 코드 반드시 사용자가 입력하는 형태를 지켜야함
		double kg = sc.nextDouble();  // 근거만 있다면 변수는 원하는 대로 설정 가능
		
		//double bmi = kg / 키^2
		//double bmi = kg / ((cm/100) * (cm/100)); // 이렇게도 가능하나 너무 복잡함
		
		double m = cm /100;
		double m2 = m*m;  
		double bmi = kg / m2; // kg / m / m // kg / (m*m)
		System.out.println(bmi);
		
		// 2번문제 : bmi 수치로 과체중 판별하기
		boolean overWeigh = (bmi >= 23) && (bmi <= 24.9);
		System.out.println(overWeigh); // 과체중 여부
 	}
}

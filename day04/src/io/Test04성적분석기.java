package io;

import java.util.Scanner;

//자바마스터 라는 시험은 총 3개의 과목을 응시해서 다음 기준에 부합하면 합격입니다.
//각 과목의 점수가 40점 이상일 것
//평균이 60점 이상일 것
//사용자에게 1과목, 2과목, 3과목의 점수를 입력받아서 합격 여부를 판정하여 출력
//(+그 외 평균 등도 출력해서 보여주세요)
public class Test04성적분석기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);		
		
		System.out.println("과목 1의 점수를 입력하세요");
		int subject1 = sc.nextInt(); 
		System.out.println("과목1 점수: " + subject1);
		
		System.out.println("과목 2의 점수를 입력하세요");
		int subject2 = sc.nextInt();
		System.out.println("과목2 점수: " + subject2);
		
		System.out.println("과목 3의 점수를 입력하세요");
		int subject3 = sc.nextInt();
		System.out.println("과목3 점수: " + subject3);
		
		//처리
		boolean score1 = subject1 >= 40; // 1과목 40점 이상
		boolean score2 = subject2 >= 40; // 2과목 40점 이상
		boolean score3 = subject3 >= 40; // 3과목 40점 이상
		
		boolean score = score1 && score2 && score3; // 각 과목의 점수가 모두 40점 이상
		
		//System.out.println(score);
		
		float avg = (float) (subject1 + subject2 + subject3) / 3;
		
		boolean result = (avg >=60) && score;
		
		
		//출력
		System.out.println("합격 : " + result + " 평균 : " + avg + "입니다."); // 합격여부 T or F
	}
}

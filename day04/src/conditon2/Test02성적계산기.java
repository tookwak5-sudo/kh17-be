package conditon2;
import java.util.Scanner;
//어느 학교의 내신 평가 기준은 다음과 같습니다.
//- 평균 90점 이상 : A등급
//- 평균 80점 이상 : B등급
//- 평균 70점 이상 : C등급
//- 나머지 : D등급
//사용자에게 국어, 영어, 수학 점수를 입력받아 이 학생의 평균 점수와 등급을 구하여 출력하세요
public class Test02성적계산기 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("국어 점수: ");
		int korean = sc.nextInt();
		System.out.print("영어 점수: ");
		int english = sc.nextInt();
		System.out.print("수학 점수: ");
		int math = sc.nextInt();		
		//처리
		int total = korean + english + math;
		double avg = (double) total / 3;
		String grade;  // character도 가능하지만 A+이런 등급이 있을 수도 있기 때문에 String으로 자료형 선택
		// 입출력을 최대한 깔끔하게 하는 것 = 모듈화
		//if문이 1줄만 있으면 괄호 생략 가능
		if(avg >= 90) 			 grade = "A"; 		
		else if(avg >= 80)	 grade = "B";	
		else if(avg >= 70) 	 grade = "C";		
		else 						 grade = "D";		
		//출력
		System.out.println("평균 : " + avg + "점"); // 평균점수
		System.out.println("등급 : " + grade); // 등급		
	}
}

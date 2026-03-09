package array;

import java.util.Scanner;

//실습 문제 (Test03점수분석기)
//프로그램을 실행하면 학생 다섯명의 점수를 입력받도록 프로그래밍 하고 입력 후 다음 정보를 출력해보세요
//
//모든 학생의 개별 점수
//90점 이상인 학생의 인원수
//60점 미만인 학생의 인원수
//다섯 명의 평균 점수
public class Test03점수분석기 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String[] students = new String[] {"A", "B", "C", "D", "E"};
		
	//	int[] scoreList = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
		int count90 = 0;
		int count60 = 0;
		int sum = 0;
		
		for(int i = 0; i < students.length; i++) {
			System.out.println("학생 " + students[i] + "의 점수는 : ");
			int[]  scoreList = new int[] {sc.nextInt()};
 			if(scoreList[i] >= 90) {
				count90++;
			}	
			if(scoreList[i] < 60) {
				count60++;
			}
			sum +=scoreList[i];
		}
		double avg = (double) sum / students.length;
		
		System.out.println("90점 이상인 학생의 인원 수 : " + count90 + "명");
		System.out.println("60점 미만인 학생의 인원 수 : " + count60 + "명");
		System.out.println(students.length +"명의 평균 점수 : " + avg + "점");
	}
}

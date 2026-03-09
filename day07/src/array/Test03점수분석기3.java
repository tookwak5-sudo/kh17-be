package array;


//실습 문제 (Test03점수분석기)
//프로그램을 실행하면 학생 다섯명의 점수를 입력받도록 프로그래밍 하고 입력 후 다음 정보를 출력해보세요
//
//모든 학생의 개별 점수
//90점 이상인 학생의 인원수
//60점 미만인 학생의 인원수
//다섯 명의 평균 점수
public class Test03점수분석기3 {
	public static void main(String[] args) {
		// 배열 없이 문제풀기
		
		// - 다섯 명의 점수를 저장할 변수 생성
		int[] scoreList = new int[] {80, 50, 95, 91, 72};
		
		// - 모든 학생의 개별 점수 // 문제마다 반복문을 따로따로 작성해주기 // 개발자에게 가장 중요한게 모듈화
		for(int i =0; i < scoreList.length; i++) {
			System.out.println("개별점수 : " + scoreList[i]);			
		}		
		//- 90점 이상 학생의 인원수
		int great = 0;
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] >= 90) great++;
		}
		
		System.out.println("90점 이상 인원수 : " + great);
		
		// -60점 미만 학생의 인원수
		int bad = 0;
		for(int i = 0; i < scoreList.length; i++) {
			if(scoreList[i] < 60) bad++;
		}
		System.out.println("60점 미만 인원수 : " + bad);
		
		// - 평균 점수
		int total = 0;
		for(int i = 0; i < scoreList.length; i++) {
			total +=scoreList[i];
		}
		double average = (double) total / scoreList.length;
		System.out.println("평균 점수 : " + average);
	}
}

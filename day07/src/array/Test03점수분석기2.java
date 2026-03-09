package array;


//실습 문제 (Test03점수분석기)
//프로그램을 실행하면 학생 다섯명의 점수를 입력받도록 프로그래밍 하고 입력 후 다음 정보를 출력해보세요
//
//모든 학생의 개별 점수
//90점 이상인 학생의 인원수
//60점 미만인 학생의 인원수
//다섯 명의 평균 점수
public class Test03점수분석기2 {
	public static void main(String[] args) {
		// 배열 없이 문제풀기
		
		// - 다섯 명의 점수를 저장할 변수 생성
		int a = 80, b = 50, c = 95, d = 91, e = 72;
		
		// - 모든 학생의 개별 점수
		System.out.println("개별점수 : " + a);
		System.out.println("개별점수 : " + b);
		System.out.println("개별점수 : " + c);
		System.out.println("개별점수 : " + d);
		System.out.println("개별점수 : " + e);
		
		//- 90점 이상 학생의 인원수
		int great = 0;
		if(a >= 90) great++;
		if(b >= 90) great++;
		if(c >= 90) great++;
		if(d >= 90) great++;
		if(e >= 90) great++;
		
		System.out.println("90점 이상 인원수 : " + great);
		
		// -60점 미만 학생의 인원수
		int bad = 0;
		if(a < 60) bad++;
		if(b < 60) bad++;
		if(c < 60) bad++;
		if(d < 60) bad++;
		if(e < 60) bad++;
		System.out.println("60점 미만 인원수 : " + bad);
		
		// - 평균 점수
		int total = a + b + c + d + e;
		double average = (double) total / 5;
		System.out.println("평균 점수 : " + average);
	}
}

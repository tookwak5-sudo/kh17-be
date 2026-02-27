package data;

public class Test06평균계산기 {
		public static void main(String[] args) {
			
			//입력
			int kor = 50;
			int eng = 65;
			int mat = 70;
			
			//처리
			int sum = kor + eng + mat;
			//double avg = sum / 3; // 정수끼리 나눠서 문제
		    //double avg = sum / 3.0;
			//double avg = sum / 3d;
			double avg = (double)sum / 3; // 변환연산(cast) -오른쪽에 있는 것을 바꿔버림
			// 변수로 있더라도 형태를 바꿔버릴 수 있음
			
			//출력
			System.out.println(sum);
			System.out.println(avg);
					
		}
}

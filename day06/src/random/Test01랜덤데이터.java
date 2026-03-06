package random;

import java.util.Random;

public class Test01랜덤데이터 {
	public static void main(String[] args) {
		//랜덤(Random) 데이터
		// - 어느 데이터가 나올지 예측이 불가능한 값
		//- 범위는 알 수 있음 (사람과 다르게 ?부터 ?개로 설정)
		//- 생성하는 방법에는 여러가지 가 있음
		// -완벽한 랜덤은 없다!
		// - 주사위, 동전, 로또, 아이템뽑기... (대부분 정수)
		
		// 방법1 : Math.random() 명령 사용
		//System.out.println(Math.random());
//		double a= Math.random(); //0이상 1미만 doulbe  // 랜덤 + 범위가 있어야함
//		double b = a*6; // 0이상 6미만 double
//		int c = (int) b; // 0이상 6미만 int (0,1,2,3,4,5)
//		int d = c + 1; // 1이상 7미만 int
		
		int d = (int)(Math.random()*6) +1; // 1부터 6개 
		System.out.println(d);
		//주사위 : 1~6, int
		
		// 방법2 : 랜덤 생성 도구를 만들어서 사용 (앞으로 사용할 방법)
		Random r = new Random(); //r이 리모컨 Scanner sc의 sc처럼
		int dice = r.nextInt(6) + 1;// 주사위 괄호 안은 개수 +1은 시작 범위
		System.out.println("dice =" + dice);
		
		
	}
}

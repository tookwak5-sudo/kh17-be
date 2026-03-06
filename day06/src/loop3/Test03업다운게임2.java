package loop3;

import java.util.Random;
import java.util.Scanner;

//컴퓨터가 1~1000 사이에서 랜덤한 정답을 생성한 뒤 사용자에게 이를 맞추도록 하는 게임을 구현하려고 합니다.
//사용자에게는 정답을 보여주지 않고 정답을 맞출 수 있는 힌트만 다음과 같이 제공합니다.
//업 : 사용자가 입력한 값보다 정답이 더 클 경우에는 업이라고 출력합니다
//다운 : 사용자가 입력한 값보다 정답이 더 작을 경우에는 다운이라고 출력합니다
//정답 : 사용자가 입력한 값이 정답인 경우에는 정답이라고 알려주고 프로그램을 종료합니다
//종료 시 몇 번의 시도만에 정답을 맞췄는지 구하여 출력하세요
public class Test03업다운게임2 {
	public static void main(String[] args) {
		Random r = new Random();
		int answer = r.nextInt(1000) + 1;
	//	System.out.println("정답 : " + answer);
		
		// - 횟수 카운트 추가
		int count = 0;
		// 1회의 업다운 게임
		// - 정답생성 1부터 1000까지

		Scanner sc = new Scanner(System.in);
		while(true) {
			// - 사용자 입력
			System.out.println("정답 입력 : ");
			int user = sc.nextInt(); // 괄호안에 숫자를 넣으면 16 -> 16진수 / 8-> 8진수 등으로 변경이됨
			
			count++; // 업,다운, 정답 모든 경우를 카운트
			
			if(answer > user) { //정답이 입력값보다 큰 경우
				System.out.println("업");
			}
			else if(answer < user) { // 정답이 입력값보다 작은 경우
				System.out.println("다운");
			}
			else {// 같은경우
				System.out.println("정답");
				break; // 탈출조건
			}
		}
		
		System.out.println("총" + count + "번 만에 맞추셨습니다."); // else에 써도 무방
	}
}
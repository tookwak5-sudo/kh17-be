package loop3;

import java.util.Random;
import java.util.Scanner;

//컴퓨터가 1~1000 사이에서 랜덤한 정답을 생성한 뒤 사용자에게 이를 맞추도록 하는 게임을 구현하려고 합니다.
//사용자에게는 정답을 보여주지 않고 정답을 맞출 수 있는 힌트만 다음과 같이 제공합니다.
//업 : 사용자가 입력한 값보다 정답이 더 클 경우에는 업이라고 출력합니다
//다운 : 사용자가 입력한 값보다 정답이 더 작을 경우에는 다운이라고 출력합니다
//정답 : 사용자가 입력한 값이 정답인 경우에는 정답이라고 알려주고 프로그램을 종료합니다
//종료 시 몇 번의 시도만에 정답을 맞췄는지 구하여 출력하세요
public class Test03업다운게임 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int count = 0; //사용자가 시도한 횟수
		
		int number = r.nextInt(1000) + 1; // 컴퓨터가 랜덤으로 정한 숫자
		System.out.println("컴퓨터가 랜덤으로 부여한 숫자 : " + number);
		while(true) {	
			System.out.println("<숫자를 입력하세요>");
			int user = sc.nextInt(); // 사용자가 입력한 숫자		
			count++;
			if(number > user) {
				
				System.out.println("업");
			}
			else if(number < user) {
				System.out.println("다운");
			}
			else {
				System.out.println("정답");
				break;
			}	
			System.out.println("-----------------");
		}
		System.out.println("시도 횟수 : " + count + "번");
	}
}
package random;

import java.util.Random;
import java.util.Scanner;

//다음 단계별로 구구단 게임을 완성하세요
//
//화면에 무작위 구구단 문제를 10개 출력하세요
//사용자의 입력을 추가하여 문제 1개 출력 후에 사용자가 정답을 입력할 수 있도록 처리하세요
//정답과 오답의 개수를 카운트하여 출력하세요
public class Test02구구단게임 {
	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int count = 1;
		int correct = 0;
		int inCorrect = 0;
		
		for(int i = 0; i < 10; i++) {
			int dan = r.nextInt(8) + 2; // 2단~9단
			int time = r.nextInt(9) + 1;  // 1~9
			System.out.print(count +"번 : " +dan + "x" + time + "=");
			
			count++;
			int result = dan*time;
			int answer = sc.nextInt();
			
			if(answer == result) {
				System.out.println("정답");
				correct++;
			}
			else {
				System.out.print("오답");
				inCorrect++;
			}
		}
		System.out.println("<게임 결과>");
		System.out.println("정답 : " + correct + "개");
		System.out.println("오답 : " + inCorrect + "개");
		
	}
}

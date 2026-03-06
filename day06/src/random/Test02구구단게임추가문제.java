package random;

import java.util.Random;
import java.util.Scanner;

//다음 단계별로 구구단 게임을 완성하세요
//
//화면에 무작위 구구단 문제를 10개 출력하세요
//사용자의 입력을 추가하여 문제 1개 출력 후에 사용자가 정답을 입력할 수 있도록 처리하세요
//정답과 오답의 개수를 카운트하여 출력하세요

//라운드를 설정해서 문항수를 라운드x10만큼으로 변경
//정답, 오답 카운트 대신 3번 틀리면 종료되도록 변경
//문제 1개당 10점으로 카운트하여 점수 계산
//연속해서 문제를 맞추는 경우 콤보를 계산
//문제를 맞춰서 얻는 점수에 콤보를 반영 (ex : 이번에 맞춘 문제가 2콤보라면 2x10=20점 획득)
public class Test02구구단게임추가문제 {
	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int round = 1; // 라운드
		int problemCount  = round * 10; // 문제 1개당 점수
		int wrongCount = 0; // 오답 개수
		//int correct = 0; //정답 개수
		int score =0; // 점수
		int combo = 0; // 콤포
		int baseScore = 10;
		
		for(int i = 1; i <= problemCount; i++) {
			int dan = r.nextInt(8) + 2; // 2단~9단
			int num = r.nextInt(9) + 1;  // 1~9
			int result = dan*num;
			
			System.out.print("[" + round + "라운드] "+ i +"번 문제 " + dan + "x" + num + "=");
			int answer = sc.nextInt();
			
			if(answer == result) { //정답
				//System.out.println("정답");
				//correct++;
				combo++;			
				score += combo * baseScore;	
				System.out.println("정답!");
				
				if(combo >= 2) {					
					System.out.print("★".repeat(combo));
				}
			}
			else { //오답
				//System.out.println("오답");
				wrongCount++;
				combo = 0;
				System.out.println("오답!");
				if(wrongCount >=3) {
					System.out.println("3번 틀려서 GAME OVER.");
					break;
				}
			}
			
		}
		
		System.out.println("최종점수 : " + score);
		//System.out.println("정답 : " + correct + "개");
	   //System.out.println("오답 : " + inCorrect + "개");
		
	}
}

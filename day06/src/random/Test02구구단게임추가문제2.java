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
public class Test02구구단게임추가문제2 {
	public static void main(String[] args) {
		
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		int correct = 0;
		int inCorrect = 0;
		int round = 1;
		int size = round * 10;
		int life = 3;
		//콤포는 0으로 초기화 될 수 있는 카운트
		int combo = 0; //콤보 카운트
		
		System.out.println("라운드 : " + round + "(" + size + "문항)");
		for(int i = 1; i <= size; i++) {			
			int left = r.nextInt(8) + 2;
			int right = r.nextInt(9) + 1;
			System.out.print(i + ". " + left + "x" + right + "=");
			
			int user = sc.nextInt();
		
			//boolean correct = left*right == user;
			if(left*right == user) {//정답이라면
				//System.out.println("정답");
				combo++; // 맞추면 +1
				if(combo >= 2) {
					System.out.println(combo + "콤보");
				}
			}
			else {//오답이라면
				//System.out.println("오답");
				combo = 0;
				life--; //기회 감소
				if(life ==0) { //기회가 없으면 나가세용
					break; //저리가!
				}
			}
		}

		if(life > 0) {
			System.out.println("클리어");
		}
		else {
			System.out.println("게임 오버");
		}
//		System.out.println("정답 개수 : " + correct + "개");
//		System.out.println("오답 개수 : " + inCorrect + "개");
	}
}

package random;

import java.util.Random;
import java.util.Scanner;

//다음 단계별로 구구단 게임을 완성하세요
//
//화면에 무작위 구구단 문제를 10개 출력하세요
//사용자의 입력을 추가하여 문제 1개 출력 후에 사용자가 정답을 입력할 수 있도록 처리하세요
//정답과 오답의 개수를 카운트하여 출력하세요
public class Test02구구단게임2 {
	public static void main(String[] args) {
		//주의!!! 도구는 반복문 바깥으로 빼야한다(why? 낭비가 심하기 때문에)
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		//카운트 추가
		int correct = 0;
		int inCorrect = 0;
		
		for(int i = 1; i <= 10; i++) {			
			int left = r.nextInt(8) + 2;
			int right = r.nextInt(9) + 1;
			System.out.print(left + "x" + right + "=");
			
			int user = sc.nextInt();
			
			//boolean correct = left*right == user;
			if(left*right == user) {//정답이라면
				//System.out.println("정답");
				correct++;
			}
			else {//오답이라면
				//System.out.println("오답");
				inCorrect++;
			}
		}
			
		System.out.println("<게임 결과>");
		System.out.println("정답 개수 : " + correct + "개");
		System.out.println("오답 개수 : " + inCorrect + "개");
	}
}

package loop4;

import java.util.Scanner;

public class Test01선실행후반복 {
	public static void main(String[] args) {
		// do-while :
		// 한번 실행을 한 뒤 반복 여부를 결정하는 형태의 반복문
		// -do {실행코드} while(반복조건);
		
		Scanner sc= new Scanner(System.in);
		
		int score; 
		do {
			System.out.print("점수 입력 :" );
			score = sc.nextInt();
		}
		while(score < 0 || score > 100);
		
		System.out.println("입력된 점수 : " + score);
	}
}

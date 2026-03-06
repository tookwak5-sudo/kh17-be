package loop3;

import java.util.Random;

public class Test01무한반복 {
	public static void main(String[] args) {
		//무한반복 
		// - 영원히 끝나지 않는 반복 (X)
		// -  특정 시점까지만 실행되는 반복 (O)
		// - 횟수나 범위를 모름
		// -(ex) 주사위를 6이 나올때까지 던지세요
		// - 주사위 2개를 같은 값이 나올 때까지 던지세요;
		
		Random r = new Random();
		
		while(true) {
			int dice1 = r.nextInt(6) + 1;
			int dice2 = r.nextInt(6) + 1;
			System.out.println("주사위1 = " + dice1 + " & " + dice2);
			System.out.println("---------------");
			//탈출 조건 : dice1과 dice2의 값이 같을 경우
			if(dice1 == dice2) {
				break;
			}
		}
	}
}


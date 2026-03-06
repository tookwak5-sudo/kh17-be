package random;

import java.util.Random;

public class Test01랜덤데이터2 {
	public static void main(String[] args) {
		
		Random r = new Random(); //r이 리모컨 Scanner sc의 sc처럼
		
		//(Q) 로또번호 1개를 추첨하여 출력
		//입력
		//처리
		int lotto = r.nextInt(45) +1;
		//출력
		System.out.println("로또번호 : " + lotto);
		// (Q)8자리 otp번호를 추첨(반드시 8자리여야함)
		// 10000000부터 99999999까지 (10000000 부터 시작하여 90000000개)
		int otp = r.nextInt(90000000) + 10000000;
		System.out.println("OTP 번호 : " + otp);
		
		
	}
}

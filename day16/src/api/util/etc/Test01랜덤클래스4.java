package api.util.etc;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import java.util.UUID;

public class Test01랜덤클래스4 {
	public static void main(String[] args) {
		Random r = new Random();
		
		//시드를 조작해서 OTP번호 생성(10초간 동일)
		//- 이용자가 여러명일 경우 각자 다른 시드가 나와야함(이 역할을 보통 일련번호가 함)
//		String user1 = UUID.randomUUID().toString();// 랜덤 시리얼 번호(중복없음)
//		String user2 = UUID.randomUUID().toString();
		String user1 = "613e2a70-f51a-4c99-b6f6-988363ab9c1c";
		String user2 = "ae648044-d657-4b3e-aa70-05f57a87912b";
		System.out.println("user1 : " +user1);
		System.out.println("user2 : " +user2);
		
		//시드 역시 두개로 나눠서 생성
		int second = 5;
		long seed1 = user1.hashCode() + System.currentTimeMillis() / (second * 1000);
		long seed2 = user2.hashCode() + System.currentTimeMillis() / (second * 1000);
		r.setSeed(seed1);
		int otp1 = r.nextInt(1000000) + 0;
		r.setSeed(seed2);
		int otp2 = r.nextInt(100000) + 0;
		DecimalFormatSymbols symbol = new DecimalFormatSymbols();
		symbol.setGroupingSeparator(' ');
		DecimalFormat f = new DecimalFormat("000,000", symbol); 
		
		System.out.println("OTP =" + f.format(otp1));
		System.out.println("OTP =" + f.format(otp2));
	}
}

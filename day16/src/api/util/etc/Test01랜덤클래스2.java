package api.util.etc;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

public class Test01랜덤클래스2 {
	public static void main(String[] args) {
		//Random 클래스
		//-초기값(시드, seed_을 이용해서 어떤 계산을 통해 원하는 범위의 랜덤데이터를 만드는 클래스
		//- 유사 랜덤 데이터를 생성
		
		Random r = new Random();
		
		
		//시드를 조작해서 OTP번호 생성(10초간 동일)
		long time = System.currentTimeMillis();
		r.setSeed(time / 10000);
		
		int otp = r.nextInt(1000000) + 0;
		int dice2 = r.nextInt(6) + 1;
		
		Format f = new DecimalFormat("000000"); // 무조건 6개
//		System.out.println("otp =" + otp);
		System.out.println("otp =" + f.format(otp));
 		
	}
}

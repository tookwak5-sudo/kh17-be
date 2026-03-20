package api.util.etc;

import java.util.Random;

public class Test01랜덤클래스 {
	public static void main(String[] args) {
		//Random 클래스
		//-초기값(시드, seed_을 이용해서 어떤 계산을 통해 원하는 범위의 랜덤데이터를 만드는 클래스
		//- 유사 랜덤 데이터를 생성
		
		Random r = new Random();
		
		
		//시드 설정
		//- 시드를 설정하니까 랜덤이 똑같이 나온다는 사실을 알게되었다
		//-일정 시간 동안 똑같은 랜덤값이 나오게도 할 수 있을까?
		//-10초동안 같은 시드를 유지하려면 
		// - 10ch(60000ms)동안 동일한 시드를 유지하려면?
		long time = System.currentTimeMillis();
		r.setSeed(time / 10000);
		
		int dice1 = r.nextInt(6) + 1;
		int dice2 = r.nextInt(6) + 1;
		
		System.out.println("dice1 =" + dice1);
		System.out.println("dice2 =" + dice2);
 		
	}
}

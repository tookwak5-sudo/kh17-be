package conditon2;

public class Test01그룹조건 {
	public static void main(String[] args) {
		// 3개 이상의 조건
		// - 피자 가격이 (1)많이 비싼지, (2)그냥 비싼지, (3)적당한지, (4)싼지 구분

		// 입력 // 4가지 경우는 3번만 물어서 답을 구하기 가능 // 질문을 순서대로 하기 때문에 질문의 순서가 중요
		int pizza = 12000;

		// 출력
		if (pizza >= 30000) {
			System.out.println("엄청비싸..");
		} 
		else if (pizza >= 25000) {
			System.out.println("비싼데?");
		} 
		else if (pizza >= 15000) {
			System.out.println("나쁘지 않은데");
		} 
		else {
			System.out.println("대박인데?");
		}

	}
}

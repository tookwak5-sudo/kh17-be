package loop;
//삼육구게임은 숫자에 3, 6, 9가 포함되어 있다면 해당 숫자가 포함된 개수만큼 박수를 치는 게임입니다. 
//그렇지 않은 숫자는 그냥 숫자를 말하는 게임입니다.
//1부터 순서대로 진행을 하며 상황에 맞는 멘트를 하도록 규칙이 정해져 있습니다.
//1부터 99까지 369게임을 시뮬레이션한 결과를 출력하세요
public class Test04삼육구게임 {
	public static void main(String[] args) {
		for(int i = 1; i<= 99; i++) {
			int ten = i/10%3;
			int one = i%10%3;
			if(ten ==0 && one == 0) {
				System.out.println("짝짝");			
			}
			else if(ten == 0 || one ==0) {
				System.out.println("짝");
			}
			else {
				System.out.println(i);
			}
		}
//		for(int i = 1; i<= 99; i++) {
//			int ten = i/10%3;
//			int one = i%10%3;
//			if(one == 0) {
//				System.out.println("짝");
//			}
//			else if(ten == 0){
//				System.out.println("짝");
//			}
//			else {
//				System.out.println(i);
//			}
//		}
	}
}


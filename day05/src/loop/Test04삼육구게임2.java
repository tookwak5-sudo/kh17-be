package loop;
//삼육구게임은 숫자에 3, 6, 9가 포함되어 있다면 해당 숫자가 포함된 개수만큼 박수를 치는 게임입니다. 
//그렇지 않은 숫자는 그냥 숫자를 말하는 게임입니다.
//1부터 순서대로 진행을 하며 상황에 맞는 멘트를 하도록 규칙이 정해져 있습니다.
//1부터 99까지 369게임을 시뮬레이션한 결과를 출력하세요
public class Test04삼육구게임2 {
	public static void main(String[] args) {
//	1. 1부터 99까지의 범위를 설정
// 2. 범위 내에서 3,6,9가 들어간 숫자 출력
		
		for(int i = 1; i<= 99; i++) {
		//	if() { // 3,6,9가 들어있다면 출력
			boolean three = i/10 == 3 || i % 10== 3;
			boolean six = i/10 == 6 || i % 10 == 6;
			boolean nine = i/10 == 9 || i % 10 == 9;
			
			if(three || six || nine) {	
				System.out.println("짝");	
			}
			else {
				System.out.println(i);
			}
		}
		
	}
}


package loop3;

import java.util.Scanner;

//모래성 게임은 모래에 깃발을 꼽아두고 모래를 깃발이 넘어지지 않게 가져가는 게임입니다.
//이걸 숫자로 구현하기 위해서 다음과 같이 규칙을 변경합니다.
//최초에 100이라는 값을 설정하고 이것을 모래로 간주합니다.
//사용자는 1부터 9사이의 숫자를 입력합니다.
//입력한 값만큼 모래로 설정한 숫자에서 차감합니다.
//마지막 모래, 즉 0을 가져가는 사람이 패배하도록 처리합니다.
//사용자가 1부터 9 사이가 아닌 다른 숫자를 입력하면 그 턴은 스킵합니다.
public class Test05숫자모래성게임 {
	public static void main(String[] args) {
		int max = 100; 
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("현재 남은 모래 : " + max);
			System.out.print("숫자입력(1~9) : ");
			int user = sc.nextInt();
			
			if(user < 1) continue;
			if(user > 9) continue;
			// 입력숫자 범위를 1~9까지로  
			for(int i = 1; i <= user; i++) {
				System.out.println(i);
			}
			
			max -= user; // max에서 user을 빼기
			
			if(max <= 0) {
				break;
			}
		}
		System.out.println("패배");
	}
}

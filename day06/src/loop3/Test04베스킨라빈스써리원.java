package loop3;

import java.util.Scanner;

//사용자 2명이 번갈아 숫자를 입력하여 베스킨라빈스 31 게임을 하려고 합니다.
// 이 게임은 31을 외치면 지는 게임 입니다.
// 사용자는 '1', '2', '3', 중에 하나만 입력합니다(몇개의 숫자를 진행시킬 건진만)
// 예를들어 첫 턴에서 사용자가 '2'를 입력하면 (1,2)를 선택한 것으로 간주. 그 다음 사용자가 '3'을 입력하면 (3,4,5)를 선택한 것으로 간주
// 31을 선택하는 사용자가 나올 때까지 반복적으로 입력할 수 있도록 프로그램을 구현 '31'을 선택하게 되면 게임 오버라는 메시지와 함께 프로그램 종료


//다 하고 나서 > 인터넷 검색을 통해서 1,2,3이 아닌 다른 숫자를 입력하면

public class Test04베스킨라빈스써리원 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int number = 0;
			
		while(true) {
			System.out.print("숫자 입력 : ");
			int user = sc.nextInt(); // 유저는 1, 2, 3만 입력이 가능합니다.
			switch(user) {
			case 1: 
			//	System.out.println("1을 입력하셨습니다.");
				number++;
				break;
			case 2:
			//	System.out.println("2를 입력하셨습니다.");
				number += 2;
				break;
			case 3:
			//	System.out.println("3을 입력하셨습니다.");
				number += 3;
				break;
			default:
				System.out.println("다른 숫자를 입력하셨습니다. ");
				continue;
			}
			if(number >= 31) {
				break;
			}
		//	System.out.println("현재까지 누적 숫자는 : " + number);
		}
		
		System.out.println("Game Over");
		
	}
}

package loop3;

import java.util.Scanner;

//사용자 2명이 번갈아 숫자를 입력하여 베스킨라빈스 31 게임을 하려고 합니다.
// 이 게임은 31을 외치면 지는 게임 입니다.
// 사용자는 '1', '2', '3', 중에 하나만 입력합니다(몇개의 숫자를 진행시킬 건진만)
// 예를들어 첫 턴에서 사용자가 '2'를 입력하면 (1,2)를 선택한 것으로 간주. 그 다음 사용자가 '3'을 입력하면 (3,4,5)를 선택한 것으로 간주
// 31을 선택하는 사용자가 나올 때까지 반복적으로 입력할 수 있도록 프로그램을 구현 '31'을 선택하게 되면 게임 오버라는 메시지와 함께 프로그램 종료


//다 하고 나서 > 인터넷 검색을 통해서 1,2,3이 아닌 다른 숫자를 입력하면

public class Test04베스킨라빈스써리원3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = 1; // 기준숫자
		
		while(true) {
			System.out.print("숫자 선택 :");
			int user = sc.nextInt();
			
			// if(user < 1 || user >3) continue; 이 코드도 되지만 가로로 길어짐... 
			if(user < 1) continue; // 이 키워드는 반복의 시작점으로 이동시킴
			if(user > 3) continue;
			
			//System.out.println("숫자를" + user + "개 선택하셨습니다.");
			// 범위 : number ~ number +user -1 까지 출력하고 싶음
			for(int i =number; i < number + user; i++ ) {
				System.out.println(i + "선택");
			}
			
			number +=user; // number에 user을 더한다.
			
			if(number > 31) break;		
		}
		
		System.out.println("게임 오버");
		
	}
}

package api.string;

import java.util.Scanner;

public class Test06쿵쿵따게임2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String given= "화요일";
		System.out.println("[ " + given + " ] 쿵쿵따");
			System.out.println("Your turn");
			
			while(true) {
				String input= sc.next();
				
				//검사코드
				boolean range = input.length() == 3;
				if(range == false) break; 
				
				char last = given.charAt(given.length() - 1);
				char first = input.charAt(0);
				boolean connect = last == first;
				if(connect == false) break;
			}
			System.out.println("GameOver");
	}
}

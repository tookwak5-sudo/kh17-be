package api.string;

import java.util.Scanner;

public class Test06쿵쿵따게임 {
	public static void main(String[] args) {
		System.out.println("Game Start");
		String input= "화요일";
		System.out.println("[ " + input + " ] 쿵쿵따");
		while(true) {
			System.out.println("Your turn");
			Scanner sc = new Scanner(System.in);
			String next = sc.next();
			
			boolean check1 = next.length() == 3;
			int last = input.length() - 1;
			boolean check2 = input.charAt(last) == next.charAt(0); 
			if(check1 && check2) {
				input = next;
				System.out.println(next.length());
			}
			else {
				System.out.println("GameOver");
				break;
			}
		}
	}
}

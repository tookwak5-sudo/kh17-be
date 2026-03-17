package api.string;

import java.util.Scanner;

public class Test06쿵쿵따게임3 {
	public static void main(String[] args) {
		String given= "화요일";
		System.out.println("[ " + given + " ] 쿵쿵따");
			System.out.println("Your turn");
			Scanner sc = new Scanner(System.in);
			String input= sc.next();
			
			boolean range = input.length() == 3;
			System.out.println("세글자 인가요?" + range);			
			char last = given.charAt(given.length() - 1);
			char first = input.charAt(0);
			boolean connect = last == first;
			System.out.println("연결되나요?" + connect);
	}
}

package api.string2;

import java.util.Scanner;

public class Test05이메일검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이메일 입력 : ");
		String email = sc.nextLine();
		String regex = "^[a-z][a-z0-9]{4,19}@[A-Za-z0-9\\-\\.]{1,}\\.[a-z]{2,}$";
		
		boolean valid = email.matches(regex);
		if(valid ) {
			System.out.println("올바른 이메일 형식 입니다");
		}
		else {
			System.out.println("잘못된 이메일 형식 입니다");
		}
	}
}

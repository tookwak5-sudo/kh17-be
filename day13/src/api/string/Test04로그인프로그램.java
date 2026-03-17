package api.string;

import java.util.Scanner;

//사용자에게 아이디, 비밀번호를 입력받아 다음과 같을 경우 로그인 성공 메세지를 출력하고, 아닐 경우 로그인 실패 메세지를 출력하는 프로그램을 구현하세요
//
//아이디 : khacademy (대소문자 무관)
//비밀번호 : 1234
public class Test04로그인프로그램 {
	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
//	
//		String inputId = sc.next();
//		String id = "khacademy";
//		String inputPw = sc.next();
//		String pw = "1234";
//	
//		if(id.equalsIgnoreCase(inputId) && pw.equals(inputPw)) {
//			System.out.println("로그인 성공");
//		}
//		else {
//			System.out.println("로그인 실패");
//		}
		
		// 입력
		String userId = sc.next();
		String userPw = sc.next();
		
		//처리
		//boolean isValid = 아이디가 khacacdemy이고 비밀번호가 1234이면;
		boolean isValid =  userId.equalsIgnoreCase("khacademy") && userPw.equals("1234");
		
		//c출력
		if(isValid) {
			System.out.println("로그인 성공");	
		}
		else {
			System.out.println("정보가 일치하지 않습니다.");
		}
		
		
	}
}

package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//저장소 생성(map)
		Map<String, String> personal = new HashMap<>();
		
		MemberRepository repository = new MemberRepository();
		
		//저장소에 개인정보 저장
		personal.put("testuser", "test1234");
		personal.put("student", "std1234");
		personal.put("admin", "adm1234");
		personal.put("client", "client1234");
		
		//입력했다 가정
		System.out.print("아이디 : ");
		String inputId = sc.nextLine();
		System.out.print("비밀번호 : ");
		String inputPw = sc.nextLine();
		
		if(repository.login(inputId, inputPw)) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("로그인 실패");
		}
	}
}

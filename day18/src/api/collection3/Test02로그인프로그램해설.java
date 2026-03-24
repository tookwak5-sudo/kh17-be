package api.collection3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test02로그인프로그램해설 {
	public static void main(String[] args) {
		//저장소 생성(map)
		Map<String, String> personal = new HashMap<>();
		
		
		//저장소에 개인정보 저장
		personal.put("testuser", "test1234");
		personal.put("student", "std1234");
		personal.put("admin", "adm1234");
		personal.put("client", "client1234");
		
		//사용자 입력
		String id = "testuser";
		String pw = "test1234";
		
		//판정
//		boolean login = 아이디 존재 && 비밀번호 일치
//		boolean login = personal.containsKey(id) && personal.containsValue(pw); 잘못된 식 아무 있음직법한 아이디 비밀번호 입력해도 가능
		boolean login = personal.containsKey(id) && personal.get(id).equals(pw); // personal.get(id)아이디에 있는 비밀번호와 비밀번호가 같나요?
		
		if(login) {
			System.out.println("로그인 성공");
		}
		else {
			System.out.println("입력하신 정보가 일치하지 않습니다");
		}
		
	}
}

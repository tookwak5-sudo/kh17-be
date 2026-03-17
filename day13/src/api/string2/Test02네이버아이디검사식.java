package api.string2;

public class Test02네이버아이디검사식 {
	public static void main(String[] args) {
		String userID = "tookwak2";
		//String regex =  "^[a-z][a-z0-9\\-_]{4,19}$"; // 무조건 영문 소문자로 시작
		String regex =  "^[a-z][a-z0-9]{4,19}$";  // 앞으로 사용할 형식(알파벳 소문자 시작 + 숫자포함 5~20자)
		//String regex = "^[가-힣0-9]{1,10}$"; // 추가 문제 : 한글이나 숫자로만 10자리까지
		boolean valid = userID.matches(regex);
		if(valid) {
			System.out.println("멋진 아이디 입니다");
		}
		else {
			System.out.println("사용할 수 없는 아이디입니다. 다른 아이디를 입력해 주세요");
		}
	}
}

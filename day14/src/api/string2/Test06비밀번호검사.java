package api.string2;

public class Test06비밀번호검사 {
	public static void main(String[] args) {
		//비밀번호 검사
		//-반드시 1글자 이상 포함된다는 것을 정규표현식으로 구현해야함
		//-파트별로 검사를 나눠서 하는 방법과 전체를 한번에 하는 방법이 있음
		//- 알파벳 대문자, 소문자, 숫자 ,특수문자를 반드시 1개 포함하여 8~16자로 구현
		
		String password = "Khacademy1!";
		
		String regex1 = "^.*?[A-Z]+.*?$"; //대문자 1개이상
		String regex2 = "^.*?[a-z]+.*?$"; //소문자 1개이상
		String regex3 = "^.*?[0-9]+.*?$";//숫자 1개이상
		String regex4 = "^.*?[\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\=\\+\\[\\]\\{\\}'\\\"\\`\\~\\<\\>\\.\\/\\?\\\\\\|]+.*?$";// 특수문자 1개이상
		String regex5 = "^.*?[A-Za-z0-9\\!\\@\\#\\$\\%\\^\\&\\*\\(\\)\\-\\_\\=\\+\\[\\]\\{\\}'\\\"\\`\\~\\<\\>\\.\\/\\?\\\\\\|]{8,16}.*?$";// 글자수 8~16개
		
		boolean valid1 = password.matches(regex1);
		boolean valid2 = password.matches(regex2);
		boolean valid3 = password.matches(regex3);
		boolean valid4 = password.matches(regex4);
		boolean valid5 = password.matches(regex5);
		
		boolean valid = valid1 && valid2 && valid3 && valid4 && valid5;
		
			System.out.println("1번조건 = " + valid1);
			System.out.println("2번조건 = " + valid2);
			System.out.println("3번조건 = " + valid3);
			System.out.println("4번조건 = " + valid4);
			System.out.println("5번조건 = " + valid5);
	}
}

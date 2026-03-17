package api.string2;

public class Test04생년월일검사3 {
	public static void main(String[] args) {
//		날짜 형식은 YYYY-MM-DD 형식
//		연도(YYYY)는 1900부터 2099까지 설정 가능
//		월(MM)은 01부터 12까지 설정 가능
//		일(DD)은 01부터 31까지 설정 가능

//		월별로 28, 30, 31을 구분하여 설정할 수 있도록 업그레이드 하시기 바랍니다.
//		1. 정규표현식을 3개를 만들자!

		String birth = "2026-03-31";
		String regex1 = "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])$";
		String regex2 = "^(19[0-9]{2}|20[0-9]{2})-(0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30)$";
		String regex3 = "^(19[0-9]{2}|20[0-9]{2})-(0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])$ ";
		//String regex ="^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
		boolean valid = birth.matches(regex1) || birth.matches(regex2) || birth.matches(regex3);// regex.matches(birth)로 순서 잘못쓰지 않도록 주의하기
		 
		System.out.println(valid);
	}
}

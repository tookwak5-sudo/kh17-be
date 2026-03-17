package api.string2;

public class Test01전화번호검사 {
	public static void main(String[] args) {
		//다음 번호가 올바른 휴대전화번호인지 검사하려면?
		String number = "010-1218-3434";
//		String regex = "^010-[123456789][0123456789][0123456789][0123456789]-[0123456789][0123456789][0123456789][0123456789]$";
//		String regex = "^010-[1-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]$";
		String regex = "^010-[1-9][0-9]{3}-[0-9]{4}$";
		boolean valid = number.matches(regex);
		System.out.println("올바른 전화번호 ? " + valid);
	}
}

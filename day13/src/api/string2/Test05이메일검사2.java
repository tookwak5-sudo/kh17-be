package api.string2;

public class Test05이메일검사2 {
	public static void main(String[] args) {
		
		String email = "aaaaa1@..com";
		
		boolean valid = EmailCheck.ValidCheck(email);
		System.out.println(valid);
	}
}

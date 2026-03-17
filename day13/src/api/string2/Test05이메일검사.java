package api.string2;

public class Test05이메일검사 {
	public static void main(String[] args) {
		String email = "aaaaa1@..com";
		String regex = "^[a-z][a-z0-9]{4,19}@[A-Za-z\\-.]{1,}\\.[a-z]{2,}$";
		boolean valid = email.matches(regex);
		System.out.println(valid);
	}
}

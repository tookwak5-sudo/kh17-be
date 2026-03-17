package api.string2;

public class EmailCheck {
	private EmailCheck() {}
	
	public static boolean ValidCheck(String email) {
		
		String regex = "^[a-z][a-z0-9]{4,19}@[A-Za-z\\-.]{1,}\\.[a-z]{2,}$";
		boolean valid = email.matches(regex);
		return valid;
	}
}

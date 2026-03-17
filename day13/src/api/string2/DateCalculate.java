package api.string2;

public class DateCalculate {
	private DateCalculate() {};
	
	public static boolean CheckValid(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		boolean leap = year % 400 == 0 || (year % 4 == 0) && (year % 100 !=0);
		
		
		String regex;
		if(leap) {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";  //28
		}
		else {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$"; //29
		}
		
		boolean valid = date.matches(regex);
		return valid;
	}
}

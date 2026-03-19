package api.exception;

public class DateCalculate {
	private DateCalculate() {}
	
	public static boolean CheckValid(String date) {
		int year = Integer.parseInt(date.substring(0,4));
		boolean leap = year % 4 == 0 && year % 100 !=0 || year % 400 ==0;
		
		String regex;
		if(leap) {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])))$";
		}
		else {
			regex = "^(19[0-9]{2}|20[0-9]{2})-(((02)-(0[1-9]|1[0-9]|2[0-8]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])))$";
		}
		
		boolean valid = date.matches(regex);
		return valid;
	}
	
	public static int calculateDates(String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));
		
		int total = 0;
		for(int i = 0; i < year; i++) {//작년까지
			for(int m = 1; m <= 12; m++) {
				switch(m) {
				case 2:
					boolean leap = i % 4 == 0 && i % 100 !=0 || i % 400 ==0;
					total += leap ? 29 : 28; //if(leap) { total += 29;
					break;
				case 4, 6, 9, 11:
					total += 30; break;
				default:
					total += 31; break;
				}
			}
		}
		//올해 날짜를 계산해서 더한다(month, day만으로 계산 가능, 윤년인지는 year로 판단
		return total;
	}
}

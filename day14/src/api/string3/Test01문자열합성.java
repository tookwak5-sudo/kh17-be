package api.string3;

public class Test01문자열합성 {
	public static void main(String[] args) {
		//문자열 합성과 문제점
		
		//(ex) 별을 10개 만들어보세요
		///String star = "**********";
		String star = "";
//		star +="*";
//		star +="*";
//		star +="*";
//		star +="*";
		///...
		for(int i = 1; i <= 10; i++) {
			star += "*";
		}
		System.out.println(star);
	}
}

package api.string3;

public class Test01문자열합성3 {
	public static void main(String[] args) {
		//문자열 합성과 문제점
		// - 문자열은 불변(immutable)이기 때문에 단순하게 연결만 해도 새로운 문자열이 생김
		// - 가변 문자열 역할을 하는 StringBuffer와 StringBuilder
		//(ex) 별을 10개 만들어보세요
		///String star = "**********";
		StringBuffer star = new StringBuffer();
		long begin = System.currentTimeMillis();
		for(int i = 1; i <= 10000000; i++) {
			star.append("*");
		}
		long end = System.currentTimeMillis();
		
		System.out.println("소요시간 :" + (end-begin) + "ms");
		//System.out.println(star.toString());
	}
}

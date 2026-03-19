package api.lang.etc;

public class Test01수학연산클래스 {
	public static void main(String[] args) {
		//Math 클래스
		//- 생성자가 없는(잠겨있는) 클레스
		// - 객체 생성을 아예 못하거나 아니면 생성 메소드를 제공[팩토리 패턴 or 싱글톤 패턴]하거나 둘 중 하나
		// - Math는 객체 생성을 아예 못하는  케이스(일회용 수학 연산에 특화된 클래스)
		
		//필드
		System.out.println(Math.PI); // 원주율(자바에서 표현 가능한 최대치)
		
		//메소드
		//- 절대값(absolute value) : 차이만 구하고 싶을 때
		int a = 3000;
		int b = 3500;
		//int c = a > b ? a-b : b-a;
		//int c = Math.abs(a-b);
		int c = Math.abs(b-a);
		System.out.println("c =" + c);
		//- 반올림
		System.out.println(Math.round(1.4));
		System.out.println(Math.round(1.5));
		
		//-올림과 버림
		System.out.println(Math.ceil(1.4)); // 올림
		System.out.println(Math.floor(1.4)); // 버림
		
		//-제곱
		System.out.println(Math.pow(2, 10));
		
		//-제곱근(루트)
		System.out.println(Math.sqrt(9));
		
		//- 밑변이 3, 높이가 4인 직각삼각형의 빗변의 길이?
		int f = 3;
		int h = 4;
		int f2 = (int) Math.pow(f, 2);
		int h2 = (int) Math.pow(h, 2);
		int k = f2 + h2;
		double slide = Math.sqrt(k);
		System.out.println(slide);
	}
}

package data3;

public class Test01글자데이터 {
	public static void main(String[] args) {
		//글자 데이터
		// -모든 글자는 번호가 있다 (유니코드 시스템)
		// - 자바는 글자를 char 형태로 표현
		//- 글자인데 정수인 이상한 상황이 발생
		
		char a= '가';
		System.out.println((int)a);
		
		char b = '힣';
		System.out.println(b);
		System.out.println((int)b);
		
		int c = (int) (b - a + 1);
		System.out.println(c);
		//44032  55203
		
		//우리는 UTF - 8을 기반으로 사용하고 있다.
		
		//b에 들어가있는 글자가 한글인가요?
		boolean korean = '가' <= b && b <='힣';
		
		System.out.println(korean);
	}
}

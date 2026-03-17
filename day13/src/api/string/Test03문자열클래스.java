package api.string;

public class Test03문자열클래스 {
	public static void main(String[] args) {
		//문자열(String)
		//- 여러 개의 글자를 나열한 형태의 데이터(char 배열과 비슷..)
		//- 불변(immutable) 데이터  // 언어의 컨셉을 외워야지 나머지도 이해가 가능
		
		String a = "Hello"; //기존 방식
		String b = "Hello"; // 기존 방식
		String c = new String("Hello"); // 생성자 사용
		String d = new String("Hello"); // 생성자 사용
		
		//자바는 컴파일(사전녹화) 방식의 언어입니다.
		//이 방식의 언어들은 최소한의 메모리를 사용하기 위해 
		//편집 시점에 필요한 메모리를 미리 계산합니다.
		
		// 이 프로그램에서 Hello는 총 몇 개가 메모리에 저장되어 있을까요?
		
		// 정답 : 3개
		
		// a == b
		//(주의) 객체는 참조대상이 같아야 비교연산이 true가 나오기 때문에 사실상 사용이 어려움
		System.out.println(a == b); // a와  b는 동일한 대상을 가리킴
		System.out.println(b == c); // b와 c는 다른 대상을 가리킴
		System.out.println(c== d); // c와 d는 다른 대상을 가리킴
		System.out.println(a == d); // a와 d는 다른 대상을 가리킴
		//프로그래밍에서 문자열에 비교문을 쓰게 되면 같은 대상을 가리키는 지를 물어보기 때문에
		// 문자열을 비교문애 쓸 때 equals 메소드를 사용
		
		//객체 비교는 equals 메소드로 한다
		System.out.println(a.equals(b)); // 대상이 아닌, 내용이 같으면 true;
		System.out.println(b.equals(c)); // 대상이 아닌, 내용이 같으면 true;
		System.out.println(c.equals(d)); // 대상이 아닌, 내용이 같으면 true;
		System.out.println(d.equals(a)); // 대상이 아닌, 내용이 같으면 true;
	}
}

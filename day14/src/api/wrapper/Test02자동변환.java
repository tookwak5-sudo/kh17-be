package api.wrapper;

public class Test02자동변환 {
	public static void main(String[] args) {
		//int 와 Integer는 자동변환이 가능
		//작은범위(-128~127) 사이만 동일하고 나머진 새로 생성
		
		Integer a = 500; // int -> Integer 자동변환(auto- boxing) , 반대 (auto-unboxing)
		Integer b = 500;
		Integer c = new Integer(500);
		Integer d = new Integer(500);
		Integer e = Integer.valueOf(500);
		Integer f = Integer.valueOf(500);
		
		System.out.println(a == b); // true?
		System.out.println(b == c); // b와 c는 다른 대상
		System.out.println(a == e); // true?
		System.out.println(e == f);
		
		int g = a; //Integer -> int 
		
		
		// (for example) String str = new String("hello");
		//       String str = "hello";
		
		
		
		
	}
}

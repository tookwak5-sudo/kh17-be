package api.string3;

public class Test02문자열변환 {
	public static void main(String[] args) {
		//문자열과 다른 데이터간의 변환
		//-(ex)String과 int가 서로 변환이 되는가?

		//모든 데이터는 String 클래스의 valueOf 메소드로 String으로 변경이 가능하다
		int a = 100;
		//String b = (String) a; // 안들어감(형태가 다름) 
		String b = String.valueOf(a);
		System.out.println("b = " + b);
		
		//int로 변환하는 메소드는 다른 클래스(Integer)에 있다
		String c ="12345";
		int d = Integer.parseInt(c);
		System.out.println(d);
		
		// long 변환명령은 Long클래스에 있다. = Long.parseLong();
		// float 변환명령은 Float 클래스에 있다. = Float.parseFloat();
		// double 변환명령은 double 클래스에 있다. = Double.parseDouble();
	}
}

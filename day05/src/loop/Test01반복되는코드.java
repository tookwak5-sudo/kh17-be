package loop;

public class Test01반복되는코드 {
	public static void main(String[] args) {
		//(Q) "안녕하세요"를 10번 출력
		// -for 구문을 이용해서 10번이라는 횟수를 지정
		
		// for(선언부 ; 조건부 ; 증감부)
		// i부터 쓰는 이유: 포트란 언어에서 integer에서 따왔다는 설이 유력
		// 특별이 붙일 이유가 없으면  i k m n o p....
		for(int i =1; i <= 10; i +=1) {// == x10	
			System.out.println( "안녕하세요" + i);			
		}	
		for(int i = 1; i <= 5; i = i+1) {
			System.out.println("Hello" + i*i);
		}
	}
}

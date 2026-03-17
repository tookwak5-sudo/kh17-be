package api.string2;

public class Test03숫자범위검사 {
	public static void main(String[] args) {
		//문자열이지만 "숫자" 형태로 작성된 값의 범위 검사가 가능한가?
		//다음과 같이 문자열 형태로 주어진 점수가 올바른 범위(0-100)인지 검사하려면?
		String score = "21";
		
		//String regex = "^([0-9]|[1-9][0-9]|100)$";  
		//1) 1자리 2자리 3자리 일때 
		//2) 2자리 일때는 10의자리랑 1의 자리 구분 
		//3) 3자리는 100하나이기 때문에 100만
		//Q) 01부터 25까지 존재할 수 있는 문자열을 검사하는 식을 구하시오
		String regex = "^(0[1-9]|1[0-9]|2[0-5])$";  
		//Q) 01부터 73까지 존재할 수 있는 문자열을 검사하는 식을 구하시오
		//String regex = "^(0[1-9]|[1-6][0-9]|7[0-3])$"
		boolean valid = score.matches(regex);
		System.out.println(valid);
	}
}

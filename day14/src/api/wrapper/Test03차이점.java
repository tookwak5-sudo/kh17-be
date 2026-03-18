package api.wrapper;

public class Test03차이점 {
	public static void main(String[] args) {
		//int와 Integer를 반드시 구분해야 하는 상황
		//- null이 발생할 수 있는 경우 -> null : 대상이 없는 경우
		// 원시형은 리모컨이 없어서 null이 성립하지 않음
		
		Integer a = null;
		//int b = null; // 불가능한 값
		//계산의 결과에 null이 나올 가능성이 있다면 Integer
		int b = a; // 문법적으로는 문제가 없는데(자동변환이 되니까) 실행하면 오류가 뜸
		System.out.println("b = " + b); // nullpointexecption
	}
}

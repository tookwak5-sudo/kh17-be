package api.exception;

public class Calculator {
	private Calculator() {}
	
	// N분의 1 금액을 구하는 메소드
	// -예외 처리는 힘든데 나는 예외가 발생할 수 있는 "위.험.한." 메소드야
	// - 메소드 마지막에 throws + 예외 코드를 작성해준다
	// -호출하는 코드에 try - catch를 무조건 써야함
	public static int oneOverN(int total, int people) throws Exception{
			return total / people;
	}
	// N분의 1 하고 남은 금액을 구하는 메소드
	public static int RemainingAmount(int total, int people) throws Exception {
		return total % people;
	}
	
	
}

package api.string2;

public class Test04생년월일검사5 {
	public static void main(String[] args) {
//		날짜 형식은 YYYY-MM-DD 형식
//		연도(YYYY)는 1900부터 2099까지 설정 가능
//		월(MM)은 01부터 12까지 설정 가능
//		일(DD)은 01부터 31까지 설정 가능

//		월별로 28, 30, 31을 구분하여 설정할 수 있도록 업그레이드 하시기 바랍니다.
//		1. 윤년!
	// - birth에서 연도만 잘라내서 숫자 부분을 변환해야함
		//- 그 뒤 배수 판정을 통해 윤년 여부를 계산하고 정규표현식의 2월 부분 수정
// - 정규표현식으로만으론 불가능(문자열 처리가 필요)
		
		String birth = "2026-03-31";
		 
		boolean valid = DateCalculate.CheckValid(birth);
		System.out.println(valid);
	}
}

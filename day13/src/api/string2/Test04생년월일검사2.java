package api.string2;

public class Test04생년월일검사2 {
	public static void main(String[] args) {
//		날짜 형식은 YYYY-MM-DD 형식
//		연도(YYYY)는 1900부터 2099까지 설정 가능
//		월(MM)은 01부터 12까지 설정 가능
//		일(DD)은 01부터 31까지 설정 가능
//
//		최초 구현 시 월 상관없이 모든 달이 31까지 일자를 설정할 수 있게 구현하세요.
//		다 구현하고 나서 월별로 28, 30, 31을 구분하여 설정할 수 있도록 업그레이드 하시기 바랍니다.
//
//		윤년은 프로그래밍으로밖에 구할 수 없습니다 (배수 판정 때문)
//		윤년을 고려하려면 어떻게 해야되는지 가장 마지막에 추가해보세요
		String birth = "2026-03-17";
		String regex ="^(19[0-9]{2}|20[0-9]{2})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";
		boolean valid = birth.matches(regex); // regex.matches(birth)로 순서 잘못쓰지 않도록 주의하기
		 
		System.out.println(valid);
	}
}

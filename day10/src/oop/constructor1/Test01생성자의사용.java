package oop.constructor1;

public class Test01생성자의사용 {
	public static void main(String[] args) {
// 만들고 정보를 설정하는 코드
		//		Item a = new Item();
//		a.init("설향 딸기", 9900, 5);
		
		// 만들면서 정보를 설정하는 코드
		Item a = new Item("설향 딸기", 9900, 5);
		a.show();
	}
}

package oop.method9;

public class Test01용의자탐색 {
	public static void main(String[] args) {
		Suspect s1 = new Suspect();
		Suspect s2 = new Suspect();
		Suspect s3 = new Suspect();
		Suspect s4 = new Suspect();
		
		s1.init("마리오", "학생", 15, 160, 52);
		s2.init("루이지", "개발자", 22, 180, 75);
		s3.init("피오나", "디자이너", 20, 162, 50);
		s4.init("쿠파", "기획자", 30, 190, 95);
		
		s1.setAge(-500); //정확하게 차단됨(권장 코드)
		//s1.age = -500; // 잘못된 값을 제어할 방법이 없음(권장하지 않는 코드 -> 금지되는 코드)
		
		s1.show();
		s2.show();
		s3.show();
		s4.show();
	}
}

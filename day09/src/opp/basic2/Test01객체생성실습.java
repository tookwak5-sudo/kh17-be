package opp.basic2;

public class Test01객체생성실습 {
	public static void main(String[] args) {
		//객체[인스턴스]생성
		Poketmon p1 = new Poketmon(); // new로 만들면 초기값이 생김
		Poketmon p2 = new Poketmon();
		Poketmon p3 = new Poketmon();
		
		//객체 초기화
		p1.no = 1;
		p1.name = "이상해씨";
		p1.type = "풀/독";
		
		p2.no = 4;
		p2.name = "파이리";
		p2.type = "불꽃";
		
		p3.no = 7;
		p3.name = "꼬부기";
		p3.type = "물";
		
		//객체 정보 출력
		System.out.println("<몬스터 정보>");
		System.out.println("번호 : " + p1.no);
		System.out.println("이름 : " + p1.name);
		System.out.println("속성 : " + p1.type);
		System.out.println("------------");
		System.out.println("<몬스터 정보>");
		System.out.println("번호 : " + p2.no);
		System.out.println("이름 : " + p2.name);
		System.out.println("속성 : " + p2.type);
		System.out.println("------------");
		System.out.println("<몬스터 정보>");
		System.out.println("번호 : " + p3.no);
		System.out.println("이름 : " + p3.name);
		System.out.println("속성 : " + p3.type);
	}
}

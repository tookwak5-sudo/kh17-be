package oop.method2;

//올림픽 참여국가
public class Olympics {
	//멤버 필드 : 구성 데이터 저장
	int rank;
	String name;
	int gold, silver, bronze;
	
	//멤버 메소드 : 필요 기능 코드 저장
	// - init 메소드 : 데이터 설정 코드를 보관하는 메소드
	void init(int rank, String name, int gold, int silver, int bronze) {
		this.rank =rank;
		this.name = name;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}
	// - show 메소드 : 데이터 출력 코드를 보관하는 메소드
	void show() {
		System.out.println("<파리 올림픽 순위>");
		System.out.println("순위 : " + this.rank);
		System.out.println("국가 : " + this.name);
		System.out.println("금메달 : " + this.gold);
		System.out.println("은메달 : " + this.silver);
		System.out.println("동메달 : " + this.bronze);
		System.out.println("---------------");
		int total = this.gold  + this.silver + this.bronze; //지역변수
		System.out.println("총 메달 : " + total); // 파생데이터는 계산하지 않는다.
		
		
	}
}

package oop.method8;

public class Student {
	//멤버 필드   정보 + 검사 (차단 = 필터링) // 필드에는 조건 사용불가능
	String name;
	int korean, english, math;
	
	//세터메소드
	//- 모든 항목을 개별적으로 변경할 수 있는 메소드
	//-이름짓기 힘드니까 다음과 같이 규칙을 정하자!
	//- set과 필드이름을 합쳐서 메소드 이름으로 설정
	void setName(String name) {
		if(name.length() >20) return;
		this.name = name;
	}
	void setKorean(int korean) {
		if(korean >= 0 && korean <=100) {
			this.korean = korean;
		}
	}
	
	// 0~100점 사이일 경우 영어 점수를 설정하는 세터메소드
//	void setEnglish(int english) {
//		if(english >= 0 && english <= 100) {
//			this.english = english;
//		}
//	}
	// 0~100점 사이가 아닐 경우 영어 점수를 설정하지 않는 세터메소드
	//*return은 메소드 실행을 중지하는 키워드 (break의 메소드 버전)
	void setEnglish(int english) {
		if(english < 0 && english >100) return;
		this.english = english;
	}
	
	void setMath(int math) { // 실행시키면 뭔가 하긴 하지만 아무것도 얻을 수 없는 메소드 (void - 반환없음)
		if(math < 0 && math > 100) return;
		this.math = math;
	}
	//앞으로 모든 필드에 대한 설정은 세터메소드를 이용해서만 가능!
	
	//게터 메소드 (getter method)
	//- 데이터의 반환 또는 계산 결과를 알아내기 위한 메소드
	// - 필드당 1개씩 만들고 필요하면 더 추가할 수 있음
	// -이름 규칙은 get + 필드명 으로 한다.
	// - return은 메소드 종료 및 데이터 반환을 수행하는 키워드
	// - 반환형이 void 외 다른 자료형도 있다.
	String getName() { // 실행시키면 String데이터 한 개를 얻을 수 있는 메소드
		return this.name;
	}
	int getKorean() {
		return this.korean;
	}
	int getEnglish() {
		return this.english;
	}
	int getMath() {
		return this.math;
	}
	//필드가 없더라도 계산이 필요하면 만들 수 있다.
	int getTotal() { //가상의 GETTER라고 부를 예정
		return this.korean + this.english + this.math;
	}
	double getAverage() {
		return (double) this.getTotal() / 3;
	}
	
	//멤버 메소드 // 메소드에는 가능
	void init(String name, int korean, int english, int math) {
		this.setName(name);
		this.setKorean(korean);
		this.setEnglish(english);
		this.setMath(math);
	}
	
	void show() {
		System.out.println("이름 : " + this.getName());
		System.out.println("국어 : " + this.getKorean());
		System.out.println("영어 : " + this.getEnglish());
		System.out.println("수학 : " + this.getMath());
		System.out.println("총점 : " + this.getTotal());
		System.out.println("평균 : " + this.getAverage());
	}
}

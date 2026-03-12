package oop.method9;

public class Suspect2 {
	//멤버필드
	String suspectName;
	String suspectJob;
	int age;
	float height;
	float weight;
	
	//세터 메소드
	void setSuspectName(String suspectName) {
		if(suspectName.length() > 10) return;
		this.suspectName = suspectName;
	}
	void setSuspectJob(String suspectJob) {
		this.suspectJob = suspectJob;
	}
	void setAge(int age) {
		if(age <= 0) return;
		this.age = age;
	}
	void setHeight(float height) {
		if(height <= 0) return;
		this.height = height;
	}
	void setWeight(float weight) {
		if(weight <= 0) return;
		this.weight = weight;
	} 
	//게터 메소드 계산은 게터에서 검산은 세터에서
	String getSuspectName() {
		return this.suspectName;
	}
	String getSuspectJob() {
		return this.suspectJob;
	}
	int getAge() {
		return this.age;
	}
	float getHeight() {
		return this.height;
	}
	float getWeight() {
		return this.weight;
	}
	// 추가 : 키를 m로 반환하는 메소드
	float getHeightMeter() {
		return this.height / 100;
	}
	//추가 bmi
	float getBmi() {
		return this.getWeight() / (this.getHeightMeter() * this.getHeightMeter());
	}
	// 추가 : 예상 지하철 요금 반환
	int getSubwayPrice() {
		if(this.age <= 7) return 0;
		else if(this.age >= 65) return 0;
		else if(this.age >= 20) return 1550;
		else if(this.age >= 14) return 900;
		else return 550;
	}
	
	//멤버 메소드
	void init(String suspectName, String suspectJob, int age, float height, float weight) {
		this.setSuspectName(suspectName);
		this.setSuspectJob(suspectJob);
		this.setAge(age);
		this.setHeight(height);
		this.setWeight(weight);
	}
	
	void show() {
		System.out.println("<용의자 정보>");
		System.out.println("이름 : " + this.getSuspectName());
		System.out.println("직업 : " + this.getSuspectJob());
		System.out.println("나이 : " + this.getAge());
		System.out.println("키 : " + this.getHeight() + "cm");
		System.out.println("몸무게 : " + this.getWeight() + "kg");
		System.out.println("지하철 요금 : " + this.getSubwayPrice() + "원");
		System.out.println("BMI 수치 : " + this.getBmi());
		System.out.println("--------------------");
	}
}


















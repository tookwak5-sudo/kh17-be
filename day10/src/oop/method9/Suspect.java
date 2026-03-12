package oop.method9;

public class Suspect {
	//멤버필드
	String suspectName;
	String suspectJob;
	int age;
	double height;
	double weight;
	
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
	void setHeight(double height) {
		if(height <= 0) return;
		this.height = height;
	}
	void setWeight(double weight) {
		if(weight <= 0) return;
		this.weight = weight;
	} 
	//게터 메소드
	String getSuspectName() {
		return this.suspectName;
	}
	String getSuspectJob() {
		return this.suspectJob;
	}
	int getAge() {
		return this.age;
	}
	double getHeight() {
		return this.height;
	}
	double getWeight() {
		return this.weight;
	}
	int getPrice() {
		int deposit = 500;
		int base = 0;
		if(this.age <= 7 || this.age >=65) {
			base = 0;
		}
		else if(this.age <= 13) {
			base = 550;
		}
		else if(this.age <= 19) {
			base = 900;
		}
		else {
			base = 1550;
		}
		int price = base + deposit;
		return price;
	}
	float getBmi() {
		float m = (float) this.height /100;
		float m2 = m*m;
		float bmi = (float) this.weight / m2;
		return bmi;
	}
	
	//멤버 메소드
	void init(String suspectName, String suspectJob, int age, double height, double weight) {
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
		System.out.println("지하철 요금 : " + this.getPrice() + "원");
		System.out.println("BMI 수치 : " + this.getBmi());
		System.out.println("--------------------");
	}
}


















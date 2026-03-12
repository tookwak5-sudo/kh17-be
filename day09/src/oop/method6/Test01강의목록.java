package oop.method6;

public class Test01강의목록 {
	public static void main(String[] args) {
		Lecture a = new Lecture();
		Lecture b = new Lecture();
		Lecture c = new Lecture();
		Lecture d = new Lecture();
		
		a.init("자바 프로그래밍 기초", "이론", 60, 500000, "온라인");
	//b.init("파이썬 프로그래밍 기초", "이론", 90, 1000000, "오프라인");
		b.init("파이썬 프로그래밍 기초", "이론", 90, 1000000);
		c.init("정보처리기사 필기", "시험", 30, 300000, "혼합");
		d.init("빅데이터 분석기사 실기", "시험", 120, 850000, "혼합");
		
		a.show();
		b.show();
		c.show();
		d.show();
	}
}

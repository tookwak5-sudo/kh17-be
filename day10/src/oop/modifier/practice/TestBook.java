package oop.modifier.practice;

public class TestBook {
	public static void main(String[] args) {
		Book a = new Book("자바의 정석", "기술", 1000, 5000, "대여가능");
		Book b = new Book("어린 왕자", "소설", 150, 2000, "대여중");
		Book c = new Book("노인과 바다", "소설", 200, 2500, "몰라임마");
		Book d = new Book("SQL 기초", "기술", 400, 4500, "예약중");
		
		a.show();
		b.show();
		c.show();
		d.show();
		
	}
}

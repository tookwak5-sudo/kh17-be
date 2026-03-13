package oop.modifier.practice;

public class TestBook {
	public static void main(String[] args) {
		Book a = new Book("자바의 정석", "기술", 1000, 5000, 1);
		Book b = new Book("어린 왕자", "소설", 150, 2000);
		Book c = new Book("노인과 바다", "소설", 200, 2500, 2);
		Book d = new Book("SQL 기초", "기술", 400, 4500, 3);
		
//		a.init("자바의 정석", "기술", 1000, 5000, true);
//		b.init("어린 왕자", "소설", 150, 2000, false);
//		c.init("노인과 바다", "소설", 200, 2500, true);
//		d.init("SQL 기초", "기술", 400, 4500, false);
//		
		a.show();
		b.show();
		c.show();
		d.show();
		
	}
}

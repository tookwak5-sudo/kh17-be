package oop.modifier.practice;

public class Book {
	//필드
	private String name;
	private String genre;
	private int page; //숫자 작성할 때는 int or long인지 항상체크
	private int rent;
	//private boolean rentState;
	private int status; // 1대여가능 2 대여중 3 예약중 4 대여불가
	
	public void setName(String name) {
		if(name.length() > 20) return;
		this.name = name;
	}	
	public String getName() {
		return name;
	}

	public void setGenre(String genre) {
		switch(genre) {
		case "기술", "소설", "자기개발":
			this.genre = genre;
		}
	}
	public String getGenre() {
		return genre;
	}
	
	public void setPage(int page) {
		if(page < 50) return;
		this.page = page;
	}
	public int getPage() {
		return page;
	}
	
	public void setRent(int rent) {
		if(rent < 0) return;
		if(rent % 500 != 0) return;
		this.rent = rent;
	}
	public int getRent() {
		return rent;
	}
	
	public void setStatus(int status) {
		switch(status) {
		case 1, 2, 3, 4:
			this.status = status;
		}
	}
	public int getRentState() {
		return status;
	}
	//추가 부가세가 포함된 최종금액
	public int getAddFee(int rate) {
		return this.rent *(rate) / 100;
	}
	
	public int getTotalPrice() {
		return getRent() + getAddFee(10);
	}
	public String getStatusValue() {
		if(status == 1) return "대여가능";
		if(status == 2) return "대여중";
		if(status == 3) return "예약중";
		return "대여불가";
	}
//	public String getPossible() {
//		if(this.rentState) return "대여가능";
//		else return "대여중";
//	}
	
	//생성자
	public Book(String name, String genre, int page, int rent) {
		this(name, genre, page, rent, 1);
	}
	
	public Book(String name, String genre, int page, int rent, int status) {
		this.setName(name);
		this.setGenre(genre);
		this.setPage(page);
		this.setRent(rent);
		this.setStatus(status);
	}
	
	public void show() {
		System.out.println("<도서 정보>");
		System.out.println("도서명 : " + this.name);
		System.out.println("장르 : " + this.genre);
		System.out.println("페이지 수 : " + this.getPage());
		System.out.println("대여료 : " + this.getRent() + "원");
		System.out.println("대여 상태 : " + this.getStatusValue());
		System.out.println("최종 결제 금액 : " + this.getTotalPrice() + "원 (VAT"+ getAddFee(10) +")");
		System.out.println("--------------------");
	}
}

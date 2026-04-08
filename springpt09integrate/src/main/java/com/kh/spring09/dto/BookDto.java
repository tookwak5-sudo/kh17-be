package com.kh.spring09.dto;

public class BookDto {
	private int bookId;
	private String bookTitle;
	private String bookAuthor;
	private String bookPublicationDate;
	private long bookPrice;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;
	
	@Override
	public String toString() {
		return "BookDto [bookId=" + bookId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookPublicationDate=" + bookPublicationDate + ", bookPrice=" + bookPrice + ", bookPublisher="
				+ bookPublisher + ", bookPageCount=" + bookPageCount + ", bookGenre=" + bookGenre + "]";
	}
	public BookDto() {
		super();
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	//표시용 메소드 추가
	public String getBookAuthorString() {
		if(bookAuthor == null) return "미상";
		return bookAuthor;
	}
	
	
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublicationDate() {
		return bookPublicationDate;
	}
	//표시용메소드 추가
	public String getBookPublicationDateString() {
		if(bookPublicationDate == null) return "알 수 없음";
		return bookPublicationDate;
	}
	public void setBookPublicationDate(String bookPublicationDate) {
		this.bookPublicationDate = bookPublicationDate;
	}
	public long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(long bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	//표시용 메소드 추가
	public String getBookPublisherString() {
		if(bookPublisher == null) return "알 수 없음";
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public int getBookPageCount() {
		return bookPageCount;
	}
	public void setBookPageCount(int bookPageCount) {
		this.bookPageCount = bookPageCount;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	
}

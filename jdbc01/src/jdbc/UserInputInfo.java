package jdbc;

public class UserInputInfo {
	private String bookTitle;
	private String bookAuthor;
	private String bookPublicationDate;
	private int bookPrice;
	private String bookPublisher;
	private int bookPageCount;
	private String bookGenre;
	private Object[] params = new Object[] {};
	
	public UserInputInfo(Object[] params) {
		super();
		this.params = params;
	}
	public UserInputInfo(String bookTitle, String bookAuthor, String bookPublicationDate, int bookPrice,
			String bookPublisher, int bookPageCount, String bookGenre) {
		super();
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPublicationDate = bookPublicationDate;
		this.bookPrice = bookPrice;
		this.bookPublisher = bookPublisher;
		this.bookPageCount = bookPageCount;
		this.bookGenre = bookGenre;
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
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookPublicationDate() {
		return bookPublicationDate;
	}
	public void setBookPublicationDate(String bookPublicationDate) {
		this.bookPublicationDate = bookPublicationDate;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookPublisher() {
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

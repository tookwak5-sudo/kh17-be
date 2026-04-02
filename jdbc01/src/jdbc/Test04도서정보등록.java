package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

public class Test04도서정보등록 {
	public static void main(String[] args) {
		//입력정보
		String bookTitle = "나의 라임 오렌지나무";
		String bookAuthor = "조제 마우루 지 바스콘셀루스";
		String bookPublicationDate = "1978-03-25";
		int bookPrice = Integer.parseInt("11700");
		String bookPublisher = "동녘";
		int bookPageCount = Integer.parseInt("400");
		String bookGenre = "소설";
		
		//DB 등록 
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		String sql = "insert into book("
				+ "book_id, book_title, book_author, "
				+ "book_publication_date, book_price, "
				+ "book_publisher, book_page_count, book_genre) "
				+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				bookTitle, bookAuthor, bookPublicationDate,
				bookPrice, bookPublisher, bookPageCount, bookGenre
		};
		jdbcTemplate.update(sql, params);
		
		System.out.println("등록완료");
	}
}

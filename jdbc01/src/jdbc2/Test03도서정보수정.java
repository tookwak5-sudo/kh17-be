package jdbc2;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.JdbcUtils;

public class Test03도서정보수정 {
	public static void main(String[] args) {
		int bookId = 1;
		String bookTitle = "바꾼도서명";
		String bookAuthor = "바꾼저자";
		String bookPublicationDate = "2026-03-01";
		int bookPrice = 10000;
		int bookPageCount = 100;
		String bookPublisher = "바꾼출판사";
		String bookGenre = "판타지";
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		
		// 수정할 정보
		String sql = "update book set "
				+ "book_title =?, "
				+ "book_author =?, "
				+ "book_publication_date =?, "
				+ "book_price =?, "
				+ "book_publisher =?, "
				+ "book_page_count =?, "
				+ "book_genre =? "
				+ "where book_id =?";
		
		Object[] params = {
				bookTitle, bookAuthor, bookPublicationDate, bookPrice,
				bookPublisher, bookPageCount, bookGenre, bookId
		};
		int rows = jdbcTemplate.update(sql, params);
		
		if(rows > 0) {
			System.out.println("도서 정보가 바뀜");
		}
		else {
			System.out.println("바뀐 도서정보 없음");
		}
	}
}

package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.util.JdbcUtils;

public class BookDao {
	public void insert(BookDto bookDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "insert into book("
				+ "book_id, book_title, book_author, "
				+ "book_publication_date, book_price, "
				+ "book_publisher, book_page_count, book_genre) "
				+ "values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				bookDto.getBookTitle(), bookDto.getBookAuthor(), bookDto.getBookPublicationDate(),
				bookDto.getBookPrice(), bookDto.getBookPublisher(), bookDto.getBookPageCount(), 
				bookDto.getBookGenre()
		};
		jdbcTemplate.update(sql, params);
	}
	
	//수정데이터는 성공을 하더라도 잘 적용되었는 지 알 수 없다(따로 확인)
	public boolean update(BookDto bookDto) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "update book set "
				+ "book_title =?, "
				+ "book_author =?, "
				+ "book_publication_Date =?, "
				+ "book_price =?, "
				+ "book_page_count =?, "
				+ "book_genre =? "
				+ "where book_id =?";
		Object[] params = {
				bookDto.getBookTitle(), bookDto.getBookAuthor(),
				bookDto.getBookPublicationDate(), bookDto.getBookPrice(),
				bookDto.getBookPageCount(), bookDto.getBookGenre(),
				bookDto.getBookId()
		};
		int rows = jdbcTemplate.update(sql, params);
		return rows > 0;
	}
	
	public boolean delete(int bookId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete book where book_id =?";
		Object[] params = { bookId };
		return jdbcTemplate.update(sql, params) > 0;
	}
	
}

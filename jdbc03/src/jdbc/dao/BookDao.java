package jdbc.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.mapper.BookMapper;
import jdbc.util.JdbcUtils;

public class BookDao {
	//삽입
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
	
	//삭제
	public boolean delete(int bookId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete book where book_id =?";
		Object[] params = { bookId };
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	//목록 조회 및 검색
	
	//조회
	public List<BookDto> selectList(){
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book";
		BookMapper bookmapper = new BookMapper(); //조회할 때는 mapper가 꼭 필요하다
		return jdbcTemplate.query(sql, bookmapper);
	}
	//검색
	public List<BookDto> selectList(String column, String keyword){
		if(column == null || keyword == null) return List.of();
//		Set<String> allowList = Set.of("book_title", "book_author", "book_publisher", "book_genre");
//		if(!allowList.contains(column)) return selectList();
		
		//set하고 같은 결과가 나오는 코드
		String[] allowList = new String[] {
				"book_title", "book_author", "book_publication_date",
				"book_publisher", "book_genre"
		};
		if(Arrays.binarySearch(allowList, column) == -1) return List.of();
		
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book where instr("+ column +", ?) > 0 order by "+ column +" book_id asc";
		Object[] params = { keyword };
		BookMapper bookMapper = new BookMapper();
		return jdbcTemplate.query(sql, bookMapper, params);
	}
	
	//상세검색
	public BookDto selectOne(int bookId) {
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book where book_id = ?";
		Object[] params = { bookId };
		BookMapper bookMapper = new BookMapper();
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
//		return list.size() ==0 ? null : list.get(0);
		return list.isEmpty() ? null : list.get(0);
	}
}

package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.BookDto;
import jdbc.mapper.BookMapper;
import jdbc.util.JdbcUtils;

public class Test03도서정보조회 {
	public static void main(String[] args) {
		
		// 도서정보 조회
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from book order by book_id asc";
		//Object[] params = {};
		BookMapper bookMapper = new BookMapper();
		//List<BookDto> list = jdbcTemplate.query(sql, bookMapper, params);
		List<BookDto> list = jdbcTemplate.query(sql, bookMapper);
		System.out.println("조회 결과 : " + list.size() + "개");
		for(BookDto bookDto : list) {
			System.out.println(bookDto);
		}
	}
}

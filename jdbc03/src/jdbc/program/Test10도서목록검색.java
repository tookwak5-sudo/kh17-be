package jdbc.program;

import java.util.List;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test10도서목록검색 {
	public static void main(String[] args) {
		//입력
		String column = "book_title";
		String keyword = "왕";
		//처리
		BookDao bookDao = new BookDao();
		List<BookDto> list = bookDao.selectList(column, keyword);
		
		//출력
		if(list.isEmpty()) {
			System.out.println("결과가 존재하지 않습니다");
		}
		else {
			System.out.println("도서 개수 : " + list.size());
			for(BookDto bookDto : list) {
				System.out.println(bookDto);
			}
		}
	}
}

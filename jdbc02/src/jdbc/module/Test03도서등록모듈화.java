package jdbc.module;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;
import jdbc.util.JdbcUtils;


public class Test03도서등록모듈화 {
	public static void main(String[] args) {
		
		BookDto bookDto = new BookDto();
		bookDto.setBookTitle("비켜봐");
//		String bookTitle = "나의 라임 오렌지나무";
		//bookDto.setBookAuthor("조제 마우루 지 바스콘셀루스");
//		String bookAuthor = "조제 마우루 지 바스콘셀루스";
		bookDto.setBookPublicationDate("1978-03-25");
//		String bookPublicationDate = "1978-03-25";
		bookDto.setBookPrice(11700);
//		int bookPrice = Integer.parseInt("11700");
		bookDto.setBookPublisher("동녘");
//		String bookPublisher = "동녘";
		bookDto.setBookPageCount(400);
//		int bookPageCount = Integer.parseInt("400");
		bookDto.setBookGenre("소설");
//		String bookGenre = "소설";
		
		//DB 등록 
		BookDao bookDao = new BookDao();
		bookDao.insert(bookDto);
		
		System.out.println("등록완료");

	}
}

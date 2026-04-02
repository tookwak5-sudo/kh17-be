package jdbc.program;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test03도서정보수정 {
	public static void main(String[] args) {
		// 입력
		BookDto bookDto = new BookDto();
		bookDto.setBookId(1);
		bookDto.setBookTitle("확인2용 도서");
		bookDto.setBookAuthor("확인 저자");
		bookDto.setBookPublicationDate("2025-03-05");
		bookDto.setBookPrice(18000);
		bookDto.setBookPublisher("확인 출판사");
		bookDto.setBookPageCount(150);
		bookDto.setBookGenre("교양");
		// 처리
		
		BookDao bookDao = new BookDao();
		boolean success = bookDao.update(bookDto);
		// 출력
		if(success) {
			System.out.println("도서정보가 변경되었습니다.");
		}
		else {
			System.out.println("변경될 정보가 없습니다.");
		}
	}
}

package jdbc.program;

import jdbc.dao.BookDao;
import jdbc.dto.BookDto;

public class Test13도서상세정보 {
	public static void main(String[] args) {
		//입력
		int bookId = 1;
		//처리
		BookDao bookDao = new BookDao();
		BookDto bookDto = bookDao.selectOne(bookId);
		
		//출력
		if(bookDto != null) {
			System.out.println("<도서 상세정보>");
			System.out.println("제목 : " + bookDto.getBookTitle());
			System.out.println("저자 : " + bookDto.getBookAuthor());
			System.out.println("출판사 : " + bookDto.getBookPublisher());
			System.out.println("출간일 :" + bookDto.getBookPublicationDate());
			System.out.println("판매가 : " + bookDto.getBookPrice() + "원");
			System.out.println("페이지  :" + bookDto.getBookPageCount() + "page");
		}
		else {
			System.out.println("존재하지 않는 도서입니다");
		}
	}
}


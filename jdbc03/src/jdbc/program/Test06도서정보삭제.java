package jdbc.program;

import jdbc.dao.BookDao;

public class Test06도서정보삭제 {
	public static void main(String[] args) {
		int bookId = 26;
		
		//처리
		BookDao bookDao = new BookDao();
		boolean success = bookDao.delete(bookId);
		
		if(success) {
			System.out.println("도서정보가 삭제되었습니다.");
		}
		else {
			System.out.println("해당 번호의 도서가 없습니다.");
		}
		
		//System.out.println(success ? "성공" : "실패");
	}
}

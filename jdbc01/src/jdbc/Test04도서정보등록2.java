package jdbc;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

public class Test04도서정보등록2 {
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			//입력정보
			System.out.print("제목 : ");
			String bookTitle = sc.nextLine();
			System.out.print("저자 : ");
			String bookAuthor =  sc.nextLine();
			System.out.print("출판일 : ");
			String bookPublicationDate = sc.nextLine();
			System.out.print("가격 : ");
			int bookPrice = Integer.parseInt( sc.nextLine());
			System.out.print("출판사 : ");
			String bookPublisher =  sc.nextLine();
			System.out.print("페이지 수 : ");
			int bookPageCount = Integer.parseInt( sc.nextLine());
			System.out.print("장르 : ");
			String bookGenre =  sc.nextLine();
			
			//DB 등록 
			JdbcTemplate jdbcTemplate = JdbcUtils.create();
			
			String sql = "insert into book("
					+ "book_id, book_title, book_author, "
					+ "book_publication_date, book_price, "
					+ "book_publisher, book_page_count, book_genre"
					+ ") values(book_seq.nextval, ?, ?, ?, ?, ?, ?, ?)";
			Object[] params = {
					bookTitle, bookAuthor, bookPublicationDate,
					bookPrice, bookPublisher, bookPageCount, bookGenre
			};
			// 처리
			jdbcTemplate.update(sql, params);
			
			System.out.println("등록완료");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}

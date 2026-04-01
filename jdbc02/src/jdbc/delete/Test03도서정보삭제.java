package jdbc.delete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test03도서정보삭제 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("도서 번호 입력 : ");
		int bookId = Integer.parseInt(br.readLine());
		br.close();
		// 처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete book where book_id =? ";
		//Object[] params = new Object[] {lectureNo};
		Object[] params = {bookId};
		int rows = jdbcTemplate.update(sql, params);
		
		if(rows > 0) {
			System.out.println("해당번호의 도서 삭제");
		}
		else {
			System.out.println("해당번호의 도서가 존재하지 않습니다");
		}
	}
}

package jdbc.delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test02강좌정보삭제 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("강좌 번호 입력 : ");
		int lectureNo = sc.nextInt();
		sc.close();
		
		// 처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete lecture where lecture_no =? ";
		//Object[] params = new Object[] {lectureNo};
		Object[] params = {lectureNo};
		int rows = jdbcTemplate.update(sql, params);
		
		if(rows > 0) {
			System.out.println("해당번호의 강의 삭제");
		}
		else {
			System.out.println("해당번호의 강의가 존재하지 않습니다");
		}
	}
}

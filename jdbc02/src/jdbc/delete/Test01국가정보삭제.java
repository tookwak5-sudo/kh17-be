package jdbc.delete;

import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test01국가정보삭제 {
	public static void main(String[] args) {
		//[SQL] delete country where country no = ?
		
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 국가 번호 입력: "); //이름이 아닌 번호로 지우는 이유? 이름은 unique가 아니기 때문
		int countryNo = 11;
		
		sc.close();
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "delete country where country_no =? ";
		Object[] params = {countryNo}; // 구문의 홀더[?]에 들어갈 데이터
		int rows = jdbcTemplate.update(sql, params);
		
		//출력
		if(rows > 0) {
			System.out.println("삭제가 완료되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 국가 번호 입니다.");
		}
	}
}	


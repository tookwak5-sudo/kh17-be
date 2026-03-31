package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test01연결테스트 {
	public static void main(String[] args) {
		//연결 가능한지 테스트 수행
		DriverManagerDataSource dataSource = new DriverManagerDataSource(); // 연결도구
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); // DB의 종류를 얄려줌
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB의 위치와 연결정보 @기준으로 앞뒤가 나뉨 앞: 연결방법 / 뒤: DB위치 -> DBeaver에서는 이미지로 적용했었음
		dataSource.setUsername("kh17"); // 계정이름
		dataSource.setPassword("kh17"); // 비밀번호
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(); // 실행도구
		jdbcTemplate.setDataSource(dataSource);
		
		String sql = "delete item";
		
		jdbcTemplate.execute(sql); // 실행
		
		System.out.println("실행완료"); // 위 정보가 유효하다면 실행
	}
}

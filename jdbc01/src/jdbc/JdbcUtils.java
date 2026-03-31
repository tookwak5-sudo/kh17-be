package jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcUtils {
	//DB 명령 실행에 사용할 Jdbctemplate를 생성하는 메소드
	public static JdbcTemplate create() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("kh17");
		dataSource.setPassword("kh17");
		
		//실행도구
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		
		return jdbcTemplate;
	}
}

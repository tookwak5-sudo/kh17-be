package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02국가정보등록 {
	public static void main(String[] args) {
		
		
		//연결 도구
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); // DB종류안내
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB연결 유형과 위치안내
		dataSource.setUsername("kh17"); // 계정명
		dataSource.setPassword("kh17"); // 비번
		
		// 실행도구
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource); // 연결정보를 건내주기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String countryRegion = "아시아";
		String countryName = "북한";
		String countryCapital = "평양";
		long population = 20000000L;
		
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") values(country_seq.nextval, '"+ countryRegion +"', '"+ countryName +"', '"+ countryCapital +"', '"+population+"')";
		
		jdbcTemplate.execute(sql);
		
		
		System.out.println("실행완료");
	}
}

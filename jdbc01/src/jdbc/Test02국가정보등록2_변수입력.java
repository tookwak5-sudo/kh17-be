				package jdbc;


import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Test02국가정보등록2_변수입력 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("대륙 : ");
		String countryRegion = sc.nextLine();
		System.out.print("국가 : ");
		String countryName = sc.nextLine();
		System.out.print("수도 : " );
		String countryCapital = sc.nextLine();
		System.out.print("인구수 : ");
		long countryPopulation = sc.nextLong();
		sc.close();
		
		//연결 도구
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver"); // DB종류안내
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe"); // DB연결 유형과 위치안내
		dataSource.setUsername("kh17"); // 계정명
		dataSource.setPassword("kh17"); // 비번
		
		// 실행도구
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource); // 연결정보를 건내주기
		
	
		//최종형태 (동적 SQL 방식)
		// - 데이터가 들어갈 부분을 홀더(?)로 표기
		// - 홀더에 들어갈 데이터를 Object[]로 순서대로 배치하여 전달
		// *홀더 : 위치를 잡는다.
		
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") values(country_seq.nextval, ?, ?, ?, ?)";
		//Object[] params = new Object[] {countryRegion, countryName, countryCapital, countryPopulation};
		Object[] params = {countryRegion, countryName, countryCapital, countryPopulation};
		// C언어 계열 배열
		jdbcTemplate.update(sql, params); //구문이랑 데이터 줄게 알아서 해
		
		System.out.println("실행완료");
	}
}

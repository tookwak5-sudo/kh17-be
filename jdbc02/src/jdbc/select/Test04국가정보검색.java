package jdbc.select;

import java.util.List;
import java.util.Scanner;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test04국가정보검색 {
	public static void main(String[] args) {
		//나라이름만 입력받아 국가정보를 조회하여 출력
		//- 준비물 : CountryDto, CountryMapper(이미있음)
		//입력
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 국가명 : ");
		String countryName = sc.nextLine();
		sc.close();
		
		//처리
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from country where instr(country_name, ?) > 0 order by country_no asc";
		Object[] params = {countryName};
		CountryMapper countryMapper = new CountryMapper();
		
		// - 구문을 맨 처음에 배치하고,  홀더에 들어갈 데이터를 마지막에 배치한다고 기억!
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params);
		
		System.out.println("조회 결과 : " + list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
	}
}

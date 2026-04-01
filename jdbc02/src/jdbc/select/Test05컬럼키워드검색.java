package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test05컬럼키워드검색 {
	public static void main(String[] args) {
		//입력
		// - [국가명][시아    ][검색] 과 같은 상황을 구현
 		String column = "country_capital";
		String keyword = "시아";
		
		//처리
		// - colum은 구문에 들어갈 값이고, keyword는 데이터로 배치될 값이다
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from country where instr("+column+" , ?) > 0 order by country_no asc";
		//sql = sql.replace("#1", column);	
		Object[] params = {keyword}; // 홀더 한 개
		CountryMapper countryMapper = new CountryMapper();
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params);
		//출력
		System.out.println("실행 구문 : " + sql);
		System.out.println("조회 결과 : " + list.size());
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
	}
}

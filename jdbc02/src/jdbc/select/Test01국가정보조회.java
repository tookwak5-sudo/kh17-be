package jdbc.select;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.util.JdbcUtils;

public class Test01국가정보조회 {
	public static void main(String[] args) {
		//국가 정보 조회
		
		JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "select * from country order by country_no asc";
		// Object[] params = {};  // 홀더가 없기 때문에 .. 필요 x
		//jdbcTemplate.update(sql); // 실행은 되지만 적합하지 않는
		// select에서 실행을 하려면 클래스를 하나 만들어야함
			
		CountryMapper countryMapper = new CountryMapper(); // 내가 준비한 반환도구
		List<CountryDto> list = jdbcTemplate.query(sql, countryMapper);
		
		System.out.println("조회 결과 : " + list.size() + "개");
		for(CountryDto countryDto : list) {
			System.out.println(countryDto);
		}
		
	}
}

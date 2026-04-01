package jdbc.select;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

// // 조회된 결과(ResultSet)의 행(Rows)을 CountryDto()에 연결(Mapping)시키는 도구
// - select*from country로 나온 결과가 CountryDto의 어떤 필드에 들어가야 하는지 알려주는 클래스
// - RowMapper를 상속받아서 구현
public class CountryMapper implements RowMapper<CountryDto>{
	@Override
	public CountryDto mapRow(ResultSet rs, int idx) throws SQLException {
		CountryDto countryDto = new CountryDto();//옮겨담을 클래스의 객체를 하나 만드세요
		// 조회 결과에 있는 country_no라는 칸의 데이터를 countryDto에 countryNo 필드에 넣으세요
		//int country_no = rs.getInt("country_no");
		countryDto.setCountryNo(rs.getInt("country_no"));
		//	조회 결과에 있는 country_region라는 칸의 데이터를 countryDto에 countryRegion 필드에 넣으세요
		countryDto.setCountryRegion(rs.getString("country_region"));
		//	조회 결과에 있는 country_name라는 칸의 데이터를 countryDto에 countryName 필드에 넣으세요
		countryDto.setCountryName(rs.getString("country_name"));
		//	조회 결과에 있는 country_capital라는 칸의 데이터를 countryDto에 countryCapital 필드에 넣으세요
		countryDto.setCountryCapital(rs.getString("country_capital"));
		//	조회 결과에 있는 country_population 라는 칸의 데이터를 countryDto에 countryPopulation 필드에 넣으세요
		countryDto.setCountryPopulation(rs.getLong("country_population"));
		return countryDto; //다 넣었으면 반환하세용! 
	}
	
}

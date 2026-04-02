package jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import jdbc.dto.CountryDto;
import jdbc.util.JdbcUtils;

//DAO(Data Access Object)
//- 데이터에 접근하는 작업을 수행하는 객체
//- DB 전담 클래스 (테이블마다 생성)
//- 등록, 수정, 삭제, 조회 등 자주 사용되는 DB작업들을 메소드로 보관
public class CountryDao {
	
	//내가 일을 하려면 메소드가 필요
	//- 등록 메소드 : countryDto
	//public void 이름(매개변수) {
	//- 등록 메소드 : [대륙, 국가명, 수도, 인구수}
	//public void insert(String countryRegion, String countryName, String countryCapital, long countryPopulation) {
		public void insert(CountryDto countryDto) {
			JdbcTemplate jdbcTemplate = JdbcUtils.create();
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") values(country_seq.nextval, ?, ?, ?, ?)";
		Object[] params = {
				countryDto.getCountryRegion(), countryDto.getCountryName() , 
				countryDto.getCountryCapital(), countryDto.getCountryPopulation()
				};
		jdbcTemplate.update(sql, params);
	}
		
		//수정 메소드
//		public int update(int countryNo, String countryRegion, String countryName, String countryCapital, long countryPopultaion) {
		//int형 보다는 메인에 row가 0보다 큰지 0인지 논리값을 출력하는게 더 좋아보임
		// - 등록과 다르게 실행한 뒤 "진짜 수정이 되었는 지"를 알아야함
		// - 반환형을 boolean으로 설정해서 이 결과를 판단해서 내보내도록 처리
		public boolean update(CountryDto countryDto) {
			JdbcTemplate jdbcTemplate = JdbcUtils.create();
			String sql = "update country set country_region =?, "
					+ "country_name =?, "
					+ "country_capital =?, "
					+ "country_population =? "
					+ "where country_no =?";
			Object[] params = {
					countryDto.getCountryRegion(), countryDto.getCountryName() , 
					countryDto.getCountryCapital(), countryDto.getCountryPopulation(),
					countryDto.getCountryNo()
			};
			int rows = jdbcTemplate.update(sql, params);
//			if(rows > 0) return true;
//			else return false; //방법 1
//			return rows > 0 ? true : false; // 방법 2
			return rows > 0; // 한 줄로 표현
		}
		
		//삭제 메소드
		// - 기본키(primary key)를 이용해서 삭제(매개변수가 기본키)
		// - 반환형을 boolean으로 설정해서 진짜로 삭제되었는지를 판정하여 변환
		public boolean delete(int countryNo) {
			JdbcTemplate jdbcTemplate = JdbcUtils.create();
			String sql = "delete country where country_no =?"	;
			Object[] params = {countryNo};
			return jdbcTemplate.update(sql, params) > 0;
		}
}

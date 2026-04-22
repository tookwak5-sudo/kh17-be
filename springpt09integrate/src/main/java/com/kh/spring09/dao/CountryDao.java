package com.kh.spring09.dao;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.dto.CountryDto;
import com.kh.spring09.mapper.CountryMapper;
import com.kh.spring09.vo.PageVo;

@Repository // DB나 파일을 제어하기 위한 도구 (영속성을 가진 대상 제어 도구)
public class CountryDao {
	//주세요! // 단, 등록이 되어 있어야함
	@Autowired
	private JdbcTemplate jdbcTemplate; 
	@Autowired
	private CountryMapper countryMapper;
	Set<String> allowList = Set.of("country_region", "country_name", "country_capital");
	//필요한 기능 등록
	//등록
	public int sequence() {
		String sql = "select country_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(CountryDto countryDto) {
		String sql = "insert into country("
				+ "country_no, country_region, country_name, "
				+ "country_capital, country_population"
				+ ") "
				+ "values(?, ?, ?, ?, ?)";
		Object[] params = {
				countryDto.getCountryNo(),
				countryDto.getCountryRegion(), countryDto.getCountryName(), 
				countryDto.getCountryCapital(), countryDto.getCountryPopulation()
				};
		jdbcTemplate.update(sql, params);
	}
	
	
	//수정 메소드
	public boolean update(CountryDto countryDto) {
		String sql = "update country set country_region =?, "
				+ "country_name =?, "
				+ "country_capital =?, "
				+ "country_population =? "
				+ "where country_no =?";
		Object[] params = {
				countryDto.getCountryRegion(), countryDto.getCountryName(), 
				countryDto.getCountryCapital(), countryDto.getCountryPopulation(),
				countryDto.getCountryNo()
		};
		int rows = jdbcTemplate.update(sql, params);
		return rows > 0; // 한 줄로 표현
	}
	
	//삭제 메소드
	public boolean delete(int countryNo) {
		String sql = "delete country where country_no =?"	;
		Object[] params = {countryNo};
		return jdbcTemplate.update(sql, params) > 0;
	}
	
	
	//조회 메소드
	public List<CountryDto> selectList(int beginRownum, int endRownum){
		String sql = "select * from("
				+ "select rownum rn, TMP.* from("
					+ "select * from country order by country_no asc"
					+ ") TMP"
					+ ") where rn between ? and ?";
		Object[] params = { beginRownum, endRownum};
		return jdbcTemplate.query(sql, countryMapper, params);
	}
	
	//검색 메소드
	public List<CountryDto> selectList(PageVo pageVo){
		if(pageVo.isList())
			return selectList(pageVo.getBeginRownum(), 
					pageVo.getEndRownum());
		
		
		if(allowList.contains(pageVo.getColumn()) == false) 
			return List.of(); 
		
		String sql =  "select * from ("
				+ "select rownum rn, TMP.* from ("
				+ "select * from country "
				+ "where instr("+pageVo.getColumn()+", ?) > 0 "
				+ "order by country asc"
			+ ") TMP"
			+ ") where rn between ? and ?";
		Object[] params = { 
				pageVo.getKeyword(), pageVo.getBeginRownum(), 
				pageVo.getEndRownum() };
		return jdbcTemplate.query(sql, countryMapper, params);
	}
	
	//상세 메소드
			public CountryDto selectOne(int countryNo) {
				String sql = "select * from country where country_no =?";
				Object[] params = {countryNo};
				List<CountryDto> list = jdbcTemplate.query(sql, countryMapper, params); // 일단 목록으로 조회
				return list.isEmpty() ? null : list.get(0);
			}
			
			//카운트 메소드
			public int count() {
				String sql = "select count(*) from country";
				return jdbcTemplate.queryForObject(sql, int.class);
			}
			public int count(PageVo pageVo) {
				if(pageVo.isList()) return count();
				
				if(allowList.contains(pageVo.getColumn()) == false)
					return count();
				
				String sql = "select count(*) from country where instr("+pageVo.getColumn()+", ?) > 0";
				Object[] params = {pageVo.getKeyword()};
				return jdbcTemplate.queryForObject(sql, int.class, params);
			}
			
	// 국기 등록
	public void connect(int countryNo, int attachNo) {
		String sql = "insert into country_flag(country_no, attach_no) values(?, ?)";
		Object[] params = {countryNo, attachNo};
		jdbcTemplate.update(sql, params);
	}
}

package com.kh.spring09.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.spring09.mapper.StatMapper;
import com.kh.spring09.vo.StatVO;

@Repository
public class StatDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private StatMapper statMapper;
	
	public List<StatVO> countryByRegion() {
		String sql = "select country_region title, count(*) value "
				+ "from country group by country_region "
				+ "order by country_region asc";
		return jdbcTemplate.query(sql, statMapper);
	}
	
	public List<StatVO> bookByGenre() {
		String sql = "select book_genre title, count(*) value "
				+ "from book group by book_genre "
				+ "order by book_genre asc";
		return jdbcTemplate.query(sql, statMapper);
	}
}

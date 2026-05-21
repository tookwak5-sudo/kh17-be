package com.kh.exam;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kh.exam.dto.DeptDto;

@SpringBootTest
public class DaoTest {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Test
	public long sequence() {
		String sql = "select dept_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	@Test
	public void test(DeptDto deptDto) {
		String sql = "insert into dept(dept_id, dept_name) "
				+ "values(?, ?)";
		Object[] params = {deptDto.getDeptId(), deptDto.getDeptName()};
		jdbcTemplate.update(sql, params);
	}
}

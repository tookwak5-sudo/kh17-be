package com.kh.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.exam.dto.DeptDto;
import com.kh.exam.mapper.DeptMapper;

@Repository
public class DeptDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DeptMapper deptMapper;
	
	// 부서 등록
	public void insert(DeptDto deptDto) {
		String sql = "insert into dept(dept_id, dept_name, dept_use_yn) "
				+ "values(?, ?, ?)";
		Object[] params = {deptDto.getDeptId(), deptDto.getDeptName(), deptDto.getDeptUseYn()};
		jdbcTemplate.update(sql, params);
	}
	
	// 부서명 전체조회
	public List<DeptDto> deptNameList() {
		String sql = "select * from dept order by dept_id asc";
		return jdbcTemplate.query(sql, deptMapper);
	}

	// 부서코드 중복검사 조회
	public DeptDto selectId(String deptId) {
		String sql = "select * from dept where dept_id=?";
		Object[] params = {deptId};
		List<DeptDto> list = jdbcTemplate.query(sql, deptMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	//  부서이름 중복검사 조회
		public DeptDto selectName(String deptName) {
			String sql = "select * from dept where dept_Name=?";
			Object[] params = {deptName};
			List<DeptDto> list = jdbcTemplate.query(sql, deptMapper, params);
			return list.isEmpty() ? null : list.get(0);
		}
		
		//부서코드 검사 2 조회
		public boolean selectDeptId(String deptId) {
			String sql = "select count(*) from dept where dept_id= ?";
			Object[] params = {deptId};
			return jdbcTemplate.queryForObject(sql, int.class, params) > 0;
		}
}

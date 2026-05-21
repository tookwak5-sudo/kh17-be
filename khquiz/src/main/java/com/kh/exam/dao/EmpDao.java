package com.kh.exam.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kh.exam.dto.DeptDto;
import com.kh.exam.dto.EmpDto;
import com.kh.exam.mapper.EmpMapper;

@Repository
public class EmpDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private EmpMapper empMapper;
	
	//사원 등록
	public int sequence() {
		String sql = "select emp_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}
	public void insert(EmpDto empDto) {
		String sql = "insert into emp(emp_id, emp_dept, emp_name, emp_email, "
				+ "emp_phone, emp_position, emp_hire_date, emp_use_yn) "
				+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {empDto.getEmpId(), empDto.getEmpDept(), empDto.getEmpName()
						,empDto.getEmpEmail(), empDto.getEmpPhone(), empDto.getEmpPosition()
						,empDto.getEmpHireDate(), empDto.getEmpUseYn()};
		jdbcTemplate.update(sql, params);
	}
	
	// 사원아이디 중복검사 조회
	public EmpDto selectId(int empId) {
		String sql = "select * from emp where emp_id=?";
		Object[] params = {empId};
		List<EmpDto> list = jdbcTemplate.query(sql, empMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	
	// 이메일 중복검사 조회
	public EmpDto selectEmail(String empEmail) {
		String sql = "select * from emp where emp_email=?";
		Object[] params = {empEmail};
		List<EmpDto> list = jdbcTemplate.query(sql, empMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
	// 연락처 중복검사 조회
	public EmpDto selectPhone(String empPhone) {
		String sql = "select * from emp where emp_phone=?";
		Object[] params = {empPhone};
		List<EmpDto> list = jdbcTemplate.query(sql, empMapper, params);
		return list.isEmpty() ? null : list.get(0);
	}
}

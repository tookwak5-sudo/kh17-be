package com.kh.exam.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.exam.dto.DeptDto;

@Component
public class DeptMapper implements RowMapper<DeptDto> {

	@Override
	public DeptDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeptDto deptDto = new DeptDto();
		deptDto.setDeptId(rs.getString("dept_id"));
		deptDto.setDeptName(rs.getString("dept_name"));
		deptDto.setDeptUseYn(rs.getString("dept_use_yn"));
		deptDto.setDeptCreatedAt(rs.getTimestamp("dept_created_at"));
		return deptDto;
	}
	
}

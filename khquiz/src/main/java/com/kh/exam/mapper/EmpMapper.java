package com.kh.exam.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.kh.exam.dto.EmpDto;

@Component
public class EmpMapper implements RowMapper<EmpDto>{

	@Override
	public EmpDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmpDto empDto = new EmpDto();
		empDto.setEmpId(rs.getInt("emp_id"));
		empDto.setEmpDept(rs.getString("emp_dept"));
		empDto.setEmpName(rs.getString("emp_name"));
		empDto.setEmpEmail(rs.getString("emp_email"));
		empDto.setEmpPhone(rs.getString("emp_phone"));
		empDto.setEmpPosition(rs.getString("emp_position"));
		empDto.setEmpHireDate(rs.getString("emp_hire_date"));
		empDto.setEmpUseYn(rs.getString("emp_use_yn"));
		empDto.setEmpCreatedAt(rs.getTimestamp("emp_created_at"));
		return empDto;
	}

}

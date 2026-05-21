package com.kh.exam.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class EmpDto {
	private int empId;
	private String empDept;
	private String empName;
	private String empEmail;
	private String empPhone;
	private String empPosition; //직급
	private String empHireDate; //형태(yyyy-MM-dd)
	private String empUseYn; //활동여부
	private Timestamp empCreatedAt; // 등록일자
}

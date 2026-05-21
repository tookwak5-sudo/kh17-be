package com.kh.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.exam.dao.DeptDao;
import com.kh.exam.dao.EmpDao;
import com.kh.exam.dto.DeptDto;
import com.kh.exam.dto.EmpDto;


@Controller
@RequestMapping("/emp")
public class EmpController {
	@Autowired
	private EmpDao empDao;
	@Autowired
	private DeptDao deptDao;
	
	
	//사원 정보 등록
	@GetMapping("/create")
	public String add(@ModelAttribute DeptDto deptDto, Model model) {
		// 부서테이블에서 부서명을 조회한 후 그 값을 emp jsp로 넘기는 작업
		List<DeptDto> deptNameList = deptDao.deptNameList();
		model.addAttribute("deptNameList", deptNameList);
		return "emp/create";
	}
	@PostMapping("/create")
	public String join(@ModelAttribute EmpDto empDto 
						,@ModelAttribute DeptDto deptDto) {//부서명 조회
		//[1]입력된 부서명을 이용하여 DB에 대상이 있는지 조회
		DeptDto findDeptNameDto = deptDao.selectName(empDto.getEmpDept());
		//[2]부서명이 없다면 다시 입력창 돌아가기
		if (findDeptNameDto == null) {
			return "redirect:./create?duplicate1";
		}
		
		//이메일 중복조회
		EmpDto findEmpEmailDto = empDao.selectEmail(empDto.getEmpEmail());
		if (findEmpEmailDto != null) {
			return "redirect:./create?duplicate2";
		}
		//연락처 중복조회
		EmpDto findEmpPhoneDto = empDao.selectPhone(empDto.getEmpPhone());
		if (findEmpPhoneDto != null) {
			return "redirect:./create?duplicate3";
		}
		
		//만약 체크박스가 해제되었다면 "N"을 넣고 첨부하기
		if(empDto.getEmpUseYn() == null) {
			empDto.setEmpUseYn("N");
		}
		
		//번호 생성 후 사원 등록처리
		int empId = empDao.sequence();
		empDto.setEmpId(empId);
		empDao.insert(empDto);
		
		return "redirect:./createComplete";
		//return "redirect:/emp/createComplete";
	}
	
	@RequestMapping("/createComplete")
	public String addComplete() {
		return "emp/createComplete";
	}
}

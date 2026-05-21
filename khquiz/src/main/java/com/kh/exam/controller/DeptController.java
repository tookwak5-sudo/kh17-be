package com.kh.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.exam.dao.DeptDao;
import com.kh.exam.dto.DeptDto;

@Controller
@RequestMapping("/dept")
public class DeptController {
	@Autowired
	private DeptDao deptDao;
	
	//부서 정보 등록
	@GetMapping("/add")
	public String add() {
		return "dept/add";
	}
	@PostMapping("/add")
	public String join(@ModelAttribute DeptDto deptDto, Model model) {
		
		// 부서코드 조회
		//[1] 입력된 부서코드를 이용하여 DB에 대상이 있는지 조회
		DeptDto findIdDeptDto = deptDao.selectId(deptDto.getDeptId());
		if(findIdDeptDto != null) { //중복이야 다시 입력창 돌아가기
			return "redirect:./add?duplicate";
		}
//		if(deptDao.selectDeptId(deptDto.getDeptId())) {
//			return "redirect:./add?duplicate";
//		}
		
		// [2] 입력된 부서이름을 이용하여 DB에 대상이 있는지 조회
		DeptDto findNameDeptDto = deptDao.selectName(deptDto.getDeptName());
		// 있다면
		if(findNameDeptDto != null) {
			return "redirect:./add?duplicate";
		}
		
		//만약 체크박스가 해제되었다면, N
		if(deptDto.getDeptUseYn() == null) {
			deptDto.setDeptUseYn("N");
		}
		
		//다 통과했다면(중복이 없다면) 저장
		deptDao.insert(deptDto);	
		
		return "redirect:./addFinish";
		//return "redirect:/dept/addFinish";
	}
	
	@RequestMapping("/addFinish")
	public String addComplete() {
		return "dept/addFinish";
	}

}

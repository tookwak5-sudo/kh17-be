package com.kh.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.vo.ListVO;
import com.kh.spring11.vo.admin.AdminUserRequestVO;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name= "[관리자] 회원 관리 시스템")
@CommonsApiResponse

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	private AccountDao accountDao;
	
//	//회원 복합 검색
//	@PostMapping("/users")
//	public ListVO users(@RequestBody AdminUserRequestVO vo) {
//		int count = accountDao.complexSearchCount(vo);
//		boolean last = vo.getSize() == null ? true : count <= vo.getSize();
//		return ListVO.builder()
//					.list(accountDao.complexSearch(vo))
//					.last(last)
//				.build();
//	}
	
}

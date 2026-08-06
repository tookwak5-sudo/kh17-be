package com.kh.spring11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.PurchaseDao;
import com.kh.spring11.dto.PurchaseDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name="결제 정보 API")
@AuthApiResponse

@RestController
@RequestMapping("/api/purchase")
public class PurchaseRestController {
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	//소유자 확인이 필요
	@ApiResponse(responseCode = "200", description="결제 정보 조회 성공")
	@GetMapping(value ="/{purchaseNo}", produces = "application/json")
	public PurchaseDto purchase(@PathVariable int purchaseNo,
								@CurrentUser TokenParseResponseVO parseVO) {
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseNo);
		if(purchaseDto == null) 
			throw new TargetNotfoundException(); //결제정보가 없으면(404)
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId()))
			throw new GetOutException(); //소유자가 아니면(403)
		
		return purchaseDto;
	}
}

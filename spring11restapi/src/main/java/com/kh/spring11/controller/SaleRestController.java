package com.kh.spring11.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.service.SaleService;
import com.kh.spring11.vo.sale.SaleAddRequestVO2;
import com.kh.spring11.vo.sale.SaleAddResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="상품 API")
@AuthApiResponse
@RestController
@RequestMapping("/api/sale")
public class SaleRestController {
	
	@Autowired
	private SaleService saleService;
	
	@ApiResponse(responseCode = "200", description ="상품 등록 성공")
	@PostMapping(
			value = "/", 
			produces = "application/json",
			consumes = "multipart/form-data" //spring doc를 위하여 요구형태 명시
	)
	public SaleAddResponseVO add(
		//[1]리엑트에서 데이터들이 낱개로 전송될 경우
//		@Valid @ModelAttribute SaleAddRequestVO request // 모두 낱개로 올 때 쓰는 방ㅇ식
			
		//[2]리엑트에서 데이터들이 파트별로 전송될 경우
		@Valid @RequestPart(value = "sale") SaleAddRequestVO2 request, //6개의 데이터가 담길 객체
		@Valid @RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail	//썸네일이 담길 객체(이쪽을 선호)
		)throws IllegalStateException, IOException {
//		return saleService.add(request); // [1]
		return saleService.add(request, thumbnail); // [2]
	}
}

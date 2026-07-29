package com.kh.spring11.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.service.SaleService;
import com.kh.spring11.vo.sale.SaleAddRequestVO;
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
	@PostMapping(value = "/", produces = "application/json")
	public SaleAddResponseVO add(
		@Valid @ModelAttribute SaleAddRequestVO request) throws IllegalStateException, IOException {
		System.out.println("Controller 진입");
		return saleService.add(request);
	}
}

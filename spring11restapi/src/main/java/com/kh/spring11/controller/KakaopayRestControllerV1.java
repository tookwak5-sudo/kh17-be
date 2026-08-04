package com.kh.spring11.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.configuration.KakaopayProperties;
import com.kh.spring11.service.KakaopayService;
import com.kh.spring11.vo.kakaopay.KakaopayBuyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayBuyResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name= "무식한 결제 API")
@AuthApiResponse
@RestController
@RequestMapping("/api/kakaopay/v1")
public class KakaopayRestControllerV1 {
	@Autowired
	private KakaopayService kakaopayService;
	
	@Autowired
	private KakaopayProperties kakaopayProperties;
	
	@ApiResponse(responseCode = "200", description = "무식한 결제 성공")
	@PostMapping(value ="/buy", produces = "application/json")
	public KakaopayBuyResponseVO buy(KakaopayBuyRequestVO request) {
//		보낼 데이터(Body) 준비(필수요소만)
		KakaopayReadyRequestVO payRequest = KakaopayReadyRequestVO.builder()
					.cid(kakaopayProperties.getCid())
					.partnerOrderId(UUID.randomUUID().toString())
					.partnerUserId("testuser1")
					.itemName(request.getName())
					.totalAmount(request.getPrice())
					.approvalUrl("http://localhost:8080/success")
					.cancelUrl("http://localhost:8080/cancel")
					.failUrl("http://localhost:8080/fail")
				.build();
		
		KakaopayReadyResponseVO payResponse = kakaopayService.ready(payRequest);
		
		return KakaopayBuyResponseVO.builder()
					.url(payResponse.getNextRedirectPcUrl())
				.build();
	}
}

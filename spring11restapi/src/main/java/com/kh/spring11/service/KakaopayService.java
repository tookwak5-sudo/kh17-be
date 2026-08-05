package com.kh.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kh.spring11.configuration.KakaopayProperties;
import com.kh.spring11.vo.kakaopay.KakaopayApproveRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayApproveResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class KakaopayService {
		//Autowired만 적으면 동일한 요소가 애플리케이션에 2개 이상이 있을 경우 오류발생
		//추가로 @Qualifier를 적어서 아이디를 지정하여 주입한다
		@Qualifier("kakaopayClient")
		@Autowired
		private WebClient webClient;
		@Autowired
		private KakaopayProperties kakaopayProperties;
	
	//결제준비
	public KakaopayReadyResponseVO ready(KakaopayReadyRequestVO request) {
//		상세 주소 설정
		String url = "/online/v1/payment/ready";
		
//		(+추가) approvalUrl, cancelUrl, failUrl을 현재 페이지 주소를 알아내서 계산
		log.debug("context path = {}", ServletUriComponentsBuilder.fromCurrentContextPath());
		log.debug("current request = {}", ServletUriComponentsBuilder.fromCurrentRequest()); //?안 붙음 
		log.debug("current requestURI = {}", ServletUriComponentsBuilder.fromCurrentRequestUri()); //쿼리스트림 즉, ?가 붙음 
		log.debug("current Servlet mapping = {}", ServletUriComponentsBuilder.fromCurrentServletMapping());
		
		//CID 매번 설정하지말고 서비스에서 자동으로 지정(설정값 활용)
		request.setCid(kakaopayProperties.getCid());
		
		String baseUrl = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
		request.setApprovalUrl(baseUrl+"/success/"+request.getPartnerOrderId());
		request.setCancelUrl(baseUrl+"/cancel/"+request.getPartnerOrderId());
		request.setFailUrl(baseUrl+"/fail/"+request.getPartnerOrderId());
		
//		요청 발송 및 응답 수신
		KakaopayReadyResponseVO response = webClient.post() //POST요청
				.uri(url)//상세주소
				.bodyValue(request)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayReadyResponseVO.class)//일시불(Mono)로 수신 (할부는 Flux)
				.block(); //동기방식으로 수신
		//응답데이터 반환
		return response;
	}
	
	//결제승인
	public KakaopayApproveResponseVO approve(KakaopayApproveRequestVO request) {
		String url = "/online/v1/payment/approve";
		
		//CID 매번 설정하지말고 서비스에서 자동으로 지정(설정값 활용)
		request.setCid(kakaopayProperties.getCid());
		
		KakaopayApproveResponseVO response = webClient.post() //POST요청
				.uri(url)//상세주소
				.bodyValue(request)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(KakaopayApproveResponseVO.class)//일시불(Mono)로 수신 (할부는 Flux)
				.block(); //동기방식으로 수신
		
		return response;
	}
}

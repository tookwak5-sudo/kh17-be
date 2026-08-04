package com.kh.spring11.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test02카카오페이승인요청 {
	
	@Test
	public void test() {
//		카카오페이 요청사항
//		POST /online/v1/payment/approve HTTP/1.1
//		Host: open-api.kakaopay.com
//		Authorization: SECRET_KEY ${SECRET_KEY}
//		Content-Type: application/json
		
		WebClient webClient = WebClient.builder()
				.baseUrl("https://open-api.kakaopay.com")
				.defaultHeader("Authorization", "SECRET_KEY DEV7666CCB40C0DA849EDC018AC9FB809D3F93F7")
				.defaultHeader("Content-Type", "application/json")
			.build();
		
		String url = "/online/v1/payment/approve";
		
		Map<String, String> body = new HashMap<>();
		body.put("cid", "TC0ONETIME");//가맹점 코드
		body.put("tid", "Ta714bd457126faabd68");
		body.put("partner_order_id", "ae385aaf-757b-4583-a69d-db933b53b990");
		body.put("partner_user_id", "testuser1");
		body.put("pg_token", "5f066674da0c7f754176");
		
		Map response = webClient.post() //POST요청
				.uri(url)//상세주소
				.bodyValue(body)//첨부데이터
			.retrieve()//응답 수신 허용
				.bodyToMono(Map.class)//일시불(Mono)로 수신 (할부는 Flux)
				.block(); //동기방식으로 수신
		
		for(Object key : response.keySet()) {
			Object value = response.get(key);
			log.debug("{} = {}", key, value);
		}
	}
}

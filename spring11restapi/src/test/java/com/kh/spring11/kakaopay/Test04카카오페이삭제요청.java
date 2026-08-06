package com.kh.spring11.kakaopay;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

import com.kh.spring11.configuration.KakaopayProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class Test04카카오페이삭제요청 {
	
	@Qualifier("kakaopayClient")
	@Autowired
	private WebClient webClient;
	
	@Autowired
	private KakaopayProperties kakaopayProperties;
	
	@Test
	public void test() {
		String url = "/online/v1/payment/cancel";
		
		Map<String, String> body =	new HashMap<>();
		body.put("cid", kakaopayProperties.getCid());
		body.put("tid", "Ta72f4e0617301448254");
		body.put("cancel_amount", "1");
	}
}

package com.kh.spring11.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class KakaopayConfiguration {
	@Autowired
	private KakaopayProperties kakaopayProperties;
	
    @Bean("kakaopayClient")
	public WebClient webClient() {
		return WebClient.builder()
					.baseUrl("https://open-api.kakaopay.com")
					.defaultHeader("Authorization", "SECRET_KEY "+kakaopayProperties.getSecretKey())
					.defaultHeader("Content-Type", "application/json")
				.build();
	}
	
}

package com.kh.spring13.ollama5;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class Tev1Test01 {
	
	@Test
	public void test() {
		WebClient webClient = WebClient.builder()
				.baseUrl("http://localhost:11434")
			.build();
		
		/*
		보내야 되는 요청 데이터의 형태
		
		{
			"model":"tev1:4b",
			"state":"오늘 너무 날씨가 맑아서 기분이 좋아!",
			"questions":{
				"emotion":{
					"type":"choice",
					"instructions":"문장의 감정을 판단하세요",
					"criteria":{
						"positive":"긍정적",
						"negative":"부정적"
					}
				}
				
			}
		}
		*/
		Map<String, Object> request = new HashMap<>();
		request.put("model", "tev1:4b");
		request.put("state", "리액트는 쓰레기가 아닙니다");
		request.put("questions", Map.of(
			"emotion", Map.of(
				"type", "choice",
				"instructions", "문장의 감정을 판단하세요",
				"criteria", Map.of(
					"positive", "긍정적",
					"negative", "부정적"
				)
			)
		));
		
		String response = webClient.post()
				.uri("/v1/systemone")
					.bodyValue(request)
				.retrieve()
					.bodyToMono(String.class)
				.block();
		
		System.out.println("응답" + response);
	}
}

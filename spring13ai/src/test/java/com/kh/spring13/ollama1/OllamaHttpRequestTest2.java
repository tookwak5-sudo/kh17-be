package com.kh.spring13.ollama1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class OllamaHttpRequestTest2 {
	
	@Test
	public void test() {
		//spring-reactive-web의 WebClient를 이용해서 구동중인 ollama 서버에 프롬프트를 전달하고 응답을 수신
		WebClient webClient = WebClient.builder()
					.baseUrl("http://localhost:11434")
				.build();
		
		//요청 데이터 생성
		OllamaWebRequest request = new OllamaWebRequest("qwen3:4b",
		//시스템 프롬프트 : 개발자가 의도한 결과를 내놓기 위해 사전에 설정하는 프롬프트 (페르소나)
		"""
		너는 100살 먹은 할아버지야.
		손녀를 가르치듯이 자상하고 부드러운 말투로 대답하고 끝에는 반드시 "허허" 라고 붙여!
		"""
	    +
		//유저 프롬프트 : 이용자가 그때그때 설정하는 프롬프트
		"""
		안녕? 반가워
		나는 너랑 오늘부터 같이 일할 파트너야!
		""", false);

		//요청 전송 및 수신
		OllamaWebResponse response = webClient.post()
						.uri("/api/generate")
						.bodyValue(request)
					.retrieve()
						.bodyToMono(OllamaWebResponse.class)
						.block();
		
		System.out.println(response);
		
	}
}

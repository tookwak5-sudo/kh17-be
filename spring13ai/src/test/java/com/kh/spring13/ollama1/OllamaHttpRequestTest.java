package com.kh.spring13.ollama1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class OllamaHttpRequestTest {
	
	@Test
	public void test() {
		//spring-reactive-web의 WebClient를 이용해서 구동중인 ollama 서버에 프롬프트를 전달하고 응답을 수신
		WebClient webClient = WebClient.builder()
					.baseUrl("http://localhost:11434")
				.build();
		
		//요청 데이터 생성
		Map request = new HashMap<>();
		request.put("model", "qwen3:4b"); //요청할 AI 모델
		request.put("prompt", "안녕?"); //요청할 플롬프트
		request.put("stream", false); //스트리밍 사용 여부
		
		//요청 전송 및 수신
		Map response = webClient.post()
						.uri("/api/generate")
						.bodyValue(request)
					.retrieve()
						.bodyToMono(Map.class)
						.block();
		
		System.out.println(response);
		
		//필드명만 확인
		Set keys = response.keySet();
		for(Object key : keys) {
			System.out.println(key);
		}
	}
}

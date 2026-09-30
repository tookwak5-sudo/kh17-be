package com.kh.spring13.ollama2;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

import com.kh.spring13.service.OllamaService;

@SpringBootTest
public class SpringAiTest05 {
	//Spring AI에서는 application.properties에 설정된 값들을 주입해서 자동으로 ChatModel을 생성해준다
	//-> 대부분의 옵션을 컨트롤할 수 있지만 타임아웃을 조정할 수 없다는 치명적인 단점이 존재한다
	@Autowired
	private OllamaService ollamaService;
	
	@Test
	public void test() {
//		String response = ollamaService.askToProfessor("AI 뭐가 좋아?");
		String response = ollamaService.askToChildren("AI 뭐가 좋아?");
//		String response = ollamaService.askToGrandpa("AI 뭐가 좋아?");
		System.out.println(response.strip());
		
	}
}

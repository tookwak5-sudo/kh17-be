package com.kh.spring13.ollama2;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.model.ollama.autoconfigure.OllamaChatProperties;
import org.springframework.ai.model.ollama.autoconfigure.OllamaConnectionProperties;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@SpringBootTest
public class SpringAiTest02 {
	
	@Autowired
	private OllamaConnectionProperties connectionProperties;
	@Autowired
	private OllamaChatProperties chatProperties;
	
//	@Test
	public void print() {
		System.out.println(connectionProperties.getBaseUrl());
		System.out.println(chatProperties.getModel());
		System.out.println(chatProperties.getTemperature());
		System.out.println(chatProperties.getThink());
		System.out.println(chatProperties.toOptions().getKeepAlive());
		System.out.println(chatProperties.toOptions().getNumCtx());
	}
	
	@Test
	public void test() {
		
		long start =System.currentTimeMillis();
		
		//spring-ai에서 제공하는 객체들로 ollama server에 요청을 보내고 응답을 받자
		JdkClientHttpRequestFactory factory = new JdkClientHttpRequestFactory();
		factory.setReadTimeout(Duration.ofMinutes(5L));
		
		RestClient.Builder builder = RestClient.builder().requestFactory(factory);
		
		OllamaApi ollamaApi = OllamaApi.builder()
					.baseUrl(connectionProperties.getBaseUrl())
					.restClientBuilder(builder)
				.build();
		
		OllamaChatModel chatModel = OllamaChatModel.builder()
					.ollamaApi(ollamaApi)
					.options(chatProperties.toOptions())
				.build();
		
		ChatClient chatClient = ChatClient.builder(chatModel).build();
		
		String response = chatClient.prompt()
								.system("your age is 100 old man, when you answered question you need to add '허허' to the sentence end point")
								.user("AI의 장점1가지")
							.call().content();
		
		//(+추가) 생각부분을 제거
		String endTag = "</think>";
		int position = response.indexOf("</think>");
		if(position >= 0) {
			response =response.substring(position + endTag.length());
		}
		
		System.out.println(response.strip());
		
//		System.out.println("총 소용시간 : " + )
	}
}

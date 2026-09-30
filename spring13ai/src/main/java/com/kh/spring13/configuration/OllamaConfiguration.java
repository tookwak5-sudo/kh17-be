package com.kh.spring13.configuration;

import java.time.Duration;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.model.ollama.autoconfigure.OllamaChatProperties;
import org.springframework.ai.model.ollama.autoconfigure.OllamaConnectionProperties;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;

@Configuration
public class OllamaConfiguration {
	//ollama server에 접속하기 위한 ChatClient까지 모두 @Bean으로 등록
	@Autowired
	private OllamaConnectionProperties connectionProperties;
	@Autowired
	private OllamaChatProperties chatProperties;
	
	@Bean
	public OllamaApi ollamaApi() {
		JdkClientHttpRequestFactory factory = new JdkClientHttpRequestFactory();
		factory.setReadTimeout(Duration.ofMinutes(5L));
		
		RestClient.Builder builder = RestClient.builder().requestFactory(factory);
		
		OllamaApi ollamaApi = OllamaApi.builder()
					.baseUrl(connectionProperties.getBaseUrl())
					.restClientBuilder(builder)
				.build();
		
		return ollamaApi;
	}
	
	@Bean
	public OllamaChatModel ollamaChatModel(OllamaApi ollamaApi) { //만들때는 정해진 형태(업케스팅x) 
		OllamaChatModel chatModel = OllamaChatModel.builder()
				.ollamaApi(ollamaApi)
				.options(chatProperties.toOptions())
			.build();
		
		return chatModel;
	}
	
	//메모리
	@Bean
	public MessageWindowChatMemory chatMemory () {
		return MessageWindowChatMemory.builder()
					.maxMessages(10)//기억할 누적 대화 개수
				.build();
	}
	
	@Bean
	public ChatClient chatClient(ChatModel chatModel, ChatMemory chatMemory) {
		return ChatClient
					.builder(chatModel)
					.defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
				.build();
	}
}

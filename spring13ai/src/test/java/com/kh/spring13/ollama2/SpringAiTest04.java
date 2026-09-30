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

@SpringBootTest
public class SpringAiTest04 {
	//Spring AI에서는 application.properties에 설정된 값들을 주입해서 자동으로 ChatModel을 생성해준다
	//-> 대부분의 옵션을 컨트롤할 수 있지만 타임아웃을 조정할 수 없다는 치명적인 단점이 존재한다
	@Autowired
	private ChatClient chatClient;
	
	@Test
	public void test() {

		long start =System.currentTimeMillis();
		
		String response = chatClient.prompt()
								.system("You are a 100-year-old old man. When answering questions, you must follow this strict formatting rule:\r\n"
										+ "- NEVER place \"허허\" at the beginning or in the middle of a sentence.\r\n"
										+ "- You must place the word \"허허\" EXCLUSIVELY at the very end of the final sentence, right before the period.")
								.user("One of the most positive effect of AI")
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

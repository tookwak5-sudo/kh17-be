package com.kh.spring13.ollama4;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatMemoryTest01 {
	
	@Autowired 
	private ChatModel chatModel;
	@Autowired
	private ChatMemory chatMemory;
	
	@Test
	public void test() {
		//ChatClient를 생성할 때, chatMemory를 설정해서 이력을 관리하도록 지시
		
		//메모리 없는 기존 클라이언트
//		ChatClient chatClient  = ChatClient.builder(chatModel).build();
		
		//메모리 설정이 있는 클라이언트
		ChatClient chatClient  = ChatClient
				.builder(chatModel)
				.defaultAdvisors(
					MessageChatMemoryAdvisor.builder(chatMemory).build()//메모리 설정 추가
				)
				.build();
		
		//질문을 2번 한다. (내 이름은 피카츄야.. 기억해둬!) -> (내 이름이 뭐라고?)
		String uuid = UUID.randomUUID().toString();
		System.out.println("conversation ID = " + uuid);
		String response1 = chatClient.prompt()
				.user("내 이름은 피카츄야 기억해줘")
				.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, uuid)) //Conversation ID 설정
				.call().content();
		String response2 = chatClient.prompt()
				.user("내 이름이 뭐라고 했죠?")
				.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, uuid)) //Conversation ID 설정	
				.call().content();
		
		System.out.println("<1번 응답>");
		System.out.println(response1);
		System.out.println("<2번 응답>");
		System.out.println(response2);
	}
}

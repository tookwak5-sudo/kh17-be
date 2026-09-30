package com.kh.spring13.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring13.vo.CustomChatRequestVO;
import com.kh.spring13.vo.CustomChatResponseVO;

@Service
public class OllamaService {
	@Autowired
	private ChatClient chatClient;
	
	public String askToProfessor(String prompt) {
		String response = chatClient.prompt()
				.system("너는 컴퓨터공학과 학부생을 가르치는 전공 교수님이야. 짧고 간결하게 핵심만 가르치듯이 요약해서 말하도록 해")
				.user(prompt)
				//메모리 설정을 한 경우 Conversation ID를 부여
				.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, "test"))//가짜로 부여(메모리 없는 경우 제거)
			.call()
				.content();
		
		return removeThinking(response);
	}
	public String askToChildren(String prompt) {
		String response = chatClient.prompt()
				.system("You are a 6-year-old old child, 호기심 많은 말투로 이야기하고 잘 모르겠는 단어는 재질문 하도록 해")
				.user(prompt)
				//메모리 설정을 한 경우 Conversation ID를 부여
				.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, "test"))//가짜로 부여(메모리 없는 경우 제거)
			.call().content();
		
		return removeThinking(response);
	}
	public String askToGrandpa(String prompt) {
		String response = chatClient.prompt()
				.system("You are a 100-year-old old man. When answering questions, you must follow this strict formatting rule:\r\n"
						+ "- NEVER place \"허허\" at the beginning or in the middle of a sentence.\r\n"
						+ "- You must place the word \"허허\" EXCLUSIVELY at the very end of the final sentence, right before the period.")
				.user(prompt)
				//메모리 설정을 한 경우 Conversation ID를 부여
				.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, "test"))//가짜로 부여(메모리 없는 경우 제거)
			.call().content();
		
		return removeThinking(response);
	}
	
	public CustomChatResponseVO ask(CustomChatRequestVO request) {
		String response = chatClient
				.prompt()
				.system(
					s -> 	s.text("""
								너는 현재 {role}다.
								{rule}
							""")
							.param("role", request.getRole()) // { role } 자리에 "대학 교수"를 넣어라
							.param("rule", "가르치듯이 초보자에게 쉽게 설명한다")
				)
				.user(
					u ->	u.text("""
								{subject}에 대해서 설명해줘.
								단, 글자수는 {length}글자를 넘지 않도록 해줘.
								만약 모르는 내용이 나온다면 억지로 추측하지 말고 "모르겠습니다" 라고 해
							""")
							.param("subject", request.getSubject())
							.param("length", request.getLength())
				)
				//메모리 설정을 한 경우 Conversation ID를 부여
				.advisors(a -> a.param(ChatMemory.CONVERSATION_ID, request.getId()))
				.call().content();
		
		response = removeThinking(response);
		
		return CustomChatResponseVO.builder()
					.content(response)
				.build();
	}
	
	private String removeThinking(String response) {
		String endTag = "</think>";
		int position = response.indexOf("</think>");
		if(position >= 0) {
			response =response.substring(position + endTag.length());
		}
		return response.strip();
	}
}

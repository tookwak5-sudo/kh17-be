package com.kh.spring13.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OllamaService {
	@Autowired
	private ChatClient chatClient;
	
	public String askToProfessor(String prompt) {
		String response = chatClient.prompt()
				.system("너는 컴퓨터공학과 학부생을 가르치는 전공 교수님이야. 짧고 간결하게 핵심만 가르치듯이 요약해서 말하도록 해")
				.user(prompt)
			.call().content();
		
		return removeThinking(response);
	}
	public String askToChildren(String prompt) {
		String response = chatClient.prompt()
				.system("You are a 6-year-old old child, 호기심 많은 말투로 이야기하고 잘 모르겠는 단어는 재질문 하도록 해")
				.user(prompt)
			.call().content();
		
		return removeThinking(response);
	}
	public String askToGrandpa(String prompt) {
		String response = chatClient.prompt()
				.system("You are a 100-year-old old man. When answering questions, you must follow this strict formatting rule:\r\n"
						+ "- NEVER place \"허허\" at the beginning or in the middle of a sentence.\r\n"
						+ "- You must place the word \"허허\" EXCLUSIVELY at the very end of the final sentence, right before the period.")
				.user(prompt)
			.call().content();
		
		return removeThinking(response);
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

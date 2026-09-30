package com.kh.spring13.ollama3;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTemplateTest01 {
	@Autowired
	private ChatClient chatClient;
	
	@Test
	public void test() {
		//프롬프트 템플릿을 사용하여 AI 서버에 요청하기
		String response = chatClient
				.prompt()
				.system(
					s -> 	s.text("""
								너는 현재 {role}다.
								{rule}
							""")
							.param("role", "대학 교수") // { role } 자리에 "대학 교수"를 넣어라
							.param("rule", "가르치듯이 초보자에게 쉽게 설명한다")
				)
				.user(
					u ->	u.text("""
								{subject}에 대해서 설명해줘.
								단, 글자수는 {length}글자를 넘지 않도록 해줘.
								만약 모르는 내용이 나온다면 억지로 추측하지 말고 "모르겠습니다" 라고 해
							""")
							.param("subject", "너랑 kanana 중에 누가 더 똑똑해?")
							.param("length", 1000)
				)
				.call().content();
		
		System.out.println(response);
				
	}
}
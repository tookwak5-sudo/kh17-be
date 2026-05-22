package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지 {
	@Autowired
	private JavaMailSender sender;
	
	@Test
	public void test() throws MessagingException {
		//마임메세지 (MIME Message) ex) text/html
		//- 이메일에 텍스트 외에 멀티미디어 데이터를 첨부하여 전송할 수 있도록 개발된 표준 형식
		//- 마임메세지를 직접 생성하면 모든 형식을 다 구현해야 하므로 sender을 이용해서 생성
		
//		MimeMessage message = new MimeMessage(???);
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = 
				new MimeMessageHelper(message, false, "UTF-8");
		
//		helper.setFrom("tookwak5@gmail.com");
//		helper.setTo("tookwak2@gmail.com");
		helper.setTo(new String[] {"tookwak5@gmail.com", "hlh0805@naver.com"});
		helper.setSubject("마임메세지 연습");
		helper.setText("<h1>반가워!</h1>", true); // HTML모드
		
		sender.send(message);
	}
}

package com.kh.spring09.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
public class Test01이메일보내기2 {
	
	@Autowired
	private JavaMailSender sender; 
	//생성과 사용이 분리되어있기 때문에 마치 java의 업케스팅처림 Imple이 붙으면 정보를 설정해서 만드는 클래스이기 때문에   
	//private JavaMailSenderImpl sender;
	
	@Test
	public void test() {
		// 메세지 생성 : 얘는 메세지로 한번쓰고 버리는 DTO같은 소모품(도구가 아님)  
		SimpleMailMessage message = new SimpleMailMessage();
		
		// 메세지 내용 작성( 제목 내용 참조 숨은 참조) 
		message.setFrom("tookwak4@gmail.com");
		message.setTo("tootae2@naver.com");
		// message.setCc("참조이메일주소");
		// message.setBcc("숨은참조이메일주소");
		message.setSubject("테스트 메일 발송");
		message.setText("이메일 발송 테스트1");
		
		// 전송
		sender.send(message);
		
	}
}

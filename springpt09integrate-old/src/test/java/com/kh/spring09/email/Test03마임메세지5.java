package com.kh.spring09.email;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.kh.spring09.service.EmailService;
import com.kh.spring09.service.RandomService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지5 {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private EmailService emailService;
	@Autowired
	private RandomService randomService;
	
	@Test
	public void test() throws MessagingException, IOException {
		
		
		
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = 
				new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setFrom("tookwak4@gmail.com");
		helper.setTo(new String[] {"tookwak5@gmail.com"});
		helper.setSubject("[KH정보교육원] 인증번호테스트");
		
		
		ClassPathResource resource = 
				new ClassPathResource("templates/cert-template.html"); //src제외한 나머지 경로
		File target = resource.getFile();
		
		//전송할 번호 생성
		String certNumber = randomService.generateNumber(6);
		
//		템플릿 생성
		String template = emailService.createCertHtml(certNumber);
		
		helper.setText(template, true); // HTML모드
		
		sender.send(message);
	}
}

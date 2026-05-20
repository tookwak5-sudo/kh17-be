package com.kh.spring09.service;

import java.text.DecimalFormat;
import java.text.Format;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private RandomService randomService;
	
	//이 메소드는 이제부터 비동기(백그라운드,멀티스레드)로 실행된다고 선언!
	@Async
	public void sendWelcomeMail(String memberEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("tookwak4@gmail.com");
		message.setTo(memberEmail);
		message.setSubject("[KH정보교육원] 가입을 진심으로 환영합니다!");
		message.setText("앞으로도 많은 활동 부탁드립니다!");
		sender.send(message);
	}
	
	//인증번호 발송 메소드
	public void sendCertNumber(String memberEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("tookwak4@gmail.com");
		message.setTo(memberEmail);
		message.setSubject("[KH정보교육원] 인증코드가 도착하였습니다!");
		
		String number = randomService.generateNumber(6);
		message.setText("인증번호는 [" + number + "] 입니다. \n입력창에 입력 후 확인을 눌러주세요");
		sender.send(message);
	}
}

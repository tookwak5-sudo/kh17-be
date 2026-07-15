package com.kh.spring11.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.kh.spring11.dao.CertDao;
import com.kh.spring11.dto.CertDto;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private RandomService randomService;
	
	@Autowired
	private CertDao certDao;
	
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
	
	//인증번호 발송 메소드 (단문메일용)
	public void sendCertNumber(String memberEmail) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("tookwak4@gmail.com");
		message.setTo(memberEmail);
		message.setSubject("[KH정보교육원] 인증코드가 도착하였습니다!");
		
		//인증번호 생성(랜덤으로)
		String number = randomService.generateNumber(6);
		message.setText("인증번호는 [" + number + "] 입니다. \n입력창에 입력 후 확인을 눌러주세요");
		
		//이메일 발송
		sender.send(message);
		
		//발송이 되었다면, DB등록 혹은 갱신처리
		CertDto certDto = certDao.find(memberEmail);
		if(certDto == null) { //처음 보내는 이메일
			certDao.add(CertDto.builder()
						.certEmail(memberEmail)
						.certNumber(number)
					.build());
		}
		else { //이미 보낸적이 있는 이메일
			certDao.change(CertDto.builder()
					.certEmail(memberEmail)
					.certNumber(number)
				.build());
		}
	}
	
	//인증번호 발송 메소드 (마임메세지용)
	public void sendCertNumber2(String memberEmail) throws MessagingException, IOException {
		//SimpleMailMessage message = new SimpleMailMessage();
		MimeMessage message =sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, false, "UTF-8");
		
		helper.setFrom("tookwak4@gmail.com");
		helper.setTo(memberEmail);
		helper.setSubject("[KH정보교육원] 인증코드가 도착하였습니다!");
		
		//인증번호 생성(랜덤으로)
		String number = randomService.generateNumber(6);
		
		//HTML 템플릿 생성
		String template = this.createCertHtml(number);
		
		helper.setText(template, true);
		
		//이메일 발송
		sender.send(message);
		
		//발송이 되었다면, DB등록 혹은 갱신처리
		CertDto certDto = certDao.find(memberEmail);
		if(certDto == null) { //처음 보내는 이메일
			certDao.add(CertDto.builder()
						.certEmail(memberEmail)
						.certNumber(number)
					.build());
		}
		else { //이미 보낸적이 있는 이메일
			certDao.change(CertDto.builder()
					.certEmail(memberEmail)
					.certNumber(number)
				.build());
		}
	}
	
	public String createCertHtml(String certNumber) throws IOException {
		//뽑아내서 자바io형태로 저장
				ClassPathResource resource = 
						new ClassPathResource("templates/cert-template.html"); //src제외한 나머지 경로
				File target = resource.getFile();
				
				
//				파일을 읽을 준비
				BufferedReader reader = new BufferedReader(new FileReader(target));
				
//				StringBuffer를 이용해서 합성해서 전송
				StringBuffer buffer = new StringBuffer();
				
//				한 줄씩 읽어와서 합성
				while(true) {
					String line = reader.readLine(); //한 줄씩 읽어서
					if(line == null) break; // EOF발견 시 탈출
					buffer.append(line); // 버퍼에 추가
				}
				
				reader.close(); //사용을 완료한 통로 정리
				
				//문자열로 뽑아내는 것까지는 기존 예제와 동일
				String html = buffer.toString();
				
				//Jsoup이란 기술을 이용해서 문자열을 html로 변환한 뒤 원하는 태그를 찾아 변조
				Document document = Jsoup.parse(html);
				
				//var list = $(".number-wrapper"); // jquery였다면
				Elements list = document.select(".number-wrapper"); //number-wrapper 클래스를 찾고 
				
				for(int i =0; i < list.size(); i++) { // 반복해서
					Element tag = list.get(i); // 태그정보를 알아낸뒤
					char ch = certNumber.charAt(i); // 인증번호 한 자리를 뽑아서
					tag.text(String.valueOf(ch)); // 설정
				}
				return document.toString();
	}
	
}

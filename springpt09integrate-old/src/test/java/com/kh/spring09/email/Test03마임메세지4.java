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

import com.kh.spring09.service.RandomService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@SpringBootTest
public class Test03마임메세지4 {
	@Autowired
	private JavaMailSender sender;
	@Autowired
	private RandomService randomService;
	
	@Test
	public void test() throws MessagingException, IOException {
		//마임메세지 (MIME Message) ex) text/html
		//- 이메일에 텍스트 외에 멀티미디어 데이터를 첨부하여 전송할 수 있도록 개발된 표준 형식
		//- 마임메세지를 직접 생성하면 모든 형식을 다 구현해야 하므로 sender을 이용해서 생성
		
//		MimeMessage message = new MimeMessage(???);
		MimeMessage message = sender.createMimeMessage();
		
		MimeMessageHelper helper = 
				new MimeMessageHelper(message, false, "UTF-8");
		
//		helper.setFrom("tookwak5@gmail.com");
//		helper.setTo("tookwak2@gmail.com");
		helper.setTo(new String[] {"tookwak5@gmail.com"});
		helper.setSubject("[KH정보교육원] 인증번호테스트");
		
//		미리 만들어둔 templates/cert-template.html을 읽어들여서 전송
//		- 자바처럼 File로 할까? 위치는 어떻게?
//		- Spring은 기본적으로 두 가지의 경로를 제공 (filepath, classpath)
//		- filepath는 프로젝트 전체에서의 경로 (최종 배포파일과는 무관) // 사용법 file:
//		- classpath는 src 내부의 경로 (최종 배포파일과 동일) // 사용법 classpath:
		
		//뽑아내서 자바io형태로 저장
		ClassPathResource resource = 
				new ClassPathResource("templates/cert-template.html"); //src제외한 나머지 경로
		File target = resource.getFile();
		
		//전송할 번호 생성
		String certNumber = randomService.generateNumber(6);
		
//		파일을 읽을 준비
		BufferedReader reader = new BufferedReader(new FileReader(target));
		
//		StringBuffer를 이용해서 합성해서 전송
		StringBuffer buffer = new StringBuffer();
		
//		한 줄씩 읽어와서 합성
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
		
		helper.setText(document.toString(), true); // HTML모드
		
		sender.send(message);
	}
}

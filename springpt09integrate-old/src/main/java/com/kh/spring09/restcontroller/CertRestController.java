package com.kh.spring09.restcontroller;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.CertDao;
import com.kh.spring09.dto.CertDto;
import com.kh.spring09.service.EmailService;

import jakarta.mail.MessagingException;

@CrossOrigin
@RestController
@RequestMapping("/rest/cert")
public class CertRestController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private CertDao certDao;
	
	@PostMapping("/send")
	public void send(@RequestParam String certEmail) throws MessagingException, IOException {
		//emailService.sendCertNumber(certEmail); //이메일 발송작업 완료
		emailService.sendCertNumber2(certEmail); //이메일 발송작업 완료
	}
	
	@PostMapping("/check")
	public boolean check(@ModelAttribute CertDto certDto) {
		//[1] 정보가 있는 지 확인
		CertDto findDto = certDao.selectOne(certDto.getCertEmail());
//		if(findDto == null) throw new WhoAreYouException(); //에러로 처리 
		if(findDto == null) return false;
		
		//[2] 시간이 유효한 지 확인(현재시간과 보낸시간을 확인)
		LocalDateTime current = LocalDateTime.now(); //현재시각
		LocalDateTime sent = findDto.getCertTime().toLocalDateTime(); //발송시각
		Duration duration = Duration.between(sent, current);
		if(duration.toMinutes() > 10) { //10분이 지났다면
			return false;
		}
		
		//[3] 번호가 맞는 지 확인(이메일은 이미 확인했기 때문)
		boolean valid = certDto.getCertNumber().equals(findDto.getCertNumber());
		if(!valid) return false;
		
		//[4] 인증 가능한 상태인지 확인(cert_yn이 N인 경우)
		//if(findDto.getCertYn().equals("Y")) {
		if(findDto.isComplete()) {
			return false;
		}
		
		//certDao.delete(certDto.getCertEmail()); // 사용한 인증번호 지우기!
		certDao.update(certDto.getCertEmail()); //인증완료 업데이트
		return true; //통과 & 인증번호 초기화
	}
}

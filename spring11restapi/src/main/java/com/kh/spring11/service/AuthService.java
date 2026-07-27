package com.kh.spring11.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthLoginResponseVO;

//인증과 관련된 복잡한 작업들을 모듈화 하여 처리하기 위한 서비스
@Service
public class AuthService {
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//로그인 처리
	public AuthLoginResponseVO login(AuthLoginRequestVO request) {
		//아이디에 해당하는 회원 조회
		AccountDto accountDto = accountDao.selectOne(request.getAccountId());
		if(accountDto == null) {
			throw new TargetNotfoundException();
		}
		
		//비밀번호 비교
		boolean valid = passwordEncoder.matches(
				request.getAccountPassword()
			, accountDto.getAccountPassword());
		if(!valid) throw new TargetNotfoundException();
		
		//차단여부 확인
		if(accountDto.getAccountBlock().equals("Y")) {
			throw new GetOutException();
		}

		//비밀번호가 변경한 지 30일이 지난 경우
		//현재 시각을 구하기
		Timestamp recent = accountDto.getAccountChange(); // 가장 최근 로그인 시각
		if(recent == null) { //바꾼적 없으면
			recent = accountDto.getAccountJoin(); //가입일로 저장
		}
		LocalDateTime lastChange = recent.toLocalDateTime();
		LocalDateTime current = LocalDateTime.now(); 
		
		Duration duration = Duration.between(lastChange, current);
		
		boolean update = duration.toDays() >= 1;
		
		//로그인 성공
		return AuthLoginResponseVO.builder()
			.accountId(accountDto.getAccountId()) //회원 아이디
			.accountLevel(accountDto.getAccountLevel()) //회원 레벨
			.accountNickname(accountDto.getAccountNickname()) // 회원 닉네임
			.needUpdate(update)
		.build();
	}	
	
}

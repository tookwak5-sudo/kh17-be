package com.kh.spring11.service;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring11.configuration.LoginProperties;
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
	
	@Autowired
	private LoginProperties loginProperties;
	
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
		
		//차단 회원이라면? 403반환 (GetOutException)
		if(accountDto.getAccountBlock().equals("Y")) {
			throw new GetOutException("차단된 회원입니다");
		}

		//비밀번호가 변경한 지 30일이 지난 경우
		//현재 시각을 구하기
		// - 설정파일의 need-update-term 보다 변경일이 오래되어야 한다(=초과)
		
		Timestamp lastChange = accountDto.getAccountChange(); // 가장 최근 로그인 시각
		if(lastChange == null) { //바꾼적 없으면
			lastChange = accountDto.getAccountJoin(); //가입일로 저장
		}
		
		//바꾼 적이 있는 경우 날짜 계산
		LocalDateTime lastTime = lastChange.toLocalDateTime(); //최종 바꾼일
		LocalDateTime current = LocalDateTime.now(); //현재
		
		
		//period는 정확한 시점을 알고 싶을때
		//Duration대략적인 기간을 알고 싶을때
		//Duration duration = Duration.between(lastTime, current);
		
		//ChronoUnit
		long days = ChronoUnit.DAYS.between(lastTime, current);
		
		//properties에서 30일 기준 설정한 데이터를 가져와서 
		boolean needUpdate = days >= loginProperties.getNeedUpdateTerm();
		
		//로그인 성공
		return AuthLoginResponseVO.builder()
			.accountId(accountDto.getAccountId()) //회원 아이디
			.accountLevel(accountDto.getAccountLevel()) //회원 레벨
			.accountNickname(accountDto.getAccountNickname()) // 회원 닉네임
			.needUpdate(needUpdate) // 비밀번호 변경이 필요함(30일이후)
		.build();
	}	
	
}

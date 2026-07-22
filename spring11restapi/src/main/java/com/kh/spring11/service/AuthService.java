package com.kh.spring11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthLoginResponseVO;
import com.kh.spring11.vo.auth.AuthPasswordChangeVO;
import com.kh.spring11.vo.auth.AuthPasswordRequestVO;
import com.kh.spring11.vo.auth.AuthPasswordResponseVO;

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
		
		//로그인 성공
		return AuthLoginResponseVO.builder()
					.accountId(accountDto.getAccountId()) //회원 아이디
					.accountLevel(accountDto.getAccountLevel()) //회원 레벨
					.accountNickname(accountDto.getAccountNickname()) // 회원 닉네임
				.build();
	}
	
	//비밀번호 변경 및 일치 여부 처리
	public AuthPasswordResponseVO checkPassword(String accountId, AuthPasswordRequestVO request) {
		//아이디에 해당하는 비밀번호 조회
		String originPw = accountDao.checkAccountPassword(accountId);
		//비밀번호 비교
		boolean valid = passwordEncoder.matches(request.getAccountCurrentPassword()
				, originPw);
		if(!valid) throw new TargetNotfoundException();
		//비밀번호 일치
		// 변경 비밀번호와 현재 비밀번호가 일치한 경우
		AuthPasswordResponseVO response = new AuthPasswordResponseVO();
		if(originPw == request.getAccountNewPassword()) {
			String message = "기존과 동일한 비밀번호 입니다";
			response.setMessage(message);
			response.setSuccess(false);
			return response;
		} 
		//비밀번호 변경
		//사용자가 입력한 비밀번호를 BCrypt 방식으로 암호화하여 재설정 후 등록
		String changedPassword = passwordEncoder.encode(request.getAccountNewPassword());
		AuthPasswordChangeVO passwordVO = new AuthPasswordChangeVO();
		passwordVO.setAccountId(accountId);
		passwordVO.setAccountPassword(changedPassword);
		accountDao.changeAccountPassword(passwordVO);
		String message = "변경에 성공하셨습니다";
		response.setMessage(message);
		response.setSuccess(true);
		return response;
	}
	
}

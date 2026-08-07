package com.kh.spring11.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.service.EmailService;
import com.kh.spring11.service.RandomService;
import com.kh.spring11.vo.admin.AccountBlockResponseVO;
import com.kh.spring11.vo.admin.AccountFindResponseVO;
import com.kh.spring11.vo.admin.AccountSearchResultVO;
import com.kh.spring11.vo.admin.AdminUserRequestVO;
import com.kh.spring11.vo.admin.AdminUserResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;

@Tag(name= "관리자 API")
@AuthApiResponse

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RandomService randomService;
	
	//회원정보를 반환하는 매핑(주의 : 내 정보 아님)
	@ApiResponse(responseCode = "200", description = "조회 성공")
	@GetMapping(value = "/{accountId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public AccountFindResponseVO find(@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId);
		if(accountDto == null) throw new TargetNotfoundException();
		
		AccountFindResponseVO response = new AccountFindResponseVO();
		BeanUtils.copyProperties(accountDto, response); //가능한 항목 복사
		return response;
	}
	

	//회원 복합 검색
	@ApiResponse(responseCode = "200", description="검색 성공")
	@PostMapping(value ="/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public AdminUserResponseVO search(
			@RequestBody AdminUserRequestVO request
	) {
		
		List<AccountSearchResultVO> list = accountDao.complexSearch(request);
		
		//카운트 조회
		int count = accountDao.complexSearchCount(request);
		
		return AdminUserResponseVO.builder()
					.list(list)
					.last(count <= list.size())
				.build();
	}
	
	//회원 차단
//	@PatchMapping("/block/{accountId}")
//	public AccountBlockResponseVO block(
//			@RequestBody AccountBlockRequestVO request,
//			@PathVariable String accountId) {
//		
//		AccountDto accountDto = accountDao.selectOne(accountId); // 회원 조회
//		if(accountDto == null) throw new TargetNotfoundException();
//		
//		accountDto.setAccountBlock(request.getAccountBlock()); // 입력값을 넣어주고
//		accountDao.updateAccountBlock(request); //block여부 업데이트
//		AccountBlockResponseVO response = new AccountBlockResponseVO(); //응답용 VO에
//		AccountDto result = accountDao.selectOne(accountId); // 회원 조회후에
//		BeanUtils.copyProperties(result, response); // 입력된 차단정보를 담아
//		return response; //보내기
//	}
	
	@ApiResponse(responseCode = "200", description = "차단/해제 성공")
	@PatchMapping(value = "/block/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AccountBlockResponseVO block(
			@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId); // 회원 조회
		if(accountDto == null) throw new TargetNotfoundException();
		
		boolean current = accountDto.getAccountBlock().equals("Y");
		accountDto.setAccountBlock(current ? "N" : "Y");
		accountDao.updateAccountBlock(accountDto);
		
		AccountBlockResponseVO response = new AccountBlockResponseVO();
		
		BeanUtils.copyProperties(accountDto, response);
		return response;
	}
	
	//임시 비밀번호 발행
	@ApiResponse(responseCode = "200", description= "변경 메일 발송 성공")
	@PostMapping("/tempPassword/{accountId}")
	public void tempPassword(@PathVariable String accountId) throws MessagingException, IOException {
		
		AccountDto accountDto = accountDao.selectOne(accountId);
		if(accountDto == null) throw new TargetNotfoundException();
		
		//[1] 임시 비밀번호 발행
		//String randomPassword = randomService.generateNumber(12);
		String randomPassword = randomService.generateString(12);
		
		//[2] DB 변경
		accountDao.updateAccountPassword(AccountDto.builder()
					.accountId(accountId)
					.accountPassword(randomPassword)
				.build());
		
		//[3] 이메일 변경
		emailService.sendTempPassword(accountDto.getAccountEmail(), randomPassword);
		
	}

	
}

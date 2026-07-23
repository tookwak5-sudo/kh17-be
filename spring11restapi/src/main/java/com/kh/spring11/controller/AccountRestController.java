package com.kh.spring11.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.AccountDao;
import com.kh.spring11.dto.AccountDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.account.AccountFindResponseVO;
import com.kh.spring11.vo.account.AccountJoinRequestVO;
import com.kh.spring11.vo.account.AccountJoinResponseVO;
import com.kh.spring11.vo.account.AccountMeResponseVO;
import com.kh.spring11.vo.account.ChangePasswordRequestVO;
import com.kh.spring11.vo.account.ChangePasswordResponseVO;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "회원 정보 관리 서비스")
@CommonsApiResponse

//@CrossOrigin(
//		origins = "http://localhost:5173",	
//		allowCredentials = "true")
@RestController
@RequestMapping("/api/account")
public class AccountRestController {
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private PasswordEncoder passwordEncoder;
//	@Autowired //이제 직접적으로 쓰지 않음
//	private JwtService jwtService;
	//회원가입
	@ApiResponse(responseCode = "200", description ="가입 성공")
	@PostMapping(value = "/", produces= "application/json")
	public AccountJoinResponseVO join(
			@RequestBody AccountJoinRequestVO request) { 	
		//AccountDto에 AccountJoinRequestVO의 데이터를 복사하고 가입처리
		AccountDto accountDto = new AccountDto();
		BeanUtils.copyProperties(request, accountDto); //request → accountDto
		accountDao.insert(accountDto);
		//가입된 결과(모든 데이터가 포함된)를 가져와서 응답 정보로 변환하여 반환
		AccountDto resultDto = accountDao.selectOne(accountDto.getAccountId());
		AccountJoinResponseVO response = new AccountJoinResponseVO();
		BeanUtils.copyProperties(resultDto, response);
		return response;
	}
	
	//아이디 중복검사 - 사용 가능하면 true, 불가능하면 false를 반환
	@ApiResponse(responseCode = "200", description = "존재하는 아이디")
	@GetMapping(value ="/check-id/{accountId}", produces="application/json")
	public boolean checkAccountId(@PathVariable String accountId) {
		return accountDao.checkAvailableId(accountId);
	}
		
	//닉네임 중복검사 - 사용 가능하면 true, 불가능하면 false를 반환
	@ApiResponse(responseCode = "200", description = "존재하는 닉네임")
	@GetMapping(value ="/check-nickname/{accountNickname}", produces="application/json")
	public boolean checkAccountNickname(@PathVariable String accountNickname) {
		return accountDao.checkAvailableNickname(accountNickname);
	}
	
	//이메일 중복검사 - 사용 가능하면 true, 불가능하면 false를 반환
	@ApiResponse(responseCode = "200", description = "존재하는 이메일")
	@GetMapping(value ="/check-email/{accountEmail}", produces="application/json")
	public boolean checkAccountEmail(@PathVariable String accountEmail) {
		return accountDao.checkAvailableEmail(accountEmail);
	}
	
	//회원정보를 반환하는 매핑(주의 : 내 정보 아님)
	@ApiResponse(responseCode = "200", description = "조회 성공")
	@GetMapping(value = "/{accountId}", produces="application/json")
	public AccountFindResponseVO find(@PathVariable String accountId) {
		AccountDto accountDto = accountDao.selectOne(accountId);
		if(accountDto == null) throw new TargetNotfoundException();
		AccountFindResponseVO response = new AccountFindResponseVO();
		BeanUtils.copyProperties(accountDto, response); //가능한 항목 복사
		return response;
	}
	
	//내 정보라는 건 cookie에 포함된 loginId를 읽으면 된다(지금은 ... 나중엔 변함)
	//@CookieValue로 쿠키의 값을 읽어서 해당하는 정보를 조회해서 반환
	//stateless(무상태) 서버의 세션 대체 방안
	@ApiResponse(responseCode = "200", description = "조회 성공")
	@GetMapping(value="/me", produces="application/json")
	public AccountMeResponseVO me(
		//[1] 기존
		//accessToken이라는 쿠키를 읽는 명령 (+나의 해석 및 검증이 필요)
		//@CookieValue(name="accessToken", required = false) String accessToken
		//[2] 업그레이드(1) jwtDecoder 
		//Spring Security가 해석해낸 JWT를 가져오는 명령 (+ 이미 해석되어 있음)
		//@AuthenticationPrincipal Jwt jwt
									
		//[3] 업그레이드(2) 
		//아예 무슨 명령을 써야 변환되는지까지 알려주고 최종형태를 달라고 해보자!
		//@ : 객체를 지정함  // ->jwt는 #this라 지칭 가능 //오타 검증의 문제가 남음
//		@AuthenticationPrincipal(
//			expression = "@jwtService.parseAccessToken(#this.tokenValue)"
//		)
		//[4] 업그레이드(3) 
		//공용어노테이션에 지정해버림
		@CurrentUser
		TokenParseResponseVO parseVO
	) {
		
//		if(accessToken == null) {
//			throw new WhoAreYouException();
//		} //SecurityConfiguration의 filterChain에서 null일 경우 막는 처리를 해놨기 때문에 이제는 필요없는 코드(이제는 반드시 쿠키가 생깅
		
		// 토큰 해석 + 유효성 검증 =@CookieValue로 읽었을 때(jwtDecoder 사용)  <= 유효성 검사 까지 함 근데 이제 Secuirty필터에서 쿠키해석을 먼저하는데 jwtService에서 한번 더 수행하게 됨 수정 필요 
		//TokenParseResponseVO parseVO = jwtService.parseAccessToken(accessToken);
		
		//@AuthenticationPrincipal과 같이 쓰는 명령
		// 토큰을 내가 원하는 형태로 변환만 (+ 유효성 검증은 하지 않음, JwtDecoder 사용하지 않음)
		//TokenParseResponseVO parseVO = jwtService.parseAccessToken(jwt);
		
		AccountDto accountDto = accountDao.selectOne(parseVO.getAccountId());
		if(accountDto == null) throw new TargetNotfoundException();
		AccountMeResponseVO response = new AccountMeResponseVO();
		BeanUtils.copyProperties(accountDto, response); //가능한 항목 복사
		return response;
	}
	
	//비밀번호 변경 매핑
	@PatchMapping("/password")
	public ChangePasswordResponseVO password( //DB이름을 유출할 필요없음
			@CurrentUser TokenParseResponseVO parseVO,
			//@Valid를 붙이면 Spring Validation을 사용하겠다는 뜻
			//→ 요구사항에 맞지 않으면 MethodArgumentNotValidException 예외가 발생
			//→  bad request 로 반환
			@Valid @RequestBody ChangePasswordRequestVO request
	){ //입력한 현재 비번 새로운 비번	
		// [1] DB에서 기존 유저의 정보를 불러온다
		AccountDto accountDto = accountDao.selectOne(parseVO.getAccountId());
		if(accountDto == null) throw new TargetNotfoundException();
		
		// [2] 비밀번호를 비교한다
		String db = accountDto.getAccountPassword(); //DB비밀번호
		String input = request.getPrevAccountPassword(); //사용자 입력 비밀번호
		boolean valid = passwordEncoder.matches(input, db); //BCrypt 비교
		if(!valid) { //비밀번호가 안맞아?
			return ChangePasswordResponseVO.builder()
					.result(false)
					.message("비밀번호가 일치하지 않습니다")
					.build();
		}
		
		//[3] 동일한 비밀번호로 변경을 차단
		boolean same = request.getPrevAccountPassword().equals(request.getNewAccountPassword());
		if(same) {
			return ChangePasswordResponseVO.builder()
					.result(false)
					.message("동일한 비밀번호로는 변경이 불가합니다")
					.build();
		}
		
		//[4] 변경 시도
		accountDao.updateAccountPassword(AccountDto.builder()
					.accountId(parseVO.getAccountId())
					.accountPassword(request.getNewAccountPassword())
				.build());
		
		//[5] 성공 알림
		return ChangePasswordResponseVO.builder()
					.result(true)
					.message("비밀번호 변경이 완료되었습니다")
				.build();
	}
	
}

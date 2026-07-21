package com.kh.spring11.controller;

import java.time.Duration;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.CommonsApiResponse;
import com.kh.spring11.configuration.JwtProperties;
import com.kh.spring11.service.AuthService;
import com.kh.spring11.service.JwtService;
import com.kh.spring11.vo.auth.AuthLoginRequestVO;
import com.kh.spring11.vo.auth.AuthLoginResponseVO;
import com.kh.spring11.vo.jwt.TokenCreateRequestVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "인증 처리 서비스", description = "stateless 서버의 인증 처리 로직 구현")
@CommonsApiResponse

@CrossOrigin(
		origins = "http://localhost:5173",	
		allowCredentials = "true")
@RestController
@RequestMapping("/service/auth")
public class AuthRestController {
	
	@Autowired
	private AuthService authService;
	@Autowired
	private JwtProperties jwtProperties;
	@Autowired
	private JwtService jwtService;
	
	@ApiResponse(responseCode ="200", description = "가입 성공")
	@PostMapping(value="/login" , produces = "application/json")
//	public AuthLoginResponseVO login(// 데이터만 반환
	public ResponseEntity<AuthLoginResponseVO> login ( //데이터 + 헤더 + 쿠키를 반환
			@RequestBody AuthLoginRequestVO request) {
		// 로그인 처리를 수행하고 결과를 얻어낸다
		AuthLoginResponseVO response = authService.login(request);
		
		//토큰 생성
		TokenCreateRequestVO tokenRequest = new TokenCreateRequestVO();
		BeanUtils.copyProperties(response, tokenRequest);
		String accessToken = jwtService.createAccessToken(tokenRequest);
		
		//쿠키 생성
//		ResponseCookie postIt = ResponseCookie
		ResponseCookie accessCookie = ResponseCookie
//				.from("loginId", response.getAccountId())
				.from("accessToken", accessToken) // 이제 아이디가 아니라 토큰을 통해 포스트잇(쿠키) 생성
				//각종 설정들
				.maxAge(Duration.ofSeconds(jwtProperties.getTokenValidity())) // 유효시간 30분
				.path("/")//적용범위
				.httpOnly(true) // true : 서버전(등뒤) , false :  클라이언트 검용(이마)
				.secure(false) // https 사용여부
				.sameSite("Lax")//허용범위 (NONE: 자유, Lax: 유연, Strict: 엄격) lax는 다른곳에서 오는 것을 어느정도 막아줌
				.build();
		
		//결과 반환
		return ResponseEntity.ok()
					//쿠키를 추가하는 설정
					.header(HttpHeaders.SET_COOKIE , postIt.toString())
					.body(response);
	}
	
	//로그아웃 매핑
	// - 서버에서 사용자의 로그아웃에 대하 ㄴ핵심작업은 "쿠키 삭제"이다.
	// - 하지만, 쿠키는 지우는 명령이 없다 (제한 시간을 설정해서 만드는 것 밖에 없음)
	// - 삭제효과를 내기위해 0초 후에 만료되는 쿠키를 생성해서 덮어쓰기
	@DeleteMapping("/logout")
	public ResponseEntity<Void> logout(
//				@CookieValue(name="loginId", required=false) String accountId // 이제 아이디로 하지 않기 때문에 필요없음
			) {
		//삭제를 위한 쿠키 생성(생성시와 똑같지만 만료시간이 0초여야함)
//		ResponseCookie postIt = ResponseCookie
		ResponseCookie accessCookie = ResponseCookie
				.from("accessToken", "")
				//각종 설정들
//				.maxAge(Duration.ofMinutes(30L)) // 유효시간 30분
				.maxAge(Duration.ZERO) //위랑 같은 코드
				.path("/")//적용범위
				.httpOnly(true) // true : 서버전(등뒤) , false :  클라이언트 검용(이마)
				.secure(false) // https 사용여부
				.sameSite("Lax")//허용범위 (NONE: 자유, Lax: 유연, Strict: 엄격)
				.build();
		
		//응답 생성
		return ResponseEntity.noContent()
				.header(HttpHeaders.SET_COOKIE, accessCookie.toString())
				.build();
	}
}

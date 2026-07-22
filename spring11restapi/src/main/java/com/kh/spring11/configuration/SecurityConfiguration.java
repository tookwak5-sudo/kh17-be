package com.kh.spring11.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//보안을 위해 필요한 도구 및 설정을 작성 (향후 스프링 시큐리티 설정도 이곳에 작성)
@Configuration
public class SecurityConfiguration {
	//단방향 암호화를 위한 BCryptPasswordEncoder를 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	//Spring Security 시스템의 구조를 객체화하여 등록
	//→ SecurityFilterChain
	@Bean
	public SecurityFilterChain securityFilterChan(
			HttpSecurity http//Spring Security가 제공하는 http 설정 객체
	) throws Exception {
		//http에 홈페이지 운영 규칙을 모두 설정하고 Build에서 반환
		http	
			//cors 설정 : 별도로 등록한 CorsConfigurationSource의 설정을 따르겠다(없으면 기본값)
			.cors(Customizer.withDefaults())
			//session 설정 : 무상태(STATELESS)로 설정
			.sessionManagement(
				session-> session.sessionCreationPolicy(
					SessionCreationPolicy.STATELESS
				)
			)
			//security의 기본 제공되는 로그인화면과 인증시스템을 비활성화
			.formLogin(form->form.disable())
			.httpBasic(basic->basic.disable())
			//.logout(logout->logout.disable())
			//.logout(AbstractHttpConfigurer::disable) //Java Method Reference
			
			//HTTP 요청에 대한 처리 계획
			//.requestMathchers("적용시킬 주소 or 패턴") 
			// +
			// .permitAll() - 모두 수락 (접속 허용)
			// .denyAll() - 모두 거절 (접속 차단)
			// .authenticated() - 인증 필요 (인증 방식에 대해서는 따로 정의)
			// .hasRole() - Spring Security의 기본 역할 (`ROLE_` 로 시작) // 우린 등급(브론즈, 실버 ...)로 하기 때문에 이 방식 사용하기 어려워 강제로 해줘야함
			// .hasAuthority() - 사용자가 임의로 지정한 역할
			.authorizeHttpRequests(
				auth -> auth
					//무조건 허용할 기본 페이지들
					.requestMatchers(
						"/active" //생존 확인용 페이지
						,"/swagger-ui/**"//springdoc ui
						,"/v3/api-docs/**" //springdoc json
					).permitAll()
					//조검부 혀용(내가 만든 요소들)
					.requestMatchers(
						"/api/account/me" //내 정보
					).authenticated() //인증 필요
					//나머지 모두 거절
					.anyRequest().denyAll()
			)
			//JWT를 어떻게 검증할 것인지 설정 (JwtDecoder가 반드시 필요)
			
			//예외에 대한 핸들링 설정
			//→ 인증되지 않은 경우는 401 , 권한이 부족한 경우는 403으로 반환하도록 설정 //원한다면 추가 설정도 가능
			
		;
		
		return http.build();
	}
	
}

package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//스프링의 설정파일(Configuration)
//- application.properties에 하기 어려운 설정들(ex : 계산이 필요한 경우)
//- 인터셉터 등 홈페이지의 운영과 관련된 설정은 반드시 상속이 필요(WebMvcConfigurer)
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
		//등록한 인터셉터를 가져오도록 설정하고
		@Autowired
		private TestInterceptor testInterceptor;

		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			//레지스트리에 testInterceptor가 모든 주소에서 일할 수 있다고 작성해주세요.
			registry.addInterceptor(testInterceptor).addPathPatterns("/**"); // "/*"이면 ->  http://localhost:80808/0000 하위 정보 /country/insert 인서트가 안잡힌다. 
			
			//주소(Path Patterns) 작성 규칙
			//- spring 표현식의 규칙을 따른다
			//- *을 1개 또는 2개까지 사용할 수 있다
			//- *을 1개 쓰면 현재 작성한 엔드포인트 내에서만 범위 설정이 가능
			//- *을 2개 쓰면 현재 엔드포인트부터 하위 엔드포인트를 모두 포함한 범위 설정이 가능
			//(ex) 국가정보와 관련된 모든 페이지를 타겟으로 설정하고 싶다면? /country/* 로 설정! ; *의미 이 자리에 아무거나와도 된다
			/// → /country/* 로 설정!
			/// → /country/insert , /country/list , /country/edit , /country/detail

			/// 만약 상세페이지가 /country/detail?countryNo=1이 아니고 /country/detail/1 → (경로변수)이라면?
			/// → /country/**로 설정!
			/// → /country/insert/complete, /country/list, /country/edit , /country/detail
		}
		
}

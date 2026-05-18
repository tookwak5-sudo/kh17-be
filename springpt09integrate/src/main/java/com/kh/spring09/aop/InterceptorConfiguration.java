package com.kh.spring09.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.kh.spring09.controller.CountryController;

//스프링의 설정파일(Configuration)
//- application.properties에 하기 어려운 설정들(ex : 계산이 필요한 경우)
//- 인터셉터 등 홈페이지의 운영과 관련된 설정은 반드시 상속이 필요(WebMvcConfigurer)
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer{
		//등록한 인터셉터를 가져오도록 설정하고
		@Autowired
		private TestInterceptor testInterceptor;
		
		@Autowired
		private MemberOnlyInterceptor memberOnlyInterceptor;
		
		@Autowired
		private MasterOnlyInterceptor masterOnlyInterceptor;
		
		@Autowired
		private MasterDenyInterceptor masterDenyInterceptor;
		
		@Autowired
		private BoardOwnerInterceptor boardOwnerInterceptor;
		
		//필요에 의해 3개 중 한 개를 쓰면 된다
		@Autowired
		private BoardReadInterceptor boardReadInterceptor; // 검사 없음
		
		@Autowired
		private BoardReadInterceptor2 boardReadInterceptor2; // 소유자 검증
		
		@Autowired
		private BoardReadInterceptor3 boardReadInterceptor3; // session사용
		
		@Autowired
		private BoardReadInterceptor4 boardReadInterceptor4; // DB사용
		
		
		@Override
		public void addInterceptors(InterceptorRegistry registry) {
			//레지스트리에 testInterceptor가 모든 주소에서 일할 수 있다고 작성해주세요.
			//registry.addInterceptor(testInterceptor).addPathPatterns("/**"); // "/*"이면 ->  http://localhost:80808/0000 하위 정보 /country/insert 인서트가 안잡힌다. 
			
			///주소(Path Patterns) 작성 규칙
			///- spring 표현식의 규칙을 따른다
			///- *을 1개 또는 2개까지 사용할 수 있다
			///- *을 1개 쓰면 현재 작성한 엔드포인트 내에서만 범위 설정이 가능
			///- *을 2개 쓰면 현재 엔드포인트부터 하위 엔드포인트를 모두 포함한 범위 설정이 가능
			
			///(ex) 국가정보와 관련된 모든 페이지를 타겟으로 설정하고 싶다면? /country/* 로 설정! ; *의미 이 자리에 아무거나와도 된다
			/// → /country/* 로 설정!
			/// → /country/insert , /country/list , /country/edit , /country/detail

			/// 만약 상세페이지가 /country/detail?countryNo=1이 아니고 /country/detail/1 → (경로변수)이라면?
			/// → /country/**로 설정!
			/// → /country/insert/complete, /country/list, /country/edit , /country/detail
			///
			
			//memberOnltyInterceptor를 회원만 접근해야 하는 페이지에 설정
			registry.addInterceptor(memberOnlyInterceptor).
					addPathPatterns(
							"/book/**" //book전체
//							"/lecture/insert*",//lecture 등록
//							"/lecture/edit", //lecture 수정
//							"/lecture/delete" //lecture 삭제
							,"/lecture/**"
							,"/member/**"
							,"/admin/**" //admin 전체
							,"/board/write" //게시글 등록 페이지 // 수정 삭제는 따로 막을거임, 단순 로그인을 막는다고 막아지는게 아니기 때문
							,"/rest/board/like-action" //게시글 좋아요 처리 매핑
							,"/rest/**/like-action" //모든 좋아요 처리 매핑
					)
					.excludePathPatterns( //허용할 것만 적는 방식이기 때문에 앞으로 추가될 미지의 방식은 자동으로 잠김으로 이 방식을 더 선호
							"/lecture/list"
							,"/lecture/detail"
							,"/lecture/image"
							,"/member/join*" // joinFinish도
							,"/member/login"
							,"/member/goodbyeFinish"
							,"/member/detail"
							,"/member/profile"
							,"/board/list"
							,"/board/detail"
					);
			//관리자 기능에 대한 검사 인터셉터 등록
			registry.addInterceptor(masterOnlyInterceptor)
						.addPathPatterns("/admin/**");
			
			//관리자가 관리자를 조회하는 상황을 방지하기 위한 인터셉터 등록
			registry.addInterceptor(masterDenyInterceptor).addPathPatterns(
						"/admin/member/detail"
						,"/admin/member/edit"
						,"/admin/member/block"
					);
			//본인 소유의 게시글만 수정 삭제가 가능하도록 인터셉터 등록
			registry.addInterceptor(boardOwnerInterceptor).addPathPatterns("/board/edit", "/board/delete");
			//조회수 증가 처리를 하는 인터셉터 설정
			registry.addInterceptor(boardReadInterceptor4).addPathPatterns(
						"/board/detail"
					);
		}
}

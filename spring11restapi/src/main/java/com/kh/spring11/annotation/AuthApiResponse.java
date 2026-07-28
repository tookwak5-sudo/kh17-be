package com.kh.spring11.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

//1. 이 어노테이션을 설정할 수 있는 위치를 지정 (메소드, 클래스, 또다른 어노테이션에 설정 가능)
@Target(
	{
		ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE
	})
//2. 이 어노테이션이 실질적으로 작동하는 시점 (실행중에도 읽어낼 수 있도록 설정)
@Retention(RetentionPolicy.RUNTIME)
//3. 자동으로 생성되는 API에 이 내용이 포함되도록 설정(관례적으로 커스텀 파일에 작성)
@Documented

@CommonsApiResponse

@ApiResponses({
	@ApiResponse(
		responseCode = "401",
		description = "인증되지 않았을 경우",
		content = @Content(
			mediaType = "text/plain",
			schema = @Schema(
				implementation = String.class, 
				example = "Unauthorization"
			)
		)
	),
	@ApiResponse(
		responseCode = "403",
		description = "인증 권한이 부족한 경우",
		content = @Content(
			mediaType = "text/plain",
			schema = @Schema(
				implementation = String.class, 
				example = "Forbidden"
			)
		)
	)
})

public @interface AuthApiResponse {

}

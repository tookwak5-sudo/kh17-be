package com.kh.spring11.vo.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

//지금과 같이 요청별로 VO를 따로 만들어 놓으면 Spring Validation을 적용하기가 쉽다
//- @RequestBody와 함께 @Valid라고 붙여서 검증하겠다는 의사표시를 해야한다

//주요 Annotation
//- @NotNull : null 불가
//- @NotEmpty : null 불가 + 비어있는 것 불가
//- @NotBlank : null 불가 + 비어있는 것 불가 + 공백 불가
// → 현재 우리 프로젝트는 EmptyStringDeserializer가 있어서 @NotNull로도 충분
//- @Size : 개수(문자열: 글자수; Collection에선 데이터 개수) 
//- @Pattern : 유효한 패턴에 대한 정규표현식을 지정할 때 사용
//- @Min / @Max : 최소/최대 수치 지정
//- @DecimalMin / @DemcimalMax : 소수점이 포함된 최소/최대 수치 지정
//- @Positive : 양수
//- @PositiveOrZero : 0이상

@Schema(name = "비밀번호 변경 요청 VO")
@Data
@JsonIgnoreProperties(ignoreUnknown = true) // 내가 명시한 정보 외 다른 정보가 오면 무시해라
public class ChangePasswordRequestVO {
	@NotNull
	//@Size(min = 8, max = 16) //8~16글자여야 통과 정규표현식에서 처리가 가능하지만 여기까지 선택이 가능하다
	//	@Pattern(regexp = "^(?=.*?[A-Z]+)[A-Za-z0-9!@#$]{8,16}")
//	@Pattern(
//		regexp = "^(?=.*?[A-Z]+)[A-Za-z0-9!@#$]{8,16}",
//		message = "비밀번호는 대문자, 소문자, 숫자, 특수문자를 반드시 포함하여 8~16글자로 설정해야합니다"
//	)
	private String prevAccountPassword;
	@NotNull
	private String newAccountPassword;
}

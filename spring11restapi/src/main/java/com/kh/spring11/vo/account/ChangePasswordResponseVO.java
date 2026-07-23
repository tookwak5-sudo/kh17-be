package com.kh.spring11.vo.account;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="비밀번호 변경 응답 VO")
//스프링이 자동으로 붙여주는 게 아니라 내가 작성하는 것이므로 jsonIngnore작성 x
@Data @Builder @NoArgsConstructor @AllArgsConstructor
//args없으면 기본생성자가 없음(무조건 빌더 사용) 어떻게 쓸지 모르기 때문에
public class ChangePasswordResponseVO {
	private boolean result; //true:성공 false:실패
	private String message; //상태메세지
}

package com.kh.spring11.vo.admin;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="계정 블럭 결과 응답")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class AccountBlockResponseVO {
//	private String result; 
	private boolean result; ////true - 차단됨, false - 차단해제됨
}

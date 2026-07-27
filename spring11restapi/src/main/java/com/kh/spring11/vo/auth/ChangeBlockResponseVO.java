package com.kh.spring11.vo.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="회원 차단 응답")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class ChangeBlockResponseVO {
	private String accountBlock;
}

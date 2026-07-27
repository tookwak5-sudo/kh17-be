package com.kh.spring11.vo.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name="차단여부 요청")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChangeBlockRequestVO {
	private String accountId;
	private String accountBlock;
}

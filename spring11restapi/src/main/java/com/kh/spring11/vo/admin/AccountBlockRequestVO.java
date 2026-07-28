package com.kh.spring11.vo.admin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name="차단여부 요청")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountBlockRequestVO {
	private String accountId;
	private String accountBlock;
}

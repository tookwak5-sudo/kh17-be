package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name= "상품 상세 목록 조회 요청")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder @NoArgsConstructor @AllArgsConstructor
public class KakaopayOrderRequestVO {
	private String cid;
	private String tid;
}

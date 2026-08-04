package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(name="무식하게 구매할 때의 요청 VO")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaopayBuyRequestVO {
	private String name;
	private long price;
}

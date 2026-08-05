package com.kh.spring11.vo.kakaopay;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Schema(name="구매할 때의 요청 VO")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaopayBuyRequestVO2 {
	@NotEmpty
	private List<BuyVO> orders;
}

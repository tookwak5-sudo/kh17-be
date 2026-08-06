package com.kh.spring11.vo.kakaopay;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaopayPaymentActionDetailVO {
	@JsonAlias("aid")
	private String aid; //요청 고유번호
	@JsonAlias("approvedAd")
	private LocalDateTime approvedAt; //거래시각
	@JsonAlias("amount")
	private Integer amount; //결제/취소 총액
	@JsonAlias("pointAmount")
	private Integer pointAmount; //총 포인트
	@JsonAlias("discountAmount")
	private Integer discountAmount; // 총 할인금액
	@JsonAlias("greenDeposit")
	private Integer greenDeposit; //컵 보증금
	@JsonAlias("paymentActionType")
	private String paymentActionType; //결제 타입
	@JsonAlias("payload")
	private String payload;
}

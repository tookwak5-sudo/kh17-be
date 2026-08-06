package com.kh.spring11.vo.kakaopay;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaopayOrderResponseVO {
	private String tid; //결제 고유 번호
	private String cid; // 가맹점 코드
	private String status; //결제 상태
	private String partnerOrderId; //주문번호
	private String partnerUserId; // 주문자 아이디
	private String paymentMethodType;
	private KakaopayAmountVO amount; //결제금액
	private KakaopayAmountVO canceledAmount; //결제금액
	private KakaopayAmountVO cancelAvailableAmount; //결제금액
	private String itemName;  // 상품 이름
	private String itemCode; //상품 코드
	private Integer quantity; //상품 수량(1로 고정)
	private LocalDateTime createdAt; //결제 시각 
	private LocalDateTime approvedAt; //  승인 시각
	private LocalDateTime canceledAt; // 취소 시각
	private KakaopaySelectedCardInfoVO selectedCardInfo;//결제 카드 정보
	private List<KakaopayPaymentActionDetailVO> paymentActionDetails; //결제 상세내역
//	private KakaopayPaymentActionDetail[] paymentActionDetails; //결제 상세내역
}

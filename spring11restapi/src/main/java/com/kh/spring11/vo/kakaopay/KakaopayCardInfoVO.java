package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaopayCardInfoVO {
	private String kakaopayPurchaseCorp; //매입사명
	private String kakaopayPurchaseCorpCode; //매입사 코드
	private String kakaopayIssuerCorp; // 발급사명
	private String kakaopayIssuerCorpCode; //발급사 코드
	private String bin; //카드BIN
	private String cardType; //카드 유형
	private String installMonth; //할부 개월
	private String approvedId; //승인번호
	private String cardMin; //가맹점 번호
	private String interestFreeInstall; //무이자 할부 여부
	private String installmentType; //할부유형
	private String cardItemCode; //카드 상품 코드
}

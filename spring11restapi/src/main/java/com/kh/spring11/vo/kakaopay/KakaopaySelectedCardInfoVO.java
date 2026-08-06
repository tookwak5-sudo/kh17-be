package com.kh.spring11.vo.kakaopay;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class KakaopaySelectedCardInfoVO {
	@JsonAlias("cardBin")
	private String cardBin;
	@JsonAlias("installMonth")
	private Integer installMonth;
	@JsonAlias("installmentType")
	private String installmentType;
	@JsonAlias("cardCorpName")
	private String cardCorpName;
	@JsonAlias("interestFreeInstall")
	private String interestFreeInstall;
}

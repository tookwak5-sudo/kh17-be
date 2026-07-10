package com.kh.spring11.vo;

import lombok.Data;

@Data
public class ListRequestVO {
	private Integer lastNo; //기본값 null로줘도 되지만 안써도 null이기 때문에 안써도 무방
	private int size = 10;
}

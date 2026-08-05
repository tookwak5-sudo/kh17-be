package com.kh.spring11.vo.sale;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name= "주문 상품 조회 결과 데이터")
@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class SaleOrderResponseVO {
	private List<SaleListItemVO> saleList;
}

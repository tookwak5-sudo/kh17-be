package com.kh.spring11.vo.sale;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(name="상품 정보 등록용 데이터")
@Data @JsonIgnoreProperties(ignoreUnknown = true) //false로 해서 따로 차단을 할 수 있지만 굳이?
@Builder @NoArgsConstructor @AllArgsConstructor
public class SaleAddRequestVO {
	@NotNull
	private String saleName;
	private String saleCategory;
	@NotNull @PositiveOrZero 
	private Integer saleOriginalPrice;
	@PositiveOrZero
	private Integer saleDiscountPrice; //만약 할인가격이 안들어가 있으면 상품하고 동일한 가격으로 넣기
	private String saleContent;
	@NotNull @PositiveOrZero
	private Integer saleStock;
	
	//첨부파일
	//[1] 썸네일
	private MultipartFile thumbnail;
	//[2] 상세이미지
	private List<MultipartFile> detailImages; //사용은 List가 편함
											
//	private MultipartFile[] detailImages; //보통은 가변 List, 불변 배열
	
}

package com.kh.spring11.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.dao.SaleDao;
import com.kh.spring11.service.SaleService;
import com.kh.spring11.vo.sale.ChangeThumbnailResponseVO;
import com.kh.spring11.vo.sale.SaleAddRequestVO2;
import com.kh.spring11.vo.sale.SaleAddResponseVO;
import com.kh.spring11.vo.sale.SaleDetailResponseVO;
import com.kh.spring11.vo.sale.SaleEditRequestVO;
import com.kh.spring11.vo.sale.SaleListItemVO;
import com.kh.spring11.vo.sale.SaleListRequestVO;
import com.kh.spring11.vo.sale.SaleListResponseVO;
import com.kh.spring11.vo.sale.SaleOrderRequestVO;
import com.kh.spring11.vo.sale.SaleOrderResponseVO;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Encoding;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="상품 API")
@AuthApiResponse
@RestController
@RequestMapping("/api/sale")
public class SaleRestController {
	
	@Autowired
	private SaleService saleService;
	@Autowired
	private SaleDao saleDao;
	
	@ApiResponse(responseCode = "200", description ="상품 등록 성공")
	@PostMapping(
			value = "/", 
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = "multipart/form-data" //spring doc를 위하여 요구형태 명시
	)
	public SaleAddResponseVO add(
		//[1]리엑트에서 데이터들이 낱개로 전송될 경우
//		@Valid @ModelAttribute SaleAddRequestVO request // 모두 낱개로 올 때 쓰는 방ㅇ식
			
		//[2]리엑트에서 데이터들이 파트별로 전송될 경우
		//RequestPart가 application/json임을 명시해서 SpringDoc 테스트시 혼선이 없도록
		//→custom Annotation오로 만들면 경우에 따라 안될 가능성이 존재하므로 직접 작성 권장
		@io.swagger.v3.oas.annotations.parameters.RequestBody(
			content = @Content(
				encoding = @Encoding(
					name = "sale",
					//contentType = MediaType.APPLICATION_JSON_VALUE
					contentType = MediaType.APPLICATION_JSON_VALUE
				)
			) 
		)
		@Valid @RequestPart(value = "sale") SaleAddRequestVO2 request, //6개의 데이터가 담길 객체
		@RequestPart(value = "thumbnail", required = false) 
		MultipartFile thumbnail,	//썸네일이 담길 객체(이쪽을 선호)
		
		@RequestPart(value = "detailImages", required = false)
		List<MultipartFile> detailImages
			)throws IllegalStateException, IOException {
//		return saleService.add(request); // [1]
		return saleService.add(request, thumbnail, detailImages); // [2]
	}
	
	@PostMapping("/list")
	public SaleListResponseVO list(@RequestBody SaleListRequestVO request){
		
		return SaleListResponseVO.builder()
					.items(saleDao.selectList(request))
				.build();
	}
	
	@ApiResponse(responseCode = "200", description="상세 정보 조회 성공")
	@GetMapping(value="/{saleNo}", produces=MediaType.APPLICATION_JSON_VALUE)
	public SaleDetailResponseVO detail(@PathVariable int saleNo) {
		
		return saleService.findSaleDetail(saleNo);
	}
	
	@ApiResponse(responseCode = "200", description="상세 정보 삭제 성공")
	@DeleteMapping(value="/{saleNo}")
	public void delete(@PathVariable int saleNo) {
		saleService.deleteSale(saleNo);		
	}
	
	@ApiResponse(responseCode = "200", description="상품 정보 수정 성공")
	@PutMapping(
			value ="/{saleNo}",
			consumes = "multipart/form-data"
	)
	public void edit(
			@PathVariable int saleNo,
			
			//RequestPart가 application/json임을 명시해서 SpringDoc 테스트시 혼선이 없도록
			//→custom Annotation오로 만들면 경우에 따라 안될 가능성이 존재하므로 직접 작성 권장
			@io.swagger.v3.oas.annotations.parameters.RequestBody(
				content = @Content(
					encoding = @Encoding(
						name = "sale",
						//contentType = MediaType.APPLICATION_JSON_VALUE
						contentType = MediaType.APPLICATION_JSON_VALUE
					)
				) 
			)
			@Valid @RequestPart(value = "sale") SaleEditRequestVO request,
			@RequestPart(value = "detailImages", required = false)
			List<MultipartFile> detailImages
		) throws IllegalStateException, IOException {
			saleService.edit(saleNo, request, detailImages);
	}
	
	//썸네일만 변경하는 매핑
	@ApiResponse(responseCode = "200", description = "썸네일 변경 완료")
	@PatchMapping(value="/thumbnail/{saleNo}")
	public ChangeThumbnailResponseVO changeThumbnail(
			@PathVariable int saleNo,
			@RequestPart(value = "thumbnail") MultipartFile thumbnail
			) throws IOException, Exception {
		  //기존의 이미지가 있다면 제거
		 //신규 이미지를 추가
		//추가된 이미지의 정보를 반환
		return saleService.changeThumbnail(saleNo, thumbnail);
	}
	//produces는 json데이터를 줄때
	//consume은 명시해줄때 즉, 뭔가를 설명해줄 때 produces와 consume사용
	@ApiResponse(responseCode = "200", description="썸네일 이미지 삭제 성공")
	@DeleteMapping("/thumbnail/{saleNo}")
	public void deleteThumbnail(@PathVariable int saleNo) {
		saleService.deleteThumbnail(saleNo); // 작업이 한 마디로 설명이 안되면 service를 만들기
		
	}
	
	@ApiResponse(responseCode = "200", description = "상세 이미지 1개 삭제 성공")
	@DeleteMapping("/detailImage/sale/{saleNo}/attach/{attachNo}")
	public void deleteDetailImage(
				@PathVariable int saleNo, 
				@PathVariable int attachNo //pathvariable도 modelAttribute로 묶어서 받을 수 있음
	) {
		saleService.deleteDetailImage(saleNo, attachNo);
	}
	
	//삭제이긴 하지만 데이터를 많이 보내야 하기 때문에 Post
	@ApiResponse(responseCode ="200", description = "상세 이미지 다수 삭제 성공")
	@PostMapping("/deleteDetailImages/{saleNo}")
	public void deleteDetailImages(
				@PathVariable int saleNo,
				@RequestBody List<Integer> detailNumbers
			) {
		saleService.deleteDetailImages(saleNo, detailNumbers);
	}
	
	//주문용 상품 정보 조회 명령
	@ApiResponse(responseCode = "200", description = "주문할 상품 정보 조회 성공")
	@PostMapping(value = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public SaleOrderResponseVO orders(
			@Valid @RequestBody SaleOrderRequestVO request) {
			List<SaleListItemVO> saleList = saleService.findOrders(request.getSaleNumbers());
			
			return SaleOrderResponseVO.builder()
						.saleList(saleList)
					.build();
	}
	
}

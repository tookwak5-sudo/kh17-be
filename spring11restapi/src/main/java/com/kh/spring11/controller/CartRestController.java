package com.kh.spring11.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring11.annotation.AuthApiResponse;
import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.CartDao;
import com.kh.spring11.dto.CartDto;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.purchase.CartAddRequestVO;
import com.kh.spring11.vo.purchase.CartAddResponseVO;
import com.kh.spring11.vo.purchase.CartListResponseVO;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="장바구니 API")
@AuthApiResponse

@RestController
@RequestMapping("/api/cart")
public class CartRestController {
	@Autowired
	private CartDao cartDao;
	
	@ApiResponse(responseCode = "200", description = "장바구니 추가 성공")
	@PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public CartAddResponseVO   addCart(
			@Valid @RequestBody CartAddRequestVO request, 
			@CurrentUser TokenParseResponseVO parseVO
	) {
		cartDao.insertOrUpdate(CartDto.builder()
					.cartOwner(parseVO.getAccountId()) //소유자
					.cartItem(request.getItem()) //상품번호
					.cartQty(request.getQty()) //구매수량
				.build());
		
		CartDto findDto = cartDao.selectOne(
				CartDto.builder()
					.cartOwner(parseVO.getAccountId()) //소유자
					.cartItem(request.getItem()) //상품번호
				.build()
		);
		
		return CartAddResponseVO.builder()
					.cartDto(findDto)
				.build();
	}
	
	@ApiResponse(responseCode = "200", description = "장바구니 조회 성공")
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public CartListResponseVO listCart(
			@CurrentUser TokenParseResponseVO parseVO
			) {
		
		return CartListResponseVO.builder()
					.cartItems(cartDao.selectList(parseVO.getAccountId()))
				.build();
		
	}
}

package com.kh.spring11.service;

import java.io.IOException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.dao.SaleDao;
import com.kh.spring11.dto.SaleDto;
import com.kh.spring11.vo.sale.SaleAddRequestVO;
import com.kh.spring11.vo.sale.SaleAddResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("local") //spring profile에서 local이 활성화 되어 있으면 등록될 대상
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private AttachService attachService;
	
	@Override
	public SaleAddResponseVO add(SaleAddRequestVO request) throws IllegalStateException, IOException {
		//[1] 상품 번호 생성
		int saleNo = saleDao.sequence();
		
		//[2] 등록을 위한 DTO생성
		SaleDto saleDto = new SaleDto();
		saleDto.setSaleNo(saleNo);
		BeanUtils.copyProperties(request, saleDto, "saleDiscountPrice"); //나머지 정보 설정
														//이렇게 하면 discountprice가 빠져서 등록
		//할인가격은 수동 설정
		//(+) 만일, 할인가격이 없으면 판매가격과 동일하게 할인가격을 설정
		if(request.getSaleDiscountPrice() == null) {
			saleDto.setSaleDiscountPrice(request.getSaleOriginalPrice());
		}
		else {
			saleDto.setSaleDiscountPrice(request.getSaleDiscountPrice());
		}
		
		//[3] 상품 등록
		saleDao.insert(saleDto);
		
		//[4] 사용자에게 알려주기 위해 등록된 정보를 재조회
		SaleDto resultDto = saleDao.selectOne(saleNo);
		
		SaleAddResponseVO response = new SaleAddResponseVO();
		BeanUtils.copyProperties(resultDto, response);
		
		//(+추가) 첨부파일이 있으면 첨부파일을 등록 후 상품정보와 연결
		MultipartFile thumbnail = request.getThumbnail();
		if(thumbnail.isEmpty() == false) {
			int attachNo = attachService.save(thumbnail);
			saleDao.connect(saleNo, attachNo);
		}
		
		return response;
	}
}

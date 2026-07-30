package com.kh.spring11.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring11.dao.AttachDao;
import com.kh.spring11.dao.SaleDao;
import com.kh.spring11.dto.AttachDto;
import com.kh.spring11.dto.SaleDto;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.sale.SaleAddRequestVO;
import com.kh.spring11.vo.sale.SaleAddRequestVO2;
import com.kh.spring11.vo.sale.SaleAddResponseVO;
import com.kh.spring11.vo.sale.SaleDetailResponseVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Profile("local") //spring profile에서 local이 활성화 되어 있으면 등록될 대상
public class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private AttachService attachService;
	@Autowired
	private AttachDao attachDao;
	
	@Transactional//이 메소드에서 발생하는 DB작업은 all or nothing 처리가 됨
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
		List<MultipartFile> detailImages = request.getDetailImages();
		MultipartFile thumbnail = request.getThumbnail();
		if(thumbnail.isEmpty() == false) {
			int attachNo = attachService.save(thumbnail);
			saleDao.connect(saleNo, attachNo);
		}
		
		return response;
	}
	
	@Transactional//이 메소드에서 발생하는 DB작업은 all or nothing 처리가 됨
	@Override
	public SaleAddResponseVO add(
			SaleAddRequestVO2 request,
			MultipartFile thumbnail,
			List<MultipartFile> detailImages
		) throws IllegalStateException, IOException {
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
		if(thumbnail != null && thumbnail.isEmpty() == false) {
			int attachNo = attachService.save(thumbnail);
			saleDao.connect(saleNo, attachNo);
		}
		
		//(+추가) 상세이미지가 있으면 첨부파일 등록 후 상품정보와 연결
		boolean exist = detailImages != null && detailImages.size() > 0;
		if(exist) { //파라미터가 있으면
			for(MultipartFile detail : detailImages) { //복하여
				if(detail.isEmpty() == false) { //비어있지 않은 이미지
					int attachNo = attachService.save(detail); //등록
					saleDao.connectDetailImage(saleNo, attachNo); //연결
				}
			}
		}
		
		return response;
	}

	@Override
	public SaleDetailResponseVO findSaleDetail(int saleNo) {
		//[1] SaleDto를 조회해오기
		SaleDto saleDto = saleDao.selectOne(saleNo);
		if(saleDto == null) {
			throw new TargetNotfoundException();
		}
		//[2] thumbnail 있으면 첨부파일 가져오기(없을 수도 있음)
		Integer attachNo = saleDao.findAttach(saleNo);
		AttachDto thumbnail = attachDao.selectOne(attachNo);
		
		//[3] details 조회(없을 수도 있음
		List<Integer> attachNumbers = saleDao.findDetails(saleNo); 
		System.out.println("번호들 :" + attachNumbers);
		List<AttachDto> details = attachDao.selectList(attachNumbers);
		
		return SaleDetailResponseVO.builder()
					.saleDto(saleDto)
					.thumbnail(thumbnail)
					.details(details)
				.build();
	}

	@Override
	public void delete(int saleNo) {
		//[1] 썸네일 및 첨부파일 번호 조회
		Integer attachNo = saleDao.findAttach(saleNo);
		List<Integer> attachNumbers = saleDao.findDetails(saleNo); 

//		saleDao.delete(saleNo);
//		
//		//[2] attach를 삭제
//		attachDao.delete(attachNo);
//		
//		//[3] details 삭제
//		attachDao.deleteAll(attachNumbers);
		
	}
}

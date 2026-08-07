package com.kh.spring11.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring11.annotation.CurrentUser;
import com.kh.spring11.dao.PurchaseDao;
import com.kh.spring11.dao.SaleDao;
import com.kh.spring11.dto.PurchaseDetailDto;
import com.kh.spring11.dto.PurchaseDto;
import com.kh.spring11.dto.SaleDto;
import com.kh.spring11.error.GetOutException;
import com.kh.spring11.error.TargetNotfoundException;
import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.kakaopay.BuyVO;
import com.kh.spring11.vo.kakaopay.KakaopayApproveResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelRequestVO;
import com.kh.spring11.vo.kakaopay.KakaopayCancelResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResultVO2;

@Service
public class PurchaseServiceImpl implements PurchaseService {
	
	@Autowired
	private PurchaseDao purchaseDao;
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private KakaopayService kakaopayService;
	
	@Transactional //이렇게 N+1구조에서는 transactional을 사용하기
	@Override
	public void save(KakaopayApproveResponseVO payResponse, KakaopayReadyResultVO2 result) {
		//[1] 대표정보 등록 (번호는 준비단계에서 만들어서 partnerOrderId에 문자열 형태로 넣어둠)
		int purchaseNo = Integer.parseInt(payResponse.getPartnerOrderId());
		purchaseDao.purchaseInsert(
			PurchaseDto.builder()
				.purchaseNo(purchaseNo)
				.purchaseName(payResponse.getItemName())
				.purchaseTotal(payResponse.getAmount().getTotal()) //구매금액
				.purchaseRemain(payResponse.getAmount().getTotal()) //환불가능금액(=구매금액과 동일)
				.purchaseOwner(payResponse.getPartnerUserId())//구매자
				.purchaseTid(payResponse.getTid())//거래번호
			.build()
		);
		
		
		//[2] 상세정보 등록
		List<BuyVO> orders = result.getOrders();
		for(BuyVO order : orders) {
			int purchaseDetailNo = purchaseDao.purchaseDetailSequence();
			SaleDto saleDto = saleDao.selectOne(order.getSaleNo());//상품정보 조회
			
			purchaseDao.purchaseDetailInsert(
				PurchaseDetailDto.builder()
					.purchaseDetailNo(purchaseDetailNo)
					.purchaseDetailOrigin(purchaseNo)//대표번호
					.purchaseDetailItem(order.getSaleNo())//상품번호
					.purchaseDetailName(saleDto.getSaleName()) //상품명 스냅샷
					.purchaseDetailPrice(saleDto.getSaleDiscountPrice()) //상품가격 스냅샷
					.purchaseDetailQty(order.getQuantity()) //수량
				.build()
			);
		}
	}
	
	@Transactional
	@Override
	public KakaopayCancelResponseVO cancelAll(int purchaseNo 
				,TokenParseResponseVO parseVO) {
		//구매내역 조회 (Tid를 얻기 위해)
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseNo);
		
		//취소 불가능한 상황 제거
		if(purchaseDto == null) 
			throw new TargetNotfoundException();
		if(!purchaseDto.getPurchaseOwner().equals(parseVO.getAccountId()))
			throw new GetOutException();
		if(purchaseDto.getPurchaseStatus().equals("전체취소"))
			throw new GetOutException();
		if(purchaseDto.getPurchaseStatus().equals("차단"))
			throw new GetOutException();
		if(purchaseDto.getPurchaseRemain() == 0)
			throw new GetOutException();
		
		//DB 처리
		//[1] 구매 대표정보의 취소금액 변경 및 상태 변경
		purchaseDao.purchaseCancel(purchaseNo);
		//[2] 구매 대표정보와 연결된 구매 상세정보 항목들의 상태를 취소로 변경
		purchaseDao.purchaseDetailCancel(purchaseNo);
		
		//취소 요청
		KakaopayCancelResponseVO payResponse = kakaopayService.cancel(
				KakaopayCancelRequestVO.builder()
					.tid(purchaseDto.getPurchaseTid())
					.cancelAmount(purchaseDto.getPurchaseRemain())
				.build()
		);
		
		return payResponse;
	}
	
	@Transactional
	@Override
	public KakaopayCancelResponseVO cancelUnit(
				int purchaseDetailNo) {
		//구매내역 조회 (Tid를 얻기 위해)
		PurchaseDetailDto purchaseDetailDto = purchaseDao.selectDetailOne(purchaseDetailNo);
		PurchaseDto purchaseDto = purchaseDao.selectOne(purchaseDetailDto.getPurchaseDetailOrigin());
		//취소 불가능한 상황 제거
		if(purchaseDetailDto == null) 
			throw new TargetNotfoundException();
		
		// 전체 결제 상태
		if (purchaseDto.getPurchaseStatus().equals("전체취소"))
		    throw new GetOutException();

		if (purchaseDto.getPurchaseStatus().equals("차단"))
		    throw new GetOutException();

		if(!purchaseDetailDto.getPurchaseDetailStatus().equals("승인"))
			throw new GetOutException();
		if(purchaseDetailDto.getPurchaseDetailPrice() == 0)
			throw new GetOutException();
		if(purchaseDetailDto.getPurchaseDetailQty() == 0)
			throw new GetOutException();
		
		
		purchaseDao.purchaseDetailCancel(purchaseDetailNo);
		//취소 요청
		KakaopayCancelResponseVO payResponse = kakaopayService.cancel(
				KakaopayCancelRequestVO.builder()
					.tid(purchaseDto.getPurchaseTid())
					.cancelAmount(
						purchaseDetailDto.getPurchaseDetailPrice()
						* purchaseDetailDto.getPurchaseDetailQty())
				.build()
		);
		
		return payResponse;
	}

}

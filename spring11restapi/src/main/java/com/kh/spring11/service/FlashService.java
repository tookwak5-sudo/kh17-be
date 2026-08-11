package com.kh.spring11.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import com.kh.spring11.vo.jwt.TokenParseResponseVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResultVO;
import com.kh.spring11.vo.kakaopay.KakaopayReadyResultVO2;

//임시 데이터를 저장하기 위한 서비스
@Service
public class FlashService {

	
	//Map에 데이터를 저장해두고 이를 이름으로 찾아갈 수 있도록 처리
	//- 이름을 뭘로 할 것인가? → String partnerOrderId
	//- 값을 뭘로 할 것인가? → KakaopayReadyResultVO (partnerOrderId, partnerUserId, tid) //orderId는 빼도 무방 넣어도 무방
	
	// 저장소 생성
	//private Map<String, KakaopayReadyResultVO> kakaopayReadyFlashMap = new HashMap<>(); 
	//HashMap은 동기화를 지원하지 않기 때문에, 결제에서 사용할 경우 데이터 무결성을 보장하지 못하기 때문에 단독으로 사용이 불가능하다 따라서
	// 1. synchronizedMap
	//private Map<String, KakaopayReadyResultVO> kakaopayReadyFlashMap = Collections.synchronizedMap(new HashMap<>());
	// 2. ConcurrentHashMap<>()
	
	//카카오페이 버전1용 저장소
	private Map<String, KakaopayReadyResultVO> kakaopayReadyFlashMap = new ConcurrentHashMap<>();
	
	public void addKakaopayReadyFlashData(KakaopayReadyResultVO result) {
		kakaopayReadyFlashMap.put(result.getPartnerOrderId(), result);
	}
	public KakaopayReadyResultVO getKakaopayReadyFlashData(String partnerOrderId) {
		//return kakaopayReadyFlashMap.get(partnerOrderId);
		return kakaopayReadyFlashMap.remove(partnerOrderId); //get은 그냥 꺼냄 remove는 지우면서 꺼냄
	}
	
	//카카오페이 버전2용 저장소
	private Map<String, KakaopayReadyResultVO2> kakaopayReadyFlashMap2 = new ConcurrentHashMap<>();

	public void addKakaopayReadyFlashData2(KakaopayReadyResultVO2 result) {
		kakaopayReadyFlashMap2.put(result.getPartnerOrderId(), result);
	}
	public KakaopayReadyResultVO2 getKakaopayReadyFlashData2(String partnerOrderId) {
		return kakaopayReadyFlashMap2.remove(partnerOrderId); //get은 그냥 꺼냄 remove는 지우면서 꺼냄
	}
	
	
	// 웹소켓 Version 3 용도의 플래시 저장소 
	// - 사용자의 정보 (TokenParseResponseVO) (중복된 사용자가 있을수도 있음)
	// - 동기화 된 Map을 사용
	// - accountId를 key로 사용
	private Map<String, TokenParseResponseVO> userVersion3
	 			= new ConcurrentHashMap<>();
	public void enter(TokenParseResponseVO parseVO) {
		userVersion3.put(parseVO.getAccountId(), parseVO);
	}
	
	public void leave(TokenParseResponseVO parseVO) {
		userVersion3.remove(parseVO.getAccountId());
	}
	
	public List<TokenParseResponseVO> list() {
		return new ArrayList<>(userVersion3.values());
	}
	
}

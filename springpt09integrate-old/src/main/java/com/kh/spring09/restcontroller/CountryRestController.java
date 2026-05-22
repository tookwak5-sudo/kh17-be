package com.kh.spring09.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.CountryLikeDao;
import com.kh.spring09.vo.LikeVO;

import jakarta.servlet.http.HttpSession;

//@CrossOrigin 
@RestController
@RequestMapping("/rest/country")
public class CountryRestController {
	@Autowired
	private CountryLikeDao countryLikeDao;
	
	//[1] 최초 접속 시 좋아요 여부와 현재 글의 좋아요 개수를 구해주는 매핑
	@PostMapping("/like-check")
	public LikeVO likeCheck(@RequestParam int countryNo, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		
		boolean action = countryLikeDao.check(loginId, countryNo);
		int count = countryLikeDao.count(countryNo); //현재 국가의 좋아요 계산
		return LikeVO.builder().action(action).count(count).build();
	}
	
	//[2] 좋아요 클릭 시 좋아요 토글 처리와 결과적으로 만들어진 좋아요 개수를 구해주는 매핑
	//- 비회원 차단은 interceptor에서 구현
	@PostMapping("/like-action")
	public LikeVO likeAction(@RequestParam int countryNo, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		boolean current = countryLikeDao.check(loginId, countryNo);
		if(current) {
			countryLikeDao.delete(loginId, countryNo);
		}
		else {
			countryLikeDao.insert(loginId, countryNo);
		}
		int count = countryLikeDao.count(countryNo);
		
		return LikeVO.builder().action(!current).count(count).build();
	}
}

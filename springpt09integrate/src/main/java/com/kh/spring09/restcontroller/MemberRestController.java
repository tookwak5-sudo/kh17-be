package com.kh.spring09.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring09.dao.BoardDao;
import com.kh.spring09.dao.MemberDao;
import com.kh.spring09.dao.MemberLikeDao;
import com.kh.spring09.dto.MemberDto;
import com.kh.spring09.vo.LikeVO;

import jakarta.servlet.http.HttpSession;

@CrossOrigin //외부 접근 허용(CORS 허용)
@RestController
@RequestMapping("/rest/member")
public class MemberRestController {
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private BoardDao boardDao;
	@Autowired
	private MemberLikeDao memberLikeDao;
	
	//아이디 중복 검사 (없으면 = 사용가능하면 = true 반환)
	@RequestMapping("/validId")
	public boolean validId(@RequestParam String memberId) {
		MemberDto memberDto = memberDao.selectOne(memberId);
		return memberDto == null;
	}
	
	//닉네임 중복 검사 (없으면 = 사용가능하면 = true 반환)
	@PostMapping("/validNickname")
	public boolean validNickname(@RequestParam String memberNickname) {
		MemberDto memberDto = memberDao.selectOneByMemberNickname(memberNickname);
		return memberDto == null;
	}
	
	//이메일 중복 검사 (없으면 = 사용가능하면 = true 반환)
	@PostMapping("/validEmail")
	public boolean validEmail(@RequestParam String memberEmail) {
		MemberDto memberDto = memberDao.selectOneByMemberEmail(memberEmail);
		return memberDto == null;
	}
	
	
	//좋아요
	@PostMapping("/like-check")
	public LikeVO likeCheck(@RequestParam String memberTarget, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		
		boolean action = memberLikeDao.check(loginId, memberTarget);//좋아요 여부 계산
		int count = memberLikeDao.count(memberTarget);//현재 글의 좋아요 계산
		
		
		//return Map.of("action", action, "count", count);
		return LikeVO.builder().action(action).count(count).build(); //Builder패턴
	}
	
	//[2] 좋아요 클릭 시 좋아요 토글 처리와 결과적으로 만들어진 좋아요 개수를 구해주는 매핑
	//- 비회원 차단은 interceptor에서 구현
	@PostMapping("/like-action")
	public LikeVO likeAction(@RequestParam String memberTarget, HttpSession session) {
		String loginId = (String)session.getAttribute("loginId");
		boolean current = memberLikeDao.check(loginId, memberTarget);
		if(current) { //좋아요 처리한 적이 있다면
			memberLikeDao.delete(loginId, memberTarget); // 삭제
		}
		else {
			memberLikeDao.insert(loginId, memberTarget); // 추가
		}
		int count = memberLikeDao.count(memberTarget);
//			return Map.of("action", !current , "count", count);
		return LikeVO.builder().action(!current).count(count).build();
	}
}

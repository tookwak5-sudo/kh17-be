<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 좋아요 처리 관련 자바스크립트 -->
<script type="text/javascript">
	//header.jsp에 jQuery CDN이 있기 때문에 그냥 사용 가능
	$(function(){
		//시작하자마자 서버에 물어봐서 좋아요 상태와 좋아요 개수를 알아낸다
		
		//주소창에 있는 파라미터 중 boardNo를 꺼내는 코드
		var params = new URLSearchParams(window.location.search);
		var boardNo = params.get("boardNo");
		
		$.ajax({
			url: "/rest/board/like-check",
			method: "post",
			data: { boardNo : boardNo },
			success : function(response){ 
				//response에 action과 count가 있을것으로 생각
				//- action은 좋아요 여부, count는 좋아요 개수
				$(".fa-heart").removeClass("fa-regular fa-solid")
								.addClass(response.action ? "fa-solid" : "fa-regular");
				$(".fa-heart").next(".heart-count").text(response.count);
			}
		});
	});
</script>


		<h1>
		<!-- 말머리 -->
		<c:if test="${boardDto.boardHead != null}">
		(${boardDto.boardHead})
		</c:if>
		<!-- 제목 -->
		${boardDto.boardTitle}
		<!--  수정이 되었다면 추가 표시 -->
		<c:if test="${boardDto.boardEtime != null}">
		(수정됨)
		</c:if>
		</h1>
		
		<!-- 목록과 동일하게 사용자 아이디 출력 -->
		<c:if test="${boardDto.boardWriter == null}">
			(탈퇴한 사용자)
		</c:if>
		<c:if test="${boardDto.boardWriter != null}">
			<!-- 작성자 누르면 해당 회원에 대한 상세페이지로 안내 -->
			<a href="/member/detail?memberId=${boardDto.boardWriter}">
				${boardDto.boardWriter}
			</a>
		</c:if>
		<br><br>
		<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		조회수 ${boardDto.boardReadcount}
		<hr>
		<div style="min-height: 250px">
		<!-- 있는 그대로의 출력을 수행하는 태그(엔터, 스페이스 등을 인정) -->
		<pre>${boardDto.boardContent}</pre>
		</div>	
		<br><br>
		<!--
			좋아요 처리 시나리오
			1. 이 페이지가 최초로 로딩되었을 때, 현재 사용자가 이 글에 좋아요를 누른적이 있는지 + 현재 좋아요 개수를 불러옴
			 → 하트를 채울지 비울지 결정, 하트 옆에 적어야될 숫자를 표시
			 → 비회원도 가능한 기능
			2. 하트를 클릭하면 글번호를 알려주면서 좋아요 / 해제 처리를 요청
			 → 서버에서 결과적으로 좋아요/해제 중 어떤 것이 처리되었는지와 현재 좋아요 개수를 알려줌 
			 → 회원만 가능한 기능 
		-->
		<div>
			<span>좋아요</span>
			<i class="fa-solid fa-heart red"></i> 
			<span class="heart-count">?</span>
		</div>
		<div>
		댓글 ${boardDto.boardReplycount}
		</div>
		<hr>
		<!-- 이전글 / 다음글 -->
		이전글 : <a href="./detail?boardNo=${prevBoardDto.boardNo}">${prevBoardDto.boardTitle}</a>
		<br>
		다음글 : <a href="./detail?boardNo=${nextBoardDto.boardNo}">${nextBoardDto.boardTitle}</a>
		<hr>
		<!-- 로그인 되어 있으면 -->
		<c:if test="${sessionScope.loginId != null}">
		<a href="./writer">글쓰기</a>
		<a href="./writer?boardParent=${boardDto.boardNo}">답글쓰기</a>
		</c:if>
		
		<!-- 
		sessionScope.loginId 현재 사용자의 아이디(비회원은 null)
		boardDto.boardWriter 작성자의 아이디(회원탈퇴 시 null)
		둘 다 null이어서 같은 경우는 제거해 줘야한다. 
		${boardDto.boardWriter != null}조건을 안걸면 비회원이 탈퇴한 글을 볼 때 본인으로 판정되는 걸 제거하기 위한 추가 검사하기 위한 코드
		-->
		<c:if test="${boardDto.boardWriter != null && boardDto.boardWriter == sessionScope.loginId }">
		<a href="./edit?boardNo=${boardDto.boardNo}">수정</a>
		<a href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
		</c:if>
		<a href="./list">목록으로</a>
		
	<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

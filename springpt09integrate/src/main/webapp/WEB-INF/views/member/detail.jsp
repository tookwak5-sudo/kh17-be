<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 좋아요 처리 관련 자바스크립트 (비회원도 가능) -->
<script type="text/javascript">
	//header.jsp에 jQuery CDN이 있기 때문에 그냥 사용 가능
	$(function(){
		//시작하자마자 서버에 물어봐서 좋아요 상태와 좋아요 개수를 알아낸다
		
		//주소창에 있는 파라미터 중 memberId를 꺼내는 코드
		var params = new URLSearchParams(window.location.search);
		var memberTarget = params.get("memberId");
		
		$.ajax({
			url: "/rest/member/like-check",
			method: "post",
			data: { memberTarget : memberTarget },
			success: function(response){
				//response에 action, count가 있을 것으로 기대
				//- action은 좋아요 여부, count는 좋아요 개수
				$(".fa-heart").removeClass("fa-regular fa-solid")
					.addClass(response.action ? "fa-solid" : "fa-regular");
				$(".fa-heart").next(".heart-count").text(response.count);
			}
		});
	});
</script>

<!-- el로 처리  -->
<c:if test="${sessionScope.loginId !=null && sessionScope.loginId != params.memberId}">
<!-- 좋아요 토글 자바스크립트(회원만 가능)  -->
<script type="text/javascript">
	$(function(){
		//주소창에 있는 파라미터 중 boardNo를 꺼내는 코드
		var params = new URLSearchParams(window.location.search);
		var memberTarget = params.get("memberId");
		
		//하트를 클릭하면 좋아요 토글이 발생하도록 처리
		$(".fa-heart").on("click", function(){
			$.ajax({
				url: "/rest/member/like-action",
				method: "post",
				data: { memberTarget : memberTarget },
				success: function(response) {
					$(".fa-heart").removeClass("fa-regular fa-solid")
						.addClass(response.action ? "fa-solid" : "fa-regular");
					$(".fa-heart").next(".heart-count").text(response.count);
				}
			});
		});
	});
</script>
</c:if>	

<div class="container w-800 mt-50 mb-50">
<h1>${memberDto.memberNickname}님의 개인 정보</h1>

<img src="./profile?memberId=${memberDto.memberId}" width="100" height="100"
		style="border-radius:50%; box-shadow:0 0 1px 0 black">

<ul>
	<li>아이디 : ${memberDto.memberId}</li>
	<li>닉네임 : ${memberDto.memberNickname}</li>
	<li>등급 : ${memberDto.memberLevel}</li>
	<li>상태메세지 : ${memberDto.memberMessage}</li>
	<li>가입일 : <fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 E a h시 m분"/></li>
</ul>

<hr>

<h1>작성한 게시글 목록</h1>

<table border="1" width="800">
	<thead>
		<tr>
			<th>번호</th>
			<th width="45%">제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="boardDto" items="${boardList}">
		<tr>
			<td>${boardDto.boardNo}</td>
			<td align="left">
				<a href="/board/detail?boardNo=${boardDto.boardNo}">
					${boardDto.boardTitle}
				</a>
			</td>
			<td>${boardDto.getBoardWtimeString()}</td>
			<td>${boardDto.boardReadcount}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

	<div class="cell mt-20 flex-area">
		<div>
			좋아요 
			<i class="fa-solid fa-heart red"></i>
			<span class="heart-count">0</span>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

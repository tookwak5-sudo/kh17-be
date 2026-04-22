<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
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
		좋아요 ${boardDto.boardLikecount}
		댓글 ${boardDto.boardReplycount}
	
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

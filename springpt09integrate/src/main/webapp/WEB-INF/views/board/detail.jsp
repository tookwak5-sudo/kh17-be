<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
		<h1>
			<c:if test="${boardDto.boardHead != null}">
			(${boardDto.boardHead})
			</c:if>
			${boardDto.boardTitle}
		</h1>
		${boardDto.boardWriter} <br><br>
		<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		조회수 ${boardDto.boardReadcount}
		<hr>
		<div style="min-height: 250px">
		<!-- 잇는 그대로의 출력을 수행하는 태그(엔터, 스페이스 등을 인정) -->
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
		</c:if>
		<a href="./edit?boardNo=${boardDto.boardNo}">수정</a>
		<a href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
		<a href="./list">목록으로</a>
		
	<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

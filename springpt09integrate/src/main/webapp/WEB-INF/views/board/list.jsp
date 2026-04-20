<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 제목 -->
<h1>자유게시판</h1>
타인에 대한 무분별한 비방글은 예고 없이 삭제될 수 있습니다
<hr>

<c:if test="${sessionScope.loginId != null}">
		<a href="./writer">글쓰기</a>
		</c:if>


<!-- 게시글 목록 -->

<h2>게시글 수: ${list.size()}</h2>
<table border=1 width=1000>
	<thead>
	<tr>
	<th>번호</th>
	<th width="45%">제목</th>
	<th>작성자</th>
	<th>작성일</th>
<!-- 	<th>최종수정일</th> -->
	<th>조회수</th>
	<th>좋아요</th>
	</tr>
	</thead>
	<tbody align="center">
		<c:forEach var="boardDto" items="${list}">
		<c:if test="${boardDto.boardHead == '공지'}">
		<tr>
			<td>${boardDto.boardNo}</td>
			<td align="left">
				<!-- 말머리가 있으면 표시 -->
<%-- 				<c: if test="${boardDto.boardHead != null}"> --%>
				(${boardDto.boardHead})
<%-- 				</c:> --%>
				
				<!-- 게시글 제목 -->
				<a href="./detail?boardNo=${boardDto.boardNo}">
				${boardDto.boardTitle}
				</a>
				
				<!-- 댓글 개수도 있으면(>0) 표시 -->
				<c:if test="${boardDto.boardReplycount >0}">
				[${boardDto.boardReplycount}]
				</c:if>
			</td>
			<td>
				<a href="/member/detail?memberId=${boardDto.boardWriter}">
				${boardDto.boardWriter}
				</a>
			</td>
			<td>${boardDto.boardWtimeString}</td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardLikecount}</td>
		</tr>
		</c:if>
		</c:forEach>
		<c:forEach var="boardDto" items="${list}">
		
		<tr>
			<td>${boardDto.boardNo}</td>
			<td align="left">
			<!-- 말머리가 있으면 표시 -->
				(${boardDto.boardHead})
				
				<!-- 게시글 제목 -->
				<a href="./detail?boardNo=${boardDto.boardNo}">
				${boardDto.boardTitle}
				</a>
				
				<!-- 댓글 개수도 있으면(>0) 표시 -->
				<c:if test="${boardDto.boardReplycount >0}">
				[${boardDto.boardReplycount}]
				</c:if>
			</td>
				
			<td>
				<a href="../member/detail?memberId=${boardDto.boardWriter}">
					${boardDto.boardWriter}
				</a>
			</td>
			<td>${boardDto.boardWtimeString}</td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardLikecount}</td>
		</tr>
		
		</c:forEach>
	</tbody>
</table>

<!--  페이지네이션 --> <!-- html특수문자표 참조 -->
<h2> &lt; 1 2 3 4 5 6 7 8 9 10 &gt; </h2>

<!-- 검색창 -->
<form action="./list">
	<select name="column">
		<option value="board_title" ${param.column == "board_title" ? "selected" : ""}>제목</option>
		<option value="board_writer" ${param.column == "board_writer" ? "selected" : ""}>작성자</option>
	</select>
	<input type="text" name="keyword" placeholder="검색어" value="${param.keyword}" required>
	<button>검색</button>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

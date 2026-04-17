<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시판</h1>
<a href="./writer">글작성</a>
<!-- 검색창 -->
<form action="./list">
	<select name="column">
		<option value="board_title" ${param.column == "board_title" ? "selected" : ""}>제목</option>
		<option value="board_writer" ${param.column == "board_writer" ? "selected" : ""}>작성자</option>
	</select>
	<input type="text" name="keyword" value="${param.keyword}" required>
	<button>검색</button>
</form>


<!-- 결과출력 -->

<h2>게시글 수: ${list.size()}</h2>
<table border=1 width=1000>
	<thead>
	<tr>
	<th>번호</th>
	<th>구분</th>
	<th>제목</th>
	<th>작성자</th>
	<th>작성일</th>
	<th>최종수정일</th>
	<th>조회수</th>
	<th>좋아요</th>
	<th>댓글수</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="boardDto" items="${list}">
		<c:if test="${boardDto.boardHead == '공지'}">
		<tr>
			<td>${boardDto.boardNo}</td>
			<td>
				<b style="color: red;">${boardDto.boardHead}</b>
				</td>
			<td>
				<a href="./detail?boardNo=${boardDto.boardNo}">
					${boardDto.boardTitle}
				</a>
			</td>
				
			<td>
				<a href="./detail?boardNo=${boardDto.boardNo}">
				${boardDto.boardWriter}
				</a>
			</td>
				<td><fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd"/> </td>
			<td><fmt:formatDate value="${boardDto.boardEtime}" pattern="yyyy-MM-dd"/> </td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardLikecount}</td>
			<td>${boardDto.boardReplycount}</td>
		</tr>
		</c:if>
		</c:forEach>
		<c:forEach var="boardDto" items="${list}">
		
		<tr>
			<td>${boardDto.boardNo}</td>
			<td>
				${boardDto.boardHead}
				</td>
			<td>
				<a href="./detail?boardNo=${boardDto.boardNo}">
					${boardDto.boardTitle}
				</a>
			</td>
				
			<td>
				<a href="./detail?boardNo=${boardDto.boardNo}">
				${boardDto.boardWriter}
				</a>
			</td>
			<td>
				<c:if test="${boardDto.boardWtimeNow == 'today'}">
				<fmt:formatDate value="${boardDto.boardWtime}" pattern="HH:mm:ss"/> 
				</c:if>
				<c:if test="${boardDto.boardWtimeNow == 'last'}">
				<fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd"/> 
				</c:if>
			</td>
			<td><fmt:formatDate value="${boardDto.boardEtime}" pattern="yyyy-MM-dd"/> </td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardLikecount}</td>
			<td>${boardDto.boardReplycount}</td>
		</tr>
		
		</c:forEach>
	</tbody>
</table>




<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

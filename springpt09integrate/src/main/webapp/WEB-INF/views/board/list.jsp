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
${pageVo.beginRownum}-${pageVo.endRownum} / 총 ${pageVo.count}개의 글
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
		<!-- 일반 게시물 -->
		<!--  varStatus를 쓰면 반복문의 상태를 알 수 있다(index, count, first, last) -->
		<c:forEach var="boardDto" items="${list}" varStatus="stat">
<%-- 		<tr bgcolor="${boardDto.boardHead == '공지' ? '#33d9b2' : ''}"> --%><!-- head가 공지인 것만 -->
		<tr bgcolor="${stat.index < noticeCount ? '#33d9b2' : ''}">
			<tr bgcolor="${stat.count <= noticeCount ? '#33d9b2' : ''}">
			<td>${boardDto.boardNo}</td>
			<td align="left">
<%-- 				${stat.first}처음인지 아닌지를 감지 ${stat.last}마지막인지 아닌지를 감지 --%>
				
				<!-- 말머리가 있으면 표시 -->
				<c:if test="${boardDto.boardHead != null}">
				(${boardDto.boardHead})
				</c:if>
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
				<c:if test="${boardDto.boardWriter == null}">
					(탈퇴한 사용자)
				</c:if>
				<c:if test="${boardDto.boardWriter != null}">
					<a href="../member/detail?memberId=${boardDto.boardWriter}">
					${boardDto.boardWriter}
					</a>
				</c:if>
			</td>
			<td>${boardDto.boardWtimeString}</td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardLikecount}</td>
		</tr>
		
		</c:forEach>
	</tbody>
</table>

<!-- 페이지네이션 -->
<jsp:include page="/WEB-INF/views/template/pagenation.jsp"></jsp:include>

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

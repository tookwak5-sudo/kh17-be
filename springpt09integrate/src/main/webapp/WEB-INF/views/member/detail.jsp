<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h1>상세정보</h1>
<img src="./profile?memberId=${memberDto.memberId}" width="200"
		style="border-radius:50%; box">
<%--  <fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate>  --%>
 <ul>
 	<li>아이디: ${memberDto.memberId}</li>
 	<li>닉네임: ${memberDto.memberNickname}</li>
 	<li>등급: ${memberDto.memberLevel}</li>
 	<li>상태메세지: ${memberDto.memberMessage}</li>
 	<li><fmt:formatDate value="${memberDto.memberJoin}" pattern="y년 M월 d일 E a H시 m분"></fmt:formatDate></li>
 	
 </ul>
 
 <hr>
 
 <h1>작성한 게시글 목록</h1>
 <table border = 1>
 	<thead>
 		<tr>
 			<th>번호</th>
 			<th width="45%">제목</th>
 			<th>작성일</th>
 			<th>조회수</th>
 		</tr>
 	</thead>
 	<tbody align="center">
 		<c:forEach var="boardDto" items= "${boardList}">
 		<tr>
 			<td>${boardDto.boardNo}</td>
 			<td align="left">
 				<a href="/board/detail?boardNo=${boardDto.boardNo}">
 				${boardDto.boardTitle}</td>
 				</a>
 			<td>${boardDto.getBoardWtimeString()}</td>
 			<td>${boardDto.boardReadcount}</td>
 		</tr>
 		 </c:forEach>
 	</tbody>
 </table>
 
 <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
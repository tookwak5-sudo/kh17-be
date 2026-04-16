<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 제목 -->    
<h1>회원목록</h1>

<!-- 검색창 -->
<!-- /admin/member/list -->
<form action="./list">
	<select name="column">
		<option value="member_id" ${param.column == "member_id" ? "selected" : ""}>아이디</option>
		<option value="member_email" ${param.column == "member_emIl" ? "selected" : ""}>이메일</option>
		<option value="member_nickname" ${param.column == "member_nickname" ? "selected" : ""}>닉네임</option>
		<option value="member_contact" ${param.column == "member_contact" ? "selected" : ""}>연락처</option>
	</select>
	<input type = "text" name="keyword" placeholder="검색어 입력"
		   value="${param.keyword}">
	<button>검색</button>
</form>

<!-- 결과출력 -->
<c:if test="${param.column != null && param.keyword !=null}">

<c:if test="${list.size() > 0}">
<h2>회원 수: ${list.size()}</h2>
<table border=1 width=1000>
	<thead>
	<tr>
	<th>이메일</th>
	<th>닉네임</th>
	<th>연락처</th>
	<th>가입일</th>
	<th>회원등급</th>
	<th>차단</th>
	<th>아이디</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="memberDto" items="${list}">
<%-- 		<c:forEach var="memberDto" items="${requestScope.list}"> --%>
	<tr>
	
	<td>${memberDto.memberEmail}</td>
	<td>${memberDto.memberNickname}</td>
	<td>${memberDto.memberContact}</td>
	<td><fmt:formatDate value="${memberDto.memberJoin}" pattern="yyyy-MM-dd"/> </td>
	<td>${memberDto.memberLevel}</td>
	<td>${memberDto.memberBlock}</td>
	<td>
		<a href="./detail?memberId=${memberDto.memberId}">
		${memberDto.memberId}
		</a>
	</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

</c:if>
</c:if>
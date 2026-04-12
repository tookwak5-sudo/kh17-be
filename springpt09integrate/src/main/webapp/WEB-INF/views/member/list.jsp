<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 제목 -->    
<h1>회원목록</h1>

<!-- 검색창 -->
<form action="./list">
	<select name="column">
		<option value="member_id" ${param.column == "member_id" ? "selected" : ""}>아이디</option>
		<option value="member_nickname" ${param.column == "member_nickname" ? "selected" : ""}>별명</option>
		<option value="member_contact" ${param.column == "member_contact" ? "selected" : ""}>연락처</option>
		<option value="member_level" ${param.column == "member_level" ? "selected" : ""}>등급</option>
	</select>
	<input type = "text" name="keyword" placeholder="검색어 입력"
		   value="${param.keyword}">
	<button>검색</button>
</form>
<!-- 등록링크 -->
<a href="./insert">신규등록</a>
<!-- 결과출력 -->

<h2>회원 수: ${list.size()}</h2>

<table border=1 width=1000>
	<thead>
	<tr>
	<th>회원번호</th>
	<th>아이디</th>
	<th>이메일</th>
	<th>비밀번호</th>
	<th>별명</th>
	<th>연락처</th>
	<th>회원등급</th>
	<th>회원 포인트</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="memberDto" items="${list}">
	<tr>
	<td>${memberDto.memberNo}</td>
	<td>
		<a href="./detail?memberNo=${memberDto.memberNo}">
		${memberDto.memberId}
		</a>
	</td>
	<td>${memberDto.memberEmail}</td>
	<td>${memberDto.memberPassword}</td>
	<td>${memberDto.memberNickname}</td>
	<td>${memberDto.memberContact}</td>
	<td>${memberDto.memberLevel}</td>
	<td>${memberDto.memberPoint}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>

<c:forEach var="memberDto" items="${list}">

</c:forEach>

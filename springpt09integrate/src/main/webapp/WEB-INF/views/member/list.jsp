<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 제목 -->    
<h1>회원목록</h1>

<!-- 검색창 -->
<form action="./list">
	<select name="column">
		<option value="member_Id">아이디</option>
		<option value="member_nickname">별명</option>
		<option value="member_contact">연락처</option>
		<option value="member_level">등급</option>
	</select>
	<input type = "text" name="keyword" placeholder="검색어 입력"
		   value="${param.keyword}">
	<button>검색</button>
</form>

<!-- 결과출력 -->

<h2>회원 수: ${list.size()}</h2>

<table>
	<thead>
	<tr>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	<th>아이디</th>
	</tr>
	</thead>
	<tbody>
	<tr><td></td>
	</tr>
	</tbody>
</table>

<c:forEach var="memberDto" items="${list}">

</c:forEach>

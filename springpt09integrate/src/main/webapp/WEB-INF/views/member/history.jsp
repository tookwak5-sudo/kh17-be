<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1>로그인 이력 상세조회</h1>

<form action="./history">
	시작날짜 <input type = "date" name ="beginDate" value="${param.beginDate}" required>
	마지막날짜 <input type = "date" name ="endDate" value="${param.endDate}" required>
	<button>조회</button>
</form>

<a href="/">홈으로</a>

<h2>결과출력</h2>

<table border="1" width="1500">
	<thead>
		<tr>
			<th>일시</th>
			<th>접속주소</th>
			<th>에이전트</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="memberHistoryDto" items="${loginHistory}">
		<tr>
			<td>
				<fmt:formatDate value="${memberHistoryDto.memberHistoryTime}" 
											pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>${memberHistoryDto.memberHistoryAddress}</td>
			<td>${memberHistoryDto.memberHistoryAgent}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
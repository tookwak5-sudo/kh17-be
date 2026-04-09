<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 제목 -->
<h1>국가 목록 및 검색</h1>

<!-- 검색창 -->
<form action="./list">
	<select name="column">
		<option value="country_name" ${param.column == "country_name" ? "selected" : ""}>국가명</option>
		<option value="country_region" ${param.column == "country_region" ? "selected" : ""}>대륙명</option>
		<option value="country_capital" ${param.column == "country_capital" ? "selected" : ""}>수도명</option>
	</select>
	<input type = "text" name="keyword" placeholder="검색어 입력"
		   value="${param.keyword}">
	<button>검색</button>
</form>

<!-- 등록링크 -->
<a href="./insert">신규 등록하기</a>

<!-- 결과 출력 -->
<h2>결과 수 : ${list.size()}</h2>

<table border="1" width="500">
		<thead>
		<tr>
			<th>번호</th>
			<th>대륙</th>
			<th>이름</th>
			<th>수도</th>
			<th>인구</th>
		</tr>
		</thead>
		<!-- 데이터 영억 -->
		<tbody align="center">
			<c:forEach var="countryDto" items="${list}">
			<tr>
				<td>${countryDto.countryNo}</td>
				<td>${countryDto.countryRegion}</td>
				<td>
					<a href="./detail?countryNo=${countryDto.countryNo}">
						${countryDto.countryName}
					</a>
				</td>
				<td>${countryDto.countryCapital}</td>
				<td align="right">
					<fmt:formatNumber 
					value="${countryDto.countryPopulation}" 
					pattern="#,##0"></fmt:formatNumber>명
				</td>
			</tr>
			</c:forEach>
		</tbody>

</table>

<%-- <c:forEach var="countryDto" items="${list}"> --%>
<!-- 	<hr> -->
<!-- 	<div> 비어있는 영역 -->
<%-- 		<h3>[${countryDto.countryRegion}] ${countryDto.countryName}</h3> --%>
<%-- <%-- 		원래는 --%>
<%-- 	수도 : ${countryDto.getCountryCapital} <br> --%>
<%-- 	근데 En에서 자동으로 필드명만 입력해도 자동으로 getter메소드를 가져옴} --%>
<%--  --%>  --%>
<%-- 		수도 : ${countryDto.countryCapital} <br> --%>
<%-- 		<%--인구 : ${countryDto.countryPopulation} <br> --%> --%>
<%-- 		인구 : <fmt:formatNumber value="${countryDto.countryPopulation}" --%>
<%-- 								 pattern="#,##0"></fmt:formatNumber>명<br> --%>
<!-- 	</div> -->
<%-- </c:forEach> --%>

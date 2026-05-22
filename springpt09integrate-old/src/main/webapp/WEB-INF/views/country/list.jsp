<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<div class="container w-900">
	<!-- 제목 -->
	<div class="cell center">
		<h1>국가 목록</h1>
	</div>
	
	<!-- 결과 출력 -->
	<div class="cell right">
	<h2>결과 수 : ${pageVo.beginRownum} ~ ${pageVo.endRownum}  / 총 ${pageVo.count}개</h2>
	</div>
	
	<div class="cell right">
		<div class="flex-area">
			<div>
				<!-- 검색창 -->
				<form action="./list">
					<select name="column" class="field">
						<option value="country_name" ${param.column == "country_name" ? "selected" : ""}>국가명</option>
						<option value="country_region" ${param.column == "country_region" ? "selected" : ""}>대륙명</option>
						<option value="country_capital" ${param.column == "country_capital" ? "selected" : ""}>수도명</option>
					</select>
					<input type = "text" name="keyword" placeholder="검색어 입력"
						   value="${param.keyword}" class="field" required>
					<button type="submit" class="btn btn-positive">검색</button>
				</form>
			</div>
			<div class="flex-fill right">
				<a href="./insert" class="btn btn-netural">
					<i class="fa-solid fa-plus"></i>
					<span>신규 등록</span>
				</a>
			</div>
	</div>
		<!-- 테이블 -->
		<div class="cell center">
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>대륙</th>
						<th>이름</th>
						<th>수도</th>
						<th>인구</th>
					</tr>
				</thead>
				<tbody class="center">
					<c:forEach var="countryDto" items="${list}">
					<tr>
						<td>${countryDto.countryNo}</td>
						<td>${countryDto.countryRegion}</td>
						<td>
							<a href="./detail?countryNo=${countryDto.countryNo}&page=${pageVo.page}&${pageVo.getSearchParams()}">
								${countryDto.countryName}
							</a>
							<img src="./flag?countryNo=${countryDto.countryNo}" width="20">
						</td>
						<td>${countryDto.countryCapital}</td>
						<td class="right">
							<fmt:formatNumber 
							value="${countryDto.countryPopulation}" 
							pattern="#,##0"></fmt:formatNumber>명
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>
<jsp:include page="/WEB-INF/views/template/pagenation.jsp"></jsp:include>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

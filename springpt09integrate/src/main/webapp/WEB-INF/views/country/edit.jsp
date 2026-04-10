<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>국가 정보 수정</h1>

<form action="./edit" method="post">
	<!-- 기본키(번호, countryNo)를 숨김 첨부 -->
	<input type="hidden" name="countryNo" value="${countryDto.countryNo}">
	
	대륙 <input type="text" name="countryRegion" value="${countryDto.countryRegion}"> <br><br>
	이름 <input type="text" name="countryName" value="${countryDto.countryName}"> <br><br>
	수도 <input type="text" name="countryCapital" value="${countryDto.countryCapital}"> <br><br>
	인구 <input type="text" name="countryPopulation" value="${countryDto.countryPopulation}"> <br><br>
	<button><em>수정하기</em></button>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
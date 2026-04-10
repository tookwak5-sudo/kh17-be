<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>국가 상세정보</h1>

<!-- 
	리스트 태그(ul, ol)
	- ul은 순서가 없는 리스트 (unorder list)
	- ol은 순서가 있는 리스트 (order list)
	- li는 리스트 내부의 항목 (list itme) 
-->

<ul>
	<li>번호 : ${countryDto.countryNo}</li>
	<li>대륙 : ${countryDto.countryRegion}</li>
	<li>이름 : ${countryDto.countryName}</li>
	<li>수도 : ${countryDto.countryCapital}</li>
	<li>인구 : ${countryDto.countryPopulation}명</li>
</ul>

<ol>
	<li><p><a href="./list">목록으로 이동</a></p></li>
	<li><p><a href="./insert">신규등록</a></p></li>
	<li><p><a href="./edit?countryNo=${countryDto.countryNo}">수정</a></p></li>
	<li><p><a href="./delete?countryNo=${countryDto.countryNo}">삭제</a></p></li>
	<%-- <p><a href="./delete?countryNo="${param.countryNo}"></a></p> --%>
</ol>


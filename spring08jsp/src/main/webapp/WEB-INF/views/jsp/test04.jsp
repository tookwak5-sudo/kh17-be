<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--
	JSTL
	- Jsp Standard Tag Library의 줄임말
	- JSP에서만 쓸 수 있는 특별한 태그 모음들
	- Jsp에서 데이터를 출력할 때 발생할 수 있는 프로그래밍적인 상황(ex: 조건, 반복, 예외, 형식)을 처리
	- 태그 형태이기 때문에 HTML과 더 잘 어우러져 보인다
	- 상황에 맞게 쓸 수 있도록 다양한 종류가 존재하며 필요한 태그를 "등록"하여 사용
		-c(core) - 조건, 반복, 예외 등 기초 프로그래밍 로직을 태그로 구현해놓은것
		-f(format) - 날짜형식, 숫자형식 등을 제어할 수 있는 태그 모음
		-functions - 문자열 처리를 도와주는 기능(사용하지 않는다, 컨트롤러에서 처리)
		-xml - xml형식을 해석하고 제어하는 기능(사용하지 않음, 컨트롤러에서 처리)
		-sql - database를 제어하는 기능(사용하지 않음, 컨트롤러에서 처리) 
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>이번주 로또번호</h1>

<%-- <h2>${lotto}</h2> --%>
<c:forEach var="number" items="${lotto}">
	<h2>번호 = ${number}</h2>
</c:forEach>

<hr>

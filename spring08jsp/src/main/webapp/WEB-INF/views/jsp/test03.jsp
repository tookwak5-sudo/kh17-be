<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL에는 다른 위치에 있는 데이터들도 읽을 수 있는 저장소가 존재
	- 파라미터 : param 
--%>

<h1>${param.krw}원을 환전하면...</h1>
<h2>달러 : ${usd}</h2><br><br>
<h2>엔화 : ${jpy}</h2><br><br>
<h2>위안화 : ${cny}</h2><br><br>

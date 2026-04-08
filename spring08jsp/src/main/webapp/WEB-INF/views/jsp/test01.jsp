<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
	EL (Expression Language)
	- JSP에서 프로그래밍 결과를 화면에 표현하는 방법
	- 문법 : ${이름}	
	- 장점 : 없어도 null이 출력되지 않는다
	- 자료형 구분을 따로 하지 않는다
	- 비교를 비교연산(==)으로 한다
	- 그 외에도 출력과 관련해서 불편했던 점들이 대폭 개선되었다
	- 프로그래밍 처리(if, for) 등은 불가능 (→ JSTL까지 같이 쓰면 가능)
	- el : 무언가가 왔을 때 어딘가로 표시하는 언어
--%>

<h1>JSP예제 1번</h1>

컨트롤러에서 전달되는 데이터들을 화면에 출력할 수 있습니다. <br><br>

message : ${message} <br><br>
dice : ${dice} <br><br>
lotto : ${lotto} <br><br>
hello : ${hello} <br><br> 
   
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
   
<%-- 
	지금 구현하고 싶은 코드
	for(int number : dice){
		System.out.println(number);
		if(number==6){
		System.out.prinltn("당첨");
	}
--%>  
   <h1>주사위 10개</h1>
  <c:forEach var="number" items="${dice}">
   <h2>
   		번호 : ${number}
   		<c:if test="${number == 6}">
   			(당첨)
   		</c:if>
   	</h2>
  </c:forEach>
  
  <hr>
  
  <%-- 
	지금 구현하고 싶은 코드
	for(int i=0; i<dice.size(); i++){
		System.out.println(dice.get(i));
		if(dice.get(i) == 6){
		System.out.prinltn("당첨");
	}
--%>  

<c:forEach var="i" begin="0" end="${dice.size()-1}" step= "1">
	<h2>
		주사위 = ${dice.get(i)}
		<c:if test="${dice.get(i) == 6}">
			(당첨)
		</c:if>
	</h2>
</c:forEach>
  
  

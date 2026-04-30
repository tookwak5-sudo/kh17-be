<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    

<!--  페이지네이션  -->
 
<div class="pagination on">
<!-- 맨 첫 페이지 -->
<a href="./list?page=1&${pageVo.getSearchParams()}">
	<i class="fa-solid fa-chevron-left"></i>
</a>

<!-- 이전 -->
<c:if test="${pageVo.hasPrevious()}">
<%-- <a href="./list?page=${beginBlock-1}&size=${size}${searchParams}" >&lt;</a> --%>
<a href="./list?page=${pageVo.getPreviousBlock()}&${pageVo.getSearchParams()}" >
	 <i class="fa-solid fa-chevron-left"></i>
</a>
</c:if>

<!-- 숫자 --> 
<c:forEach var="i" begin="${pageVo.getBeginBlock()}" end="${pageVo.getEndBlock()}" step="1">
	<!-- 현재 페이지의 번호를 출력하는 경우(활성화 처리) -->
	<c:if test="${pageVo.page == i}" >
		<a href="#"	class="on">${i}</a>
	</c:if>
	<!-- 현재 페이지가 아닌 번호를 출력하는 경우 -->
	<c:if test="${pageVo.page != i}">
	<a href="./list?page=${i}&${pageVo.getSearchParams()}">${i}</a>
	</c:if>
</c:forEach>

<!-- 다음 -->
<c:if test="${pageVo.hasNext()}">
<a href="./list?page=${pageVo.getNextBlock()}&${pageVo.getSearchParams()}" >
	<i class="fa-solid fa-chevron-right"></i>
</a> 
</c:if>

 <!-- 맨 끝 페이지 -->
<a href="./list?page=${pageVo.getPageCount()}&${pageVo.getSearchParams()}">
	<i class="fa-solid fa-chevron-right"></i>
</a>
 </div>

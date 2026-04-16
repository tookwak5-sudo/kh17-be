<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
 <h1> 회원 정보 변경</h1>
<form action="./edit" method="post">  
아이디: ${memberDto.memberId} <br>
<!-- 반드시 hidden이 필요하다 why? 전달을 안하면 수정이 불가능하기 때문에, 내정보가 아니라 남의 정보를 가져와야 하기 때문에 -->
<input type="hidden" name="memberId" value="${memberDto.memberId}"> 
	이메일 <input type="text" inputmode="email" name="memberEmail" value="${memberDto.memberEmail}" required> <br><br>
	닉네임 <input type="text" inputmode="text" name="memberNickname" value="${memberDto.memberNickname}" required> <br><br>
	생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}"> <br><br>
	연락처 <input type="text" inputmode="tel" name="memberContact" value="${memberDto.memberContact}"> <br><br>
 	등급  <!-- 관리자가 관리자를 만드는 건 안됨 그래서 슈퍼관리자가 있거나, DB에서 고쳐야함 -->
 	   	<!-- (중요) 즉, 자신과 동일한 등급은 생성이 불가 -->
 		<select name ="memberLevel" required>
 			<option ${memberDto.memberLevel = '브론즈' ? 'selected' : ''}>브론즈</option>
 			<option ${memberDto.memberLevel = '실버' ? 'selected' : ''}>실버</option>
 			<option ${memberDto.memberLevel = '골드' ? 'selected' : ''}>골드</option>
 			<option ${memberDto.memberLevel = '플래티넘' ? 'selected' : ''}>플래티넘</option>
 			<option ${memberDto.memberLevel = '다이아' ? 'selected' : ''}>다이아</option>
 		</select>
 		<br><br>
	포인트  <input type="text" inputmode="text" name="memberPoint" value="${memberDto.memberPoint}" required> <br><br>
	<button>정보 변경하기</button>
 </form>
 
 
 <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
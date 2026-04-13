<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
 <h1>멤버 정보 수정</h1>
 	변경을 확인하기 위해 비밀번호를 입력해주세요
 <form action="./edit" method="post">
 	비밀번호 <input type="text" name="memberPassword" value="${memberDto.memberPassword}"> <br><br>
	이메일 <input type="text" name="memberEmail" value="${memberDto.memberEmail}"> <br><br>
	별명 <input type="text" name="memberNickname" value="${memberDto.memberNickname}"> <br><br>
	생일 <input type="text" name="memberBirth" value="${memberDto.memberBirth}"> <br><br>
	연락처 <input type="text" name="memberContact" value="${memberDto.memberContact}"> <br><br>
	우편번호 <input type="text" name="memberPost" value="${memberDto.memberPost}"> <br><br>
	기본주소 <input type="text" name="memberAddress1" value="${memberDto.memberAddress1}"> <br><br>
	상세주소 <input type="text" name="memberAddress2" value="${memberDto.memberAddress2}"> <br><br>
	상태메세지 <input type="text" name="memberMessage" value="${memberDto.memberMessage}"> <br><br>
	<button>수정</button>
 </form>
 
 <c:if test="${param.error != null}">
 		<p style="color:red;">비밀번호가 틀립니다</p> 
 </c:if>
 
 <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
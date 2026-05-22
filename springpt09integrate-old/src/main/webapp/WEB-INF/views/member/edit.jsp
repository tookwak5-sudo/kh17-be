<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
 
 <jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
 
 <h1>내 정보 변경</h1>
 	변경을 확인하기 위해 비밀번호를 입력해주세요
 <form action="./edit" method="post" enctype="multipart/form-data">
 	<h2>변경할 정보 입력</h2>
	이메일 <input type="text" inputmode="email" name="memberEmail" value="${memberDto.memberEmail}" required> <br><br>
	<!-- 굳이 써야한다면 text지만 안쓸 수 있는 정보는 안쓰도록 -->
	닉네임 <input type="text" inputmode="text" name="memberNickname" value="${memberDto.memberNickname}" required> <br><br>
	생년월일 <input type="date" name="memberBirth" value="${memberDto.memberBirth}"> <br><br>
	연락처 <input type="text" inputmode="tel" name="memberContact" value="${memberDto.memberContact}"> <br><br>
	우편번호 <input type="text" inputmode="numeric" name="memberPost" value="${memberDto.memberPost}"
			size="6"  maxlength="6"> <br><br>
	기본주소 <input type="text" name="memberAddress1" value="${memberDto.memberAddress1}"
	 		size="80"> <br><br>
	 		<!-- 여기서는 영어 숫자 한글의 크기가 모두 1로 동일하기 때문에 우리가보는 관점(DB)이랑 다르기 때문에 주의 -->
	상세주소 <input type="text" name="memberAddress2" value="${memberDto.memberAddress2}"
			size="80"> <br><br>
	상태메세지 <br>
	<input type = "text" name="mebmerMessage" value="${memberDto.memberMessage}" size = "80">
<%-- 	<textarea rows="5" cols="80" name="memberMessage">${memberDto.memberMessage}</textarea>  --%>
	<br><br>
	<!-- 파일 선택창에는 value를 줄 수 없다(보안상의 이유로) -->
	표지 <input type="file" name="attach" accept=".png, .jpg"><br><br>
	(기존 프로필) <br>
	<img src="./profile?memberId=${memberDto.memberId}" width="100"> <br><br>
 	<br><br>
 	
	<h2>비밀번호 확인</h2> 
	<!-- 비밀번호는 넘겨주면 큰일난다.... 절대 정보 넘겨주지 말기 -->
 	비밀번호 <input type="text" name="memberPassword" required> <br><br>
	<c:if test="${param.error != null}">
 	<p style="color:red;">비밀번호가 일치하지 않습니다</p> 
 	</c:if>
 	
 	
	<button>정보 변경하기</button>
 </form>
 
 <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
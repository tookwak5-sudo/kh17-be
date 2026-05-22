<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
	$(function(){
// 		  //상태 객체
//           var state = {
//               empDeptValid : false,
//               empNameValid : false,
//               empEmailValid : false,
//               empPhoneValid : false,
//               empPositionValid : false,
//               empHireDateValid : true,
//               ok : function() {
//                   return Object.values(this)//이 객체의 모든 이름에 대한 값을 반환해라
//                   .filter(v => typeof v == "boolean") // boolean값만 추출해서
//                   .every(v => v === true); //모두 true인지 확인해서 반환해라;
//               }
//           };

//           //항목별 이벤트 처리
          
//           //부서
//            $("[name=empDept]").on("blur", function(){
//         	    var valid = this.value.length > 0;
//                 if(valid == false){ //형식 오류 먼저 제거
//                     //필요한 처리 (실패표시) 
//                     $("[name=empDept]").removeClass("success fail")
//                         .addClass("fail").attr("data-error", "1"); //클래스 다 지우고 fail을 추가한다
//                     state.empDeptValid = false;
//                     return;
//                 }
//            });
          
//           //폼 전송 처리
//           document.querySelector(".form-check").addEventListener("submit", function(e){
//               //입력창 상태 갱신처리
//               var selectList = document.querySelectorAll("select[name]");
//               for(var i = 0; i < selectList.length; i++){
//                   selectList[i].dispatchEvent(new Event('input'));
//               }
//               var inputList = document.querySelectorAll("input[name]");
//               for(var i=0; i < inputList.length; i++){
//                   inputList[i].dispatchEvent(new Event('blur'));
//               }

//               if(state.ok() == false){
//                   e.preventDefault();
//               }
//           });

	  });
</script>
<script type="text/javascript">
// 	$(function(){
// 		$.ajax(){
			
// 			method: "post",
// 			success:function(response){
// 				for(var i=0; i <response.length; i++){
// 					$("[name=deptName]").append("<option>...");
// 				}
// 			}
// 		}
		
// 	});
</script>

	<form action="./create" autocomplete="off" method="post" class="form-check">
	 <div class="container w-600 mt-50 mb-50"> 
	 	<div class="cell center">
	 		<h1>신규 부서 등록</h1>
	 	</div>
	 	<div class="cell">
	 		<label>부서명<i class="fa-solid fa-asterisk red"></i></label>
	 		<select class="field w-100" name="empDept">
	 				<option value="">선택하세요</option>
	 			<c:forEach var="deptDto" items="${deptNameList}" >
	 				<option value="${deptDto.deptId}">${deptDto.deptName}</option>
	 			</c:forEach>
	 		</select> 
	 		 <div class="fail-feedback">필수 항목입니다</div>
	 	</div>
	 	<div class="cell">
	 		<label>사원명<i class="fa-solid fa-asterisk red"></i></label>
	 		<input type="text" name="empName" class="field w-100"> 
	 	</div>
	 	<div class="cell">
	 		<label>이메일<i class="fa-solid fa-asterisk red"></i></label>
	 		<input type="text" inputmode="email" name="empEmail" class="field w-100">
	 	</div>
	 	<div class="cell">
	 		<label>연락처<i class="fa-solid fa-asterisk red"></i></label>
	 		<input type="text" inputmode="tel"  name="empPhone" class="field w-100">
	 	</div>
	 	<div class="cell">
	 		<label>직급<i class="fa-solid fa-asterisk red"></i></label>
	 		<select class="field w-100" name="empPosition">
	 			<option value="">선택하세요</option>
			    <option value="사원">사원</option>
			    <option value="대리">대리</option>
			    <option value="과장">과장</option>	
			    <option value="차장">차장</option>
			    <option value="부장">부장</option>
	 		</select>
	 	</div>
	 	<div class="cell">
	 		<label>입사일</label>
	 		<input type="date" name="empHireDate">
	 	</div>
		<div class="cell">
			<label>직무여부</label>
			<input type="checkbox" name="empUseYn" value="Y">
		</div>
		
	 	<div class="cell mt-50">
	 		<button type="submit" class="btn btn-positive w-100">등록</button>
	 	</div>
 	</div>
</form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- 자바스크립트 작성 영역 -->
    <script>
        function checkBoardTitle() {
            var tag = document.querySelector("[name=boardTitle]");
            var valid = tag.value.length > 0;
            tag.classList.remove("success", "fail");
            tag.classList.add(valid ? "success" : "fail");
            return valid;
        }
        function checkBoardHead() {
            var tag = document.querySelector("[name=boardHead]");
            tag.classList.add("success");
            return true;
        }
        function checkBoardContent() {
            var tag = document.querySelector("[name=boardContent]");
            var valid = tag.value.length > 0;
            tag.classList.remove("success", "fail");
            tag.classList.add(valid ? "success" : "fail");
            return valid;
        }

        function checkForm() {
            var boardTitleValid = checkBoardTitle();
            var boardHeadValid = checkBoardHead();
            var boardContentValid = checkBoardContent();

            var valid = boardTitleValid && boardHeadValid && boardContentValid;

            return valid;
        }
        
        function calculateCount() {
            //[1] 입력창을 선택한다
            var textarea = document.querySelector("[name=boardContent]");
            //[2] 글자수를 계산한다
            // var size = textarea.value.length;
            var size = getByteLength(textarea.value);

            //[3] 글자수를 표시한다
            //var count = document.querySelector(".count");
            //var count = textarea의 뒤에 있는 span; // doㅡ탐색 html은 tree구조
            //var count = document.querySelector("[name=q1] + .count") // css를 활용한 방법
            var div = textarea.nextElementSibling; //textarea의 바로 뒤에 있는 태그
            var span = div.children[0]; //div 내부에 있는 첫번째 태그를 받아옴
            span.textContent = size;


            //[4] 글자 수가 1000을 넘게 되면 넘어간 만큼 잘라내자
            if(size > 1000) {
                span.classList.add("red");
                
            }
            else{
                span.classList.remove("red");
            }

            //심화 : UTF-8 기준 바이트 수 계산 함수
            function getByteLength(str){
                return new TextEncoder().encode(str).length;
            }
        }
    </script>

<form action="./writer" method="post" enctype="multipart/form-data" autocomplete="off"
            onsubmit="return checkForm();">
        
        <div class="container w-500 mt-50 mb-50">
        
         <!--  제목창을 답글일 때와 새글일 때로 나눠서 처리  -->
        	<div class="cell">
                <c:if test="${param.boardParent == null}">	
                <h1>신규 글 작성</h1>
                </c:if>
                <c:if test="${param.boardParent != null}">	
                <h1>답글 작성</h1>
                </c:if>
                <span>타인에 대한 무분별한 비방글은 경고 없이 삭제될 수 있습니다</span>
            </div>
           
            
            <c:if test="${param.boardParent != null}">
            <input type="hidden" name="boardParent" value="${param.boardParent}">
            </c:if>
            
            <div class="cell">
                <label>제목<i class="fa-solid fa-asterisk red"></i></label> 
                <input type="text" name="boardTitle" class="field w-100" onblur="checkBoardTitle();">
                <div class="success-feedback">제목 설정이 완료되었습니다</div>
                <div class="fail-feedback">필수 입력 항목입니다</div>
            </div>
            
            <div class="cell">
                <label>구분</label> 
                <select name="boardHead" class="field w-100" oninput="checkBoardHead();">
                <option value="">선택 안함</option>
                
                <!-- 공지는 관리자만 보이도록 해야함 -->
                <c:if test="${sessionScope.loginLevel == '마스터'}">
                <option value="공지">공지</option>
                </c:if>
                
                <option value="유머">유머</option>
                <option value="자유">자유</option>
                <option value="정보">정보</option>
            </select>
            </div>
            
            <div class="cell">
                <label>내용<i class="fa-solid fa-asterisk red"></i></label>
                <textarea name="boardContent" class="field" rows="30" cols="50"
                		oninput="calculateCount();"
                        onblur="checkBoardContent();"></textarea>
               	<div class="right">
                    <span>0</span> / 1000 byte
                </div>
                <div class="success-feedback">입력이 완료되었습니다</div>
                <div class="fail-feedback">필수 입력 항목입니다</div>
            </div>
            <div class="cell mt-40">
            <button class="btn btn-positive w-100">등록</button>
            </div>
        </div>
    </form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
   
	
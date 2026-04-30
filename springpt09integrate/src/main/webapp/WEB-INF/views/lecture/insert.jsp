<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	  <form autocomplete="off" method="post" enctype="multipart/form-data">
        <div class="container w-500 mt-50 mb-50">
            <div class="cell center">
                <h1>신규 강좌 등록</h1>
            </div>
            <div class="cell">
                <label>강좌명 *</label>
                <input type="text" name="lectureTitle" 
                        class="field w-100" required
                        placeholder="e.g., 정보처리 산업기사 필기">
            </div>
            <div class="cell">
                <label>카테고리 *</label>
                <select class="field w-100" name="lectureCategory" required>
                    <option value="">선택하세요</option>
                    <option>이론</option>
                    <option>실습</option>
                    <option>시험</option>
                </select>
            </div>
            <div class="cell">
                <label>강의시간 *</label>
                <input type="text" inputmode="numeric" name="lectureDuration" 
                    class="field w-100" required>
            </div>
            <div class="cell">
                <label>수강료</label>
                <input type="text" inputmode="numeric" name="lecturePrice" 
                        class="field w-100" required>
            </div>
            <div class="cell">
                <label>강의형태</label>
                <select class="field w-100" name="lectureType" required>
                    <option value="">선택하세요</option>
                    <option>온라인</option>
                    <option>오프라인</option>
                    <option>혼합</option>
                </select>
            </div>
            <div class="cell">
                <label>미리보기</label>
                <input type="file" name="attach" accept=".png, .jpg" multiple
                class="field w-100">
            </div>
            <div class="cell mt-40">
                <button class="btn btn-neutral w-100">목록으로</button>
                <button class="btn btn-positive w-100">강좌생성</button>
            </div>
        </div>
    </form>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
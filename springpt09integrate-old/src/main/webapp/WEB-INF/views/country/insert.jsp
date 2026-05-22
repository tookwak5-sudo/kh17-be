<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script src="/js/country/insert.js"></script>

  <form action="./insert" method="post" autocomplete="off" class="form-check">

        <div class="container w-600 mt-50 mb-50">
            <div class="cell center">
                <h1>국가정보 등록</h1>
            </div>

            <div class="cell">
            <label>대륙명<i class="fa-solid fa-asterisk red"></i></label>
            <select class="field w-100" name="countryRegion"> 
                <option value="">선택하세요</option>
                <option>아시아</option>
                <option>아프리카</option>
                <option>북아메리카</option>
                <option>남아메리카</option>
                <option>유럽</option>
                <option>오세아니아</option>
            </select>
            <!-- <div class="success-feedback"></div> -->
            <div class="fail-feedback">필수 항목입니다</div>
            </div>

            <div class="cell">
                <label>국가명<i class="fa-solid fa-asterisk red"></i></label>
                <input type="text" name="countryName" class="field w-100">
                <div class="success-feedback">올바른 형식의 이름입니다</div>
                <div class="fail-feedback">한글로만 작성 가능합니다</div>
            </div>
            
            <div class="cell">
                <label>수도명<i class="fa-solid fa-asterisk red"></i></label>
                <input type="text" name="countryCapital" class="field w-100">
                <div class="fail-feedback">필수 항목입니다!</div>
            </div>

            <div class="cell">
            <label>인구<i class="fa-solid fa-asterisk red"></i></label>
            <input type="text" inputmode="numeric" name="countryPopulation" 
                class="field w-100" >
            <div class="fail-feedback">0보다 큰 숫자만 가능합니다</div>
            </div>


            <div class="cell mt-50">
                <button type="submit" class="btn btn-positive w-100">등록하기</button>
            </div>     
        </div>
    </form>
  
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
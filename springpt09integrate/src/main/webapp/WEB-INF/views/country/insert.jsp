<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <h1>국가정보 등록 페이지</h1>
    
<!-- 절대경로    /country/insert2 -->
<!--   <form action="./insert"> -->
<!--   <form action="./insert" method="get"> get-->
<!--   <form method="post"> 주소가 같기 때문에 안써도 무방-->
 <form action="./insert" method="post" enctype="multipart/form-data">
  대륙* <input type="text" name="countryRegion"> <br><br>
  이름* <input type="text" name="countryName"> <br><br>
  수도* <input type="text" name="countryCapital"> <br><br>
  인구* <input type="text" name="countryPopulation"> <br><br>
  국기 <input type="file" name="attach" accept=".png , .jpg"> <br><br> 
  <button>등록하기</button>
  </form> 
  
  <jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
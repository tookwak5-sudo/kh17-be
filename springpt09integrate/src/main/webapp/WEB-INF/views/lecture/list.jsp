<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<div class="container w-900">
		<!-- 제목 -->
		<div class="cell center">
		<h1>강좌 목록 조회</h1>
		</div>
		
		<div class="cell">
			<!-- 결과출력 -->
			<h2>결과 수 : ${pageVo.beginRownum} ~ ${pageVo.endRownum}  / 총 ${pageVo.count}개</h2>
		</div>
		
		<div class="cell right">
			<div class="flex-area">
				<div>
					<!-- 검색창 -->
					<form action="./list" method="Get">
						<select name="column" class="field">
							<option value="lecture_title" ${param.column == "lecture_title" ? "selected" : ""}>강좌명</option>
							<option value="lecture_category" ${param.column == 'lecture_category' ? 'selected' : ''}>카테고리</option>
							<option value="lecture_type" ${param.column == "lecture_type" ? "selected" : ""}>강좌유형</option>
						</select>
					<input type = "text" name="keyword" placeholder="검색어 입력"
						   value="${param.keyword}" class="field" required>
						<button class="btn btn-positive">검색</button>
					</form>
				</div>	
				<!-- 등록링크 -->
				<div class="flex-fill right">
					<a href="./insert" class="btn btn-netural">
						<i class="fa-solid fa-plus"></i>
						<span>신규 등록</span>
					</a>
				</div>
			</div>	
			<!-- 테이블 -->
			<div class="cell center">
				<table class="table"> <thead>
					<tr>
						<th>강의번호</th>	
						<th width="20%">강의명</th>
						<th>카테고리</th>	
						<th>강의시간	</th>
						<th>수강료</th>
						<th>강의유형</th>
					</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="lectureDto" items="${list}">
					<tr>
						<style>
							td {color: green}
						</style>
						<td>${lectureDto.lectureNo}</td>				
						<td class="left">
							<a href="./detail?lectureNo=${lectureDto.lectureNo}">
								${lectureDto.lectureTitle}
							</a>	
						</td>
						<td>
							<!-- 카테고리를 클릭하면 해당 카테고리의 강좌만 보이게 -->
							<a href="./list?column=lecture_category&keyword=${lectureDto.lectureCategory}">
								${lectureDto.lectureCategory}
							</a>
						</td>
						<td class="right">${lectureDto.lectureDuration}</td>
						<td class="right">
						<fmt:formatNumber 
							value="${lectureDto.lecturePrice}" 
							pattern="#,##0"></fmt:formatNumber>원
						</td>
						<td>${lectureDto.lectureType}</td>
					</tr>
					</c:forEach>
						</tbody>
				</table>
			</div>	
	</div>
<jsp:include page="/WEB-INF/views/template/pagenation.jsp"></jsp:include>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
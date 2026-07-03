<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<div class="container w-1200 mt-50 mb-50">
	    <div class="cell center mb-0">
	        <h1 class="mb-0">자유 게시판</h1>
	    </div>
	    <div class="cell center mt-0">
	        타인에 대한 무분별한 비방은 예고 없이 삭제될 수 있습니다
	    </div>
	    <hr>
	    <div class="cell left mb-0">
	        <c:if test="${sessionScope.loginId != null}">
			<a href="./writer" class="btn btn-positive">글쓰기</a>
			</c:if>
	   </div>
	   <div class="cell right mt-0">
	      <!-- 게시글 목록 -->
			<span>${pageVo.beginRownum}-${pageVo.endRownum} / 총 ${pageVo.count}개의 글</span>
	   </div>
	   <div class="cell">
	       <table class="table">
	  		 <thead>
	               <tr>
	                   <th>번호</th>
	                   <th class="w-40">제목</th>
	                   <th>작성자</th>
	                   <th>작성일</th>
	                   <th>조회수</th>
	                   <th>좋아요</th>
	               </tr>
	  		</thead>
	   <tbody>
			<!-- 일반 게시물 -->
			<!--  varStatus를 쓰면 반복문의 상태를 알 수 있다(index, count, first, last) -->
			<c:forEach var="boardDto" items="${list}" varStatus="stat">
			<%-- 		<tr bgcolor="${boardDto.boardHead == '공지' ? '#33d9b2' : ''}"> --%><!-- head가 공지인 것만 -->
			<tr bgcolor="${stat.index < noticeCount ? '#33d9b2' : ''}">
			<tr bgcolor="${stat.count <= noticeCount ? '#33d9b2' : ''}">
			<td>${boardDto.boardNo}</td>
			<td align="left">
			<%-- 				${stat.first}처음인지 아닌지를 감지 ${stat.last}마지막인지 아닌지를 감지 --%>
			<!-- 답변글인 경우 차수만큼 간격을 벌리고 추가 표시 -->
			<c:if test="${boardDto.boardDepth > 0}">
				<c:forEach var="i" begin="1" end="${boardDto.boardDepth}" step="1">
					&nbsp;&nbsp;&nbsp;&nbsp;
				</c:forEach>
				→
			</c:if>
	
			<!-- 말머리가 있으면 표시 -->
			<c:if test="${boardDto.boardHead != null}">
			(${boardDto.boardHead})
			</c:if>
			<!-- 게시글 제목 -->
			<a href="./detail?boardNo=${boardDto.boardNo}" >
			${boardDto.boardTitle} 
			</a>
			
			<!-- 댓글 개수도 있으면(>0) 표시 -->
			<c:if test="${boardDto.boardReplycount >0}">
			[${boardDto.boardReplycount}]
			</c:if>
			</td>
				
			<td>
				<c:if test="${boardDto.boardWriter == null}">
				(탈퇴한 사용자)
			</c:if>
			<c:if test="${boardDto.boardWriter != null}">
				<a href="../member/detail?memberId=${boardDto.boardWriter}">
				${boardDto.boardWriter}
				</a>
			</c:if>
			</td>
			<td>${boardDto.boardWtimeString}</td>
			<td>${boardDto.boardReadcount}</td>
			<td>${boardDto.boardLikecount}</td>
			</tr>	
	</c:forEach>
	</tbody>
	                
        </tbody>
    </table>
</div>

 <div class="cell">    
<!-- 페이지네이션 -->
<jsp:include page="/WEB-INF/views/template/pagenation.jsp"></jsp:include>
</div>
	<!-- 검색창 -->
        <div class="cell center">
            <form autocomplete="off">
                <select name="column" class="field">
                    <option value="board_title">제목</option>
                    <option value="board_writer">작성자</option>
                </select>
                <input type="text" name="keyword" required
                    class="field" placeholder="검색어 입력">
                <button type="submit" class="btn btn-positive">
                    <i class="fa-solid fa-magnifying-glass"></i>
                    <span>검색</span>
                </button>
            </form>
        </div>
</div>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>

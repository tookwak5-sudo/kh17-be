<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<!-- 좋아요 처리 관련 자바스크립트 (비회원도 가능) -->
<script type="text/javascript">
	//header.jsp에 jQuery CDN이 있기 때문에 그냥 사용 가능
	$(function(){
		//시작하자마자 서버에 물어봐서 좋아요 상태와 좋아요 개수를 알아낸다
		
		//주소창에 있는 파라미터 중 boardNo를 꺼내는 코드
		var params = new URLSearchParams(window.location.search);
		var boardNo = params.get("boardNo");
		
		$.ajax({
			url: "/rest/board/like-check",
			method: "post",
			data: { boardNo : boardNo },
			success: function(response){
				//response에 action, count가 있을 것으로 기대
				//- action은 좋아요 여부, count는 좋아요 개수
				$(".fa-heart").removeClass("fa-regular fa-solid")
					.addClass(response.action ? "fa-solid" : "fa-regular");
				$(".fa-heart").next(".heart-count").text(response.count);
			}
		});
	});
</script>

<!-- el로 처리  -->
<c:if test="${sessionScope.loginId !=null}">
<!-- 좋아요 토글 자바스크립트(회원만 가능)  -->
<script type="text/javascript">
	$(function(){
		//주소창에 있는 파라미터 중 boardNo를 꺼내는 코드
		var params = new URLSearchParams(window.location.search);
		var boardNo = params.get("boardNo");
		
		//하트를 클릭하면 좋아요 토글이 발생하도록 처리
		$(".fa-heart").on("click", function(){
			$.ajax({
				url: "/rest/board/like-action",
				method: "post",
				data : {boardNo : boardNo},
				success: function(response) { // ◀ 세미콜론 지우고 중괄호({) 시작
					$(".fa-heart").removeClass("fa-regular fa-solid")
						.addClass(response.action ? "fa-solid" : "fa-regular");
					$(".fa-heart").next(".heart-count").text(response.count);
				}
			});
		});
	});
</script>
</c:if>

<!-- 댓글 시스템 작성을 위한 자바스크립트 -->
 <script type="text/javascript">
	$(function(){
        var params = new URLSearchParams(window.location.search);
        var boardNo = params.get("boardNo");

		$(".btn-reply").on("click", function(){
            var replyContent = $(".field-reply").val();
            if(replyContent.length == 0) return; //입력값이 없으면 차단처리

			$.ajax({
				url: "/rest/reply/write",		
				method: "post",
				data: {
					replyContent : replyContent,
                    replyOrigin : boardNo
				},
                success: function(){
                    console.log("등록완료");
                    $(".field-reply").val(""); //입력값 삭제
                }
			});
		});
	});
</script>

<div class="container w-950 mt-50 mb-50">
	<div class="cell">
		<div class="flex-area" style="align-items:end">
			<div>
				<h1 class="mt-0 mb-0">
					<!-- 말머리가 있으면 표시 -->
					<c:if test="${boardDto.boardHead != null}">
					(${boardDto.boardHead})
					</c:if>
					<!-- 제목 -->
					${boardDto.boardTitle}
					<!-- 수정되었다면 추가 표시 -->
					<c:if test="${boardDto.boardEtime != null}">
					(수정됨)
					</c:if>	
				</h1>
			</div>
			<div class="ms-40">
				<!-- 목록과 동일하게 사용자 아이디 출력 -->
				<c:if test="${boardDto.boardWriter == null}">
					(탈퇴한사용자)
				</c:if>
				<c:if test="${boardDto.boardWriter != null}">
					<!-- 누르면 이동하도록 링크 구현 -->
					<a href="/member/detail?memberId=${boardDto.boardWriter}" class="link">
						${boardDto.boardWriter}
					</a>
				</c:if>
			</div>
		</div>
	</div>

	<div class="cell mt-20 flex-area">
		<div><fmt:formatDate value="${boardDto.boardWtime}" pattern="yyyy-MM-dd HH:mm"></fmt:formatDate></div>
		<div class="ms-20">조회수 ${boardDto.boardReadcount}</div>
	</div>

	<hr>
	<div class="cell" style="min-height:300px">
		<!-- 있는 그대로의 출력을 수행하는 태그(엔터, 스페이스 등을 인정) -->
		<pre>${boardDto.boardContent}</pre>
	</div>

	<div class="cell mt-20 flex-area">
		<!-- 
			좋아요 처리 시나리오
			1. 이 페이지가 최초로 로딩되었을 때, 현재 사용자가 이 글에 좋아요를 누른적이 있는지 + 현재 좋아요 개수 불러옴
			 → 하트를 채울지 비울지 결정, 하트 옆에 적어야될 숫자를 표시
			 → 비회원도 가능한 기능
			2. 하트를 클릭하면 글번호를 알려주면서 좋아요/해제 처리를 요청
			 → 서버에서 결과적으로 좋아요/해제 중 어떤것이 처리되었는지와 현재 좋아요 개수를 알려줌
			 → 회원만 가능한 기능
		-->
		<div>
		
			좋아요 
			<i class="fa-solid fa-heart red"></i>
			<span class="heart-count">0</span>
		</div>
		<div class="ms-20">댓글 ${boardDto.boardReplycount}</div>
	</div>
	
	<hr>
	
	<!-- 댓글관련 정보가 표시될 자리 -->
	<div class="cell">댓글 목록이 표시될 자리</div>
	
	<c:if test="${sessionScope.loginId != null}">
	<div class="cell">
		<textarea class="field w-100 field-reply" placeholder="댓글 내용 작성"></textarea>
		<button type="button" class="btn btn-positive w-100 mt-10 btn-reply">
			<i class="fa-solid fa-pen"></i>
		</button>
	</div>
	</c:if>
	<c:if test="${sessionScope.loginId == null}">
	<div class="cell">
		<h3>댓글 작성을 원하시면 <a href="/member/login">로그인</a>하세요</h3>
	</div>
	</c:if>
	
	<!-- form은 전송태그인데 딱히 보낼 정보가 없기 때문에 form 작성할 필요? 없다 -->
	<%-- <form action="/rest/reply/write" method="post" autocomplete="off" class="form-check"> 
		<input type="hidden" name="replyOrigin" value="${boardDto.boardNo}">
		
		<div class="cell center">
			<textarea name="replyContent" rows="5" style="width: 100%; font-size: 16px"></textarea>
		</div>
		<button type="submit" class="btn btn-positive w-10 left">등록하기</button>
	</form> --%>
	
	<!-- 목록 -->
		<div class="container w-600 mt-50 mb-50">
		<c:forEach var="replyDto" items="${list}">
			<div class="cell">
				<div class="flex-area flex-vertical">
					<div class="outer">
						<div class="inner">
							<div class="flex-area">
								<div class="image-area flex-area flex-center">
									<div class="center">
										<img src="http://dummyimage.com/80" width="100%" height="100%" class="image-circle">
									</div>
								</div>
		
		                        <div class="content -area flex-fill">
		                            <div class="writer">
		                                작성자누구누구
		                            </div>
		                            <div class="detail mt-20">
		                                <span>댓글내용</span>
		                            </div>
		
		                            <div class="mt-10">
		                                <span>작성일/수정일</span>
		                            </div>
		                        </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</c:forEach>
		</div>
	<hr>

	<!-- 이전글/다음글 출력 -->
	<div class="cell">
		<span class="badge blue me-20">이전글</span> 
		<a href="./detail?boardNo=${prevBoardDto.boardNo}" class="link">${prevBoardDto.boardTitle}</a>	
	</div>
	<div class="cell">
		<span class="badge blue me-20">다음글</span>
		<a href="./detail?boardNo=${nextBoardDto.boardNo}" class="link">${nextBoardDto.boardTitle}</a>	
	</div>

	<hr>
	<div class="cell right">
		<c:if test="${sessionScope.loginId != null}">
		<a class="btn btn-positive" href="./write">글쓰기</a>
		<a class="btn btn-positive" href="./write?boardParent=${boardDto.boardNo}">답글쓰기</a>
		</c:if>

		<c:if test="${boardDto.boardWriter != null && boardDto.boardWriter == sessionScope.loginId}">
		<a class="btn btn-negative" href="./edit?boardNo=${boardDto.boardNo}">수정</a>
		<a class="btn btn-negative" href="./delete?boardNo=${boardDto.boardNo}">삭제</a>
		</c:if>

		<a class="btn btn-neutral" href="./list">목록으로</a>
	</div>
</div>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
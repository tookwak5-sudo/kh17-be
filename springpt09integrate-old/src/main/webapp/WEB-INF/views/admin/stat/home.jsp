<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
/* 	차트비율 해제를 위한 제한 설정 */
	.flex-area > .container {
		padding: 10px;
	}
	.flex-area > .container > .chart-wrapper {
		/* 기준영역 설정 */
		position: relative; 
		height: 300px;
	}
</style>

 <!-- chartjs CDN 
		항상 필요한 cdn이 아니기 때문에 페이지에 cdn 배치  -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

<!-- 차트를 그리는 함수 -->
<script type="text/javascript">
function createChart(endpoint, selector) {
    //시작하자마자 차트를 만들지 말고 서버에 물어본 뒤, 받은 데이터로 차트 생성
    $.ajax({
      url: "/rest/stat/"+endpoint,
      method: "post",
      success: function (response) { //response에 titles와 values가 담겨있음
        //const ctx = document.querySelector(".custom-chart"); //js 스타일
        const ctx = $(selector)[0]; //jquery 스타일

        //차트 생성 - NEW chart(태그, {옵션});
        new Chart(ctx, {
          //tye은 차트의 유형(bar/line/pie/doughnut)
          type: response.type,
          //data는 차트를 그리기 위한 값의 정보
          data: {
            //labels가 x축에 표시될 이름
            labels: response.titles,
            //datasets은 차트에 그릴 데이터 집합들 (복수계 가능)
            datasets: [
              {
                //label: '국가 수', //범례
                data: response.values,
                borderWidth: 1, //테두리 두께
                backgroundColor: [
                  "rgba(183, 21, 64,0.5)",
                  "rgba(250, 152, 58,0.5)",
                  "rgba(246, 185, 59,0.5)",
                  "rgba(5, 196, 107,0.5)",
                  "rgba(60, 64, 198,0.5)",
                  "rgba(24, 44, 97,0.5)",
                  "rgba(131, 52, 113,0.5)",
                ],
                boarderColor: [
                  "rgba(183, 21, 64,1.0)",
                  "rgba(250, 152, 58,1.0)",
                  "rgba(246, 185, 59,1.0)",
                  "rgba(5, 196, 107,1.0)",
                  "rgba(60, 64, 198,1.0)",
                  "rgba(24, 44, 97,1.0)",
                  "rgba(131, 52, 113,1.0)",
                ],
              }
            ]
          },
          //차트를 표시하기 위한 옵션
          options: {
        	responsive: true,
        	maintainAspectRatio: false,
            scales: {
              y: {
                beginAtZero: true //y축을 무조건 0부터 시작
              }
            },
            plugins: {
              legend: { display: false } // 범례 제거
            },
          }
        });
      }
    });
  }
</script>

<script type="text/javascript">
	$(function(){
		createChart("country-region", ".country-region");
		createChart("lecture-category", ".lecture-category");
		createChart("lecture-type", ".lecture-type");
		createChart("book-genre", ".book-genre");
		createChart("member-level", ".member-level");
		createChart("board-head", ".board-head");
	});
</script>

<div class="container w-950 mt-50 mb-50">
	<div class="cell center">
		<h1>대시보드</h1>
	</div>
	
	<div class="cell flex-area" style="flex-wrap: wrap;">
		<div class="container w-33 mb-30">
			<div class="cell">
				<h3>대륙별 국가 현황</h3>
			</div>
			<div class="cell chart-wrapper">
				<canvas class="country-region"></canvas>
			</div>
			<div class="cell right">
				<a href="#" class="link">
					<span>데이터 더 보기</span>
					<i class="fa-solid fa-arrow-right fa-fade"></i>
				</a>
			</div>
		</div>
		<div class="container w-33 mb-30">
			<div class="cell">
				<h3>주제별 강좌 현황</h3>
			</div>
			<div class="cell chart-wrapper">
				<canvas class="lecture-category"></canvas>
			</div>
			<div class="cell right">
				<a href="#" class="link">
					<span>데이터 더 보기</span>
					<i class="fa-solid fa-arrow-right fa-fade"></i>
				</a>
			</div>
		</div>
		
		<div class="container w-33 mb-30">
			<div class="cell">
				<h3>유형별 강좌 현황</h3>
			</div>
			<div class="cell chart-wrapper">
				<canvas class="lecture-type"></canvas>
			</div>
			<div class="cell right">
				<a href="#" class="link">
					<span>데이터 더 보기</span>
					<i class="fa-solid fa-arrow-right fa-fade"></i>
				</a>
			</div>
		</div>
		
		<div class="container w-33 mb-30">
			<div class="cell">
				<h3>장르별 도서 현황</h3>
			</div>
			<div class="cell chart-wrapper">
				<canvas class="book-genre"></canvas>
			</div>
			<div class="cell right">
				<a href="#" class="link">
					<span>데이터 더 보기</span>
					<i class="fa-solid fa-arrow-right fa-fade"></i>
				</a>
			</div>
		</div>
		
		<div class="container w-33 mb-30">
			<div class="cell">
				<h3>등급별 회원 현황</h3>
			</div>
			<div class="cell chart-wrapper">
				<canvas class="member-level"></canvas>
			</div>
			<div class="cell right">
				<a href="#" class="link">
					<span>데이터 더 보기</span>
					<i class="fa-solid fa-arrow-right fa-fade"></i>
				</a>
			</div>
		</div>
		
		<div class="container w-33 mb-30">
			<div class="cell">
				<h3>주제별 게시글 현황</h3>
			</div>
			<div class="cell chart-wrapper">
				<canvas class="board-head"></canvas>
			</div>
			<div class="cell right">
				<a href="#" class="link">
					<span>데이터 더 보기</span>
					<i class="fa-solid fa-arrow-right fa-fade"></i>
				</a>
			</div>
		</div>
	</div>
</div> 

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
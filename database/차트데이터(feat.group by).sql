-- 통계를 위한 그룹 쿼리
-- group by를 이용하여 원하는 집단별 데이터를 조회
-- 그룹 생성 제한조건을 having으로 설정할 수 있다

-- 현재 홈페이지에 존재하는 데이터 : 국가, 강좌, 도서, 회원, 게시글, 댓글 등
-- 국가 : 대륙별 국가 수, 대륙별 인구 합/평균/최대/최소 
-- 강좌 : 카테고리별 강좌 수, 수강료 합/평균/최대/최소, 강의시간 합/평균/최대/최소
-- 도서 : 장르별 도서 수, 판매급액 합/평균/최대/최소
-- 회원 : 등급별 회원 수, 포인트 합/평균/최대/최소
-- 게시글 : 말머리 별/작성자별 글 수, 조회수/좋아요/댓글 수 합/평균/최대/최소

-- 계산을 통해서 만들어내는 그룹
-- 인구 구간별 국가 수, 수강료 구간별 강좌 수, 강의 시간대 별 강좌 수, 연도별 출간된 도서 수
-- 일자별 가입/로그인 회원 수, 일자별 작성된 게시글 수 

--[1] 대륙별 국가 수
select COUNTRY_REGION, count(*), sum(country_population), max(country_population), min(country_population) from country group by COUNTRY_REGION
order by country_region asc;

--[2] 카테고리/유형별 강좌 수, 수강료 합/평균/최대/최소, 강의시간 합/평균/최대/최소
select * from lecture;
select lecture_Category, count(*), sum(lecture_price), 
		avg(lecture_price), max(lecture_price), min(lecture_price),
		max(LECTURE_DURATION)
FROM  lecture group by lecture_category;
select lecture_type, sum(lecture_price), round(avg(lecture_price), 2) from lecture group by lecture_type order by count(*) desc;

--[3] 도서 장르별 도서 수, 판매급액 합/평균/최대/최소
select book_genre, count(*), sum(book_price), round(avg(book_price), 1), MAX(book_price) 최대, min(BOOK_PRICE) 최소  from book group by book_genre;

--[4] 회원 등급별 회원 수, 포인트 합/평균/최대/최소
select member_level, count(*) count from member group by member_level order by count desc;
select * from member;

--[5] 게시글 : 말머리 /작성자 별 글 수,  조회수,/좋아요/댓글/ 합/평균/최대/최소
select board_head, count(*) from board group by board_head;
--[중요] 별칭만 통일 시키면 테이블 상관없이 결과집합이ㅏ동일하다

select country_region title, count(*) count from country group by country_region;
select lecture_category title, count(*) count from lecture group by lecture_category;
select lecture_type title, count(*) from lecture group by lecture_type;
select book_genre title, count(*) count from book group by book_genre;

-- (추가) 연도별 출간된 책 권수
select * from book;
select title, count(*) count from (
	select extract(year from to_timestamp(book_publication_date, 'yyyy-mm-dd')) title
	from book
) group by title order by title asc;


-- (추가) 월별 가입 회원 수
select * from member;
select title from (
	select to_char(member_join, 'yyyy-mm') title
	from member
) group by title order by title desc;

--(추가) 월별 작성된 게시글 수
select * from board;
select title, count(*) count 
from (select to_char(board_wtime, 'yyyy-mm') title from board)
group by title;

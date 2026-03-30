-- 데이터 조회(select)
-- DBMS에서 가장 많이 하는 작업이며 많은 종류의 문법들이 존재
-- 구문 : - select 항목 from 테이블 [조건] [정렬];
-- []대괄호는 없어도 되는 구문을 표시하는 의미

-- 조회할 항목을 설정하는 법

-- [1] 원하는 항목을 골라서 조회할 수 있다
select book_title, book_price from book;

-- [1-1] 전체 조회 
select book.* from book; -- book의 모든항목(*)을 조회(book의 모든항목)
select * from book; -- 이렇게 사용해도된다(모든항목)

--[2] 존재하진 않지만 계산을 통해 값을 만들어서 같이 조회할 수 있다.
select book_title, book_price, book_price/book_page_count from BOOK;

--[3] 조회할 항목의 이름 대신 "별칭"을 사용할 수 있다.
-- 큰따옴표를 쓰면 있으면  별칭에 띄어쓰기를 사용할 수 있고, 없으면 못씀
-- 자바에서는 문자열 내에 큰따옴표 표기가 어려우므로 별칭에 띄어쓰기를 쓰지 않고 큰따옴표를 제거하여 사용	

select book_title "도서명", 
book_price "판매가", 
book_price/book_page_count "페이지 당 가격"
from book;

select book_title 도서명, 
book_price 판매가, 
book_price/book_page_count 페이지당가격
from book;

-- (Q) lecture 테이블에 등록된 강좌들의 모든 정보와 시간 당 요금을 같이 출력

select lecture.*, lecture_price/lecture_duration from lecture;

select lecture.*,
lecture_price/lecture_duration lecture_price_per_price
from lecture;

-- (Q) printservice 테이블에 등록된 모든 서비스 정보와 시간당 요금을 같이 출력

select printservice.*, printservice_unitpricE printservice_unitprice_per_price
from printservice;


-- 조건 
-- - 자바의 if문처럼 조회구문에 where 키워드와 같이 사용해서 데이터를 필터링하는 역할을 수행
-- - 숫자, 문자열, 날짜와 관련된 조건들이 각각 다름

-- [1] 숫자 조건 (비교 연산 : >, <, >=, <=, ==, != 과 논리 연산 : and, or)
-- 번호가 5인 도서를 조회 (찾는 건 다 찾는데, 조건에 맞는 내용만 표시, 즉, 전체 조회와 성능이 동일하다)
select * from book where book_id = 5;  

-- 가격이 2만원 이하인 도서
select * from book where book_price <= 20000;

-- 가격이 1만원대인 도서
select * from book where book_price between 10000  and 19999; 
select * from book where book_price >= 10000 and book_price < 20000;
select * from book where book_price >= 10000 and book_price <= 19999;

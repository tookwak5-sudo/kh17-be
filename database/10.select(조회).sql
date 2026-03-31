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


-- [2] 문자열 조건 (Java String처럼 일치, 유사 검사들이 핵심, 크기 비교는 잘 안함)
-- where은 하나만 쓰고 조건이 여러개면 and나 or로 연장
-- 제목이 "어린왕자"인 도서를 조회 //(정확하게 일치하는 문자열 탐색)  
select * from book where BOOK_TITLE = '어린왕자'; 

-- "열린책들" 출판사에서 출판한 도서를 조회 (정확하게 일치하는 문자열 탐색)
select * from book where book_publisher = '열린책들';

-- "마법사"가 제목에 포함된 도서를 조회 -> 배울 방법은 총3가지
-- 패턴을 지정한 검색(%는 글자의 존재 가능성이 있다는 의미, 자바의 contains와 유사)
select * from book where book_title like '%마법사%';
-- 존재 위치가 어디인지 찾는 검색 (자바의 indexOf와 유사, 오라클은 1부터 시작하며 없으면 0);
select * from book where instr(book_title, '마법사') > 0; -- 즉, 0보다 크다는 마법사란 단어가 존재
-- 정규표현식 -- 패턴이 복잡할 때 사용, 매우 복잡한 걸 찾을 수 있다 대신 그만큼 느림 
select * from book where REGEXP_LIKE(book_title, '마법사');

-- "해리포터" 시리즈 조회 (접두사를 찾을 때 - like '%')
select * from book where book_title like '%해리포터%';
select * from book where instr(book_title,'해리포터') = 1;

-- 결론 
-- 정규표현식은 매우 복잡한 패턴을 찾을 수 있지만 성능이 많이 안좋다.
-- like연산은 전반적으로 성능이 안좋지만 시작검사만틈은 0티어다.
-- instr함수는 전반적으로 성능이 좋지만 상황에 따른 차이가 없다.

-- [3] 날짜 조건
-- book테이블에는 날짜가 없음으로 변환명령을 사용해서 조회 (toTimestamp)


-- 2000년 이후에 출판된 도서 조회
-- 문자열로도 구해지긴 하지만 제한적으로 가능
select * from BOOK where BOOK_PUBLICATION_DATE like '2%';
select * from BOOK where instr(BOOK_PUBLICATION_DATE, '2') = 1; -- 함수자체가 문자를 찾는 것이기 때문에 문자열로 입력하도록 노력하기

-- 2000년 이후에 출판된 도서 조회 (날짜로 바꿔서)
-- extract 함수는 날짜 데이터에서 원하는 함수를 추출할 수 있다
-- select * from book where extract(year from 날짜정보) >= 2000;
select * from book where 
extract(year from to_timestamp(book_publication_date, 'YYYY-MM-DD')) >= 2000;

-- 여름에 출판된 도서를 조회
select * from book where
extract(month from to_timestamp(book_publication_date, 'YYYY-MM-DD')) >= 6
and extract(month from to_timestamp(book_publication_date, 'YYYY-MM-DD')) <= 9

select * from book where
extract(month from to_timestamp(book_publication_date, 'YYYY-MM-DD')) between 6 and 9;

select * from book where
extract(month from to_timestamp(book_publication_date, 'YYYY-MM-DD')) in (6, 7, 8);


-- 2001년 부터 2006년 상반기(6/30)까지 출판된 도서를 조회 // extract만으로는 한계가 있다

--select * from book 
--where 날짜로바꾼출판일 between 2001년1월1일0시0분0초 and 2006년6월30일23시59분59.999초;

-- 범용성이 높기 때문에 이 구문을 쓰는 걸 추천(문자열 -> 날짜)
select * from book
where to_timestamp(book_publication_date, 'YYYY-MM-DD')
	BETWEEN 
		to_timestamp('2001-01-01 00:00:00.000', 'YYYY-MM-DD HH24:MI:SS.FF3')
		and 
		to_timestamp('2006-06-30 23:59:59.999', 'YYYY-MM-DD HH24:MI:SS.FF3');
 -- 날짜는 사용자가 입력하지만 시간 같은 경우는 개발자가 입력해놔야 한다. 
 -- 특히, 주시간 설정을 안해놓을 경우 00:00:00초로 설정되기 때문에 마지막 날이 누락되는 경우가 생길 수 있다
-- (Q) 최근 90일 사이에 출판된 도서 조회
select * from book
where to_timestamp(book_publication_date, 'YYYY-MM-DD')
	between systimestamp - interval '90' day and systimestamp;
	
-- (Q) 최근 10년간 출판된 도서 조회
select * from book
where to_timestamp(book_publication_date, 'YYYY-MM-DD')
	between systimestamp - interval '10' year and systimestamp;

-- (Q) 최근 7년 10개월간 출판된 도서 조회
select * from book
where to_timestamp(book_publication_date, 'YYYY-MM-DD')
	between systimestamp - interval '8-2' year to month and systimestamp;
	

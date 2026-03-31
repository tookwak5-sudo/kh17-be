drop table item;
create table item(
item_no number primary key,
item_name varchar2(30) not null,
item_type varchar2(15),
item_price number,
item_made timestamp,
item_expire timestamp,
check(item_type in ('과자','아이스크림','주류','사탕','초콜릿'))
);

INSERT INTO item VALUES (1, '스크류바', '아이스크림', 1200, TO_TIMESTAMP('2022-05-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-10-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (2, '마이쮸', '사탕', 900, TO_TIMESTAMP('2022-01-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-01-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (3, '초코파이', '과자', 3000, TO_TIMESTAMP('2022-01-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-01-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (4, '맛동산', '과자', 2200, TO_TIMESTAMP('2022-02-01 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-10-20 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (5, '참이슬', '주류', 1000, TO_TIMESTAMP('2022-01-05 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-04-05 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (6, '처음처럼', '주류', 1000, TO_TIMESTAMP('2022-03-15 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-08-15 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (7, '바나나킥', '과자', 1500, TO_TIMESTAMP('2022-05-03 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2022-06-03 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (8, '빠삐코', '아이스크림', 1000, TO_TIMESTAMP('2023-12-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-06-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (9, '멘토스', '사탕', 1200, TO_TIMESTAMP('2023-03-20 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-12-31 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (10, '오레오', '과자', 2100, TO_TIMESTAMP('2023-06-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-06-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (11, '포카칩', '과자', 1500, TO_TIMESTAMP('2022-05-05 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-05-05 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (12, '칸쵸', '과자', 1000, TO_TIMESTAMP('2022-06-10 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-06-10 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (13, '허니버터칩', '과자', 1700, TO_TIMESTAMP('2022-07-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-07-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (14, '새우깡', '과자', 1200, TO_TIMESTAMP('2022-08-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-08-01 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (15, '칙촉', '과자', 2500, TO_TIMESTAMP('2022-09-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-09-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (16, '가나초콜릿', '초콜릿', 2000, TO_TIMESTAMP('2022-10-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-10-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (17, '빼빼로', '과자', 1500, TO_TIMESTAMP('2022-11-11 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-11-11 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (18, '파이리', '사탕', 1000, TO_TIMESTAMP('2022-12-31 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2023-12-01 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (19, '초코송이', '과자', 1200, TO_TIMESTAMP('2023-01-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-01-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (20, '빈츠', '과자', 1300, TO_TIMESTAMP('2023-02-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-02-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (21, '죠리퐁', '과자', 1400, TO_TIMESTAMP('2023-03-01 08:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-03-01 09:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (22, '오징어집', '과자', 1500, TO_TIMESTAMP('2023-04-01 10:23:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-04-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (23, '누네띠네', '과자', 1200, TO_TIMESTAMP('2023-05-01 08:15:30', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-05-01 09:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (24, '포테토칩', '과자', 1600, TO_TIMESTAMP('2023-06-01 14:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-06-01 16:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (25, '새콤달콤', '사탕', 1000, TO_TIMESTAMP('2023-07-01 09:30:15', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-07-01 10:45:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (26, '카라멜콘', '과자', 1100, TO_TIMESTAMP('2023-08-01 11:00:00', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-08-01 13:30:00', 'YYYY-MM-DD HH24:MI:SS'));
INSERT INTO item VALUES (27, '오징어땅콩', '과자', 1500, TO_TIMESTAMP('2023-09-01 10:15:45', 'YYYY-MM-DD HH24:MI:SS'), TO_TIMESTAMP('2024-09-01 12:00:00', 'YYYY-MM-DD HH24:MI:SS'));


commit;

select * from item;

--등록된 상품의 이름만 조회
-- select item.item_name from item;
select item_name from item order by item_no asc;

--등록된 상품의 이름과 가격을 조회
select item_name, item_price from item order by item_no asc;

--등록된 상품의 모든 정보를 조회
select * from item;
select * from item order by item_no asc;

--등록된 상품의 모든 정보와 유통기간(제조일부터 폐기일 사이의 구간)
select item.*, item_expire - item_made period from item;
select item.*, extract(day from item_expire - item_made) AS period from item;

--가격이 2000원 이상인 상품만 조회 - 항상 정렬을 생각하기
select * from item where item_price >= 2000 order by item_no asc;

--가격이 2000원 이상 3000원 이하인 상품만 조회
select * from item WHERE 
item_price >= 2000 and item_price <= 3000 order by item_price asc;

select * from item WHERE 
item_price between 2000 and 3000;


--25번 상품을 조회
select * from item where item_no = 25; -- 정렬안해도됨 있거나 없거나 있어도 1개 밖에 없기 때문에
--이름이 스크류바인 상품을 조회 == 일치하는 항목
select * from item where item_name = '스크류바' order by item_no asc; 

--이름이 참으로 시작하는 상품을 조회
select * from item where item_name like '참%' order by item_no asc; -- instr과 성능차이가 심하기 때문에 like 사용

--select * from item where instr(item_name, '참') = 1 order by item_no asc; 

--이름에 이가 포함된 상품을 조회 -- 정렬을 언급이 따로 없다면 primary key로 정렬
-- select * from item where item_name like '%이%';
select * from item where instr(item_name, '이') > 0 order by item_no asc; -- instr성능이 좋기 때문에 instr사용


--제조년도가 2022년인 상품을 조회
	-- [1] 연도를 뽑아서 조회
	select * from item where 
	extract(year from item_made) = 2022 order by item_no asc;
	-- [2] 문자로 바꿔서 조회(like)
	select * from item where 
	to_char(item_made, 'YYYY-MM-DD') like '2022%' order by item_no asc;
	-- [3] 문자로 바꿔서 조회(=)
	select * from item where 
	to_char(item_made, 'YYYY') = '2022' order by item_no asc;
	-- [4] 날짜데이터를 가져와 between을 통해 비교
	select * from item where ITEM_MADE BETWEEN 
	to_timestamp('2022-01-01 00:00:00:000', 'YYYY-MM-DD HH24:MI:SS:FF3')
	and
	to_timestamp('2022-12-31 23:59:59:999', 'YYYY-MM-DD HH24:MI:SS:FF3')
	order by item_no asc;
	
--2020년 1월 1일부터 현재까지 제조된 상품을 조회
select * from item where item_made
between to_timestamp('2020-01-01 00:00:00:000', 'YYYY-MM-DD HH24:MI:SS:FF3') 
and systimestamp order by item_no asc;


--2020년 상반기(6월 30일)까지 제조된 상품을 가격이 저렴한 순으로 조회
select * from item where 
item_made <= to_timestamp
('2020-06-30 23:59:59:999', 'YYYY-MM-DD HH24:MI:SS:FF3') order by item_price asc, item_no asc;

--모든 상품을 가격이 낮은 순으로 조회
select * from item
order by item_price asc, item_no asc;

--모든 상품을 최근 제조한 순으로 조회
select * from item
order by item_made desc, item_no asc
;
--가격이 2000원 이상인 상품을 1차 이름순, 2차 제조일순으로 조회
select * from item
where item_price >= 2000 
order by item_name ASC, item_made asc, item_no asc; 

--주류 카테고리의 상품 개수
select * from item;
select count(*) from item where item_type = '주류';
--아이스크림의 평균 가격
select
	count(*) AS 개수,
	sum(item_price) AS 합계,
	sum(item_price) / count(*) AS "평균 계산",
	AVG(item_price) AS 평균
 from item
 where item_type = '아이스크림';

select avg(item_price) from item where item_type = '아이스크림';

--등록된 상품 중 가장 비싼 상품 1개의 이름과 종류, 가격
select * 
from (
	select item_name, item_type, item_price
	from item
	order by item_price desc
)
where rownum = 1;


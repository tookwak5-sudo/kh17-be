-- 날짜 데이터
-- ORACLE의 날짜 데이터는 두 종류가 있다
-- (1) DATE : 비교적 간단한 시간 (과거부터 사용) 초까지
-- (2) TIMESTAMP : 좀 더 자세한 시간 (나중에 추가된 형태) 밀리초까지 데이터에 따라 나노초까지
-- 용도에 맞는 걸 잘 찾아서 써야함
-- 향후 자바와 연동되는 형태도 고려할 필요가 있다
--(1) DATE는 java.sql.Date와 연동되며 LocalDate로 쉽게 변환 가능하다.
--(2) TIMESTAMP는 java.sql.Timestamp와 연동되며 LocalDateTime으로 쉽게 변환 가능하다
-- 그래서 주로 Timestamp 사용

--(예) 상품 테이블(table goods)
drop table goods;
create table goods(
	goods_no number primary key,
	goods_name varchar(60) not null,
	goods_price number not null,
	-- 판매 시작일(goods_begin)과 판매 종료일(goods_end), 등록일(goods_reg)을 지정  //`Day`만 저장할 거면 문자
	goods_begin timestamp,
	goods_end timestamp,
	goods_reg timestamp default systimestamp not null -- sysdate는 현재시각을 의미하는 date 값
);

-- 시퀀스
drop sequence goods_seq;
create sequence goods_seq; 

-- 데이터
-- (상품명)최고급노트북, (판매가) 300만원, 
-- (판매시작일)3월30일 오후 4시, (판매종료일) 4월 2일 낮 12시
insert into goods(
	goods_no, goods_name, goods_price, goods_begin, goods_end
)
values(
	goods_seq.nextval, '최고급 노트북', 3000000, 
	-- 날짜는 문자열을 변환해서 만들어야 한다. 변환 명령은 to_timestamp(문자열 값, 형식)
	-- 자바와 형식 차이가 존재(yyyy-년도, mm-월, dd-일, hh -12시간방식, hh24 -24시간 시간방식, mi - 분, ss -초)
	to_timestamp('2026-03-30 16:00:00', 'YYYY-MM-DD HH24:MI:SS'),
	to_timestamp('2026-04-02 12:00:00', 'YYYY-MM-DD HH24:MI:SS')
);
commit;
select * from goods;


-- 단일행 함수 : 데이터의 구조는 유지하면서 값만 변형시키는 함수 (ex : extract, to_timestamp)
-- 집계 함수 : 테이블을 요약해서 하나의 정보로 만드는 함수 (ex : count, max, min, sum, avg)

-- [합 : sum] 모든 상품의 가격 합계는 얼마인가요? (데이터 개수와 상관없이 대답은 1개만 나옴 "~~원")
select sum(item_price) from item;

-- 다른 데이터와 같이 조회가 가능할까?
-- select item_name, sum(item_price)  from item; 불가능

select * from item;

-- [평균 : avg]
-- 모든 상품의 가격 평균을 구해보자
select avg(item_price) from item;
-- 과자의 가격 평균을 구해보기
select avg(item_price) from item where item_type = '과자';
select sum(item_price), avg(item_price) from ITEM where item_type = '과자';
select sum(item_price) 합계, avg(item_price) 평균 from item where item_type = '과자';


-- [최대, 최소 : max, min]
-- (Q) 가장 비싼 사탕과 가장 저렴한 사탕의 가격을 출력하시오
select max(item_price) 가장비싼사탕, min(item_price) 가장싼사탕 from item
where item_type = '사탕';


-- [개수 : count(*)]
-- (Q) 모든 상품의 개수 
-- select count(item_price) 상품가격의개수 from item;  -- 혹시라도 가격에 null이 있다면 null은 세지 않음
 	select count(item_no) 상품번호의개수 from item; -- primary key는 없을 수 없기 때문에 
 	select count(*) from item; -- 전부 다 null이어도 개수에 합산함 so, 항목을 넣어도 되고 와일드키를 사용해도 무방
-- (Q) 등록된 과자의 개수 -- count는 별칭으로 cnt많이 사용
select count(*) cnt from item where item_type = '과자';


-- [집계함수가 조건에 들어간 경우 처리 방법]
-- 다음 코드는 실행이 안됨(집계함수가 조건에 들어가면 실행횟수가 너무 많아져 성능이 너무 저하돼서 차단됨)
-- select * from item where item_price = max(item_price); 
-- max가 계산을 해야 만들어야 하는데 필터링 조건에 넣어버리면 계속 실행이 되면서 오류가 생김

-- [1] 한번에 처리하지 않고 두 번에 걸쳐서 실행
select max(item_price) from item;
select * from item where item_price = 3000;
-- [2] 두 번의 처리 과정을 한번에 엮어서 실행
-- 조회 구문도 괄호를 이용해서 순서대로 실행시킬 수 있다 (sub query, 서브 쿼리)
select * from item where item_price = (select max(item_price) from item);


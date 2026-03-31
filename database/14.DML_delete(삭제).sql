-- 삭제(delete)
-- 존재하는 데이터를 제거하는 행위
-- 데이터가 변하도록 commit과 rollback이 필요하다
-- 구문 형식 : delete [from] 테이블이름 [조건];
-- 실행이 되도 삭제는 이뤄지지 않았을 수 있다(적용된 결과가 몇 개인지 봐야함)

-- 전부 다 삭제
delete item;
-- delete from item; -- select * from item;하고 헷갈릴 ㅁ여지가 있기 대문에 delete item;사용

-- 1번 상품을 삭제 (가장 많이 쓰이는 형태, 1개만 처리)
delete item where item_no = 1;

-- 과자를 삭제
delete item where item_type = '과자';

-- 되돌리기
select * from item;
rollback;

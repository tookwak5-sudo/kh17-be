select * from member;_history order by member_history_no desc;


-- 하고 싶은 것
-- [1] Top N Qurey (상위 N개만 조회)
-- [2] 기간 검색


-- [1] 최근 로그인 이력을 10개만 조회
-- 전체가 다 나오는 상황
select * from member_history
where member_history_origin = 'testuser1'
order by member_history_time desc, member_history_no desc;

-- 행번호를 추가하여 조회(정렬 전에 번호가 부여되는 문제가 발생)
select rownum, member_history.* from member_history 
where member_history_origin = 'adminuser1' 
order by member_history_time desc, member_history_no desc;

-- 서브쿼리를 쓰는 이유 순서를 원하는 대로 지정하기 위해 - 괄호는 연산자 우선순위를 높힌다
-- 반드시 1번부터 조회를 해야만 조회가 되는 반쪽짜리 구문 (1번이 안생기면 2번은 생길수가 없다)
-- 문제점 : 줄번호를 생성하면서 항목을 생성하면서 조건으로 필터링을 하고 있다
select rownum, TMP.* from (
	select * from member_history
	where member_history_origin = 'adminuser1'
	order by member_history_time desc, member_history_no DESC  
)TMP where rownum >= 10;

-- 최종구문
-- select * from (원하는 데이터를 조회하고 줄번호까지 다 붙인 결과) where 행번호 between 1 and 10;
select * from (
	select rownum RN, TMP.* from (
		select * from member_history
		where member_history_origin = 'adminuser1'
		order by member_history_time desc, member_history_no asc  
	)TMP 
) where RN between 9 and 10;

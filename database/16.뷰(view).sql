--뷰(view) : 
-- 자주 사용할 것 같은 구문을 테이블처럼 쓸 수 있도록 객체로 생성
-- 테이블은 아니지만 테이블 처럼 사용할 수 있음
-- drop view music_chart; -- view에서는 create or replace로 drop creat를 한번에 처리가능
create or replace view music_chart as
SELECT 
	music.*,
	music_play * 2 + music_like * 5 - music_dislike * 10 music_point
from music
order by music_point desc, music_id asc;

select * from music_chart; -- 논리 테이블 (ex.즐겨찾기 느낌)

-- 권한 주는 법 system 우클릭 편기 들어가서 권한 설정주기
-- grant create view to kh17;

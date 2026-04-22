-- Board 테이블을 조회
select * from board_list
-- Board_no를 상위 board_parent를 하위로 하여 연결(상위 항목에 prior 붙여주기)
connect by prior board_no=board_parent
-- 묶여있는 그룹의 대표는 시작지점
start with board_parent is null
-- 출력 중 우선순위를 따져야한다면, board_no가 작은걸 먼저 출력
-- 1차는 그룹이 큰것 부터, 2차는 번호가 작은 것 부터(order siblings by 사용)
order siblings by board_group desc, board_no asc;

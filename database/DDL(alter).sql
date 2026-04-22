-- board 테이블을 개조 (항목추가)
-- 가장 편한 방식은 테이블을 지웠다가 항목을 추가해서 다시 생성하는것
-- 데이터가 이미 있거나 외래기(FK)가 있다면 어려울 수 있음
-- 형식 : alter 종류 이름 옵션
-- 옵션에 add modifier 등이 올 수 있음 
alter table board add (
board_group number,
board_parent references board(board_no) on delete cascade ,  --셀프참조, 삭제를 업데이트 식으로 처리하는 방식으로 답글을 남길 수 있다
board_depth number
);

update board set board_group = board_no, board_depth=0;
alter table board modify (
board_group not null,
board_depth default 0 not null
);

select * from board;

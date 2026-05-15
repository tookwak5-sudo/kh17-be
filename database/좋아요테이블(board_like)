-- 게시글 좋아요 테이블
drop table board_like;
create table board_like(
member_id references member(member_id) on delete cascade not null,
board_no references board(board_no) on delete cascade not null,
primary key(member_id, board_no)
);

select * from board_like;

commit;

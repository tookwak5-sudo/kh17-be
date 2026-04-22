--게시글 목록(내용조회를 하지 않는)용 뷰 생성
create or replace view board_list as
select 
    board_no, board_head, board_title,
    board_writer, board_wtime, board_etime,
    board_readcount, board_likecount, board_replycount,
from board;

-- > 기존 view에 group관련 column 추가 (view는 언제든지 유동적으로 변경이 가능하다)

create or replace view board_list as
select 
    board_no, board_head, board_title,
    board_writer, board_wtime, board_etime,
    board_readcount, board_likecount, board_replycount,
    board_group, board_parent, board_depth
from board;

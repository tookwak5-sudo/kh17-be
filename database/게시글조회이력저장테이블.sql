-- 게시글 조회이력을 저장할 테이블
-- 관계 테이블(relation), 개체간의 관계를 기록하는 용도

-- 회원이 게시글을 조회한다
-- 회원(개체, entity), 게시글(개체, Entity)

-- 단순하게 누가 누구의 글을 읽었는지, 중복읽기 불가만 구현하면 되기 때문에 sequence필요없음
-- 이럴 경우 복합키를 사용하게됨
create table board_read (
member_id references member(member_id) on delete cascade not null,
board_no references board(board_no) on delete cascade not null,
board_read_time timestamp default systimestamp not null, 
primary key(member_id, board_no) -- 복합키 설정
);

select * from board_read;

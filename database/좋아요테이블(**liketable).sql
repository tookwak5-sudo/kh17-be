-- 게시글 좋아요 테이블
drop table board_like;
create table board_like(
member_id references member(member_id) on delete cascade not null,
board_no references board(board_no) on delete cascade not null,
primary key(member_id, board_no)
);

select * from board_like;

commit;


-- 국가 좋아요 테이블
create table country_like(
member_id references member(member_id) on delete cascade not null,
country_no references country(country_no) on delete cascade not null,
primary key(member_id, country_no)
);

-- 멤버 좋아요 테이블
drop table member_like;
create table member_like(
member_id references member(member_id) on delete cascade not null,
member_target references member(member_id) on delete cascade not null,
primary key(member_id, member_target), 
check(member_id != member_target)
);

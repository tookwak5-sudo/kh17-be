--로그인 이력을 저장할 테이블
create table member_history(
member_history_no number primary key,
member_history_time timestamp default systimestamp not null,
member_history_origin references member(member_id) on delete cascade not null,
member_history_address varchar(45) not null,
member_history_agent varchar(512) not null
);
create sequence member_history_seq;

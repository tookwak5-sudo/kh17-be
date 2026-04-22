-- 첨부파일 정보 테이블
create table attach (
attach_no number primary key, --기본키이자 파일명
attach_name varchar(255) not null,
attach_type varchar(255),
attach_size number not null,
check(attach_size >= 0)
);

create sequence attach_seq;

select * from attach;

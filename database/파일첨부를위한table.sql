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

-- 국기 테이블
create table country_flag (
country_no references country(country_no) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(country_no) -- 한 국가는 이미지를 한개밖에 못쓰게 된다
-- primary key(country_no, attach_no) -- 한 국가는 이미지를 한 개밖에 못쓰게 된다(다른 이미지는 됨)
);


-- 책표지 테이블
create table book_cover(
book_id references book(book_id) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(book_id)
);

-- 강좌 이미지 테이블
create table lecture_image(
lecture_no references lecture(lecture_no) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(lecture_no, attach_no)
);

commit;

select * from member;

select * from book_cover;

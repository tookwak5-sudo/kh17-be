
-- 데이터베이스 실습 과제 1번


-- 초기화 스크립트

drop table lecture;
create table lecture(
lecture_no number not null unique,
lecture_title varchar(180byte) not null, 
lecture_category char(6byte) not null, -- 고정된 값은 char
lecture_duration varchar(3byte) not null,
lecture_price number not null,
lecture_type varchar(12byte) not null,

check(LENGTH(lecture_title) between 1 and 60),
check(lecture_category in ('이론', '실습', '시험')),
check(lecture_duration in ('30', '60', '90', '120', '150')),
check(lecture_price >=0 and MOD(lecture_price, 1000) = 0),
check(lecture_type in ('온라인', '오프라인', '혼합'))
);

-- 시퀀스
drop sequence lecture_seq;
create sequence lecture_seq;

insert into lecture(
 lecture_no, lecture_title, lecture_category, 
 lecture_duration, lecture_price, lecture_type
)
values(lecture_seq.nextval, '자바 프로그래밍 기초', '이론', '60', 500000, '온라인');

insert into lecture(
 lecture_no, lecture_title, lecture_category, 
 lecture_duration, lecture_price, lecture_type
)
values(lecture_seq.nextval, '파이썬 프로그래밍 기초', '이론', '90', 1000000, '오프라인');

insert into lecture(
 lecture_no, lecture_title, lecture_category, 
 lecture_duration, lecture_price, lecture_type
)
values(lecture_seq.nextval, '정보처리기사 필기', '시험', '30', 300000, '혼합');

insert into lecture(
 lecture_no, lecture_title, lecture_category, 
 lecture_duration, lecture_price, lecture_type
)
values(lecture_seq.nextval, '빅데이터 분석기사 실기', '시험', '120', 850000, '혼합');

-- 최종저장, 설정을 통해서 auto-commit해제
commit;

select * from lecture;


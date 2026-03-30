--데이터베이스 실습과제 3
drop table person;
create table person(
person_no number not null unique,
person_name varchar(21byte) not null,
person_job varchar(12byte) not null,
person_age number not null,
person_height number not null, -- JAVA에서 설정하면 되기 때문에 굳이 여기서 설정 안해도됨.
person_weight number not null,
check(regexp_like(person_name, '^[가-힣]{2,}$')), -- or ^[가-힣]{2,7}$
check(person_age > 0 and person_height > 0 and person_weight > 0)
);

-- 시퀀스
drop sequence person_seq;
create sequence person_seq;

-- 더미 데이터

insert into person(
	person_no, person_name, person_job, 
	person_age, person_height, person_weight
)
values(person_seq.nextval, '마리오', '학생', 15, 160, 52);

insert into person(
	person_no, person_name, person_job, 
	person_age, person_height, person_weight
)
values(person_seq.nextval, '루이지', '개발자', 22, 180, 75);

insert into person(
	person_no, person_name, person_job, 
	person_age, person_height, person_weight
)
values(person_seq.nextval, '피치공주', '디자이너', 20, 162, 50);

insert into person(
	person_no, person_name, person_job, 
	person_age, person_height, person_weight
)
values(person_seq.nextval, '쿠파', '기획자', 30, 190, 95);

commit;

select * from person;

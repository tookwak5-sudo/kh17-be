-- 회원 삭제 대기 테이블
-- 회원 한 명당 딱 1번만 등록 가능 1대1 관계
create table member_exit(
member_exit_id references member(member_id) on delete cascade,
member_exit_time timestamp default systimestamp not null,
primary key(member_exit_id)
);

-- 뷰 생성 : 회원 ← 삭제대기정보(회원 정보에 삭제 대기정보를 추가해서 조회)
create view member_with_exit as
select member.*, member_exit_time from member 
	left outer join member_exit on member.member_id = member_exit.member_exit_id;

-- 뷰 생성 : 회원 + 삭제대기 정보(즉, 삭제대기중인 회원만 조회)
create view member_wait_exit as
select member.*, member_exit_time from member 
	inner join member_exit on member.member_id = member_exit.member_exit_id;

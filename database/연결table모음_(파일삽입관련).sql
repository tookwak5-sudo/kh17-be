-- 국기 테이블
create table country_flag (
country_no references country(country_no) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(country_no) -- 한 국가는 이미지를 한개밖에 못쓰게 된다
-- primary key(country_no, attach_no) -- 한 국가는 이미지를 한 개밖에 못쓰게 된다(다른 이미지는 됨)
);

commit;

-- 책표지 테이블
create table book_cover(
book_id references book(book_id) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(book_id)
);

-- 강좌 이미지 테이블
create table lecture_image(
lecture_no references lecture(lecture_no) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null, -- 한 번 사용한 이미지는 다시 사용할 수 없을 때 얘를 pk로 만들면된다
primary key(lecture_no, attach_no) -- 같은 이미지랑 같은 번호가 중복될 수 없다
);

-- 프로필 이미지 등록
create table member_profile(
member_id references member(member_id) on delete cascade not null,
attach_no references attach(attach_no) on delete cascade not null,
primary key(member_id)
);
commit;

select * from member;
_profile;
select * from lecture_image;

select * from book_cover;

select * from member_history;

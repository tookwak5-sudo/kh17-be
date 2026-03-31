-- book 테이블 생성 실습

-- 테이블 생성
drop table book;
create table book(
book_id number primary key,
book_title varchar(300) not null,
book_author varchar(90),
book_publication_data char(10), -- 시간 없이 날짜만 있으면 문자열
-- book_price number(*, 0) not null,
book_price number not null,
book_publisher varchar(90 byte),
book_page_count number not null,
book_genre varchar(15 byte) not null,
-- oracle에는 긍정, 부정탐색이 없다
check(regexp_like(book_author, '^[^\!\@\#\$]+$')),
check(book_price >= 0),
-- 만약에 가능하다고 한다면
check(book_price = floor(book_price)),
-- 날짜 검사
check(regexp_like(book_publication_data, '^([0-9]{4})-(0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-9]|3[01])$')),
check(book_page_count > 0),
check(book_genre in ('판타지', '교양', '소설', '역사', '과학', '추리소설', '다큐멘터리'))
);

drop sequence book_seq;
create sequence book_seq;

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '해리포터와 마법사의 돌', 'J.K.롤링', '1997-06-26',
	15000, '문학동네', 320, '판타지'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '어린왕자', '앙투안 드 생텍쥐페리', '1943-04-06',
	12000, '열린책들', 130, '소설'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '삼국지', '나관중', '1522-01-01',
	30000, '민용사', 850, '역사'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '데미안', '헤르만 헤세', '1919-01-01',
	13000, '더클래식', 200, '소설'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '어린이 교양 과학', '박영규', '2019-07-01',
	15000, '사계절출판사', 300, '과학'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '조선왕조실록', '한중록', '1922-05-05',
	45000, '휴머니스트', 500, '역사'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '무궁화 꽃이 피었습니다', '김진명','1933-11-15',
	10000, '예문아카이브', 360, '소설'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '토지', '박경리', '2014-12-01',
	22000, '지식을만드는지식', 700, '소설'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '지적 대화를 위한 넓고 얕은 지식', '채사장', '2014-12-01',
	17000, '한빛비즈', 450, '교양'
);

insert into book(
	book_id, book_title, book_author, book_publication_data, 
	book_price, book_publisher, book_page_count, book_genre
)
values(
	book_seq.nextval, '1984', '조지 오웰', '1949-06-08',
	14000, '열린책들', 280, '소설'
);

commit;

select * from book;


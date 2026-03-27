-- 데이터 등록 실습

-- menu 테이블 아쉬운점 no자동으로 입력 안되나? YN다시..
drop table menu;

create table menu(
menu_no number not null unique,
menu_category varchar(15byte) not null,
menu_name varchar(60byte) not null,
menu_price number(10) not null,
menu_event char(1byte) default 'N' not null,
-- default를 설정하면 미설정시 초기값 지정이 가능, 단 not null보다 앞에 있어야함
check(menu_category in ('음료', '디저트', '한정메뉴', '식사')),
check(menu_price >= 0),
check(menu_event in ('Y', 'N'))
);


-- insert into menu(5개) values (5개)

insert into menu(menu_no, menu_category, menu_name, menu_price, menu_event)
values (1, '음료', '아메리카노', 2500, 'Y');

--insert into menu(menu_no, menu_category, menu_name, menu_price, menu_event)
--values (2, '음료', '고구마라떼', '3000', 'N');

insert into menu(menu_no, menu_category, menu_name, menu_price)
values (2, '음료', '고구마라떼', 3000);

insert into menu(menu_no, menu_category, menu_name, menu_price, menu_event)
values (3, '디저트', '티라미수', 4000, 'Y');

--insert into menu(menu_no, menu_category, menu_name, menu_price, menu_event)
--values (4, '디저트', '마카롱', 2000, 'N');

insert into menu(menu_no, menu_category, menu_name, menu_price)
values (4, '디저트', '마카롱', 2000);

select * from menu;

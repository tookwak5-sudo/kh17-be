-- product 테이블
drop table product;
create table product(
product_no number not null unique,
product_name varchar(60byte) not null,
product_category varchar(12byte) not null,
product_price number not null,
product_stock number not null,
product_discount number(3) default 0 not null,
product_early char(1byte) default 'N' not null,
check(product_category in ('라면', '제과', '잡화', '캠핑', '공구', '이벤트')),
check(product_price >= 0),
check(product_stock >= 0),
--check(product_discount >= 0 and product_discount <= 100),
check(product_discount between 0 and 100),
check(product_early in ('Y', 'N'))
);

-- 데이터 추가
-- insert into product(7개) values(7개)
--insert into product(
--	product_no, product_name, product_category, product_price,
--	product_stock, product_discount, product_early
--)
--values ( 1, '비김면', '라면', 16800, 2, 0, 'Y');

insert into product(
	product_no, product_name, product_category, product_price,
	product_stock, product_early
)
values ( 1, '비김면', '라면', 16800, 2, 'Y');

insert into product(
	product_no, product_name, product_category, product_price,
	product_stock
)
values (2, '크림대빵', '제과', 6500, 2);

insert into product(
	product_no, product_name, product_category, product_price,
	product_stock, product_discount, product_early
)
values (3, '점보도시락', '라면', 8500, 3, 5, 'Y');

insert into product(
	product_no, product_name, product_category, product_price,
	product_stock, product_discount
)
values (4, '공간춘', '라면', 12300, 3, 20);
select * from product;

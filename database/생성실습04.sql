--데이터베이스 실습과제 4

drop table phone;
create table phone(
phone_no number not null unique,
phone_name varchar(60byte) not null,
phone_memory number(3) not null,
phone_telecom varchar(9byte) not null,
phone_price number not null,
phone_contract varchar(2byte) default 0 not null, -- null은 많이 들어가면 좋지 않음
check(phone_memory in (64, 128, 256, 512)),
check(phone_telecom in ('SKT', 'KT', 'LG', '알뜰폰')),
check(phone_price >= 0),
check(phone_contract in (0, 24, 36))
);

--시퀀스
drop sequence phone_seq;
create sequence phone_seq;

insert into phone(
	phone_no, phone_name, phone_memory, 
	phone_telecom, phone_price, phone_contract
)
values(phone_seq.nextval, '갤럭시 S26', 256, 'SKT', 1797400, 24);

insert into phone(
	phone_no, phone_name, phone_memory, 
	phone_telecom, phone_price, phone_contract
)
values(phone_seq.nextval, 'iPhone 17 Pro', 128, 'KT', 1555000, 24);

insert into phone(
	phone_no, phone_name, phone_memory, 
	phone_telecom, phone_price
)
values(phone_seq.nextval, '갤럭시 S26 Ultra', 256, 'LG', 1254000);

insert into phone(
	phone_no, phone_name, phone_memory, 
	phone_telecom, phone_price, phone_contract
)
values(phone_seq.nextval, 'iPhone 17', 256, '알뜰폰', 1200000, 36);

commit;

select * from phone;

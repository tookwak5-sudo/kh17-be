--데이터베이스 실습 과제 2번

drop table printservice;
create table printservice(
printservice_no number not null unique,
printservice_partname varchar(230byte) not null,
printservice_partcategory varchar(9byte) not null,
printservice_makeduration number not null,
printservice_unitprice number(*, -3) not null,
printservice_deliverytype varchar(12byte) default '일반' not null,
check(printservice_partcategory in ('재료', '소모품', '부품', '출력')),
check(printservice_makeduration >= 0),
check(mod(printservice_makeduration, 24) = 0),
check(printservice_unitprice >= 0),
check(printservice_deliverytype in ('일반', '퀵', '방문수령'))
);

-- 시퀀스
drop sequence printservice_seq;
create sequence printservice_seq;

insert into printservice(
	printservice_no, printservice_partname, printservice_partcategory,
	printservice_makeduration, printservice_unitprice
)
values(
	printservice_seq.nextval, '고강도 PLA 필라멘트', '재료',
	24, 25100
);

insert into printservice(
	printservice_no, printservice_partname, printservice_partcategory,
	printservice_makeduration, printservice_unitprice, printservice_deliverytype
)
values(
	printservice_seq.nextval, '노즐 세트', '소모품', '48', 15000, '퀵'
);

insert into printservice(
	printservice_no, printservice_partname, printservice_partcategory,
	printservice_makeduration, printservice_unitprice
)
values(
	printservice_seq.nextval, '출력물 전용 베드', '부품', 72, 45000
);

insert into printservice(
	printservice_no, printservice_partname, printservice_partcategory,
	printservice_makeduration, printservice_unitprice, printservice_deliverytype
)
values(
	printservice_seq.nextval, '맞춤형 출력물 제작', '출력', '120', 100000, '방문수령'
);

commit;
select * from printservice;

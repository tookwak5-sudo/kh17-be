drop table member;
create table member(
member_id varchar(20) primary key,
member_email varchar(100) not null unique,
member_password varchar(16) not null,
member_nickname varchar(30) not null unique,
member_birth char(10),
member_contact char(11),
member_post varchar(6),
member_address1 varchar(450),
member_address2 varchar(300),
member_level varchar(12) default '브론즈' not null,
member_message varchar(300),
member_join timestamp default systimestamp not null,
member_login timestamp,
member_change timestamp,
member_block char(1) default 'N' not null,
member_point number default 0 not null,
check(regexp_like(member_id, '^[a-z][a-z0-9]{4,19}$')),
check(regexp_like(member_email, '^([a-z][a-z0-9]{4,19})@([A-Za-z0-9\-\.]{1,})(\.[a-z]{2,3})$')),
check(regexp_like(member_password, '^[]\[A-Za-z0-9!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]{8,16}$')),
check(regexp_like(member_password, '[A-Z]+')),
check(regexp_like(member_password, '[a-z]+')),
check(regexp_like(member_password, '[0-9]+')),
check(regexp_like(member_password, '[]\[\!\@\#\$\%\^\&\*\(\)\-\_\=\+\{\}''\"\`\~\<\>\.\,\/\?\\\|]+')),
check(regexp_like(member_nickname, '^[가-힣A-Za-z0-9]{1,10}$')),
check(regexp_like(member_birth, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(regexp_like(member_contact, '^010[1-9][0-9]{7}$')),
check(regexp_like(member_post, '^[0-9]{5,6}$')),
--미입력은 NULL이고, null은 검사방법이 다르다 (is null, is not null)
check(
    (member_post is null and member_address1 is null and member_address2 is null) 
    or 
    (member_post is not null and member_address1 is not null and member_address2 is not null) 
),
check(member_level in ('브론즈', '실버', '골드', '플래티넘', '다이아', '마스터')),
check(member_block in ('Y', 'N')),
check(member_point >= 0)
);

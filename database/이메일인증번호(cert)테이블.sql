create table cert(
cert_email varchar2(100) primary key,
cert_number char(6) not null,
cert_time timestamp default systimestamp not null,
check(regexp_like(cert_email, '^([a-z][a-z0-9]{4,19})@([A-Za-z0-9\-\.]{1,})(\.[a-z]{2,3})$')),
check(regexp_like(cert_number, '^[0-9]{6}$'))
);

-- column 추가(인증 확인을 위한)
alter table cert add (cert_yn char(1));
update cert set cert_yn = 'N';
alter table cert modify (cert_yn default 'N' not null);
alter table cert modify (check(cert_yn in ('Y', 'N')));

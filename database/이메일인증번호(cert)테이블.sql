create table cert(
cert_email varchar2(100) primary key,
cert_number char(6) not null,
cert_time timestamp default systimestamp not null,
check(regexp_like(cert_email, '^([a-z][a-z0-9]{4,19})@([A-Za-z0-9\-\.]{1,})(\.[a-z]{2,3})$')),
check(regexp_like(cert_number, '^[0-9]{6}$'))
);

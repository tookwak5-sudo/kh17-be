-- 시퀀스 (sequence)
-- 유일한 번호를 발급해주는 도구(객체)
-- 고유번호를 만들기 위해서 사용하는 경우가 대부분

-- 시퀀스 생성 : 이름은 테이블과 연관된 이름으로 짓는것이 유리함
-- create sequence 이름
create sequence country_seq;

-- 기존에 있는 country 데이터는 삭제(안배운 명령)
delete country;

-- 시퀀스를 사용해서 등록
insert into country(
	country_no, country_region, country_name, 
	country_capital, country_population
)
values(country_seq.nextval, '아시아', '대한민국', '서울', 51700000);

insert into country(
	country_no, country_region, country_name,
	country_capital, country_population
)
values(country_seq.nextval, '유럽', '프랑스', '파리', 68000000);

insert into country(
	country_no, country_region, country_name,
	country_capital, country_population
)
values(country_seq.nextval, '북아메리카', '캐나다', '오타와', 40000000);
-- 시퀀스 삭제
drop sequence country_seq;

select * from country;

--시퀀스의 상태 보기 // 메뉴창에 KH17 -> Sequences -> country_seq들어가도 보임
--CACHE 20  
--빨리 처리하기 위해 20개를 미리 뽑아둠 
--DB전원을 끄고 다시 시작하게 되면 20번까지는 사라지고, 21부터 시작을 함 그냥 두고 하면됨
--반대 NOCACHE or CACHE1 

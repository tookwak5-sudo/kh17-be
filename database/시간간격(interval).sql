--조건에 따른 시간 간격(10분, 30분) 설정 코드
--[1] 방식
delete cert where 
	(cert_yn= 'N' and systimestamp - interval '10' minute > cert_time)
	or
	(cert_yn= 'Y' and systimestamp - interval '30' minute > cert_time);

--[2] 방식
delete cert where 
	(cert_yn= 'N' and systimestamp - cert_time > interval '10' minute) 
	or
	(cert_yn= 'Y' and systimestamp - cert_time > interval '30' minute);

select * from cert;

commit;

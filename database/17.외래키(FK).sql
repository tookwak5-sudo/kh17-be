
-- 퀴즈 테이블
-- 퀴즈에는 문항이 있고 보기와 해설이 존재
-- 퀴즈를 상위테이블로 두고 보기와 해설을 하위테이블로 설계 (정규화 고려 분리 생성)

-- 퀴즈 테이블 : 퀴즈번호, 문제내용
drop table quiz;
create table quiz(
quiz_no number primary key,
quiz_content varchar(300) not NULL 
);

-- 보기 테이블 : 보기번호, 퀴즈번호, 보기내용, 정답여부
drop table choice;
create table choice(
choice_no number primary key,
-- 외래키(Foreign Key)를 만들어서 강하게 연결된 칼럼을 생성
-- 설정만으로도 자동으로 유효성 검사를 수행함(존재하지 않는 문항번호는 절대로 추가할 수 없음)
choice_origin references quiz(quiz_no) on delete cascade not null,
choice_text varchar(300) not null,
choice_answer char(1) not null,
check(choice_answer in('Y', 'N'))
);


-- 데이터 등록 : '자바를 만든 사람은?' (1) 고슬링 (2) 고블린 (3) 그렘린 (4) 고구마
insert into quiz(quiz_no, quiz_content) values(1, '자바를 만든 사람은?');
insert into quiz(quiz_no, quiz_content) values(2, '자바는 객체지향이다?');
insert into quiz(quiz_no, quiz_content) values(3, '테스트 문제');

insert into choice(choice_no, choice_origin, choice_text, choice_answer) values(1, 1, '고슬링', 'Y');
insert into choice(choice_no, choice_origin, choice_text, choice_answer) values(2, 1, '고블린', 'N');
insert into choice(choice_no, choice_origin, choice_text, choice_answer) values(3, 1, '그렘린', 'N');
insert into choice(choice_no, choice_origin, choice_text, choice_answer) values(4, 1, '고구마', 'N');



insert into choice(choice_no, choice_origin, choice_text, choice_answer) values(5, 2, 'O', 'Y');
insert into choice(choice_no, choice_origin, choice_text, choice_answer) values(6, 2, 'X', 'N');


-- 보기가 있는 문항은 지울 수 없다 (외래키 때문이며 옵션을 줘서 해겨 ㄹ가능)
-- on delete set null - 퀴즈를 지웠을 때 보기의 퀴즈번호를 null로 변경
-- on delete cascade - 퀴즈를 지우면 연결된 보기가 자동으로 지워짐
--delete quiz where quiz_no=1;
--delete quiz where quiz_no=2;


-- primary key에 숫자 number설정해도 되지만 references가 저걸 가져와라 형태 그대로 가져오기 때문에 굳이 쓸 필요는 없다
-- 해설 테이블
drop table comments;
create table comments(
comments_no number primary key,
comments_origin references quiz(quiz_no) on delete cascade not null,
comments_body varchar(1000) not null
);

insert into comments(comments_no, comments_origin, comments_body) values(1, 1, '자바의 역사');
insert into comments(comments_no, comments_origin, comments_body) values(2, 1, '자바의 특징');
insert into comments(comments_no, comments_origin, comments_body) values(3, 1, '참고사이트');

commit;


-- 이런 구조를 구현했다면 조회는 어떻게 할 수 있을까?
-- 단순하게 테이블 1개만 조회하는 것이 아니라 원하는 목적에 맞게 합쳐서(Join) 조회할 수 있다
select * from quiz;
select * from choice;
select * from comments order by comments_no;

-- 크로스 조인(cross join) : 카사디안 곱 형태로 두 테이블의 데이터를 합성하여 조회(왕 무식)
select * from quiz, CHOICE;
select * from quiz cross join choice;

-- 내부 조인(inner join) : 내부 조인은 양쪽에 모두 존재하는 경우만 조회
select * from quiz q inner join choice c on q.quiz_no = c.choice_origin;
select * from quiz inner join choice on quiz.quiz_no = choice.choice_origin;

select * from quiz inner join comments on quiz.quiz_no = comments.comments_origin;

-- 외부 조인(outer join) : 한쪽을 조회하면서 다른 데이터들을 결합하여 조회(한쪽은 다 조회)
select * from quiz left outer join choice on quiz.quiz_no = choice.choice_origin;
select * from quiz left outer join comments on quiz.quiz_no = comments.comments_origin;


-- 보기가 있는 문항들을 해설 여부와 관계없이 조회하고 싶다
select * from quiz 
	inner join choice on quiz.quiz_no = choice.choice_origin 
	left outer join comments on quiz.quiz_no = comments.comments_origin
	order by quiz_no asc;

-- 문항별로 정답만 출력 해설은 잇으면 출력
-- 꼭 테이블이 아니라 조회 결과와도 JOIN이 가능하다
-- Join이 무적은 아니다 (성능저하가 발생)
-- select * from choice where choice_answer = 'Y'

select * from quiz
	inner join (select * from choice where CHOICE_ANSWER = 'Y')  ANSWER 
		on quiz.quiz_no = ANSWER.CHOICE_ORIGIN
	left outer join comments on quiz.quiz_no = comments.comments_origin
	order by quiz_no asc;

-- 게시글(board) 테이블 작성

drop table board;
create table board(
board_no number primary key,
board_head char(6),
board_title varchar(300) not null, 
board_content varchar(3000) not null,
board_writer references member(member_id) on delete set null,
board_wtime timestamp default systimestamp not null,
board_etime timestamp,
board_readcount number default 0 not null,
board_likecount number default 0 not null,
board_replycount number default 0 not null,
check(board_head in ('공지', '유머', '자유', '정보')),
check(board_readcount >=0),
check(board_likecount >=0),
check(board_replycount >=0)
);

drop sequence board_seq;
create sequence board_seq;

insert into board values (board_seq.nextval, '공지', '사이트 점검 안내', '금일 밤 12시부터 서버 점검이 진행됩니다.', 'adminuser1', systimestamp, null, 0, 0, 0);
insert into board values (board_seq.nextval, '유머', '웃긴 이야기', '오늘 있었던 재미있는 일을 공유합니다.', 'testuser1', systimestamp, null, 5, 2, 1);
insert into board values (board_seq.nextval, '자유', '오늘 날씨 좋네요', '산책하기 딱 좋은 날씨입니다.', 'testuser1', systimestamp, null, 3, 1, 0);
insert into board values (board_seq.nextval, '정보', '오라클 팁 공유', '조인 성능 개선 방법을 소개합니다.', 'adminuser1', systimestamp, null, 10, 5, 2);
insert into board values (board_seq.nextval, '유머', '고양이 밈', '귀여운 고양이 사진 모음입니다.', 'testuser1', systimestamp, null, 7, 3, 1);
insert into board values (board_seq.nextval, '자유', '주말 계획', '이번 주말 뭐 하시나요?', 'testuser1', systimestamp, null, 2, 0, 0);
insert into board values (board_seq.nextval, '정보', '자바 공부법', '효율적인 자바 학습 방법 공유.', 'adminuser1', systimestamp, null, 8, 4, 1);
insert into board values (board_seq.nextval, '공지', '이벤트 안내', '회원 대상 이벤트를 진행합니다.', 'adminuser1', systimestamp, null, 15, 10, 5);
insert into board values (board_seq.nextval, '자유', '점심 추천', '오늘 뭐 먹을까요?', 'testuser1', systimestamp, null, 4, 1, 0);
insert into board values (board_seq.nextval, '유머', '회사 밈', '직장인 공감 밈 공유합니다.', 'testuser1', systimestamp, null, 6, 2, 1);

insert into board values (board_seq.nextval, '정보', 'SQL 튜닝', '인덱스 활용 방법 정리.', 'adminuser1', systimestamp, null, 9, 3, 2);
insert into board values (board_seq.nextval, '자유', '운동 시작', '헬스 시작했습니다.', 'testuser1', systimestamp, null, 3, 1, 1);
insert into board values (board_seq.nextval, '유머', '아재 개그', '웃긴 아재개그 모음.', 'testuser1', systimestamp, null, 5, 2, 0);
insert into board values (board_seq.nextval, '공지', '서비스 업데이트', '새로운 기능이 추가되었습니다.', 'adminuser1', systimestamp, null, 20, 15, 10);
insert into board values (board_seq.nextval, '정보', '파이썬 추천', '입문자용 파이썬 강의 추천.', 'adminuser1', systimestamp, null, 11, 6, 3);
insert into board values (board_seq.nextval, '자유', '영화 추천', '최근 본 영화 추천합니다.', 'testuser1', systimestamp, null, 4, 2, 1);
insert into board values (board_seq.nextval, '유머', '짤방 공유', '재미있는 짤 올립니다.', 'testuser1', systimestamp, null, 6, 3, 2);
insert into board values (board_seq.nextval, '정보', '리눅스 명령어', '자주 쓰는 명령어 정리.', 'adminuser1', systimestamp, null, 7, 2, 1);
insert into board values (board_seq.nextval, '자유', '취미 생활', '요즘 취미가 뭐세요?', 'testuser1', systimestamp, null, 2, 1, 0);
insert into board values (board_seq.nextval, '공지', '휴무 안내', '공휴일 휴무 공지입니다.', 'adminuser1', systimestamp, null, 12, 5, 2);

select * from board order by board_no desc;

-- 게시글 목록(내용조회를 하지 않는)용 뷰 생성
create or replace view board_list as
select ALL 	
	board_no, board_head, board_title,
	board_writer, board_wtime, board_etime,
	board_readcount, board_likecount, board_replycount
from board;

select * from board_list;

commit;




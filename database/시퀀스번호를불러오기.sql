insert into board(board_no, board_writer, board_head, board_title, board_content)
values(board_seq.nextval, 'testuser1', '정보', '테스트 정보글', '테스트 정보글 내용');

commit;

select * from board order by board_no desc;
-- 내가 지금 실행한 녀석이 가장 위에 글에 있는 번호가 아닐까? 라는 추론은 가능, 지금 내가 쓴 글이 내 글이라고는 장담하자ㅣ 못함
-- 누군가의 검색하는 사이 최신글이 올라올 수도 있기 때문에

--[1] max로도 구현이 가능하지만, 찰나의 순간이라도 동시에 입력되는 경우 둘 다 마지막 번호로 가는 경우가 생김
select max(board_no) from board; 

--[2] dual 내가 무조건 마음대로 쓸 수 있는 dual이라는 임시 테이블이 있음// 대상을 쓰기가 애매할 경우
-- 번호를 DB에서 등록을 해서 문제가 생김, seq는 절대 같은 번호를 다른 데이터에 등록하지 않기 때문에 임시테이블에 seq를 담고 자바로 보내기
select board_seq.nextval from dual;

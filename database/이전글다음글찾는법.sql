-- 이전 글번호를 어떻게 구하죠?
-- 글이 지워지면 어떻게 되고?
-- (ex) 현재 10번글을 보고 있을 때 이 글의 이전 글 번호와 다음 글 번호를 각각 구해보세요!

-- select * from board_list where board_no = (10번보다 작은번호를 가진 글 중에 제일 큰 번호);
select * from board_list where board_no = (
	select max(board_no) from board where board_no < 10
);
-- select * from board_list where board_no = (10번보다 작은번호를 가진 글 중에 제일 작은 번호);
select * from board_list where board_no = (
	select min(board_no) from board where board_no > 10
);

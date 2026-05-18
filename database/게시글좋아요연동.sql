--방법 [1]
-- 게시글 조회
select board.board_no, board.board_head, board.board_title,board.board_writer, 
		board.BOARD_WTIME, board.board_etime, board.board_readcount, board.board_replycount, 
		nvl(BL.board_likecount, 0) board_likecount
from board left outer join 
(select board_no, count(*) board_likecount from board_like group BY  board_no) BL
 on board.board_no = BL.board_no;

-- 그룹(group query)
-- 테이블에 존재하는 데이터를 원하는 항목별로 묶어서 보기 위한 구문
-- 조회할 때 사용하며, group by  + having 절을 사용

-- (ex) music table의 장르별 곡수
select distinct music_genre from music
group by music_genre; 

--방법 [2] 이 방식 사용할 예정
update board 
set board_likecount = (select count(*) from board where board_no = 3033)
where board_no=3033;

select * from board where board_no = 3033;

select * from board;

commit;

--public boolean updateBoardLikecount(int boardNo) {
--		String sql = "update board set board_likecount = ("
--			+ "select count(*) from board_like where board_no = ?"
--			+ ") where board_no = ?";
--	Object[] params = { boardNo, boardNo };
--	return jdbcTemplate.update(sql, params) > 0;
--	}

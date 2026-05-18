--댓글 테이블
drop table reply;
create table reply(
reply_no number primary key,
reply_writer references member(member_id) on delete set null,
reply_origin references board(board_no) on delete cascade not null,
reply_content varchar(1500) not null,
reply_wtime timestamp default systimestamp not null,
reply_etime timestamp
);

create sequence reply_seq;

commit;

select * from reply;

select * from reply where reply_origin= 6030 order by reply_no asc

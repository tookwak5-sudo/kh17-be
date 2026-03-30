-- 정렬(order)
-- 데이터를 원하는 기준에 맞게 재배열하는 것
-- 오름차순 : 작은 데이터부터 큰 데이터까지 점점 커지도록 배치한 것(ascending, 줄여서 asc)
-- 내림차순 : 큰 데이터부터 작은 데이터까지 점점 작아지도록 배치한 것(descending, 줄여서 desc)
-- 현실에서는 오름차순, 내림차순이라는 단어를 잘 안쓴다 
-- 정렬되지 않은 데이터는 가치가 없다 (즉, 목록은 반드시 정렬하여 조회	해야한다)
-- 정렬의 목적 내가 의도한 데이터를 출력하기 위해

-- 정렬은 데이터가 확정된 다음 수행해야 한다 (= 조건과 같은 데이터가 변하는 작업을 먼저 수행해야한다)

-- 모든 도서를 번호(book_id) 순으로 정렬하여 조회
select * from book order by book_id asc;

-- 모든 도서를 이름 순으로 정렬(2차 정렬이 필요, 이름이 같으면?) 
select * from book order by book_title asc, book_id asc;

-- 2만원이 넘는 도서를 최신순으로 출력
--select * from book order by book_publication_date desc where book_price > 20000; -- 안됨 데이터가 변하는 작업을 먼저 수행해줘야함
select * from book where book_price > 20000 order by book_publication_date desc, book_id asc;

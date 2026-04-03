--테이블 생성
drop table music;
create table music(
music_id number primary key,
music_title varchar(300) not null,
music_artist varchar(90),
music_album varchar(150) not null,
music_release char(10),
music_play number,
music_like number,
music_dislike number,
music_genre varchar(30),
check(regexp_like(music_release, '^([0-9]{4})-(((02)-(0[1-9]|1[0-9]|2[0-9]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01])))$')),
check(music_play >= 0),
check(music_like >= 0),
check(music_dislike >= 0),
check(music_genre in ('K-POP', '락', '인디', '발라드', '힙합', '트로트', '재즈', '클래식'))
);

--시퀀스
drop sequence music_seq;
create sequence music_seq;

-- 테스트 데이터 20개 삽입 (다양한 장르 및 수치 구성)

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Hype Boy', 'NewJeans', 'New Jeans', '2022-08-01', 5000, 1200, 15, 'K-POP');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '사건의 지평선', '윤하', 'END THEORY', '2022-03-30', 4500, 980, 5, '락');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '밤양갱', '비비', '밤양갱', '2024-02-13', 3800, 850, 40, '인디');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Dynamite', 'BTS', 'Dynamite', '2020-08-21', 9999, 3500, 20, 'K-POP');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Love Lee', 'AKMU', 'Love Lee', '2023-08-21', 2800, 720, 10, '인디');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '첫 눈처럼 너에게 가겠다', '에일리', '도깨비 OST', '2017-01-07', 6200, 1500, 12, '발라드');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'TOMBOY', '(G)I-DLE', 'I NEVER DIE', '2022-03-14', 4100, 1100, 35, '락');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '아무노래', '지코', 'THINKING Part.2', '2020-01-13', 5500, 1300, 50, '힙합');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '모든 날 모든 순간', '폴킴', '키스 먼저 할까요 OST', '2018-03-20', 7000, 1800, 8, '발라드');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Ditto', 'NewJeans', 'OMG', '2022-12-19', 8500, 2400, 18, 'K-POP');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '안동역에서', '진성', '안동역에서', '2012-09-01', 3200, 450, 5, '트로트');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'G선상의 아리아', '바흐', '클래식 정선', '1990-01-01', 1200, 300, 2, '클래식');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Blue Giant', '재즈 앙상블', 'Jazz Today', '2021-05-10', 950, 280, 4, '재즈');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '사랑은 늘 도망가', '임영웅', '신사와 아가씨 OST', '2021-10-11', 9000, 4200, 10, '트로트');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '쇼미더머니 노래', '다이나믹 듀오', 'SMTM 특선', '2023-11-05', 2100, 600, 80, '힙합');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '사계', '비발디', 'Classic Masterpiece', '1995-10-20', 1500, 400, 1, '클래식');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '어떻게 이별까지 사랑하겠어', 'AKMU', '항해', '2019-09-25', 5800, 1900, 15, '발라드');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Smoke', '다이나믹 듀오', '스트릿 우먼 파이터2', '2023-09-05', 4300, 950, 60, '힙합');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, 'Take Five', '데이브 브루벡', 'Time Out', '1959-12-14', 1100, 350, 3, '재즈');

INSERT INTO music (music_id, music_title, music_artist, music_album, music_release, music_play, music_like, music_dislike, music_genre)
VALUES (music_seq.NEXTVAL, '예뻤어', 'DAY6', 'Every DAY6 February', '2017-02-06', 4900, 1600, 20, '락');

COMMIT;

-- 데이터 확인
SELECT * FROM music;

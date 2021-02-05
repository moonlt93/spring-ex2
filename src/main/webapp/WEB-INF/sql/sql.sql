CREATE SEQUENCE seq_board;

DROP TABLE TBL_BOARD;

CREATE TABLE tbl_board (
    rno NUMBER(10,0),
    bno NUMBER(10, 0),
    title VARCHAR2(200) NOT NULL,
    content VARCHAR2(2000) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    updatedate DATE DEFAULT SYSDATE
    );

ALTER TABLE tbl_board ADD CONSTRAINT pk_board
PRIMARY KEY (bno);

INSERT INTO tbl_board (bno, title, content, writer)
VALUES (seq_board.nextval, '테스트 제목', '테스트 내용', 'user00');

CREATE SEQUENCE seq_comment;

CREATE TABLE tbl_comment (
    cno NUMBER(10, 0), -- 댓글 primary key
    bno NUMBER(10, 0) NOT NULL, -- 게시물 번호
    content VARCHAR2(500) NOT NULL,
    writer VARCHAR2(50) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    PRIMARY KEY(cno)
);


ALTER TABLE tbl_comment ADD updatedate DATE DEFAULT SYSDATE;


INSERT INTO tbl_comment (cno, bno, content, writer)
VALUES (seq_comment.nextval, 1, 'first comment', 'newbie');

select * from tbl_board;

COMMIT;



SELECT * FROM tbl_comment;



SELECT
 bno, title, content,
 writer, regdate, updatedate
FROM
 (
  SELECT 
   ROW_NUMBER() OVER (ORDER BY bno DESC) rn,
   bno, title, content, writer,
   regdate, updatedate
  FROM
   tbl_board
 )
WHERE
 rn BETWEEN 6 AND 10;

-- 1page, 10
-- between 1 and 10
--        (page -1) * amount + 1              page * amount

-- 2page, 10
-- between 11 and 20

-- 3page, 10
-- between 21 and 30


SELECT * FROM tbl_board ORDER BY bno DESC;

create table tbl_reply(
rno number(10,0),
bno number(10,0) not null,
reply varchar2(1000) not null,
replyer varchar2(50) not null,
replyDate date default sysdate,
updateDate date default sysdate
);

Create sequence seq_reply;

alter table tbl_reply add constraint pk_reply primary key (rno);
alter table tbl_reply add constraint fk_reply_board foreign key (bno) references
tbl_board (bno);

select * from tbl_REPLY;
select * from tbl_board;

select * from tbl_reply ORDER BY RNO DESC;
 

SELECT COUNT(*) FROM tbl_reply;









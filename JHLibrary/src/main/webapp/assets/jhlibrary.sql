CREATE TABLE T_BOOK (
       B_NO          NUMBER PRIMARY KEY,
       ISBN          VARCHAR2(13) NOT NULL,
       TITLE         VARCHAR2(255) NOT NULL,
       AUTHOR        VARCHAR2(100),
       PUBDATE       VARCHAR2(12),
       REGDATE       VARCHAR2(12) DEFAULT TO_CHAR(SYSDATE, 'YYYY-MM-DD'),
       COVER         VARCHAR2(255),
       CATEGORY_NAME VARCHAR2(255),
       PUBLISHER     VARCHAR2(100),
       ITEMPAGE      NUMBER,
       DESCRIPTION   VARCHAR2(4000),
       B_STATUS      VARCHAR2(20) DEFAULT '가능',
       R_COUNT       NUMBER DEFAULT 0
);

ALTER TABLE T_BOOK MODIFY
       REGDATE VARCHAR2(12) DEFAULT TO_CHAR(SYSDATE, 'YYYY-MM-DD');

UPDATE T_BOOK
   SET
       REGDATE = TO_CHAR(SYSDATE, 'YYYY-MM-DD');

INSERT INTO T_BOOK (
       B_NO,
       ISBN,
       TITLE,
       AUTHOR,
       PUBDATE,
       COVER,
       CATEGORY_NAME,
       PUBLISHER,
       ITEMPAGE,
       DESCRIPTION
) VALUES (
       SEQ_T_BOOK_NO.NEXTVAL,
       ?,
       ?,
       ?,
       ?,
       ?,
       ?,
       ?,
       ?,
       ?
);

CREATE SEQUENCE SEQ_T_BOOK_NO INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

SELECT *
  FROM T_BOOK
 ORDER BY B_NO DESC;

update t_book set b_status = '샘플' where b_no = 6;

SELECT *
  FROM T_USER;

SELECT ISBN,
       TITLE,
       AUTHOR,
       PUBDATE,
       REGDATE,
       COVER,
       CATEGORY_NAME,
       PUBLISHER,
       ITEMPAGE,
       DESCRIPTION,
       SUM(R_COUNT) as r_total,
       COUNT(ISBN) as count,
       sum(case when b_status = '가능' then 1 else 0 end) as ableCount
  FROM T_BOOK
 GROUP BY ISBN,
          TITLE,
          AUTHOR,
          PUBDATE,
          REGDATE,
          COVER,
          CATEGORY_NAME,
          PUBLISHER,
          ITEMPAGE,
          DESCRIPTION
 
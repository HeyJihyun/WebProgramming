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

UPDATE T_BOOK
   SET
       B_STATUS = '분실'
 WHERE B_STATUS = '샘플';

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
       SUM(R_COUNT) AS R_TOTAL,
       COUNT(ISBN)  AS COUNT,
       SUM(
              CASE
                     WHEN B_STATUS = '가능' THEN
                            1
                     ELSE
                            0
              END
       )            AS ABLE_COUNT
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
order by title;

COMMIT;
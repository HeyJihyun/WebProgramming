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

CREATE TABLE T_RENTAL (
       R_NO        NUMBER DEFAULT SEQ_T_RENT_NO.NEXTVAL PRIMARY KEY,
       U_ID        VARCHAR2(255) NOT NULL,
       B_NO        NUMBER NOT NULL,
       RENTAL_DATE DATE DEFAULT SYSDATE,
       RETURN_DATE DATE DEFAULT SYSDATE + 14,
       EXTENSION   NUMBER(1) DEFAULT 1,
       CONSTRAINT FK_U_ID FOREIGN KEY(U_ID) REFERENCES T_USER(ID),
       CONSTRAINT FK_B_NO FOREIGN KEY(B_NO) REFERENCES T_BOOK(B_NO)
);
insert into T_RENTAL(U_ID, b_no) values('aaa', (select min(b_no) from t_book where isbn = '9791197889585' and b_status = '가능'));
update t_book set b_status = '대여중' where b_no = (select min(b_no) from t_book where isbn = '9791197889585' and b_status = '가능');
select * from t_rental;


drop table t_rental;

CREATE SEQUENCE SEQ_T_RENT_NO INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

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
 ORDER BY TITLE;

COMMIT;



SELECT *
  FROM T_USER
 ORDER BY ID;
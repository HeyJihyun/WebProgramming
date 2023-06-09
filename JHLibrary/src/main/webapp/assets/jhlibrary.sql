-- t_book테이블 생성
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

CREATE SEQUENCE SEQ_T_BOOK_NO INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;

-- t_rental 테이블 생성
CREATE TABLE T_RENTAL (
       R_NO        NUMBER DEFAULT SEQ_T_RENT_NO.NEXTVAL PRIMARY KEY,
       U_ID        VARCHAR2(255) NOT NULL,
       B_NO        NUMBER NOT NULL UNIQUE,
       RENTAL_DATE DATE DEFAULT SYSDATE,
       RETURN_DATE DATE DEFAULT SYSDATE + 14,
       EXTENSION   NUMBER(1) DEFAULT 1,
       CONSTRAINT FK_U_ID FOREIGN KEY ( U_ID )
              REFERENCES T_USER ( ID ),
       CONSTRAINT FK_B_NO FOREIGN KEY ( B_NO )
              REFERENCES T_BOOK ( B_NO )
);

CREATE SEQUENCE SEQ_T_RENT_NO INCREMENT BY 1 START WITH 1 NOCYCLE NOCACHE;


-- 도서 대여 쿼리
INSERT INTO T_RENTAL (
       U_ID,
       B_NO
) VALUES (
       'aaa',
       (
              SELECT MIN(B_NO)
                FROM T_BOOK
               WHERE ISBN = '9791197889585'
                 AND B_STATUS = '가능'
       )
);

UPDATE T_BOOK
   SET B_STATUS = '대여중',
       R_COUNT = R_COUNT + 1
 WHERE B_NO = (
       SELECT MIN(B_NO)
         FROM T_BOOK
        WHERE ISBN = '9791197889585'
          AND B_STATUS = '가능'
);

-- 도서대여 쿼리 종료


SELECT *
  FROM T_RENTAL;



-- 도서 등록 쿼리
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

SELECT *
  FROM T_BOOK
 ORDER BY B_NO DESC;

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

SELECT R_NO, R.B_NO, TITLE, AUTHOR, COVER, TO_CHAR(RENTAL_DATE, 'YYYY-MM-DD') AS RENTAL_DATE, TO_CHAR(RETURN_DATE, 'YYYY-MM-DD') AS RETURN_DATE, EXTENSION
  FROM T_BOOK   B, T_RENTAL R
 WHERE B.B_NO = R.B_NO
   AND U_ID = 'aaa';
   
UPDATE T_RENTAL
   SET EXTENSION = 0,
       RETURN_DATE = RETURN_DATE + 7
 WHERE R_NO = 1;
select * from t_rental;
commit;
         

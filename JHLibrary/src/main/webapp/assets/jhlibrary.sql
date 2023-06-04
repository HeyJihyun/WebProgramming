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

alter table t_book modify regdate VARCHAR2(12) default TO_CHAR(SYSDATE, 'YYYY-MM-DD');   
update t_book set regdate = TO_CHAR(SYSDATE, 'YYYY-MM-DD');

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

select * from t_book order by b_no desc;
select * from t_user;

select isbn, title, AUTHOR, pubdate, regdate, cover, category_name, publisher, itempage, description, b_status, sum(r_count), count(isbn), count(b_status) from t_book group by isbn, title, AUTHOR, pubdate, regdate, cover, category_name, publisher, itempage, description, b_status ;
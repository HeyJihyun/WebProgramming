CREATE TABLE TT_MEMBER (
       ID       VARCHAR2(100) PRIMARY KEY,
       PASSWORD VARCHAR2(200) NOT NULL,
       NAME     VARCHAR2(100),
       TYPE     CHAR(1) DEFAULT 'U'
);

INSERT INTO TT_MEMBER VALUES (
       'admin',
       'admin',
       '관리자',
       'S'
);

INSERT INTO TT_MEMBER VALUES (
       'aaa',
       '1234',
       '홍길동',
       'U'
);

SELECT *
  FROM TT_MEMBER;

COMMIT;
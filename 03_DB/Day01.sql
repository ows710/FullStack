/*
> sql plus
사용자명 입력 : system
비밀번호 입력 : 1234

CREATE USER MULTI IDENTIFIED BY Test09061234 
DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- 권한부여
GRANT CONNECT, RESOURCE TO MULTI;
-- GRANT DWROLE TO MULTI;

COMMIT;

> sql plus
사용자명 입력 : MULTI
비밀번호 입력 : MULTI

*/

/*
-- 실행 : CTRL + ENTER
drop user MULTI;

CREATE USER MULTI IDENTIFIED BY Test09061234 
DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

-- 권한부여
GRANT CONNECT, RESOURCE TO MULTI;
-- GRANT DWROLE TO MULTI;

COMMIT;
-- -----------------------------

SELECT * FROM TABS;

CREATE TABLE TEST_1( NAME VARCHAR2(30));

DROP TABLE TEST_1;

SELECT * FROM TEST_1;

INSERT INTO TEST_1 VALUES('LEE');
*/


-- 실행 : 커서를 실행하고자 하는 명령어에 두고 CTRL+ENTER
--		 실행하고자 하는 명령어를 블럭치고 ALT+X ( 여러줄 실행도 가능 )
SELECT * FROM TABS;

-- 한줄 주석
/*여러줄
 * 주
 * 석
 **/

 */

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
DROP TABLE MYTEST;

CREATE TABLE MYTEST(
	MNO NUMBER,
	MNAME VARCHAR2(20),
	NICKNAME VARCHAR2(20)
);

SELECT * FROM MYTEST;

 



DROP TABLE SCORE;
CREATE TABLE SCORE(
	NAME VARCHAR2(20) PRIMARY KEY,
	KOR NUMBER NOT NULL,
	ENG NUMBER NOT NULL,
	MATH NUMBER NOT NULL,
	SUM NUMBER,
	AVG NUMBER,
	GRADE CHAR(2) CHECK(GRADE IN ('A', 'B', 'C', 'D', 'F'))
);

INSERT INTO SCORE VALUES('LEE', 100, 100, 100, 300, 100.0, 'A');
SELECT * FROM SCORE;



-------------------------------

DROP TABLE MYBOARD;

CREATE TABLE MYBOARD(
	MYNO NUMBER PRIMARY KEY,
	MYNAME VARCHAR2(100) NOT NULL,
	MYTITLE VARCHAR2(1000) NOT NULL,
	MYCONTENT VARCHAR2(4000) NOT NULL,
	MYDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_MYBOARD
NOCACHE;

SELECT * FROM MYBOARD;

INSERT INTO MYBOARD
VALUES(SEQ_MYBOARD.NEXTVAL, '관리자', '게시판 테스트', '테스트 중입니다.
1234567ABCD', CURRENT_DATE);

DROP TABLE MVCBOARD;
DROP SEQUENCE SEQ_MVCBOARD;
CREATE TABLE MVCBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(100) NOT NULL,
	TITLE VARCHAR2(1000) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	REGDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_MVCBOARD
NOCACHE;

INSERT INTO MVCBOARD
VALUES(SEQ_MVCBOARD.NEXTVAL, '관리자', '테스트 중', '테스트 1234 ABCD', '20/02/22');

SELECT * FROM MVCBOARD;


------------------------------------------

CREATE TABLE MYMEMBER(
	MYNO NUMBER PRIMARY KEY,
	MYID VARCHAR2(500) NOT NULL UNIQUE,
	MYPW VARCHAR2(500) NOT NULL,
	MYNAME VARCHAR2(300) NOT NULL,
	MYADDR VARCHAR2(4000) NOT NULL,
	MYPHONE VARCHAR2(20) NOT NULL UNIQUE,
	MYEMAIL VARCHAR2(100) NOT NULL UNIQUE,
	MYENABLED VARCHAR2(2) NOT NULL CHECK(MYENABLED IN('Y','N')),
	MYROLE VARCHAR2(50) NOT NULL
);
CREATE SEQUENCE SEQ_MYMEMBER
NOCACHE;

INSERT INTO MYMEMBER
VALUES(SEQ_MYMEMBER.NEXTVAL,'ADMIN','1234','관리자','관리시 관리구 관리동',
'010-1234-5678','ADMIN@MYMEMBER.COM','Y','ADMIN');

SELECT * FROM MYMEMBER;


UPDATE MYMEMBER SET MYROLE='ADMIN' WHERE MYNO=1;

-------------------------
DROP TABLE MYMVCBOARD;

CREATE TABLE MYMVCBOARD(
	SEQ NUMBER PRIMARY KEY,
	WRITER VARCHAR2(200) NOT NULL,
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_MYMVCBOARD
NOCACHE;

INSERT INTO MYMVCBOARD
VALUES(SEQ_MYMVCBOARD.NEXTVAL, '관리자', '테스트 중..', '테스트 중입니다~
1234 ABCD ', '22/02/22');

SELECT * FROM MYMVCBOARD;

---------------------------------
CREATE TABLE ANSWERBOARD(
	BOARDNO NUMBER PRIMARY KEY,
	GROUPNO NUMBER NOT NULL,
	GROUPSQ NUMBER NOT NULL,
	TITLETAB NUMBER NOT NULL,
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WRITER VARCHAR2(1000) NOT NULL,
	REGDATE DATE NOT NULL
);

-- 글 번호(PK)
CREATE SEQUENCE BOARDNOSQ NOCACHE;
-- 그룹 번호(새로운 글 등록할 때)
CREATE SEQUENCE GROUPNOSQ NOCACHE;


SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ;

-- 첫번째 글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL, GROUPNOSQ.NEXTVAL,
1, 0, '첫번째 글', '1번 글입니다.', '유저1', CURRENT_DATE);

-- 두번째 글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL, GROUPNOSQ.NEXTVAL,
1, 0, '두번째 글', '2번 글입니다.', '유저2', CURRENT_DATE);


-- 1번 글에 답변 글 작성
-- 부모와 같은 GROUPNO
-- 부모의 GROUPSQ+1, 부모의 TITLETAB+2
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=1),
	(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=1)+1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=1)+2,
	'RE:첫번째 글', '1번 글에 답글입니다.', '유저2', CURRENT_DATE
);

SELECT * FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSQ;


-- 세번째 글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL, GROUPNOSQ.NEXTVAL,
1, 0, '세번째 글', '3번 글입니다.', '유저3', CURRENT_DATE);


-- 2번 글에 답변글 작성
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2),
	(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2)+1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=2)+2,
	'RE:두번째 글', '2번 글에 답글입니다.', '유저1', CURRENT_DATE
);

-- 답변글 작성(RE:두번째 글, BOARDNO=5)
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=5),
	(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=5)+1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=5)+2,
	'RE:RE:두번째 글', '2번글 답변글에 답변글', '유저1', CURRENT_DATE
);

SELECT * FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSQ;


-- 답변글 작성(두번째 글, BOARDNO=2)
-- 부모와 같은 GROUPNO,
-- 부모의 GROUPSQ+1, 부모의 TITLETAB+2
UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2)
	AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2);

-- 부모와 같은 GROUPNO,
-- 부모의 GROUPSQ+1, 부모의 TITLETAB+2
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=2),
	(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=2)+1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=2)+2,
	'RE:두번째 글에 답변글', '2번글 답변글!!', '유저2', CURRENT_DATE
);

SELECT * FROM ANSWERBOARD
ORDER BY GROUPNO DESC, GROUPSQ;

-- 답변 작성(RE:두번쨰 글, BOARDNO=7)
-- 1. UPDATE
UPDATE ANSWERBOARD SET GROUPSQ = GROUPSQ+1
WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=7)
	AND GROUPSQ>(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=7);
-- 2. INSERT
INSERT INTO ANSWERBOARD
VALUES(BOARDNOSQ.NEXTVAL,
	(SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO=7),
	(SELECT GROUPSQ FROM ANSWERBOARD WHERE BOARDNO=7)+1,
	(SELECT TITLETAB FROM ANSWERBOARD WHERE BOARDNO=7)+2,
	'RE:RE:두번째 글', '2번글 답글에 답글~~~~~', '유저3', CURRENT_DATE
);


----------------------------------
/*str.addr_gu+"/"+str.content_id+"/"+str.content_nm+"/"+
str.new_addr+"/"+str.cradle_count+"/"+str.longitude+"/"+str.latitude+"' */
DROP TABLE BIKE_TB;

CREATE TABLE BIKE_TB(
	ADDR_GU VARCHAR2(4000),
	CONTENT_ID NUMBER PRIMARY KEY,
	CONTENT_NM VARCHAR2(4000),
	NEW_ADDR VARCHAR2(4000),
	CRADLE_COUNT NUMBER,
	LONGITUDE NUMBER,
	LATITUDE NUMBER
);

SELECT * FROM BIKE_TB;
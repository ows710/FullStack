-- view에 데이터 insert, update, delete

CREATE OR REPLACE VIEW V_JOB
AS SELECT * FROM JOB;


SELECT * FROM V_JOB;

-- 뷰를 통한 데이터 추가
INSERT INTO V_JOB VALUES('J8', '인턴');

SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- 뷰를 통한 데이터 수정
UPDATE V_JOB SET JOB_NAME = '알바'
WHERE JOB_CODE = 'J8';

-- 뷰를 통한 데이터 삭제
DELETE FROM V_JOB
WHERE JOB_CODE = 'J8';

-- DML 명령어가 안되는 이유
-- 1. 뷰의 정의되지 않은 컬럼 값을 변경하려는 경우
-- 2. 산술 연산이 포함된 컬럼
-- 3. JOIN을 통한 여러 테이블 정보를 가진 뷰(조회하는 정보 중 PK요소가 한 개만 존재할 경우)
-- 4. 그룹함수, GROUP BY 통한 결과를 가져왔을 경우

CREATE OR REPLACE VIEW V_JOB
AS SELECT JOB_CODE FROM JOB;

SELECT * FROM V_JOB;

-- SQL Error [913] [42000]: ORA-00913: 값의 수가 너무 많습니다
INSERT INTO V_JOB VALUES('J8', '인턴');

-- SQL Error [904] [42000]: ORA-00904: "JOB_NAME": 부적합한 식별자
UPDATE V_JOB
SET JOB_NAME = '인턴'
WHERE JOB_CODE = 'J7';


CREATE OR REPLACE VIEW V_EMP_SAL
AS
SELECT EMP_ID, EMP_NAME, SALARY,
	   (SALARY + SALARY*NVL(BONUS, 0))*12 연봉
FROM EMPLOYEE;

SELECT * FROM V_EMP_SAL;

-- SQL Error [1733] [42000]: ORA-01733: 가상 열은 사용할 수 없습니다
INSERT INTO V_EMP_SAL
VALUES(900, '최창진', 3000000, 40000000);

-- VIEW 생성 시 설정 옵션
-- OR REPLACE : 기존에 있떤 동일한 이름의 뷰가 있을 경우 해당 뷰를 덮어 씌우고,
-- 				없다면 새로 만들겠다.
-- FORCE / NO FORCE : 서브쿼리에 사용된 테이블이 존재하지 않아도 뷰를 강제로 생성할 것인지 설정
-- WITH CHECK / READ ONLY :
--		CHECK : 옵션 설정한 컬럼 값을 바꾸지 못하게 막는 설정
--		READ ONLY : 뷰에 사용된 어떠한 컬럼도 뷰를 통해 변경하지 못하게 막는 설정

-- FORCE : 존재하지 않는 테이블이라도 뷰를 강제로 생성
-- 기본값 : NO FORCE
CREATE OR REPLACE FORCE VIEW V_EMP
AS
SELECT T_CODE, T_NAME
FROM TEST_TABLE;

-- SQL Error [4063] [72000]: ORA-04063: view "MULTI.V_EMP"에 오류가 있습니다
SELECT * FROM V_EMP;


-- WITH READ ONLY : 데이터의 입력, 수정, 삭제 모두 막는 옵션
CREATE OR REPLACE VIEW V_EMP
AS
SELECT * FROM EMPLOYEE
WITH READ ONLY;

SELECT * FROM V_EMP;

-- SQL Error [32575] [99999]: ORA-32575: 뷰를 수정하는데 명시적 열 기본값이 지원되지 않음
INSERT INTO V_EMP
VALUES(600, '최창진', '101010-1234565', 'choi@or.kr', '010-3332-4322', 'D1', 'J7', 'S1', 8000000, 0.1,
	  200, CURRENT_DATE, NULL, DEFAULT);

-- SQL Error [42399] [99999]: ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
DELETE FROM V_EMP
WHERE EMP_ID = '500';



-- 시퀀스 SEQUENCE
-- 규칙에 맞춰 연속적인 숫자를 생성하는 객체
-- 1,2,3,4,5, ...

-- CREATE SEQUENCE 시퀀스명
-- [INCREMENT BY 숫자] : 다음 값에 대한 증감 수치, 생략하면 1씩 증가
-- [START WITH 숫자]   : 시작값, 생략하면 1부터
-- [MAXVALUE 숫자| NOMAXVALUE]	  : 최대값 설정 | 설정하지 않으면 10^27-1
-- [MINVALUE 숫자| NOMINVALUE]	  : 최소값 설정 | -10^26
-- [CYCLE| NOCYCLE]				  : 값의 순환 여부(1~100 .. ~ .. 1~100)
-- [CACHE 바이트 크기|NOCACHE]		  : 값을 미리 구해 놓고 다음 값을 반영할 떄 활용할지 여부


CREATE SEQUENCE SEQ_EMPID
START WITH 300
INCREMENT BY 5
MAXVALUE 330
NOCYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

-- SQL Error [8004] [72000]: ORA-08004: 시퀀스 SEQ_EMPID.NEXTVAL exceeds MAXVALUE은 사례로 될 수 없습니다
-- 330을 넘어가게 되면 최대값을 넘어가게 되므로 에러 발생

SELECT SEQ_EMPID.CURRVAL FROM DUAL;

-- 시퀀스
DROP SEQUENCE SEQ_EMPID;

CREATE SEQUENCE SEQ_EMPID
INCREMENT BY 10
MAXVALUE 100
NOCYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

-- 시퀀스 초기값을 변경하고자 할 경우 삭제 후 재생성
-- SQL Error [2283] [42000]: ORA-02283: 시퀀스 시작 번호는 변경할 수 없습니다.
ALTER SEQUENCE SEQ_EMPID
--START WITH 200
INCREMENT BY 5
MAXVALUE 150
NOCYCLE
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

-- 시퀀스 정보가 들어있는 데이터 사전
SELECT * FROM USER_SEQUENCES;

SELECT * FROM EMPLOYEE;

CREATE SEQUENCE SEQ_EID
START WITH 300
INCREMENT BY 1
MAXVALUE 10000
NOCYCLE
NOCACHE;

SELECT * FROM USER_SEQUENCES;

-- 시퀀스 활용하여 데이터 추가
-- EMPLOYEE에 추가
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '최창진', '121212-2345677', 'choi_cj@or.kr', '01033324442', 'D2', 'J7',
	  'S1', 6000000, 0.1, 200, CURRENT_DATE ,NULL, DEFAULT);
SELECT * FROM EMPLOYEE
WHERE EMP_NAME = '최창진';


-- D9 부서에 J7직급의 사원 4명을
-- 시퀀스 활용하여 추가
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '홍길동', '121212-3345677', 'hong_gd@or.kr', '01033324442', 'D9', 'J7',
	  'S1', 6000000, 0.1, 200, CURRENT_DATE ,NULL, DEFAULT);
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '고길동', '050505-2222333', 'go_gd@or.kr', '01033324443', 'D9', 'J7',
	  'S1', 6000000, 0.1, 200, CURRENT_DATE ,NULL, DEFAULT);
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '강길동', '551230-1234555', 'kang_gd@or.kr', '01033324444', 'D9', 'J7',
	  'S1', 6000000, 0.1, 200, CURRENT_DATE ,NULL, DEFAULT);
INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '최길동', '880808-1233211', 'choi_gd@or.kr', '01033324445', 'D9', 'J7',
	  'S1', 6000000, 0.1, 200, CURRENT_DATE ,NULL, DEFAULT);	 

SELECT * FROM EMPLOYEE;

-- CYCLE : 시퀀스 값이 최소값 혹은 최대값에 도달했을 때 다시 반대의 값부터 시작하는 옵션. 순환.
CREATE SEQUENCE SEQ_CYCLE
START WITH 200
INCREMENT BY 10
MAXVALUE 230
MINVALUE 15
CYCLE
NOCACHE;

SELECT SEQ_CYCLE.NEXTVAL FROM DUAL; -- 200
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL; -- 210
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL; -- 220
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL; -- 230 MAXVALUE
SELECT SEQ_CYCLE.NEXTVAL FROM DUAL; -- 15
-- CYCLE 설정 시 최대값(최소값) 도달 시 다시 최소값(최대값)부터 시작.


-- CACHE / NOCACHE
-- CACHE : 컴퓨터가 다음값에 대한 연산들을 그때그때 수행하지 않고 미리 계싼해 놓는 것.
-- NOCACHE : 그때그때 처리하는 것.


CREATE SEQUENCE SEQ_CACHE
START WITH 100
INCREMENT BY 1
CACHE 20
NOCYCLE;

SELECT SEQ_CACHE.NEXTVAL FROM DUAL;
SELECT * FROM USER_SEQUENCES;

	 
-- INDEX 인덱스 --
-- SQL 명령어 조회 처리속도를 향상시키기 위한 객체
-- 한 테이블의 식별자가 되는 컬럼값에 대해 일정 단위로 계산하여 조회속도 향상

-- 장점
-- 검색속도 향상

-- 단점
-- 1. 인덱스가 존재하는 테이블의 내용이 자주 변경된다면 변경을 할 때마다
--	  인덱스를 매번 계산하여 만들어야 하기에 성능 저하.
-- 2. 인덱스 저장을 위한 별도의 공간 필요
	 
SELECT * FROM USER_IND_COLUMNS;


SELECT ROWID, EMP_ID, EMP_NAME
FROM EMPLOYEE;

-- ROWID : 테이블 생성 및 데이터 추가 시에
--		   오라클에서 부여하는 데이터의 순번.
--		   시스템에서 직접 관리하기 때문에 사용자가 함부로 변경할 수 없다.


-- 인덱스의 종류
-- 1. 고유 인덱스(UNIQUE)
-- 2. 비고유 인덱스(NOUNIQUE)
-- 3. 단일 인덱스(SINGLE)
-- 4. 결합 인덱스(COMPOSITE)
-- 5. 함수기반 인덱스(FUNCTION BASE)


-- 고유인덱스
-- 인덱스 생성 시 고유값을 기준으로 생성하는 인덱스
-- 오라클에서는 PK 제약조건 사용하면 자동으로 생성

-- SQL Error [1408] [72000]: ORA-01408: 열 목록에는 이미 인덱스가 작성되어 있습니다
-- 중복 생성 불가
CREATE UNIQUE INDEX IDX_EMP_NO
ON EMPLOYEE(EMP_NO);

SELECT *
FROM USER_IND_COLUMNS
WHERE TABLE_NAME = 'EMPLOYEE';

-- SQL Error [1452] [72000]: ORA-01452: 중복 키가 있습니다. 유일한 인덱스를 작성할 수 없습니다
CREATE UNIQUE INDEX IDX_DEPT_CODE
ON EMPLOYEE(DEPT_CODE);

-- NON-UNIQUE INDEX
-- 내가 자주 사용하는 컬럼을 인덱스로 구성.

CREATE INDEX IDX_DEPT_CODE
ON EMPLOYEE(DEPT_CODE);


-- 새로고침
ALTER INDEX INX_DEPT_CODE REBUILD;

-- 삭제
DROP INDEX IDX_DEPT_CODE;




-- PL/SQL
-- PROCEDURAL LANGUAGE
-- 정적 SQL명령에서 동적인 SQL을
-- 구현할 수 있게 제공하는 스크립트 언어.
-- 기본 SQL에서 확장된 형태의 오라클 자체 내장된 절차적 언어.
-- 변수, 조건, 반복, 예외처리 등을 지원

-- [기본형식]
-- DECLARE : 선언부
-- BEGIN : 실행부
-- EXCEPTION : 예외처리부
-- END;

-- 프로시저 : PL/SQL 문을 저장해서 사용.

BEGIN
	DBMS_OUTPUT.PUT_LINE('HELLO~');
END;

-- 선언부 : 변수 선언
DECLARE
	vid NUMBER;
BEGIN
	SELECT EMP_ID
	INTO vid
	FROM EMPLOYEE
	WHERE EMP_NAME='선동이';

	DBMS_OUTPUT.PUT_LINE('ID='||vid);
EXCEPTION
	WHEN NO_DATA_FOUND THEN DBMS_OUTPUT.PUT_LINE('NO DATA!!!');
END;
-- INTO vid --> 변수에 조회한 값을 저장
-- 조회한 데이터가 없다면 'NO DATA!!!'출력(예외처리)



DECLARE
	v_empno NUMBER(4);
BEGIN
	v_empno := 1000;
	DBMS_OUTPUT.PUT_LINE(v_empno||'__');
END;

-- 변수에 값 대입
-- 변수명 := 값;


-- 레퍼런스 변수
-- 한 컬럼의 자료형을 사용하여 변수 선언
DECLARE
	EMP_ID EMPLOYEE.EMP_ID%TYPE;
	EMP_NAME EMPLOYEE.EMP_NAME%TYPE;
	SALARY EMPLOYEE.SALARY%TYPE;
BEGIN
	SELECT EMP_ID, EMP_NAME, SALARY
	INTO EMP_ID, EMP_NAME, SALARY
	FROM EMPLOYEE
	WHERE EMP_NAME = '이창진';

	DBMS_OUTPUT.PUT_LINE('EMP_ID:' || EMP_ID);
	DBMS_OUTPUT.PUT_LINE('EMP_NAME:' || EMP_NAME);
	DBMS_OUTPUT.PUT_LINE('SALARY:' || SALARY);
END;

SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME = '이창진';


-- 한 테이블의 모든 컬럼의 자료형을 참조할 때 사용
DECLARE
	myrow EMPLOYEE%ROWTYPE;
BEGIN
	SELECT EMP_ID, EMP_NAME
	INTO myrow.emp_id, myrow.emp_name
	FROM EMPLOYEE
	WHERE EMP_NAME = '선동일';

	DBMS_OUTPUT.PUT_LINE(myrow.emp_id||','||myrow.emp_name);
END;


DECLARE
	myrow EMPLOYEE%ROWTYPE;
BEGIN
	SELECT *
	INTO myrow
	FROM EMPLOYEE
	WHERE EMP_NAME = '선동일';

	DBMS_OUTPUT.PUT_LINE(myrow.emp_id||','||myrow.emp_name||','||myrow.salary);
END;



-- IF 문 --
--1. IF ~ THEN ~ END IF;
BEGIN
	IF
		10>0 THEN DBMS_OUTPUT.PUT_LINE('10이 0보다 큽니다!!');
	END IF;
END;



DECLARE
	myrow EMPLOYEE%ROWTYPE;
BEGIN
	SELECT *
	INTO myrow
	FROM EMPLOYEE
	WHERE EMP_NAME = '유재식';

	DBMS_OUTPUT.PUT_LINE(myrow.emp_id||','||myrow.emp_name||','||myrow.salary);
	
	IF (myrow.job_code = 'J1')
	THEN DBMS_OUTPUT.PUT_LINE('대표님!!!');
	END IF;
END;

-- 2. IF ~ THEN ~ ELSE ~ END IF;
DECLARE
	myrow EMPLOYEE%ROWTYPE;
BEGIN
	SELECT *
	INTO myrow
	FROM EMPLOYEE
	WHERE EMP_NAME = '선동일';

	DBMS_OUTPUT.PUT_LINE(myrow.emp_id||','||myrow.emp_name||','||myrow.salary);
	
	IF (myrow.job_code = 'J1') THEN DBMS_OUTPUT.PUT_LINE('대표님!!!');
	ELSE DBMS_OUTPUT.PUT_LINE('사원...');
	END IF;
END;

-- 3. IF ~ THEN ~ ELSIF ~ ELSE ~ END IF;
/*
 * IF 조건 THEN
 * 		실행 구문;
 * ELSIF 조건 THEN
 * 		실행 구문;
 * ELSIF 조건 THEN
 * 		실행 구문;
 * ELSE
 * 	조건을 다 만족하지 않을 경우 실행 구문;
 * END IF;
 * 
 */
DECLARE
	myrow EMPLOYEE%ROWTYPE;
BEGIN
	SELECT *
	INTO myrow
	FROM EMPLOYEE
	WHERE EMP_NAME = '송종기';

	DBMS_OUTPUT.PUT_LINE(myrow.emp_id||','||myrow.emp_name||','||myrow.salary);
	
	IF (myrow.job_code = 'J1') THEN
		DBMS_OUTPUT.PUT_LINE('대표님!!!');
	ELSIF (myrow.job_code='J2') THEN
		DBMS_OUTPUT.PUT_LINE('임원진');
	ELSE DBMS_OUTPUT.PUT_LINE('사원...');
	END IF;
END;


-- 반복문
-- LOOP, FOR, WHILE

-- 일반 LOOP문
/*
 * LOOP
 * 		반복시킬 내용
 * 		IF 반복종료 조건
 * 			EXIT;
 * 		END IF;
 * 		또는
 * 		EXIT [WHEN 종료 조건]
 * END LOOP;
 * 
 * 
 */

DECLARE
	N INT :=5;
BEGIN
	LOOP
		DBMS_OUTPUT.PUT_LINE(N);
		N := N - 1;
		EXIT WHEN N = 0;
	END LOOP;
END;

-- FOR 반복문
/*
 * FOR 카운터변수 IN [REVERSE] 시작값..종료값 LOOP
 * 		반복할 내용;
 * END LOOP;
 * 
 */

BEGIN
	FOR N IN 1..5 LOOP
		DBMS_OUTPUT.PUT_LINE(N);
	END LOOP;
END;

BEGIN
	FOR N IN REVERSE 1..5 LOOP
		DBMS_OUTPUT.PUT_LINE(N);
	END LOOP;
END;

-- FOR문을 통한 INSERT 실행
CREATE TABLE TB_TEST_FOR(
	TEST_NO NUMBER,
	TEST_DATE DATE
);

BEGIN
	FOR x IN 1..10 LOOP
		INSERT INTO TB_TEST_FOR VALUES(x, CURRENT_DATE + x);
	END LOOP;
END;

SELECT * FROM TB_TEST_FOR;

-- WHILE문
-- 제어 조건이 TRUE인 동안만 반복.
/*
 * WHILE 반복조건 LOOP
 * 		반복할 내용;
 * END LOOP;
 */
DECLARE
	N INT := 5;
BEGIN
	WHILE N > 0 LOOP
		DBMS_OUTPUT.PUT_LINE(N);
		N := N - 1;
	END LOOP;
END;

-- 예외처리 EXCEPTION --
/*
 * EXCEPTION
 * 		WHEN 예외명 THEN 처리문1
 * 		WHEN 예외명 THEN 처리문2
 * 		WHEN OTHERS THEN 처리문3
 */
/*
 * 제공되는 익히 알려진 예외 법칙
 * NO_DATA_FOUND : SELECT한 결과가 하나도 없을 경우
 * CASE_NOT_FOUND : CASE 구문 중 일치하는 결과도 없고, ELSE로 그외 처리내용도 작성하지 않았을 때
 * LOGIN_DENIED : 잘못된 ID/PW 입력했을 경우
 * DUP_VAL_ON_INDEX : UNIQUE 제약조건 위배
 * INVALID_NUMBER : 문자데이터를 숫자 변경할 때, 변경할 수 없는 문자인 경우
 */
BEGIN
	UPDATE EMPLOYEE
	SET EMP_ID = '201'
	WHERE EMP_ID = '200';
EXCEPTION
	WHEN DUP_VAL_ON_INDEX THEN
	DBMS_OUTPUT.PUT_LINE('이미 존재하는 사원입니다.');
END;


-- PL/SQL 객체
-- 프로시저 : PL/SQL을 미리 저장해 놓았다가 프로시저명으로 호출하여
--			함수처럼 동작시키는 객체
/*
 * CREATE [OR REPLACE] PROCEDURE 프로시저명
 * 					(매개변수1 [IN/OUT/IN OUT] 자료형[, 매개변수2 자료형])
 *					IN : 프로시저에서 사용할 변수 값을 외부에서 받아올 때 사용하는 모드.
 *					OUT : 프로시저 싱행 결과를 외부로 추출할 때 사용하는 모드(RETURN)
 * IS
 * 	변수 선언;
 * BEGIN
 * 	실행할 코드;
 * END;
 */

-- 호출방식
-- EXECUTE 프로시저명[(전달값2, 전달값2...)]


-- EMLOYEE 테이블 복사하여 새로운 테이블 하나 생성
CREATE TABLE EMP_TMP
AS SELECT * FROM EMPLOYEE;

-- 프로시저 생성
CREATE OR REPLACE PROCEDURE DEL_ALL_EMP
IS
	-- 변수 선언이 없더라도 IS 생략 불가능
BEGIN
	DELETE FROM EMP_TMP;
	COMMIT;
END;
-- 프로시저는 선언시 바로 실행되는 것이 아닌
-- 선언 후 실행을 통해 별도 실행까지 해줘야 한다.

SELECT COUNT(*) FROM EMP_TMP;

-- EXEC DEL_ALL_EMP;
CALL DEL_ALL_EMP();

SELECT COUNT(*) FROM EMP_TMP;


-- FUNCTION 함수 : 내부에서 계산된 결과를 반환.
-- MAX(), MIN(), SUM()...

-- [사용형식]
-- CREATE [OR REPLACE] FUNCTION 함수명(매개변수 [모드] 자료형)
-- RETURN 자료형;
-- IS
--	변수 선언;
-- BEGIN
-- 	실행코드;
-- RETURN 결과데이터;
-- END;

CREATE OR REPLACE FUNCTION BONUS_CALC(V_EMP_ID IN EMPLOYEE.EMP_ID%TYPE)
RETURN NUMBER
IS
	V_SAL NUMBER;
	V_BONUS NUMBER;
	RES NUMBER;
BEGIN
	SELECT SALARY, NVL(BONUS,0)
	INTO V_SAL, V_BONUS
	FROM EMPLOYEE
	WHERE EMP_ID = V_EMP_ID;

	RES := V_SAL*V_BONUS;
	RETURN RES;
END;

SELECT EMP_NAME, BONUS_CALC(EMP_ID)
FROM EMPLOYEE;


-- 트리거 TRIGGER --
-- 특정 테이블이나 뷰가 DML을  통해 데이터 변환이 일어날 때
-- 그 시점을 감지하여 자동으로 동작하는 스크립트
-- 로직을 구현하는 객체


CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT
ON EMPLOYEE
DECLARE
	V_EMP_NAME VARCHAR2(20);
BEGIN
	SELECT EMP_NAME
	INTO V_EMP_NAME
	FROM(SELECT * FROM EMPLOYEE ORDER BY HIRE_DATE DESC)
	WHERE ROWNUM = 1;

	DBMS_OUTPUT.PUT_LINE(V_EMP_NAME||'사원이 입사했습니다.');
	DBMS_OUTPUT.PUT_LINE('환영해주세요:D');
END;

-- AFTER, BEFORE [INSERT|UPDATE|DELETE]

INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '김하현','090909-4242424','kim_hh@or.kr', '01033224422',
	  'D5','J7','S5',3000000,0.1,200,CURRENT_DATE,NULL,DEFAULT);

INSERT INTO EMPLOYEE
VALUES(SEQ_EID.NEXTVAL, '박하현','100909-4242424','park_hh@or.kr', '01033224466',
	  'D5','J7','S5',3000000,0.1,200,CURRENT_DATE,NULL,DEFAULT);


	 
-- 제품 정보 테이블
CREATE TABLE PRODUCT(
	PCODE NUMBER PRIMARY KEY,
	PNAME VARCHAR2(30),
	BRAND VARCHAR2(30),
	PRICE NUMBER,
	STOCK NUMBER DEFAULT 0
);
-- 제품 입,출고 내역 테이블
CREATE TABLE PRODUCT_DETAIL(
	DCODE NUMBER PRIMARY KEY,
	PCODE NUMBER NOT NULL,
	PDATE DATE DEFAULT CURRENT_DATE,
	AMOUNT NUMBER,
	STATUS CHAR(6) CHECK(STATUS IN ('입고', '출고')),
	CONSTRAINT FK_PRODUCT FOREIGN KEY(PCODE) REFERENCES PRODUCT
);
SELECT * FROM PRODUCT;
SELECT * FROM PRODUCT_DETAIL;

CREATE SEQUENCE SEQ_PRODUCT NOCACHE;
CREATE SEQUENCE SEQ_DETAIL NOCACHE;
-- 제품 등록 --
INSERT INTO PRODUCT
VALUES(SEQ_PRODUCT.NEXTVAL, '노트북', 'SAMSUNG', 2000000, DEFAULT);
INSERT INTO PRODUCT
VALUES(SEQ_PRODUCT.NEXTVAL, '스마트워치', 'APPLE', 1000000, DEFAULT);
INSERT INTO PRODUCT
VALUES(SEQ_PRODUCT.NEXTVAL, '이어폰', 'SONY', 500000, DEFAULT);
INSERT INTO PRODUCT
VALUES(SEQ_PRODUCT.NEXTVAL, '키보드', 'LOGITECH', 300000, DEFAULT);


SELECT * FROM PRODUCT;

-- 제품 입출고 관련 재고 증감 트리거 생성
CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON PRODUCT_DETAIL
FOR EACH ROW
BEGIN
	IF :NEW.STATUS = '입고'
	THEN UPDATE PRODUCT SET STOCK = STOCK + :NEW.AMOUNT
		 WHERE PCODE = :NEW.PCODE;
	END IF;
	IF :NEW.STATUS = '출고'
	THEN UPDATE PRODUCT SET STOCK = STOCK - :NEW.AMOUNT
		 WHERE PCODE = :NEW.PCODE;
	END IF;
END;


SELECT * FROM PRODUCT;

-- DETAIL에 입,출고 내역을 INSERT하고 PRODUCT의 STOCK의 값이 변하는지 확인
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 1, CURRENT_DATE, 10, '입고');

SELECT * FROM PRODUCT_DETAIL;

-- 입고
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 2, CURRENT_DATE, 100, '입고');
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 3, CURRENT_DATE, 200, '입고');
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 4, CURRENT_DATE, 1000, '입고');


-- 출고
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 1, CURRENT_DATE, 10, '출고');
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 2, CURRENT_DATE, 50, '출고');
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 3, CURRENT_DATE, 44, '출고');
INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 4, CURRENT_DATE, 677, '출고');

SELECT * FROM PRODUCT;

INSERT INTO PRODUCT_DETAIL VALUES(SEQ_DETAIL.NEXTVAL, 2, CURRENT_DATE, 35, '입고');
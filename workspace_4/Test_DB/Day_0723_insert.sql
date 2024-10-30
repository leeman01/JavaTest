-- 7월 23일 화요일

/*
 SQL문의 종류
1. DDL:create,alter,drop 
2. DML : insert,select,update,delete
3.DCL : grant, revoke
4.TQL: commit , rollback, savepoint
*/

-- 테이블 생성하기
/*
	create Table 테이블명
	(
		컬럼명    데이터타입    제약조건(생략가능) ,  -- pk,fk,nn,uq,ck (default)
		컬럼명    데이터타입    제약조건(생략가능) ,
		컬럼명    데이터타입    제약조건(생략가능) ,
		컬럼명    데이터타입    제약조건(생략가능) ,
		컬럼명    데이터타입    제약조건(생략가능) ,
		제약조건 (이는 테이블 레벨 제약조건) 컬럼명
	);
	
* 제약조건은 모든 제약조건을 관리하는 테이블에서 관리하게굄
* 제약조건명은 어떤테이블의 어껀컬럼에 어떤제약조건이 걸린건지 알기 좋게 만드는 것 이 좋다	
	
-- 데이터타입(자료형)
1) 문자자료형
char (10) : 'korea     ' => 글자크기가 고정되었을 때 사용
vachar(50): 'korea' ,
longbob

2) 숫자 자료형

*/
-- 데이터베이스 dima4 만들기
CREATE databases dima4;

USE dima4;
DROP TABLE sample;
-- 데이블 생성
-- 일련번호 int ,이름(4*3) vchar(4),주소(100),나이(decimal(3)
CREATE  TABLE sample
( 
	seq int auto_INCREMENT PRIMARY KEY -- AUTO_INCREMENT 자동으로 일련번호 지정
	,name varchar(15) NOT NULL
	,address varchar(100)
	,age decimal(3) DEFAULT 0	
);

SELECT * FROM sample;

-- 데이터 넣기

INSERT INTO sample 
(name,address,age)
VALUES
('홍길동','서울시 강남수 삼성동',25);

INSERT INTO sample 
(name,age)
VALUES
('임꺽정',30);

INSERT INTO sample 
(name,address)
VALUES
('손오공','제주시');

INSERT INTO sample 
VALUES
(4,'저팔계','충청남도 무슨동네',27);

SELECT * FROM sample;

COMMIT ;

-- 연습 fitness회원 정보를 저장할 수 있는 테이블을 생성하시오

USE dima4;
DROP TABLE fitness;
-- 데이블 생성
-- 일련번호 int ,이름(4*3) vchar(4),주소(100),나이(decimal(3)
-- 제약조건명을 기재하는 경우에는 테이블레벨을 사용 --> 가장 아래
-- 제약조건명을 기재하지 않는 경우에는 컬럼 레벨을 사용 --> 컬럼명 옆에
CREATE TABLE fitness
(
    id INT AUTO_INCREMENT, -- AUTO_INCREMENT 자동으로 일련번호 지정
    name VARCHAR(20) NOT NULL, -- NOT NULL은 반드시 컬럼 레벨로 사용해야 함
    gender CHAR(1),
    height DECIMAL(5,2), -- height의 철자 오류 수정
    weight DECIMAL(5,2),
    std_weight DECIMAL(5,2),
    bmi DECIMAL(4,2),
    bmiresult VARCHAR(30),
    CONSTRAINT fitness_id_pk PRIMARY KEY(id),
    CONSTRAINT fitness_gender_ck CHECK (gender IN ('남', '여')),
    CONSTRAINT fitness_height_ck CHECK (height BETWEEN 150 AND 200)
);

DESC dima4.sample fitness;
-- 제약조건 확인하기(information schema, table_constraints)
SELECT 
    TABLE_NAME 
    ,CONSTRAINT_NAME 
    ,CONSTRAINT_TYPE 
FROM 
    information_schema.table_constraints
WHERE 
    TABLE_NAME = 'fitness';

-- 제약조건 확인하기 2번째 (information schema,columns)
   SELECT 
   TABLE_NAME 
   ,COLUMN_NAME 
   ,IS_NULLABLE 
   ,COLUMN_KEY 
	,TABLE_SCHEMA 
   FROM  information_schema.COLUMNS;

 

	SELECT 
	TABLE_SCHEMA 
	  FROM  information_schema.COLUMNS
	  WHERE TABLE_SCHEMA ='dima4' ;
INSERT INTO fitness
(name,gender,height,weight,bmi)
VALUES
('이동건','남',190.04,87,weight / (height*height*0.0001));
SELECT * FROM fitness;

INSERT INTO fitness
(name,gender,height,weight,bmi)
VALUES
('이동건2','남',185, 74, weight / (height*height*0.0001));
SELECT * FROM fitness;

INSERT INTO fitness
(name,gender,height,weight,bmi)
VALUES
('이동건2','남',185, 74, weight / (height*height*0.0001));
SELECT * FROM fitness;

COMMIT;
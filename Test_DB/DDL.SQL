-- 데이터베이스 생성
DROP DATABASE jpatest;
CREATE database jpatest CHARACTER SET utf8mb4;
USE jpatest;
-- 접속할수있는 사용자 계정생성(jpauser)
DROP USER 'jpauser'@'localhost';
CREATE USER 'jpauser'@'localhost' identified BY 'jpauser'; -- 자기 컴퓨터에서 접속한 사람
DROP USER 'jpauser'@'%'; -- 외부에서 접속한 사람
CREATE USER 'jpauser'@'%' identified BY 'jpauser';

GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'localhost'; -- 모든 권한을 부여
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'%';

-- 자바에서는테이블을 안만들어서 여기에서 미리만든다
-- => 샘플 데이터 생성 (java jpa01 프로젝트와 연동하는 테이블 생성)
DROP TABLE  mysuer ; 
CREATE  TABLE mysuer(
email varchar(50) PRIMARY KEY  
, name varchar(50) NOT NULL 
,join_date datetime DEFAULT current_timestamp

);

-- entity -- 테이블이 실체화 되기전을 의미한다 => vo와 똑같은 테이블이다 DB 와 연동을 위함
SELECT * FROM  mysuer ;
DESC jpatest.mysuer ;
SELECT * FROM jpatest.mysuer;


-- 자바에서는테이블을 안만들어서 여기에서 미리만든다
-- => 샘플 데이터 생성 (java jpa02 프로젝트와 연동하는 테이블 생성)
DROP TABLE  members ;  
CREATE  TABLE members(
email varchar(50) PRIMARY KEY  
, name varchar(50) NOT NULL 
,birthday datetime 
,age decimal(3)
);

SELECT * FROM jpatest.members ;

-- 자바에서는테이블을 안만들어서 여기에서 미리만든다
-- => 샘플 데이터 생성 (java jpa03 프로젝트와 연동하는 테이블 생성)
DROP TABLE jpatest.fitness;

CREATE  TABLE fitness(
id int AUTO_INCREMENT PRIMARY KEY ,
name varchar(40),
gender varchar(10) ,
height decimal(10,2),
weight decimal(10,2),
std_weight decimal(10,2),
bmi decimal(10,2),
bmi_result varchar(100)  -- 어차피 varchar는 남는 메모리는 알아서 줄이므로 널널하게 잡자
); 
SELECT * FROM jpatest.fitness;
/*
 * private int id;
	private String name;
	private String gender;
	private double height;
	private double weight;
	private double stdweight;
	private double bmi;
 */
USE jpatest;
DROP TABLE jpatest.hotel_1;
CREATE TABLE hotel_1(
hotel_id varchar(50) PRIMARY KEY ,
name varchar(50) , 
created_date datetime ,
grade varchar(2)
);

SELECT * FROM jpatest.hotel_1;


USE jpatest;
DROP TABLE jpatest.cashbook;
CREATE TABLE cashbook(
seq int AUTO_INCREMENT PRIMARY KEY , 
today datetime DEFAULT current_timestamp,
item_type varchar(20),
detail varchar(200) NOT NULL ,
amount int,
note varchar(500)
);

SELECT * FROM jpatest.cashbook;

SELECT format(YEAR(c.today),'Y')
FROM jpatest.cashbook c;


SELECT item_type itemType ,sum(amount) total
FROM jpatest.cashbook
WHERE date_format(today,"%Y-%m") ="2024-08"
GROUP BY item_type;


-- 샘플데이터 생성( jpa05 프로젝트와 연동하는 테이블의 생성)
DROP TABLE jpatest.hotel_05;
CREATE TABLE jpatest. hotel_05(
hotel_id varchar(50) PRIMARY KEY ,
name varchar(50) , 
created_date datetime ,
grade varchar(2),
addr1 varchar(100) ,
addr2 varchar(100),
zipcode varchar(10)
);
SELECT * FROM  jpatest.hotel_05;
DROP TABLE jpatest.address ;
CREATE TABLE address(
addr1 varchar(100) ,
addr2 varchar(100),
zipcode varchar(10)
);

-- 테이블 생성
-- 1 : 1의 관계 , 1: 다의 관계 , 다대다의 관계 (권장하지않음 오류가 잦음)	
DROP TABLE jpatest.survey ;
CREATE TABLE jpatest.survey(
id varchar(30) PRIMARY KEY ,
name varchar(50) 
);
DROP TABLE jpatest.question;
CREATE TABLE jpatest.question(
Id varchar(10) PRIMARY KEY ,
survey_id varchar(10) REFERENCES jpatest.survey(id) ,
title varchar(50),
order_no int
);

SELECT  * FROM jpatest.question;
SELECT * FROM jpatest.survey;






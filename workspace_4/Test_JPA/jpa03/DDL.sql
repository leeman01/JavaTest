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


















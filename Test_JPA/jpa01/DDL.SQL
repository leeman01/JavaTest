-- 데이터베이스 생성
DROP DATABASE jpatest;
CREATE database jpatest CHARACTER SET utf8mb4;


-- 접속할수있는 사용자 계정생성(jpauser)
DROP USER 'jpauser'@'localhost';
CREATE USER 'jpauser'@'localhost' identified BY 'jpauser'; -- 자기 컴퓨터에서 접속한 사람
DROP USER 'jpauser'@'%'; -- 외부에서 접속한 사람
CREATE USER 'jpauser'@'%' identified BY 'jpauser';

GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'localhost'; -- 모든 권한을 부여
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'%';

-- 자바에서는테이블을 안만들어서 여기에서 미리만든다
-- => 샘플 데이터 생성 (java jpa01 프로젝트와 연동하는 테이블 생성)
DROP TABLE  jpatest.mysuer ; 
CREATE  TABLE jpatest.mysuer(
email varchar(50) PRIMARY KEY  
, name varchar(50) NOT NULL 
,join_date datetime DEFAULT current_timestamp

);
SELECT * FROM  jpatest.mysuer;
DESC  jpatest.mysuer;
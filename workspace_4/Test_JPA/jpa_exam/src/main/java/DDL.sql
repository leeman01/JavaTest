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



USE jpatest;
DROP TABLE jpatest.cashbook;
CREATE TABLE cashbook(
sqr int AUTO_INCREMENT PRIMARY KEY , 
today datetime DEFAULT current_timestamp,
item_type varchar(20),
detail varchar(200) NOT NULL ,
amount int,
note varchar(500)
);

SELECT * FROM jpatest.cashbook;
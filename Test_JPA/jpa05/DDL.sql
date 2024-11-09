DROP USER 'jpauser'@'localhost';
CREATE USER 'jpauser'@'localhost' identified BY 'jpauser'; -- 자기 컴퓨터에서 접속한 사람
DROP USER 'jpauser'@'%'; -- 외부에서 접속한 사람
CREATE USER 'jpauser'@'%' identified BY 'jpauser';

GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'localhost'; -- 모든 권한을 부여
GRANT ALL PRIVILEGES ON jpatest.* TO 'jpauser'@'%';


USE jpatest;
DROP TABLE jpatest.hotel_1;
CREATE TABLE hotel_1(
hotel_id varchar(50) PRIMARY KEY ,
name varchar(50) , 
created_date datetime ,
grade varchar(2)
);

SELECT * FROM hotel_1;
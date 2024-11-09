2024년 9월 04일 화요일

USE dima;

CREATE TABLE dima.guestbook(
seq int AUTO_INCREMENT PRIMARY KEY,
name varchar(50) NOT NULL ,
pwd varchar(50) NOT NULL,
content varchar(1000) ,
create_date datetime DEFAULT current_timestamp
);

DELETE TABLE dima.guestbook;

SELECT * FROM dima.guestbook g ;

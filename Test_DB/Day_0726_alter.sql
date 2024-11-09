/* 7월 26일 ALTER */
DROP TABLE products;
DROP TABLE customer;

CREATE TABLE dima4.customer(
customer_id char(3) PRIMARY KEY,
customer_name varchar(50) NOT NULL,
phone_number varchar(30) NOT NULL ,
address varchar(100)
);

-- 판매제품의 정보를 저장하는 테이블
CREATE  TABLE dima4.products(
product_id char(5) PRIMARY KEY ,
product_name varchar(100) NOT NULL,
manufactred_date datetime DEFAULT current_timestamp ,
unit_price int DEFAULT 0
);

-- 계약 정보를 저장하는 테이블
CREATE TABLE dima4.contract(
customer_id char(3) REFERENCES dima4.customer(customer_id),
product_id char(5) REFERENCES dima4.products(product_id),
contract_date datetime DEFAULT current_timestamp,
cnt int,
CONSTRAINT contract_pk PRIMARY KEY (customer_id,product_id)
); -- 양쪽 부모를 지닌 자식

-- alter => 테이블 이름 변경
ALTER TABLE dima4.customer RENAME TO dima4.customers;

-- 컬럼 추가 add
ALTER TABLE dima4.customers ADD email char(20);
-- 칼럼을 이미 존재하는 컬럼에 끼워넣기
ALTER TABLE dima4.products ADD product_grade char(1) CHECK (product_grade IN ('A','B','C'))
AFTER manufactred_date;

-- 컬럼삭제
ALTER TABLE dima4.contract DROP cnt;

-- 컬럼의 타입을 수정 modify
ALTER TABLE dima4.customers MODIFY address varchar(80);

-- 컬럼을 수정 change
ALTER TABLE dima4.products 
CHANGE COLUMN unit_price price DECIMAL(10,2);


--  수정여부를 확인하기
DESC dima4.contract ;
DESC dima4.products ;
DESC dima4.customers ;




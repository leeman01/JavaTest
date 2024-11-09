/* 관계를 형성해서 테이블 만들기 
 * 1. 부모테이블 만들기(PK,FK) => 자식 테이블 만들기
 * drop은 자식테이블 => 부모테이블 순이다
 */
USE dima4;
DROP TABLE parent ;
-- Create the parent table
CREATE TABLE IF NOT EXISTS dima4.parent 
(
    id INT AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    age DECIMAL(3, 0) DEFAULT 20,
    CONSTRAINT parent_id_pk PRIMARY KEY (id)
);

-- Drop the child table if it exists
DROP TABLE IF EXISTS dima4.child;

-- Create the child table
CREATE TABLE dima4.child (
    cid INT AUTO_INCREMENT,
    id INT,         -- 부모의 PK가 전이된 컬럼
    major VARCHAR(30),
    grade DECIMAL(2, 1),
    CONSTRAINT child_cid_pk PRIMARY KEY (cid),
    CONSTRAINT chid_id_fk FOREIGN KEY (id) REFERENCES dima4.parent(id)
    ON DELETE CASCADE ON UPDATE CASCADE
);
-- 부모의 레코드를 삭제하려고 하면 ㅇ[라님 (부모의 PK를 자식이 참조하고 있다면)

INSERT INTO dima4.parent 
(name,phone,age)
VALUES
('홍길동','1',20);

INSERT INTO dima4.parent 
(name,phone,age)
VALUES
('사오정','3',22);

INSERT INTO dima4.parent 
(name,phone,age)
VALUES
('길동','2',20);

INSERT INTO dima4.parent 
(name,phone,age)
VALUES
('홍길동','4',50);

SELECT * FROM dima4.parent;

INSERT INTO dima4.child(id,major,grade) VALUES (1,'컴공',4);
INSERT INTO dima4.child(id,major,grade) VALUES (2,'gksrnrgkr',3);
INSERT INTO dima4.child(id,major,grade) VALUES (3,'영어영문ㄴ학',5);
INSERT INTO dima4.child(id,major,grade) VALUES (4,'응용미술',3);
SELECT * FROM dima4.child;

-- 조인으로 조회하기
SELECT p.id,p.name,c.major,c.grade 
FROM dima4.parent p , dima4.child c 
WHERE p.id = c.cid ;
-- on delete cashcade가 되는지 확인
-- 부모의 레코드를 삭제하면 자식의 레코드로 같이 삭제되는 것
DELETE FROM dima4.parent p
WHERE p.id=1;

SELECT * FROM dima4.child;
-- on update cashcade
-- 부모레코드의 PK가 수정되면 자식의 레코드의 FK도 같이 수정되는것

UPDATE dima4.parent 
SET id :=90
WHERE id=2;
SELECT * FROM dima4.parent p ;
SELECT * FROM dima4.child; -- 참조하던 자식도 바뀜







-- --------------------------------------------------------------------------------------------------------
CREATE TABLE dima4.movie (
    movie_num INT AUTO_INCREMENT,
    genre VARCHAR(50) NOT NULL,
    movie_name VARCHAR(50) NOT NULL,
    movie_summary VARCHAR(2000) NOT NULL,
    movie_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    enabled DECIMAL(1) DEFAULT 1,
    rolename VARCHAR(20) DEFAULT 'ROLE_USER',
    CONSTRAINT movie_num_pk PRIMARY KEY (movie_num)
);

CREATE TABLE dima4.review(
review_num INT AUTO_INCREMENT,
review_name  VARCHAR(50) NOT NULL,
movie_num int NOT NULL,
review_text VARCHAR(2000) NOT NULL,
score DECIMAL(1) DEFAULT 0,
review_date DATETIME DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT review_name_pk PRIMARY KEY (review_num),
	CONSTRAINT review_movie_num_fk FOREIGN KEY (movie_num) REFERENCES dima4.movie(movie_num),
	ON DELETE CASCADE ON UPDATE CASCADE
);

SELECT
   *
FROM
    information_schema.table_constraints
WHERE
    table_schema = 'dima4';

















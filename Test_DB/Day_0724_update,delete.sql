/*
 * update 테이블명
 * set first_name = '오공'
 * where employee_id = 100
 */


USE hr;
DROP TABLE emp2;
SELECT DATABASE();
-- 1) insert into select문
-- select에서 나온 결과를 다른 새로운 테이블을 생성해서 복사하는 방법
SELECT *
FROM hr.employees e ;

-- INSERT INTO employees
-- (employee_id,first_name,last_name,hire_date,job_id)
-- VALUES
-- (99,'길동','홍','2024-07-24','IT_PROG');

CREATE TABLE hr.emp2
SELECT *
FROM hr.employees e;

SELECT *
FROM employees ;

UPDATE hr.emp2
SET first_name ='오공'
WHERE employee_id =100;

SELECT *
FROM emp2
WHERE first_name ='오공';

ROLLBACK ; -- 되돌림 , 단 autocommit이  false여야지만 원상태로 되돌아간다

UPDATE hr.emp2
SET salary =salary *1.1;

SELECT *
FROM employees;
-- SH_CLERK 인 직급을 전부 SA_REP로 수정
UPDATE hr.emp2
SET job_id ='SA_REP'
WHERE  job_id = 'SH_CLERK';
-- 오토커밋을 비활성화 :0 // 오토커밋을 활성화 :1
SET autocommit =0;


-- delete 문: 레코드를 삭제
/*
 * DELETE FROM 테이블명
 * where 조건절 ;
 */
SELECT *
FROM hr.emp2;

-- 커미션을 안받는 사람을 삭제하고자 함
DELETE  FROM hr.emp2 
WHERE  commission_pct  IS NULL;

ROLLBACK;

-- [문제] 80번 부서의 직원들만 새로운 테이블로 옮겨라(emp_80) => 이 테이블의 모든 직원의 급여를 25% 올리시오

DROP TABLE emp_80;

CREATE TABLE emp_80
SELECT *
FROM hr.employees e 
WHERE  department_id=80;


SELECT *
FROM emp_80;

UPDATE  hr.emp_80
SET  salary = salary *1.25;



ROLLBACK ;

-- insert 문의 autoincrement 의 사용복습
DROP TABLE mytble;

USE dima4;

CREATE TABLE mytble (
   USERid int AUTO_INCREMENT primary KEY
, name varchar(30) NOT NULL
, age int DEFAULT 0
, join_date datetime DEFAULT current_timestamp
,today date DEFAULT (current_date)
, `now` datetime DEFAULT (current_time) 
);

INSERT INTO dima4.mytble
(name,age)
VALUES
('이몽룍',20);

INSERT INTO dima4.mytble
(USERid,name,age)
VALUES
(NULL,'이몽준',20);


SELECT *
FROM dima4.mytble;

SELECT last_insert_id();

-- 날짜관련 데이터 타입 테스트하기
USE dima4;
SELECT DATABASE() ;

 CREATE TABLE timetest
 (
 	col1 date
 	,col2 datetime
 	,col3 timestamp
 	,col4 time
 	,col5 year
 );
 
DESC timetest;

INSERT INTO dima4.timetest
VALUES
(
current_timestamp,current_timestamp,current_timestamp,current_timestamp,current_timestamp
);

SELECT *
FROM timetest;

/*
 * JOIN 
 * 		-2개의 테이블(관계가 형성되어있는 테이블)로부터 데이터를 조회
 * 		- 두 테이블은 (PK,FK가 있어야한다)
 * -조인의 종류
 * 1) CROSS JOIN(=카르테시안)
 * 		A X B
 * 
 * 
 */

USE hr;
SELECT * FROM hr.employees e ;
SELECT *FROM hr.departments d ;

-- 1) 카르테시안 조인
SELECT  * FROM hr.employees e CROSS JOIN hr.departments d ;


SELECT  * FROM hr.employees e, hr.departments d ;

-- 2) Inner join: 조건절이 포함되어 PK와 FK가 같은 데이터를 조회
-- 조인 컬럼에 null을 가진 레코드는 제외된다// 서로 관계를 맺는 둘이상의 테이블로부터 데이터를 조회
-- FK값이 NULL인 경우에는 조회대상에서 제외된다
SELECT * 
FROM hr.employees e INNER JOIN hr.departments d 
ON e.department_id =d.department_id ; -- 두 테이블의 조인 조건을 on에 기재

-- 이름,사원번호,급여,부서명-연습
SELECT  e.employee_id ,e.first_name ,e.salary ,d.department_name 
FROM hr.employees e INNER JOIN hr.departments d 
ON e.department_id =d.department_id ; 

-- 이름,사원번호,급여,부서명-연습 => Using 절로 수정
SELECT  e.employee_id ,e.first_name ,e.salary ,d.department_name 
FROM hr.employees e INNER JOIN hr.departments d 
USING  (department_id);

-- 사원번호로 오름차순
SELECT  e.employee_id ,e.first_name ,e.salary ,d.department_name 
FROM hr.employees e INNER JOIN hr.departments d 
ON e.department_id =d.department_id 
ORDER BY e.employee_id ;

-- 사원번호로 오름차순  => USING 절
SELECT  e.employee_id ,e.first_name ,e.salary ,d.department_name 
FROM hr.employees e INNER JOIN hr.departments d 
USING  (department_id)
ORDER BY e.employee_id ;

-- [문제] 급여가 200을 초과하는 이름 급여 부서명
SELECT  e.first_name ,e.salary ,d.department_name 
FROM hr.employees e INNER JOIN hr.departments d 
ON e.department_id =d.department_id 
WHERE e.salary >200
ORDER BY e.employee_id ;

SELECT  e.first_name ,e.salary ,d.department_name 
FROM hr.employees e INNER JOIN hr.departments d 
USING  (department_id)
WHERE e.salary >200
ORDER BY e.employee_id ;

-- [문제] 급여가 200을 초과하는 직원의 이름,급여,부서명,근무하는 도시를 조회하시오
-- employees(FK =department_id),departments(PK=department_id,FK =location_id) , locations(PK = locatio_id)
SELECT * FROM hr.locations ;
SELECT * FROM hr.departments d ;

SELECT e.first_name ,e.salary ,d.department_name ,l.city
FROM hr.employees e INNER join	hr.departments d
ON e.department_id =d.department_id 	
	INNER JOIN hr.locations l 
	ON d.location_id  = l.location_id 
WHERE e.salary >5000;	
	

SELECT e.first_name ,e.salary ,d.department_name ,l.city
FROM hr.employees e INNER join	hr.departments d
USING  (department_id )
	INNER JOIN hr.locations l 
	USING (location_id )
WHERE e.salary >5000;	
-- [문제] 부서명과 부서가 속한 도시와 해당 도시가 있는 나라를 조회하시오

SELECT d.department_name ,l.city ,c.country_name 
FROM hr.departments d  INNER JOIN hr.locations l 
USING  (location_id) 
	INNER JOIN hr.countries c 
	ON c.country_id =l.country_id ;

-- outer join
/*
 *  inner join은 FK가 null이면 조회에서 제외됨
 * outer join은 모든 데이터를 다 조회
 * Left Outer Join(자식 null 데이터를 가진 테이블을 왼쪽에 배치) / Right Outer Join
 * Outer는 생략 가능
 * 
 * 
 * 
 */

-- [문제] 전체직원의 이름,급여,부서명 조회

SELECT e.first_name ,e.salary ,d.department_name 
FROM hr.employees e LEFT OUTER  JOIN hr.departments d 
ON e.department_id =d.department_id ;


SELECT e.first_name ,e.salary ,d.department_name 
FROM hr.employees e LEFT OUTER  JOIN hr.departments d 
USING (department_id );

-- [문제] [문제] 부서명과 부서가 속한 도시와 해당 도시가 있는 나라를 조회하시오
SELECT d.department_name ,l.city ,c.country_name 
FROM  hr.locations l RIGHT OUTER JOIN hr.countries c 
USING (country_id)
	right  OUTER JOIN hr.departments d 
	USING (location_id);

/*
 * self join 
 * 하나의 테이블에 PK와 FK를 같이 가지고 있는 경우
 * 
 * 
 */
SELECT e.employee_id ,e.first_name ,e.manager_id 
FROM hr.employees e ;

-- [문제]사원번호와 이름 ,상관의 사원번호와 상관의 이름
-- 부모의 pk가 자식의 fk로 전이
SELECT e.employee_id ,e.first_name AS "직원명",e2.employee_id ,e2.first_name AS "Manger 명" 
FROM hr.employees e   -- 자식을 왼쪽에 (FK)
INNER JOIN hr.employees e2   -- 부모를 오른쪽에(PK)
ON  e.manager_id = e2.employee_id ;

-- [문제]:ㅣ steven도 출력되도록 하시오(총 107명 아 조회되어야함)
SELECT e.employee_id ,e.first_name AS "직원명",e2.employee_id ,e2.first_name  AS "Manger 명"
FROM hr.employees e   -- 자식을 왼쪽에 (FK)
LEFT OUTER  JOIN hr.employees e2   -- 부모를 오른쪽에(PK)
ON  e.manager_id = e2.employee_id ;




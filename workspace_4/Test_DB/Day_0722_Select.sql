-- 2024년 7월 22일 (월)
/*

**** SQL
-- DBS에 접근해서 처리하는 명령어들
-- 국제표준이지만 각 벤더별로 명령문이 조금씩 다르다!
-명령어의 종류
1) DDL(Database Definition Language) : 객체를 다루는 명령
  create(생성) alter(변경) drop(삭제)
  2) DML(Database Manipulation Language): 테이블의 레코드를 다루는 명령
  
  insert(삽입)  select(조회)  update(수정) delete(삭제)  -- 조회를 제외한 나머지는 원본 보다는 복사본으로 삭제 , 수정,삽입을 한다고 생각하자
 
  3) TCL(Transaction Control Language) 트랙션을 다루는 명령
  
  commit(저장)   rollback(전체되돌림)  savepoint(되돌릴 위치까지 되돌림)
  commit -> 원본의 내용을 복사본에 오버라이딩해준다
   
  4) DCL (DataBase Control Language)  : 권한을 다루는 명령
  
  grant(권한부여) revoke(권환회수)
  
  주의) 
  - SQL 명령은 ; 로 끝나야 한다
  
*/


/**** select 문
 * 테이블의 내용을 조회
 */

USE hr;

SELECT*FROM employees;
SELECT first_name,hire_date,salary
FROM employees e;

-- 기본데이터 확인하기
SELECT*FROM countries c ;
SELECT *FROM regions r ;
SELECT *FROM  departments d ;
SELECT*FROM employees e ;


-- 이름과 급여정보를 조회하시오
SELECT first_name, salary 
FROM employees e ;
-- distinct : 중복된 결과는 나오지 않게해라
-- all: 전체 다 보여주는 것으로 디폴트 값이며 생략이 가능하다

SELECT distinct department_id FROM employees e ;

-- 부서번호를 정렬하고 조회하시오
-- 오름차순은 asc 내림차순은 desc 이다
-- select distinct 컬럼명 from 테이블명  --- ASC(기본값)
SELECT DISTINCT  department_id
FROM employees e
ORDER BY department_id desc;

-- --------------------------------- 07/23
-- 스키마 생성

CREATE SCHEMA dima4 DEFAULT CHARACTER SET utf8mb4;

DROP SCHEMA dim4 ;

-- 스키마 사용 => 어떤 스키마에서 작업 중인걸 알아야한다

USE hr;
SHOW tables;
USE sakila;

-- 테이블의 내용 조회
SELECT * FROM employees;

select first_name,salary,job_id
FROM employees
ORDER BY salary DESC;

-- job_id별로 오름차순, job_id가 같은 경우 알파벳순으로  이름을 알파벳순으로 오름차순
-- orderby 절은 항상 문장의 마지막
select first_name,salary,job_id
FROM employees
ORDER BY job_id ASC, first_name ASC,salary DESC ;

-- Distinct <=> All
-- 조회한 레코드의 모든 데이터가 같을 경우 중복을 배제
SELECT ALL first_name,salary,job_id
FROM employees
ORDER BY job_id ASC;
/****
 Where 절
 조건을 주어서 조건에 부합하는 정보만 조회할 때 사용
 True /False 반환되는 조건을 Where 에서 사용
 모든 레코드를 전부 조사
 비교연산자
 = != >= ,<=  >  < 
 
 LIKE 연산자
문자열 내에 포함된 특별한 문자값을 찾아서 조회할때

% : 0개 이상의 글자를 의미
_ : _당 한개의 글자를 의미

 NULL 비교 => ' ' 이건 빈문자열로 NULL값이 아니다
 
 IS NULL , IS NOT NULL
 
  BETWEEN 값 AND 비교값

  AND 연산과 유사
    
  IN 연산자
  OR 연산자와 유사
  
  Limit
  초과된 결과의 일부분만 재추출하여 다시 조회
  
 논리연산자
 AND OR NOT 
 
 산술연산자
 + - */ 


  */

SELECT  first_name,salary,job_id
FROM employees
WHERE salary>=10000
ORDER BY salary DESC ;

-- 문제 부서번호가 80인 사람을 전부 조회
SELECT  department_id,first_name,salary
FROM employees
WHERE  department_id =80;

-- 문제  급여가 10000 이상인 직원의 사원 이름 직급 급여 조회

SELECT  department_id,employee_id ,salary,job_id 
FROM employees
WHERE  salary >=10000;

-- 연습 betwwn 문제
SELECT  department_id,employee_id ,salary,job_id 
FROM employees
WHERE  salary BETWEEN 5000 AND 10000
ORDER BY salary DESC;

-- 급여가 5000이상인 10000이하

SELECT  department_id,employee_id ,salary,job_id 
FROM employees
WHERE  salary <=10000 AND salary>=5000 
ORDER BY salary DESC;


SELECT  department_id,employee_id ,salary,job_id 
FROM employees
WHERE  department_id =10 OR department_id =50;

-- 부서가 이에 속하지 않은 직원

SELECT  department_id,employee_id ,salary,job_id 
FROM employees
WHERE NOT (department_id =10 OR department_id =50) 
ORDER BY 1;

-- 이름 급여 커미션 비용 을 조회
SELECT  first_name,salary,commission_pct 
FROM employees e 
WHERE commission_pct>=0 ;

SELECT  first_name,salary,commission_pct 
FROM employees e 
WHERE  commission_pct IS NULL ; -- null값을 비교하는 IS NULL 

-- 모든 데이터베이스에서 문자열값을 받을 때는  ' ' 을 사용한다 " " 은 별칭을 쓸 때 사용한다
SELECT  first_name,salary,job_id,commission_pct 
FROM employees e 
WHERE  commission_pct IS NOT NULL 
AND job_id = 'SA_MAN' ; -- null값을 비교하는 IS NULL 

-- 별칭 붙이기
SELECT  first_name AS " 이 름 ",salary AS  월급,job_id,commission_pct 
FROM employees  e 
WHERE  commission_pct IS NOT NULL ;

-- 연습  이름,급여,커미션 총수령액을 조회 => 별칭을 통한 계산을 불가능하다
SELECT  first_name AS " 이 름 ",salary AS  월급,job_id,commission_pct ,salary +salary *commission_pct  AS "총수령액"
FROM employees  e 
WHERE  commission_pct IS NOT NULL;

-- LIKE 연산자 사용
-- 연습 이름이 문자 'J;로 시작하는 직원의 이름과 부서 조회'

SELECT  first_name AS " 이름 ",salary AS  월급,department_id 
FROM employees  e 
WHERE  first_name  LIKE   'J%' ;

SELECT  first_name AS " 이름 ",salary AS  월급,department_id 
FROM employees  e 
WHERE  first_name  LIKE   '%n' ;

SELECT  first_name AS " 이름 ",salary AS  월급,department_id 
FROM employees  e 
WHERE  first_name  LIKE   '____n' ;


-- 이름, 입사일  급여

SELECT  first_name AS " 이름 ",salary AS  월급,hire_date 
FROM employees  e 
WHERE  hire_date  LIKE   '2007%' ;

-- 문제 1월달에 입사한 사람

SELECT  first_name AS " 이름 ",salary AS  월급,hire_date 
FROM employees  e 
WHERE  hire_date  LIKE   '_____01%';

-- 연습 2007년 이전에 입사한 직원의 이름과 입사년도를 조회하시오
SELECT  first_name AS " 이름 ",salary AS  월급,hire_date 
FROM employees  e 
WHERE   hire_date  <  '2007-01-01'
ORDER BY hire_date;

-- IN 연산자
-- 사원번호가 145번이거나 147번,158번인 사람을 조회
-- 사원번호 이름 전화번호

SELECT  employee_id ,first_name ,phone_number 
FROM employees  e 
WHERE   employee_id IN (145,147,158);

-- 문제  부서번호가 80이거나 50인 직원의 명단(이름,부서번호,직급)을 조회

SELECT  department_id ,first_name ,job_id 
FROM employees  e 
WHERE   department_id  IN (80,50);

-- 맨 앞에서도 10개 조회
SELECT employee_id first_name,salary 
FROM employees e
LIMIT 10 ;
-- 20개를 건너뛰고 10개 조회
SELECT employee_id first_name,salary 
FROM employees e
LIMIT 20,10 ;

-- 나머지연산
SELECT 10%3; -- DUAL: dummy 테이블

/* 변수의 사용(사용자 정의 변수) */
-- 변수선언과 초기화  :=
-- 자바에서는 =이 대입연산자고, :=은 sql이 대입연산자다 =은 비교연산자이다
SET @low := 4000, @hi := 6000;


SELECT @low,@hi;
SELECT@ltest; -- @test변수는 초기화하지 않았으므로 NULL


SELECT *FROM employees e
WHERE salary BETWEEN @low AND @hi;


















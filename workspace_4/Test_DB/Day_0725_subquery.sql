/*
 * 서브쿼리(sub query)
 * 쿼리문안에 다른 쿼리가 포함된 것
 * 서브쿼리 - 안쪽에 포함된 쿼리문
 * 메인쿼리 - 바깥쪽에있는 쿼리문
 * 
 * 1) 메인쿼리
 * -실행의 결과를 보여주는 쿼리문
 * - 일반적으로 서브쿼리에 의해 실행된 결과가 메인에서 사용
 * 
 * 2) 서브쿼리
 * - 메인쿼리 안쪽에 위치한 쿼리문 
 * -서브쿼리의 결과가 메인쿼리의 조건이나 결과로 사용됨
 * 
 *  -서브쿼리의 위치: where 절, having절 , from 절, insert 문의 into 절(보류) select 절,update 문의 set절
 * select sub
 * from sub
 * where sub
 * 
 * 3) 서브쿼리의 종류
 * 1. 단일행 서브쿼리 : 서브쿼리가 뱉어내는 값이 1개
 * 2. 복수형 서브쿼리: 서브쿼리가 뱉어내는 값이 1개 이상 , =로비교는 불가능함 , 여러개를 비교할 수 있는 연산자를 사용해야함,/// in 연산자 ,any 연산자(비교연산자), all 연산자
 * > any < any >=any
 */
		
-- [문제]	사원번호가 162번인 사원의 급여와 동일한 같은 급여를 받는 직원의 이름 급여 부서번호 조회	
-- 1) 찾은값 : 10,500
SELECT salary
FROM hr.employees e 
WHERE employee_id = 162;
-- 2) 찾은 값을 가지고 다시 조회
SELECT first_name ,salary ,department_id 
FROM hr.employees e 
WHERE salary =10500;
		
		
-- 3) 단일행 서브쿼리로 합치기		
SELECT first_name ,salary ,department_id 
FROM hr.employees e 
WHERE salary =( SELECT salary
FROM hr.employees e 
WHERE employee_id = 162  );

-- 다중행 서브쿼리
USE world;
SELECT * FROM world.city;

SELECT * FROM world.country ;
SELECT * FROM world.countrylanguage ;
-- 연습문제
SELECT name,Population 
FROM world.country c 
WHERE code in(SELECT CountryCode 
FROM world.countrylanguage c 
WHERE Percentage =100 AND `Language` ='SPANISH');


-- [문제] 30번부서의 직급들과 동일한 직급이 다른팀에도 있는지 조사


SELECT * FROM hr.employees e
WHERE job_id  IN (SELECT DISTINCT job_id 
FROM hr.employees e 
WHERE department_id =30);

SELECT *
FROM hr.employees e 
WHERE job_id ='PU_MAN' OR  job_id ='PU_CLERK';

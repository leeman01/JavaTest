-- ======================================================
/*
 * 서브쿼리(subquery)
 * 쿼리문 안에 다른 쿼리가 포함된 것
 * 서브쿼리 - 안쪽에 포함된 쿼리문
 * 메인쿼리 - 바깥쪽에 있는 쿼리문
 * 
 * 1)메인쿼리
 * - 실행의 결과를 보여주는 쿼리문 
 * - 일반적으로 서브쿼리에 의해 실행된 결과를 메인에서 사용
 * 
 * 2) 서브쿼리
 * - 메인쿼리 안쪽에 위치한 쿼리문
 * - 서브쿼리의 결과가 메인쿼리의 조건이나 결과로 사용됨
 * - 서브쿼리의 위치
 *       where 절
 *       having   
 *       from   
 *       select   
 *       insert 문의 into절 
 *       update 문의 set절
 *
 * 3) 서브쿼리의 종류
 *       1.단일행 서브쿼리 : 서브쿼리가 뱉어내는 값이 1개
 *       2.다중행 서브쿼리 : 서브쿼리가 뱉어내는 값이 2개 이상 =로 비교 불가
 *                      여러개를 비교할 수 있는 연산자를 사용해야함
 *                      in 연산자, any 연산자(비교연산자), all 연산자
 *                      > any , < any , >= any ...
 *       3. 다중 컬럼 서브쿼리 :
 *                      서브쿼리가 뱉어내는 컬럼이 여러개인 경우
 *       4.Scalar 서브쿼리
 * 				: SELECT 절의 컬럼 위치에 사용되는 서브쿼리
 * 				: Scalar 서브쿼리는 성능 문제로 join 사용을권장한다
 *       5.Inline View
 * 			: 서브쿼리가 from 절에 기술되는 것
 * 			: 서브쿼리로 조회되는 결과를 테이블로 사용함
 * 			: 서브쿼리에서 조회되는 컬럼에는 별칭을 사용해야 한다
 *       6.상호연관 서브쿼리
 * 
 */


-- 사원번호가 162번인 사원의 급여와 동일한 급여를 받는 직원의 이름, 급여, 부서번호를 조회
-- 1) 찾은값 : 10500
SELECT salary
FROM hr.employees e 
WHERE employee_id =162;

-- 2) 찾은 값을 가지고 다시 조회
SELECT first_name ,salary ,department_id 
FROM hr.employees e 
WHERE salary =10500;

-- 3) 단일행 서브쿼리로 합치기
SELECT first_name ,salary ,department_id 
FROM hr.employees e 
WHERE salary = 
(
SELECT salary
FROM hr.employees e 
WHERE employee_id =162);


-- 9. SELF JOIN을 사용하여 'Oliver' 사원의 부서명, 그 사원과 동일한 부서에서 근무하는 동료 사원의 이름을 조회.
-- 단, 각 열의 별칭은 부서명, 동료로 할 것.

-- 1) 찾은값 : 80
SELECT  department_id 
FROM hr.employees e 
WHERE first_name ='Oliver';

-- 2) 찾은 값을 가지고 다시 조회
SELECT e.first_name ,d.department_name
FROM hr.employees e JOIN hr.departments d 
USING (department_id)
WHERE e.department_id =(SELECT  e.department_id 
               FROM hr.employees e 
               WHERE e.first_name ='Oliver');

-- 다중행 서브쿼리
-- in연산자의 사용
-- 30번 부서의 직급들과 동일한 직급이 다른팀에도 있는지 조사하는 서브쿼리를 작성하시오
USE hr;
SELECT *FROM hr.employees e 
WHERE job_id IN(SELECT DISTINCT job_id 
FROM hr.employees e 
WHERE department_id =30)
AND department_id != 30 
;

            
            
-- mysql 에서 제공하는 world database 내에 테이블을 확인한 후 전체 인구 percentage 100%가 공식언어로 'spanish'를 사용하는 나라의 이름과 인구를 조회하는 코드를 서브 쿼리를 이용해 작성하시오
USE world;
SELECT *FROM world.city c ;
SELECT *FROM world.country c ;
SELECT *FROM world.countrylanguage c ;

SELECT name,Population
FROM world.country c 
WHERE code IN (SELECT CountryCode 
            FROM world.countrylanguage c 
            WHERE Percentage=100
            AND `Language`='spanish');

-- any 연산자의 사용 
-- hr 데이터베이스에 존재하는 employees테이블에 'ST_MAN'이라는 직군이 있다.
         -- 이 직군보다 적은 급여를 받는 직원의 정보를 조회 
      
USE hr;
SELECT first_name ,salary 
FROM hr.employees e 
WHERE salary < ANY (
      SELECT salary
      FROM hr.employees e
      WHERE job_id='ST_MAN'
      ORDER BY salary); 

-- job_title이 'manager'인 직원과 동일한 급여를 받는 직원의 사원번호, 이름,job_id, 급여의 정보를 급여순으로 조회하시오
   
   SELECT e.salary , first_name ,job_title
   FROM hr.employees e  INNER JOIN hr.jobs j 
   ON e.job_id = j.job_id 
   WHERE job_title LIKE '%manager';
      
   SELECT employee_id ,first_name ,job_id ,salary 
   FROM hr.employees e 
   WHERE salary =ANY (
         SELECT e.salary 
         FROM hr.employees e  INNER JOIN hr.jobs j 
         ON e.job_id = j.job_id 
         WHERE job_title LIKE '%manager'
   )
ORDER BY 4;


-- all 연산자 사용
-- hr 데이터베이스에 존재하는 employees테이블에 'ST_MAN'이라는 직군이 있다.
         -- 이 직군보다 적은 급여를 받는 직원의 정보를 조회 
USE hr;
SELECT first_name ,salary 
FROM hr.employees e 
WHERE salary < ALL  (
      SELECT salary
      FROM hr.employees e
      WHERE job_id='ST_MAN'
      ORDER BY salary
   ); 
   
-- job_title이 'manager'인 직원과 동일한 급여를 받는 직원의 사원번호, 이름,job_id, 급여의 정보를 급여순으로 조회하시오
   SELECT e.salary , first_name ,job_title
   FROM hr.employees e  INNER JOIN hr.jobs j 
   ON e.job_id = j.job_id 
   WHERE job_title LIKE '%manager';
      
   SELECT employee_id ,first_name ,job_id ,salary 
   FROM hr.employees e 
   WHERE salary <ALL  (
         SELECT e.salary 
         FROM hr.employees e  INNER JOIN hr.jobs j 
         ON e.job_id = j.job_id 
         WHERE job_title LIKE '%manager'
         ORDER BY salary 
   )
ORDER BY 4;

-- ========================================================================================================================
-- 3. 다중 컬럼 서브쿼리
-- 각 부서별 최고금액을 수령하는 직원의 정보(사원번호,이름, 급여, 부서명, 직급명)을 출력하시오
         
 
-- [연습] 각 부서별 최고금액을 수령하는 직원의 정보 직원의 정보 사원번호 이름 급여 부서명 직급명 을 조회하시오
-- max min average 함수가 있다 
SELECT department_id , max(salary)
FROM hr.employees e 
GROUP BY department_id ;
         
-- 서브쿼리 사용하기 :컬럼이 2개 조회
 
 SELECT e.employee_id, e.first_name, e.salary, d.department_name, j.job_title
FROM hr.employees e
INNER JOIN hr.departments d ON e.department_id = d.department_id
INNER JOIN hr.jobs j ON e.job_id = j.job_id
WHERE (e.department_id, e.salary) IN (
    SELECT department_id, MAX(salary)
    FROM hr.employees
    GROUP BY department_id
);

-- 스칼라 서브쿼리  => 값이 다중으로 나오면 스칼라 서브쿼리 사용이 불가능하다

SELECT 
	(SELECT last_name FROM hr.employees e2 WHERE first_name='Bruce') AS "Bruce의 성",
	(SELECT last_name FROM hr.employees e2 WHERE first_name='Daniel') AS "Daniel의 성"
;
-- 인라인 뷰

-- 일반조회
SELECT employee_id ,first_name ,salary ,department_id 
FROM hr.employees e 
WHERE department_id =80;
-- 앞에서 조회된 결과를 이용해서 일련번호를 부여한 후에 출력하려면?
SET  @ronum :=0; -- 일련번호를 넣기 위해 사용자 정의변수
SELECT @ronum := @ronum +1 AS "일련번호",tbl.* FROM 
(SELECT employee_id ,first_name ,salary ,department_id 
FROM hr.employees e 
WHERE department_id =80) tbl;
-- 상호연관 서브쿼리

-- [연습] 각 부서별로 해당 부서의 급여 평균 미만의 급여를 수령하는 직원 명단 조회 => 부서번호,사원번호,이름,급여,부서별 평균
SELECT department_id ,employee_id ,first_name ,salary
FROM hr.employees e 
WHERE salary <( SELECT avg(salary)
						FROM hr.employees 
						WHERE department_id =e.department_id)
ORDER BY 1,2;

SELECT avg(salary)
FROM hr.employees e 
WHERE department_id =20;

-- 위 코드를 인라인 뷰로 수정하시오
SELECT department_id AS "부서번호" ,avg(salary) AS "부서 평균"
FROM hr.employees e 
GROUP BY department_id ;
-- 인라인 뷰 안에 넣자
SELECT e.department_id, e.employee_id, e.first_name, e.salary,round(부서_평균)
FROM (
    SELECT department_id, AVG(salary) AS 부서_평균
    FROM hr.employees
    GROUP BY department_id
) tbl
INNER JOIN hr.employees e ON tbl.department_id = e.department_id
WHERE e.salary < tbl.부서_평균
ORDER BY 1,2;






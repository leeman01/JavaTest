/* [서브쿼리 문제] */

USE hr;

-- 1. SELF JOIN을 사용하여 'Oliver' 사원의 부서명, 그 사원과 동일한 부서에서
-- 근무하는 동료 사원의 이름을 조회. 단, 각 열의 별칭은 부서명, 동료로 할 것. (서브쿼리로!)
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
-- 2. 사원번호가 109인 사원보다 급여가 많은 사원을 표시(사원이름과 담당) 조회하시오.
SELECT salary 
FROM hr.employees e 
WHERE e.employee_id =109 ;

SELECT e.first_name ,j.job_title ,e.salary 
FROM hr.employees e INNER JOIN hr.jobs j 
ON e.job_id =j.job_id 
WHERE e.salary  >(SELECT salary 
FROM hr.employees e 
WHERE e.employee_id =109 );
-- 3. 최소 급여를 받는 직원과 같은 급여를 받는 사원의 이름, 담당업무명, 급여를 조회하시오.
-- (그룹함수 사용 + 서브쿼리 + 조인)
SELECT min(salary)
FROM hr.employees e ;

SELECT e.first_name ,e.job_id ,e.salary 
FROM hr.employees e 
WHERE salary = (SELECT min(salary)
FROM hr.employees e );
-- 4. 전체 평균 급여보다 적은 급여를 받은 사원들의 담당 업무를 찾아 담당업무(JOB_ID)와 급여를 조회하시오.
SELECT avg(salary)
FROM hr.employees e ;

SELECT e.job_id,e.salary 
FROM hr.employees e 
WHERE salary <(SELECT avg(salary)
FROM hr.employees e );

-- 5. 담당 업무가 IT_PROG인 사원보다 급여가 적으면서 업무가 IT_PROG가 아닌 사원들을 조회(사원번호, 이름, 담당업무) 하시오
SELECT salary 
FROM hr.employees e 
WHERE e.job_id  = 'IT_PROG';

SELECT e.first_name ,j.job_title ,e.employee_id 
FROM hr.employees e INNER JOIN hr.jobs j 
ON e.job_id =j.job_id 
WHERE e.salary <ANY (SELECT salary 
FROM hr.employees e 
WHERE e.job_id  = 'IT_PROG');


-- 6. 성이 'Chen'과 동일한 부서에 있는 사원의 이름과 입사일을 조회하시오
SELECT  e.department_id 
FROM hr.employees e 
WHERE e.last_name ='Chen';

SELECT ALL e.first_name ,e.department_id ,e.hire_date 
FROM hr.employees e   
WHERE e.department_id =(SELECT  e.department_id 
FROM hr.employees e 
WHERE e.last_name ='Chen');


-- 7. 급여가 평균 급여보다 많은 사원들의 사원번호와 이름을 표시하되 결과를 급여에 대해 오름차순으로 정렬하시오
SELECT avg(salary)
FROM hr.employees e ;

SELECT e.employee_id ,e.first_name 
FROM hr.employees e 
WHERE salary  >(SELECT avg(salary)
FROM hr.employees e )
ORDER BY salary ;
-- 8. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원번호와 이름을 표시하는 질의를 작성하시오
SELECT department_id 
FROM hr.employees e 
WHERE first_name LIKE '%k%';

SELECT e.employee_id ,e.first_name ,e.department_id 
FROM hr.employees e 
WHERE department_id in (SELECT department_id 
FROM hr.employees e 
WHERE first_name LIKE '%k%');
-- 9. 평균 급여보다 많은 급여를 받고 이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 사원번호,
-- 이름, 급여를 조회하시오.

SELECT avg(salary)
FROM hr.employees e ;


SELECT e.department_id 
FROM hr.employees e 
WHERE salary >(SELECT avg(salary)
FROM hr.employees e 
) AND e.first_name  LIKE '%M%';

SELECT e.employee_id ,e.first_name ,e.salary 
FROM hr.employees e 
WHERE department_id IN (SELECT e.department_id 
FROM hr.employees e 
WHERE salary >(SELECT avg(salary)
FROM hr.employees e 
) AND e.first_name  LIKE '%M%');
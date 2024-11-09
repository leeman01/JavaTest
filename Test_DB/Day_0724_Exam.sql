/* [연습문제] */

-- 1. JOIN을 이용하여 사원ID가 100번인 사원의 부서번호와 부서이름을 출력하시오
USE hr;
SELECT DATABASE () ;
SELECT e.department_id ,d.department_name 
FROM hr.employees e  INNER JOIN hr.departments d 
USING (department_id)
WHERE e.employee_id =100;
-- 2. INNER JOIN을 이용하여 사원이름과 함께 그 사원이 소속된 도시이름과 지역명을 출력하시오

SELECT e.first_name ,l.city,r.region_name 
FROM hr.employees e  INNER JOIN hr.departments d 
USING (department_id)
	INNER JOIN hr.locations l 
	USING (location_id)
		INNER JOIN hr.countries c 
		USING (country_id)
			INNER JOIN hr.regions r 
			using(region_id);
-- 3. INNER JOIN과 USING 연산자를 사용하여 100번 부서에 속하는
-- 직원명과 직원의 담당 업무명, 속한 부서의 도시명을 출력하시오.
-- (100번 부서에는 직원 6명있음)
SELECT e.first_name ,j.job_title ,l.city 
FROM hr.employees e  INNER JOIN hr.jobs j 
USING (job_id)
	INNER JOIN hr.departments d 
	USING (department_id)
		INNER JOIN hr.locations l 
		USING (location_id)
WHERE  e.department_id =100;

-- 연속적인 where and 문 사용 가능하다
SELECT e.first_name ,j.job_title ,l.city 
FROM hr.employees e ,hr.departments d ,hr.jobs j ,hr.locations l 
WHERE 
	e.department_id =100
AND
j.job_id =e.job_id 
AND
e.department_id  = d.department_id 
AND
d.location_id  = l.location_id ;

-- 4. JOIN을 사용하여 커미션을 받는 모든 사원의 이름, 부서ID, 도시명을 출력하시오
SELECT e.department_id ,e.department_id ,l.city 
FROM hr.employees e  INNER JOIN hr.departments d 
USING (department_id)
	INNER JOIN hr.locations l 
			USING (location_id)
WHERE e.commission_pct  IS NULL;

-- 5. INNER JOIN과 와일드카드를 사용하여 이름에 A가 포함된 모든 사원의 이름과 부서명을 출력하시오(단, 대소문자 구분 없음)
SELECT e.first_name ,d.department_name 
FROM hr.employees e  INNER JOIN hr.departments d 
USING (department_id)
WHERE e.first_name  LIKE '%A%';
-- 6. JOIN을 사용하여 Seattle에 근무하는 모든 사원의 이름, 업무, 부서번호 및 부서명을 출력하시오
SELECT e.first_name ,j.job_title ,d.department_id ,d.department_name ,l.city 
FROM hr.employees e  JOIN hr.jobs j 
USING (job_id)
	 JOIN hr.departments d 
	USING (department_id)
		JOIN hr.locations l 
		USING (location_id)
WHERE  l.city ='Seattle';

-- 7. SELF 조인을 사용하여 사원의 이름 및 사원번호와 매니저 이름 및 매니저 번호와 함께 조회하시오. (이미 풀었던 문제임)


-- 8. OUTER JOIN, SELF JOIN을 사용하여 관리자가 없는 사원을 포함하여 사원번호를 기준으로 내림차순 정렬하여 조회


-- 9. SELF JOIN을 사용하여 'Oliver' 사원의 부서명, 그 사원과 동일한 부서에서 근무하는 동료 사원의 이름을 조회.
-- 단, 각 열의 별칭은 부서명, 동료로 할 것.
SELECT   e2.first_name ,e2.department_id ,d.department_name 
FROM hr.employees e 
	INNER JOIN hr.employees e2 
ON e.department_id = e2.department_id 
	INNER JOIN hr.departments d 
	ON e2.department_id  = d.department_id 
WHERE e.first_name ='Oliver' ;

SELECT department_id 
FROM hr.employees e 
WHERE first_name ='Oliver';

SELECT e.first_name, d.department_name
FROM hr.employees e
JOIN hr.departments d
USING (department_id)
WHERE e.department_id = (
    SELECT e2.department_id
    FROM hr.employees e2
    WHERE e2.first_name = 'Oliver'
);

-- 10. SELF JOIN을 사용하여 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 매니저 이름 및 입사일과 함께 출력하시오
SELECT e.first_name
FROM hr.employees e 
	INNER JOIN hr.employees e2
	ON e.manager_id =e2.employee_id
WHERE 	 e.hire_date < e2.hire_date ;

-- 11. Last name이 ‘King’을 Manager로 둔 사원의 이름과 급여를 조회하시오.
SELECT e.first_name ,e.salary 
FROM hr.employees e 
	INNER JOIN hr.employees e2 
ON e.manager_id =e2.employee_id
WHERE e2.last_name ='King';
-- 12. Finance부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오
SELECT  e.department_id ,e.first_name,jh.job_id ,j.job_title 
FROM hr.employees e 
	INNER JOIN hr.departments d 
	using(department_id)
		INNER JOIN hr.job_history jh 
		using(department_id)
			INNER JOIN hr.jobs j 
			ON e.job_id  = j.job_id ;

		
		
		
--    ---------------------------------------------------\







 		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
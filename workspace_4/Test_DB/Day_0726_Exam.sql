/0함수 연습문제 */

USE hr;

-- 1.    모든 사원의 이름과, 전화번호 첫 3자리를 출력하시오.
SELECT substring(e.first_name,1,3) "이름" , substring(e.phone_number,1,3) "전화번호" 
FROM hr.employees e ;
-- 2.    모든 사원의 이름과 성, 그리고 (이름과 성을 합한 글자수)를 출력하시오.
SELECT first_name ,last_name ,concat(last_name,' ',first_name) "Full_name" ,LENGTH(concat(last_name,' ',first_name)) 
FROM hr.employees e ;
-- 3.    모든 사원의 이름과 성의 머리글자만 출력하시오. (예. A.A)
SELECT concat( substring(e.first_name,1,1),'.',substring(e.last_name,1,1)) "요약"
FROM hr.employees e ;
-- 4.    모든 사원의 이름과 성을 대문자로 출력하시오.
SELECT upper(e.first_name) ,upper(e.last_name)
FROM hr.employees e ;
-- 5.    사원의 JOB_ID에 포함된 '_'문자의 위치를 구하고, JOB_ID 에서
--     그 위치 이전까지의 문자열을 사원번호와 함께 출력하시오. (INSTR, SUBSTR 함수 사용)
SELECT  concat(e.employee_id,' ', substring(e.job_id,1,locate('_',job_id)-1))
FROM hr.employees e ;
-- 6.    사원 급여를 30으로 나눈 값을 소수점 둘째 자리에서 반올림하여 출력하시오.
SELECT round(e.salary/30,2)
FROM hr.employees e ;
-- 7.    사원 급여를 30으로 나눈 값을 소수점 아래를 버림 한 후 출력하시오.
SELECT floor(e.salary/30)
FROM hr.employees e ;
-- 8.    2의 10승을 계산하여 출력하시오.
SELECT power(2,10); 
-- 9.    모든 사원의 입사일과, 입사일 이후 100일째 되는 날을 다음과 같은 형식으로 출력하시오.
  SELECT e.hire_date,DATE_ADD(e.hire_date, INTERVAL 100 DAY)  -- adddate를 써도된다
  FROM hr.employees e ;
 
-- 10.    입사일 이후 오늘까지의 날짜수를 다음과 같이 출력하시오. 최근 입사한 사원순으로 정렬.
SELECT datediff(now(),e.hire_date) 
FROM hr.employees e ;
-- 11.    입사일 이후 오늘까지의 개월수를 다음과 같이 출력하시오.
SELECt( YEAR(now())-year(e.hire_date))*12 + (MONTH(now())-MONTH(e.hire_date)) "총개월"
FROM hr.employees e ;
-- 12.    입사일을 다음과 같은 형식으로 출력하시오.
-- 2015년 05월 21일 
SELECT concat(year(e.hire_date),'년',' ',MONTH(e.hire_date),' ','월',' ',DAY(e.hire_date),' ','일')
FROM hr.employees e ;
SELECT date_format(hire_date,'%Y년 %m월 %d일') 
FROM hr.employees e ;
-- 13.    입사일이 3월인 모든 사원의 정보를 출력하시오.
SELECT *
FROM hr.employees e 
WHERE MONTH(e.hire_date)=3;
-- 14.    입사한 달이 홀수인 모든 사원의 정보를 출력하시오.
SELECT *
FROM hr.employees e 
WHERE month(e.hire_date) %2 !=0;
-- 15.    현재 시간을 다음과 같은 형식으로 출력하시오.

SELECT concat(HOUR(now()),'시',' ',MINUTE(now()),'분',SECOND(now()),'초');

-- 16.    급여를 다음과 같은 형식으로 출력하시오.
SELECT concat(format(floor(salary), '#,### '),'달러')
FROM hr.employees e ;

-- 17.    입사일 컬럼의 값이 NULL인 경우 오늘 날짜로 치환하여 출력하시오.
SELECT *
FROM hr.employees e 
WHERE e.hire_date is NOT NULL;







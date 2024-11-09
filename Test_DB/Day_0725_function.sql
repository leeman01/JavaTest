/* 7월 25일 Function(함수)의 사용

/*  문자열 관련 함수
-- 1) asci() , char()
/*
 * 
 */
SELECT  ascii('A'),char(97); 

SELECT bit_length('abc'),char_length('abc'),LENGTH('abc');  -- a 가 1바이트 = 8비트 8비트 * 3 = 24 
SELECT bit_length('가나다'),char_length('가나다'),LENGTH('가나다') -- 한글은 한 글자당 3바이트 필요

SELECT concat('Database ','So Good'); 
-- Steven King 입니다.
SELECT concat(first_name,' ',last_name,' 입니다.') AS "소개"
FROM hr.employees e  ;

-- 반복
SELECT REPEAT ('hello',3);

-- 뒤집기
SELECT reverse('I have a dream! ');

-- 위치찾기(인덱스가 1부터 시작하므로 찾지못햇을 때는 0이 반환된다)
SELECT locate('home','f I can make if I can make your heart my home') ;

SELECT locate('love','f I can make if I can make your heart my home')
-- 3번째 전달값은 찾을 시작위치 값
SELECT locate('care','Throw me to the water I dont care how deep or shallow',5);
-- 테이블을 삽입
SELECT INSERT ('I love you',3,4,'miss');
-- you를 me로 바꾸기

SELECT INSERT ('I love you',8,3,'me');
SELECT locate ('you','I love you!');

-- 위 문장을 하나로 바꾸기
SELECT INSERT ('I love you', locate ('you','I love you!'),3,'me');

--  데이터 추출 : left() right() (문자열,개수)
SELECT LEFT('Throw me to the water I dont care how deep or shallow',9), -- 왼쪽에서부터 9개를 추출
right('Throw me to the water I dont care how deep or shallow',4); -- 왼쪽에서부터 9개를 추출

-- substring (문자열,위치,개수)
SELECT substring('Throw me to the water I dont care how deep or shallow',11,5);
-- 대소문자 변환
SELECT upper('Throw me to the water I dont care how deep or shallow'),
lower('Throw me to the water I dont care how deep or shallow');

-- 치환해주는 함수 : replace(문자열 , 찾을 문자열 , 바꿀 문자열)
SELECT replace('MYSQL','MY','MS');

-- 길이를 구하기
SELECT LENGTH ('      I have a dream!!!!!! '  );

-- 문자열 공백 자르기 : trim()
SELECT trim('      I have a dream!!!!!! ' ),
LENGTH (trim( '  I have a dream!!!!!! ' )),
LENGTH (ltrim( '  I have a dream!!!!!! ' )),
LENGTH (rtrim( '  I have a dream!!!!!! ' ));

-- 문자 추가: leading, trailing ,both

SELECT 
    TRIM(LEADING '~' FROM '~~I have a dream!!!!~~~~~ ') AS LeadingTrim,
    TRIM(TRAILING '~' FROM '~~~~~~~~I have a dream!!!!~~~~') AS TrailingTrim,
    TRIM(BOTH '~' FROM '~~~~~~~~I have a dream!!!!~~~~~ ') AS BothTrim;
SELECT TRIM(BOTH '*' FROM '**** dwwd ****');
-- employee 와 departments 테이블을 이용해 아래와 같이 조회

SELECT concat(e.first_name,'의 부서는',d.department_name) "Full_name"
FROM hr.employees e INNER JOIN hr.departments d 
ON e.department_id =d.department_id 
ORDER BY first_name;

SELECT version(); 

/* 수학관련함수 */
SELECT abs(-45.34),abs(45.23); -- 절대값

SELECT floor(-45.34),floor(45.23); -- 버림 // 음의 방향에서 만나는 첫번째 정수값
SELECT ceil(-45.6534),ceil(45.523);
SELECT truncate(-45.6534,1),truncate(45.523,1); -- 소수점 자릿수에서 버림
SELECT round(-45.6534,1),round(45.523,1); -- 지정된 수수점 자리까지 반올림
-- 최대값, 최소값
SELECT greatest(5,1,8,50) "최대값",least(5,1,8,7,50 )"최소값";

-- 원주율 구하기
SELECT pi();
-- 제곱근 구하기
SELECT sqrt(81);
-- 제곱하기
SELECT power(2,3.5); 

/* 날짜 함수 */
SELECT now(),sysdate();

SELECT curdate(),curtime(); -- 현재 날짜 , 시간 분리해서 보여줌
-- 날짜 데이터를 연도 월 일로 분리해서 조회
SELECT year(sysdate()) , MONTH(sysdate()), day(sysdate());

-- date() , time()  curdate(),curtime();와 유사하다 하지만 curdate(),curtime()를 더 많이 쓴다
SELECT date(sysdate()),time(sysdate());

-- 시, 분, 초 
SELECT HOUR(curtime()),MINUTE (curtime()),SECOND(curtime());
-- 경과시간 계산 datediff(날짜1,날짜2)
SELECT  datediff('1950-6-26','1945-08-15'); 

SELECT  datediff('1945-08-15','1950-06-26'); -- 과거가 앞에 나오면 마이너스 값이 나온다

-- [문제] 오늘부터 수료일까지 몇일이 남음?
SELECT  datediff('2024-11-01',now()) "수료일까지 남은 시간";

SELECT timediff(curtime(),'10:00:00'); -- 경과시간 
SELECT hour(timediff(curtime(),'10:00:00'));
SELECT  concat(hour(timediff(curtime(),'10:00:00')) ,'시간',MINUTE(timediff(curtime(),'10:00:00')),'분이 지남' ) "총 경과한 시간";

SELECT  dayofweek(sysdate()); -- 달력상에선 일요일이 시작이라 일요일 =1이다 

SELECT monthname(sysdate()); -- 월 이름 

-- 기타함수
/* 기타함수 */
-- employees 테이블에서 제공하는 salary를 이용하여 회사급여 평균을 찾아 변수에 저장한다
SET @salavg:=(SELECT avg(e.salary) FROM hr.employees e );

SELECT @salavg;

-- 직원의 급여가 평균보다 많은지 아닌지 출력하는 코드를 작성
SELECT first_name ,salary,@salavg AS "평균",if(salary>@salavg , "많다","적다")  AS "비교"
FROM hr.employees e ;

-- [문제] ifnull
--  manager_id가 null인 사람은 " 팀장없음"
SELECT first_name,ifnull(manager_id,"팀장없음") 
FROM hr.employees e ;

-- [연습] departments테이블에서 매니저 이름을 출력하시오
SELECT d.department_id, d.department_name,ifnull(e.first_name,"매니저없음") 
FROM hr.departments d 
LEFT OUTER JOIN hr.employees e 
ON d.manager_id = e.employee_id;

COMMIT;
-- 그룹핑
USE hr;

SELECT count(*) FROM hr.employees e ;-- 전체 레코드수
SELECT count(manager_id) FROM hr.employees e ;-- 매니저 레코드수 , null값은 세지 않아서 106개 나옴
SELECT count(*),count(manager_id) FROM hr.employees e ;-- 매니저 레코드수 , null값은 세지 않아서 106개 나옴

-- sum 합계구하기 avg 평균구하기  min 최소값 max 최대값  
SELECT sum(salary), avg(salary),min(salary),max(salary)     FROM hr.employees e ;

-- 각 부서별 그룹화후 sum 합계구하기 avg 평균구하기  min 최소값 max 최대값  
SELECT department_id ,sum(salary), round(avg(salary),2),min(salary),max(salary)     FROM hr.employees e GROUP BY e.department_id ;

-- 그룹화정보와 관계없는 걸 넣으면 오류 => 원하는 정보를 그룹화하더라도 결과가 바람직하게 나오지는 않는다
SELECT department_id  ,sum(salary), round(avg(salary),2),min(salary),max(salary)     
FROM hr.employees e 
GROUP BY e.department_id ;

-- 그룹핑 된정보에 조건 주기
SELECT department_id  ,sum(salary), round(avg(salary),2),min(salary),max(salary)     
FROM hr.employees e 
GROUP BY e.department_id 
HAVING avg(salary)>5000; -- WHERE 가 아닌 having이어야한다

-- [문제] hr 데이터베이스내에 있는 여러 테이블을 이용하여 그룹핑
 -- 1) countries 테이블을 이용하여 몇개의 나라가 등록되있는지
SELECT count(*) FROM hr.countries c  ;
-- 2) countires 테이블의 country_id 값이 locations 테이블에서 사용됨=> 나라별로 도시를 묶을수 있다, 각 나라별 도시의개수와 나라이름
SELECT count(city),c.country_name 
FROM hr.locations l INNER JOIN hr.countries c 
USING (country_id)
GROUP BY country_id ;


-- 부서별 최대 최소 급여를 조회 부서번호
SELECT  max(salary),min(salary),department_id 
FROM hr.employees e 
GROUP BY department_id ;
-- Job_id 별 급여의 평균과 아이디를 조회
SELECT  avg(salary),job_id 
FROM hr.employees e 
GROUP BY job_id ;
-- 부서의 인원수가 없거나 1명인 부서를 제외하여 조회하시오
SELECT count(department_id),e.department_id 
FROM hr.employees e 
GROUP BY department_id 
HAVING count(department_id)>1  AND count(department_id) IS NOT NULL;

-- 입사년도별 입사인원이 가장 적은 해의 정보

SELECT count(employee_id),year(hire_date)
FROM hr.employees e 
GROUP BY YEAR(hire_date) 
ORDER BY 2;

SELECT min(입사인원) FROM 
(SELECT count(employee_id) AS "입사인원",year(hire_date)
FROM hr.employees e 
GROUP BY YEAR(hire_date) 
ORDER BY 1) temp ;

SELECT YEAR(hire_date), count(*)
FROM hr.employees e 
GROUP BY YEAR(hire_date)
HAVING count(hire_date) = (
    SELECT min(입사인원)
    FROM (
        SELECT YEAR(e.hire_date) AS "입사년도", count(*) AS "입사인원"
        FROM hr.employees e 
        GROUP BY YEAR(e.hire_date)));
    















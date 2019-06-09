***참고*** - *오라클 DB를 깨끗하게 지우려면*

>1. 서비스(services.msc)에러 Oracle~ 서비스 시작되어 있는 것 모두 중지
>
>2. 레지스트리에서 Oracle 관련 정보 삭제
>
>   a. regedit
>
>   b. HKEY_LOCAL_MACHINE > SOFTWARE > Oracle 디렉토리 삭제
>
>   c. HKEY_LOCAL_MACHINE > System > CurrentControlSet > services > Oracle 디렉토리들삭제
>
>   d. HKEY_LOCAL_MACHINE > System > CurrentControlSet > services > event log > Applicatoin Oracle 디렉토리들 삭제
>
>3. 탐색기 C:\Program Files 아래 Oracle 디렉토리 삭제
>
>4. 윈도우 프로그램 메뉴 Oracle 메뉴 디렉토리 삭제
>
>5. C:\app 삭제



#### 복습 (summary)

- Database 정의

- DBMS

- 계층형-망형-관계형-객체관계형-클러스터로 구성

- Table - Column(Attribute) + Row(Record)

- Primary Key - Not NULL + Unique

- Foreign Key - 다른 table의 PK를 참조하는 현재 table의 속성

- null - 아직 값이 할당되지 않음을 의미. 0이 아니며 ' '도 아니다. 

  - 산술/논리 연산 결과는 항상 null
  - nvl(대상컬럼, 원하는결과값) 함수를 사용해서 처리

- SQL(Structured Query Language) - 선언적 언어, 결과 기술

  - DML - select, update, insert, delete
  - DDL - create, alter, drop, truncate, rename, comment
  - DCL - grant, revoke
  - TCL - commit, rollback, savepoint

- 전형적 검색 구문 구조

  ```
  select * | [distinct] column... | expression [as] Alias
  from 테이블명
  [where 조건]
  ...
  [group by 조건]
  [order by columnn [asc|desc]]
  
  ```

- 테이블 구조 확인 - desc, describe

- 컬럼 타입

  - char(size)
  - varchar2(size)
  - number(p, s)
  - date
  - timestamp
  - timestamp with timezone
  - interval year to month
  - interval day to second
  - rowid

- 컬럼 타입에 따른 연산

  - char/varchar2 -  결합연산자(||)
  - number - 산술연산자
  - date - ±n, ±1/24, date-date

- where 절 연산자

  - in (.., .., ...)
  - like - 문자패턴비교. _, %
  - between 하한값 and 상한값 - 범위연산자
  - is null, is not null
  - 조건이 여러개 이면 논리 연산자(not, and, or)로 결합합니다.

- order by 컬럼|표현식|별칭|column-position;

- 함수 - 반드시 하나의 값을 리턴한다

  - 단일행함수 - character, number, date, conversion
  - 복수행함수
  - 분석(window)함수



---

#### 기타함수

- nvl(column, expression)

  column과 expression이 동일한 타입이어야 한다.

  

- nvl(column, expression1, expression2)

  ex1과 ex2가 동일한 타입이어야한다.

  

- coalesce(column, expression1, expression2, ...)

  최초의 NULL이 아닌 값을 리턴

  

- nullif(expression1, expression2)

  expression1과 , expression2가 동일한 타입이어야한다.

  값이 동일하면 NULL, 다르면 expression1을 리턴한다.

```sql
--문> 사원들 중 커미션을 받지 않는 사원들은 -1으로 출력해보자(이름, 급여, COMM)
select empno, ename, comm, nvl(comm, -1) as comm2 from emp;

--문> 사원들 중 커미션을 받는 사원은 급여+커미션을 출력하고, 커미션을 받지 않는 사원은 'No Commision'을 출력합니다(이름, 급여, 커미션, 비고)
select empno, ename, sal, comm, nvl2(comm, to_char(sal+comm), 'No Commision') as 비고 from emp;
```

```sql
--QUIZ> 다음의 결과는? (결과를 예측해 본 후에 확인할 것)

select coalesce(1, null, null, null, null) from dual;
--예측) 1
--결과) 1

select coalesce( null, null, 3, null, null) from dual;
--예측) 3
--결과) 3

select coalesce( null, null, null, null, null, 'a') from dual;
--예측) a
--결과) a

select nullif(100, '100') from dual;
--예측) ERROR
--결과) ERROR

select nullif('A', 'A'), nullif('A', 'a') from dual;
--예측) null, A
--결과) null, A
```



#### 조건처리

- 조건처리 함수 : ***decode*** 함수

  ```decode(column, 표현식1, 리턴값1, 표현식2, 리턴값2,...)```

- 조건처리 표현식 , sql3 : ***case when then [else] end***

  ```case [표현식] when [값|표현식] then 값 [else 값] end ```

```sql
문> 사원들의 부서번호가 10번이면 월급을 5%인상
    부서번호가 20번이면 월급을 10%인상
    부서번호가 30번이면 월급을 3%인상 
    그 외의 부서는 월급 100인상합니다.
    현재의 월급과 인상된 월급을 출력합니다.

-- decode
select ename, deptno, sal,
	decode(
        deptno,
        10, sal*1.05,
        20, sal*1.1,
        30, sal*1.03,
        sal+100
    ) as "Increase"
from emp;

--case when then end
select ename, deptno, sal,
	case deptno
        when 10 then sal*1.05
        when 20 then sal*1.1
        when 30 then sal*1.03
        else sal+100
	end as "Increase"
from emp;
```

```sql
--문> 월급에 대한 세금 출력하시오
    월급이 1000미만이면 0,  
    2000미만이면 월급의 5%, 
    3000미만이면 월급의10%
    4000미만이면 월급의15%, 
    4000이상이면 월급의 20%
    
--decode
select empno, ename, sal,
    decode(trunc(sal/1000),
        0, 0,
        1, sal*0.05,
        2, sal*0.1,
        3, sal*0.15,
        sal*0.2
    ) as 세금
from emp;    

--case when then end
select empno, ename, sal,
    case
        when sal < 1000 then 0
        when sal < 2000 then sal*0.05
        when sal < 3000 then sal*0.1
        when sal < 4000 then sal*0.15
        else sal*0.2
    end as 세금
from emp; 

```



#### 그룹함수

*그룹핑된 행 집합, 테이블의 전체 행 집합의 컬럼이 함수의 인수로 전달되고 결과는 반드시 1개 리턴*

- sum(number 타입| expression)
- avg(number 타입 | expression)
- min(number, char, date 컬럼타입 |expression)
- max(number, char, date 컬럼타입 |expression)
- count([distinct]number, char, date컬럼타입 | expression) - null 아닌 값의 갯수 리턴
- stdev(number 타입 | expression) - 표준편차
- variance(number 타입 | expression)  - 분산

```sql
--문> 전체 사원의 급여 합계, 평균, 최대값, 최소값 결과 출력
select sum(sal), avg(sal), max(sal), min(sal) from emp;

--문> 전체 emp 테이블의 행수?
select count(*), count(empno) from emp;

--문> 전체 사원들 중에서 가장 빠른 입사 날짜와 가장 최근의 입사 날짜는?
select min(hiredate), max(hiredate) from emp;

--문> 전체 사원들 중에서 이름순서가 가장 빠른 사원의 이름과 이름 순서가 가장 늦은 사원의 이름
select min(ename), max(ename) from emp;

--문> 사원들이 소속된 부서의 종류의 수 출력?
select count(distinct deptno) from emp;

--문> 커미션을 받는 사원 수는?
select count(comm) from emp;
select count(ename) from emp where nvl(comm, -1) >= 0;

--문> 전체 사원들의 커미션의 평균은?
select sum(comm)/count(*), avg(nvl(comm, 0)) from emp;
```



***그룹함수는 그룹핑된 컬럼하고만 같이 쓸 수 있다***

```sql
--문> 부서번호와 부서의 평균 급여를 함께 출력
select deptno, avg(sal) from emp group by deptno;

--group by 된 컬럼이 꼭 select 절에 오지 않아도 무방하다
select deptno, avg(sal) from emp group by deptno;

--group by 절에는 column명만 선언할 수 있다.

--문> 부서와 직무별 급여 평균 출력
select deptno, job, avg(sal) from emp group by deptno, job;


--문> 각 부서별로 인원수, 급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력하여라
select 
	deptno, count(ename), avg(sal), 
	min(sal), max(sal), sum(sal)
from 
	emp
group by 
	deptno
order by 
	sum(sal) desc
```



***※ 그룹함수의 조건은 having절에 선언합니다.***

*조건을 where 절에 쓸 수 없다!!!*

```sql
--문> EMP 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호 , 인원수, 급여의 합을 출력하여라
select deptno, avg(sal)     --4
from emp                    --1
where ~                     --2 (filter 조건)
group by deptno;            --3

-- 그래서
select 
	deptno, count(*), sum(sal)
from 
	emp
group by 
	deptno
having 
	count(*) > 4;
```

```sql
--문> EMP 테이블에서 급여가 부서별 최대 급여가 2900 이상인 부서에 대해서 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
select 	deptno, avg(sal), sum(sal)
from emp
group by deptno
having max(sal) >= 2900;

--문> EMP 테이블에서 업무별 급여의 평균이 3000 이상인 업무에 대해서 업무명, 평균 급여, 급여의 합을 구하여 출력하여라.
select job, avg(sal), sum(sal)
from emp
group by job
having avg(sal) >= 3000;

```



###### 연습문제 - 망

```sql
--1
select last_name, salary 
from employees 
where salary > 12000;

--2
select last_name, department_id 
from employees 
where employee_id = 176;

--3
select last_name, salary
from employees
where salary >12000 or salary < 5000;

--7
select last_name, hire_date 
from employees
where hire_date like '94%';

--8
select last_name, job_id
from employees
where manager_id is null;


--9
select last_name, salary, commission_pct
from employees
where commission_pct is not null
order by salary desc , commission_pct desc;


--10
select last_name, salary
from employees
where salary > &emp_sal;

```



###### 연습문제 2

```sql
--1 true?
--2 false?
--3 true?

--7
select count(distinct manager_id) from employees;

--8
select max(salary) - min(salary) 
from employees;

--9
select manager_id, min(salary) 
from employees
group by manager_id
having 
    manager_id is not null and
    min(salary) > 6000
order by min(salary) desc;


--10
select 
    count(employee_id) as "TOTAL",
    count(
        CASE 
        WHEN hire_date like '95%' THEN 1
        END
    ) as "1995",
    count(
        CASE 
        WHEN hire_date like '96%' THEN 1
        END
    ) as "1996",
    count(
        CASE 
        WHEN hire_date like '97%' THEN 1
        END
    ) as "1997",
    count(
        CASE 
        WHEN hire_date like '98%' THEN 1
        END
    ) as "1998"
from employees;


--11
select distinct 
    job_id,
    sum(
        CASE
        WHEN department_id = 20 THEN salary
        END
    ) as "Dept 20",
    sum(
        CASE
        WHEN department_id = 50 THEN salary
        END
    ) as "Dept 50",
    sum(
        CASE
        WHEN department_id = 80 THEN salary
        END
    ) as "Dept 80",
    sum(
        CASE
        WHEN department_id = 90 THEN salary
        END
    ) as "Dept 90",
    sum(salary) as "Total"
from employees
group by job_id
order by job_id;

```





---

### JOIN

```
employees, emp - 사원정보
departments, dept - 부서정도

이 경우 '사원이름, 부서번호, 부서이름' 을 가져오려면 join을 수행하여야합니다.
```

- oracle join syntax
- sql1999 표준 syntax
- equi join (inner join)
- non-equi join
- self-join (자기 참조가 가능한 테이블에서만 수행가능)
- outer join (조인 컬럼값이 null인 경우 결과집합에 포함시키기 위한 조인)

***※ 조인 조건을 잘못 정의하거나, 조인 조건을 누락하면 cartesian production(cross join)이 일어나므로 주의해야한다***



#### Inner Join

```sql
--문> 사원이름, 부서번호, 부서이름
select last_name, department_id, department_name


--####1. 조인 조건 누락
select 
    v1.last_name, v1.department_id, v2.department_name
from 
    employees v1, departments v2
-- => cartesian product가 일어남


--####2. where 절에 조건 넣기
select 
    v1.last_name, v1.department_id, v2.department_name
from 
    employees v1, 
    departments v2
where 
    v1.department_id = v2.department_id;
    
    
--####3. Natural Join
--natual join 은 oracle 서버가 조인할 테이블에서 동일한 이름의 컬럼으로 자동 equi 방식 조인을 수행합니다.
--natual join 은 조인할 테이블에서 동일한 이름의 컬럼 앞에 소유자 테이블명 또는 alias를 선언하지 않습니다.
--natual join 은 동일한 속성이지만, 설계할때 부모와 자식 테이블에서 이름을 다르게 정의하면 조인 수행 안됩니다
select 
    last_name, department_id, department_name
from 
    employees a natural join departments b;
    

--####4. Join Using 사용
select 
    a.last_name, department_id, b.department_name
from 
    employees a join departments b 
using 
    (department_id);
    
    
---#### Inner Join
select 
	a.empno, a.ename, b.deptno, b.dname
from 
	emp a  inner join  dept b on a.deptno = b.deptno;


-- 준비작업
conn scott/oracle
create table copy_emp
as select empno , ename, job, hiredate, sal, mgr, deptno deptid
from emp;

drop table copy_emp purge;  --테이블 삭제



--문> copy_emp와 dept테이블에서 사번, 이름, 부서번호, 부서명 출력
--####5. Join On 사용
select 
	a.empno, a.ename, b.deptno, b.dname
from 
	copy_emp a join dept b on a.deptid = b.deptno;
-- ***on 절을 사용한다***



--문> 사원이름, 급여, 급여의 등급을 조회 출력
--####6. Non-euqi Join
select 
	a.ename, a.sal, b.grade
from
	emp a, salgrade b
where 
    a.sal between b.losal and b.hisal;
    
select 
	a.ename, a.sal, b.grade
from 
	emp a join salgrade b
on
	a.sal between b.losal and b.hisal;


--문> 사원번호 사원이름 관리자번호 관리자 이름을 출력
--####7. Self Join
select 
	a.empno, a.ename, a.mgr, b.ename
from 
	emp a join emp b on a.mgr = b.empno;


conn hr2/oracle
desc employees
desc departments
desc locations
-- ※※※※ n개의 테이블을 조인할 때 최소 조인 조건은 최소 n-1개 ※※※※
--문> 사원이름, 소속 부서이름, 부서가 위치한 도시를 출력
select 
	a.last_name, b.department_name, c.city
from 
	employees a, departments b, locations c
where 
	a.department_id = b.department_id 
	and 
	b.location_id = c.location_id;
	
	
select
	a.last_name, b.department_name, c.city
from 
	employees a 
	join  departments b on a.department_id = b.department_id 	 join locations c  on   b.location_id = c.location_id;
    
```



#### Outer Join

```sql
conn scott/oracle
insert into emp (empno, ename) values (8000, 'Hong');


--문> 부서번호가 없는 사운을 포함해서 사원들의 부서이름을 함께 출력
--틀린 예
select 
a.empno, a.ename, a.deptno, b.dname
from 
	emp a, dept b
where 
	a.deptno = b.deptno;

--맞는 예
select 
	a.empno, a.ename, a.deptno, b.dname
from 
	emp a, dept b
where 
	a.deptno = b.deptno(+);

--SQL1999
select 
	a.empno, a.ename, a.deptno, b.dname
from 
	emp a left outer join dept b on a.deptno = b.deptno;


--문> 부서정보를 기준으로 부서의 소속 사원을 출력하고, 소속 사원이 벗는 부서도 출력합니다.
--틀린 예
select 
	b.deptno, b.dname, a.empno, a.ename
from 
	emp a, dept b
where 
	a.deptno = b.deptno
order by 
	b.deptno;

--맞는 예
select 
	b.deptno, b.dname, a.empno, a.ename
from 
	emp a, dept b
where 
	a.deptno(+) = b.deptno
order by 
	b.deptno;
	
--SQL1999
select 
	b.deptno, b.dname, a.empno, a.ename
from 
	emp a right outer join dept b on a.deptno = b.deptno
order by 
	b.deptno;

--오류 문장
select 
	b.deptno, b.dname, a.empno, a.ename
from 
	emp a, dept b
where 
	a.deptno(+) = b.deptno(+) -- 양쪽에 할 수 없음!!!
order by 
	b.deptno;

-- SQL1999 인 경우 full <--- 로 가능하다!!!
select 
	b.deptno, b.dname, a.empno, a.ename
from 
	emp a full outer join dept b on a.deptno = b.deptno
order by 
	b.deptno;

```



###### 연습문제 - exercise3.docx

```sql
--1
select 
    location_id, street_address, city, 
    state_province, country_name
from 
	locations a natural join countries b;
	
	
--2
select 
	a.last_name, a.department_id, b.department_name
from 
	employees a, departments b
where 
	a.department_id = b.department_id
order by 
	a.department_id;

select 
	a.last_name, a.department_id, b.department_name
from 
	employees a join departments b on a.department_id = 		b.department_id
order by 
	a.department_id;
	
	
--3
select last_name, job_id, a.department_id, b.department_name
from
    employees a 
    join departments b on a.department_id = b.department_id
    join locations c on b.location_id = c.location_id
where 
	c.city = 'Toronto';


--4
select
    a.last_name as "Employee",
    a.employee_id as "EMP#",
    b.last_name as "Manager",
    b.employee_id as "Mgr#"
from 
	employees a , employees b 
where 
    a.manager_id = b.employee_id;
    
    
select
    a.last_name as "Employee",
    a.employee_id as "EMP#",
    b.last_name as "Manager",
    b.employee_id as "Mgr#"
from 
	employees a 
	join employees b on a.manager_id = b.employee_id;


```








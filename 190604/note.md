#### 복습

- 그룹함수

  ```sql
  select ~			   --5
  from ~				   --1
  [where 필터조건]		--2
  [group by 컬럼, ...]    --3
  [having ~ ]            --4
  ```

  - 여러 행의 컬럼이 함수의 인수로 전달되고, 함수의 결과는 한개(ex: sum, avg, min, max, count, stddev, variance)

  - ***그룹 함수는 null을 연산에 포함시키지 않습니다.***
    - count(column) - null이 아닌 개수를 리턴
    - count(*) - 테이블의 행수를 리턴, 내부적으로 not null 또는 PK 제약조건이 선언된 컬럼을 기준으로 카운팅합니다.

  - 그룹함수(all | distinct 컬럼)
  - ***그룹함수를 적용한 컬럼과 그룹함수를 적용하지 않은 컬럼이 select절에 선언될 경우 group by 절에 그룹함수를 적용하지 않은 컬럼을 반드시 선언해 줘야 합니다.***
  - ***그룹함수의 조건은 having 절에 선언합니다***

- 검색방법 - Projection, join

  - Join

    하나 이상의 테이블에서 동일한 속성의 컬럼값이 일치할 때 테이블의 row를 결합해서 결과집합으로 생성

    - inner join = equi join
    - non-equi join
    - self join (자기 참조가 가능한 테이블)
    - outer join - 일치하는 조인컬럼값이 null인 row도 조인 결과로 생성하려면
    - cartesian product - 조인 조건을 생략하거나, 조인 조건을 논리적으로 잘못 지정하여 두 테이브르이 모든 row가 한 번씩 join되는 것

  - 오라클 초기 버전부터 사용 했었떤 조인 구문

    ```sql
    where 조인조건
    
    --cartesian product
    select e.ename, e.deptno, d.dname
    from emp e, dept d;
    
    --부서번호가 null인 사원데이터를 조인 결과에 포함하려면
    select e.ename, e.deptno, d.dname
    from emp e, dept d
    where e.deptno = d.deptno(+)
    
    --소속 사원이 없는 부서정보를 조인 결과에 포함하려면
    select e.ename, e.deptno, d.dname
    from emp e, dept d
    where e.deptno(+) = d.deptno
    
    --부서번호가 null인 사원데이터를 와 소속 사원이 없는 부서정보를 조인 결과에 모두 포함하려면
    select e.ename, e.deptno, d.dname
    from emp e, dept d
    where e.deptno(+) = d.deptno(+) -- 에러발생!!!!!
    ```

  - 오라클에서 지원하는 sql1999 조인 구문

    ```sql
    --컬럼 명이 같은 경우
    from tab1 a natural join tab2 a
    from tab1 a join tab2 a using (조인 컬럼명)
    
    --컬럼 명이 다를 경우
    from tab1 a join tab2 b on a.col = b.col2
    from tab1 a join tab1 b on a.col = g.col2
    
    --cartesian product
    select e.ename, e.deptno, d.dname
    from emp e cross join dept d;
    
    --부서번호가 null인 사원데이터를 조인 결과에 포함하려면
    select e.ename, e.deptno, d.dname
    from emp e left outer join dept d  on e.deptno = d.deptno;
    
    --소속 사원이 없는 부서정보를 조인 결과에 포함하려면
    select e.ename, e.deptno, d.dname
    from emp e right outer join dept d  on e.deptno = d.deptno;
    
    --부서번호가 null인 사원데이터를 와 소속 사원이 없는 부서정보를 조인 결과에 모두 포함하려면
    select e.ename, e.deptno, d.dname
    from emp e full outer join dept d  on e.deptno = d.deptno;
    ```

  - N개의 테이블을 조인 하려면 최소 조인조건은 N-1개





---

### Subquery

조건 값을 알수 없어서 query를 2번 수행해야 하는 경우 subquery를 활용할 수  있습니다.

```subquery = inner query = nested query```

- subquery 는 mainquery의 select절, from절,  where절,  having절, order by 절에 subquery가 정의될 수 있습니다.
- where 절과 having절의 subquery는 연산자 오른쪽에 ()안에 정의합니다.
- 단일 행을 리턴하는 subquery : *single row wubquery*
- 복수 행을 리턴하는 subquery : *multiple row subquery*
- 단일 행, 단일 컬럼값을 리턴 subquery : *scalar subquery*
- 두개 이상의 컬럼 값을 리턴하는 subquery : *multiple column subquery*
- where 절에 single row subquery를 사용할 경우 반드시 single row operator를 사용: ***>, >=, <=, < =, <>***
- where 절에 multiple row subquery를 사용할 경우 반드시 multiple row operator를 사용:  ***in, any, all***

```sql
--문> ADAMS 보다 급여를 만ㅁㅎ이 받는 사원
select 
	ename, sal
from 
	emp
where 
	sal > (select sal from emp where ename = 'ADAMS');
	
	
--문> 사원번호 7839번과 동일한 직무를 담당하는 사원정보 검색
select
    ename, job
from 
    emp
where 
	job = (select job from emp where empno = 7839);


--문> emp 테이블에서 최소 월급을 받는 사원 정보 검색
select 
	*
from 
	emp
where 
	sal = (select min(sal) from emp);


--문> emp 테이블에서 전체 사원 평균 월급보다 급여가 적게 받는 사원 검색
select 
    *
from 
    emp
where 
	sal < (select avg(sal) from emp);


--문> EMP 테이블에서 사원번호가 7521인 사원과 업무가 같고 급여가 7934인 사원보다 많은 사원의 사원번호, 이름, 담당업무, 입사일자, 급여를 조회하라
select
    empno, ename, job, hiredate, sal
from
    emp
where 
    job = (select job from emp where empno = 7521)
    and
    sal > (select sal from emp where empno = 7934);


--문> EMP 테이블에서 부서별 최소 급여가 20번 부서의 최소 급여보다 많 은 부서의 부서번호와 부서의 최소급여를 조회하라.
select 
    deptno, min(sal)
from 
    emp
group by 
	deptno
having 
	min(sal) > (select min(sal) from emp where deptno = 20);
   
   
--문> 10번부서 사원의 월급과 동일한 월급을 받는 다른 부서의 사원을 검색하시오
--multiple row subquery의 값을 =, or로 비교하려면 in 연산자를 사용합니다.
select 
    *
from 
    emp
where 
	sal in (select sal from emp where deptno = 10)
	and
	deptno != 10;


--문>부서별로 가장 급여를 많이 받는 사원의  사원번호 , 이름, 급여, 부서번호를 조회하라
--multiple column subquery, pair-wise 비고
select
    empno, ename, deptno, sal
from 
    emp
where 
	(deptno, sal) 
	in 
	(
        select 
        	deptno, max(sal) 
        from 
        	emp 
        group by 
        	deptno
    );


--문>업무가 SALESMAN인 최소 한명 이상의 사원보다 급여를 많이 받는 사원의 이름,  급여, 업무를 조회하라
select
    ename, sal, job
from 
    emp
where 
	sal > any (select sal from emp where job = 'SALESMAN')
    and 
    job <> 'SALESMAN';



--문>업무가 SALESMAN인 모든 사원이 받는 급여보다 급여를 많이 받는 사원의 이름,  급여, 업무를 조회하라
select
    ename, sal, job
from 
    emp
where 
	sal > all (select sal from emp where job = 'SALESMAN')
    and 
    job <> 'SALESMAN';



--문> 직무별 평균 급여중에서 직무별 평균급여가 가장 작은 직무를 조회하시오 (직무, 평균월급)
select job, avg(sal)
from 
    emp
group by 
	job
having 
	avg(sal) = (select min(avg(sal)) from emp group by job)


--문> 부서번호 80번 사원들중에서 월급이 높은 3사람을 조회하시오
select 
	rownum, empno, sal
from (
    	select empno, sal 
    	from emp 
    	order by sal desc
	)
where 
	rownum < 4;

--hr/oracle
select 
    rownum, employee_id, department_id,last_name, salary
from (
        select * 
    	from employees
    	where department_id = 80
    	order by salary desc
	)
where 
	rownum < 4;



--문>subquery를 사용해서 관리자인 사원들만 검색
select 
	*
from 
	emp
where 
	empno in (
        select distinct mgr from emp
    );



--문>subquery를 사용해서 관리자가 아닌 사원들만 검색
--subquery의 모든 값을 비교해야 하는 연산에서는 null 포함되어 있는지 여부를 먼저 체크해서 null을 처리하거나 제외시켜야 합니다.
select  *
from emp
where empno not in (
        select distinct mgr from emp
        where mgr is not null
    );


--문> 각 부서별로 평균급여보다 급여를 많이 받는 사원 검색 (이름, 부서, 급여) - co-related subquery, join

--join으로 처리
select  a.*
from 
    emp a , (
        select deptno, avg(sal) as avgsal
        from emp
        group by deptno
        ) b
where 
    a.deptno = b.deptno
    and
    a.sal > b.avgsal;
    
--co-related subquery
select 
    a.*
from 
    emp a
where
    a.sal > (
        select avg(sal) 
        from emp 
        where a.deptno = deptno
    );
    
--conn hr/oracle
-- desc employees - 현재 근무부서와 직무
-- desc job_history - 과거 근무햇엇떤 부서, 직무, 기간
--문> 사원들 중에서 2번이상 부서 또는 직무를 변경한 이력이 있는 사원의 사번, 이름을 출력하시오.

--join 으로
select 
	a.employee_id, a.last_name
from 
    employees a 
    join  (
        select 
            employee_id, count(employee_id) as movcnt
        from 
            job_history
        group by
            employee_id
    ) b 
    on
        a.employee_id = b.employee_id
where 
    b.movcnt >= 2;

--co-related subquery 로???

```








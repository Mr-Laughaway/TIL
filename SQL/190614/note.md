### SQL/JDBC 수행평가

#### SQL

```sql
--[SQL]
--1.
desc emp;


--2.
select distinct deptno from emp;


--3.
select to_char(sysdate, 'YYYY"년" MM"년" DD"일"') "Today"
from dual;


--4.
select deptno, count(empno) as "사원수", avg(sal) as "급여평균"
from emp
group by deptno
order by deptno asc;


--5.
select deptno, job, avg(sal)
from emp
group by rollup(deptno, job);


--6.
select ename, deptno, dname, loc
from emp full outer join dept using (deptno);


--7.
select 
    a.employee_id "사번",
    a.first_name "사원 이름",
    a.manager_id "매니저 사번",
    b.first_name "매니저 이름"
from
    employees a,  employees b 
where 
    a.manager_id = b.employee_id
    and
    a.department_id is null;




```



#### JDBC

```java

```


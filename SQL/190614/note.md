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


```



#### JDBC

```java

```


### 복습

- ***subquery***

  - select 문 내부에 정의된 select문(inner query, nested query). 그 밖이나 감싸고 있는 query는 outer query나 main query라고 부른다.
  - 2번 이상 select를 수행해서 결과 집합을 생성해야 할 때
  - 종류
    - single row subquery (게 중에서도 1row 1col을 반환할 때를 scalar subquery라고 부른다)
    - multiple row subquery (게중에도 col이 여러개면 multiple column subquery)
    - subquery가 main query보다 먼저 수행  - 한 번 수행
    - co-related subquery(상관관계 subquery) - subquery가 main query의 컬럼을 참조해서, main query의 행수만큼 subquery 반복적으로 수행
  - subquery가 올 수 있는 위치
    - select 절
    - from 절  - inline view
    - where 절 - 연산자 오른쪽 (subquery)
    - having 절 - 연산자 오른쪽 (subquery)
    - order by 절
  - subquery가 where절이나 having 절에 정의될 때 
    - single row subquery : **<, >, >=, <=, =**
    - multiple row subquery: **in, any <, any >,  all< , all>**
  - **order by 절은 from 절의 inline view 에서만 허용됨**
  - ***rownum*** - 결과행에 순차적인 번호를 발행하는 내장 컬럼. rownum은 order by 전에 발생되므로, order by 후에 rownum으로...

  - co-related subquery(상관관계 subquery)

    ```sql
    select ~~
    from table 1 a
    where column [연산자] (select ~
                      		from table2
                       		where a.column = column2)
    ```

  

- ***with***

  ```sql
  별칭 as (subquery),
  별칭 as (subquery),
  ...,
  별칭 as (subquery)
  select ~
  from ~
  where ~
  ```

  

- ***집합연산자(set operator)*** 

  - 합집합: union, union all
  - 교집합: intersect
  - 차집합: minus

  ```sql
   select ~
   from ~
   [where ~]
   [group by ~]
   [having ~]
   union | union all | intersect | minus
   select ~
   from ~
   [where ~]
   [group by ~]
   [having ~]
  ```

  ※*각 select 문에서 컬럼개수와 컬럼타입이 일치해야 합니다.*

  ※*결과는 첫번째 컬럼 값을 기준으로 정렬된 결과가 리턴되므로 다른 컬럼으로 정렬하려면 order by절은 마지막 select문에만 허용됩니다.*

  - **union**

    각 select의 결과 행에서 중복된 행을 제외하기 위해 sorting 합니다.

  - **intersect**

    각 select의 결과 행에서 중복된 행만 결과로 생성하기 위해 sorting 비교 합니다.

  - **minus**

    첫 번째 select의 결과에만 속한 행을 선택하기 위해 sorting 비교합니다.

  - **union all**

    append 방식

  

- **rollup, cube**

  ```sql
  --문> 전체 사원의 급여 평균
  --	  부서별 사원의 급여 평균
  --    부서와 직무별 사원의 급여 평균
  select to_number(null), to_char(null), avg(sal)
  from emp
  union all
  select deptno, to_char(null), avg(sal)
  from emp
  group by deptno
  union all
  select deptno, job, avg(sal)
  from emp
  group by deptno, job;
  --> 문제점 : full scan, cost 비쌈
  --> 해결방법: rollup 사용
  select deptno, job, avg(sal)
  from emp
  group by rollup (deptno, job);
  
  
  --문> 전체 사원들의 급여 평균과
  --    부서별 사원들의 급여 평균과 
  --    직무별 사원들의 급여 평균과
  --    부서와 직무별 사원들의 급여 평균을 단일 결과 집합으로 출력합니다.
  select to_number(null), to_char(null), avg(sal)
  from emp
  union all
  select deptno, to_char(null), avg(sal)
  from emp
  group by deptno
  union all
  select to_number(null), job, avg(sal)
  from emp
  group by deptno, job
  union all
  select deptno, job, avg(sal)
  from emp
  group by deptno, job;
  --> 문제점 : full scan, cost 비쌈
  --> 해결방법: rollup 사용
  select deptno, job, avg(sal)
  from emp
  group by cube (deptno, job);
  
  ```

  

  ---

  

- **sets**

  rollup 으론 모자르고, cube로는 넘칠 때 사용. 효율이 rollup, cube 만큼 좋진 않지만 쓸만함.

  ```sql
  select deptno, job, mgr, avg(sal)
  from emp
  group by grouping sets ((deptno, mgr), (mgr), (job), ());
  ```

  

- 

  
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
    from table1 a
    where column [연산자] (select ~
                      		from table2
                       		where a.column1 = column2)
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

  

- **grouping sets**

  rollup 으론 모자르고, cube로는 넘칠 때 사용. 효율이 rollup, cube 만큼 좋진 않지만 쓸만함.

  ```sql
  select deptno, job, mgr, avg(sal)
  from emp
  group by grouping sets ((deptno, mgr), (mgr), (job), ());
  ```

  

---



## 10. 데이터를 추가, 수정, 삭제하는 데이터 조작어

```sql
conn scott/oracle
desc dept
```



### insert into ...

- 새로운 데이터를 추가하려면 대상 테이블에 insert권한 또는 테이블의 소유자이어야 한다.

  ```sql
  insert into 테이블명
  values (테이블에 정의된 컬럼 순서대로 모든 값을 선언);
  ```

  

- 새로 추가되는 행의 데이터로 일부 컬럼값만 정의할 경우, 필수 컬럼은 반드시 포함되어야한다.

  ```sql
  insert into dept (dname, loc)
  values ('IT', 'Seoul'); --> ERROR
  ```

  ```sql
  insert into dept (deptno, dname)
  values (50, 'IT');
  select * from dept;
  
  insert into dept
  values (55, 'ERP', null);
  select * from dept;
  
  insert into dept
  values(150, 'HR', null); --> ERROR 컬럼size초과
  
  insert into dept
  values(50, 'HR', null); --> ERROR, deptno(PK)에 중복값...
  
  insert into emp (empno, ename, deptno)
  values (9000, 'Kim', 70); --> ERROR, deptno(FK)의 참조컬럼에 70번 데이터가 없어서 
  
  insert into emp (empno, ename, deptno, hiredate)
  values (9000, 'Kim', 50, sysdate); --> 함수사용가능, 형식 맞음
  
  insert into emp (empno, ename, deptno, hiredate)
  values (9001, 'Lee', 50, '19년3월2일'); --> ERROR, 날짜 포맷 오류
  
  insert into emp (empno, ename, deptno, hiredate)
  values (9001, 'Lee', 50, '19/03/02'); --> 잘 됨. 만약 안 되면 to_date('19/03/02') 사용
  
  
  ```

  

- **subquery 로 insert 하기**

  ```sql
  --테이블 만들기 위해 구조만 가져옴(false 조건)
  create table emp10
  as select * from emp where 1=2; -- CTAS
  --확인
  desc emp10;
  select * from emp10;
  
  --넣기: values 절 대신 subquery를 선언하면 subquery의 결과 행 수 많큼 추가됩니다.
  insert into emp10
  select * from emp where deptno = 10;
  --확인
  select * from emp10;
  
  --잘못된 넣기
  insert into emp10 (empno, ename, deptno, sal)
  select empno, job, hiredate, mgr
  from emp where deptno = 20;
  ```

  

### update ... set

테이블에 이미 존재하는 행의 데이터를 수정할 때 컬럼 단위로 수정합니다.

- 사용법

```sql
-- where 조건 없는 update
update 테이블명
set 컬럼명=new컬럼값 [, 컬럼명=new컬럼값, ...]; --테이블의 모든 데이터를 단일 값으로 update

update emp10
set sal = 1;

select * from emp10;

rollback;

select * from emp10;



-- where 조건 있는 update
update 테이블명
set 컬럼명=new컬럼값 [, 컬럼명=new컬럼값, ...];
where 조건;

update emp 
set sal = 1
where deptno = 30;

select empno, ename, deptno, sal 
from emp;

rollback;

select empno, ename, deptno, sal 
from emp;




-- 각종 ERROR
update dept
set deptno = 100
where dname = 'IT'; --> ERROR, 컬럼 size초과

update dept
set deptno = 40
where dname = 'IT'; --> ERROR 중복값

update emp
set deptno = 60
where empno = 7788; --> 참조무결성제약조건 오류



--문> SMITH사원의 급여를 KING 사원의 급여와 동일하도록 변경하세요
--update의 set절과 where절에 subquery를 사용할 수 있다
--update의 set절에 오는 subquery는 scalar subquery만 가능
update 
	emp
set 
	sal = (select sal from emp where ename = 'KING')
where 
	ename = 'SMITH';

rollback;


--문> KING사원과 동일한 부서에 근무하는 KING사원을 제외한 다른 사원의 급여를 20%인상 수정합니다.
update 
	emp
set
	sal = (sal * 1.2)
where 
    deptno = (select deptno from emp where ename = 'KING')
    and
    ename <> 'KING';
```



- default 조건 column의 update

```sql
drop table emp10 purge;
desc emp10;

create table customer (
    custid number(7), 
    custname varchar2(15),
    point number(5) default 100
 );
 
desc customer;
select * from customer;
 
insert into customer (custid, custname)
values (990301, 'Kim');
 
select * from customer;
 
update customer
set point = null;
 
select * from customer;

update customer
set point = default;
 
select * from customer;
 
```





### delete

테이블에 이미 저장되어 있는 레코드를 삭제할 때

```sql
delete from 테이블명; --전체 행 삭제

delete 테이블명; --오라클에서는 from절 생략 가능

delete from 테이블명 where 조건; --조건을 만족하는 행만 삭제

delete from 테이블명 where 컬럼 연산자 (subquery);

select * from emp;
delete from emp;
select * from emp;
rollback;

delete from emp where deptno = 30;
select * from emp;
rollback;
select * from emp;

delete from dept; --> ERROR 참조하는 자식 레코드가 존재하면 부모 레코드 삭제 불가. 참조 무결성 오류.

--문> ADAMS 사원과 동일한 직무를 담당하는 사원 삭제(ADAMS제외)
delete from 
	emp
where 
	job = (select job from emp where ename = 'ADAMS') 
	and
	ename <> 'ADAMS';
rollback;


```



### merge into ... using ... on ... matched then

※운용계 DB : transaction 목적의 DB. 데이터 변경.

※정보계 DB : 장기간 저장, 읽기, 분석 목적의 DB(**D**ata**W**arehouse 등)

데이터이관(**E**xtract**T**ranslate**L**oad) 작업에 유용하게 쓰임.

```sql
merge into 대상테이블 as t
using 소스테이블 as s
on t.pk컬럼 = s.pk컬럼
when matched then
update set t.컬럼 = s.컬럼, ...
[delete where 조건]
when not matched then
insert (t.컬럼리스트)
values (s.컬럼리스트);
```



```sql
conn scott/oracle 

create table emp30 (empno, ename, deptno, job, sal)
as select empno, ename, deptno, '  ' job, 0 sal
from emp
where deptno = 30;

desc emp30
select * from emp30;


--문> emp테이블로부터 30번 부서 사원정보를 emp30 테이블로 복제하시오
--30번부서 사원은 직무와 급여를 update하고
--급여가 2500이상이면 삭제하시오
--20, 10번부서 사원은 사원번호와 이름과 부서번호만 입력하시오 
alter table emp30 modify (job varchar2(15), sal number(8,2));

--나
merge into emp30 t
using emp s
on (t.empno = s.empno)
when matched then
	update set t.job = s.job, t.sal = s.sal
	delete where s.sal >= 2500
when not matched then
	insert (t.empno, t.ename, t.deptno, t.job, t.sal)
	values (s.empno, s.ename, s.deptno, s.job, s.sal)
	where s.sal < 2500;

--강사님
merge into emp30 a
using emp b
on (a.empno = b.empno)
when matched then
    update set a.job = b.job , a.sal = b.sal
    delete where a.sal > 2500
when not matched then
    insert (a.empno, a.ename, a.deptno)
    values (b.empno, b.ename, b.deptno);
```





## 11. 트랜잭션 제어와 세션

***Transaction - Unit of work*** (분리되어 수행될 수 없는 작업단위)

***ACID*** - 원자성, 일관성, 격리성, 영속성

DB관점의 transaction은 변경(DML, DDL, DCL)이 포함되면 일어난다.



#### transaction 단위

- 1개 이상의 DML들로 구성 - 명시적 commit, rollback

- 1개의 DDL - auto commit
- 1개의 DCL - auto commit

>수행중인 DML 트랜잭션의 세션이 비정상종료하면 oracle server는 rollback 합니다.
>
>수행중인 DML 트랜잭션의 세션이 정상종료(exit;)하면 oracle server는 commit 합니다.



#### 읽기 일관성

select하는 user들이 변경중인 user의 작업이 종료될 때까지 기다릴 필요가 없고 변경 작업하려는 user들은 select하는 user들이 검색을 종료할 때까지 기다릴 필요가 없다. 

*변경 작업중인 user들은 변경중인 값을 조회결과로 볼 수 있고, 변경 작업중이 아닌  user들은 DB에 저장된(commit)데이터 값을 조회 결과로 볼 수 있다.*

오라클 서버는 읽기 일관성을 위해서 lock, undo segment 등을 지원합니다.

```sql
create table test (num   number(2));
insert into test values (1);
insert into test values (2);
savepoint a;
insert into test values (3);
insert into test values (4);
savepoint b;
insert into test values (5);
insert into test values (6);
select * from test;
rollback to savepoint b;
select * from test;
rollback to savepoint a;
select * from test;
rollback;
```



***https://localhost:1158/em***

> A session에서 update후 commit을 하지 않은 상황에서 B session에서 또 update를 하면 waiting이 걸린다. 이때 상황을, 위 주소로 들어가면 확인 할 수 있다.
>
> (sys/oracle as sysdba)





## 13. 객체 종류

### 객체

- 테이블을 생성하려면 create table 시스템 권한이 있어야 한다.

- tablespace(data container) 저장소에 quota가 할당되어 있어야 한다.

- table 또는column 이름 규칙

  - 영문자 또는 _, $, #로 시작

  - 두 번째 문자부터 숫자 허용

  - 키워드 안 됨

  - schema 내에서 중복된 이름 사용 불가

    > schema
    >
    > 서로 연관된 table, index등의 객체를 그룹핑하는 논리적 개념. 객체 명을 재사용할 수 있는 namespace역할을 합니다. 오라클은 user 명을 schema명으로 사용합니다

  - 길이 제한 30자

  - DB 이름 길이 제한 8자

- 컬럼 타입

  - char: 고정길이 문자열 ~2000byte

  - varchar2: 가변길이 문자열 ~4000byte

  - number(p, s)

  - date: _세기, _년, _월, _일, _시, _분, _초

  - timestamp: date 타입 확장. 1/10^9의 정밀한 초값 저장

  - timestamp with timezone

  - interval year to month

  - interval day to second

  - rowid

  - **CLOB**(Character Large Object) ~ 4G

  - raw: binary 형식의 값 저장 (지문, 증명사진 등) ~2000byte

  - **BLOB**(Binary Large Object)

  - **BFILE**(Big File): read only 가능한 file을 DB외부에 운영체제의 폴더에 저장, transaction 처리 없음.

    

  ```sql
  desc user_tables;
  select table_name, tablespace_name from user_tables;
  
  create table 테이블명 (
      컬럼명 컬럼타입(size),
      컬럼명 컬럼타입(size) [default 값],
      컬럼명 컬럼타입(size) [제약조건],
      ...
      [, 제약조건]
  )
  [....................];
  
  --CTAS
  create table 테이블이름
  as (subquery);
  
  --Ex)
  create table emp20
  as select empno, ename, deptno, sal*12
  from emp
  where deptno =20; --ERROR (컬럼몇 * 오류)
  
  create table emp20
  as select empno, ename, deptno, sal*12 as salary
  from emp
  where deptno =20; -- alias로 해결
  
  create table emp20 (empid, name, deptid, salary)
  as select empno, ename, deptno, sal*12 
  from emp
  where deptno =20; -- 컬럼명 지정으로 해결
  
  
  ```

  >***제약조건 constraint*** - table의 DML 수행시 규칙
  >
  >Primary Key, not null, Unique Key, Foreign Key, check





## 14. 제약조건

``` sql
create table userinfo (
    userid varchar2(10) not null,
    username varchar2(15) constraint userinfo_nn not null,
    age number(30)
);

desc userinfo
insert into userinfo
values('tester1', '테스트1', 20);

insert into userinfo (username, age)  
values('테스터1', 20); -- NOT NULL 제약조건에 걸림

select * from userinfo;

select constraint_name, constraint_type
from user_constraints
where table_name = 'USERINFO';
--SYS_C0011087	C
--USERINFO_NN	C

insert into userinfo (username, age)
values('tester2', 30);

alter table userinfo disable constraint userinfo_nn; --  제약조건 비활성화

drop table userinfo purge;

--====================unique 제약조건 ====================
create table userinfo 
(userid  varchar2(10)  constraint userinfo_uk  unique,
 username  varchar2(15)  ,
 age  number(30)
);

desc userinfo
insert into userinfo 
values ('tester1', '테스터1', 20);

insert into userinfo  (username, age)
values ( '테스터2', 25);    ---userid는 null?

insert into userinfo  (username, age)
values ( '테스터3', 30);    ---userid는 null?

insert into userinfo 
values ('tester1', '테스터5', 35); ---error

select * from userinfo;

select constraint_name, constraint_type
from user_constraints
where table_name = 'USERINFO';

select index_name, uniqueness
from user_indexes
where table_name = 'USERINFO';

--oracle server는 unique제약조건이 선언된 컬럼에 자동으로 unique index 생성합니다.

alter table userinfo disable constraint userinfo_uk;
select index_name, uniqueness
from user_indexes
where table_name = 'USERINFO'; --? 
--제약조건 비활성화 하면 인덱스 자동 삭제 

alter table userinfo enable constraint userinfo_uk;
 
select index_name, uniqueness
from user_indexes
where table_name = 'USERINFO'; ---? index 다시 자동 생성?


drop table userinfo purge;


--==================primary key 제약조건===================
--다른 제약조건은 하나의 테이블에 여러개 선언가능하지만 primary key 제약조건은 하나만 선언 가능하다.
create table userinfo 
(userid  varchar2(10)  constraint userinfo_pk primary key,
 username  varchar2(15)  ,
 age  number(30)
);

desc userinfo
insert into userinfo 
values ('tester1', '테스터1', 20);

insert into userinfo  (username, age)
values ( '테스터2', 25);    ---userid는 null?

insert into userinfo  (username, age)
values ( '테스터3', 30);    ---userid는 null?

insert into userinfo 
values ('tester1', '테스터5', 35); ---error PK 위반

select * from userinfo;

select constraint_name, constraint_type
from user_constraints
where table_name = 'USERINFO';

select index_name, uniqueness
from user_indexes
where table_name = 'USERINFO';

drop table userinfo purge;




--=====================check 제약조건======================
create table userinfo(
	userid  varchar2(10),
	username  varchar2(15),
	gender   char(1) constraint userinfo_ck  check (gender in 			('F', 'M')),
	age  number(2) check (age > 0 and age < 100)
);

select constraint_name, constraint_type, search_condition
from user_constraints
where table_name='USERINFO';

insert into userinfo  values ('a001', 'an', 'f', 20);  --E
insert into userinfo  values ('a001', 'an', 'w', 20); --E

--null 허용한다....
insert into userinfo  values ('a001', 'an', null, 20);   --E


insert into userinfo  values ('a002', 'choi', 'M', 0); --E
insert into userinfo  values ('a002', 'choi', 'M', 100); --E

insert into userinfo  values ('a002', 'choi', 'M', 25); -- OK

drop table userinfo purge;




```





- purge, flashback

  drop table OOO;의 경우 undo 생성 없이 물리적 삭제되고 구조 또한 삭제된다. 그래서 10g 버전 이후 Recyclebin을 지원하여 휴지통에 들어간다. purge를 실행하면 휴지통에서도 삭제 된다.

  ```sql
  
  create table copy_dept
  as select * from dept;
  desc copy_dept;
  select * from copy_dept;
  
  drop table copy_dept;
  desc copy_dept;
  select * from copy_dept;
  
  select tname from tab;
  --BIN$xUjd5jQBSja1Z90V5FQVuw==$0
  --BONUS
  --CUSTOMER
  --DEPT
  --EMP
  --EMP30
  --SALGRADE
  --TEST
  select * from user_recyclebins;
  select * from recyclebin;
  select * from "BIN$xUjd5jQBSja1Z90V5FQVuw==$0"; --조회됨
  
  flashback table copy_dept to before drop; --복구
  select * from recyclebin; --확인 (없어짐)
  select tname from tab; --확인 (없어짐)
  select * from copy_dept; -- 조회됨(복구됨)
  
  ```

  

  

  



#### Window 함수

- ***rank()***

  특정 컬럼에 대한 순위를 구하는 함수로서 동일한 값에 대해서 동일한 순위를 가지며, 동일한 순위의 수만큼 다음 순위는 건너뛴다

  ```sql
  --emp 테이블에서 사원이름, 직무, 급여 데이터와 전체 사원의 급여가 높은 순서와 JOB별로 급여가 높은 순서 출력하시오
  
  select ename, job , sal,
      rank() over( order by sal desc) sal_rank,
      rank() over (partition by job order by sal desc) job_rank --emp 테이블에서 사원이름, 직무, 급여 데이터와 전체 사원의 급여가 높은 순서와 JOB별로 급여가 높은 순서 출력하시오
  from emp;
  ```

  

- ***dense_rank()***

  특정 컬럼에 대한 순위를 구하는 함수로서 동일한 순위 다음의 순위는 동일 순위의 수와 상관없이 1 증가된 값을 돌려준다**.**

  ```sql
  --emp사원 테이블에서 사원이름, 직무, 급여 데이터와 전체 사원의 급여를 높은 순서로 출력하되,동일한 순위를 하나의 등수로 간주하여 출력하시오
  select ename, job , sal,
      dense_rank() over( order by sal desc) sal_rank,
      dense_rank() over (partition by job order by sal desc) job_rank
  from emp;
  ```

  

- ***row_number()***

  특정 컬럼에 대한 순위를 구하는 함수로서 동일한 값이라도 고유한 순위를 부여한다(동일한 순위를 배제하기 위해 unique한 순위를 -oracle의 경우 rowid가 적은 행이 먼저 나온다- 매긴다).  PARTITION내의 ROW들에 순서대로 UNIQUE한 일련번호를 부여한다

  ```sql
  --emp사원 테이블에서 사원이름, 직무, 급여 데이터와  전체 사원의 급여가 높은 순서와 동일한 순위에 대하여 고유한 순위 같이 출력
  select  ename, job, sal, 
          dense_rank( ) over ( order by sal desc ) sal_rank
          ,  rank( ) over ( order by sal desc ) sal_rank2
          ,  row_number( ) over ( order by sal desc  ) sal_rank2
  from emp; 
  ```

  

- ***sum()***

  sum 함수를 이용해 파티션별로 윈도우의 합을 구할 수 있다.

  ```sql
  --사원들의 급여와 같은 매니저를 두고 있는 사원들의  salary 합을 구하여 출력한다.
  select ename, mgr, sal, 
      sum(sal) over (partition by mgr order by sal asc)
  from emp;
  ```

  

- ***range unbounded  preceding/following***

  emp사원 테이블에서 사원이름, 관리자, 급여 데이터와 사원들의 급여와
  같은 매니저를 두고 있는 사원들의 salary 합을 파티션내에 현재 행을 기준으로 이전행의 salary들의 누적합을 함께 출력한다.

  ```sql
  --emp사원 테이블에서 사원이름, 관리자, 급여 데이터와 사원들의 급여와 같은 매니저를 두고 있는 사원들의  salary 합을 파티션내에 현재 행을 기준으로 이전행의 salary들의 누적합을 함께 출력한다.
  select  ename, mgr, sal, 
          sum(sal) over (partition by mgr order by sal
                         range  unbounded preceding) 
  from emp;
  
  
  select  ename, mgr, sal, 
          sum(sal) over (partition by mgr order by sal
                         rows between unbounded preceding and current row   ) 
  from emp;
  
  
  select  ename, mgr, sal, 
          sum(sal) over (partition by mgr order by sal
                         rows between 1 preceding and 1 following   ) 
  from emp;
  
  
  select  ename, mgr, sal, 
          count(sal) over (order by sal
                           range between 200 preceding and 200 following   ) 
  from emp;
  
  ```

  

- ***first_value***(컬럼), ***last_value***(컬럼)

  ```sql
  select ename, mgr, sal,
      first_value(sal) over (partition by mgr order by sal) i,
      last_value(sal) over (partition by mgr order by sal) j
  from emp;
  --last_value() 값이 제대로 안 나오므로 
  --range unbounded following을 같이 써 줘야한다
  select ename, mgr, sal,
      first_value(sal) over (partition by mgr order by sal) i,
      last_value(sal) over (partition by mgr order by sal
          range between current row and unbounded following
      ) j
  from emp;
  
      
  ```

  

- ***lag(), lead()*** - 파티션별 윈도우에서 이전/이후 몇 번째 행의 값을 가져올 수 있다 

  ```sql
  select ename, mgr, sal,
      lag(sal) over (order by hiredate) i,
      lag(sal, 2, 0) over (order by hiredate) j
  from emp;
  
  select ename, mgr, sal,
      lead(sal) over (order by hiredate) i,
      lead(sal, 2, 0) over (order by hiredate) j
  from emp; 
  ```

  *3개의 AGUMENTS 까지 사용할 수 있는데, 두번째 인자는 몇 번째 앞의 행을 가져올 지 결정하는 것이고 (default 1), 세번째 인자는 파티션의 첫번째 행의 경우 가져올데이터가 없어 NULL값이 들어오는데 이 경우 다른 값으로 바꾸어 줄 수 있다.*




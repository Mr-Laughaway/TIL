### 복습

- 순위 관련 함수

  - rank() 

    ```sql
    rank() over (
        		partition by 컬럼 order by 컬럼 
                rows|range unbounded preceding |
                between current row and unbounded
                 	following |
        	    n preceding | n following
    ) 
    ```
```sql
    
- dense_rank()
  
- row_number()



- 집계 관련 window 함수
  - sum(),
  - min()
  -  max()
  -  avg(),
  - count()



- 행 순서 관련 함수
  - first_value()
  - last_value()
  - lag(컬럼,  n [, null 대체값]) - 현재 row 이전 행
  - lead(컬럼, n [, null 대체값]) - 현재 row 이후 행



- DML

  - **insert into** - 새 데이터 추가

    ```sql
    insert into 테이블명 (컬럼명 리스트) values (컬럼명 리스트의 순서와 타입에 맞는 값 리스트);
    
    insert into 테이블명 values (테이블에 선언된 컬럼순서대로 모든 값);
    
    -- values 절에 null, default, 단일행 함수 등 사용가능
    
    insert into 테이블명 (컬럼명 리스트) subquery; --컬럼명 리스트는 subquery의 컬럼순서 , 개수, 타입과 일치해야 합니다.
    
```

```sql
> ```
> insert 오류 - 컬럼타입 불일치, 컬럼크기 불일치, 제약조건 오류
> ```
```


​    

  - **update** - 컬럼 값 변경

    ```sql
    update 테이블명 set 컬럼명=변경할 값 [, 컬럼명 = 변경할 값, ...];
    
    update 테이블명 set 컬럼명=변경할 값 [, 컬럼명 = 변경할 값, ...] where 조건;
    
    update 테이블명 set 컬럼명=(subquery) [, 컬럼명=변경할 값,...] where subquery;
    
    ```

    > update 오류 - 컬럼타입 불일치, 컬럼크기 불일치, 제약조건 오류
> 변경할 값에 null, default, 단일행함수 등 사용가능


​    
- **delete from** - 행 삭제
  
    ```sql
    delete from 테이블명;  --모든 행 삭제
    
    delete 테이블명; --oracle에서 from 생략
    
    delete from 테이블명 where 조건 ;  ---조건을 만족하는 행만 삭제
    
    delete from 테이블명 where (subquery) ;
    ```
  
    >참조무결성제약조건 오류 : 참조하는 자식 레코드가 존재하면 부모 레코드는 삭제할 수 없습니다.
    >ex) 부서테이블의 레코드를 삭제하려면 소속 사원이 없는 부서정보 레코드만 삭제 가능합니다.



- ETL 작업에 사용하는 하나의 DML로 insert, update, delete 수행

  ``` sql
  merge into 대상테이블 t
  using 소스테이블 s
  on (s.pk컬럼 = t.pk컬럼)
  when matched then
    update set t.컬럼 = s.컬럼, ...
    delete where조건
  when not matched then
    insert (t.컬럼, t.컬럼,....)
    values (s.컬럼, s.컬럼,...);
  ```

  

- TCL - Transaction Control Language

  - Transaction - Unit or Work, all or nothing, ACID

  - DB에서  Transaction 단위 - 하나 이상의 DML, 하나의 DDL(auto commit), 하나의 DCL(auto commit)

  - 하나 이상의 DML로 구성된 트랜잭션은 명시적으로 *commit;* 또는 *rollback;* 해야 합니다.

  - 트랜잭션 수행중에 DB 연결된 세션 **정상 종료**할 경우 oracle server는 트랜잭션을 ***commit***합니다.

  - 트랜잭션 수행중에 DB 연결된 세션 **비정상 종료**할 경우 oracle server는 트랜잭션을 ***rollback*** 합니다.

  - 긴 트랜잭션의 경우 *rollback*을 일부 할 수 있습니다.

    ```sql
    savepoint 식별자;
    rollback to savepoint 식별자;
    ```

  - **읽기 일관성** 

    *- 변경중인 user는 자신이 변경중인 값이 조회되고, 변경중이지 않은 user들은 DB에 이전에 저장된 값을 조회합니다.*

    *- Lock과 undo data를 이용해서 읽기 일관성을 보장*

    *- undo data는 트랜잭션을 rollback을 하면 변경전값을 undo segment로부터 restore(복원)합니다.*



- 데이터베이스의 객체

  - table 

    - 구조와 물리적 data(record + column)
    - heap, partition, IOT, clustered, ... 등의 종류가 있다.

  - view

    - table에 대해서 select 로 정의된 table의 window역할
    - 보안, 간결한 select 문 사용을 위해서 base가 되는 table이나 view가 필요할 때 사용 (예외- MeterializedView : 성능향상이 목적인 물리적 data를 가지는 view)

  - index

    - 테이블의 컬럼에 생성
    - where 절에 검색조건으로 사용되는 컬럼, join 컬럼, ordery by 절의 컬럼 등에 생성
    - 내부적으로 oracle server가 select 수행시 사용
    - b*tree 구조로 저장

  - sequence

    - 순차적으로 숫자값이 저장되어야 하는 컬럼(주문번호, 게시판의 글 번호 등)의 값을 자동으로 발행해주는 객체
    - 최소값, 최대값, 증감값 설정합니다.

  - synonym(동의어)

    schema명, 객체@dblink명과 같은 객체이름을 간결하게 사용하기 위한 동의어



- 테이블 생성

  ```sql
  create table 테이블명 (
  	컬럼명 컬럼타입(크기) 
      제약조건 | default 값, ...
      )
  [tablespace 저장소명 storage...];
  ```
  - 테이블 생성을 위해 필요한 권한

     create table 권한, tablespace에 대한 quota가 할당되어 있어야 합니다.

  - 테이블명, 컬럼명 이름 규칙

    - 대소문자 구별 안 함 - data dictionary에는 대문자로 저장됨

    - 첫 문자로 영문자, _, &, # 허용

    - 두 번째 문자부터 숫자 허용

    - 키워드 허용 안 됨

    - 동일한 schema내에서 같은 이름의 객체 안 됨

      > schema 
      >
      > - 서로 연관된 객체들을 그룹핑한 것
      > - 오라클에서는 user명을 schema명으로 사용함
      > - user 소유의 객체들을 그룹핑해서 다른 user 소유의 객체들을 구별하는 namespace 역할을 하면서 동일한 이름의 객체를 다른 schema에서 사용 가능 (schema명.객체명)

  - 컬럼 타입

    - char
    - varchar2
    - number
    - date
    - timestamp
    - timestamp with timezone
    - interval year to month
    - interval day to second
    - Bfile
    - BLOB (LONG RAW)
    - CLOB (LONG)
    - RAW
    - rowid - 행주소 (objectid + fileid + blockid + 행순서번호)

    ```sql
    create table 테이블명 (컬럼명 리스트)
    as select ~ 
       from ~
       [where~]
       ....;
    ```

  - 테이블의 구조 복제

    ```sql
    create table 테이블명  
    as select ~ 
       from ~
       where 1=2;
    ```

    

- 제약조건(constraint)

  DML 수행 시 컬럼값의 허용 또는 제한규칙

  - primary key - unique + not null, **테이블에 하나만 정의 가능**
  - not null - null  허용 안 함, **컬럼 레벨**에서만 제약조건 선언 가능
  - unique - 중복값을 허용하지 않음,(**오라클은 null은 unique 값으로 취급해서 여러개 가능**)
  - check
  - foreign key

  ```sql
  create table emp2 (
      empno number(4),
      ename varchar2(15) [constraint 이름] not null, --컬럼 레벨
      hiredate date,
      job varchar2(15),
      sal number(8,2),
      constraint emp2_pk primary key (empno, ename) --테이블 레벨
  );
  ```

  - 컬럼에 index가 자동 생성되는 제약조건 

    - primary key
    - unique key

  - 제약조건 메타 정보 조회

    - user_constraints
    - all_constraints
    - dba_constraints

  - 테이블의 메타 정보 조회

    - user_tables(tab)
    - all_tables
    - dba_tables

  - 컬럼 메타 정보 조회

    ```sql
    desc dict;
    
    select  table_name
    from dict
    where table_name like 'USER%COLUMNS';
    
    select column_name, data_type, nullable
    from user_tab_columns
    where table_name = 'EMP';
    ```

  - 인덱스 메타 정보 조회 

    - user_indexes
    - user_ind_columns

    

---



### 제약 조건

```sql
-- conn scott/oracle (아무데서나 해도 됨)

create table category (
    cid number(5),
    cname varchar2(20)
);
insert into category values (10000, 'BOOK');
insert into category values (20000, 'Music');
insert into category values (30000, 'Game');
insert into category values (40000, 'Movie');

select * from category;


--foreing key 제약 조건이 참조하는 부모 컬럼에는 primary key 또는 unique key 제약조건이 걸려 있어야한다.
create table product (
    prodid number(5),
    pname varchar2(50),
    price number(6),
    cid number(5) constraint product_fk references category(cid)
);
-->>> ERROR


-->>> 대상 column에 제약조건 설정 후 product 생성
alter table category add constraint category_pk primary key(cid);

create table product (
    prodid number(5),
    pname varchar2(50),
    price number(6),
    cid number(5) constraint product_fk references category(cid)
);
-->>> SUCCESS


--제약 조건 확인
select constraint_name, constraint_type
from user_constraints
where table_name = 'PRODUCT';


insert into product values (1, 'java', 5000, 10000); --
insert into product values (2, 'oracle', 5000, 50000); --참조 무결성 오류
insert into product values (3, 'BTS', 15000, 20000);--
update product set cid = 2222 where prodid = 3; -- 참조 무결성 오류

delete from category where cid = 40000; --
delete from category where cid = 10000; -- 참조 무결성 오류
update category set cid = 15000 where cid = 10000; --참조 무결성 오류 


create table product (
prodid   number(5),
pname    varchar2(50),
price    number(6),
cid      number(5) ,
constraint product_fk foreign key (cid) references category(cid)  -- on delete cascade 또는 on delete set null
);
-- on delete cascade 부모 삭제시 무결성 제약에 걸릴경우 같이 삭제
-- on delete set null 부모 삭제시 무결성 제약에 걸릴경우 null로 변경

```



### index

```sql



-- unique 제약이 없는 경우 FULL SCAN
select * from emp where ename = 'SMITH';

-- unique 제약이 있어서 index가 있기 때문에 UNIQUE SCAN(INDEX SCAN)
select * from emp where empno = 7788;
```

- PK와 UK에 index 자동생성 목적 

  정합성 체크와 중복값 체크를 빠르게하기 위함



- index 생성에 적합한 조건

  - where 조건에 사용되는 컬럼

  - join 컬럼

  - order by 컬럼

  - 컬럼 중에서 distinct value(선택도) 값이 많아야 합니다.

  - where 절의 =(equal) 연산 조건의 결과 행이 5%이내가 적합

    > 인덱스 생성 컬럼으로 조회 결과 행수가 약 10%를 초과하면 손익분기점으로 table full scan이 더 유리하다.

  - 자주 update되는지 않는 컬럼이 적함. 자주 update 되는 컬럼은 인덱스를 생성하면 성능이 저하됨

  - 4~6개 블럭이상에 데이터가 저장된 테이블

  

- 인덱스의 종류

  - 단일컬럼 인덱스

    ```cretae index idx_name on emp(sal);```

  - 복합컬럼 인덱스

    ```create index idx_name on emp (sal, ename, ...);```

  - unique 인덱스

    ```create unique index idx_name on emp(empno);```

  - non-unique 인덱스

  - function-based 인덱스 (컬럼 값의 내림차순 등으로 생성)

    ```create index idx_name on emp(sal*12+COMM);```

  - OLTP

    - B*TREE 인덱스
    - 소량 데이터, 빠른 검색

  - OLAP, DW, DSS - 분석처리 ***BITMAP INDEX***

    ***01011101  등의 bitwise 연산***

    데이터 종류가 적고 같은 데이터가 많이 존재할 때 주로 사용

    ```sql
    where 컬럼 = 값 or
    	  ... 연령대 1/6,
    	  ... 미혼여부 1/2,
    	  ... 직장여부 1/2
    
    create BITMAP INDEX IDX_NAME ON EMP(JOB);
    
    ```

    

- index 삭제

  ```sql
  drop index 인덱스이름;
  ```

  

- alter index 가능 (따로 공부해야...)



- index 조회

  ```sql
  select * from user_ind_columns;
  ```

  

#### 앞에서 빼먹은 alter 

- 컬럼 타입 변경할 때 컬럼값이 존재하더라도 char5->varchar2(10) 변경은 가능
- 컬럼 타입 변경할 때 호환되지 않는 컬럼타입으로 변경할 때는 컬럼값을 null 변경한 후에 변경할 수 있다.
- 컬럼 크기를 변경할 때 크기 증가는 항상 가능하지만, 컬럼값이 존재할 때  컬럼 크기를 줄이려면 저장된 컬럼값의 초대 길이보다 작게 죽일 수 없다.
- not null 제약조건 추가 

```sql
alter table 테이블명 add constraint~;

alter table 테이블명 drop constraint~;

alter table 테이블명 add (컬럼 컬럼타입(크기), 컬럼 컬럼타입(크기),..);

alter table 테이블명 drop (컬럼 컬럼타입(크기), 컬럼 컬럼타입(크기),..);

alter table 테이블명 drop column 컬럼명;

alter table 테이블명 rename column old명 to new명;

alter table 테이블명 enable constraint~;

alter table 테이블명 disable constraint~;

```



#### drop 복습

```sql
drop table 테이블명;
--테이블이름이 rename되어 recyclebin에 저장됨
--조회가능
--저장공간이 부족할 때 oracle server가 제거함

drop table 테이블명 purge;
--recyclebin을 bypass하고 물리적으로 완전 삭제

purge recyclebin;
```

- 삭제되는 정보
  - table 메타 정보
  - data
  - 제약조건
  - index



#### truncate 복습

```sql
truncate table 테이블명 [reuse storage];
--구조만 남겨두고 data는 완전 삭제(recyclebin에도 undo data도 생성하지 않음)
```

- 삭제되는 정보
  - data



---



### VIEW

- ***simple view*** 

  하나의 대상 테이블로부터 view 생성

  ***DML이 가능한 view(간접적 table access DML 수행됨)***

  - not null 제약조건이 선언된 컬럼은 모두 포함
  - 컬럼 표현식 없음
  - group by 없음
  - 그룹함수 x
  - rowid 없음
  - 

- ***complex view***

  하나 이상의 테이블에 대한

  - 하나 이상의 테이블에 대한 select 문으로 정의
  - 컬럼표현식, group by, 그룹함수 rowid 등 모두 포함



- 권한 확인

  ```sql
  select * from session_privs;
  ```

  

- 권한이 없을 경우

  ```
  <cmd>
  
  sqlplus / as sysdba
  
  SQL> grant create view to scott, hr
  ```



- view 생성

  ``` sql
  create view emp20_vu
  as select empno, ename, deptno, job, sal*12 salary
     from emp
     where deptno = 20;
     
  select text from user_views where view_name = 'EMP20_VU';
  
  
  
  ```



- create or replace view - alter view 역할

  ```sql
  create or replace view dept_vu
  as select *
  from dept10; --> error
  
  create or replace force view dept_vu
  as select *
  from dept10; --> 컴파일 오류와 함께 뷰가 생성되었습니다.
  
  select object_name, object_type, status
  from user_objects
  where object_name = 'DEPT_VU';
  --결과: DEPT_VU		VIEW	INVALID
  --생성은 되었으나 유효하지 않음
  ```



- complex view - 추가/변경/삭제 불가

  ```sql
  select * from emp20_vu;
  
  insert into emp20vu values(
  	9005, 'Song', 20, 'SALESMAN', 2000); --ERROR 가상 열은 사용할 수 없습니다.
  ```

  

- simple view - 추가/변경/삭제 가능

  ```sql
  create view emp20_vu
  as select empno, ename, deptno, job, sal
     from emp
     where deptno = 20; --ERROR 기존의 객체가 이름을 사용하고 있습니다.
     
  create or replace view emp20_vu
  as select empno, ename, deptno, job, sal
     from emp
     where deptno = 20;
     
  insert into emp20_vu values(
  	9005, 'Song', 20, 'SALESMAN', 2000); --SUCCESS
  
  select * from emp;
  select * from emp20_vu;
  
  delete from emp20_vu where empno = 9005;
  
  select * from emp;
  select * from emp20_vu;
  ```

  

- view 삭제

  ```sql
  drop view emp20_vu;
  ```

  view 객체 삭제는 테이블에 영향을 주지 않고, 메타 정보만 



- with check option (타입; V)

  ```sql
  create or replace view emp20_vu
  as select empno, ename, deptno, job, sal
     from emp
     where deptno = 20 with check option;
     
  select constraint_name, constraint_type
  from user_constraints
  where table_name = 'EMP20_VU';
  
  insert into emp20_vu values(
      9005, 'Song', 30, 'SALESMAN', 2000); --ERROR: 20번 부서만 insert/update 등이 가능 
  ```



- with read only (타입: O)

  ```sql
  create or replace view emp20_vu
  as select empno, ename, deptno, job, sal
     from emp
     where deptno = 20 with read only;
     
  select constraint_name, constraint_type
  from user_constraints
  where table_name = 'EMP20_VU';
  
  insert into emp20_vu values(
      9005, 'Song', 30, 'SALESMAN', 2000); --ERROR: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
      
  delete from emp20_vu; --ERROR: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
  ```





### SEQUENCE

- 생성 및 사용

```sql
create sequence emp_seq;
select * from user_sequences;

select emp_seq.currval from dual; --시퀀스를 생성하면 최최값을 생성한 다음에 currval을 사용 가능하다

select emp_seq.nextval from dual;

select emp_seq.currval from dual;

insert into emp (empno, ename)
values (emp_seq.nextval, 'Kang');

select empno, ename from emp;

--여러 테이블에서 같은 시퀀스를 사용한다 (번호 갭 주의)
update dept set deptno = emp_seq.nextval
where deptno = 50;

select deptno, dname from dept;


```



- 변경 가능  (start with는 변경 불가)

  ```sql
  alter sequence 시퀀스명
  increment by ~
  maxvalue ~
  minvalue ~
  cycle ~
  cache ~;
  
  ```



- 삭제

  ```sql
  drop sequence 시퀀스명;
  --메타 정보만 data dictionary로부터 삭제됨
  ```

  

### SYNONYM

```sql
create [PUBLIC] synonym 동의어이름
for [사용자.][객체이름];

select * from user_synonyms; --synonym 확인
```

```sql
--사용 예

--권한 주기
--(cmd)
--> sqlplus / as sysdba
--> SQL> grant create sysnonym to scott;

create synonym e for emp;

select * from e;

drop synonym e;
```



---





## 15. 사용자, 권한, 롤 관리

```sql
conn / as sysdba
create user kim
identified by 1234
password expire;

conn kim/1234 

--alter user kim identified by 새비밀번호;
--password 명령어로 비밀번호 변경

conn kim/oracle
-- create session 권한 (DB connetion권한) 없다고 오류 

conn / as sysdba
grant create session to kim;


conn kim/oracle
create table test (name varchar2(10));   --ERROR

select user from dual;


--dual -----소유자? 
select owner, table_name
from all_tables
where table_name='DUAL';

```



- 권한

  - 시스템 권한 - DB에서 특정 sql을 수행할 수 있는 권한, **DBA**

  - 객체 권한

    - table

      alter, delete, index, insert, references, select, update

    - view

      delete, insert, references, select, update

    - sequence

      select, alter, drop

  ```sql
  conn kim/oracle
  select * from scott.emp;
  
  conn scott/oracle
  grant select on emp to kim;
  
  
  conn kim/oracle
  select * from scott.emp;
  grant select on scott.emp  to hr;  --ERROR
  
  conn scott/oracle
  grant select on emp to kim with grant option;
  
  
  conn kim/oracle
  select * from scott.emp;
  grant select on scott.emp  to hr; 
  
  conn hr/oracle
  select * from scott.emp; 
  
  conn scott/oracle
  revoke select on emp from hr;  --ERROR, 객체 권한은 직접 권한을 준 user가 회수 가능합니다.
  
  revoke select on emp from kim;
  
  conn kim/oracle
  select * from scott.emp; --ERROR 권한 회수되어 못 봄
  
  conn hr/oracle
  select * from scott.emp; --ERROR 객체권한은 cascade로 회수됨
  
  ```

  ```sql
  --컬럼별 권한
  grant update on emp(job, deptno) to kim;
  
  --user_tab_privs, user_sys_privs 확인
  select * from 'user%prives';
  select session_privs;
  
  
  ```

  

- 롤

  권한 관리의 불편한 점을 해결하기 위해 롤(role)이라는 그룹핑 개념을 이용.

  - 직무별, 업무별로 필요한 권한을 그룹핑 - role
  - role을 생성할 수 있는 권한은 DBA에게 있다.

  ```sql
  --생성
  create role 롤이름;
  
  --부여
  grant 시스템 권한, 객체 권한 to 롤이름;
  grant 롤이름 to 사용자|롤이름|public;
  
  --회수
  revoke 롤이름 from 사용자|롤이름|public;
  
  --삭제
  drop 롤이름 사용자|롤이름|public;
  
  --10g 이후 일반적 권한 부여
  grant CONNECT, RESOURCE, CREATE VIEW, CREATE SYSNONYM
  to 롤이름;
  ```

  - CONNECT 롤
    - alter session
    - create cluster
    - create database link
    - create sequence
    - ***create session*** - 얘 빼고 다 없어짐(10g  부터)
    - create synonym
    - create table
    - create view
  - RESOURCE 롤
    - create tirgger
    - create sequence
    - create type
    - create procedure
    - create cluster
    - craete operator
    - create indextype
    - create table
  - DBA 롤

  - **role의 또 하나의 장점은 동적 권한 관리 기능이다.**



---



## JDBC

- 준비작업

  ```
  jdbc library를 JDK library 패스로 카피
  
  C:\app\student\product\11.2.0\dbhome_1\jdbc\lib\ojdbc6.jar
  
  -->
  
  C:\Program Files (x86)\Java\jdk1.8.0_211\jre\lib\ext\ojdbc6.jar
  ```



- DBTest.java

  ```java
  package lab.java.core;
  
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Statement;
  
  public class DBTest {
  
  	public static void main(String[] args) {
  
  		Connection con = null; //DB연결상태 세션 저오 저장
  		Statement stat = null;
  		ResultSet rs = null;
  		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
  		String sql = "select * from dept";
  		try {
  			Class.forName("oracle.jdbc.OracleDriver");
  //			System.out.println("Driver loading 성공");
  			con = DriverManager.getConnection(url, "scott", "oracle");
  //			System.out.println("db connect 성공");
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			while(rs.next()) {
  				System.out.print(rs.getInt("deptno"));
  //				System.out.println(rs.getInt(1));
  				System.out.print(rs.getString(2));
  //				System.out.println(rs.getString("dname"));
  				System.out.println(rs.getString(3));
  //				System.out.println(rs.getString("loc"));
  			}
  			
  		}
  		catch(ClassNotFoundException e) {
  			System.out.println("Driver 없음");
  		}
  		catch(SQLException e) {
  			System.out.println(e.getMessage());
  			//db 연결 실패
  		}
  		finally {
  			try {
  				if(rs != null) rs.close();
  				if(stat != null) stat.close();
  				if(con != null) con.close();
  			}
  			catch(Exception e) {
  				e.printStackTrace();
  			}
  		}//finally end
  		
  	}//main end
  
  }//class end
  
  ```



- InsertTest.java

  ```java
  package lab.java.core;
  
  import java.io.FileInputStream;
  import java.io.IOException;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.util.Properties;
  
  public class InsertTest {
  
  	public static void main(String[] args) {
  
  		Connection con = null; //DB연결상태 세션 저오 저장
  		PreparedStatement stat = null;
  		String sql = "insert into dept values (?, ?, ?)";
  		try {
  			Properties prop = new Properties();
  			prop.load(new FileInputStream("C:/workspace/day13/src/dbinfo.properties"));
  			
  			Class.forName(prop.getProperty("driver"));
  			System.out.println("Driver loading 성공");
  			con = DriverManager.getConnection(
  					prop.getProperty("url"), 
  					prop.getProperty("user"), 
  					prop.getProperty("pwd")
  			);
  			System.out.println("db connect 성공");
  			
  			stat = con.prepareStatement(sql);
  			stat.setInt(1,  70);
  			stat.setString(2, "BigData");
  			stat.setString(3, "Seoul");
  			
  			int rows = stat.executeUpdate();
  			if(rows > 0) {
  				System.out.println("insert 성공");
  			}
  			
  		}
  		catch(ClassNotFoundException e) {
  			System.out.println("Driver 없음");
  		}
  		catch(SQLException e) {
  			System.out.println(e.getMessage());
  			//db 연결 실패
  		}
  		catch(IOException e) {
  			System.out.println(e.getMessage()); //Properties
  		}
  		finally {
  			try {
  				if(stat != null) stat.close();
  				if(con != null) con.close();
  			}
  			catch(Exception e) {
  				e.printStackTrace();
  			}
  		}//finally end
  		
  	}//main end
  
  }//class end
  
  ```

  ```properties
  #dbinfo.properties
  
  driver=oracle.jdbc.OracleDriver
  url=jdbc:oracle:thin:@localhost:1521:orcl
  user=scott
  pwd=oracle
  ```

  


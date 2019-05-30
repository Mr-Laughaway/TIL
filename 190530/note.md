# Database

특정 기업이나 조직 또는 개인이 필요에 의해 논리적으로 연관된 데이터를 모아 일정한 형태로 저장해 놓은 것



### DBMS(Database Management System)

데이터베이스 관리 프로그램. 데이터 입력, 수정, 삭제 등의 기능을 제공한다.

- Database 특징
  - 통합된 데이터 - 데이터의 중복을 최소화하여 중복으로 인한 데이터 불일치 현상을 제거
  - 저장된 데이터 - 디스크, 테이프 같은 컴퓨터 저장장치에 저장된 데이터
  - 운영 데이터 - 업무를 위한 검색을 할 목적으로 저장된 데이터
  - 공용 데이터 - 동시 공유
  - 실시간 접근성
  - 지속적인 변화
  - 내용에 따른 참조
- 파일 시스템
  - 데이터를 파일 단위로 저장하므로 중복 가능
  - 데이터의 중복 저장으로 일관성이 결여됨
  - 데이터 정의와 프로그램의 독립성 유지 불가능
  - 관리 기능 보통
  - 프로그램 개발 생산성 나쁨

- DBMS 장점
  - DBMS를 이용하여 데이터를 공유하기 때문에 중복 가능성이 낮음
  - 중복 제거로 데이터의 일관성이 유지됨
  - 데이터 정의와 프로그램의 독립성 유지 가능
  - 데이터 복구, 보안, 동시성 제어, 데이터 관리 기능 등을 수행
  - 짧은 시간에 큰 프로그램을 개발할 수 있음
  - 데이터 무결성 유지, 데이터 표준 준수 용이
- Database 사용자 그룹
  - 일반 사용자
  - 응용프로그램 개발자
  - SQL 사용자
  - DBA

- DB 용어
  - Table ≒ Entity (Record 집합)
  - Row ≒ Record ≒ Tuple (속성값 모음)
  - Column ≒ Attribute (속성)
  - Primary Key 속성 = Not Null + Unique
  - Foreign Key = 외래키
  - SQL(Structured Query Language)

- DML - Data Manipulation Language

  - DQL SELECT
  - 추가 INSERT
  - 수정 UPDATE
  - 삭제 DELETE

- DDL - Data Definition Language

  - 생성 CREATE
  - 변경 ALTER, RENAME
  - 삭제 DROP
  - table 관리 TRUNCATE

- DCL - Data Control Language

  - DBMS 보안(인증)
  - 권한(GRANT, REVOKE)

- TCL - Transaction Control Language

  한번에 처리되어야 하는 일련의 작업 집합

  - 결정 COMMIT
  - 취소 ROLLBACK
  - 중간저장 SAVEPOINT



##### 실행 연습 

```s
> sqlplus
> sqlplus /nolog
^C or exit

> sqlplus / as sysdba
SQL> select user from dual;

SQL> alter user scott
	2 identified by oracle
	3 account unlock;
사용자가 변경되었습니다.
	
SQL> alter user hr
	2 identified by oracle
	3 account unlock;	
사용자가 변경되었습니다.

SQL> conn hr/oracle
연결되었습니다.

SQL> conn scott/oracle
연결되었습니다.

SQL> host // -> cmd로 빠져나옴
> lsnrctl status  // 리스터 상태 점검
> exit // SQL>로 돌아감

SQL> select user from dual;
...
SQL> select tname from tab;
...
SQL> select * from emp;
...



```

soft parsing, hard parsing, logical read, physical read





### SQL - Structured Query Language

선언적, 결과중심적 언어.



#### SELECT

- Projection - table, column 기준 검색
- Selection - table, row 기준 검색
- Join - 2개 이상의 table에서 공통된 속성값 기준 row 결합



*참고*

>  sqlplus 툴  - sql 실행, 결과 보여주는 환경 제공
>
>  sqlplus 툴 명령어 - 세미콜론(;) 없이 사용 가능, 명령어 축약 사용 가능
>
>  sql문은 명렁어 축약 불가, 반드시 한 문장은 세미콜론(;) 으로 종료



*참고*

> char(1) ~2000byte
> varchar2(1) ~4000byte
> number타입 binary형식으로 정수, 실수
> date 날짜를 7byte를 사용해서 수치값으로 저장 (__세기, __년도 __월 __일 __시 __분 __초)
>
> select sysdate from daul; --시스템 현재 시간을 리턴하는 함수

```
SQL> conn scott/oracle
SQL> select tname from tab;
SQL> describe emp;

SQL> select sysdate from dual;
SYSDATE
--------
19/05/30

SQL> alter session set nls_date_format = 'YYYY/MM/DD HH24:MI:SS';
세션이 변경되었습니다.

SQL> select sysdate from dual;
SYSDATE
-------------------
2019/05/30 11:22:05
-------------------

SQL> exit; -- db disconnection, 세션 종료

-- 세션을 종료한 후에 다시 시작하면 세션의 기본 날짜 출력 형식으로 변경

> sqlplus scott/oracle

SQL> select sysdate from dual;
SYSDATE
--------
19/05/30

SQL>

```



***참고 - table 목록 확인 방법***

> meta 정보가 저장된 oracle data dictionary view는
>
> user_tables  - 특정 user 소유의 테이블 목록 확인
>
> all_tables - 특정 user 소유 + 권한을 받은 테이블 목록 확인
>
> dba_tables - DB의 모든 테이블 목록 확인 (DBA 권한으로만 확인 가능)

```
SQL> desc user_tables
SQL> select table_name from user_tables; --user_tables의 별칭 tab

SQL> desc tab
SQL> select tname from tab;

SQL> select table_name from all_tables;
SQL> select table_name from dba_tables; -- 오류발생(권한)

conn  / as sysdba 
conn sys/oracle as sysdba
select table_name from dba_tables;

conn scott/oracle
```

> ※ **SQL문장의 키워드와 테이블명, 컬럼명등은 대소문자 구별 안합니다**
>
> ※ **컬럼값은 대소문자 구별합니다.**





---

#### Projection

- select

- distinct - 중복 제거

```
select ename, sal, job, deptno from emp;

select deptno from emp;

select distinct deptno from emp; -- hashing방식 사용해서 중복값 제거

select deptno, distinct job from emp; --?
```

- expression

  -  number 타입 컬럼은 산술연산 가능 : +, -, *, /

    ```select sal, sal+100, sal-100, sal*2, sal/100 from emp;```

  - char / varchar2 타입 컬럼은 문자열 결함 : ||

    ```select ename || 'is work as  ' || job from emp;```

  - date 타입 컬럼 : date ±  n, date ± date, date ± 1/n

    ※ 문자,날짜 데이터는 반드시 ' '를 사용해서 표현, 처리

    ※ 날짜 데이터 세션에 설정된 포맷 형식하고 일치해야 합니다. ('RR/MM/DD')

- as (alias)

- 

*참고*

>데이터가 추가될 대 입력되지 않은 컬럼값은 null 이다.
>
>null은 아직 값이 없다는 의미입니다. 0 도 아니고 ' '도 아닙니다.
>
>null 은 산술연산 수행 결과가 항상 null입니다.
>
>null을 포함하는 컬럼들은 null아닌 값으로 변환 후에 산술연산을 수행해야 합니다.
>
>모든 DBMS에서는 null 아닌 값으로 변환해주는 내장 함수를 제공합니다.
>
>nvl(clumn, null일때 변환하고 싶은 값)
>
>null은 비교연산, 논리연산 모두 null이 결과입니다



###### Quiz

```sql
-- 1. 'A' 결과로 출력하려면?
select '''A''' from dual;
select q'['A']' from dual;

select 10 || 10 from dual; -- true?  => '1010'
select '10' + '10' from dual; -- '1010'? => 20

select sysdate+1, sysdate-1 from dual;
select sysdate-hiredate from emp;
select sysdate+hiredate from emp;

alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';
select sysdate, sysdate+1/24, sysdate+5/1440 from dual;
```

*참고*

>※ select~ from절이 필수절입니다.
>※ 단순계산 결과, 함수 결과, 문자 데이터 출력등은 dual테이블을 사용합니다





---

#### SELECTION

- where 절 사용

  ```sql
  select ename, deptno from emp where deptno = 30;
  select ename, job from emp where job = 'ANALYST';
  select ename, sal from emp where sal >= 3000;
  alter session set nls_date_format='RR/MM/DD';
  select ename, hiredate from emp where hiredate >= '87/01/01';
  ```

- is null, is not null

- and, or, not

- ***between***

- ***in 리스트 연산자 :  in (값, 값, 값)***

  ```sql
  -- 커미션을 받는 사람
  select ename, comm from emp where comm is not null;
  
  -- 급여가 3000이상 5000 이하인 사람
  select ename, sal from emp where sal>= 3000 and sal <= 5000;
  select ename, sal from emp where sal between 3000 and 5000;
  
  --직업이 ANALYST 이거나 CLERK 인 사람
  select ename, job from emp where job = 'ANALYST' or job = 'CLERK';
  select ename, job from emp where job in ('CLERK', 'ANALYST');
  
  ```

- ***character pattern matching 연산자 : like ' %, _'***

  - %는 모든 문자, 갯수는  0~ㅡ
  - _모든 문자, 갯수는 1

  ```sql
  -- 이름의 두번째 글자가 D 인 사람
  select ename from emp where ename like '_D%';
  
  -- S로 시작하는 사람
  select ename from emp where ename like 'S%';
  
  -- N으로 끝나는 사람
  select ename from emp where ename like '%N';
  
  -- 81년도에 입사한 사람
  select ename, hiredate from emp where hiredate like '81%';
  ```

- 논리 연산자의 우선순위 NOT, AND, OR

  ```sql
  --업무가 PRESIDENT 이고 급여가 1500 이상이거나 업무가 SALESMAN인 사원의 사원번호, 이름, 업무, 급여를 출력하여라
  select empno, ename, job, sal from emp where (job = 'PRESIDENT' and sal >= 1500) or job = 'SALESMAN';
  
  --급여가 1500 이상이고 업무가 SALESMAN이거나 PRESIDENT인 사원의 사원번호, 이름, 업무, 급여를 출력하여라
  select empno, ename, job, sal from emp where sal >= 1500 and job in ('PRESIDENT', 'SALESMAN');
  select empno, ename, job, sal from emp where (sal >= 1500) and (job = 'SALESMAN' or job = 'PRESIDENT');
  ```



***전형적인 구문 구조***

```sql
select ~
from ~
[where 필터 조건]
[group by 컬럼]
[having 조건]
[order by 정렬기준컬럼 정렬방식] -- asc 오름차순 default, desc 내림차순

--사원들의 사번, 이름, 부서번호, 월급, 커미션, 연봉(sal+comm*12),의 결과를 출력, 연봉의 내림차순으로...
select empno, ename, deptno, sal, comm, sal + nvl(comm, 0) * 12 as 연봉 from emp order by 연봉 desc;
-- order by 절에는 컬럼 표현식, 별칭, 컬럼 포지션을 사용할 수 잇습니다.
select empno, ename, deptno, sal, comm, (sal + nvl(comm, 0)) * 12 as 연봉
from emp order by 6 desc;

--사원들의 사번, 이름, 부서번호, 월급, 커미션, 연봉(sal+comm*12)읠 결과 출력(부서번호로 오름차순, 연봉으로 내림차순)
select empno, ename, deptno, sal, comm, (sal + nvl(comm, 0)) * 12 as 연봉 from emp order by deptno, 연봉 desc;
```



##### 연습문제

```sql

--문제1)  EMP Table의 모든 자료를 출력하여라.
select * from emp;

--문제2)  EMP Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.
select empno, ename, sal, job from emp;

--문제3) 모든 사원의 급여를 $300 증가시키기 위해 덧셈 연산자를 사용하고 결과에 SAL+300을 조회한다
select empno, ename, sal, sal+300 as sal2 from emp;
  
--문제4) EMP 테이블에서 사원번호, 이름, 급여보너스를 출력하여라.
select empno, ename, comm from emp

--문제5) EMP 테이블에서 ENAME를 NAME로 SAL을 SALARY로 출력하여라.
select ename as name, sal as salary from emp;

--문제6) EMP 테이블에서 ENAME를 Name로 SAL*12를 Annual Salary 로 출력하여라.
select ename as "Name", sal*12 as "Anual Salary" from emp;

--문제7) EMP 테이블에서 ENAME를 '성 명'으로, SAL를 ‘급 여'로  출력하여라.
select ename as "성 명", sal as "급 여" from emp;

--문제8) EMP 테이블에서 이름과 업무를 연결하여 출력하여라.
select ename || job from emp;

--문제9) EMP 테이블에서 이름과 업무를 "King is a PRESIDENT" 형식으로 출력하여라.
select ename || ' is a ' || job from emp;

--문제10) EMP 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 
select ename || ': 1 year salary = ' ||(sal *12) from emp;

--문제11) EMP 테이블에서 JOB을 모두 출력하여라.
select job from emp;

--문제12) EMP 테이블에서 담당하고 있는 업무의 종류를 출력하여라.
select distinct job from emp;

--문제13) EMP 테이블이 부서번호를 중복 값을 제거해서 조회하라
select distinct deptno from emp;

--문제14) 부서별로 담당하는 업무를 한번씩 출력하여라.
select distinct deptno, job from emp;

--문제15) EMP 테이블에서 사원번호, 이름, rowid를 조회하라.
select empno, ename, rowid from emp;

--문제17) EMP 테이블에서 급여가 3000 이상인 사원의 사원번호, 이름, 담당업무, 급여를 출력하라.
select empno, ename, job, sal from emp where sal >= 3000;

--문제18) EMP 테이블에서 담당업무가 Manager인 사원의 정보를 사원정보, 성명, 담당업무, 급여, 부서번호를 출력하라.
select empno, ename, job, sal, deptno from emp where job = 'MANAGER';

--문제19) EMP 테이블에서 1982년 1월 1일 이후에 입사한 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
select empno, ename, job, sal, hiredate, deptno from emp where hiredate >= '82/01/01';

--문제20) EMP 테이블에서 급여가 1300에서 1700사이의 사원의 성명, 담당업무, 급여, 부서 번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where sal between 1300 and 1700;


--문제21) EMP 테이블에서 사원업호가 7902, 7788, 7566인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하여라.
select ename, job, sal, deptno from emp where empno in (7902, 7788,7566);

--문제22) EMP 테이블에서 입사일자가 82년도에 입사한 사원의 사번, 성명, 당당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where hiredate like '82%';

--문제23) EMP 테이블 이름의 첫 글자가 'M'인 사원의 이름, 급여 조회하라
select ename, sal from emp where ename like 'M%';

--문제24) EMP 테이블 이름의  두 번째 글자가 ‘L'인 사원의 이름,업무를  조회하라
select ename, job from emp where ename like '_L%';

--문제25) EMP 테이블에서 보너스가 NULL인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where comm is null;

--문제26) EMP 테이블에서 급여가 1100 이상이고 JOB이 Manager인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp where sal >= 1100 and job = 'MANAGER';


--문제27) EMP 테이블에서 급여가 1100 이상이거나 JOB이 Manager인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하여라.
select empno, ename, job, sal, hiredate, deptno from emp
where sal >= 1100 or job = 'MANAGER';

```



#### SQL의 단점

- 조건처리 : 함수
- 반복처리
  - table의 행 단위 반복처리
  - 명시적 for / while 안 됨
- exception 처리 안 됨
- 변수사용 안 됨 (mysql 등등 되는 DBMS도 있긴 함)

> ***"이런 단점들을 함수로 커버한다."***



####  함수

- predefine - DB벤더 (nvl, sysdate, user, ...)
- custom(PL/SQL)
- 단일행 함수
  - Character
  - Number
  - Date
  - Null, 기타
  - Conversion
- 복수행 함수 - input으로 all row 혹은 grouped row
- 분석함수(Window 함수)



##### Character to Character Functions

- initcap(), lower(), upper()
- length(), lengthb()
- concat()

```sql
select initcap(ename), lower(ename), upper(ename) from emp;

select length('korea'), length('대한민국') from dual;

select lengthb('korea'), lengthb('대한민국') from dual;

--함수 안에 함수를 nested하면  nested된 함수부터 처리
select concat(concat(ename, ' is '), job) from emp;

```

- substr()

```sql
select 
    substr('today is 2015년 4월 26일', 1, 5),
    substr('today is 2015년 4월 26일', 10, 5),
    substr('today is 2015년 4월 26일', 15),
    substr('today is 2015년 4월 26일', -3, 2)
from dual;

select 
    instr('Korea is wonderful', 'o') as a,
    instr('Korea is wonderful', 'o', 1, 2) as b,
    instr('Korea is wonderful', 'o', 9) as c,
    instr('Korea is wonderful', 'x') as d
from dual;

```

- lpad(), rpad() : padding

  ```sql
  select ename, sal, lpad(sal, 10, '*') from emp;
  select ename, sal, rpad(sal, 10, '*') from emp;
  ```

- trim(), ltrim(), rtrim() 

  ```sql
  select length('  hello  '), length(trim('  hello  ')) from dual;
  
  select trim('H' from 'Hello wonderful'), trim('l' from 'Hello wonderful') from dual;
  
  select ltrim('Hello wonderful', 'He' ), rtrim( 'Hello wonderful' , 'ful') from dual;
  ```

- replace()

  ```sql
  select replace('Jack AND Jue', 'J', 'Bl') from dual;
  ```

- translate()

  ```sql
  SELECT TRANSLATE('SQL*Plus User''s Guide', ' */''', '___') FROM DUAL;
  ```

  

##### Number Functions

- round()

  ```sql
  select round(12.345, 2), round(12.345, 0), round(12.345, -1) from dual;
  
  -- 12.35  /   12   / 10
  ```

- trunc()

  ```sql
  select trunc(12.345,2), trunc(12.345), trunc(12.345, -1) from dual;
  
  -- 12.34  /  12  /  10
  ```

- mod()

  ```sql
  select mod(99, 4) from dual;
  
  --사원 번호가 홀수인 사원 출력
  select empno, ename from emp where mod(empno, 2) = 1;
  ```

- ceil()

  ```sql
  select ceil(12.345), floor(12.345) from dual;
  ```

- power()

  ```sql
  select power(3, 2), power(5, 2)from dual;
  ```



##### Date Function

*참고*

>timestamp컬럼 타입 (YYYY/MM/DD HH24:MI:SS.SSSSSSSSS)
>
>timestamp(3) #6이 defaul
>
>timstamp with time zone
>
>-sysdate 시스템의 현재 시각 리턴
>
>-current_date
>
>-current_timestamp

```sql
alter session set nls_date_format='YYYY-MM-DD HH24:MI:SS';

-- ?
select sessiontimezone from dual;

-- ?
alter session set time_zone =  '+03:00';

select sysdate, current_date, current_timestamp from dual;


```

- add_months(date, n) - 개월 수를 더한 날짜가 리턴

  ```sql
  select add_months('87/01/01', 3) from dual;
  select hiredate, add_months(hiredate, 6) from emp;
  ```

- months_between(date, date) - 기간이 리턴

  ```sql
  select months_between(sysdate, hiredate) from emp;
  ```

- next_day(date, '요일명')

  ```sql
  select next_day(sysdate,'목') "NEXT DAY" from dual;
  ```

- trunc()

  ```sql
  select trunc(to_date('14/02/14'), 'MONTH'), trunc(to_date('14/02/14'), 'YEAR') from dual;
  ```

- round()

  ```sql
  select round(to_date('14/02/14'), 'MONTH'), round(to_date('14/02/14'), 'YEAR') from dual
  ```

###### 문제

```sql
--사원들의 입사 날짜로부터 6개월 후 날짜로부터 다음 금요일이 연봉 조정 면담 날짜 입니다. 사원들의 사번과 입사날짜와 연봉 조정 면담날짜를 출력하세요.
select empno, ename, hiredate, next_day( add_months(hiredate, 6), '금' ) as 연봉조정날짜 from emp;
```

*참고*

>to_date(날짜문자열. format)
>
>```select '2019-05-30 5:43 PM', to_date('2019-05-30 5:43', 'YYYY-MM-DD HH12:MI') from dual;```
>
>***to_char(날짜, format)***
>
>```select sysdate, to_char(sysdate, 'YYYY"년" MM"월" DD"일"') from dual;```
>
>***to_char(숫자, format)***
>
>```select to_char(123456.789, '$9,999,999.9999') from dual;```
>
>***to_number(문자열, format)***
>
>```select to_number('$1,234,567.999', '$99,999,999.9999') from dual;```



#### RR 과 YY - *책봐라*






















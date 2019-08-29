# Database

특정 기업이나 조직 또는 개인이 필요에 의해 논리적으로 연관된 데이터를 모아 일정한 형태로 저장해 놓은 것

> 비즈니스 목적으로 트렌젝션 처리를 위해서 모아놓은, 여러 사용자들이 공유하는 데이터 저장 집합

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

  - 선택 SELECT
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

```sql
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

> sqlplus 툴  - sql 실행, 결과 보여주는 환경 제공
>
> sqlplus 툴 명령어 - 세미콜론(;) 없이 사용 가능, 명령어 축약 사용 가능
>
> sql문은 명렁어 축약 불가, 반드시 한 문장은 세미콜론(;) 으로 종료



*참고*

> char(1) ~2000byte
> varchar2(1) ~4000byte
> number타입 binary형식으로 정수, 실수
> date 날짜를 7byte를 사용해서 수치값으로 저장 (__세기, __년도 __월 __일 __시 __분 __초)
>
> select sysdate from daul; --시스템 현재 시간을 리턴하는 함수

```sql
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

```sql
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





------

#### Projection

- select
- distinct - 중복 제거

```sql
select ename, sal, job, deptno from emp;

select deptno from emp;

select distinct deptno from emp; -- hashing방식 사용해서 중복값 제거

select deptno, distinct job from emp; --?
```

- expression

  - number 타입 컬럼은 산술연산 가능 : +, -, *, /

    ```select sal, sal+100, sal-100, sal*2, sal/100 from emp;```

  - char / varchar2 타입 컬럼은 문자열 결함 : ||

    ```select ename || 'is work as  ' || job from emp;```

  - date 타입 컬럼 : date ±  n, date ± date, date ± 1/n

    ※ 문자,날짜 데이터는 반드시 ' '를 사용해서 표현, 처리

    ※ 날짜 데이터 세션에 설정된 포맷 형식하고 일치해야 합니다. ('RR/MM/DD')

- as (alias)

- 

*참고*

> 데이터가 추가될 대 입력되지 않은 컬럼값은 null 이다.
>
> null은 아직 값이 없다는 의미입니다. 0 도 아니고 ' '도 아닙니다.
>
> null 은 산술연산 수행 결과가 항상 null입니다.
>
> null을 포함하는 컬럼들은 null아닌 값으로 변환 후에 산술연산을 수행해야 합니다.
>
> 모든 DBMS에서는 null 아닌 값으로 변환해주는 내장 함수를 제공합니다.
>
> nvl(clumn, null일때 변환하고 싶은 값)
>
> null은 비교연산, 논리연산 모두 null이 결과입니다



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

> ※ select~ from절이 필수절입니다.
> ※ 단순계산 결과, 함수 결과, 문자 데이터 출력등은 dual테이블을 사용합니다





------

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



#### 함수

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

> timestamp컬럼 타입 (YYYY/MM/DD HH24:MI:SS.SSSSSSSSS)
>
> timestamp(3) #6이 defaul
>
> timstamp with time zone
>
> -sysdate 시스템의 현재 시각 리턴
>
> -current_date
>
> -current_timestamp

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

> to_date(날짜문자열. format)
>
> ```select '2019-05-30 5:43 PM', to_date('2019-05-30 5:43', 'YYYY-MM-DD HH12:MI') from dual;```
>
> ***to_char(날짜, format)***
>
> ```select sysdate, to_char(sysdate, 'YYYY"년" MM"월" DD"일"') from dual;```
>
> ***to_char(숫자, format)***
>
> ```select to_char(123456.789, '$9,999,999.9999') from dual;```
>
> ***to_number(문자열, format)***
>
> ```select to_number('$1,234,567.999', '$99,999,999.9999') from dual;```



#### RR 과 YY - *책봐라*



***참고*** - *오라클 DB를 깨끗하게 지우려면*

> 1. 서비스(services.msc)에러 Oracle~ 서비스 시작되어 있는 것 모두 중지
> 2. 레지스트리에서 Oracle 관련 정보 삭제
>
> a. regedit
>
> b. HKEY_LOCAL_MACHINE > SOFTWARE > Oracle 디렉토리 삭제
>
> c. HKEY_LOCAL_MACHINE > System > CurrentControlSet > services > Oracle 디렉토리들삭제
>
> d. HKEY_LOCAL_MACHINE > System > CurrentControlSet > services > event log > Applicatoin Oracle 디렉토리들 삭제
>
> 3. 탐색기 C:\Program Files 아래 Oracle 디렉토리 삭제
> 4. 윈도우 프로그램 메뉴 Oracle 메뉴 디렉토리 삭제
> 5. C:\app 삭제



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



------

#### 기타함수

- nvl(column, expression)

  column값이 null 일경우 expression을 리턴

  column과 expression이 동일한 타입이어야 한다.

  

- nvl(column, expression1, expression2)

  column값이 null이 아니면 e1, 아니면 e2를 리턴.

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
select avg(sal) from emp group by deptno;

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





------

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
    - cartesian product - 조인 조건을 생략하거나, 조인 조건을 논리적으로 잘못 지정하여 두 테이블의 모든 row가 한 번씩 join되는 것

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
    from tab1 a join tab1 b on a.col = b.col2
    
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





------

### Subquery

조건 값을 알수 없어서 query를 2번 수행해야 하는 경우 subquery를 활용할 수  있습니다.

```subquery = inner query = nested query```

- subquery 는 mainquery의 select절, from절,  where절,  having절, order by 절에 subquery가 정의될 수 있습니다.
- where 절과 having절의 subquery는 연산자 오른쪽에 ()안에 정의합니다.
- 단일 행을 리턴하는 subquery : *single row subquery*
- 복수 행을 리턴하는 subquery : *multiple row subquery*
- 단일 행, 단일 컬럼값을 리턴 subquery : *scalar subquery*
- 두개 이상의 컬럼 값을 리턴하는 subquery : *multiple column subquery*
- where 절에 single row subquery를 사용할 경우 반드시 single row operator를 사용: ***>, >=, <=, < =, <>***
- where 절에 multiple row subquery를 사용할 경우 반드시 multiple row operator를 사용:  ***in, any, all***

```sql
--문> ADAMS 보다 급여를 많이 받는 사원
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
	sal > any (
        select 
        	sal 
       	from 
        	emp 
        where 
        	job = 'SALESMAN'
    )
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
    	where deptno = 80
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

--co-related subquery 로??? (어렵네...., 성능면에서 비추)
select 
	a.employee_id, a.last_name
from 
	employees a
where 
	2 <= (
    	select 
        	count(employee_id) 
        from 
        	job_history
        where a.employee_id = employee_id
    );
```



- ***where exists (co-related subquery)***

  ```sql
  --문>subquery를 사용해서 관리자인 사원들만 검색
  select 
  	*
  from 
  	emp
  where 
  	empno in (
          select distinct mgr from emp
      );
  -->>>>>>> where exists 
  select 
  	*
  from 
  	emp a
  where 
  	exists (
          select '1'
          from emp 
          where a.empno = mgr
      );
  
  --문>subquery를 사용해서 관리자가 아닌 사원들만 검색
  --subquery의 모든 값을 비교해야 하는 연산에서는 null 포함되어 있는지 여부를 먼저 체크해서 null을 처리하거나 제외시켜야 합니다.
  select  *
  from emp
  where empno not in (
          select distinct mgr 
      	from emp
          where mgr is not null
      );
  -->>>>>>> where exists 
  select *
  from emp a
  where not exists(
      	select '1'
          from emp 
  		where a.empno = mgr
  );
  
  ```

  

- with 절 *(고급 sql, 이런 것도 있다....)*

  ```sql
  --conn hr/oracle
  --문> 부서별 총 급여가 전체 부서의 총급여 평균보다 큰 부서번호와 총급여를 출력합니다.
  
  with
  dept_sum as ( select department_id, sum(salary) as sum_sal
              from employees
              group by department_id),
  emp_avg as ( select avg(sum_sal) as  total_avg
              from dept_sum)
  select a.department_id, a.sum_sal
  from dept_sum a, emp_avg b
  where a.sum_sal > b.total_avg;
  
  ```

  

- 집합 연산자

  UNION, UNION ALL, MINUS, INTERSECT

  ```sql
  --conn hr2/orcle
  desc employees
  desc job_history
  
  --문> 20명 사원의 현재와 과거의 모든 부서, 직무 이력을 출력
  --동일한 직무와 부서 근무 이력은 중복 데이터로 출력
  -- UNION ALL
  select employee_id, job_id, department_id
  from employees
  UNION ALL
  select employee_id, job_id, department_id
  from job_history;
  
  --문> 20명 사원의 현재와 과거의 모든 부서, 직무 이력을 출력
  --동일한 직무와 부서 근무 이력은 한번만 결과 데이터로 출력
  -- UNION
  select employee_id, job_id, department_id
  from employees
  UNION 
  select employee_id, job_id, department_id
  from job_history;
  
  --문> 20명 사원중 의 현재 직무와 부서를 과거에 동일한 부서와 직무를 담당한 사원 조회 (사원번호, 직무, 부서번호)
  -- INTERSECT
  select employee_id, job_id, department_id
  from employees
  INTERSECT
  select employee_id, job_id, department_id
  from job_history;
  
  --문> 입사한 이후에 한 번도 직무나 부서를 변경한 적이 없는 사원번호 출력
  select employee_id, job_id, department_id
  from employees
  MINUS
  select employee_id, job_id, department_id
  from job_history;
  
  --conn scott/oracle
  --문>  전체 사원들의 급여 평균과
  --    부서별 사원들의 급여 평균과 
  --    부서와 직무별 사원들의 급여 평균을 단일 결과 집합으로 출력합니다.
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
  
  ```



- group by ***rollup***

  group by rollup (A, B)

  -> group by (A, B)

  -> group by (A)

  -> group by ()

  ```sql
  --문>  전체 사원들의 급여 평균과
  --    부서별 사원들의 급여 평균과 
  --    부서와 직무별 사원들의 급여 평균을 단일 결과 집합으로 출력합니다.
  
  select deptno, job, avg(sal)
  from emp
  group by rollup (deptno, job);
  ```

  

- group by ***cube***

  group by cube (A, B)

  -> group by (A, B)

  -> group by (A)

  -> group by (B)

  -> group by ()

  ```sql
  --문>  전체 사원들의 급여 평균과
  --    부서별 사원들의 급여 평균과 
  --    직무별 사원들의 급여 평균과
  --    부서와 직무별 사원들의 급여 평균을 단일 결과 집합으로 출력합니다.
  
  select deptno, job, avg(sal)
  from emp
  group by cube (deptno, job);
  
  ```

  

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

  

  ------

  

- **grouping sets**

  rollup 으론 모자르고, cube로는 넘칠 때 사용. 효율이 rollup, cube 만큼 좋진 않지만 쓸만함.

  ```sql
  select deptno, job, mgr, avg(sal)
  from emp
  group by grouping sets ((deptno, mgr), (mgr), (job), ());
  ```

  

------



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

> 수행중인 DML 트랜잭션의 세션이 비정상종료하면 oracle server는 rollback 합니다.
>
> 수행중인 DML 트랜잭션의 세션이 정상종료(exit;)하면 oracle server는 commit 합니다.



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

  > ***제약조건 constraint*** - table의 DML 수행시 규칙
  >
  > Primary Key, not null, Unique Key, Foreign Key, check





## 14. 제약조건

```sql
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
values ( '테스터2', 25);    ---userid는 null? --> 가능

insert into userinfo  (username, age)
values ( '테스터3', 30);    ---userid는 null? --> 가능 

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
values ( '테스터2', 25);    ---userid는 null? --> PK는 null 안 됨

insert into userinfo  (username, age)
values ( '테스터3', 30);    ---userid는 null? --> PK는 null 안 됨

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
insert into userinfo  values ('a001', 'an', null, 20); -- OK


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

~~~sql
    
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
    
~~~

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

  > 참조무결성제약조건 오류 : 참조하는 자식 레코드가 존재하면 부모 레코드는 삭제할 수 없습니다.
  > ex) 부서테이블의 레코드를 삭제하려면 소속 사원이 없는 부서정보 레코드만 삭제 가능합니다.



- ETL 작업에 사용하는 하나의 DML로 insert, update, delete 수행

  ```sql
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

    

------



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



------



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

  ```sql
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



------





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



------



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

  

### 복습

- 테이블 컬럼 추가

  ```sql
   alter table ~ add (컬럼 컬럼타입 [제약조건]);
  ```

  

- 테이블 컬럼 삭제

  ```sql
  alter table ~ drop column 컬럼명;
  alter table ~ drop (컬럼, 컬럼);
  ```

  

- 테이블 컬럼 이름 변경

  ```sql
  alter table ~ rename column old컬럼명 to new컬럼명;
  ```



- 테이블 컬럼타입 또는 size 변경

  ```sql
  alter table ~ modify (컬럼 컬럼타입(size));
  ```

  

- 제약조건을 컬럼 추가

  ```sql
  alter table ~ add constraint 이름 타입;
  ```

  

- 컬럼에 정의되어 있는 제약조건 삭제

  ```sql
  alter table ~ drop constraint 이름;
  ```



- 제약조건을 활성화

  ```sql
   alter table ~ enable constraint 이름;
  ```

  

- 제약조건을 비활성화

  ```sql
  alter table ~ disable constraint 이름;
  ```

  

- 테이블 삭제

  ```sql
  drop table ~;
  drop table ~ purge;
  
  ```

  

- recyclebin으로부터 drop 테이블 복원

  ```sql
  flashback table ~ to before drop;
  
  ```

  

- 테이블의 구조는 그대로 두고 데이터만 물리적으로 삭제시키고 사용했던 공간 할당을 그대

  ```sql
  truncate table ~
  
  ```

  

- View

  > 논리적 테이블, table에 대한 window

  - Simple view

    DML이 가능한 뷰(base table의  not null 컬럼 모두 포함. 표현식 X, 그룹핑 X, rowid X, rownum X).

  - Complex View

    DML이 불가능한 뷰(2개 이상의 테이블로부터 join 포함, 그룹핑, 함수 표현식 등이 포함된 경우)

  - 사용목적

    보안, 간결한 sql 사용

  ```sql
  create [or replace ] [force|noforce] view 뷰이름 
  as 
    select ~
    from ~
    [where ~]
    [group by ~]
    [having ~]
    [order by ~]
    [with check option]  ---체크 제약 조건
    [with read only]  --read only 제약조건
  
  ```

  - 테이블 삭제하면

    구조, 데이터, 제약조건, 인덱스 함께 삭제됩니다.

  - 테이블에 대한 view가 존재하는데 테이블이 삭제(drop)되면

    view는 status가 invalid 상태로 변경되어 사용이 불가능해 짐



- Index

  > 검색 속도를 향상(select 수행 성능향상) 을 위해서 사용하는 객체

  - b*tree index
  - bitmap index
  - 단일 컬럼 인덱스
  - 복합 컬럼 인덱스
  - function based index - 컬럼표현식의 결과값으로 인덱스 생성

  ```sql
  create index ~ on 테이블(컬럼 [desc]);
  alter index ~ on 테이블(컬럼....);
  drop index ~ ;
  
  ```

  

- Sequence

  > 최소값 ~ 최대값 범위내에서 설정된 증감값에 따라 정수를 생성하는 객체

  ```sql
  create sequence ~
      [start with ~]
      [increment by ~]
      [minvalue ~ | nominvalue]
      [maxvalue ~ } nomaxvalue]
      [cache n | nocache]
      [cycle } nocycle];
  
  alter sequence ~; --단, start with 는 변경 못함
  drop sequence ~;
  
  ```



- Synonym

  > 'schema.객체@dblink명' 처럼 긴 객체이름을 간결하게 줄여서 쓰려면 동의어를 사용한다

  ```sql
  create synonym ~ for schema.객체@dblink명;
  
  ```

  

- 권한

  > 데이터베이스에 connect 하려면 대상 데이터베이스에 user명이 등록되어 있어야하며, 인증방식도 정의되어 있어야 한다. 또한 create session 권한이 있어야 한다.

  ```sql
  create user ~ --권한은 DBA(sys, system, drop user~로 삭제 없음)
  	indentified by 비밀번호
  	[default tablespace ~]
      [temp tablespace ~]
      [tablespace quota XXM]
      [profile ~]
      [consumer group ~]
      
  grant 권한, ..., to user명, ..., role명, ..., public;
  revoke 권한, ..., from user명, ..., role명, ..., public;
  
  ```

  - 권한의 종류

    - 시스템 권한 - DBA
    - 객체 권한 - 객체의 소유자, DBA

  - **role**

    > 특정 업무, 직무와 연관된 권한들을 그룹핑한 것

  - 객체 권한 부여

    ```sql
    grant 권한,...on 객체[(컬럼,...)] to user명,..., role명,...public;
    revoke 권한,...on 객체[(컬럼,...)] from user명,..., role명,...public;
    
    ```

    

- JDBC

  - JDBC 프로그래밍 단계

    1. 연결할 데이터베이스의 driver class 클래스 (~.jar) 준비

       - 운영체제의 환경 변수 classpath에 추가
       - JDK또는 JRE의 라이브러리 검색 위치중에 외부 확장 라이브러리 저장위치(%JAVA_HOME%jre/lib/ext)
       - 이클립스(IDE)에서 프로젝트 build path>configure build path>library>add external jar ... 추가

    2. import java.sql.*;

    3. DriverClass 로딩

       ```java
       try {
       	Class.forName(" "); // oracle.jdbc.OracleDriver
       }catch(ClassNotFoundException e){
           System.out.println(e.getMessage());
       }
       
       
       ```

    4. static 멤버 객체 이용

       ```java
       Connection con;
       ...
       con = DriverManager.getConnection(url, user, pwd); //DB에 connect 합니다. DB에 세션 생성되고, 세션이 리턴됩니다. => java.sql.Connection 객체로 받습니다.
       
       ```

       Connection의 주요메서드

       - close()
       - createStatement()
       - preparedStatement()
       - callableStatement()
       - 

    5. SQL 실행 대행 객체 Statement 객체 생성

       - Statement 

         *완전한 sql 문장을 문자열로 전송하므로 매번 hard parsing 할 가능성이 높다.*

       - PreparedStatement

         *sql 문중중에서 변경되는 부분들을 ?(index parameter)로 성정해서 미리 sql을 전송하고, 실행할 때 마다 값만 전송해서 실행(soft parsing 수행 될 확률이 높다).*

       - CallableStatement

         *DB에 저장되어 있는 procedure, function을 호출해서 결과를 받을때*

    6. SQL문 실행

       - executeQuery() - select 문장, ResultSet 객체 리턴
       - executeUpdate() - DML문은 int(변경된 행수) 리턴, DDL, DCL문
       - execute() - select문, DML문, boolean 리턴(true 일 때는 select 수행, false)

    7. select 구행 결과 처리

       ```java
       while(rs.next()) {
           rs.getInt("컬럼명" | 컬럼포지션), 
           rs.getDouble("컬럼명" | 컬럼포지션), 
           rs.getString("컬럼명" | 컬럼포지션),
           rs.getDate("컬럼명" | 컬럼포지션),
           ...
       }
       
       ```

    8. SQLException 예외 처리

    9. 사용 자원 반납(Connection, Statement, ResultSet)

       ```java
       XXX.close(); // 예외처리 필요
       
       ```

  - 접속 정보 보안 처리

    > 소스코드에 db연결정보를 hard coding하는 것은 보안상 문자가 되므로 보안 폴더에 properties파일을 만들고 key=value형태로 저장합니다.

    ```java
    Properties prop = new Properties();
    prop.load(new FileInputStream("경로/이름.."));
    String value = prop.getProperty("key");
    
    ```

    

------



### JDBC Transaction 처리

- Table 준비

  ```sql
  create table product (
      id varchar2(20),
      price number(8)
  );
  
  insert into product values ('사과', 1000);
  insert into product values ('복숭아', 1500);
  insert into product values ('포도', 2000);
  insert into product values ('망고', 3000);
  insert into product values ('수박', 3500);
  
  commit;
  
  
  ```

  

- TransactionTest.java

  ```java
  package lab.java.core;
  
  import java.io.FileInputStream;
  import java.io.IOException;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.SQLException;
  import java.sql.Savepoint;
  import java.sql.Statement;
  import java.util.Properties;
  
  public class TransactionTest {
  
  	public static void main(String[] args) {
  
  		Connection con = null; //DB 연결상태 세션 저오 저장
  		PreparedStatement selectPs = null;
  		PreparedStatement updatePs = null;
  		ResultSet rs = null;
  		String query = "SELECT id, price FROM product WHERE price > ?";
  		String update = "UPDATE product SET price = ? WHERE id = ?";
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
  			
  			con.setAutoCommit(false); //명시적 트랜잭션 제어를 위해
  			
  			selectPs = con.prepareStatement(query);
  			updatePs = con.prepareStatement(update);
  			
  			selectPs.setInt(1,  100);
  			rs = selectPs.executeQuery();
  			
  			Savepoint save1 = con.setSavepoint();
  			while(rs.next()) {
  				String id = rs.getString("id");
  				int oldPrice = rs.getInt("price");
  				int newPrice = (oldPrice * 2);
  				updatePs.setInt(1,  newPrice);
  				updatePs.setString(2,  id);
  				updatePs.executeUpdate(); 
  				System.out.println("New Price of " + oldPrice + " is " + newPrice);
  				if(newPrice >= 5000) {
  					con.rollback(save1);
  				}
  			}//while end
  			
  			System.out.println();
  
  			selectPs.setInt(1, 100);
  			rs = selectPs.executeQuery();
  			
  			Savepoint save2 = con.setSavepoint();
  			while(rs.next()) {
  				String id = rs.getString("id");
  				int oldPrice = rs.getInt("price");
  				int newPrice = (oldPrice * 2);
  				updatePs.setInt(1,  newPrice);
  				updatePs.setString(2,  id);
  				updatePs.executeUpdate(); 
  				System.out.println("2. New Price of " + oldPrice + " is " + newPrice);
  				if(newPrice >= 5000) {
  					con.rollback(save2);
  				}
  			}//while end
  			con.commit();
  			System.out.println();
  			
  			Statement stmt = con.createStatement();
  			rs = stmt.executeQuery("SELECT id, price FROM product");
  			
  			System.out.println();
  			while(rs.next()) {
  				String id = rs.getString("id");
  				int price = rs.getInt("price");
  				System.out.println("id : " + id + ", price : " + price);
  			}
  			
  		}
  		catch(ClassNotFoundException e) {
  			System.out.println("Driver 없음");
  		}
  		catch(SQLException e) {
  			System.out.println(e.getMessage()); //DB 연결 실패
  		}
  		catch(IOException e) {
  			System.out.println(e.getMessage()); //Properties
  		}
  		finally {
  			try {
  				if(rs != null) rs.close();
  				if(selectPs != null) selectPs.close();
  				if(updatePs != null) updatePs.close();
  				if(con != null) con.close();
  			}
  			catch(Exception e) {
  				e.printStackTrace();
  			}
  		}//finally end
  		
  	}//main end
  
  }//class end
  
  
  ```

  

### ResultSetMetaData

- GetMetaData.java

  ```java
  package lab.java.core;
  
  import java.io.FileInputStream;
  import java.io.IOException;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.ResultSetMetaData;
  import java.sql.SQLException;
  import java.util.Properties;
  
  public class GetMetaData {
  
  	public static void main(String[] args) {
  
  		Connection con = null; //DB연결상태 세션 저오 저장
  		PreparedStatement stat = null;
  		String sql = "select * from emp";
  		ResultSet rs = null;
  		ResultSetMetaData rsmd = null;
  		try {
  			Properties prop = new Properties();
  			prop.load(new FileInputStream("C:/workspace/day14/src/dbinfo.properties"));
  			
  			Class.forName(prop.getProperty("driver"));
  			System.out.println("Driver loading 성공");
  			con = DriverManager.getConnection(
  					prop.getProperty("url"), 
  					prop.getProperty("user"), 
  					prop.getProperty("pwd")
  			);
  			System.out.println("db connect 성공");
  			
  			stat = con.prepareStatement(sql);
  			rs = stat.executeQuery();
  			rsmd = rs.getMetaData();
  			System.out.println("컬럼이름\t\tNull허용?\t\t컬럼타입");
  			System.out.println("============================================");
  			for(int i = 0; i < rsmd.getColumnCount(); i++) {
  				System.out.print(rsmd.getColumnName(i+1)+"\t");
  				if(rsmd.isNullable(i+1) == 0 ) {
  					System.out.print("\tNot Null\t");
  				}
  				else {
  					System.out.print("\t\t\t");
  				}
  				
  				System.out.print(rsmd.getColumnTypeName(i+1));
  				if(rsmd.getColumnTypeName(i+1).contentEquals("VARCHAR2")) {
  					System.out.print("("+rsmd.getPrecision(i+1)+")");
  				}
  				if(rsmd.getColumnTypeName(i+1).contentEquals("NUMBER")) {
  					if(rsmd.getScale(i+1) > 0) {
  						System.out.print("("+rsmd.getPrecision(i+1)+ "," + rsmd.getScale(i+1) + ")");
  					}
  					else {
  						System.out.print("("+rsmd.getPrecision(i+1)+")");
  					}
  				}
  				
  				System.out.println();
  			}
  			
  		}
  		catch(ClassNotFoundException e) {
  			System.out.println("Driver 없음");
  		}
  		catch(SQLException e) {
  			System.out.println(e.getMessage()); //DB 연결 실패
  		}
  		catch(IOException e) {
  			System.out.println(e.getMessage()); //Properties
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



### JDBC 종합 실습 (Book Workshop)

- 테이블 준비

  ```sql
  drop table book purge;
  
  create table Book (
      isbn varchar2(5) constraint book_isbn_pk primary key,
      category varchar2(15),
      title varchar2(50),
      author varchar2(30),
      price number(6),
      descript varchar2(500)
  );
  
  insert into book (isbn, title, category, price, descript)
  values('M0001', 'Cooking Light', 'living, cooking', 15000, 'America Cooking');
  
  insert into book (isbn, title,  author, price)
  values('N0001', 'The Confession', 'Grisham, John', 10500);
  
  commit;
  
  ```



- BookUtil.java

  ```java
  package lab.jdbc.util;
  
  import java.util.Scanner;
  
  import java.util.Scanner;
  
  public class BookUtil {
  	
  	public static String getUserInput() {
  		Scanner sc = new Scanner(System.in);
  		return sc.nextLine();
  	}
  	
  	public static void printHeader() {
  		System.out.println("-------------------------------------- 도서 정보 --------------------------------------");
  	}
  	
  	public static void printTail() {
  		System.out.println("------------------------------------------------------------------------------------");
  	}
  }
  
  
  
  ```

  

- Book.java

  ```java
  package lab.jdbc.entity;
  
  public class Book {
  	private String isbn;
  	private String category;
  	private String title;
  	private String author;
  	private int price;
  	private String descript;
  	
  	public Book() {
  		super();
  		
  	}
  	
  	public Book(String isbn, String title, int price) {
  		super();
  		this.isbn = isbn;
  		this.title = title;
  		this.price = price;
  	}
  
  	public Book(String isbn, String title, String author, int price) {
  		this(isbn, title, price);
  		this.author = author;
  		
  	}
  
  	public Book(String isbn, String category, String title, int price, String descript) {
  		this(isbn, title, price);
  		this.category = category;
  		this.descript = descript;
  	}
  
  	public String getIsbn() {
  		return isbn;
  	}
  
  	public String getCategory() {
  		return category;
  	}
  
  	public String getTitle() {
  		return title;
  	}
  
  	public String getAuthor() {
  		return author;
  	}
  
  	public int getPrice() {
  		return price;
  	}
  
  	public String getDescript() {
  		return descript;
  	}
  
  	public void setIsbn(String isbn) {
  		this.isbn = isbn;
  	}
  
  	public void setCategory(String category) {
  		this.category = category;
  	}
  
  	public void setTitle(String title) {
  		this.title = title;
  	}
  
  	public void setAuthor(String author) {
  		this.author = author;
  	}
  
  	public void setPrice(int price) {
  		this.price = price;
  	}
  
  	public void setDescript(String descript) {
  		this.descript = descript;
  	}
  
  	@Override
  	public String toString() {
  		String info = null;
  		if(isbn.startsWith("N")) {
  			info = "소설 [isbn=" + isbn + ", title=" + title + ", author=" + author 
  					+ ", price=" + price + "]";
  		}
  		else {
  			info = "잡지 [isbn=" + isbn + ", category=" + category + ", title=" + title 
  					+ ", price=" + price + ", descript=" + descript + "]";
   		}
  				
  		return info;
  	}
  	
  }
  
  ```

  

- BookBiz.java

  ```java
  package lab.jdbc.biz;
  
  import java.io.FileInputStream;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.Properties;
  
  import lab.jdbc.entity.Book;
  import lab.jdbc.util.BookUtil;
  
  public class BookBiz {
  //	private ArrayList<Book> books;
  	
  	public BookBiz() {
  		super();
  	}
  	
  	public Connection dbCon() {
  		Connection con = null;
  		try {
  			Properties prop = new Properties();
  			prop.load(new FileInputStream("C:/workspace/day13/src/dbinfo.properties"));
  			
  			Class.forName(prop.getProperty("driver"));
  //			System.out.println("Driver loading 성공");
  			con = DriverManager.getConnection(
  					prop.getProperty("url"), 
  					prop.getProperty("user"), 
  					prop.getProperty("pwd")
  			);
  //			System.out.println("db connect 성공");
  			
  			
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		
  		return con;
  	}
  	
  	public void dbClose(Connection con, Statement stat, ResultSet rs) {
  		try {
  			if(rs != null) rs.close();
  			if(stat != null) stat.close();
  			if(con != null) con.close();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	public void printAllBooks() {
  		Connection con = null;
  		Statement stat = null;
  		String sql = "select * from book";
  		ResultSet rs = null;
  		try {
  			con = dbCon();
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			BookUtil.printHeader();
  			while(rs.next()) {
  				Book book = new Book();
  				book.setIsbn(rs.getString("isbn"));
  				book.setTitle(rs.getString("title"));
  				book.setAuthor(rs.getString("author"));
  				book.setPrice(rs.getInt("price"));
  				book.setCategory(rs.getString("category"));
  				book.setDescript(rs.getString("descript"));
  				System.out.println(book);
  			}
  			BookUtil.printTail();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	public void printAllNovels() {
  		Connection con = null;
  		Statement stat = null;
  		String sql = "select * from book where isbn like 'N%'";
  		ResultSet rs = null;
  		try {
  			con = dbCon();
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			BookUtil.printHeader();
  			while(rs.next()) {
  				Book book = new Book();
  				book.setIsbn(rs.getString("isbn"));
  				book.setTitle(rs.getString("title"));
  				book.setAuthor(rs.getString("author"));
  				book.setPrice(rs.getInt("price"));
  				book.setCategory(rs.getString("category"));
  				book.setDescript(rs.getString("descript"));
  				System.out.println(book);
  			}
  			BookUtil.printTail();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, rs);
  		}
  	}
  	
  	public void printAllMagazines() {
  		Connection con = null;
  		Statement stat = null;
  		String sql = "select * from book where isbn like 'M%'";
  		ResultSet rs = null;
  		try {
  			con = dbCon();
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			BookUtil.printHeader();
  			while(rs.next()) {
  				Book book = new Book();
  				book.setIsbn(rs.getString("isbn"));
  				book.setTitle(rs.getString("title"));
  				book.setAuthor(rs.getString("author"));
  				book.setPrice(rs.getInt("price"));
  				book.setCategory(rs.getString("category"));
  				book.setDescript(rs.getString("descript"));
  				System.out.println(book);
  				
  			}
  			BookUtil.printTail();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, rs);
  		}
  	}
  	
  	public void printMagazineOneYearSubscription() {
  		Connection con = null;
  		Statement stat = null;
  		String sql = "select title, price from book where isbn like 'M%'";
  		ResultSet rs = null;
  		try {
  			con = dbCon();
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			BookUtil.printHeader();
  			int i = 0;
  			while(rs.next()) {
  				Book book = new Book();
  				book.setTitle(rs.getString("title"));
  				book.setPrice(rs.getInt("price"));
  				System.out.println(++i + ". " + book.getTitle() + " : " + book.getPrice()*12 + " 원\n");
  			}
  			BookUtil.printTail();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, rs);
  		}
  	}
  	
  	public ArrayList<Book> searchNovelByAuthor(String author) {
  		ArrayList<Book> searchBooks = new ArrayList<Book>();
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "select * from book where isbn like 'N%' and author like ?";
  		ResultSet rs = null;
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1, '%' + author + '%');
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Book book = new Book();
  				book.setIsbn(rs.getString("isbn"));
  				book.setTitle(rs.getString("title"));
  				book.setAuthor(rs.getString("author"));
  				book.setPrice(rs.getInt("price"));
  				book.setCategory(rs.getString("category"));
  				book.setDescript(rs.getString("descript"));
  				searchBooks.add(book);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, rs);
  		}
  				
  		return searchBooks;
  	}
  	
  	public ArrayList<Book> searchNovelByPrice(int minPrice, int maxPrice) {
  		ArrayList<Book> searchBooks = new ArrayList<Book>();
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "select * from book where isbn like 'N%' and price between ? and ?";
  		ResultSet rs = null;
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setInt(1, minPrice);
  			stat.setInt(2, maxPrice);
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Book book = new Book();
  				book.setIsbn(rs.getString("isbn"));
  				book.setTitle(rs.getString("title"));
  				book.setAuthor(rs.getString("author"));
  				book.setPrice(rs.getInt("price"));
  				book.setCategory(rs.getString("category"));
  				book.setDescript(rs.getString("descript"));
  				searchBooks.add(book);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return searchBooks;
  	}
  	
  	public int insertBook(Book newBook) {
  		/*
  		int rows = 0;
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?)";
  		
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1, newBook.getIsbn());
  			stat.setString(2, newBook.getCategory());
  			stat.setString(3, newBook.getTitle());
  			stat.setString(4, newBook.getAuthor());
  			stat.setInt(   5, newBook.getPrice());
  			stat.setString(6, newBook.getDescript());
  			rows = stat.executeUpdate();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, null);
  		}
  		
  		return rows;
  		*/
  		
  		int rows = 0;
  		Connection con = null;
  		PreparedStatement stat = null;
  		String novel = "INSERT INTO book (isbn, title, author, price) VALUES(?, ?, ?, ?)";
  		String magazine = "INSERT INTO book (isbn, title, price, category, descript) VALUES(?, ?, ?, ?, ?)";
  		
  		try {
  			con = dbCon();
  			if(newBook.getIsbn().startsWith("N")) {
  				stat = con.prepareStatement(novel);
  				stat.setString(1, newBook.getIsbn());
  				stat.setString(2, newBook.getTitle());
  				stat.setString(3, newBook.getAuthor());
  				stat.setInt(4, newBook.getPrice());
  			}
  			else {
  				stat = con.prepareStatement(magazine);
  				stat.setString(1, newBook.getIsbn());
  				stat.setString(2, newBook.getTitle());
  				stat.setInt(3, newBook.getPrice());
  				stat.setString(4, newBook.getCategory());
  				stat.setString(5, newBook.getDescript());
  			}
  			rows = stat.executeUpdate();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, null);
  		}
  		
  		return rows;
  	}
  	
  	public int updateBook(Book modifyBook) {
  		int rows = 0;
  		Connection con = null;
  		PreparedStatement stat = null;
  		String novel = "UPDATE book SET price = ? WHERE isbn = ?";
  		String magazine = "UPDATE book SET price = ?, descript = ? WHERE isbn = ?";
  		
  		try {
  			con = dbCon();
  			if(modifyBook.getIsbn().startsWith("N")) {
  				stat = con.prepareStatement(novel);
  				stat.setInt(1, modifyBook.getPrice());
  				stat.setString(2, modifyBook.getIsbn());
  			}
  			else {
  				stat = con.prepareStatement(magazine);
  				stat.setInt(1, modifyBook.getPrice());
  				stat.setString(2, modifyBook.getDescript());
  				stat.setString(3, modifyBook.getIsbn());
  			}
  			rows = stat.executeUpdate();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, null);
  		}
  		
  		return rows;
  	}
  	
  	public int deleteBook(String isbn) {
  		int rows = 0;
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "DELETE FROM book WHERE isbn = ?";
  		
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1, isbn);
  			rows = stat.executeUpdate();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}finally {
  			dbClose(con, stat, null);
  		}
  		
  		return rows;
  	}
  }
  
  
  ```

  

- BookTest.java

  ```java
  package lab.jdbc.test;
  
  import java.util.ArrayList;
  
  import lab.jdbc.biz.BookBiz;
  import lab.jdbc.entity.Book;
  import lab.jdbc.util.BookUtil;
  
  public class BookTest {
  
  	public static void main(String[] args) {
  		
  		BookBiz biz = new BookBiz();
  		ArrayList<Book> books = null;
  		Book book = null;
  
  		while(true) {
  			printMenu();
  			System.out.print("## 메뉴 입력 : ");
  			int n = -1;
  			try {
  				n = Integer.parseInt(BookUtil.getUserInput());
  			}
  			catch(NumberFormatException e) {
  				//Todo: 별로 할 일 없음
  			}
  			finally {
  				if(n == 0) {
  					System.out.println("------------------------------");
  					System.out.println("  프로그램을 종료합니다. Bye~");
  					System.out.println("------------------------------");
  					break;
  				}
  				
  				switch(n) {
  				case 1: biz.printAllBooks();
  					break;
  					
  				case 2: biz.printAllMagazines();
  					break;
  					
  				case 3: biz.printAllNovels();
  					break;
  					
  				case 4: biz.printMagazineOneYearSubscription();
  					break;
  					
  				case 5:
  					System.out.print("> 검색할 저자명을 입력하세요 : ");
  					
  					books = biz.searchNovelByAuthor(BookUtil.getUserInput());
  					BookUtil.printHeader();
  					for(int i = 0; i < books.size(); i++) {
  						System.out.println(books.get(i));
  					}
  					BookUtil.printTail();
  					break;
  					
  				case 6:
  					try {
  						System.out.print("> 검색할 소설 가격의 최소값을 입력하세요: ");
  						int min = Integer.parseInt(BookUtil.getUserInput());
  						System.out.print("> 검색할 소설 가격의 최대값을 입력하세요: ");
  						int max = Integer.parseInt(BookUtil.getUserInput());
  						
  						books =  biz.searchNovelByPrice(min, max);
  						BookUtil.printHeader();
  						for(int i = 0; i < books.size(); i++) {
  							System.out.println(books.get(i));
  						}
  						BookUtil.printTail();
  					}
  					catch(NumberFormatException e) {
  						System.out.println("@ 숫자 형식이 잘못되었습니다.");
  					}
  					break;
  					
  				case 7:
  					book = new Book();
  					System.out.print("> ISBN 입력하세요: ");
  					book.setIsbn(BookUtil.getUserInput());
  					
  					System.out.print("> 책 제목을 입력하세요: ");
  					book.setTitle(BookUtil.getUserInput());
  					
  					System.out.print("> 가격을 입력하세요:  ");
  					book.setPrice(Integer.parseInt(BookUtil.getUserInput()));
  					
  					if(book.getIsbn().startsWith("N")) {
  						System.out.print("> 저자를 입렵하세요:  ");
  						book.setAuthor(BookUtil.getUserInput());
  					}
  					else {
  						System.out.print("> 카테고리를 입력하세요: ");
  						book.setCategory(BookUtil.getUserInput());
  						
  						System.out.print("> 설명을 입력하세요: ");
  						book.setDescript(BookUtil.getUserInput());
  					}
  					
  					if(biz.insertBook(book) > 0 ) {
  						System.out.println("새 책 정보 추가 완료!!!");
  					}
  					
  					break;
  					
  				case 8:
  					book = new Book();
  					System.out.print("> ISBN 입력하세요: ");
  					book.setIsbn(BookUtil.getUserInput());
  				
  					System.out.print("> 가격을 입력하세요:  ");
  					book.setPrice(Integer.parseInt(BookUtil.getUserInput()));
  					
  					if(book.getIsbn().startsWith("M")) {
  						System.out.print("> 설명을 입력하세요: ");
  						book.setDescript(BookUtil.getUserInput());
  					}
  					
  					if(biz.updateBook(book) > 0) {
  						System.out.println("책 정보 변경 완료!!!");
  					}
  					
  					break;
  					
  				case 9:
  					System.out.print("> ISBN 입력하세요: ");
  					String isbn = BookUtil.getUserInput();
  					if(biz.deleteBook(isbn) > 0) {
  						System.out.println("책 정보 삭제 완료!!!");
  					}
  					break;
  					
  					
  				default:
  					System.out.println("@ 메뉴번호를 잘못 입력하셨습니다.");	
  				}
  			}//end of try~catch~finally
  		}//end of while
  	}//end of main
  	
  	
  	
  	public static void printMenu() {
  		System.out.println("=== << 도서 정보 프로그램 >> ===");
  		System.out.println("1. 전체 도서 정보 조회");
  		System.out.println("2. 전체 잡지 조회");
  		System.out.println("3. 전체 소설 조회");
  		System.out.println("4. 잡지 연간 구독료 조회");
  		System.out.println("5. 소설 저자명 검색");
  		System.out.println("6. 소설 가격 검색(최소값 ~ 최대값)");
  		System.out.println("7. 도서 추가");
  		System.out.println("8. 도서 변경");
  		System.out.println("9. 도서 삭제");
  	System.out.println("0. 시스템 종료");
  		System.out.println("===========================");
  	}
  
  }
  
  ```

  

### JDBC 종합실습 - 성적 관리 시스템 구축

- 테이블 준비

  ```sql
  create table student (
      studentNO varchar(5) constraint student_pk primary key,
      studentName varchar2(15) not null,
      c number(3),
      linux number(3),
      java number(3),
      careerYears number(2),
      internYN    char(10) check (internYn in ('Y', 'N'))
  );
  
  alter table student add (
      average number(5,2),
      pass char(1) check (pass in ('Y', 'N'))
  );
  
  alter table student rename column averdfage to average;
  
  alter table student modify (
      c number(3) default 0,
      linux number(3) default 0,
      java number(3) default 0
  );
  
  desc student;
  
  --전체 학생 목록 검색
  --합격 학생 검색
  --학생정보 추가
  --과목 점수 수정
  --학생 정보 삭제
  
  ```

  

- CommonUtil.java

  ```java
  package lab.jdbc.grade.util;
  
  import java.util.Scanner;
  
  public class CommonUtil {
  	
  	 public static String getUerInput() {
  		   Scanner input = new Scanner(System.in);
  		   return input.nextLine();
  	   }
  	   public static void printHead() {
  		   System.out.println("=======================================================================================");
  		   System.out.println("사번       이름   신입/경력  인턴여부  경력년수           C   Linux   Java        총점   평균   합격여부");;
  		   System.out.println("=======================================================================================");
  	   }  
  	   public static void printTail() {
  		   System.out.println("=======================================================================================");
  	   }
  }
  
  ```

  

  

- Student.java

  ```java
  package lab.jdbc.grade.entity;
  
  public class Student {
  	private String studentNo;
  	private String studentName;
  	private int c;
  	private int linux;
  	private int java;
  	private int careerYears;
  	private String internYn;
  	private double average;
  	private String pass;
  	
  	public Student() {
  		super();
  	}
  	
  	
  
  	public Student(String studentNo, String studentName, int c, int linux, int java, String internYn) {
  		super();
  		this.studentNo = studentNo;
  		this.studentName = studentName;
  		this.c = c;
  		this.linux = linux;
  		this.java = java;
  		this.internYn = internYn;
  	}
  	
  	
  
  
  
  	public String getStudentNo() {
  		return studentNo;
  	}
  
  	public void setStudentNo(String studentNo) {
  		this.studentNo = studentNo;
  	}
  
  	public String getStudentName() {
  		return studentName;
  	}
  
  	public void setStudentName(String studentName) {
  		this.studentName = studentName;
  	}
  
  	public int getC() {
  		return c;
  	}
  
  	public void setC(int c) {
  		this.c = c;
  	}
  
  	public int getLinux() {
  		return linux;
  	}
  
  	public void setLinux(int linux) {
  		this.linux = linux;
  	}
  
  	public int getJava() {
  		return java;
  	}
  
  	public void setJava(int java) {
  		this.java = java;
  	}
  
  	public int getCareerYears() {
  		return careerYears;
  	}
  
  	public void setCareerYears(int careerYears) {
  		this.careerYears = careerYears;
  	}
  
  	public String getInternYn() {
  		return internYn;
  	}
  
  	public void setInternYn(String internYn) {
  		this.internYn = internYn;
  	}
  
  
  
  	public double getAverage() {
  		return average;
  	}
  
  
  
  	public void setAverage(double average) {
  		this.average = average;
  	}
  
  
  
  	public String getPass() {
  		return pass;
  	}
  
  
  
  	public void setPass(String pass) {
  		this.pass = pass;
  	}
  
  
  
  	@Override
  	public String toString() {
  		String st = String.format("%s\t%s\t%s\t%s\t%s\t%d\t%d\t%d\t%d\t%.1f\t%s", 
  			studentNo,
  			studentName,
  			studentNo.startsWith("1") ? "신입" : "경력",
  			studentNo.startsWith("1") ? internYn.trim() : " ",
  			studentNo.startsWith("1") ? " " : String.valueOf(careerYears),
  			c,
  			linux,
  			java,
  			c + linux + java,
  			average,
  			pass
  		);
  		
  		return st;
  	}
  }
  
  ```

  

- GradeManager.java

  ```java
  package lab.jdbc.grade.biz;
  
  import java.io.FileInputStream;
  import java.sql.Connection;
  import java.sql.DriverManager;
  import java.sql.PreparedStatement;
  import java.sql.ResultSet;
  import java.sql.Statement;
  import java.util.ArrayList;
  import java.util.Properties;
  
  import lab.jdbc.grade.entity.Student;
  
  public class GradeManager {
  	
  	public Connection dbCon() {
  		Connection con = null;
  		try {
  			Properties prop = new Properties();
  			prop.load(new FileInputStream("C:/workspace/day13/src/dbinfo.properties"));
  			
  			Class.forName(prop.getProperty("driver"));
  //			System.out.println("Driver loading 성공");
  			con = DriverManager.getConnection(
  					prop.getProperty("url"), 
  					prop.getProperty("user"), 
  					prop.getProperty("pwd")
  			);
  //			System.out.println("db connect 성공");
  			
  			
  			
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  		
  		return con;
  	}
  	
  	public void dbClose(Connection con, Statement stat, ResultSet rs) {
  		try {
  			if(rs != null) rs.close();
  			if(stat != null) stat.close();
  			if(con != null) con.close();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	
  	public ArrayList<Student> getAllStudent() {
  		Connection con = null;
  		Statement stat = null;
  		String sql = "SELECT  * FROM student ORDER BY studentno";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.createStatement();
  			rs = stat.executeQuery(sql);
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return students;
  	}
  	
  	public ArrayList<Student> getPassStudent() {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "SELECT * FROM student WHERE pass = ? ORDER BY studentno";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1,  "Y");
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return students;
  		
  	}
  	
  	public ArrayList<Student> getFailStudent() {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "SELECT * FROM student WHERE pass = ? ORDER BY studentno";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1,  "N");
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, rs);
  		}
  		
  		return students;
  	}
  	
  	public int insertStudent(Student s) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		int nRows = 0;
  		String careerSt = 
  				"INSERT INTO student ("
  					+ "studentNo, studentName, c, linux, java, careerYears, internYN, average, pass) "
  					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(careerSt);
  
  			stat.setString(1, s.getStudentNo());
  			stat.setString(2, s.getStudentName());
  			stat.setInt(3,  s.getC());
  			stat.setInt(4,  s.getLinux());
  			stat.setInt(5,  s.getJava());
  			stat.setInt(6,  s.getCareerYears());
  			stat.setNString(7, s.getInternYn());
  			double avg = (s.getC() + s.getLinux() + s.getJava()) / 3.0;
  			stat.setDouble(8, Double.parseDouble(String.format("%.2f", avg)));
  			String pass = s.getStudentNo().startsWith("1") ?
  					(avg >= 70 ? "Y" : "N")	: (avg >= 80 ? "Y" : "N");
  			stat.setString(9, pass);
  			nRows = stat.executeUpdate();
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return nRows;
  	}
  	
  	public int updateStudent(Student s) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		int nRows = 0;
  		String sql = 
  				"UPDATE student SET c = ?, java = ?, linux = ?, "
  				+ "careerYears = ?, internYn = ?, "
  				+ "average = ?, pass = ? "
  				+ "WHERE studentNo = ? ";
  		try {
  			con = dbCon();
  			con.setAutoCommit(false);
  			stat = con.prepareStatement(sql);
  			stat.setString(8, s.getStudentNo());
  			stat.setInt(1,  s.getC());
  			stat.setInt(2,  s.getLinux());
  			stat.setInt(3,  s.getJava());
  			stat.setInt(4,  s.getCareerYears());
  			stat.setString(5, s.getInternYn());
  			double avg = (s.getC() + s.getLinux() + s.getJava()) / 3.0;
  			stat.setDouble(6, Double.parseDouble(String.format("%.2f", avg)));
  			String pass = s.getStudentNo().startsWith("1") ?
  					(avg >= 70 ? "Y" : "N")	: (avg >= 80 ? "Y" : "N");
  			stat.setString(7,  pass);
  		
  			nRows = stat.executeUpdate();
  			
  			con.commit();
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return nRows;
  	}
  	
  	public int deleteStudent(String sno) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "DELETE FROM student WHERE studentNo = ?";
  		int nRows = 0;
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1, sno);
  			nRows = stat.executeUpdate();
  			
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return nRows;
  	}
  	
  	public ArrayList<Student> searchStudent(String sno) {
  		Connection con = null;
  		PreparedStatement stat = null;
  		String sql = "SELECT * FROM student WHERE studentNo = ?";
  		ResultSet rs = null;
  		ArrayList<Student> students = new ArrayList<Student>();
  		try {
  			con = dbCon();
  			stat = con.prepareStatement(sql);
  			stat.setString(1,  sno);
  			rs = stat.executeQuery();
  			while(rs.next()) {
  				Student st = new Student();
  				st.setStudentNo(rs.getString("studentNo"));
  				st.setStudentName(rs.getString("studentName"));
  				st.setC(rs.getInt("c"));
  				st.setLinux(rs.getInt("linux"));
  				st.setJava(rs.getInt("java"));
  				st.setInternYn(rs.getString("internYN"));
  				st.setCareerYears(rs.getInt("careerYears"));
  				st.setAverage(rs.getDouble("average"));
  				st.setPass(rs.getString("pass"));
  				
  				students.add(st);
  			}
  		}catch(Exception e) {
  			e.printStackTrace();
  		}
  		finally {
  			dbClose(con, stat, null);
  		}
  		
  		return students;
  	}
  	
  	
  	
  	public GradeManager() {
  		super();
  	}
  
  }
  ```

  

- GradeTest.java

  ```java
  package lab.jdbc.grade.test;
  
  import java.util.ArrayList;
  
  import lab.jdbc.grade.biz.GradeManager;
  import lab.jdbc.grade.entity.Student;
  import lab.jdbc.grade.util.CommonUtil;
  
  public class GradeTest {
  
  	public static void main(String[] args) {
  		
  		ArrayList<Student> students;
  		GradeManager mgr = new GradeManager();
  		 
  		while (true) {
  			printMenu();
  			System.out.print("## 메뉴 입력:");
  			String menu = CommonUtil.getUerInput();
  			if (menu.equals("9")) {
  				System.out.println("------------------------");
  				System.out.println("프로그램을 종료합니다. Bye~");
  				System.out.println("------------------------");
  				break;
  			}
  			switch (menu) {
  			case "1":
  				students = mgr.getAllStudent();
  				CommonUtil.printHead();
  				for( Student s : students) {
  					System.out.println(s);
  				}
  				CommonUtil.printTail();
  				break;
  				
  			case "2":
  				students = mgr.getPassStudent();
  				CommonUtil.printHead();
  				for( Student s : students) {
  					System.out.println(s);
  				}
  				CommonUtil.printTail();
  				break;
  				
  			case "3":
  				students = mgr.getFailStudent();
  				CommonUtil.printHead();
  				for( Student s : students) {
  					System.out.println(s);
  				}
  				CommonUtil.printTail();
  				 
  				break;
  			case "4":
  				Student newS = new Student();
  				System.out.print("> 사번 입력하세요: ");
  				newS.setStudentNo(CommonUtil.getUerInput());
  				
  				System.out.print("> 이름 을 입력하세요: ");
  				newS.setStudentName(CommonUtil.getUerInput());
  				
  				if(newS.getStudentNo().startsWith("1")) {
  					System.out.print("> 인턴겸험 여부를 입력하세요: ");
  					newS.setInternYn(CommonUtil.getUerInput());
  				}
  				else {
  					System.out.print("> 경력년수를 입력하세요: ");
  					newS.setCareerYears(Integer.parseInt(CommonUtil.getUerInput()));
  				}
  				
  				System.out.print("> C 점수를 입력하세요: ");
  				newS.setC(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Linux 점수를 입력하세요: ");
  				newS.setLinux(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Java 점수를 입력하세요: ");
  				newS.setJava(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				newS.setAverage((newS.getC() + newS.getJava() + newS.getLinux()) / 3.0);
  				
  				if(mgr.insertStudent(newS) > 0) {
  					System.out.println("OOO 사원 추가 완료 OOO");
  				}
  				else {
  					System.out.println("XXX 사원 추가 실패 XXX");
  				}
  				break; 
  				 
  			case "5":
  				Student modS = new Student();
  				System.out.print("> 변경할 사원의 사번 입력하세요: ");
  				modS.setStudentNo(CommonUtil.getUerInput());
  				
  				System.out.print("> C 점수를 입력하세요: ");
  				modS.setC(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Linux 점수를 입력하세요: ");
  				modS.setLinux(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				System.out.print("> Java 점수를 입력하세요: ");
  				modS.setJava(Integer.parseInt(CommonUtil.getUerInput()));
  				
  				
  				if(modS.getStudentNo().startsWith("1")) {
  					System.out.print("> 인턴겸험 여부를 입력하세요: ");
  					modS.setInternYn(CommonUtil.getUerInput());
  				}
  				else {
  					System.out.print("> 경력년수를 입력하세요: ");
  					modS.setCareerYears(Integer.parseInt(CommonUtil.getUerInput()));
  				}
  				
  				modS.setAverage((modS.getC() + modS.getJava() + modS.getLinux()) / 3.0);
  				
  				
  				if(mgr.updateStudent(modS) > 0) {
  					System.out.println("OOO 사원 변경 완료 OOO");
  				}
  				else {
  					System.out.println("XXX 사원 변경 실패 XXX");
  				}
  				
  				 
  				break;
  			case "6":
  				
  				System.out.print("> 삭제할 사원의 사번 입력하세요: ");
  				String delS = CommonUtil.getUerInput();
  				if(mgr.deleteStudent(delS) > 0) {
  					System.out.println("OOO 사원 삭제 완료 OOO");
  				}
  				else {
  					System.out.println("XXX 사원 삭제 실패 XXX");
  				}
  				
  				 
  				break;
  			case "7": //학번으로 검색... 귀찮아... 안 해..
  				System.out.print("> 변경할 사원의 사번 입력하세요: ");
  				String sno = CommonUtil.getUerInput();
  				ArrayList<Student> searchedSt = mgr.searchStudent(sno);
  				
  				CommonUtil.printHead();
  				if(searchedSt != null) {
  					for( Student s : searchedSt) {
  						System.out.println(s);
  					}
  				}
  				else
  					System.out.println("해당 사원이 없습니다.");
  					
  				CommonUtil.printTail();
  						
  				break;
  			}// switch end
  		} // while end
  
  	}
  
  	public static void printMenu() {
  		System.out.println("===<< 성적관리 시스템 메뉴 >>===");
  		System.out.println("1. 전체 수강생 조회");
  		System.out.println("2. 합격 수강생 조회");
  		System.out.println("3. 불합격 수강생 조회");
  		System.out.println("4. 수강생 정보 추가");
  		System.out.println("5. 수강생 정보 수정");
  		System.out.println("6. 수강생 정보 삭제");
  		System.out.println("7. 학번으로 수강생 정보 조회");		 
  		System.out.println("9. 시스템 종료");
  		System.out.println("===============================");
  
  	}
  
  }
  
  ```





### Exercise4.docx

```sql
--subquery
--1
select *
from employees
where department_id = (
    select department_id from employees 
    where last_name = 'Zlotkey')
    and last_name != 'Zlotkey';
    
--2
select employee_id, last_name, salary
from employees
where salary > (
    select avg(salary) from employees)
order by salary asc;

--3
select employee_id, last_name
from employees
where department_id in (
    select department_id
    from employees
    where last_name like '%u%'
    );
    
--4
select last_name, department_id, job_id
from employees
where department_id in (
    select distinct department_id 
    from departments
    where location_id = 1700
)
order by department_id asc;

--5
select last_name, salary
from employees
where manager_id = (
    select employee_id
    from employees
    where last_name = 'King'
);
    
--6
select department_id, last_name, job_id
from employees
where department_id = (
    select department_id
    from departments
    where department_name = 'Executive'
    );

--7
select 
    employee_id, last_name, salary
from 
    employees
where 
    department_id in (
        select distinct department_id
        from employees
        where last_name like '%u%'
    )
    and
    salary > (
        select avg(salary)
        from employees
    );
    
    
--set operators
--1
select distinct department_id
from employees
MINUS
select distinct department_id
from employees
where job_id = 'ST_CLERK';

--2
select 
    country_id as "CO", country_name
from 
    countries
MINUS 
select 
    distinct country_id, country_name
from 
    locations left join countries using (country_id);

--3
select distinct job_id, department_id
from employees
where department_id = 10
UNION ALL
select * from (
    select distinct job_id, department_id
    from employees
    where department_id = 50
    order by job_id asc
)
UNION ALL
select distinct job_id, department_id
from employees
where department_id = 20;

--4
select employee_id, job_id
from employees
INTERSECT
select distinct employee_id, job_id
from job_history;

--5
select last_name, department_id, to_char(null)
from employees
UNION
select to_char(null), department_id, department_name
from departments;

```



### SQL/JDBC 수행평가

#### SQL

```sql
--[SQL]
--1.
desc emp;


--2.
select distinct deptno from emp;


--3.
select to_char(sysdate, 'YYYY"년" MM"월" DD"일"') as "Today"
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


--8.
select 
	mon as "입사월", 
	to_char(max(salary), '9,999,999')  || '원' as "최고급여"
from (
    select
        to_number(to_char(hire_date, 'MM')) || '월' as mon,
        salary
    from  employees
)
group by mon
having max(salary) >= 10000
order by max(salary) desc, mon;


--9.
select 
    hireyear as "입사년도",
    count(employee_id) as "조건에 맞는 직원수"
from (
    select 
    	to_char(hire_date, 'YY') as hireyear,
    	employee_id
    from employees
    where salary between 5000 and 10000
)
group by hireyear
having count(employee_id) >= 7
order by hireyear;


```



#### JDBC

```java
package lab.jdbc.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JdbcExam {

	public static void main(String[] args) {
		
		System.out.print("FIRST_NAME 첫 글자를 입력하세요 : ");
		Scanner input = new Scanner(System.in);
		String inputSt = input.nextLine();
		inputSt = inputSt.toUpperCase();
		
		search(inputSt);
		
	}//main end
	
	
	
	public static void search(String inputSt) {
		Connection con = null; 
		PreparedStatement stat = null;
		String sql = "select * from employees where first_name like (? || '%') order by salary";
		ResultSet rs = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:orcl", 
					"hr", 
					"oracle"
			);
			
			stat = con.prepareStatement(sql);		
			stat.setString(1, inputSt);
			rs = stat.executeQuery();
			while(rs.next()) {
				int nSal = rs.getInt("salary");
				System.out.println(
						rs.getString("first_name") + "(" 
						+ rs.getString("last_name") + ") "
						+ nSal/1000 + "," + String.format("%03d", nSal%1000) + "원" 
						
				);
			}
	
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver 없음");
		}
		catch(SQLException e) {
			System.out.println( "DB연동 오류 발생 : " + e.getMessage());
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
	
    }//search() end

}//class end


```






















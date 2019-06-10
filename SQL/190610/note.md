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

    > ```
    > insert 오류 - 컬럼타입 불일치, 컬럼크기 불일치, 제약조건 오류
    > ```

    

  - **update** - 컬럼 값 변경

    ```sql
    update 테이블명 set 컬럼명=변경할 값 [, 컬럼명 = 변경할 값, ...];
    
    update 테이블명 set 컬럼명=변경할 값 [, 컬럼명 = 변경할 값, ...] where 조건;
    
    update 테이블명 set 컬럼명=(subquery) [, 컬럼명=변경할 값,...] where subquery;
    
    ```

    > update 오류 - 컬럼타입 불일치, 컬럼크기 불일치, 제약조건 오류
> 변경할 값에 null, default, 단일행함수 등 사용가능
    
    
    
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

  


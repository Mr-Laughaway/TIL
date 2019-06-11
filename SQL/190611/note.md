### 복습

- 테이블 컬럼 추가

  ```sql
   alter table ~ add (컬럼 컬럼타입 [제약조건]);
  ```

  

- 테이블 컬럼 삭제

  ``` sql
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
  -  function based index - 컬럼표현식의 결과값으로 인덱스 생성

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
    1. 연결할 데이터베이스의
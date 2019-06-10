### 복습

- 순위 관련 함수

  - rank() 

    ```sql
    rank() over (partition by 컬럼 order by 컬럼
    		rows|range 
                 unbounded preceding|unbounded following |
                 
                 
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

  - insert into - 새 데이터 추가

    ```sql
    insert into 테이블명 (컬럼명 리스트) values (컬럼명 리스트의 순서와 타입에 맞는 값 리스트);
    
    insert into 테이블명 values (테이블에 선언된 컬럼순서대로 모든 값);
    
    -- values 절에 null, default, 단일행 함수 등 사용가능
    
    insert into 테이블명 (컬럼명 리스트) subquery; --컬럼명 리스트는 subquery의 컬럼순서 , 개수, 타입과 일치해야 합니다.
    
    ```

    > ```
    > insert 오류 - 컬럼타입 불일치, 컬럼크기 불일치, 제약조건 오류
    > ```

    

  - update - 컬럼 값 변경

    ```sql
    update 테이블명 set 컬럼명=변경할 값 [, 컬럼명 = 변경할 값, ...];
    
    update 테이블명 set 컬럼명=변경할 값 [, 컬럼명 = 변경할 값, ...] where 조건;
    
    
    
    ```

    

    ```sql
    
    ```

    
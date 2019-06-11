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

    1. 연결할 데이터베이스의 driver class 클래스 (~.jar) 준비

       - 운영체제의 환경 변수 classpath에 추가
       - JDK또는 JRE의 라이브러리 검색 위치중에 외부 확장 라이브러리 저장위치(%JAVA_HOME%jre/lib/ext)
       - 이클립스(IDE)에서 프로젝트 build path>configure build path>library>add external jar ... 추가

    2.  import java.sql.*;

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

    

---



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

  
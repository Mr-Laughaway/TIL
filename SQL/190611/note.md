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
  
  
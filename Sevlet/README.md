## 인터넷과 웹 프로그래밍

#### apache-tomcat 

- WAS 의 한 종류(매우 기본적)
  - oracle weblogic, AS
  - IBM websphere
  - timax JEUS, Web...
- web server 기능
- web application 기능
- HTML 서비스 (http demon, http listener)
- web container 기능
  - 동적인 요청에 대한 처리
  - JSP sevlet container (JVM 통해 동작)







#### JSP - Java Server Page

- Servlet (server + applet)
  - server side에서 실행되는 프로세스
  - Java 기반 + html 태그로 구성
    - 항상 재 컴파일 필요
    - 협업의 어려움(개발측, 디자인측)
- JSP
  - html 기반 + Java 코드로 구성





#### 복습

##### 자바스크립트로 지도 보여주기

- 자바스크립트 코드

  ```javascript
  navigator.geolocation.getCurrentPosition(success콜백, error콜백, [options])
  
  success콜백(position객체) {
      position.coords.latitude;
      position.coords.longitude;
      ...
  }
      
  error콜백(error객체) {
      error.message;
      error.code;
      ...
  }
  ```



##### Servlet

> Server + Applet

- www 웹 서비스를 제공하는 웹 서버에서 실행되는 웹 컴포넌트를 구현하는 기술
- 웹 요청을 처리, 처리 결과를 동적으로 생성하여 응답(html 생성)



##### WAS

> Web Server + Application Server

- Web Server: http listener(demon)
- Application Server: 서버에서 실행되는 웹 컴포넌트의 실행환경을 제공. NamingContext 기능, Pooling 기능



##### JSP

> Java Server Page



##### 웹 컨텐스트 표준 구조

```
웹 컨텍스트(http://.../루트-컨텍스트)

|----html, js, css, image, ..., (jsp)

|----WEB-INF
		|----classes (패키지형태-class파일)
		|----lib (jar파일-외부 자바 library)
		|----web.xml(웹 컨텍스트의 환경설정파일 - 파라미터, 리스너, 필터, 전역세션 timeout, 전역 에러 페이지, 서블릿, 리소스 참조, 웰컴페이지 리스트)
		|----src
		|----tld, tags
```



##### tomcat 설행 과정

```
tomcat startup
	|---- conf
			|----server.xml
			|----web.xml
			|----context.xml
					|----web1
                    		|---찾아(못찾으면 루트 web.xml)
							|	url-pattern에서 찾아 sevlet을 실행하던지
							|	혹은 없으면 웰컴페이지를 리턴한다
							|	없으면 404
					*JSP 요청의 경우*
                    컨테이너가 /web1/hello_jsp.java 찾아
                    객체 없으면 컴파일->객체생성->init->service(doGet,doPost)반복->destroy
```



##### Servlet Spec.

- 패키지 선언
- public class로 선언
- HttpServlet 상속
- lifecycle method override
  - service(), doGet(), doPost(), doPut() 등
  - HttpServletRequest, HttpServletResponse 등 이용하여 구현
  - throws ServletException, IOEXception



##### JSP Spec.

- 정적 페이지 선언

  ex)

  ```<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>```



------

### 복습 (이건 다 외워야한다)

##### 요청 메시지로부터 헤더 정보 추출

1. ```http:/ip:port/web1/header요청``` -> ```@webServlet("/header")```
2. ```Enumeration<String> <- HttpServletRequest.getHeaderName()```
3. ```Enumeration.hasMoreElement() : boolean```
4. ```Enumeration.nextElement() : String```
5. ```.getHeader() : 1개 일때 (String)```
6. ```.getHeaders() : 2개 이상일 때 (Enumeration<String>)```



##### http 요청 메시지를 전송한 클라이언트 정보 추출

```java
request.getMethod();
request.getRemoteAddr();
request.getContextPath();
request.getRequestURI();
request.getRequestURL();
request.getServletPath();
```



##### 웹 컨텍스트

- 추상화한 객체 : ServletContext
- ```request.getServletContext();``` 로 얻어냄



##### form 데이터로 받은 값 추출

```java
HttpServletRequest.getParameter("input 요소의 name 속성값");

//checkbox input 요소의 checked 요소의 value들을 추출
HttpServletRequest.getParameterValues("input 요소의 name 속성값");
```

ex)

1. memberform.html요청 (단순페이지요청 : GET 방식)

2. HttpListener가 html페이지 응답

3. 클라이언트가 데이터 입력하고 html페이지 응답

   ```<form action="./join" method="" encType="multipart/form-data">```

4. ```@WebServlet("/join")``` 선언된 서블릿이 요청을 받아서 응답 처리

   파일 업로드 처리하는 서블릿에 선언할 Annotation

   ```@MultipartConfig(location="", maxFileSize="", maxRequestSize="")```

   ```java
   Collection<Part> parts = request.getParts();
   for(Part part : parts) {
       if(part.getContentType() != null) {
           String fileName = part.getSubmittedFileName();
           if(fileName != null) {
               String newName = fileName.substring(0, fileName.lastIndexOf("."))
                   + "_" + System.currentTimeMillis() +
                   fileName.substring(fileName.lastIndexOf("."));
               part.write(newName);
               out.print("<br>업로드한 파일 이름: " + fileName);
               out.print("<br>크기: " + part.getSize());
               out.print("<br><img src='./uploads/"+newName+"' width=300 height=200>");
   
               System.out.println("<br>업로드한 파일 이름: " + fileName);
           }
       }
       else {
           String partName = part.getName();
           String fieldValue = request.getParameter(partName);
           out.print("<br>" + partName + ": " + fieldValue);
       }
   }
   ```



##### 요청을 동일한 웹 컨텍스트의 다른 servlet 또는 jsp에 전송

```java
ServletContext sctx = request.getServletContext(); //요청 웹 컥텍스트 객체 받기
RequestDispatcher rd = sctx.getRequestDispatcher("/요청을 넘길 경로");
rd.forward(request, response);
//or rd.include(request, response));

```



##### request 객체에 값 저장 및 추출

```java
HttpServletRequest.setAttribute(키로 사용할 객체, 값 객체);
HttpServletRequest.getAttribute(키); // Object로 반횐 되므로 실제 저장한 타입으로 다운캐스팅 해야한다.
```



##### Anchor 태그 요청 전달

```html
<a href="./xxx?paramName=paramValue&pramName=paramValue"> 요청 전달 </a>
<!-- GET 방식 전달 -->
```



##### 상태 정보를 저장하는 방법

- 클라이언트 브라우저에 저장(key=value) : ***Cookie*** (유효기간: setMaxAge())
- URL query-string 방식
- 요청 전송하는 페이지에 <input type="hidden" name="" value=""> 를 사용하여 전송하는 방식
- 웹 서버에 객체로 저장 : ***Session*** (유효기간: 브라우저 종료되어 세션이 종료될 때 까지만 유지됨)

1. 클라이언트가 특정 웹 서버(tomcat)로 최초 요청을 전송

2. 웹 서버(tomcat)가 클라이언트 요청에 대해 응답을 할 때 해시 함수 기반 JSessionID 값을 생성해서 쿠키로 전송합니다.

3. 클라이언트가 웹 서버로 두 번째, 세 번째, ... 요청을 할 때마다 브라우처 자체적으로 요청 웹 서버에서 보내준 쿠키 정보를 찾아서 전송.

4. 웹 서버의 웹 컴포넌트(서블릿)에서 요청과 함께 전송된 쿠키 정보를 추출하려면

   ```java
   //추출시
   HttpServletRequest.getCookies(); // Cookie[]
   
   //저장시
   Cookie cookie = new Cookie(key, name);
   HttpServletResponse.addCookie(cookie);
   ```



------



#### 페이지 변경

##### requestDispatcher(컨텍스트 패스 스트링)

- request 추가 정보 전달 가능



sendRedirect(URL 형식 스트링) 

- ***표시 URL도 바뀜***
- 다른 URL로도 보낼 수 있음
- ***request , response 객체 새로 생성되기 때문에 정보 전달 불가***
- ***정보 전달시 쿼리 스트링으로 전달해야한다 ***





#### JSP

- 스크립트, HTML 태그와 함께 java 코드 포함

- View와 로직이 분리 안 되어서 ***재사용성이 낮음***

- 페이지 단위로 개발하여 빠르게 개발 가능하지만...

- Servlet -> JSP -> EJB(망함) -> MVC 패턴 적용 웹 애플리케이션 구현

  > View 는 JSP,
  >
  > Controller 는 Servelt
  >
  > data 영속성과 비즈니스로직은 JavaObject

- 현재 JSP는 MVC 구조에서 View로만 제한하며, 태그과 EL(Expression Language)만 사용

- JSP 요소

  - 정적 지시자

    - <%@ page ~~%>
    - <%@ include ~~ %>
    - <%@ taglib ~~ %>

  - 동적 지시자

    - ```<jsp:include ~></jsp:include>```
    - ```<jsp:useBean ~><jsp:getProperty ~~/>... </```

  - declare scriptlet

    ```
     <%!
     	변수 선언 초기화; //변환된 서블린의 멘버 변수로 정의
    					
        public void method() {
    	...				
    	}
    	
    %>
    ```

  - scriptlet

    ```
    <%
    	자바 실행 문장; //변환된 서블릿의 _service()의 실행문장으로 포함된다
    	...
    %>
    
    ```

  - expression

    ```
    <%= 출력내용 %>
    // <% out.println(출력내용) %> 과 동일
    
    ```



#### 복습

- 자바 기반의 웹 어플리케이션에서 JSP의 역할 - View(사용자에게 제공되는 content, 입력 페이지)

- JSP 구성 요소

  - 정적 지시자

    ```
    <%@ page ...%>
    <%@ include .. %>
    <%@ taglib ... %>
    
    ```

  - 동적 태그

    ```
    <jsp:include .../>
    <jsp:forward .../>
    <jsp:setProperty .../>
    <jsp:getProperty .../>
    ```

- 자바 코드와 관련된 JSP 요소

  ```jsp
  <%! 
  	변수 선언 초기화; //서블릿으로 변환 됐을 때 멤버 변수
  	메서드 정의		//서블릿으로 변환 됐을 때 멤버 메서드
  %>
  
  <%
  	자바 실행 문장; 	//변환된 서블릿에 _jspService()에 포함
  	...
  %>
  
  <%= 출력 내용 %> 
  // == <% out.print(출력내용); %>
  
  //Expression Language
  ${출력내용}
  
  ```

  

#### ch3. 31page 외워 (내장 객체)



#### 복습

##### Http 프로토콜

- 접속시 생성된 상태 정보를 유지하지 않는 stateless 프로토콜

- 접속시 웹 컨테이너에서 생성한 ```JSESSION ID```, 로그인 정보, 쇼핑 카트에 저장된 상품 정보등 상태 정보 저장방법

  - URL query-string 방식

    ```http://ip:port/웹컨텍스트/xxx.jsp?JSESSSIONID=139819238```

  - 요청 전송하는 페이지에 ```<input type="hidden" name="" value="">```  form 를 사용하여 전송하는 방식

  - Cookie를 사용하는 방법

    - cookie 정보를 함께 전송하는 방식
    - ***웹 브라우저에 저장***

    ```java
    //쿠키 만들어 전송
    Cookie c = new Cookey(key, value);
    c.setMaxAge(초단위기간);
    HttpServletResponse.addCookie(); //-> 클라이언트에게 전송
    
    //쿠키 읽기
    HttpServletRequest.getCookies(); //쿠키 배열 리턴
    
    //쿠키 삭제
    쿠키.setMaxAge(0);
    
    ```

  - Session을 사용하는 방법

    - ***웹 컨테이너의 메모리에 저장*** (Java는 객체로 저장)

    - Session 객체는 최초 요청시에 웹 컨테이너가 HttpSession의 구현 객체를 생성

    - 받아오기 / 사용하기

      ```java
      HttpServletRequest.getSession(); //가져오기
      session.setAttribute(key, value); //저장
      session.getAttribute(key, value); //추출
      session.removeAttribute(key); //삭제
      session.getID(); //아이디
      session.getLastAccessTime(); //마지막 접속시각
      
      //세션 유지시간 (web.xml에 설정해도 된다)
      session.setMaxInactiveInterval(초);
      
      //세션 만료시키기
      session.invalidate();
      
      
      
      ```

- 요청을 재지정

  클라이언트가 요청한 Servlet이나 JSP에서 응당하는 대신 요청을 다른 자원(JSP, 서블릿)에 전달하는 것

  - dispatcher 방식

    ```java
    ServletContext sc = request.getServletContext();
    RequestDispatcher rd = sc.getReqeustDispatcher("/경로");
    request.setAttribute(key, value);
    rd.forward(request, response);
    ```

    - 동일한 웹 컨텍스트만 가능
    - 처음 요청한 url 유지
    - ***request, response 객체 유지***

  - redirect 방식

    ```
    response.sendRedirect("URL 패스 방식");
    ```

    - 동일한 웹 컨텍스트와 다른 웬 컨텍스트/웹 서버 둘 다 가능
    - 최종 요청 url 로 출력
    - ***request, response 객체 날아감***
    - 정보 전달시 ***session, 혹은 쿼리 스트링***으로 전달해야한다.



##### JSP

- HTML 또는 XML 기반의 동적인 웹 컨텐츠를 개발하는 스크립트

- 응답 페이지를 구현하는데만(View로만) 제한하는 것으로 권장됨

  > 자바코드를 로직을 가능한한 포함하지 않고 태고, el로만 컨텐츠를 생성하는것을 권장합니다.

- JSP 구성요소

  - 정적 지시자

    ```jsp
    <%@ page 
    		contentType="text/html;charset=utf-8" 
        	session
        	buffer
        	isThreadSafe
        	errorPage
        	isErrorPage
        	info
        	language="java"
        	import
        	extends
        	isELIgnored
        	defferedSyntaxAllowedAsLiteral
    %>
    <!-- 
    text/xml 
    text/plain, text/json(?)
    image/jpeg
    ...
    application/vnd.ms-
    application/json(?)
    -->
    
    <%@ include file="" // <html>, <head>, <body>는 포함하면 안 됨
    %>
    
    <!-- JSP 페이지 내에 html 태그가 아닌 태그를 만나면 매핑된 Java class를 실행시켜 줌 -->
    <%@ taglib
    		prefix=""
        	uri="http://java.sun.com/jsp/jstl/~" //~는core, sql, 국제화 format처리 라이브러리, xml 등 JSTL(Java Standard Tag Library)
    %>
    <!--<c:if test=''>, <c:case, <c:forEach 등등 -->
    
    ```

    

  - 동적 지시자

    - declare scriptlet ```<%!  %>```

      멤버 변수 또는 멘버 메서드 

    - scriptlet ```<%   %>```

      자비 실행 문장. _jspService()메서드의 문장으로 들어감.

    - expression ```<%=   %>``` == ```<% out.println(출력내용); %>``` == ```${출력내용}```

      출력 내용. 변수, 연산식, 값을 리턴하는 함수 등.

  

  - JSP 주석

    ```<%-- JSP 주석 --%>```

    ```<% //주석 %>```

    ```<!-- html 주석 -->```

    

  - JSP 내장객체 (요청이 들어올때 JSP 컨테이너 내에서 자동생성)

    - request - javax.servlet.http.HttpServletRequest
    - response - javax.servlet.http.HttpServletResponse
    - session - javax.servlet.http.HttpSession
    - application - javax.servlet.ServletContext
    - out - javax.servlet.jsp.JSPWriter
    - exception - java.lang.Throwable
    - page - java.lang.Object
    - config - javax.servlet.ServletConfig
    - pageContext - javax.servlet.jsp.PageContext
    - 유효범위 - 컨테이너 메모리에 유지되는 범위
      1. page scope - 현재 jsp 페이지
      2. request scope - redirect 페이지 전환시 
      3. session scope - session.invalidate, 만료, 브라우저 종료
      4. application scope - 웹 컨텍스트가 웹 컨테어니로부터 삭제될 때 까지 혹은
    - page, request, session, application 공통 메서드
      1. setAttribute()
      2. getAttribute()
      3. removeAttribute()
      4. getAttributeNames()



------



#### 자주 사용하는 태그

- 표준 액션 태그

  - JSP 스펙에 정의된 기능, 모든 JSP 컨테이너가 지원하므로 항상 상용 가능

  - ```<jsp:userBean ~~~```

  - ```<jsp:setProperty~```

  - ```<jsp:getProperty~```

  - ```<jsp:include page=""/>```

  - 

    

- 커스텀 액션 태그

  - 개발자가 직접 태그 클래스와 tld(xml형식) 파일을 정의해서 사용

- EL(Expression Language) 

  - 표현 언어,  JSP2.0에서 추가
  - ```<c:out ...>``` 또는 ```<jsp:getProperty ...>``` 보다 간결하게 사용가능



##### 게시판의 유스케이스

- 게시물 작성

  - 포함기능

    - 비밀번호 설정

  - 확장기능

    - 사진파일 첨부

    

- 게시물 목록



- 게시물 보기

  - 포함기능
  - 확장기능
    - 댓글

  

- 게시물 수정

  - 포함기능
    - 비밀번호 체크
  - 확장기능

  

- 게시물 삭제

  - 포함기능
    - 비밀번호 체크
  - 확장기능



- 댓글작성
- 댓글수정
- 댓글삭제





##### 게시글의 데이터

- 제목
- 내용
- 작성자
- 작성일
- 조회수
- 글번호
- 첨부파일(multi?)
- 비밀번호



##### 댓글의 데이터

- 글번호
- 게시글번호
- 작성자
- 내용
- 비밀번호



// 전체 게시물 수와 페이지 크기를 가지고 전체 페이지 개수를 계산한다.
// 소수점에 따라 계산 상의 오류가 없도록 두 가지 중 한 가지를 이용한다.
방법 1 : pageCount = totalCount / PAGE_SIZE;
방법 2 :pageCount = (int)Math.ceil(totalCount / (PAGE_SIZE+0.0));

if((totalCount % PAGE_SIZE) !=0)
pageCount++;

// 현재 그룹 설정
int curGroup = (curPage-1) / GROUP_SIZE;









```sql
DECLARE
      vn_base_num NUMBER := 3;
    BEGIN
       FOR i IN 1..9
       LOOP
          DBMS_OUTPUT.PUT_LINE (vn_base_num || '*' || i || '= ' || vn_base_num * i);
       END LOOP;
    END;

# DBMS_RANDOM.VALUE
- 랜덤한 숫자를 생성한다.
- Syntax : DBMS_RANDOM.VALUE(low IN NUMBER, high IN NUMBER)
- 파라미터 low는: 최소 범위, high는: 최대 범위 값이다.

SELECT DBMS_RANDOM.VALUE(1000, 10000) rand FROM DUAL;

SELECT CEIL(DBMS_RANDOM.VALUE(1000, 10000)) rand 
FROM DUAL
CONNECT BY LEVEL <= 10;


# DBMS_RANDOM.STRING
- 랜덤한 문자열을 생성한다.
- Syntax : DBMS_RANDOM.STRING opt IN CHAR, len IN NUMBER)
- opt (옵션)은 아래와 같다.
'u', 'U' : 대문자
'l', 'L' : 소문자
'a', 'A' : 대소문자 구분없는 영문자
'x', 'X' : 영문자와 숫자 혼합
'p', 'P' : 문자 혼합


    SELECT DBMS_RANDOM.STRING('U',  10) rand FROM DUAL -- 대문자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('L',  10) rand  FROM DUAL -- 소문자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('A',  10) rand  FROM DUAL -- 영문자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('X',  10) rand FROM DUAL -- 영숫자
    UNION ALL
    SELECT DBMS_RANDOM.STRING('P',  10) rand FROM DUAL  --문자혼합
)
SELECT * FROM t;


# DBMS_RANDOM.RANDOM
- DBMS_RANDOM.RANDOM은 랜덤 한 숫자를 생성해 준다.
- 한번 실행해 보자 SELECT DBMS_RANDOM.RANDOM FROM DUAL
- DBMS_RANDOM.RANDOM 함수를 이용하면 데이터를 랜덤한 순서로 정렬 할 수 있다.

SELECT * 
  FROM
     (SELECT * 
        FROM emp 
       ORDER BY DBMS_RANDOM.RANDOM()) 
 WHERE ROWNUM <= 3;

   
   
 DECLARE       
    BEGIN
       FOR i IN 1..35
       LOOP
           insert into emaillist values (DBMS_RANDOM.STRING('L',  10), concat(DBMS_RANDOM.STRING('L',  5), '@korea.com'), emaillist_seq.nextval);
       END LOOP;
       commit;
    END;  
    /
    
    
    
// 전체 게시물 수와 페이지 크기를 가지고 전체 페이지 개수를 계산한다.
// 소수점에 따라 계산 상의 오류가 없도록 두 가지 중 한 가지를 이용한다.
방법 1 : pageCount = totalCount / PAGE_SIZE;
방법 2 :pageCount = (int)Math.ceil(totalCount / (PAGE_SIZE+0.0));

if((totalCount % PAGE_SIZE) !=0)
pageCount++;

// 현재 그룹 설정
int curGroup = (curPage-1) / GROUP_SIZE;


drop table bbs purge;

create table bbs(
bid  number(6)  primary key,  --글번호
subject 	varchar2(100),    --제목
writer 		varchar2(20),     ---작성자
password 	varchar2(15),     --비밀번호
idate		date,             --작성일
contents        varchar2(2000),  --글내용
email           varchar2(50), --이메일
ip		varchar2(30), --작성자 pc ip
fileYN		char(1)   default 'N' check( fileYN in('Y','N')) ,   --file첨부 여부
rcount		number(5)  default 0,   --조회수 
vcount 		number (5)  default 0  --추천
);

drop sequence bbs_seq;
create sequence bbs_seq nocache;


create table bbs_comment (
cmid    number(6)  primary key, 
rbid   number(6), 
writer varchar2(20), 
idate  date, 
contents  varchar2(1000), 
password   varchar2(15), 
ip      varchar2(30)
);

drop sequence comment_seq;
create sequence comment_seq nocache;


insert into bbs (bid, subject, writer, idate, contents, password, ip)
values (bbs_seq.nextval, '테스트', '게시판지기', sysdate, 
'게시판 테스트입니다', '1234', '70.12.50.130');

insert into bbs_comment (cmid, rbid, writer, idate, contents, password, ip
) values (comment_seq.nextval, -1, '관리자', sysdate, 
'댓글 테스트입니다', '1234', '70.12.50.131');
commit;

create table bbs_file (
    fid   number primary key,
    rbid   number ,
    filename  varchar2(50),
    filetype   varchar2(15)
);
 
create sequence bbsfile_seq nocache;
commit;

select * from bbs;
select * from bbs_comment;
select * from bbs_file;





```


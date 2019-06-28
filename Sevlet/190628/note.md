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



---



#### 페이지 변경

##### requestDispatcher(컨텍스트 패스 스트링)

- requeat 추가 정보 전달 가능



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

  >View 는 JSP,
  >
  >Controller 는 Servelt
  >
  >data 영속성과 비즈니스로직은 JavaObject

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

    


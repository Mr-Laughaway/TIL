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




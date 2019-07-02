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
      3. session scope - session.invalidate, 브라우저 종료
      4. application scope - 웹 컨텍스트
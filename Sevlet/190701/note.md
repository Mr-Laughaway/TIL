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
  
  <%= 출력 내용 %> // == <% out.print(출력내용); %>
  
  ```

  
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
    - 동일한 웹 컨텍스트만 가능
    - 처음 요청한 url 유지
  - redirect 방식
    - 동일한 웹 컨텍스트와 다른 웬 컨텍스트/웹 서버 둘 다 가능
    - 최종 요청 url 로 출력




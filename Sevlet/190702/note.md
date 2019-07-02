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
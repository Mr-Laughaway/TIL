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


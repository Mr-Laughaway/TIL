# HTML5

### 웹 구조 이해

> 강의 자료를 봐야 할 듯...
>
> "webapp_arch.pptx"



### 웹 역사

- 1990년대 초반 -  WEB 1.0

  - 팀 리버스? 

  - 단순 html 서비스

  - 동기 방식(sync)

  - 전체 페이지 갱신 방식

  - 정적 서비스(static)

    - CGI 로 동적페이지 생성 -> 서버 과부하

    - 별도의 container 서버를 두어 해결

      많은 요청을 동시에 해야하기에 thread 방식 사용

  - EJB (분산 시도... 실패)



- BackEnd

  -> Servlet (Server Applet)

  -> JSP (Java Server Page: Model1 방식)

  -> EJB 등장 (분산처리 -> 실패)

  -> Servlet(Controller) + JSP(VIew) : Model2 방식

  -> Framework 등장 (Structs, Spring 등)

  -> 표준화 (국내는 전자정부 표준화 프레임웍 등 - Spring으로 되어 있음)



- FrontEnd

  - HTML - 구조 정의
  - CSS - 스타일 정의
  - javascript - 동작 정의

  -> Rich Client Internet(Flash, IE Active X 등)

  -> IE 전용 함수등 문제점 등장

  -> W3C 웹 표준화(해외: 2000초반~ , 국내: 2000중반~)

  -> Ajax 비동기 요청 등장

  -> 스마트폰의 등장으로  멀티미디어 태그, app cache, web storage 등등 기능 등장

  ***HTML5_V2.pdf 읽어라*** 
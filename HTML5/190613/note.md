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



- hello.html

  ```html
  <!DOCTYPE html>
  
  <html>
  
  <head>
  <meta charset="UTF-8">
  <title>hello.html</title>
  <style>
  body {
    font-size: 20px;
    color: red;
  }
  </style>
  </head>
  
  <body>
  안녕하세요? 처음 만들어보는 html 문서...<br>
  <!-- html 주석, 브라우저 엔진 파서가 해석하지 않습니다. -->
  <a href="https://www.w3schools.com">Visit W3Schools.com!</a><br> <!-- Inline 태그 -->
  The <abbr title="World Health Organization">WHO</abbr> was founded in 1948.<br>
  <hr>
   Block 태그<br>
  <h1>Block 태그</h1> <!-- Block 태그 -->
  <h2>Block 태그</h2>
  <h3>Block 태그</h3>
  <h4>Block 태그</h4>
  <h5>Block 태그</h5>
  <h6>Block 태그</h6>
  <hr>
  기본적으로 원자핵은 내부의 양성자로 인해 양전하를 띠므로 두 개의 원자핵이 서로 접근하게 되면 
  전기적인 척력에 의해 서로 밀어내게 된다. 하지만 원자핵을 초고온으로 가열하면 원자핵의 
  운동에너지가 전기적 척력을 이겨내어 두 원자핵이 서로 충돌하게 된다. 그리고 이후에는 두 원자핵 사이에 
  강력한 인력이 작용해 하나의 원자핵으로 결합될 수 있다. 가장 가벼운 원소인 수소의 원자핵끼리 핵융합을 
  위해 필요한 온도는 대략 1억℃ 이상이며, 더 무거운 원자핵들 
  간의 핵융합에는 더 고온의 환경이 필요하다.
  <hr>
  <p>기본적으로 원자핵은 내부의 양성자로 인해 양전하를 띠므로 두 개의 원자핵이 서로 접근하게 되면</p> 
  <p>전기적인 척력에 의해 서로 밀어내게 된다. 하지만 원자핵을 초고온으로 가열하면 원자핵의</p>  
  <p>운동에너지가 전기적 척력을 이겨내어 두 원자핵이 서로 충돌하게 된다. 그리고 이후에는 두 원자핵 사이에</p> 
  <p>강력한 인력이 작용해 하나의 원자핵으로 결합될 수 있다. 가장 가벼운 원소인 수소의 원자핵끼리 핵융합을</p>  
  <p>위해 필요한 온도는 대략 1억℃  이상이며, 더 무거운 원자핵들 </p> 
  <p>간의 핵융합에는 더 고온의 환경이 필요하다.</p> 
  <hr>
  <b>Block 태그</b>
  <i>Block 태그</i>
  <small>Block 태그</small>
  <sub>Block 태그</sub>
  <sup>Block 태그</sup>
  <ins>Block 태그</ins>
  <del>Block 태그</del>
  <hr>
  <ruby>
    <span>大韓民國</span>
    <rt>대한민국</rt>
  </ruby>
  <hr>
  <p>Orderd List</p>
  <ol>
    <li>Facebook</li>
    <li>Tweeter</li>
    <li>Linked In</li>
  </ol>
  <p>Unorderd List</p>
  <ul>
    <li>Facebook</li>
    <li>Tweeter</li>
    <li>Linked In</li>
  </ul>
  <hr>
  <table border = 1>
    <tr><td>A</td><td>A</td><td>A</td></tr>
    <tr><td>A</td><td>A</td><td>A</td><td>A</td><td>A</td><td>A</td><td>A</td></tr>
    <tr><td>A</td><td>A</td><td>A</td><td>A</td></tr>
  </table>
  <table border = 1>
    <tr><td colspan = 2>칸</td><td>칸</td><td>칸</td></tr>
    <tr><td>칸</td><td>칸</td><td>칸</td><td>칸</td></tr>
    <tr><td>칸</td><td>칸</td><td>칸</td><td rowspan = 2>칸</td></tr>
    <tr><td>칸</td><td>칸</td><td>칸</td></tr>
  </table>
  <hr>
  <table border=1>
    <tr>
      <td rowspan=6>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td rowspan=2>성명</td>
      <td>한글</td>
      <td colspan=2>&nbsp;&nbsp;</td>
      <td colspan=2>나이(만)</td>
      <td colspan=2>&nbsp;&nbsp;</td>
      <td rowspan=2>성<br>별</td>
      <td rowspan=2 colspan=2>&nbsp;&nbsp;</td>
    </tr>
    
    <tr>
      <td>영문</td>
      <td colspan=2></td>
      <td colspan=2>주민등록번호</td>
      <td colspan=2></td>
    </tr>
    
    <tr>
      <td colspan=2>현주소</td>
      <td colspan=9></td>
    </tr>
    
    <tr>
      <td colspan=2>e-mail</td>
      <td colspan=9></td>
    </tr>
    
    <tr>
      <td colspan=2>신장</td>
      <td colspan=2>&nbsp;&nbsp;&nbsp;cm</td>
      <td >몸무게</td>
      <td colspan=2>&nbsp;&nbsp;&nbsp;kg</td>
      <td colspan=2>혈액형</td>
      <td colspan=2>&nbsp;&nbsp;형</td>
    </tr>
    
    <tr>
      <td colspan=2>전화번호</td>
      <td colspan=3></td>
      <td colspan=2>휴대폰</td>
      <td colspan=4></td>
    </tr>
  </table>
  <hr>
  
  <img src='C:\Users\Public\Pictures\Sample Pictures\Koala.jpg'
    alt="코알라" title="코알라" width='300' />
  <hr>
  
  <audio src="sample.mp3" autoplay controls loop></audio>
  <hr>
  
  <video width='320' autoplay controls loop>
    <source src='sample.mp4' type='video/mp4'>
  </video>
  <hr>
  
  
  
  </body>
  
  </html>
  
  
  ```



- form.html

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  </head>
  <body>
  
  <h1>회원가입</h1>
  <form method="post" action="login.jsp" name="" id="">
    아 이 디 : <input type="text" name="userid" id="userid"><br>
    비밀번호 : <input type="text" name="password" id="password"><br>
    <input type="submit" value="로그인">
    <input type="reset" value="취소">
  </form>
  
  
  </body>
  </html>
  ```

  


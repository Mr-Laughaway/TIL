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
    아 이 디 : <input type="text" name="userid" id="userid" required><br>
    비밀번호 : <input type="text" name="password" id="password"><br>
    
    URL : <input type="url" name="url"><br>
    EMAIL : <input type="email" name="email"><br>
    연락처 : <input type="tel" name = "phone"
      pattern="\d{3}-\d{4}-\d{4}"
      placeholder="000-0000-0000"
    ><br>
    number : <input type="number" max=100 min=0 step=5 title="0~100값 허융"><br>
    
    <input type="submit" value="로그인">
    <input type="reset" value="취소">
  </form>
  
  
  </body>
  </html>
  ```



- CSS 실습

  ***csstest.htm***

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="csstest.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  
    <header>
      상단 헤더
    </header>
    
    <nav>
      내비게이션 메뉴
    </nav>
    
    <div class="conlay">
    <section>
      메인 콘텐츠
    </section>
    
    <aside>
      사이드바
    </aside>
    <div class="clear"></div>
    </div>
    
    
    <footer>
      하단 푸터
    </footer>
    
  
  </body>
  </html>
  ```

  

  ***csstest.css***

  ```css
  @charset "UTF-8";
  
  * {
    padding: 0;
    margin 0;
  }
  
  li {
    list-style-type: none;
  }
  
  .clear {
    clear: both;
  }
  
  .conlay {
    width: 997px;
  }
  
  header {
    width: 995px;
    height: 100px;
    margin-top: 10px;
    border: solid 1px green;
  }
  
  #logo {
    float: left;
    border: solid 1px red;
  }
  
  #top {
    float: right;
    margin: 30px 20px 0 0;
    border: solid 1px red;
  }
  
  nav {
    width: 995px;
    height: 70px;
    margin-top: 10px;
    border: solid 1px green;
  }
  
  section {
    width: 674px;
    height: 240px;
    float: left;
    margin-top: 10px;
    border: solid 1px green;
  }
  
  aside {
    width: 290px;
    height: 240px;
    float: left;
    margin-top: 10px;
    margin-left: 29px;
    border: solid 1px green;
  }
  
  footer {
    width: 995px;
    height: 130px;
    margin-top: 10px;
    border: solid 1px green;
  }
  
  ```

  

  #### Tag들

  - iframe 

    ```html
    <iframe src="https://www.daum.net">
      <p>Your browser does not support iframes.</p>
    </iframe>
    ```

    target 대상으로 지정 가능

    ```html
    <h2>국내 주요 사이트</h2>
    <p><a href="http://www.naver.com" target="site">네이버</a></p>
    <p><a href="http://www.daum.net" target="site">다음</a></p>
    <p><a href="http://www.google.com" target="site">구글</a></p>
    
    <iframe width="800" height="300" src="http://www.yes24.com" name="site"></iframe>
    ```

    

  - meter

    ```html
    <meter value="2" min="0" max="10">2 out of 10</meter><br>
    <meter value="0.6">60%</meter>
    ```

    

  - img > map > area

    ```html
    <img src="./images/navi.jpg" alt="" usemap="#Map1" />
    <map name="Map1">
      <area shape="rect" coords="0,0,40,35" href="http://mail.naver.com" alt="메일" />
      <area shape="rect" coords="40,0,70,35" href="http://section.cafe.naver.com" alt="카페" />
      <area shape="rect" coords="70,0,115,35" href="http://section.blog.naver.com" alt="블로그" />
    </map>
    ```

  

  - embed

    ```html
    <p>Yellow - Coldplay 뮤직 비디오</p>
    <embed src="https://www.youtube.com/embed/yKNxeF4KMsY" width="560" height="315" >
    ```

  

  - label, optgroup, option

    ```html
    <label>
        <select>
            <optgroup label="한식">
                <option>비빔밥</option>
                <option>갈비탕</option>
                <option>김치찌게</option>
                <option>된장찌게</option>
            </optgroup>
            <optgroup label="중식">
                <option>짜장면</option>
                <option>짬뽕</option>
                <option>탕슉</option>
            </optgroup>
            <optgroup label="양식">
                <option>돈까스</option>
                <option>스파게티</option>
            </optgroup>
        </select>
    </label>
    ```

    

  - svg

    ```html
    <svg width="100" height="100">
      <circle cx="50" cy="50" r="40" stroke="green" stroke-width="4" fill="yellow" />
      Sorry, your browser does not support inline SVG.
    </svg>
    ```

  

  - ***frameset, frame*** (아주 유용할 듯)

    ***frame_test.html***

    ```html
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>Frame test</title>
    </head>
    
    <frameset rows="40%, 60%">
      <frame src="top.html"/>
      <frameset cols="30%,70%">
        <frame src="left.html"/>
        <frame src="right.html"/>
      </frameset>
    </frameset>
    
    </html>
    ```

    ***top.html***

    ```html
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>top</title>
    </head>
    <body style="background-color:green">
      top
    </body>
    </html>
    
    ```

    ***left.html***

    ```html
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>left</title>
    </head>
    <body style="background-color:blue">
      left
    </body>
    </html>
    
    ```

    ***right.html***

    ```html
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>right</title>
    </head>
    <body style="background-color:yellow">
      right
    </body>
    </html>
    
    ```

  

  

  ### tag를 활용한 layout 분리

  #### 개인 실습

  *layouttest.html*

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <link href="layouttest.css" rel="stylesheet" type="text/css">
  </head>
  <body>
  
    <header>
      <h2>머리말 입니다.</h2>
      <nav>
        네비게이션 영역. 이전 이후 등
      </nav>
    </header>
    <section>
      <article> 첫 번째 기사  </article>
      <article> 두 번째 기사  </article>
      <article> 세 번째 기사  </article>
    </section>
    <aside> 광고입니다. 계란 사세요. 계란  </aside>
    <div class="clear"></div>
  
    
    
    <footer>
      하단 푸터
    </footer>
    
  
  </body>
  </html>
  
  ```

  

  *layouttest.css*

  ```css
  @charset "UTF-8";
  
  * {
    padding: 0;
    margin 0;
  }
  
  li {
    list-style-type: none;
  }
  
  .clear {
    clear: both;
  }
  
  .conlay {
    width: 997px;
  }
  
  header {
    width: 995px;
    height: 100px;
    margin-top: 10px;
    border: solid 2px green;
    background: yellow;
  }
  
  #logo {
    float: left;
    border: solid 1px red;
  }
  
  #top {
    float: right;
    margin: 30px 20px 0 0;
    border: solid 1px red;
  }
  
  nav {
    float: right;
    border: solid 2px green;
    background: chartreuse;
  }
  
  section {
    width: 674px;
    height: 240px;
    float: left;
    margin-top: 10px;
    border: solid 1px green;
    background: lightgray;
  }
  
  article {
    margin-left: 20px;
    margin-top: 10px;
    margin-right: 20px;
    height: 30px;
    background: white;
    border: solid 1px green;
  }
  
  aside {
    width: 290px;
    height: 240px;
    float: left;
    margin-top: 10px;
    margin-left: 29px;
    border: solid 1px green;
  }
  
  footer {
    width: 995px;
    height: 130px;
    margin-top: 10px;
    border: solid 1px green;
  }
  
  
  ```

  

  #### 강사님 모범 답안

  *layout1_teacher.html*

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  	<meta charset="utf-8">
  	<title>semantic3</title> 
  	<style>
  		header { 
            background:yellow; 
            border:2px solid blue;
            position:relative;
  		margin-bottom:10px;
          }
  		nav { 
            background:lime; 
            border:1px solid red;
            position:absolute;
  		  right:5px;
            bottom:2px;
            width:300px; 
          }
  		section { 
            padding:10px;
            maring:10px;
            border:1px solid black;
  		  background:lightgray;
            width:70%; 
          }
  		article { 
            padding:20px;
            margin:10px;
            border:1px solid black;
  		  border-radius:8px;
            background:beige;
          }
  		aside { 
            float:right;
            width:20%;
            background:orange;
            padding:10px; 
          }
  		footer { 
            background:yellow; 
            border:1px solid blue;
            margin-top:10px; 
          }
  
  	</style>
  <body>
  	<header> <h2>머리말입니다.</h2>
  		<nav> 내비게이션 영역. 이전, 이후, 홈</nav>
  	</header>
  	<aside> 광고입니다. 계란 사세요. 계란</aside>
  	<section>
  		<article> 첫 번째 기사 </article>
  		<article> 두 번째 기사 </article>
  		<article> 세 번째 기사 </article>
  	</section>
  	<footer> 꼬리말입니다. 회사 연락처 등</footer>
  </body>
  </html>
  
  
  ```

  

  

  ### CSS 스타일 입히기 연습

  - Puppy

    *puppy.html*

    ```html
    <!DOCTYPE html>
    <html lang="ko">
    <head>
    	<meta charset="utf-8">
    	<title>강아지 키우기</title>
    	<link href="puppy.css" rel="stylesheet" type="text/css">
    </head>
    <body>
    	<header>
    		<h1>입양하기</h1>
    		<nav>
    			<ul>
    				<li><a href="#">애완견 종류</a></li>
    				<li><a href="#">입양하기</a></li>
    				<li><a href="#">건강돌보기</a></li>
    				<li><a href="#">더불어살기</a></li>
    			</ul>
    		</nav>
    	</header>
    	<section>
    		<h2>강아지 용품 준비하기</h2>
    		<img src="puppy.jpg" id="puppy">
    		강아지 집
    		강아지가 편히 쉴 수 있는 포근한 집이 필요합니다. 강아지의 집은 강아지가 다 큰 후에도 계속 쓸 수 있는 집으로 구입하세요.집을 구입하실 때는 박음질이 잘 되어 있는지, 세탁이 간편한 제품인지 꼭 확인하시고 고르시는 것이 좋습니다.
    		
    		강아지 먹이
    		강아지의 먹이는 꼭 어린 강아지용으로 나와있는 사료를 선택하세요. 강아지들은 사람에 비해 성장속도가 8배정도 빠르답니다. 따라서 강아지에게는 성장속도에 맞는 사료를 급여하셔야 합니다. 사람이 먹는 음식을 먹게 되면 양념과 향신료에 입맛이 익숙해지고, 비만이 될 가능성이 매우 높아집니다. 강아지용 사료는 생후 12개월까지 급여하셔야 합니다.
    		
    		밥그릇, 물병
    		밥그릇은 쉽게 넘어지지 않도록 바닥이 넓은 것이 좋습니다.물병은 대롱이 달린 것으로 선택하세요. 밥그릇에 물을 주게 되면 입 주변에 털이 모두 젖기 때문에 비위생적이므로 대롱을 통해서 물을 먹을 수 있는 물병을 마련하시는 것이 좋습니다.
    		
    		이름표, 목줄
    		강아지를 잃어버릴 염려가 있으니 산책할 무렵이 되면 이름표를 꼭 목에 걸어주도록 하세요. 그리고 방울이 달린 목걸이를 하고자 하실 때는 신중하셔야 합니다. 움직일 때마다 방울이 딸랑 거리면 신경이 예민한 강아지들에게는 좋지 않은 영향을 끼칠 수 있기 때문입니다.
    	</section>
    	<footer>
    		<p>Copyright 2012 funnycom</p>
    	</footer>
    </body>
    </html>
    
    ```

    *puppy.css*

    ```css
    @charset "UTF-8";
    /* CSS Document */
    
    body {
      font-family: "맑은 고딕", "고딕", "굴림";
    }
    
    header {
      width: 620px;
      margin-right: auto;
      margin-left: auto;
      background-color: #069;
      padding: 10px;
      overflow: hidden;
    }
    
    header h1 {
      width: 140px;
      float: left;
      color: #ffffff;
    }
    
    header nav {
      width: 460px;
      float: right;
    }
    
    nav ul {
      list-style-type: none;
    }
    
    nav ul li {
      display: inline; /* 줄바꿈 안 하고 한 라인에 표시 */
      float: left;
      margin: 10px;
    }
    
    nav ul li a {
      color: white;
      text-decoration: none;
    }
    
    p {
      font-size: 15px;
      line-height: 20px;
    }
    
    h1 {
     font-size: 2em; 
    }
    
    section {
      width: 600px;
      margin-right: auto;
      margin-left: auto;
      border: 5px solid #333;
      padding: 15px;
    }
    
    img#puppy {
      float: right;
      margin-left:10px;
      border: 1px solid #ccc;
      box-shadow: -2px 3px 5px #000;
      -moz-box-shadow: -2px 3px 5px #000;
      -webkit-box-shadow: -2px 3px 5px #000;
    }
    
    footer {
      width: 620px;
      margin-right: auto;
      margin-left: auto;
      margin-top: 0;
      padding: 10px;
      background-color: #333;
      color: white;
      text-align: center;
    }
    
    
    ```

  

  - signup.html

    ```html
    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <style>
      body {
        background: #666;
      }
      
      #container {
        width: 450px;
        margin: 15px auto;
        padding: 10px;
        border: 1px solid #666;
        border-radius: 10px;
        background: white;
      }
      
      ul {
        list-style-type: none;
      }
      
      ul li {
        line-height: 25px;
        margin-bottom: 10px;  
      }
      
      label {
        width: 80px;
        float: left;
        text-align: right;
        padding-right: 5px;
        font-weight: bold;
      }
      
      .centered {
        text-align: center;
      }
    </style>
    </head>
    <body>
    <div id="container">
      <h1>가입 정보</h1>
      <form action="/register.jsp"  method="get"> 
        <ul>
          <li>
            <label for="uname">이름</label>
            <input type="text" id="uname" name="uname" placeholder="홍길동" required>
          </li>
           <li>
            <label for="email">이메일</label>
            <input type="email" id="email" name="email" placeholder="abcd@abcd.com" required>
          </li>
           <li>
            <label for="pw">비밀번호</label>
            <input type="password" id="pw" name="pw" required>
          </li>
          <li>
            <label for="sex">비밀번호</label>
            <select id="sex" name="sex">
              <option value="w"> 여성 </option>
              <option value="m"> 남성 </option>
            </select>
          </li>
        </ul>
        <div class="centered">
          <input type="submit" value="가입하기" class="centered">
        </div>
      </form>
    </div>
    </body>
    </html>
    
    ```

    
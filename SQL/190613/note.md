#### Tag들



- tag.html

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>태그 테스트</title>
  </head>
  <body>
  
  
  <iframe src="https://www.daum.net">
    <p>Your browser does not support iframes.</p>
  </iframe>
  
  <hr>
  
  <meter value="2" min="0" max="10">2 out of 10</meter><br>
  <meter value="0.6">60%</meter>
  
  <hr>
  
  <img src="./images/navi.jpg" alt="" usemap="#Map1" />
  <map name="Map1">
    <area shape="rect" coords="0,0,40,35" href="http://mail.naver.com" alt="메일" />
    <area shape="rect" coords="40,0,70,35" href="http://section.cafe.naver.com" alt="카페" />
    <area shape="rect" coords="70,0,115,35" href="http://section.blog.naver.com" alt="블로그" />
  </map>
  
  <hr>
  
  <h2>국내 주요 사이트</h2>
  <p><a href="http://www.naver.com" target="site">네이버</a></p>
  <p><a href="http://www.daum.net" target="site">다음</a></p>
  <p><a href="http://www.google.com" target="site">구글</a></p>
  
  <iframe width="800" height="300" src="http://www.yes24.com" name="site"></iframe>
    
  <hr>
  
  </body>
  </html>
  ```

  

- layouttest.html

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



- layouttest.css

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



- layout1_teacher.html

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

  

- iframe_test.html

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>iframe 테스트</title>
  </head>
  <body>
  
  h2>국내 주요 사이트</h2>
  <p><a href="http://www.naver.com" target="site">네이버</a></p>
  <p><a href="http://www.daum.net" target="site">다음</a></p>
  <p><a href="http://www.google.com" target="site">구글</a></p>
  
  <iframe width="800" height="300" src="http://www.yes24.com" name="site">
  
  
  </body>
  </html>
  ```

  

- frame_test.html

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
  
  <!-- top.html -->
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
  
  <!-- left.html -->
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
  
  <!-- right.html -->
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

  
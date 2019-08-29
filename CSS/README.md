# CSS

Cascading Style Sheets



## 목차

* [I. 문법](#i-문법)
* [II. 대표적인 속성들](#ii-대표적인-속성들)
  + [background](#background)
  + [background-image](#background-image)
  + [float](#float)
  + [nth-child(n), collapse, opacity](#nth-child(n), collapse, opacity)
  + [hirerarchy, h1+h2, :hover, :active, ::first-child, ::first-line](#hirerarchy, h1+h2, :hover, :active, ::first-child, ::first-line)
  + [inline](#inline)
  + [padding](#padding)
  + [position](#position)
  + [select[attr=xxx]](#select[attr=xxx])
  + [border-collapse](#border-collapse)
  + [transition](#transition)



## I. 문법

```css
selector {
	property: value value value ... ;
	...
}
```

작성된 파일은 html 문서에 아래와 같이 적용한다.

```thml
<!DOCTYPE html>
<html>
태그: 내용에 대한 구조적 변경 -> 파서 -> 생성 결과물 DOM TREE
Element

<style>
브라우저의 렌더러가 적용

<!-- html 주석 -->
<link rel='stylesheet 등' type='text/css 등' href="대상 문서">

css 주석 : /* 주석 *>
@charset "UTF-8";  <-- 파일 첫 머리에 지정하는게 좋다
```



## II. 대표적인 속성들

### background

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>background</title>
<style>
  body {
    background-color: yellow;
  }
  
  #button {
    width: 120px;
    height: 25px;
    padding: 8px;
    background-color: blue;
    color: white;
    text-align: center;
  }
</style>
</head>
<body>
  <h3>캠핑장 9월 예약</h3>
  <ul>
    <li>9월분 예약 2019년 8월 16일(수) 14:00부터~</li>
    <li>문의전화 : 031-222-1234</li>
  </ul>
  <div id='button'>
    자세히 보기 &gt;
  </div>

</body>
</html>
```

### background-image

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bgimg</title>
<style>
  body {
    background-image: url('bg.jpg');
    background-repeat: no-repeat;
  }
  
  h3 {
    background-color: yellow;
    padding: 8px;
  }
</style>
</head>
<body>
  <h3>강아지</h3>
  <img src="puppy.jpg">

</body>
</html>
```

### float

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Store</title>
<style>
  body {
    width: 997px;
  }
  
  hr {
    border: 3px solid gray;
  }
  
  ul {
  
  }
  
  li {
    clear: both;
    margin-top: 10px;
    list-style-type: none;
    height: 110px;
    border-bottom: solid 2px lightgray;
  }
  
  li img {
    width: 80px;
    height: 100px;
    float: left;
  }
  
  li p {
    
    margin-top: 0px;
    margin-left: 10px;
    width: 400px;
    float: left;
    font-size: 20px;
    font-weight: 10px;
  }
  
  .div_price {
    float:left;
    margin-left: 100px;
  }
  
  .price {
    display: block;
    width: 100px;
    font-weight: bold;
    color: red;
  }
  
  .post {
    
  }
  
  .writer {
    float: right;
    font-weight: bold;
    
  }
  
</style>
</head>
<body>

<h2>판매 도서 목록</h2>
<hr class="bar">

<ul>
  <li>
    <img src="../images/puppy.jpg">
    <p>[견권] 앞차기</p>
    <div class="div_price">
      <span class="price">13,500원</span>
      <span class="post">배송비 2,500</span>
    </div>
    <span class="writer">흰둥이</span>
  </li>
  <li>
    <img src="../images/puppy.jpg">
    <p>[견권] 실전 견권 입문</p>
    <div class="div_price">
      <span class="price">23,500원</span>
      <span class="post">배송비 3,500</span>
    </div>
    <span class="writer">흰둥이</span>
  </li>
</ul>

</body>
</html>
```

### nth-child(n), collapse, opacity

```html
<!DOCTYPE html>
<html>
<head>
  <title>CSS3 Style Property Basic</title>
  <style>
    p {
    }
    p:nth-child(1) {}
    p:nth-child(2) { font-size: 100%; }
    p:nth-child(3) { font-size: 150%; }
    p:nth-child(4) { font-size: 200%; }
    
    table {
      visibility: collapse;
    }
    
    #box {
      background-color: black;
      color: white;
      opacity: 0.2;
    }
  </style>
</head>
<body>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    
    <table>
      <tr>
        <td>df</td>
      </tr>
    </table>
    
    <br>
    
   
    <h4>Dummy</h4>
    <div id="box">
      <p> asdkjfadf;as;lkdf;lasdfj;asdj;fjas;d </p> 
      <p> asdkjfadf;as;lkdf;lasdfj;asdj;fjas;d </p>
    </div>
     <h4>Dummy</h4>
</body>
</html>
```

### hirerarchy, h1+h2, :hover, :active, ::first-child, ::first-line

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
  /* 후손 테스트 해라 */
  #header h3 { color: red; }
  #header > #d2 h3 { color: blue; }
  
  h1 + h2 { color: red;}
  h1 ~ h2 { background-color: orange;}
  
  h1:hover { background-color: black; color: yellow;}
  h1:active { background-color: red; color: black;}
  
  input:enabeld { background-color: white;}
  input:disabled { background-color: gray;}
  input:focus { background-color: orange;}
  input:checked {
    background-color: green; 
    color:green;
    width: 100px;
    height: 100px;
  }
  
  li { 
    list-style: none;
    float:left; padding: 15px;
  }
  
  li:first-child { border-radius: 10px 0 0 10px; }
  li:last-child { border-radius: 0 10px 10px 0; }
  li:nth-child(2n) { background-color: #f00003; }
  li:nth-child(2n+1) { background-color: #800000; }
  
  p::first-letter { font-size: 3em;}
  p::first-line { color: red;}
  p::selection { color: yellow; background-color: black;}
  
  a { text-decoration: none;}
  a:visited { color: green;}
  a:link::after { content: ' - ' attr(href) ' hahahaha!!!!!!!!!!!!!!'}
  
</style>

</head>
<body>
  <div id="header">
    <h3>자손태그</h3>
    <div id="d1">
      <h3>후손태그</h3>
    </div>
    <div id="d2">
      <div>
        <h3>후손태그</h3>
      </div>
    </div>
  </div>
  
  <h1>h1 태그</h1>
  <h2>h2 태그</h2>
  <h2>h2 태그</h2>
  <h2>h2 태그</h2>
  <h2>h2 태그</h2>
  
  <hr>
  
  <h4>Enabled</h4>
  <input />
  <h4>Disabled</h4>
  <input disabled="disabled"/><br>
  <label>체크박스</label> 
  <input type="checkbox"/>
  
  <hr>
  
  <ul>
    <li>First</li>
    <li>Second</li>
    <li>Third</li>
    <li>Fourth</li>
    <li>Fifth</li>
    <li>Sixth</li>
    <li>Seventh</li>
  </ul>
  <br>
  
  <h4></h4>
  <h5></h5>
  <h6></h6>
  <br>
  <hr>
  
  <p> Newmonoultramicroscopicsilicovolcanoconiosis alksdjflkasjdfl;kasjdflk;al;ksdjflkasjdfl;kajsd;lfkjas;ldkfj
  asj;dlfkjas;ldkfja;slkdfja;lskdjf;laksdjf;lkasjdf;lkasjdf;lkjasd;lkfj asdl;kf asd;as sdlf a;aslkdfaksd as;ldfkasd fsadf
  </p>
  <br>
  
  <p>Since fifteen hundred and sixteen minds asdklfjasl;kdjflkasjdflk;jasdlf;kjasl;kdfjlka;sjdflk;ajsdflkjasldk;fj
  asl;kdf asd;lkfj as;dlkf as;kdjf ;lkajsd f; as dfa;lskdf asd;lkfj asd;l asd;kjfasd;klfj
  </p>
  
  <hr>
  
  <h4><a>Nothing</a></h4>
  <h4><a href="http://hanb.co.kr">Hanbit Media</a></h4>
  <h4><a href="www.w3.org">W3</a></h4>
  <h4><a href="https://github.com">Github</a></h4>
  
</body>
</html>
```

### inline

```html
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<style>
  span, img {
    border: solid 1px red;
  }
  
  p, div {
    border: solid 1px blue;
  }
  
  li {
    list-style-type: none;
  }
  
  #v_menu {
    width: 150px;
  }
  
  #v_menu li {
    padding: 5px;
    border-bottom: dotted 1px black;
  }
  
  #h_menu li {
    display: inline;
  }
  
  .menus {
    margin: 0 20px 0 20px;
    color: green;
  }
  
  
 
</style>
</head>
<body>
<h2>인라인과 블록의 차이점</h2>

<h3>1. 인라인(수평 방향 레이아웃)</h3>
<img src="cheese.jpg">
<span>치즈</span>
<img src="juice.jpg">
<span>오렌지 주스</span>

<h3>2. 블록(수직 방향 레이아웃)</h3>
<p>이것은 단락입니다.</p>
<div>박스 A</div>
<div>박스 B</div>

<h3>1. 세로 메뉴</h3>
<ul id='v_menu'>
  <li>CEO 인사말</li>
  <li>조직도</li>
  <li>전화번호 안내</li>
  <li>찾아오시는 길</li>
</ul>

<h3>2. 가로 메뉴</h3>
<ul id='h_menu'>
  <li class='menus'>회사소개</li>
  <li>|</li>
  <li class='menus'>제품안내</li>
  <li>|</li>
  <li class='menus'>고객센터</li>
  <li>|</li>
  <li class='menus'>매장안내</li>
</ul>
</body>
</html>
```

### padding

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>padding</title>
<style>
  p {
    width: 500px;
    border: solid 2px black;
    margin-top: 20px;
  }
  
  h3 {
    border-left: solid 8px blue;
    padding-left: 10px;
  }
  
  #padding1 {
    padding: 20px;
  }
  
  #padding2 {
    padding-top: 20px;
    padding-right: 30px;
    padding-bottom: 40px;
    padding-left: 50px;
    /* padding: 20px 30px 40px 50px; */
  }
</style>
</head>
<body>
  <h3>서울동물원 소개</h3>
  <p id='padding1'> 서울동물원은 동.ㅁ;ㅣ나얼;ㅣ만얼;ㅣ만얼;ㅣ마넝ㄹ;ㅣㅏㅁㄴ얼;ㅣㅏㅁ넝ㄹ;ㅣㅏㅁㄴ얼
  ㅁㄴ이;라ㅓㅁㄴ;이라ㅓㅁㄴ;ㅣ아럼;니ㅏ얼;ㅣㅁ낭러ㅣ;ㅁ나얼;ㅣㅁ나ㅓㅇ리;ㅏㅁㄴ얼
  ㅁㄴ이;라ㅓㅁㄴ;ㅣㅇ라ㅓㅁ;니아럼ㄴ'이ㅏ러</p>
  <p id='padding2'> 서울동움ㄹ원은 동 식물원 ㅁ;ㅣㅏㅓㅇㄴㄹ;ㅣㅏㅁ넝ㄹ;ㅣㅏㅓㅁㄴㅇ;ㅣ라ㅓㅁㄴ;이ㅏ럼
  ㅁ넝;ㅣ라ㅓㅁㄴ;이라ㅓㅁ;ㄴ아ㅓㄹ;미나얼;ㅣㅁ나ㅓㅇㄹ;ㅣ마넝ㄹ;ㅣㅁ나ㅓㅇㄹ;ㅣ마넝ㄹ;ㅣㅏㅁ넝ㄹ
  ㅁ넝;ㅣ라ㅓㅁㄴ;이라ㅓㅁ;니아럼;니ㅏ얼;미나ㅓㅇㄹ;미낭러</p>

</body>
</html>
```

### position

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <style>
    .area {
      width: 400px;
      height: 100px;
      border: 3px solid black;
      
      position: relative;
      overflow: scroll;
    }
    
    .box {
      width: 100px; height: 100px;
      position: absolute;
      /*opacity: 0.5;*/
    }
    .red {
      background-color: red;
      left: 10px; top: 10px;
      z-index: 100;
    }
    .green {
      background-color: green;
      left: 50px; top: 50px;
      z-index: 10;
    }
    .blue {
      background-color: blue;
      left: 90px; top: 90px;
      z-index: 1;
    }
  </style>
</head>
<body>
  <h1>Lorem ipsum</h1>
  <div class="area">
    <div class="box red"></div>
    <div class="box green"></div>
    <div class="box blue"></div>
  </div>
  <h1>Lorem ipsum</h1>
  
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아1</span><br>
  <span>아아아아아2</span><br>
  <span>아아아아아3</span><br>
  <span>아아아아아4</span><br>
  <span>아아아아아5</span><br>
  <span>아아아아아6</span><br>
  <span>아아아아아7</span><br>
  <span>아아아아아8</span><br>
  <span>아아아아아9</span><br>
  <span>아아아아아10</span><br>
</body>
</html>
```

### select[attr=xxx]

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style>
  input[type=text] { background: red;}
  input[type=password] { background: blue;}
  
  img[src$=png] { border: solid 3px yellow;}
  img[src$=jpg] { border: solid 3px blue;}
</style>

</head>

<body>
  <form>
    <input type="text">
    <input type="password">
    <br>
    
    
    <img src="../images/foxtail.jpg">
    <img src="../images/full.png">
    <img src="../images/cheese.jpg">
  </form>
</body>
</html>
```

### border-collapse

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>table-border</title>
<style>
  table, th, td {
    border: solid 1px #000000;
  }
  
  table {
    border-collapse: collapse;
  }
  
  th {
    width: 80px;
    padding: 6px;
  }
  
  td {
    padding 6px;
    text-align: center;
  }
  
  #day {
    background-color: #adf0f4;
  }
  
  #title {
    background-color: #adcff4;
  }
</style>
</head>
<body>
  <h2>고속버스 예매</h2>
<table>
  <tr id='day'>
    <th colspan='4'>서울 &lt;=&gt; 대전 2020.9.6 수</th>
  </tr>
  <tr id='title'>
    <th>출발</th>
    <th>버스회사</th>    
    <th>등급</th>  
    <th>예약가능</th>    
  </tr>
  <tr>
    <td>11:50</td>
    <td>한진고속</td>
    <td>우등</td>
    <td><img src='full.png'></td>
  </tr>
  <tr>
    <td>12:50</td>
    <td>천일고속</td>
    <td>고속</td>
    <td><img src='empty.png'></td>
  </tr>
  <tr>
    <td>13:50</td>
    <td>한진고속</td>
    <td>우등</td>
    <td><img src='full.png'></td>
  </tr> 
</table>

</body>
</html>
```

### transition

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
  <style>
        input[type=checkbox]:checked + div {
            height: 0px;
        }
        div {
            overflow: hidden;
            background-color: green;
            width: 650px; height: 100px;

            /* 변환 효과를 적용합니다. */
            -ms-transition-duration: 1s;
            -webkit-transition-duration: 1s;
            -moz-transition-duration: 1s;
            -o-transition-duration: 1s;
            transition-duration: 1s;
        }
        
        div:hover {
          height:300px;
        }
    </style>
</head>
<body>
    <div>
        <h1>Lorem ipsum dolor amet</h1>
    </div>
</body>
</html>
```


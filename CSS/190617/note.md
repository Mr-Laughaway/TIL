### 문법

```css
selector {
	property: value value value ... ;
	...
}
```



```
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



#### 실습



*background*

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



*background-image*

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



***float (bookstore.html)***

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



*nth-child(n), collapse, opacity*

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








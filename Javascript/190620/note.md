### 복습

- 자바 스크립트 함수를 정의하는 방법

  - 함수 선언문으로 정의

    ```javascript
    function square(x) { return x*x* }
    ```

  - 함수 리터럴(익명 함수)로 정의

    ```javascript
    var square = function(x) { return x*x }
    square(5); //호출
    ```

  - Function 생성자로 정의

    ```javascript
    var square = new Function("x", "return x*x");
    square(5); //호출
    ```

  - 화살표 함수 표현식(람다식)으로 정의

    ```javascript
    var square = x => x*x;
    square(5); //호출
    ```

  - 즉시 실행 함수 - 익명 함수를 정의하고 바로 실행

    ```javascript
    (function(x) {return x*x})(5); //방법 1
    (function(x) {return x*x}(5)); //방법 2
    (function square(x) {return x*x;})(5);//방법 3
    ```

    >  한번 실행하므로 초기화 작업할 때 사용하며, 전역 유효 범위를 오염시키지 않는다.

    

- 모든 함수의 인수는 가변 길이를 가집니다.

  - 선언된 인수보다 적으면 인수를 참조할 때 ```undefined```

  - 선언된 인수보다 많으면 ```무시```한다.

  - 모든 함수가  생성될 때  인수가 저장되는 함수의 property는 Argument 객체의 arguments 입니다.

    ```arguments.length``` ,```arguments[index]```



-  자바 스크립트에서 재귀함수를 정의하고 사용할 수 있습니다.

  ```javascript
  function fact(n) {
  	if(n<=1) return
      
      return n*fact(n-1);
  }
  
  fact(5);
  ```



- 함수가 호출되어 실행되는 시점에 this 값이 결정됩니다.

  - 최상위 레벨의 코드에서 this는 Window 객체의 참조번수 window

  - 이벤트 핸들러Event Handler

    ```javascript
    window.onload = 이벤트핸들러 함수(){};
    window.onload = function() {
        this; // ? window
    }
    
    button.onclick = function() {
        this; // 클릭 이벤트가 발생한 버튼
    }
    ```

  - 생성자 함수 안에서 this는 생성자 함수로부터 생성되는 객체 자신

  - 호출된 함수 내부에서  this는 window입니다.



- ***클로저 함수***

  ```javascript
  function makeCounter() {
      var count = 0;
      return g;
  
      function g() { //클로저 함수
          return count++;
      }
  }
  
  var counter = makeCounter(); // 함수 수행이 끝나면 garbage collenction 되어야 하지만 클로저 함수를 리턴하는 함수의 실행 context는 그대로 남아 있다.
  console.log(counter());
  console.log(counter());
  console.log(counter());
  ```



- 객체 정의 방법

  - 객체 리터럴로 정의

    ```
    { 속성: 값, 속성:값, 속성:function(){}, ...}
    ```

  - 생성자 함수를 정의하고 생성자 함수로부터 객체 생성할 수 있습니다.

    ***특별함 방법 : 클로저 함수 사용!!!***

    ```javascript
    function Person(name, age) {
        var _name = name; //private 성격의 속성
        var _age = age;
        
        return {
            getName : function() { return _name; },
            getAge : function() { return _ age; },
            setAge : function(n) { _age = n; }
        };
    }
    
    var p = new Persion("kim", 30);
    //console.log(p_name); // 오류
    console.log(p.getName());
    console.log(p.getAge());
    ```



- 함수적 프로그래밍 특성
  - 변수에 함수를 저장할 수 있습니다.
  - 배열의 요소로 함수를 저장할 수 있습니다.
  - 함수 내부에 함수를 정의할 수 있습니다(nested function).
  - 함수에서 함수를 반환할 수 있습니다.
  - 용어] 내부에 함수를 정의하거나, 함수를 반환하는 함수를 고차 함수라고 합니다.
  - 함수의 인수로 함수를 전달할 수 있습니다.
  - 용어] 인수로 전달되는 함수를 콜백함수라고 합니다.



- 자바 스크립트 객체 분류
  - 내장 객체
    - Object
    - String
    - Boolean
    - Number
    - Array
    - Date
    - RegExp
    - ...
  - 브라우저 객체
    - Window
  - ECMAScript 객체



- Window 객체
  - close()
  - open(url, name, {...})
  - moveBy()
  - MoveTo()
  - alert()
  - confirm()
  - prompt()
  - setTimeout(function(){}, timeout millisecond), clearTimeout()
  - setInterval(function(){}, interval millisecond), clearInterval()



- Window객체의 속성 Document ***document*** : HTML 요소 관련 처리 객체
  - getElementById("")
  - getElementsByName("")
  - getElementsByTagName("");
  - getElementsByClassName("");
  - querySelector("css의 selector형식");  ```td:hover``` 등
  - querySelectorAll("css의 selector형식");
  - createElement("h1")
  - createComment
  - createTextNode("말말말")
  - createDocumentFragment
  - createAttribute()
  - setAttribute()
  - getAttribute()
  - removeAttribute()
  - Element.parentNod, childNodes
  - appendChild()



- Element 추가

  ```html
  <!DOCTYPE html>
  <html>
  <head>
    <meta charset="UTF-8">
    <title>InsertBefore 테스트</title>
  </head>
  <body>
    <ul id= 'doglist'>
      <li>포메라니안</li>
      <li>달마시안</li>
    </ul>
    
    <script>
    	var doglist = document.getElementById("doglist");
    	var element = document.createElement("li");
    	var text = document.createTextNode("불독");
    	//두 번째 자시 ㄱ요소의 바로 앞에 삽입
    	doglist.insertBefore(element, doglist.children[1]);
    	element.appendChild(text);
    </script>
  </body>
  </html>
  ```

  

- window scroll

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Scroll</title>
  <style>
    .box {
      display: inline-block;
      padding: 100px;
      margin: 100px;
      margin-left: 0;
      background-color: yellow;
    }
  </style>
  </head>
  
  <body>
    <div class="box" id="sec1">#sec1</div>
    <br>
    <div class="box" id="sec2">#sec2</div>
    <br>
    <div class="box" id="sec3">#sec3</div>
    
    <script>
    
    	function getScrollTop() {
    		if(window.pageYOffset !== undefined) {
    			return window.pageYOffset;
    		}
    		else {
    			return document.documentElement.scrollTop || 
    				document.body.scrollTop; 
    		}
    	}
    	
    	console.log(getScrollTop());
    	
    	function getScrollLeft() {
    		if(window.pageXOffset !== undefined) {
    			return window.pageXOffset;
    		}
    		else {
    			return document.documentElement.scrollLeft || 
    				document.body.scrollLeft; 
    		}
    	}
    	
    	console.log(getScrollLeft());
    	
    	if('scrollRestoration' in history) {
    		history.scrollRestoration = 'manual';
    	}
    	var element = document.getElementById("sec3");
    	var rect = element.getBoundingClientRect();
    	
    	console.log(rect.left + getScrollLeft());
    	console.log(rect.top + getScrollTop());
    	
    	scrollTo(rect.left + getScrollLeft(), rect.top + getScrollTop());
    </script>
  
  </body>
  </html>
  ```

  

- value 가져오기

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>폼 태그</title>
  <script>
  	function whenSubmit() {
  		// 변수를 선언합니다.
  		var pass = document.getElementById('pass').value;
  		var pass_check = document.getElementById('pass_check').value;
  		
  		//비번 같냐?
  		if(pass == pass_check) {
  			alert('성공');
  		}
  		else {
  			alert('다시 입력해주세요.');
  			return false;
  		}
  	}
  
   
  </script>
  </head>
  <body>
    <form id="my_form" onsubmit="whenSubmit()">
      <label for="name">이름</label><br/>
      <input type="text" name="name" id="name"/><br/>
      <label for="pass">비밀번호</label><br/>
      <input type="password" name="pass" id="pass"/><br/>
      <label for="pass_check">비밀번호 확인</label><br/>
      <input type="password" id="pass_check"/><br/>
      <input type="submit" value="제출"/>
    </form>
  </body>
  </html>
  ```

  

- Event 추가 및 강제 호출

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>이벤트</title>
    <script>
    	/*
    	//DOM level 0
    	window.onload = function() {
    		alert("load event handler1");
    	}
    	
    	window.onload = function() {
    		alert("load event handler2");
    	}
    	
    	window.onload = function() {
    		alert("load event handler3");
    	}
    	*/
    	
    	//DOM level1
    	/*
    	window.addEventListener("load", function(){
    		alert("load event handler1")}, false);
    	window.addEventListener("load", function(){
    		alert("load event handler2")}, false);
    	window.addEventListener("load", function(){
    		alert("load event handler3")}, false);
    	*/
    	
    	window.addEventListener("load", function(){
    		var h3 = document.getElementById("evt");
    		h3.onclick = function() {
    			alert("까꿍");
    			this.onclick = null;
    		}
    		
    		var h3_2 = document.getElementById("evt2");
    		h3_2.onclick = function() {
    			
    			this.style.background = 'orange';
    			this.style.color = 'yellow';
    		}
    	}, false);
    	
    </script>
  </head>
  <body>  
    <h3> 자바스크립트 이벤트</h3>
    # DOM Level 0 이벤트 모델 : on이벤트명 = function(){} => 
    이벤트당 하나의 이벤트 핸들러만 연결
    <br>
    #DOM Level 2 이벤트 모델:
    이벤트소스(태그객체).addEventListner("이벤트명", function(){}, 이벤트캡처여부)
    이벤트당 하나 이상의 이벤트 핸들러 연결
    <br>
    이벤트에 대한 이벤트 핸들러가 한번만 수행 후 이벤트 핸들러 취소하려면:
    이벤트 소스.on이벤트속성 = null;<br>
    <h3 id="evt"> 이벤트 핸들러 한 번만</h3>
    <h3 id="evt2"> 클릭이벤트가 발생하면 색 바꿔</h3>
    이벤트 핸들러 함수 내부에서 이벤트 객체의 속성들을 핸들링할 때 이벤트 소스 객체를 
    this 참조 합니다<br>
   
  
  </body>
  </html>
  ```



- location 객체

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
      window.onload = function() {
      	
      	var panel1 = document.getElementById("panel1")
      	var nNum = 1+Math.floor(Math.random()*100);
      	panel1.innerHTML = nNum;
      	panel1.style.fontSize = 100 + (Math.random()*100)+"px";
      	
      	setTimeout(function(){
      		//location.href = "https://www.w3schools.com";
      		//location.assign("https://www.naver.com");
      		//location.replace("https://www.google.com");
      		//location.reload();
      		location.href = location.href;
      	}, 3000);
      	
      }
    </script>
  </head>
  <body>
    <!-- h3> 이 페이지는 3초후에 www.w3schools.com 으로 이동합니다.</h3 -->
    <h3> 이 페이지는 3초후에 reload 됩니다.</h3>
    <div id="panel1">
      
    </div>
  </body>
  </html>
  ```

  

- history 객체

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
      window.onload = function() {
      	/*
  		history.pushState(null, null, "js01.html");
  		history.pushState(null, null, "js02.html");
  		history.pushState(null, null, "js03.html");
  		history.pushState(null, null, "js04.html");
  		history.pushState(null, null, "js05.html");
  		history.pushState(null, null, "js08.html");
  		*/
  		
  		document.getElementById("back").onclick = function() {
  			history.back();
  		}
  		
  		document.getElementById("next").onclick = function() {
  			history.forward();
  		}
  		
  		document.getElementById("goBack").onclick = function() {
  			history.go(-2);
  		}
  		
  		document.getElementById("goNext").onclick = function() {
  			history.go(3);
  		}
      }
    </script>
  </head>
  <body>
    <button id="back">이전</button> <br>
    <button id="next">다음</button> <br>
    <button id ="goBack">go(-2))</button> <br>
    <button id="goNext">go(3)</button> <br>
    <script>
    	document.write("화면해상도 : " + screen.width + " x " + screen.height);
    	document.write("<br>색상수화면해상도수(비트) : " +  screen.colorDepth);
    </script>
    
  </body>
  </html>
  ```

  

- 당첨번호 뽑기 예제

  ``` html
  <!DOCTYPE html >
  <html>
  <head>
  	<meta  charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		}
  		#panel1{
  			border:1px #000000 solid;
  			line-height:400px;
  			font-size:100px;
  			width:400px;
  			height:400px;
  			text-align:center;
  			vertical-align:middle;		
  		}
  	
  	</style>
  	<script>
  		/*
  		 	Step #8
  		 		- 1에서 참여인원수 내에서 랜덤숫자 만들기(20분)
  		 	Step #7
  				- 출력패널 스타일 초기화
  			Step #6-1
  				- 리팩토링
  			Step #6
  				- 당첨 버튼 클릭시 램덤숫자출력정지
  				- 현재 화면에 출력된 숫자가 당첨번호, 이를 부각시키기 위해서 글자색을 빨간색, 크기를 250px로 만듬.
  			Step #5
  				- 초기 시작시 랜덤숫자 만들기는 정지된 상태.
  				- 시작 버튼 클릭시 랜덤하게 숫자가 출력되도록 만들기.
  			Step #4
  				- step #1에서 만든 숫자를 레이아웃에 출력하기.("숫자가 출력될 영역"Element를 구해야겠죠?)
  			Step #3
  				- 레이아웃 구성하기(숫자가 출력될 영역, 시작버튼, 당첨버튼등이 있어야 겠죠?)
  			Math.
  			Step #2
  				- 0.1초에 한번씩 Random 하게 1부터 100사이의 정수 만들기.(setInterval을 이용하세요)
  			Step #1
  				- Random하게 1부터 100사이의 정수 만들기.
  		*/
  	 window.onload = function() {
  			
  		var panel = document.getElementById("panel1");
  		var nMax;
  		var idInterval = 0;
  		
  	 	document.getElementById("btn_start").onclick = function() {
  	 		if(idInterval == 0) {
      	 		nMax = document.getElementById("lab_total").value;
      	 		panel.style.color = 'black';
      	 		
      	 		idInterval = setInterval(function(){
      	 			panel.innerHTML = parseInt(Math.random()*nMax)+1;
      	 			panel.style.fontSize = (parseInt(Math.random()*200)+1) + 'px';
      	 		}, 100);
  	 		}
  	 	}
  	 	
  	 	document.getElementById("btn_stop").onclick = function() {
  	 		if(idInterval != 0) {
      	 		clearInterval(idInterval);
      	 		idInterval = 0;
      	 		panel.style.color = 'red';
      	 		panel.style.fontSize = '250px';
  	 		}
  	 	}
  		
  	}
  	</script>
  </head>
  
  <body>
  	<div> 
  		<h4>경품추첨기-ver 0.1</h4>
  	
  		<div id="panel1" > 1
  			<!-- 이곳에 숫자가 출력됩니다. -->
  		</div>
  	
  		<div id="nav">
  			참여인원 : <input type="text" id="lab_total" value="100">
  			<button id="btn_start">시작</button>
  			<button id="btn_stop">멈춤</button>
  		</div>
  	</div>
  </body>
  </html>
  
  ```

  

- 여러가지 변경 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  	<meta charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		
  		}
  		
  		div{
  			border: 1px solid #999999;
  			margin:20px;
  			margin-bottom:20px;
  		}
  		div div{
  			border: 1px dotted #CCC;
  			
  		}
  		
  		.active{
  			font-size:20pt;
  			color:#090;
  			border:5px solid #ff0000;
  		}
  	</style>
  	<script>
  	window.onload=function(){			
  		 solveM1();
  		 solveM2();
  		 solveM3();
  		 solveM4();
  		 solveM5();
  		 solveM6();
  	}
  	
  	function solveM1(){
  		// 노드 찾기
  		var m1 = document.getElementById("m_1");
  		// 스타일 변경하기.
  		m1.style.color = "#ff0000";
  	}
  	
  	function solveM2(){
  		// 노드 찾기.
  		var m2 = document.getElementById("m_2");
  		// 클래스 이름 변경하기.
  		m2.className = "active";
  	}
  	
  	function solveM3(){
  		// 노드 찾기.
  		var m2 = document.getElementById("m_3");
  		// 자식노드중에서 img 태그만을 찾은 후 첫번째 태그를 얻어온다. 
  		var img = m2.getElementsByTagName("img")[0];
  		// HTMLImageElement의 src 프로퍼티를 이용해서 이미지를 변경하는 경우.
  		img.src	= "ch3.png"
  		// Element의 setAttribute 메소드를 이용해서 이미지를 변경하는 경우.
  		img.setAttribute("src", "ch3.png");
  	}
  	
  	function solveM4(){
  		// p태그 노드 생성하기.
  		var p4 = document.createElement("p");
  		// 텍스트 설정하기.
  		p4.innerHTML = "항목4";
  		// 신규로 생성한 p태그를 추가할 부모 노드 찾기.
  		var m4 = document.getElementById("m_4");
  		// p태그를 부모노드에 추가하기.
  		m4.appendChild(p4);
  	}
  	
  	function solveM4_2(){
  		// p태그 노드 생성하기.
  		var p4 = document.createElement("p");
  		// text 노드 생성하기.
  		var text = document.createTextNode();
  		// 텍스트 설정하기.
  		text.nodeValue = "항목4";
  		p4.appendChild(text);
  
  		// 신규로 생성한 p태그를 추가할 부모 노드 찾기.
  		var m4 = document.getElementById("m_4");
  		// p태그를 부모노드에 추가하기.
  		m4.appendChild(p4);
  	}
  	
  	function solveM5(){
  		//부모노드 찾기.
  		var m5 = document.getElementById("m_5");
  		// m5의 자식노드에서 <p>태그만을 모두 찾기.
  		var ps = m5.getElementsByTagName("p");
  				
  		for(var i=0;i<ps.length;i++){
  			var p = ps[i];
  			
  			//p.firstChild는 text node 입니다.
  			var text = p.firstChild.nodeValue;
  		
  			// p요소중 텍스트값이 항목4를 가지고 있는 노드를 찾아 삭제.	
  			if(text.indexOf("항목4")!=-1){
  				m5.removeChild(p);
  				break;
  			}
  		}
  	}
  	
  	function solveM5_2(){
  		var m5 = document.getElementById("m_5");
  		var ps = m5.getElementsByTagName("p");
  		
  		m5.removeChild(ps[2]);
  		// 또는 m5.removeChild(ps.item(2))
  	}
  
  	
  	function solveM6(){
  		// 제거할 노드와 가장 근접한 노드를 찾습니다.
  		var m6 = document.getElementById("m_6");
  		// 제거하기.
  		document.body.removeChild(m6.parentNode);
  	}
  	
  	function solveM6_2(){
  		// 제거할 노드와 가장 근접한 노드를 찾습니다.
  		var divs = document.getElementsTagName("div");
  		// 제거하기.
  		document.body.removeChild(divs[11]);
  	}
  	</script>
  </head>
  
  <body>
  	<div> 
  		<h4>테스트1</h4>
  		<div id="m_1">
  			#m_1 : 글자색을 빨간색으로 변경해주세요.
  		</div>
  	</div>
  	<div> 
  		<h4>테스트2</h4>
  		<div id="m_2">
  			#m_2 : 클래스 active를 적용시켜 주세요.
  		</div>
  	</div>
  	<div> 
  		<h4>테스트3</h4>
  		<div id="m_3">
  			#m_3 : 에고 이 이미지가 아닌데... 이미지를 ch3.png로 변경해주세요"<br>
  			<img src="ch2.png">
  		</div>
  	</div>
  	<div> 
  		<h4>테스트4</h4>
  		<div id="m_4">
  			#m_ 4 :  홋! 항목4까지 있어야 하는건데, 바쁜나머지 실수를 했군요. 항목4를 제일 뒤에 추가해주시겠어요?
  			<p>
  				항목1
  			</p>
  			<p>
  				항목2
  			</p>
  			<p>
  				항목3
  			</p>
  		</div>
  	</div>
  	<div> 
  		<h4>테스트5</h4>
  		<div id="m_5">
  			#m_ 5 :  이번에는 항목4가 더 추가되었네요. 즉시 삭제해주세요.
  			<p>
  				항목1
  			</p>
  			<p>
  				항목4
  			</p>
  			<p>
  				항목2
  			</p>
  		</div>
  	</div>
  	<div> 
  		<h4>테스트6</h4>
  		<div id="m_6">
  			#m_ 6 : 이런이런! 이 부분은 전혀 필요없는 내용들인데 왜 있는거죠? #m_6부터 헤더태그까지 모두 삭제해주세요.
  			<p>
  				DOM(Document Object Model)이란?<br>
  				웹페이지 문서를 조작하기 위해서 지켜야될 약속(interface)만 딸랑 적혀있는 문서랍니다.
  				약속만 있을뿐 내부는 텅빈 상자랍니다.
  				우리가 알고있는 W3C DOM에는 구현소스가 한줄도 존재하지 않습니다.
  				그럼 실제 구현소스는??
  			</p>
  		</div>
  	</div>
  </body>
  </html>
  
  ```



- 생선 움직이기 예제

  ***나***

  ```html
  <!DOCTYPE html >
  <html>
  <head>
  	<meta  charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		
  		}
  		#panel{
  			width:600px;
  			height:300px;
  			border:1px solid #999;
  			position:relative;
  		}
  		
  		#bar{
  			position:absolute;
  			left:50px;
  			top:190px;
  			width:500px;
  			height:20px;
  			
  			background:#F30;
  		}
  		
  		#img1{
  			position:absolute;
  			left:50px;
  			top:120px;
              margin-left: 50px;	
  		}
  		
  		#nav{
  			text-align:center;
  			width:600px;
  		}
  	</style>
  	
  	<script>
  		 // 시작위치 구하기.
  		 // 마지막 위치.(시작위치 + bar의 넓이 - 이미지 넓이)
  		 // 이미지의 현재 위치를 시작위치로 설정.
  		 // 사용하게 될 이미지(물고기) 엘리먼트를 변수에 저장.
  		 // 시작버튼 이벤트 리스너 등록.
  		 // 정지버튼 이벤트 리스너 등록.
  		 // 타이머 실행.
  		 // 이미지 움직이기. -  2px만큼 이동합니다.
           //  위치값이 마지막 위치값을 넘어가는 순간, 
  		//  시작 위치<--- 마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  		// 위치값이 시작위치값을 넘어가는 순간,
  		// 시작위치 ---->마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  		// 최종적으로 조절된 위치값을 left에 적용시켜 준다.
  		// 타이머 정지시키기.
  	</script>
    
    <script>
    	window.onload = function() {
    		var eImg = document.getElementById("img1");
    		var imgWidth = eImg.clientWidth;
    		var barWidth =  document.getElementById("bar").clientWidth;
    		
    		var nMinMargin = 0;
    		var nMaxMargin = barWidth - imgWidth;
    		
    		var nDir = 1;
    		var nStep = 5;
    		var nTimerID = 0;
    		
    		//START button
    		document.getElementById("btn_start").onclick = function() {
    			
    			if(nTimerID == 0) {
    				nTimerID = setInterval(function(){
    					var margin = parseInt(eImg.style.marginLeft);
    					if(isNaN(margin)) {
    						eImg.style.marginLeft = '0px';
    						margin = 0;
    					}
    					
    					if(nDir == 1){
    						if(margin + nStep > nMaxMargin) 
    							nDir = -1;
    					}
    					else {
    						if(margin - nStep < nMinMargin)
  							nDir = 1;
    					}
    					
    					eImg.style.marginLeft = margin + nStep*nDir + 'px';
    					
    				}, 20);
    			}
    		}
    		
    		//STOP button
    		document.getElementById("btn_stop").onclick = function() {
    			if(nTimerID) {
    				clearInterval(nTimerID);
    				nTimerID = 0;
    			}
    		}
    		
    		
    	}
    </script>
  </head>
  
  <body>	
  	<div> 
  		<h4>#img1을 #bar의 영역에서 계속 좌우로 움직이도록 만들어주세요.</h4>
  		<div id="panel">
  			<div id="bar"> </div>
  			<div id="img1">
  				<img src="fish.png">
  			</div>
  		</div>
  		<div id="nav">
  			<button id="btn_start">시작</button>
  			<button id="btn_stop">멈춤</button>
  		</div>
  	</div>       
  </body>
  </html>
  
  ```

  ***선생님***

  ```html
  <!DOCTYPE html  >
  <html>
  <head>
  	<meta  charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;		
  		}
  		
  		#panel{
  			width:600px;
  			height:300px;
  			border:1px solid #999;
  			position:relative;
  		}
  		
  		#bar{
  			position:absolute;
  			left:50px;
  			top:190px;
  			width:500px;
  			height:20px;
              margin-left:1px;
  			background:#F30;
  		}
  		
  		#img1{
  			position:absolute;
  			left:50px;
  			top:120px;		
  		}
  		
  		#nav{
  			text-align:center;
  			width:600px;
  		}
  	</style>
  	
  	<script>
  		var nEndX;
  		var nCurrentX;
  		var nStartX;
  		var nTimerID;
  		var nStep;
  		var objIMG;
  	
  		window.onload=function(){
  			var objBar = document.getElementById("bar");
  			
  			// 시작위치 구하기.
  			this.nStartX = objBar.offsetLeft;
  	
  			// 마지막 위치.(시작위치 + bar의 넓이 - 이미지 넓이)
  			this.nEndX = objBar.clientWidth;
  			this.nEndX += this.nStartX;		
  			this.nEndX -= 128;
  	
  			// 이미지의 현재 위치를 시작위치로 설정.
  			this.nCurrentX = this.nStartX;
  			
  			this.nStep = 2;
  			this.nTimerID = 0;
  			
  			// 계속해서 사용하게 될 이미지 엘리먼트를 변수에 저장.
  			this.objIMG = document.getElementById("img1");
  		 
  			// 시작버튼 이벤트 리스너 등록.
  			document.getElementById("btn_start").addEventListener("click",function(){
  				start();
  			},false);
  			
  			// 정지버튼 이벤트 리스너 등록.
  			document.getElementById("btn_stop").addEventListener("click",function(){
  				stopMove();
  			},false);
  		}
  		 
  		
  		// 타이머 실행.
  		function start(){
  			if(this.nTimerID==0)
  				this.nTimerID = setInterval(this.startMove,30);
  			
  		}
  		
  		// 이미지 움직이기.
  		function startMove(){
  			// nStep만큼 이동합니다.
  			this.nCurrentX += this.nStep;
  			
  			//  위치값이 마지막 위치값을 넘어가는 순간, 
  			//  시작 위치<--- 마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  			if(this.nCurrentX>this.nEndX){
  				this.nCurrentX=this.nEndX;
  				this.nStep=-2;
  			}
  			// 위치값이 시작위치값을 넘어가는 순간,
  			// 시작위치 ---->마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  			if(this.nCurrentX<this.nStartX){
  				this.nCurrentX=this.nStartX;
  				this.nStep=2;
  			}
  			
  			// 최종적으로 조절된 위치값을 left에 적용시켜 준다.
  			this.objIMG.style.left=this.nCurrentX+"px";		
  		}
  		
  		// 타이머 정지시키기.
  		function stopMove(){
  			if(this.nTimerID!=0){
  				clearInterval(this.nTimerID);
  				this.nTimerID=0;
  			}
  		}
  	</script>
  </head>
  
  	<div> 
  		<h4>#img1을 #bar의 영역에서 계속 좌우로 움직이도록 만들어주세요.</h4>
  		<div id="panel">
  			<div id="bar"> </div>
  			<div id="img1">
  				<img src="fish.png">
  			</div>
  		</div>
  		<div id="nav">
  			<button id="btn_start">시작</button>
  			<button id="btn_stop">멈춤</button>
  		</div>
  	</div>       
  </body>
  </html>
  
  ```

  
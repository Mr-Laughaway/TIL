### 복습

- ***Location(location)***

  브라우저 객체 중 문서의 URL 관리를 위해 사용하는 객체

  - href
  - assign(url)
  - replace(url)
  - reload()



- ***Navigator***

  클라이언트의 브라우저 성보를 얻을 수 있는 객체 

  - gelocation
  - appName
  - onLine
  - platform



- ***Screen***

  화면의 크기와 색상 정보를 관리하는 객체

  - width, height
  - orientation
  - colorDepth



- ***History***

  웹 페이지의 이력을 관리하는 객체

  - length
  - forward(), back(), go(n|-n)



- 이벤트 처리

  - ```이벤트소스객체.on이벤트 = function(){}```

  - ```이벤트소스객체.addEventListener("이벤트", 이벤트 핸들러 함수, 캡처링 여부)```



- 등록된 이벤트 제거
  - ```이벤트소스객체.on이벤트 = null;```
  - 이벤트소스객체.removeEventListener("이벤트", 이벤트 핸들러 함수)



- 브라우저에서 처리해주는 기본 이벤트 취소:

  - <a href="">의 클릭 이벤트
  - form 태그의 submit 이벤트

  ```javascript
  이벤트소스객체.on이벤트 = function() {
  	return false;
  }
  
  이벤트소스객체.on이벤트 = function() {
  	event.preventDefault();
  }
  
  
  ```



- 이벤트 전파 방식

  - 버블링 (대부분의 브라우저에서 기본으로 지원) : 자식 -> 부모

    ```javascript
    //버블링 중단 시키기
    document.getElementById("p1").onclick= function(evt){	
    		
    		var event = evt || window.event;
    		console.dir(evt);
    		event.cancelBubble = true; //IE의 이벤트 전파를 취소
    		
    		if(event.stopPropagation) {
    			event.stopPropagation(); //W3C 표준 이벤트 전파 취소 함수
    		}
    		
    		this.style.backgroundColor='orange';
    	}
    ```

  - 캡처링



- 뷰포트(윈도우 좌표계)

  웹 브라우저에서 문서의 내용을 표시하는 영역

  - 뷰포트 너비 속성: clientWIdth, innerWidth(스크롤막대포함)
  - 뷰포트 높이 속성: clientHeight, innerHeight(스크롤 막대 포함)



- 문서의 요소 객체는 박스모델이 적용됨
  - left, top, right, bottom
  - width, height



- innerHTML, innerText, ***textContent(공백도 다 가져왕)***

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
    	onload = function() {
    		document.getElementById("d1").innerHTML = "<strong>강조체</strong> <i>이탤릭</i>";
    		document.getElementById("d2").textContent= "<strong>강조체</strong>     <i>이탤릭</i>";
    		document.getElementById("d3").innerText = "<strong>강조체</strong>      <i>이탤릭</i>";
    		
    		
    		console.log(document.getElementById("d4").innerHTML);
    		console.log(document.getElementById("d4").innerText);
    		console.log(document.getElementById("d4").textContent);
    	}
    </script>
  </head>
  <body>
  
    <div id="d1"></div>
    <div id="d2"></div>
    <div id="d3"></div>
    <div id="d4">
      <div id="d5">내용   내용</div>
    </div>
  </body>
  </html>
  ```

  

- file 로 이미지 파일 정보 가져오기

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <script>
  
  window.onload = function(){
  	var fileElement = document.getElementById("f1");
  	fileElement.addEventListener("change", function(){
  		var files = fileElement.files;
  		var output = "";
  		for(var i=0; i<files.length; i++) {
  			var file = files[i];
  			output += "파일이름 : " + file.name + ", 크기 : " + file.size +
  				"bytes, 타입 : " + file.type + "<br>";
  				
  		}
  		
  		document.getElementById("result").innerHTML = output;
  		
  	}, false);
   
  }
  
  </script>
  </head>
  <body>
    <input id="f1" type="file" multiple accept="image/*">
    <div id="result"></div>
   </body>
  </html>
  ```



- ***Drag and Drop***

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <script>
  var dropbox;
  window.addEventListener("load", function() {
  	dropbox = document.getElementById("dropbox");
  		// 이벤트 핸들러 할당	
  	dropbox.addEventListener("drop", drop, false);
  	dropbox.addEventListener("dragenter", dragEnter, false);
  	dropbox.addEventListener("dragover", dragOver, false);
  }, false);
  
  function dragEnter(event) {
  	event.stopPropagation();
  	event.preventDefault();
  }
  
  function dragOver(event) {
  	event.stopPropagation();
  	event.preventDefault();
  }
  
  function drop(event) {
  	event.stopPropagation();
  	event.preventDefault();
  
  	var files = event.dataTransfer.files;
  	var count = files.length;
  
  	// 오직 한개 이상의 파일이 드랍된 경우에만 처리기를 호출한다.
  	if (count > 0) {
  		var file = files[0];
  		document.getElementById("droplabel").innerHTML 
  		           = "Processing "+ file.name;
  		var reader = new FileReader();
  		// 파일 리더의 이베트 핸들러 정의
  		reader.onloadend = function(event) {
  			var img = document.getElementById("preview");
  			img.src = event.target.result;//event.target는 FileReader객체
  		};
  		reader.readAsDataURL(file);
  	}
  }
  	
  </script>	
  </head>
  <body>
  <h1>Drag and Drop Demo</h1>
  	<div id="dropbox"
  		style="width: 360px; height: 80px; border: 1px solid #aaa;">
  		<span id="droplabel"> 이곳에 파일을 드랍해 주세요... </span>
  	</div>
  	<img id="preview" alt="[ preview will display here ]" />
  </body>
  </html>
  ```

  

- FileReader로 file 내용 읽기

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script>
  //1. new FileReader()
  //2. onload, onloadend이벤트에 대한 핸들러 : result속성에 저장낸 내용을 textarea에..
  //3. readAsText()사용  내용 읽기
  function readFile(){
  	var file = document.getElementById("file").files[0];
  	document.getElementById("fileName").innerHTML = file.name;
  	document.getElementById("fileSize").innerHTML = file.size+"Bytes";
  	
  	var reader = new FileReader();
  	reader.onloadend = function() {
  		document.getElementById("content").innerHTML = reader.result;
  	}
  	
  	var encodingList = document.getElementById("encoding");
  	var encoding =
  	//	encodingList.options[encodingList.selectedIndex].value;
  		encodingList.children[encodingList.selectedIndex].innerHTML;
  	console.log(file);
  	reader.readAsText(file, encoding);
  	
  }
  </script>
  </head>
  <body>
   <h1> FileReader Interface : readAsText()</h1>
         <input id="file" type="file">
         <select id="encoding">
             <option>UTF-8</option>
  		   <option>euc-kr</option>
          </select>
          <button onclick="readFile()">읽기</button><br />
          <div>
              <span id="fileName">File Name</span>
              <span id="fileSize">File Size</span>
          </div>
          <textarea id="content" readonly style="width:600px; height:400px;"></textarea>
  </body>
  </html>
  ```



- Drag & Drop 으로 element 옮기기 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  
  <meta charset="utf-8">
  <title>Insert title here</title>
  <style>
  div#Red {border:2Px solid #F00;}
  div#Blue {border:2Px solid #00F;}
  div {width:400px;height:266px;}
  a {margin:50px;display:block;}
  </style>
  <script>
  	function drag(source, event) {
  		//event.preventDefault();
  		console.log('drag');
  		event.stopPropagation();
  		event.dataTransfer.setData("text", source.id);
  	};
  	
  	function drop(source, event) {
  		//event.preventDefault();
  		console.log('drop');
  		event.stopPropagation();
  		var imgId = event.dataTransfer.getData("text");
  		source.appendChild(document.getElementById(imgId));
  	};
  </script>
  </head>
  <body>
  <div id="Red" ondrop="drop(this, event);" 
       ondragenter="return false;" 
       ondragover="return false;"></div>
  <div id="Blue" ondrop="drop(this, event);" 
  	ondragenter="return false;" 
  	ondragover="return false;"></div>
  <img draggable="true" id="textlink" 
       ondragstart="drag(this, event);" 
       src="../images/red_dragon1.jpeg"></img>
  </body>
  </html>
  ```

  

- Canvas 예제 및 내용 복사

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <script>
  	window.addEventListener("load", function(){
  		var img = document.getElementById("scream");
  		var canvas1 = document.getElementById("drawCanvas");
  		var ctx = canvas1.getContext("2d");
  		ctx.drawImage(img, 10, 10);
  		
  	}, false);
  	
  	function fromImageData() {
  		var canvas1 = document.getElementById("drawCanvas");
  		var imgData = canvas1.toDataURL();
  		var canvas2 = document.getElementById("copyCanvas");
  		var ctx = canvas2.getContext("2d");
  		var img = new Image();
  		img.src = imgData;
  		
  		img.onload = function() {
  			ctx.drawImage(img, 50, 50);
  		};
  		
  	}
  	
  	window.addEventListener("load", function(){
  		var canvas = document.getElementById("drawCanvas2");
  		var ctx = canvas.getContext("2d");
  		var width = canvas.clientWidth;
  		var height = canvas.clientHeight;
  		
  		ctx.beginPath();
  		
  		ctx.moveTo(width*0.5, height*0.1);
  		ctx.lineTo(width*0.1, height*0.7);
  		ctx.lineTo(width*0.9, height*0.7);
  		ctx.lineTo(width*0.5, height*0.1);
  		
  		ctx.moveTo(width*0.5, height*0.9);
  		ctx.lineTo(width*0.1, height*0.3);
  		ctx.lineTo(width*0.9, height*0.3);
  		ctx.lineTo(width*0.5, height*0.9);
  		
  		ctx.stroke();
  		ctx.closePath();
  		
  		
  	}, false);
  
  </script>
  </head>
  <body>
  <h3>canvas API : Image Copy</h3>
  <img id="scream" src="../images/red_dragon1.jpeg" 
  width="220" height="277" style="display:none;">
  <canvas id="drawCanvas" width="200" height="200" style="position: relative; border: 1px solid #000;"></canvas>
  <button onclick="fromImageData();">캔버스 복사=></button>                  
  <canvas id="copyCanvas" width="300" height="300" style="position: relative; border: 1px solid #000;"></canvas>
  <hr>
  <canvas id="drawCanvas2" width="300" height="300" style="position: relative; border: 1px solid #000;"></canvas>
  </body>
  </html>
  ```



- ***Exception***

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
      function permutation(a) {
        if(!(a instanceof Array)) {
          throw new Error(a + " is not an array");
        }
  
     	  return a;
      }
    </script>
  </head>
  <body>
    <script>
    	//permutation("ABC");
    	//x++;
    	//if( a>0 ) { a++;
    	
    	try {
    		var p = permutation(/*"abc"*/ [1,2,3,4,5]);
    		p.forEach(function(v){
    			console.log(v);
    		});
    	}
    	catch(e) {
    		alert(e);
    	}
    </script>
    
  
  </body>
  </html>
  ```



- innerHTML, innerText, textContent

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
    	onload = function() {
    		document.getElementById("d1").innerHTML = "<strong>강조체</strong> <i>이탤릭</i>";
    		document.getElementById("d2").textContent= "<strong>강조체</strong>     <i>이탤릭</i>";
    		document.getElementById("d3").innerText = "<strong>강조체</strong>      <i>이탤릭</i>";
    		
    		console.log(document.getElementById("d4").innerHTML);
    		console.log(document.getElementById("d4").innerText);
    		console.log(document.getElementById("d4").textContent);
    	}
    </script>
  </head>
  <body>
  
    <div id="d1"></div>
    <div id="d2"></div>
    <div id="d3"></div>
    <div id="d4">
      <div id="d5">내용   내용</div>
    </div>
  </body>
  </html>
  ```

  

### Exception은 책 좀 더 볼 것



- jQuery 기본 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
  	/*
  	jQuery(document).ready(function(){
  		alert("ready event handler1")
  	});
  	
  	$(document).ready(function(){
  		alert("ready event handler2")
  	});
  	
  	$(function(){alert("즉시 실행될 함수")});
  	*/
  	
  	$(document).ready(function(){
  		//$('h3').css('color', 'blue').css('background', 'orange');
  		//$('*').css('color', 'blue').css('background', 'orange');
  		//$('div, p').css('color', 'blue').css('background', 'orange');
  		//$('#simple').css('color', 'blue').css('background', 'orange');
  		//$('.todo').css('color', 'blue').css('background', 'orange');
  		//$('.todo.select').css('color', 'blue').css('background', 'orange');
  		//$('body > p').css('color', 'blue').css('background', 'orange');
  		$('input[type=text]').val('Hello, jQuery..!');
  		$('input:password').css('background', 'cyan');
  		$('input:focus').css('background', 'lightgray');
  	});
  	
  	
  	
  </script>
  </head>
  <body>
  
    <h3> jQuery </h3>
    <h3 id="simple"> jQuery 는 javascript 보다 코드가 간결해서 코드량을 약 1/3로 줄여줍니다. </h3>
    <h3> jQuery 효과를 조합하면 멋진 효과를 만들 수 있습니다.</h3>
    <div class="todo"> <p>1. Lorem </p> </div>
    <p>2. Ipsum</p>
    <article class="todo select">3. Consta</article>
    <ul>
      <li>4. Melis</li>
      <li>5. Astra</li>
    </ul>
    
    text : <input type="text" /><br>
    password : <input type="password" /><br>
    e-mail : <input type="email" autofocus/><br>
    radio : <input type="radio" checked /><br>
    checkbox : <input type="checkbox" /><br>
    file : <input type="file" /><br>
    
    
  </body>
  </html>
  ```

  

- jQuery - eq(), nth-child()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery2</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
  	$(document).ready(function(){
  		//5초 후에 코드를 실행합니다.
  		/*
  		setTimeout(function(){
  			//변수를 선언합니다.
  			var value = $('select > option:selected').val();
  			
  			//출력합니다.
  			alert(value);
  		}, 5000);
  		*/
  		/*
  		$('tr:odd').css('background', 'orange');
  		$('tr:even').css('background', 'yellow');
  		$('tr:first').css('background', 'black').css('color', 'white');
  		
  		$('td:first').css('width', '100px').next().css('width', '70px');
  		*/
  		
  		$('tr:eq(0)').css('background', 'black').css('color', 'white');
  		$('td:nth-child(3n+1)').css('background', 'yellow');
  		$('td:nth-child(3n+2)').css('background', 'green');
  		$('td:nth-child(3n)').css('background', 'orange');
  	});
  </script>
  </head>
  <body>
  
    <select>
      <option>Apple</option>
      <option>Bag</option>
      <option>Cat</option>
      <option>Dog</option>
      <option>Elephant</option>
    </select>
    
    <hr>
    
    <table>
          <tr><th>이름</th><th>혈액형</th><th>지역</th><th>이름</th><th>혈액형</th><th>지역</th></tr>
          <tr><td>강민수</td><td>AB형</td><td>서울특별시 송파구</td><td>강민수</td><td>AB형</td><td>서울특별시 송파구</td></tr>
          <tr><td>구지연</td><td>B형</td><td>미국 캘리포니아</td>
  		<td>구지연</td><td>B형</td><td>미국 캘리포니아</td></tr>
          <tr><td>김미화</td><td>AB형</td><td>미국 메사추세츠</td>
  		<td>김미화</td><td>AB형</td><td>미국 메사추세츠</td></tr>
          <tr><td>김선화</td><td>O형</td><td>서울 강서구</td>
  		<td>김선화</td><td>O형</td><td>서울 강서구</td></tr>
          <tr><td>남기주</td><td>A형</td><td>서울 노량진구</td><td>남기주</td><td>A형</td><td>서울 노량진구</td></tr>
          <tr><td>윤하린</td><td>B형</td><td>서울 용산구</td>
  		<td>윤하린</td><td>B형</td><td>서울 용산구</td></tr>
      </table>
    
    
  </body>
  </html>
  ```
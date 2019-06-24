### 복습

- jQuery?

  - 모든 브라우저에서 동작하는(클라이언트 side에서 실행)  자바스크립트 library

  - html의 문서요소를 간결하게 처리할 수 있다.

  - local file 혹은 CDN 사용

  - 사용 예시

    ```javascript
    jQuery(문서요소 | 함수)
    $(문서 요소 | 함수)
    ```

- 일관된 이벤트 핸들러 등록/삭제

  ```javascript
  on이벤트명 = function(){}
  addEventListener("이벤트명", function(){}, false)
  removeEventListener("이벤트명", 핸들러);
  
  attachEvent()
  detachEvent()
  ```

- 효과/ajax 처리 간결하면서 쉽게

- load 이벤ㅌㅌ와 유사한 jquery의 이벤트는 ready 이벤트

  ```javascript
  $(document).ready(이벤트 핸들러 함수);
  ```

- jQuery 사용 예

  ```javascript
  $("태그명")
  $("#id")
  $("태그.클래스속성값") //특정 태그 내에서 특정 클래스를 갖고 있는 엘레먼트 선택
  $("부모태그 > 자식태그") //부모태그 바로 아래의 태그들만 선택
  $("부모태그 자손태그") // 모든 자손태그 선택
  $("태그, 태그, 태그") // 각각 선택
  $("태그[속성명=속성값]")
  ```



---

- .each()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
    .highlight_0 {  background: yellow; }
    .highlight_1 {  background: orange; }
    .highlight_2 {  background: blue; }
    .highlight_3 {  background: green; }
    .highlight_4 {  background: red; }
  </style>
  </head>
    <script>
    
      $(document).ready(function(){
      	$('h3').each(function(index, item){
      		//$(this).addClass('high_light_' + index);
      		$(item).addClass('highlight_' + index);
      	});
      });
    	
    </script>
  <body>
    <h3>Item - 9</h3>
    <h3>Item - 9</h3>
    <h3>Item - 9</h3>
    <h3>Item - 9</h3>
    <h3>Item - 9</h3>
  </body>
  </html>
  ```



- noConflict()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
    .highlight_0 {  background: yellow; }
    .highlight_1 {  background: orange; }
    .highlight_2 {  background: blue; }
    .highlight_3 {  background: green; }
    .highlight_4 {  background: red; }
  </style>
  </head>
    <script>
    
    	$.noConflict();
  	var J = jQuery;
      J(document).ready(function(){
      	/*
      	$('h3').each(function(index, item){
      		//$(this).addClass('high_light_' + index);
      		$(item).addClass('highlight_' + index);
      	});
      	*/
      	
      	J("h3").each(function(index, item){
      		J(item).removeClass("highlight_" + index);
      	});
      });
    	
    </script>
  <body>
    <h3 class="highlight_0">Item - 0</h3>
    <h3 class="highlight_1">Item - 1</h3>
    <h3 class="highlight_2">Item - 2</h3>
    <h3 class="highlight_3">Item - 3</h3>
    <h3 class="highlight_4">Item - 4</h3>
  </body>
  </html>
  ```



- jquery Event 처리

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
  
  </style>
  </head>
    <script>
    
      $(document).ready(function(){
      	/*
      	$('#wrap').on('click', function(){
      		var len = $('h1').length;
      		var targetHTML = $(this).text();
      		$("#wrap").append("<h1>"+len+"-"+targetHTML+"</h1");
    		});
      	*/
      	$('#wrap').on('click', 'h1', function(){
      		var len = $('h1').length;
      		var targetHTML = $(this).text();
      		$("#wrap").append("<h1>"+len+"-"+targetHTML+"</h1");
    		});
      	
      	/*
      	$('#wrap').on('click', 'h1', function(){
        		 var len = $('h1').length;
        		 var targetHTML = $(this).text();
        		 $("#wrap").append("<h1>"+len+"-"+targetHTML+"</h1>");
        	 });
      	*/
      });
    	
    </script>
  <body>
    <div id="wrap">
        <h1>Header</h1>
    </div>
  </body>
  </html>
  ```



- jQuery - first(), last()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
  
  </style>
  </head>
    <script>
    
      $(document).ready(function(){
      	/*
      	$('h3').css('background', 'Orange').filter(
      			':even').css('color', 'Green').end().filter(
      			':odd').css('color', 'Blue');
      	*/
      	
      	
      	// $('h3').eq(0).css('color', 'green');
     		//$('h3').eq(-1).css('color', 'blue');
    	  	$('h3').first().css('color', 'cyan');
    	  	$('h3').last().css('color', 'magenta');
      	
      });
    	
    </script>
  <body>
    <h3>Item - 0</h3>
    <h3>Item - 1</h3>
    <h3>Item - 2</h3>
    <h3>Item - 3</h3>
    <h3>Item - 4</h3>
    <h3>Item - 5</h3>
    
  
    
  </body>
  </html>
  ```



- parseXML()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <style>
   div{  margin:10px;
         border:3px Solid Black;
         border-radius:10px;
         float:left;
         width:120px; height:120px;
         text-align:center;
          }
      </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
          // 변수를 선언합니다.
          var xml = '';
          xml += '<friends>';
          xml += '    <friend>';
          xml += '        <name>연하진</name>';
          xml += '        <language>Ruby</language>';
          xml += '    </friend>';
          xml += '    <friend>';
          xml += '        <name>윤명월</name>';
          xml += '        <language>Basic</language>';
          xml += '    </friend>';
          xml += '    <friend>';
          xml += '        <name>윤하린</name>';
          xml += '        <language>C#</language>';
          xml += '    </friend>';
          xml += '</friends>';
  
          $(document).ready(function () {
             var xmlDoc = $.parseXML(xml);
             $(xmlDoc).find('friend').each(function(index, item){
          	   var output = '';
          	   output += '<div>';
          	   output += '	<h1>' + $(this).find('name').text() + '</h1>';
          	   output += '	<p>' + $(this).find('language').text() + '</h1>';
          	   output += '</div>';
          	   
          	   document.body.innerHTML += output;
             });
          });
      </script>
  </head>
  <body>
  
  </body>
  </html>
  ```



- 



- Effect - show, hide. toggle, slideUp, slideDown, slideToggle

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
  </style>
  <script>
  	
  	$(document).ready(function(){
  		$("#show").click(function(){ $('img').show(); });
  		$("#hide").click(function(){ $('img').hide(); });
  		$("#toggle").click(function(){ $('img').toggle(3000, "linear", function(){
  				alert("End!");
  			}); 
  		});
  		$("#slideD").click(function(){ $('img').slideDown(); });
  		$("#slideU").click(function(){ $('img').slideUp(); });
  		$("#slideToggle").click(function(){ $('img').slideToggle(3000, "swing", function(){
  				alert("End!");
  			}); 
  		});
  	});
  </script>
  </head>
  <body>
    <button id="show">show</button>
    <button id="hide">hide</button>
    <button id="toggle">toggle</button>
    <button id="slideD">slideDown</button>
    <button id="slideU">slideUp</button>
    <button id="slideToggle">slideToggle</button>
    <button id="fadein">fadeIn</button>
    <button id="fadeout">fadeOut</button>
    <button id="fadetoggle">fadeToggle</button>
    <br>
    <img src="../images/cat.jpg"/>
    
  </body>
  </html>
  ```

  

- Effect - 
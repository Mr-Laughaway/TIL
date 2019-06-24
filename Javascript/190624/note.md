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



- attr()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <style>
          }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
          $(document).ready(function () {
        	 
          	
          	$('img').attr('width', function(index){
          		return (index+1)*100 
            	});
          	
          	/*
          	$('img').attr({width: function(index){
          		return (index+1) * 100;
          	}, height: 100 	});
          	*/
          	
          	
          	var colors = ['red', 'white', 'purple'];
        		
        		$('h1').css({
        			color: function(index){
        				return colors[index];
        			},
        			background: 'black'
        		});
          });
      </script>
  </head>
  <body>
    <img src="../images/Koala.jpg">
    <img src="../images/Penguins.jpg">
    <img src="../images/Hydrangeas.jpg">
    
    <h1>으아아아 1</h1>
    <h1>으아아아 2</h1>
    <h1>으아아아 3</h1>
  
  </body>
  </html>
  ```



- remove(), empty()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>jQuery 실습</title>
  <style>
          }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
      $(document).ready(function () {
    		/*
      	var headers = $('h1').html();
    		alert(headers);
    		
    		
  		var texts = $('h1').text();
  		alert(texts);
  		*/
  		
  		/*
  		$('div').html(function(index){
  			return ("<h3>header-" + index + "</h3>");
  		});
  		*/
  		
  		
  		$('div').text(function(index){
  			return ("<h3>header-" + index + "</h3>");
  		});
  		
  		$('h3').last().remove();
  		$('#emt').empty();
  		
    		
  		$('<p></p>').html("This is <mark>web app</mark>").appendTo('body');
      });
  </script>
  </head>
  <body>
    <h1> Header-0 </h1>
    <h1> Header-1 </h1>
    <h1> Header-2 </h1>
    <div></div>
    <div></div>
    <div></div>
    <hr>
    <h3>제목1</h3>
    <h3>제목2</h3>
    <article id = 'emt'>
      <p> 아아아1 </p>
      <p> 아아아2 </p>
      <p> 아아아3 </p>
    </article>
  </body>
  </html>
  ```



- append, prepend, insertAfter, insertBefore

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <style>
  div { 
    border: 1px solid black;
    width : 300px;
    height : 300px;
  }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script> 
  	$(document).ready(function () {
        $('<p></p>').html('<mark>appendTo</mark>').appendTo('div');
        $('<p></p>').html('<mark>prependTo</mark>').prependTo('div');
        $('<p></p>').html('<mark>insertAfter</mark>').insertAfter('div');
        $('<p></p>').html('<mark>insertBefore</mark>').insertBefore('div');
        
        
        $('div').append(function(){
        	return $('<p></p>').html('<mark>append</mark>');
        });
        $('div').prepend(function(){
        	return $('<p></p>').html('<mark>prepend</mark>');
        });
        $('div').before(function(){
        	return $('<p></p>').html('<mark>before</mark>');
        });
        $('div').after(function(){
        	return $('<p></p>').html('<mark>after</mark>');
        });
      });
  </script>
  </head>
  <body>
   <h3>문서 객체를 추가</h3>
   A.appendTo(B) : B의 마지막 자식 요소로 A요소를 추가 <br>
   A.prependTo(B) : B의 첫번째 자식 요소로 A요소를 추가 <br>
   A.insertAfter(B) : B의 형제노드로서 A요소를 B의 다음에 추가<br>
   A.insertBefore(B) : B의 형제노드로서 A요소를 B의 앞에 추가<br>
   A.append(B) : A의 마지막 자식 요소로 B요소를 추가 <br>
   A.prepend(B) : A의 첫번째 자식 요소로 B요소를 추가 <br>
   A.after(B) : A의 형제노드로서 B요소를 A의 다음에 추가<br>
   A.before(B) : A의 형제노드로서 B요소를 A의 앞에 추가<br> 
   <div>내용</div>
     
      
  </body>
  </html>
  ```



- appendTo를 활용한 slide 효과 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <style>
  img {
    width:  300px;
    height: 200px;
  }
  
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script> 
  	$(document).ready(function () {
  		setInterval(function(){
  			$('img').first().appendTo('body');
  		}, 1000);
       
      });
  </script>
  </head>
  <body>
  
  <h3>슬라이드</h3>
  <img src="../images/Koala.jpg">
  <img src="../images/Penguins.jpg">
  <img src="../images/Hydrangeas.jpg">
     
      
  </body>
  </html>
  ```



- wrap(), warpAll()

  ```html
  <!doctype html>
  <html lang="ko">
  <head>
  <meta charset="UTF-8">  
  <title>jQuery 문서 조작</title>
  <style>  
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>  
    $(document).ready(function(){		 
    	$('#btn1').on('click', function(){
    		$('p:first').replaceWith('Hello world!');
  	});
    	
    	$('#btn2').click(function(){
    		$('<h2>Hellow world!</h2>').replaceAll('p');
  	});
    	
    	$('#btn3').click(function(){
    		$('p').wrap('<div></div>');
  	});
    	
    	$('#btn4').click(function(){
    		$('p').warpAll('<div></div>');
  	});
    	
    });
  </script>
  </head>
   <body>
   
    <p>단락1</p>
    <p>단락2</p>
    <p>단락3</p> 
    <button id="btn1">단락1에 새로운 내용 넣기</button>
    <button id="btn2">모든 단락에 새로운 내용 넣기</button>
    <button id="btn3"> 단락을 div로 감싸기</button>
    <button id="btn4"> 모든 단락을 div로 감싸기</button>
    
  </body>
  </html>
  
  ```



- ***clone 책봐라!!!***



- Event - 1

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="EUC-KR">
  <title>Insert title here</title>
  <style>
  .reverse {
     background:black;
     color:white;
  }
  </style>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
  $(document).ready(function(){
  	/*
  	$("h1").on("click", function(){
  		$(this).html(function(index, html){
  			return html + "+";
  		});
  		
  		$(this).off("click");
  	});
  	*/
  	/*
  	$("h1").one("click", function(){
  		$(this).html(function(index, html){
  			return html + "+";
  		});
  	});
  	*/
  	
  	/*
  	$("h1").one("click", function(){
  		$(this).html(
  				$(this)html() + "+"
  		);
  	});
  	*/
  	
  	/*
  	$('h1').on({
  		mouseenter: function(){ $(this).addClass("reverse");},
  		mouseleave: function(){ $(this).removeClass("reverse");}
  	});
  	*/
  })
  </script>
  </head>
  <body>
  <h1>Click</h1>
  </body>
  </html>
  ```



- Event - 2

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <style>
  .reverse {
     background:black;
     color:white;
  }
  </style>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
  $(document).ready(function(){
  	$('h1').click(function(){
  		$(this).html(function(index, html){
  			return html + "★";
  		});
  	});
  	
  	setInterval(function(){
  		//$('h1').last().click();
  		$('h1').last().trigger('click');
  	}, 1000);
  });
  </script>
  </head>
  <body>
    <h1>Start:</h1>
    <h1>Start:</h1>
  </body>
  </html>
  ```



- preventDefault()

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
  		
  		$('a').click(function(event){
  			event.preventDefault();
  		});
  		
  		$('#f1').click(function(event){
  			event.preventDefault();
  		});
  		
  		/*
  		$('a').click(function(event){
  			return false;
  		});
  		
  		$('#f1').click(function(event){
  			return false;
  		});
  		*/
  	});
  </script>
  </head>
  <body>
  
  <a href="http://www.multicampus.co.kr">www.multicampus.co.kr</a><br>
  <form  id = "f1" method="get" action="data.jsp">
  email : <input type=email name="email" id="email"><br>
  <input type="submit">
  </form>
  </body>
  </html>
  ```

  





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
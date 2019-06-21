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



- innerHTML, innerText, textContent(공백도 다 가져왕)

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

  


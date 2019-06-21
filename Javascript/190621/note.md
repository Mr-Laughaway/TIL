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

    
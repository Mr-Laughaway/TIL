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

  
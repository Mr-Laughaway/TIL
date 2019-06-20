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
    ```

  - 
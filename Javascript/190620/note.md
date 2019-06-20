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
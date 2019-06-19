### 복습

- 자바스크립트?
  - 인터프리터 언어
  - 동적 프로토타입 기반 객체지향 언어
  - 동적 타입 언어
  - 함수 기반 언어 (함수가 일급 객체)
    - 함수를 변수에 저장
    - 함수의 인수로 함수를 전달
    - 함수 내부에 함수 정의 가능
    - 함수에서 함수 정의를 반환 가능
  - 함수가 클로저를 정의한다.



- 자바스크립트의 구성 기술

  - ECMAScript core (코어 언어)

  - 웹 브라우저의 API

    - window interface

    - DOM (document ?)

    - XMLHttpRequest

    - HTML5 API (geolocation, WebWorks, Canvas, Video.. 등등)

      근데 이건 태그지... javascript가 아니지 않나?  ```<br>``` 이 javascript가 아닌 것 처럼...



- 자바스크립트 분류
  - 클라이언트 측 기술 (jQuery, Vue.js, React.js, ... 등)
  - 서버 측 기술 (node.js, ... 등)



- 자바스크립트 코드 작성 문법
  - 인코딩은 utf-8 권장
  - 대소문자 구분
  - 확장자는 ```.js```
  - 한 문장 단위로 ```;``` 구분 (필수는 아님)
  - 주석은 ```//``` , ```/* */``` 



- 변수
  - ```var 변수명;```
  - ```_```, ```$```, ```영문자```로 시작.
  - 두 번째 문자부터 숫자 허용
  - 길이제한 없음
  - 키워드 X, 내장 함수명 X(되긴 됨), 내장 객체명 X(되긴 됨)



- 데이터 유형
  - Primitive type
    - number
    - string
    - null
    - undefined
    - boolean
    - symbol
  - Reference type
    - function
    - object
    - interface
    - array (object 유형)





> 좀 이상하지만...
>
> - 선언되지 않은 변수르 참조하면? ReferenceError
> - 선언만 된 변수, 초기값이 할당되지 않은 변수를 참조하면 ? undefined
> - 객체를 메모리에서 검색을 했는데, 검색되지 않으면 반환되는 값은? null



- 자바스크립트 출력 방법

  - document.write(), document.writeln()

  - console.log(), console.dir()

  - window.alert("메세지")

    

- 자바스크립트 입력 방법

  - window.prompt("메시지", 기본값) - 반환 타입은 문자열
  - window.confirm("메시지") - 반환 타입은 boolean



- 자바 스크립트 연산자
  - 산술 연산자:  ```*, /, %, +, -```
  - 단항 연산자: ```~, !, +, -, ++, --````
  - 비교 연산자: ```>, >=, <, <=, ==, ~=, ===, !==```
  - 비트연산자: ```&, |, ^```
  - 논리연산자: ```&&, ||```
  - shift 연산자:  ```<<, >>, >>>```
  - 삼항 연산자: ```조건 ? 항1: 항2;```
  - 기타  연산자: ```type of, in, instanceof, ...```



- 제어문
  - if
  - switch
  - for
  - [do] while



- ***템플릿 리터럴과 placeholder***

  ``` `포맷형식 ${변수} 문자열` ```



- 자바스크립트의 형변환
  - 문자열로 형 변환: String
  - 정수나 실수로 형 변환
    - Number()
    - window.parseInt() 등등
  - 논리형으로 변환
    - !!값
    - Boolean()



---



### 함수 


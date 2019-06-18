# Javascript

#### 자바스크립트 특징

- 인터프리터 언어

  그러나 JIT(Just In Time Compiler) 등의 기법이 적용되어 빨라짐

- 동적 프로토타입 기반 객체 지향 언어

  동적으로 메서드나 멤버 추가/삭제 가능

- 동적 타입 언어

  타입이 실행 때 결정되고 바뀔 수도 있다.

- 함수가 일급 객체가

  함수를 객체 취급하며, 함수에 함수를 인수로 넘길 수 있다.

- 함수가 클로저(closer)를 정의한다.

  클로저로 변수를 은익하거나 영속성을 보장하는 등 다양한 기능을 구현할 수 있다.



#### 자바스크립트의 기술적 요소

- ECMAScript (코어 언어)

- 클라이언트 측의 고유한 기술 요소

  코어와 웹 브라우저의 API로 구성되어 있다.

  - Window 인터페이스
  - DOM
  - XMLHttpRequest (ajax의 핵심 객체)

- 서버 측 자바스크립트의 고유한 기술 요소

  - Node.js
  - Rhino (Mozilla가 관리)
  - Aptana Jaxer



#### HTML 문서에 자바스크립트 포함 위치

##### html에 포함하는 방법

```html
<head>
    <script>
        //자바스크립트 코드
        //대체로 선언과 관련된 부분이 많다
        //ex) 전역변수 선언, 함수 선언
        //body요소 를 참조하거나 사용하는 실행문장은
        //오류가 발생한다.
    </script>
</head>

<body>
    <script>
        //자바스크립트 코드
        //대체로 즉시 실행 문장 코드가 온다.
    </script>
</body>


```



##### html로부터 분리시키는 방법

```html
<head>
    <script type="text/javascript" src="경로/파일.js"></script>
</head>
<body>
</body>
```



##### factorial test

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트 테스트01</title>
<script>
	window.alert("head 태그내에 포함된 javascript 실행");
</script>
</head>
<body>
  <script>
  	function fact(n) {
		if( n<=1 ) return n;
		return n*fact(n-1);
	}
	for(var i=1; i < 10; i++) {
	    console.log(i+"! = " + fact(i));
	}
  </script>
</body>
</html>
```




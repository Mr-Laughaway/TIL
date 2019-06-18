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



##### 변수 선언 기본

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수 선언</title>
</head>
<body>
  #자바스크립트에서 변수 선언은 var 변수명;<br>
  var 변수명 = 초기값;<br>
  자바 스크립트에서 문자열은 "" 또는 ''로 감싸줘야 합니다.<br>
  변수를 선언하고 초기화하지 않은면 아직 a 변수와 sum 변수의 타입이 결정되지 않았으므로 'undefined'라고 뜬다 <br>
  <script>
  	var sum, a;
  	console.log("a=" + a);
  	document.write("sum=" + sum + "<br>");
  	//document.write("x=" + x + "<br>");
  	
  	console.dir(window);
  	korea = 3; //실행시에 전역객체(window객체)의 속성으로 추가됩니다.
  	document.write("korea=" + korea + "<br>");
  	
  	var a = 5;
  	document.write("a=" + a + "<br>");
  </script>
</body>
</html>
```



##### 변수 타입들

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 타입</title>
</head>
<body>
  #자바스크립트의 데이터 유형<br>
  primitive type - string, number, boolean, undefined, null 등 <br>
  reference type - function, object <br>
  <script>
  	var a = 1;
  	document.write("a변수의 타입 : " + typeof(a) + "<br>");
  	
  	var b = 0.5;
  	document.write("b변수의 타입 : " + typeof(b) + "<br>");
  	
  	a = "javascript"; //동적 타입 언어
  	b = 'ECMAScript6';
  	document.write("a변수의 타입 : " + typeof(a) + "<br>");
  	document.write("b변수의 타입 : " + typeof(b) + "<br>");
  	
  	a = function(){};
  	document.write("a변수의 타입 : " + typeof(a) + "<br>");
  	b=[]; //배열은 객체 취급
  	document.write("b변수의 타입 : " + typeof(b) + "<br>");
  	
  	a = {}; //<JSON (Javascript Object Notation) 정의 가능
  	document.write("a변수의 타입 : " + typeof(a) + "<br>");
  	b = new  Object();
  	document.write("b변수의 타입 : " + typeof(b) + "<br>");
  	
  	a = true;
  	document.write("a변수의 타입 : " + typeof(a) + "<br>");
  	b = true;
  	document.write("b변수의 타입 : " + typeof(b) + "<br>");
  	
  	a = 0x2a;
  	document.write("a변수의 10진수 값 : " + a + "<br>");
  	a = 0o73;
  	document.write("a변수의 10진수 값 : " + a + "<br>");
  	a = 0b101;
  	document.write("a변수의 10진수 값 : " + a + "<br>");
  	a = 1.16142E-11;
  	document.write("a변수의 10진수 값 : " + a + "<br>");
  	
  	a='"javascript"';
  	document.write("a변수의 값 : " + a + "<br>");
  	
  	//document.write("c[0]변수의 값 : " + c[0] + "<br>");
  	
  	a = function(){};
  	document.write("a 함수의 리턴 값 : " + a() + "<br>");
  	
  	a = function(d) {
  		alert("d = " + d);
  	};
  	a();

  </script>

</body>
</html>
```



##### Math.random 으로 주사위 굴리기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주사위</title>
</head>
<body>
  <script>
  	document.write(Math.round(Math.random()*5+1) + "<br>"); 
  </script>

</body>
</html>
```



##### String. 함수들

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>String과 ===</title>
</head>
<body>
  <script>
	document.write("1 + {} : " + (1+{}) + "<br>");
	
    var msgObj = new String("Everything is practice.");
    document.write("msgObj.length : " + msgObj.length + "<br>");
    document.write("msgObj.charAt(3) : " + msgObj.charAt(3) + "<br>");
    document.write("msgObj[3] : " + msgObj[3] + "<br>");
    document.write("msgObj.substring(7,10) : " + msgObj.substring(7,10) + "<br>");
    document.write("msgObj.slice(7,10) : " + msgObj.slice(7,10) + "<br>");
    document.write("msgObj.slice(-3) : " + msgObj.slice(-3) + "<br>");
    document.write("msgObj.slice(-9, -6) : " + msgObj.slice(-9, -6) + "<br>");
    document.write("msgObj.indexOf('t')) : " + msgObj.indexOf('t') + "<br>");
    document.write("msgObj.indexOf('i')) : " + msgObj.indexOf('i') + "<br>");
    document.write("msgObj.split(' ')) : " + msgObj.split(' ') + "<br>");
    document.write("msgObj.replace('p', 'P')) : " + msgObj.replace('p', 'P') + "<br>");
    document.write("msgObj.includes('thing')) : " + msgObj.includes('thing') + "<br>");
    document.write("msgObj.charCodeAt(0) : " + msgObj.charCodeAt(0) + "<br>");
    document.write("msgObj.codePointAt(0) : " + msgObj.codePointAt(0) + "<br>");
  </script>
</body>
</html>
```



##### ==과 ===의 차이

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>String과 ===</title>
</head>
<body>
  <script>
    document.write("null == undefined : " + (null == undefined) + "<br>");
    document.write("1 == '1' : " + (1 == '1') + "<br>");
    document.write("255 == '0xff' : " + (255 == '0xff') + "<br>");
    document.write("true == 1: " + (true == 1) + "<br>");
    document.write("true == '1' : " + (true == '1') + "<br>");
    document.write("new String('a') == 'a' : " + (new String('a') == 'a') + "<br>");
    document.write("new Number(2) == 2 : " + (new Number(2) == 2) + "<br>");
  </script>
  <br>
  <script>
    document.write("null === undefined : " + (null === undefined) + "<br>");
    document.write("1 === '1' : " + (1 === '1') + "<br>");
    document.write("255 === '0xff' : " + (255 === '0xff') + "<br>");
    document.write("true === 1: " + (true === 1) + "<br>");
    document.write("true === '1' : " + (true === '1') + "<br>");
    document.write("new String('a') === 'a' : " + (new String('a') === 'a') + "<br>");
    document.write("new Number(2) === 2 : " + (new Number(2) === 2) + "<br>");
  	document.write("10>20>30 : " + (10>20>30) + "<br>");
  </script>

</body>
</html>
```


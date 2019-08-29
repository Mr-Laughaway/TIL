# Javascript

#### 자바스크립트 특징

- 인터프리터 언어

  그러나 JIT(Just In Time Compiler) 등의 기법이 적용되어 빨라짐

- 동적 프로토타입 기반 객체 지향 언어

  동적으로 메서드나 멤버 추가/삭제 가능

- 동적 타입 언어

  타입에 값이 저장 될 때 결정되고 또 바뀔 수도 있다.

- 함수가 일급 객체

  함수를 객체 취급하며, 함수에 함수를 인수로 넘길 수 있다.

- 함수가 클로저(closer)를 정의한다.

  클로저로 변수를 은익하거나 영속성을 보장하는 등 다양한 기능을 구현할 수 있다.



#### 자바스크립트의 기술적 요소

- ECMAScript (코어 언어)

- 클라이언트 측의 고유한 기술 요소

  코어와 웹 브라우저의 API로 구성되어 있다.

  - window 인터페이스
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



##### eval() 함수

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>String과 ===</title>
</head>
<body>
  <script>
  	var a = "window.alert('eval은 문자열을 자바스크립트 코드로 실행합니다')";
  	eval(a);
  </script>

</body>
</html>

```



##### type 변환 (String, parseXxx, Number)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>형변환</title>
</head>
<body>
  <h3>자바스크립트 형변환</h3>
  <script>
  	var n = 26;
  	document.write("var n = 26" + "<br>");
  	document.write("n.toString() : " + n.toString() + "<br>")
  	document.write("n.toString(2) : " + n.toString(2) + "<br>")
  	document.write("n.toString(16) : " + n.toString(16) + "<br>")
  	document.write("(26).toString(16) : " + (26).toString(16) + "<br>")
  </script>
  <br>
  <script>
  	var x = 1234.567;
  	document.write("var x = 1234.567" + "<br>");
  	document.write("x.toString() : " + x.toString() + "<br>");
  	document.write("x.toString(16) : " + x.toString(16) + "<br>");
  	document.write("x.toFixed(0) : " + x.toFixed(0) + "<br>");
  	document.write("x.toFixed(2) : " + x.toFixed(2) + "<br>");
  	document.write("x.toFixed(4) : " + x.toFixed(4) + "<br>");
  	document.write("x.toExponential(2) : " + x.toExponential(2) + "<br>");
  	document.write("x.toPrecision(3) : " + x.toPrecision(3) + "<br>");
  	document.write("x.toPrecision(6) : " + x.toPrecision(6) + "<br>");
  </script>
  <br>
  <script>
  	document.write("String(26) : " +String(26)+ "<br>");
  	document.write("String(1234.567) : " +String(1234.567)+ "<br>");
  	document.write("String(0x1a) : " +String(0x1a)+ "<br>");
  </script>
  <br>
  <script>
  	document.write("String('ABC') : " + String("ABC")+ "<br>");
  	document.write("String(true) : " + String(true)+ "<br>");
  	document.write("String(false) : " + String(false)+ "<br>");
  	document.write("String(NaN) : " + String(NaN)+ "<br>");
  	document.write("String(null) : " + String(null)+ "<br>");
  	document.write("String(undefined) : " + String(undefined)+ "<br>");
  	document.write("String({x:1, y:2}) : " + String({x:1, y:2})+ "<br>");
  	document.write("String([1, 2, 3]) : " + String([1, 2, 3])+ "<br>");
  </script>
  <br>
  <script>
  	document.write("parseInt('3.14') : " +parseInt("3.14")+ "<br>");
  	document.write("parseFloat('3.14') : " +parseFloat("3.14")+ "<br>");
  	document.write("parseInt('3.14 meters') : " +parseInt("3.14 meters")+ "<br>");
  	document.write("parseFloat('3.14 meters') : " +parseFloat("3.14 meters")+ "<br>");
  	document.write("parseInt('0xFF') : " +parseInt("0xFF")+ "<br>");
  	document.write("parseInt('0.5') : " +parseInt("0.5")+ "<br>");
  	document.write("parseInt(''.5') : " +parseInt(".5")+ "<br>");
  	document.write("parseInt('abc') : " +parseInt("abc")+ "<br>");
  	document.write("parseFloat('\100') : " +parseFloat("\100")+ "<br>");
  </script>
  <br>
  <script>
  	document.write("Nubmer('2.71828') : " + Number("2.71828") + "<br>");
  	document.write("Number(123) : " + Number(123) + "<br>");
  	document.write("Number(true) : " + Number(true) + "<br>");
  	document.write("Number(false) : " + Number(false) + "<br>");
  	document.write("Number(NaN) : " + Number(NaN) + "<br>");
  	document.write("Number(undefined) : " + Number(undefined) + "<br>");
  	document.write("Number(null) : " + Number(null) + "<br>");
  	document.write("Number({x:1, y:2}) : " + Number({x:1, y:2}) + "<br>");
  	document.write("Number([1,2,3]) : " + Number([1,2,3]) + "<br>");
  </script>
</body>
</html>

```



##### 제어문 (if, 삼항, 논리, switch)

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제어문</title>
</head>
<body>

  <script>
  	//var input1 = window.prompt("점수를 입력하세요", 0);
  	//document.write(input1 + ":" + typeof(input1) + "<br>");
  	
  	//var input2 = window.confirm("종료하시겠습니까?");
  	//document.write(input2 + ":" + typeof(input2) + "<br>");
  </script>
  
 
  <p>문1> if문을 이용해서 사용자로부터 입력받은 점수가 짝수인지 홀수인지 출력 </p>
  <script>
    var input = window.prompt("점수를 입력하세요", 0);
    if( parseInt(input)%2 === 0 ) {
        document.write("짝수" + "<br>");
    }
    else {
      document.write("홀수" + "<br>");
    }
  </script>
  <hr>
  
  <p>문2> 삼항 연산자를 이용해서 사용자로부터 입력받은 점수가 짝수인지 홀수인지 출력 </p>
  <script>
 	 parseInt(input)%2 === 0 ?
  			document.write("짝수" + "<br>")
  			:
  			document.write("홀수" + "<br>");
  </script>
  <hr>
  
  <p>문3> 논리 연산자를 이용해서 사용자로부터 입력받은 점수가 짝수인지 홀수인지 출력 </p>
  <script>
  	parseInt(input)%2 === 0 && document.write("짝수" + "<br>");
  	parseInt(input)%2 === 0 || document.write("홀수" + "<br>");
  </script>
  <hr>
  
  <p>문4> switch 문을 사용해서 사용자로부터 입력받은 점수에 대한 학점 출력, ABCD</p>
  <script>
  	switch(parseInt(parseInt(input)/10)) {
  	case 10:
  	case 9:
  		document.write("A학점" + "<br>");
  		break;
  	case 8:
  		document.write("B학점" + "<br>");
  		break;
  	case 7:
  		document.write("C학점" + "<br>");
  		break;
  	case 6:
  		document.write("D학점" + "<br>");
  		break;
  	default:
  		document.write("F학점" + "<br>");
  	}
  </script>
  <hr>
  
</body>
</html>

```



##### 반복문 (for, while, do~while)과 구구단

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>반복문</title>
 <style>
  div {
    width: 100px;
    float: left;
  }
 </style>
</head>
<body>
  <script>
  
  	for(var i = 0; i < 10; i++) {
  		if( i%2 == 1 )
  			document.write(i+ " ");
  	}
  	document.write("<hr>");
  	
  	var i = 0;
  	while(i < 10) {
  		i++;
  		if( i%2 == 1 )
  			document.write(i+ " ");
  	}
  	document.write("<hr>");
  	
  	var i = 0;
  	do {
  		i++;
  		if( i%2 == 1 )
  			document.write(i+ " ");
  	}while(i < 10);
  	document.write("<hr>");
  
  	var nums = [1,2,3,4,5,6,7,8,9,10];
  	for(var n in nums) {
  		if(n%2 == 1)
  			document.write(n + " ");
  	}
  	document.write("<hr>");
  	
  	for(var i = 1; i <= 9; i++){
  		for(var j = 2; j <= 9; j++) {
  			document.write("<div>" + j + "*" + i + "=" + j*i + "</div>");
  		}
  		document.write("<br>");
  	}
  	document.write("<hr>");
  	
  	for(var su = 1; su<10; su++) {
  		for(var dan=2; dan<10; dan++){
  			document.write(`${dan}x${su}=${dan*su}\t`);
  		}
  		document.write("<br>");
  	}
  </script>

</body>
</html>

```

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



------

### 객체

- 자바 스크립트 객체 생성 방법
  - 객체 리터럴
    - JSON 등
    - 특정 객체를 한 번만 생성해서 사용하는 경우
  - 생성자 함수:
    - new 키워드 사용
    - 필요할 때 마다 생성해서 사용 할 때



#### 객체 리터럴 방식으로 객체 생성

- for in 반복문을 객체의 속성에 접근할 때 사용 가능
- 객체에 대해서 사용하는 in 키워드는 속성 준재 여부를 체크할 때 사용할 수 있습니다.
- 객체의 속성을 객체.속성 대신 속성명으로만 사용할 때 ```with(객체){}``` 사용합니다.
- 객체 리터럴 방식으로 정의되는 객체는 동적으로 속성, 메소드를 추가하거나, 제거할 수 있습니다.

```javascript
var student = { 이름 : '홍길동',  영어:88, 국어:90, 수학:77, 과학:75 }; 
document.write(student.이름+"의 총점 :" +(student.영어+student.국어+student.수학+student.과학)+"<br>");

with(student){
	document.write(이름+"의 평균 :" +(영어+국어+수학+과학)/4+"<br>");
}
console.dir(student);
```



#### 자바스크립트 함수

- var 변수 = function(){} ; //익명(anonymous) 함수
- function 이름(){ } //named function, 선언적 함수
- 사용자 정의 함수는 소스가 공개되지만, 내장함수등은 소스는 native code로 공개하지 않습니다.
- 변수에 저장된 익명함수는 정의된 후에 호출이 가능하지만 
  자바스크립트 엔진은 실행코드보다 먼저 선언적 함수를 읽습니다.(hoisting)
- 선언적 함수는 defintion전에 호출을 하더라도 실행 순서상 문제가 되지 않습니다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자바스크립트 함수</title>
</head>
<body>
<h3>자바스크립트 함수</h3>
# var 변수 = function(){} ; //익명(anonymous) 함수<br>
# function 이름(){ } //named function, 선언적 함수<br>
# 사용자 정의 함수는 소스가 공개되지만, 내장함수등은 소스는 native code로 공개하지 않습니다.<br>
# 변수에 저장된 익명함수는 정의된 후에 호출이 가능하지만 <br>
# 자바스크립트 엔진은 실행코드보다 먼저 선언적 함수를 읽습니다.(hoisting)<br>
#선언적 함수는 defintion전에 호출을 하더라도 실행 순서상 문제가 되지 않습니다.<br> 
<script> 
//func1();//변수에 저장된 함수 호출
func2(); //선언적 함수(named function) 호출
var func1 = function(){
	var jum= Number(window.prompt("1~100사이의 수를 입력하세요", 0));
	(jum%2==0)? alert("짝수") : alert("홀수");
}  
function func2(){
	var jum= Number(window.prompt("1~100사이의 수를 입력하세요", 0));
	(jum%2==0)? alert("짝수") : alert("홀수");
}

func1();
</script>
</body>
</html>
```



#### 자바스크립트 함수(cont'd)

- 모든 함수 가변인자를 가지는 함수로 정의할 수 있습니다.
- 함수가 실행될때 실행 컨텍스트에서는 함수 내부에 arguments 배열과 유사한 타입의 속성이 생성됩니다.
- arguments에 함수를 호출할때 입력값인 인수가 저장됩니다. 
  - 함수에 정의된 매개변수의 개수보다 많은 매개변수로 호출하면 실행시에 무시된다.
  - 함수에 정의된 매개변수의 개수보다 적은 매개변수로 호출하면 undefined로 전달된다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자바스크립트 함수</title>
</head>
<body>
<h3>자바스크립트 함수</h3>
# 모든 함수 가변인자를 가지는 함수로 정의할 수 있습니다<br>
함수가 실행될때 실행 컨텍스트에서는 함수 내부에 arguments 배열과 유사한 타입의 속성이 생성됩니다.<br>  
arguments에 함수를 호출할때 입력값인 인수가 저장됩니다.
함수에 정의된 매개변수의 개수보다 많은 매개변수로 호출하면 실행시에 무시된다<br>
함수에 정의된 매개변수의 개수보다 적은 매개변수로 호출하면 undefined로 전달된다<br> 
<script> 

function hap(a, b){
	document.write("함수의 인수개수 :"+arguments.length+"<br>");
	var sum = 0;
	for (var item in arguments )	{
		document.write(arguments[item]+"<br>");
		sum+=arguments[item];
	}
	document.write("함수의 a, b : "+a+", "+b +"<br>");
	return sum;
}
document.write("hap(3, 5) 호출 :"+hap(3, 5) +"<br>"); //인수개수 맞게 호출
document.write( "<br>");
document.write("hap(1, 3, 5, 7, 9) 호출 :"+hap(1, 3, 5, 7, 9) +"<br>"); //인수 개수보다 많이 ..함수 호출
document.write( "<br>");
document.write("hap(9) 호출 :"+hap( 9) +"<br>"); //인수 개수보다적게...함수 호출
document.write( "<br>");
var nums = [2,4, 6, 8, 10];
document.write("hap(nums) 호출 :"+hap(nums) +"<br>"); //배열을 인수로..함수로 호출
console.dir(hap);
</script>
자바스크립트에서 배열은 모든 타입을 요소로 저장할 수 있습니다.<br>
<script>
var arrays = [1, 'hello', true, function(){}, {name:'korea'}, [100, 200] ];
for (var index in arrays )
{
document.write(index+":"+arrays[index] +"<br>");
}
</script>
</body>
</html>
```



#### 자바스크립트 함수(cont'd)

함수 내부에 함수를 정의 할 수 있습니다. => 외부함수와 충돌이 발생되는 경우, 함수를 사용하는 내부에 정의할수 있으며, 내부함수는 내부함수가 정의된 함수 내부에서만 호출할 수 있습니다.

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자바스크립트 함수</title>
</head>
<body>
<h3>자바스크립트 함수</h3>
함수 내부에 함수를 정의 할 수 있습니다. => 외부함수와 충돌이 발생되는 경우,
함수를 사용하는 내부에 정의할수 있으며, 내부함수는 내부함수가 정의된 함수 내부에서만 호출할 수 있습니다.<br> 
<script>
/*
function square(x){ //인수의 제곱을 반환
		return x*x;
	}
	*/
function pythagoras(width, height){	 //직각삼각형의 빗변의 길이
	function square(x){ //인수의 제곱을 반환
		return x*x;
	}
	return Math.sqrt(square(width)+square(height));
}	
document.write("밑변3, 높이 4인 삼각형의 빗변의 길이 :"+ pythagoras(3, 4) +"<br>");
 
 
// 삼각형이 직각인지 확인하는 함수
function square(width, height, hypotenuse) {
    if (width * width + height * height == hypotenuse * hypotenuse) {
        return true;
    } else {
        return false;
    }
 }
</script>
</script>
</body>
</html>
```



#### 자바스크립트 함수(cont'd)

- 함수를 매개변수로 전달할 수 있습니다.
- 함수를 리턴하는 함수를 정의 가능
- var 키워드를 생략한 함수 내부에 선언된 변수는 함수호출후에 전역변수로 Global 실행 컨텍스트에 추가됩니다. 함수외부에서 참조가 가능해집니다.
- 지역 변수 localVar를 클로저 함수를 통해 참조 가능
- let은 블록 유효 범위를 갖는 지연변수 선언
- constr는 블록 유효 범위를 갖는 상수 선언

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>자바스크립트 함수</title>
</head>
<body>
<h3>자바스크립트 함수</h3>
# 함수를 매개변수로 전달할 수 있습니다.<br>
# 함수를 리턴하는 함수를 정의 가능 <br>
# var 키워드를 생략한 함수 내부에 선언된 변수는 함수호출후에 전역변수로 Global 실행 컨텍스트에 추가됩니다. 함수외부에서 참조가 가능해집니다.<br>
<script>
  var globalVar = 'korea';//전역변수 
  function test(name){
	  globalVar2 = name; //var 키워드를 생략한 함수 내부에 선언된 변수는 함수호출후에 전역변수로 Global 실행 컨텍스트에 생성됩니다. 함수외부에서 참조가 가능해집니다.
	  var localVar = "Hello~"+name+"!!"; //로컬변수
	  return function(){
		       return localVar;
	  }
  }
document.write("전역변수 globalVar :"+ globalVar+"<br>");
//document.write("전역변수 globalVar2 :"+ globalVar2+"<br>"); 
 test('독도');//함수 호출 후
document.write("전역변수 globalVar2 :"+ globalVar2+"<br>"); 
//document.write("지역 변수 localVar :"+ localVar+"<br>");  //에러 발생
document.write("지역 변수 localVar를 클로저 함수를 통해 참조 가능"+ test('제주도')()+"<br>");  

function caller(callee){
	 for(var i=0;i<5;i++){
		 callee();
	 }
 }

 function callee(){
	 alert("callee");
 }
 
 caller(callee); 
</script>
#let은 블록 유효 범위를 갖는 지연변수 선언<br>
#constr는 블록 유효 범위를 갖는 상수 선언<br>
<script>
let x = "outer x";
{
	let x = "inner x";
	let y = "inner y"; 
	document.write("블럭 내부에서 x :"+ x+"<br>"); 
    document.write("블럭 내부에서 y :"+ y+"<br>"); 
}
document.write("블럭 외부에서 x :"+ x+"<br>"); 
//document.write("블럭 외부에서 y :"+ y+"<br>"); //ReferenceError
{
	const c = 3;
	document.write("블럭 내부에서 c :"+ c+"<br>");
	//c = 5;  //TypeError

}

</script>

</body>
</html>
```



- 생성자 함수

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>객체 리터럴</title>
  </head>
  <body>
    <script>
    	var student = {
    		이름 : '홍길동',
    		영어:88,
    		국어:90,
    		수학:77,
    		과학:75,
    		total : function() {
    			return this.영어 + this.국어 + this.수학 + this.과학;
    		},
    		average : function() {
    			return this.total() / 4;
    		}
    	};
    	
    	document.write(student.이름 + "의 총점 : " + student.total() + "<br>");
    	document.write(student.이름 + "의 평균 : " + student.average() + "<br>");
    </script>
    <hr>
    <h3>
      동이랗ㄴ 속성을 가지는 객체를
    </h3>
    <script>
    	//객체 생성을 위한 생성자 함수 정의
    	function Student(name, ko, math, en, sci) {
    		this.name = name;
    		this.ko  = ko;
    		this.math = math;
    		this.en = en;
    		this.sci = sci;
    		this.total = function() {
    			return this.ko + this.math + this.en + this.sci;
    		};
    		this.average = function() {
    			return this.total() / 4;
    		};
    	}
    	
    	//객체 생성
    	var students = [
    		new Student('장기영', 87, 98, 88, 95),
    		new Student('연하진', 92, 98, 96, 98),
    		new Student('구지연', 76, 96, 94, 90),
    		new Student('나선주', 98, 92, 96, 92),
    		new Student('윤아린', 95, 98, 98, 98),
    		new Student('윤명월', 64, 88, 92, 92),
    		new Student('김미화', 82, 86, 98, 88),
    		new Student('김연화', 84, 74, 78, 92),
    		new Student('박여현', 97, 92, 88, 95),
    		new Student('서준서', 45, 52, 72, 65)
    	];
    	
    	
    	
    	for(var idx in students) {
    		document.write(students[idx].name + "의 총점 : " + students[idx].total() + "<br>");
    	  	document.write(students[idx].name + "의 평균 : " + students[idx].average() + "<br>");
    	  	document.write("<br>");
    	}
    </script>
  
  </body>
  </html>
  ```



- 프로토타입

  ```html
  	<!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>프로토 타입</title>
  </head>
  <body>
    
    
      #생성자 함수로 생성되는 객체들의 기능은 모두 동일하므로 객체 생성시마다 메모리에
      생성되는 것 보다는<br>
      생성자 함수는 function객체로 메모리에 생성될 때 프로토타입 속성객체가 자동으로 
      생성됩니다.<br>
      프로토타입 속성 객체에 생성자 함수로 생성되는 객체들의 기능을 추가하면, 전역 메서드 처럼 사용 가능합니다.<br>
      메모리를 줄이고... <br>
    
    <script>
    	//객체 생성을 위한 생성자 함수 정의
    	function Student(name, ko, math, en, sci) {
    		this.name = name;
    		this.ko  = ko;
    		this.math = math;
    		this.en = en;
    		this.sci = sci;
    	}
    	
    	Student.prototype.total = function() {
  			return this.ko + this.math + this.en + this.sci;
  	};
  	
  	Student.prototype.average = function() {
  		return this.total() / 4;
  	};
    	
    	//객체 생성
    	var students = [
    		new Student('장기영', 87, 98, 88, 95),
    		new Student('연하진', 92, 98, 96, 98),
    		new Student('구지연', 76, 96, 94, 90),
    		new Student('나선주', 98, 92, 96, 92),
    		new Student('윤아린', 95, 98, 98, 98),
    		new Student('윤명월', 64, 88, 92, 92),
    		new Student('김미화', 82, 86, 98, 88),
    		new Student('김연화', 84, 74, 78, 92),
    		new Student('박여현', 97, 92, 88, 95),
    		new Student('서준서', 45, 52, 72, 65)
    	];
    	
    	
    	
    	for(var idx in students) {
    		document.write(students[idx].name + "의 총점 : " + students[idx].total() + "<br>");
    	  	document.write(students[idx].name + "의 평균 : " + students[idx].average() + "<br>");
    	  	document.write("<br>");
    	}
    	
    	console.dir(Student);
    </script>
  
  </body>
  </html>
  ```



- 내장객체 : Array

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>내장 객체</title>
  </head>
  <body>
    <h3>내장 객체</h3>
    <script>
    	console.dir(Date);
    	/*
    	var today = new Date();
    	
    	for(var key in today) {
    		document.write(key + " : " + today.key+ "<br>");
    	}
    	*/
    	
    	var array1 = new Array();
    	var array2 = new Array(10);
    	var array3 = new Array(10, 20, 30, 40, 50);
    	
    	document.write("* array1.length : " + array1.length + "<br>");
    	document.write("* array2.length : " + array2.length + "<br>");
    	document.write("* array3.length : " + array3.length + "<br>");
    	document.write("<hr>");
    	
    	array3[5] = 60;
    	array3.push(70);
    	for(var idx in array3) {
    		document.write("* array3[" + idx +"] : " + array3[idx] + "<br>");
    	}
    	document.write("<hr>");
    	
    	delete array3[1];
    	for(var idx in array3) {
    		document.write("* array3[" + idx +"] : " + array3[idx] + "<br>");
    	}
    	document.write("<hr>");
    </script>
     자바스크립트에서 배열은 서로 다른 타입의 요소를 저장할 수 있고<br>
     동적으로 요소를 추가하거나 삭제할 수 잇습니다.<br>
    
    
  </body>
  </html>
  ```



- window.open()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Window객체 활용 </title>
  <script>
    window.onload = function() {
      var btn = document.getElementById("newOpen");
      btn.onclick = function() {
      	window.open("js12.html", "", "width=300 height=300");
      }
    }
    </script>
  </head>
  <body>
    <h3>새창</h3>
    <button id="newOpen">새창 열기</button><br>
    
  
  </body>
  </html>
  
  ```



- window.moveBy()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>윈도우 움직이기</title>
    <script>
    	window.onload = function() {
    		document.getElementById("up").onclick = function() {
    			window.console.log('a');
    			window.moveBy(0, -10);
    		};
    		document.getElementById("left").onclick = function() {
    			console.log('b');
    			window.moveBy(-10, -0);
    		};
    		document.getElementById("right").onclick = function() {
    			console.log('c');
    			window.moveBy(10, 0);
    		};
    		document.getElementById("down").onclick = function() {
    			console.log('d');
    			window.moveBy(0, 10);
    		};
    		
    	}
    	
    	
    </script>
  </head>
  <body>
    <h3>js12.html</h3>
    <input type="button" id="up" value="     UP     "/> <br>
    <input type="button" id="left" value="    LEFT    "/> <br>
    <input type="button" id="right" value="   RIGHT    "/> <br>
    <input type="button" id="down" value="    DOWN    "/> <br>
  </body>
  </html>
  
  ```



- setTimeout()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
    <title>js13.html</title>
    <script>
    	window.onload = function() {
    		setTimeout(function(){
    			window.close();
    		}, 5000);
    	}
    	
    	//setInterval : 주기마다 계속 반복
    </script>
  </head>
  <body>
  
  </body>
  </html>
  
  ```

  

- setInterval()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
    <title>Insert title here</title>
    <script>
    	
    	window.onload = function() {
    		//setInterval(함수, 시간) 반복
    		//clearInterval
    		
    		var cnt = 1;
    		var intervalID;
    		
    		document.write("<h3>1초마다 숫자 출력하고 10초후 종료</h3>");
    		
    		intervalID = setInterval(function(){
    			if(cnt <= 10) {
    				document.write(cnt++ + "<br>");
    			}
    			else {
    				clearInterval(intervalID);
    				window.close();
    			}
    			
    		}, 1000);
    	}
    </script>
  </head>
  <body>
    
  
  </body>
  </html>
  
  ```

  

- Document 객체를 이용한 문서 구조 변경

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
    <title>Document 객체를 이용한 문서 구조 변경</title>
    <script>
    	window.onload = function() {
      	var h1 = document.createElement("h1");
      	var text1 = document.createTextNode("새 요소 추가");
      	h1.appendChild(text1);
      	document.body.appendChild(h1);
      	
      	var img1 = document.createElement("img");
      	img1.src = "../images/puppy.jpg";
      	img1.width = 300;
      	img1.height = 300;
      	document.body.appendChild(img1);
      	//document.body.appendChild(
      	//		document.createElement("br")
      	//);
      	
      	
      	var img2 = document.createElement("img");
      	img2.setAttribute('src', "../images/puppy.jpg");
      	img2.setAttribute('width', 300);
      	img2.setAttribute('height', 300);
      	console.log(img2.getAttribute("src"));
      	document.body.appendChild(img2);
      	
      	var nodelist = document.getElementsByName("j2");
      	console.log(nodelist.length);
      	console.log(nodelist[0].innerHTML+","+nodelist[1].innerHTML);
      	nodelist = document.getElementsByTagName("p");
      	console.log(nodelist.length);
      	
      	var p1 = document.getElementById("j1");
      	p1.style.border = "2px solid blue";
      	p1.style.color = "orange";
      	p1.style.fontSize="20";
      	console.log(
      		document.getElementById("j1").parentNode.nodeName
      	);
      	
    	}
    </script>
  </head>
  <body>
    <h3>Document 객체를 이용한 문서 구조 변경</h3>
    <p id="j1">JavaScript</p>
    <p name="j2">jQuery</p>
    <p name="j2">SencaTouch</p>
    <p>Node.js</p>
  
  </body>
  </html>
  
  ```



- querySelector()

  ```html
  <!DOCTYPE html>
  <html>
  
  <head>
    <meta charset="utf-8" />
    <title>Query Selector Demo</title>
  
    <style type="text/css">
      td {
        border-style: solid;
        border-width: 1px;
        font-size: 300%;
      }
  
      td:hover {
        background-color: cyan;
      }
  
      #hoverResult {
        color: green;
        font-size: 200%;
      }
    </style>
    <script>
    	window.onload = function() {
    		document.getElementById("findHover").onclick = function() {
    			var hovered = document.querySelector("td:hover");
    			if(hovered) {
    				document.getElementById("hoverResult").innerHTML =
    					hovered.innerHTML;
    			}
    		}
    	}
    </script>
  </head>
  
  <body>
  <h3> document.querySelector() </h3>
    <section>
      <!-- create a table with a 3 by 3 cell display -->
      <table>
        <tr>
          <td>A1</td> <td>A2</td> <td>A3</td>
        </tr>
        <tr>
          <td>B1</td> <td>B2</td> <td>B3</td>
        </tr>
        <tr>
          <td>C1</td> <td>C2</td> <td>C3</td>
        </tr>
      </table>
  
      <div>Focus the button, hover over the table cells, and hit Enter to identify them using querySelector('td:hover').</div>
      <button type="button" id="findHover" autofocus>Find 'td:hover' target</button>
      <div id="hoverResult"></div>
  
       
    </section>
  
  </body>
  </html>
  
  ```

  



- querySelector() - 예제2

  ```html
  <!DOCTYPE html>
  <html>
  
  <head>
    <meta charset="utf-8" />
    <title>Query Selector All Demo</title>
  
    <style type="text/css">
      td {
        border-style: solid;
        border-width: 1px;
        font-size: 200%;
      }
  
  
      #checkedResult {
        color: green;
        font-size: 200%;
      }
    </style>
    
    <script>
      window.onload = function() {
    		document.getElementById("findChecked").onclick = function() {
    			var selected = document.querySelectorAll("input:checked");
    			var result = "Selected boxes are: ";
    			for( var i = 0; i < selected.length; i++) {
    				result += (selected[i].name + " ");
    			}
    
    			document.getElementById("checkedResult").innerHTML = result;
    		}
    	}
    </script>
  
  </head>
  
  <body>
  
    <section>
  
      <table>
        <tr>
          <td><input type="checkbox" name="A1">A1</td>
          <td><input type="checkbox" name="A2">A2</td>
          <td><input type="checkbox" name="A3">A3</td>
        </tr>
  
        <tr>
          <td><input type="checkbox" name="B1">B1</td>
          <td><input type="checkbox" checked name="B2">B2</td>
          <td><input type="checkbox" name="B3">B3</td>
        </tr>
  
        <tr>
          <td><input type="checkbox" name="C1">C1</td>
          <td><input type="checkbox" name="C2">C2</td>
          <td><input type="checkbox" name="C3">C3</td>
        </tr>
  
      </table>
      <div>Select various checkboxes, then hit the button to identify them using querySelectorAll("*:checked").</div>
      <button type="button" id="findChecked" autofocus>Find checked boxes</button>
      <div id="checkedResult"></div>
  
       
    </section>
  
  </body>
  
  </html>
  
  ```



- misstion1

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  	<meta charset="utf-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		
  		}
  		
  		div{
  			border: 1px solid #999999;
  			margin:20px;
  			margin-bottom:20px;
  		}
  		div div{
  			border: 1px dotted #CCC;
  			
  		}
  		
  		.active{
  			font-size:20pt;
  			color:#090;
  			border:5px solid #ff0000;
  		}
  	</style>
  	<script>
  	
  	window.onload = function() {
  		//1
  		var m_1 = document.getElementById("m_1");
  		m_1.style.color = 'red';
  		
  		//2
  		var m_2 = document.getElementById("m_2");
  		m_2.setAttribute('class', 'active');
  		
  		//3
  		var m_3 = document.getElementById("m_3");
  		m_3.children[1].setAttribute('src','../images/ch3.png');
  		
  		//4
  		var m_4 = document.getElementById("m_4");
  		var p = document.createElement("p");
      	var text = document.createTextNode("항목4");
      	p.appendChild(text);
      	m_4.appendChild(p);
      	
      	//5
      	var m_5 = document.getElementById("m_5");
      	m_5.removeChild(m_5.children[1]);
      	
      	
      	//6
      	var m_6 = document.getElementById("m_6");
      	var p_m_6 = m_6.parentNode;
      	var nChild =  p_m_6.childElementCount;
      	for(var i = 0; i < nChild; i++) {
      		p_m_6.removeChild(p_m_6.children[0]);
      	}
      	
  	}
  		 
  	</script>
  </head>
  
  <body>
  	<div> 
  		<h4>테스트1</h4>
  		<div id="m_1">
  			#m_1 : 글자색을 빨간색으로 변경해주세요.
  		</div>
  	</div>
  	<div> 
  		<h4>테스트2</h4>
  		<div id="m_2">
  			#m_2 : 클래스 active를 적용시켜 주세요.
  		</div>
  	</div>
  	<div> 
  		<h4>테스트3</h4>
  		<div id="m_3">
  			#m_3 : 에고 이 이미지가 아닌데... 이미지를 ch3.png로 변경해주세요"<br>
  			<img src="../images/ch2.png">
  		</div>
  	</div>
  	<div> 
  		<h4>테스트4</h4>
  		<div id="m_4">
  			#m_ 4 :  홋! 항목4까지 있어야 하는건데, 바쁜나머지 실수를 했군요. 항목4를 제일 뒤에 추가해주시겠어요?
  			<p>
  				항목1
  			</p>
  			<p>
  				항목2
  			</p>
  			<p>
  				항목3
  			</p>
  		</div>
  	</div>
  	<div> 
  		<h4>테스트5</h4>
  		<div id="m_5">
  			#m_ 5 :  이번에는 항목4가 더 추가되었네요. 즉시 삭제해주세요.
  			<p>
  				항목1
  			</p>
  			<p>
  				항목4
  			</p>
  			<p>
  				항목2
  			</p>
  		</div>
  	</div>
  	<div> 
  		<h4>테스트6</h4>
  		<div id="m_6">
  			#m_ 6 : 이런이런! 이 부분은 전혀 필요없는 내용들인데 왜 있는거죠? #m_6부터 헤더태그까지 모두 삭제해주세요.
  			<p>
  				DOM(Document Object Model)이란?<br>
  				웹페이지 문서를 조작하기 위해서 지켜야될 약속(interface)만 딸랑 적혀있는 문서랍니다.
  				약속만 있을뿐 내부는 텅빈 상자랍니다.
  				우리가 알고있는 W3C DOM에는 구현소스가 한줄도 존재하지 않습니다.
  				그럼 실제 구현소스는??
  			</p>
  		</div>
  	</div>
  </body>
  </html>
  
  
  ```

  

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

    > 한번 실행하므로 초기화 작업할 때 사용하며, 전역 유효 범위를 오염시키지 않는다.

    

- 모든 함수의 인수는 가변 길이를 가집니다.

  - 선언된 인수보다 적으면 인수를 참조할 때 ```undefined```

  - 선언된 인수보다 많으면 ```무시```한다.

  - 모든 함수가  생성될 때  인수가 저장되는 함수의 property는 Argument 객체의 arguments 입니다.

    ```arguments.length``` ,```arguments[index]```



- 자바 스크립트에서 재귀함수를 정의하고 사용할 수 있습니다.

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
  - ECMAScript 객체



- Window 객체
  - close()
  - open(url, name, {...})
  - moveBy()
  - MoveTo()
  - alert()
  - confirm()
  - prompt()
  - setTimeout(function(){}, timeout millisecond), clearTimeout()
  - setInterval(function(){}, interval millisecond), clearInterval()



- Window객체의 속성 Document ***document*** : HTML 요소 관련 처리 객체
  - getElementById("")
  - getElementsByName("")
  - getElementsByTagName("");
  - getElementsByClassName("");
  - querySelector("css의 selector형식");  ```td:hover``` 등
  - querySelectorAll("css의 selector형식");
  - createElement("h1")
  - createComment
  - createTextNode("말말말")
  - createDocumentFragment
  - createAttribute()
  - setAttribute()
  - getAttribute()
  - removeAttribute()
  - Element.parentNod, childNodes
  - appendChild()



- Element 추가

  ```html
  <!DOCTYPE html>
  <html>
  <head>
    <meta charset="UTF-8">
    <title>InsertBefore 테스트</title>
  </head>
  <body>
    <ul id= 'doglist'>
      <li>포메라니안</li>
      <li>달마시안</li>
    </ul>
    
    <script>
    	var doglist = document.getElementById("doglist");
    	var element = document.createElement("li");
    	var text = document.createTextNode("불독");
    	//두 번째 자시 ㄱ요소의 바로 앞에 삽입
    	doglist.insertBefore(element, doglist.children[1]);
    	element.appendChild(text);
    </script>
  </body>
  </html>
  
  ```

  

- window scroll

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Scroll</title>
  <style>
    .box {
      display: inline-block;
      padding: 100px;
      margin: 100px;
      margin-left: 0;
      background-color: yellow;
    }
  </style>
  </head>
  
  <body>
    <div class="box" id="sec1">#sec1</div>
    <br>
    <div class="box" id="sec2">#sec2</div>
    <br>
    <div class="box" id="sec3">#sec3</div>
    
    <script>
    
    	function getScrollTop() {
    		if(window.pageYOffset !== undefined) {
    			return window.pageYOffset;
    		}
    		else {
    			return document.documentElement.scrollTop || 
    				document.body.scrollTop; 
    		}
    	}
    	
    	console.log(getScrollTop());
    	
    	function getScrollLeft() {
    		if(window.pageXOffset !== undefined) {
    			return window.pageXOffset;
    		}
    		else {
    			return document.documentElement.scrollLeft || 
    				document.body.scrollLeft; 
    		}
    	}
    	
    	console.log(getScrollLeft());
    	
    	if('scrollRestoration' in history) {
    		history.scrollRestoration = 'manual';
    	}
    	var element = document.getElementById("sec3");
    	var rect = element.getBoundingClientRect();
    	
    	console.log(rect.left + getScrollLeft());
    	console.log(rect.top + getScrollTop());
    	
    	scrollTo(rect.left + getScrollLeft(), rect.top + getScrollTop());
    </script>
  
  </body>
  </html>
  
  ```

  

- value 가져오기

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>폼 태그</title>
  <script>
  	function whenSubmit() {
  		// 변수를 선언합니다.
  		var pass = document.getElementById('pass').value;
  		var pass_check = document.getElementById('pass_check').value;
  		
  		//비번 같냐?
  		if(pass == pass_check) {
  			alert('성공');
  		}
  		else {
  			alert('다시 입력해주세요.');
  			return false;
  		}
  	}
  
   
  </script>
  </head>
  <body>
    <form id="my_form" onsubmit="whenSubmit()">
      <label for="name">이름</label><br/>
      <input type="text" name="name" id="name"/><br/>
      <label for="pass">비밀번호</label><br/>
      <input type="password" name="pass" id="pass"/><br/>
      <label for="pass_check">비밀번호 확인</label><br/>
      <input type="password" id="pass_check"/><br/>
      <input type="submit" value="제출"/>
    </form>
  </body>
  </html>
  
  ```

  

- Event 추가 및 강제 호출

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>이벤트</title>
    <script>
    	/*
    	//DOM level 0
    	window.onload = function() {
    		alert("load event handler1");
    	}
    	
    	window.onload = function() {
    		alert("load event handler2");
    	}
    	
    	window.onload = function() {
    		alert("load event handler3");
    	}
    	*/
    	
    	//DOM level1
    	/*
    	window.addEventListener("load", function(){
    		alert("load event handler1")}, false);
    	window.addEventListener("load", function(){
    		alert("load event handler2")}, false);
    	window.addEventListener("load", function(){
    		alert("load event handler3")}, false);
    	*/
    	
    	window.addEventListener("load", function(){
    		var h3 = document.getElementById("evt");
    		h3.onclick = function() {
    			alert("까꿍");
    			this.onclick = null;
    		}
    		
    		var h3_2 = document.getElementById("evt2");
    		h3_2.onclick = function() {
    			
    			this.style.background = 'orange';
    			this.style.color = 'yellow';
    		}
    	}, false);
    	
    </script>
  </head>
  <body>  
    <h3> 자바스크립트 이벤트</h3>
    # DOM Level 0 이벤트 모델 : on이벤트명 = function(){} => 
    이벤트당 하나의 이벤트 핸들러만 연결
    <br>
    #DOM Level 2 이벤트 모델:
    이벤트소스(태그객체).addEventListner("이벤트명", function(){}, 이벤트캡처여부)
    이벤트당 하나 이상의 이벤트 핸들러 연결
    <br>
    이벤트에 대한 이벤트 핸들러가 한번만 수행 후 이벤트 핸들러 취소하려면:
    이벤트 소스.on이벤트속성 = null;<br>
    <h3 id="evt"> 이벤트 핸들러 한 번만</h3>
    <h3 id="evt2"> 클릭이벤트가 발생하면 색 바꿔</h3>
    이벤트 핸들러 함수 내부에서 이벤트 객체의 속성들을 핸들링할 때 이벤트 소스 객체를 
    this 참조 합니다<br>
   
  
  </body>
  </html>
  
  ```



- location 객체

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
      window.onload = function() {
      	
      	var panel1 = document.getElementById("panel1")
      	var nNum = 1+Math.floor(Math.random()*100);
      	panel1.innerHTML = nNum;
      	panel1.style.fontSize = 100 + (Math.random()*100)+"px";
      	
      	setTimeout(function(){
      		//location.href = "https://www.w3schools.com";
      		//location.assign("https://www.naver.com");
      		//location.replace("https://www.google.com");
      		//location.reload();
      		location.href = location.href;
      	}, 3000);
      	
      }
    </script>
  </head>
  <body>
    <!-- h3> 이 페이지는 3초후에 www.w3schools.com 으로 이동합니다.</h3 -->
    <h3> 이 페이지는 3초후에 reload 됩니다.</h3>
    <div id="panel1">
      
    </div>
  </body>
  </html>
  
  ```

  

- history 객체

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
      window.onload = function() {
      	/*
  		history.pushState(null, null, "js01.html");
  		history.pushState(null, null, "js02.html");
  		history.pushState(null, null, "js03.html");
  		history.pushState(null, null, "js04.html");
  		history.pushState(null, null, "js05.html");
  		history.pushState(null, null, "js08.html");
  		*/
  		
  		document.getElementById("back").onclick = function() {
  			history.back();
  		}
  		
  		document.getElementById("next").onclick = function() {
  			history.forward();
  		}
  		
  		document.getElementById("goBack").onclick = function() {
  			history.go(-2);
  		}
  		
  		document.getElementById("goNext").onclick = function() {
  			history.go(3);
  		}
      }
    </script>
  </head>
  <body>
    <button id="back">이전</button> <br>
    <button id="next">다음</button> <br>
    <button id ="goBack">go(-2))</button> <br>
    <button id="goNext">go(3)</button> <br>
    <script>
    	document.write("화면해상도 : " + screen.width + " x " + screen.height);
    	document.write("<br>색상수화면해상도수(비트) : " +  screen.colorDepth);
    </script>
    
  </body>
  </html>
  
  ```

  

- 당첨번호 뽑기 예제

  ```html
  <!DOCTYPE html >
  <html>
  <head>
  	<meta  charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		}
  		#panel1{
  			border:1px #000000 solid;
  			line-height:400px;
  			font-size:100px;
  			width:400px;
  			height:400px;
  			text-align:center;
  			vertical-align:middle;		
  		}
  	
  	</style>
  	<script>
  		/*
  		 	Step #8
  		 		- 1에서 참여인원수 내에서 랜덤숫자 만들기(20분)
  		 	Step #7
  				- 출력패널 스타일 초기화
  			Step #6-1
  				- 리팩토링
  			Step #6
  				- 당첨 버튼 클릭시 램덤숫자출력정지
  				- 현재 화면에 출력된 숫자가 당첨번호, 이를 부각시키기 위해서 글자색을 빨간색, 크기를 250px로 만듬.
  			Step #5
  				- 초기 시작시 랜덤숫자 만들기는 정지된 상태.
  				- 시작 버튼 클릭시 랜덤하게 숫자가 출력되도록 만들기.
  			Step #4
  				- step #1에서 만든 숫자를 레이아웃에 출력하기.("숫자가 출력될 영역"Element를 구해야겠죠?)
  			Step #3
  				- 레이아웃 구성하기(숫자가 출력될 영역, 시작버튼, 당첨버튼등이 있어야 겠죠?)
  			Math.
  			Step #2
  				- 0.1초에 한번씩 Random 하게 1부터 100사이의 정수 만들기.(setInterval을 이용하세요)
  			Step #1
  				- Random하게 1부터 100사이의 정수 만들기.
  		*/
  	 window.onload = function() {
  			
  		var panel = document.getElementById("panel1");
  		var nMax;
  		var idInterval = 0;
  		
  	 	document.getElementById("btn_start").onclick = function() {
  	 		if(idInterval == 0) {
      	 		nMax = document.getElementById("lab_total").value;
      	 		panel.style.color = 'black';
      	 		
      	 		idInterval = setInterval(function(){
      	 			panel.innerHTML = parseInt(Math.random()*nMax)+1;
      	 			panel.style.fontSize = (parseInt(Math.random()*200)+1) + 'px';
      	 		}, 100);
  	 		}
  	 	}
  	 	
  	 	document.getElementById("btn_stop").onclick = function() {
  	 		if(idInterval != 0) {
      	 		clearInterval(idInterval);
      	 		idInterval = 0;
      	 		panel.style.color = 'red';
      	 		panel.style.fontSize = '250px';
  	 		}
  	 	}
  		
  	}
  	</script>
  </head>
  
  <body>
  	<div> 
  		<h4>경품추첨기-ver 0.1</h4>
  	
  		<div id="panel1" > 1
  			<!-- 이곳에 숫자가 출력됩니다. -->
  		</div>
  	
  		<div id="nav">
  			참여인원 : <input type="text" id="lab_total" value="100">
  			<button id="btn_start">시작</button>
  			<button id="btn_stop">멈춤</button>
  		</div>
  	</div>
  </body>
  </html>
  
  
  ```

  

- 여러가지 변경 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  	<meta charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		
  		}
  		
  		div{
  			border: 1px solid #999999;
  			margin:20px;
  			margin-bottom:20px;
  		}
  		div div{
  			border: 1px dotted #CCC;
  			
  		}
  		
  		.active{
  			font-size:20pt;
  			color:#090;
  			border:5px solid #ff0000;
  		}
  	</style>
  	<script>
  	window.onload=function(){			
  		 solveM1();
  		 solveM2();
  		 solveM3();
  		 solveM4();
  		 solveM5();
  		 solveM6();
  	}
  	
  	function solveM1(){
  		// 노드 찾기
  		var m1 = document.getElementById("m_1");
  		// 스타일 변경하기.
  		m1.style.color = "#ff0000";
  	}
  	
  	function solveM2(){
  		// 노드 찾기.
  		var m2 = document.getElementById("m_2");
  		// 클래스 이름 변경하기.
  		m2.className = "active";
  	}
  	
  	function solveM3(){
  		// 노드 찾기.
  		var m2 = document.getElementById("m_3");
  		// 자식노드중에서 img 태그만을 찾은 후 첫번째 태그를 얻어온다. 
  		var img = m2.getElementsByTagName("img")[0];
  		// HTMLImageElement의 src 프로퍼티를 이용해서 이미지를 변경하는 경우.
  		img.src	= "ch3.png"
  		// Element의 setAttribute 메소드를 이용해서 이미지를 변경하는 경우.
  		img.setAttribute("src", "ch3.png");
  	}
  	
  	function solveM4(){
  		// p태그 노드 생성하기.
  		var p4 = document.createElement("p");
  		// 텍스트 설정하기.
  		p4.innerHTML = "항목4";
  		// 신규로 생성한 p태그를 추가할 부모 노드 찾기.
  		var m4 = document.getElementById("m_4");
  		// p태그를 부모노드에 추가하기.
  		m4.appendChild(p4);
  	}
  	
  	function solveM4_2(){
  		// p태그 노드 생성하기.
  		var p4 = document.createElement("p");
  		// text 노드 생성하기.
  		var text = document.createTextNode();
  		// 텍스트 설정하기.
  		text.nodeValue = "항목4";
  		p4.appendChild(text);
  
  		// 신규로 생성한 p태그를 추가할 부모 노드 찾기.
  		var m4 = document.getElementById("m_4");
  		// p태그를 부모노드에 추가하기.
  		m4.appendChild(p4);
  	}
  	
  	function solveM5(){
  		//부모노드 찾기.
  		var m5 = document.getElementById("m_5");
  		// m5의 자식노드에서 <p>태그만을 모두 찾기.
  		var ps = m5.getElementsByTagName("p");
  				
  		for(var i=0;i<ps.length;i++){
  			var p = ps[i];
  			
  			//p.firstChild는 text node 입니다.
  			var text = p.firstChild.nodeValue;
  		
  			// p요소중 텍스트값이 항목4를 가지고 있는 노드를 찾아 삭제.	
  			if(text.indexOf("항목4")!=-1){
  				m5.removeChild(p);
  				break;
  			}
  		}
  	}
  	
  	function solveM5_2(){
  		var m5 = document.getElementById("m_5");
  		var ps = m5.getElementsByTagName("p");
  		
  		m5.removeChild(ps[2]);
  		// 또는 m5.removeChild(ps.item(2))
  	}
  
  	
  	function solveM6(){
  		// 제거할 노드와 가장 근접한 노드를 찾습니다.
  		var m6 = document.getElementById("m_6");
  		// 제거하기.
  		document.body.removeChild(m6.parentNode);
  	}
  	
  	function solveM6_2(){
  		// 제거할 노드와 가장 근접한 노드를 찾습니다.
  		var divs = document.getElementsTagName("div");
  		// 제거하기.
  		document.body.removeChild(divs[11]);
  	}
  	</script>
  </head>
  
  <body>
  	<div> 
  		<h4>테스트1</h4>
  		<div id="m_1">
  			#m_1 : 글자색을 빨간색으로 변경해주세요.
  		</div>
  	</div>
  	<div> 
  		<h4>테스트2</h4>
  		<div id="m_2">
  			#m_2 : 클래스 active를 적용시켜 주세요.
  		</div>
  	</div>
  	<div> 
  		<h4>테스트3</h4>
  		<div id="m_3">
  			#m_3 : 에고 이 이미지가 아닌데... 이미지를 ch3.png로 변경해주세요"<br>
  			<img src="ch2.png">
  		</div>
  	</div>
  	<div> 
  		<h4>테스트4</h4>
  		<div id="m_4">
  			#m_ 4 :  홋! 항목4까지 있어야 하는건데, 바쁜나머지 실수를 했군요. 항목4를 제일 뒤에 추가해주시겠어요?
  			<p>
  				항목1
  			</p>
  			<p>
  				항목2
  			</p>
  			<p>
  				항목3
  			</p>
  		</div>
  	</div>
  	<div> 
  		<h4>테스트5</h4>
  		<div id="m_5">
  			#m_ 5 :  이번에는 항목4가 더 추가되었네요. 즉시 삭제해주세요.
  			<p>
  				항목1
  			</p>
  			<p>
  				항목4
  			</p>
  			<p>
  				항목2
  			</p>
  		</div>
  	</div>
  	<div> 
  		<h4>테스트6</h4>
  		<div id="m_6">
  			#m_ 6 : 이런이런! 이 부분은 전혀 필요없는 내용들인데 왜 있는거죠? #m_6부터 헤더태그까지 모두 삭제해주세요.
  			<p>
  				DOM(Document Object Model)이란?<br>
  				웹페이지 문서를 조작하기 위해서 지켜야될 약속(interface)만 딸랑 적혀있는 문서랍니다.
  				약속만 있을뿐 내부는 텅빈 상자랍니다.
  				우리가 알고있는 W3C DOM에는 구현소스가 한줄도 존재하지 않습니다.
  				그럼 실제 구현소스는??
  			</p>
  		</div>
  	</div>
  </body>
  </html>
  
  
  ```



- 생선 움직이기 예제

  ***나***

  ```html
  <!DOCTYPE html >
  <html>
  <head>
  	<meta  charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;
  		
  		}
  		#panel{
  			width:600px;
  			height:300px;
  			border:1px solid #999;
  			position:relative;
  		}
  		
  		#bar{
  			position:absolute;
  			left:50px;
  			top:190px;
  			width:500px;
  			height:20px;
  			
  			background:#F30;
  		}
  		
  		#img1{
  			position:absolute;
  			left:50px;
  			top:120px;
              margin-left: 50px;	
  		}
  		
  		#nav{
  			text-align:center;
  			width:600px;
  		}
  	</style>
  	
  	<script>
  		 // 시작위치 구하기.
  		 // 마지막 위치.(시작위치 + bar의 넓이 - 이미지 넓이)
  		 // 이미지의 현재 위치를 시작위치로 설정.
  		 // 사용하게 될 이미지(물고기) 엘리먼트를 변수에 저장.
  		 // 시작버튼 이벤트 리스너 등록.
  		 // 정지버튼 이벤트 리스너 등록.
  		 // 타이머 실행.
  		 // 이미지 움직이기. -  2px만큼 이동합니다.
           //  위치값이 마지막 위치값을 넘어가는 순간, 
  		//  시작 위치<--- 마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  		// 위치값이 시작위치값을 넘어가는 순간,
  		// 시작위치 ---->마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  		// 최종적으로 조절된 위치값을 left에 적용시켜 준다.
  		// 타이머 정지시키기.
  	</script>
    
    <script>
    	window.onload = function() {
    		var eImg = document.getElementById("img1");
    		var imgWidth = eImg.clientWidth;
    		var barWidth =  document.getElementById("bar").clientWidth;
    		
    		var nMinMargin = 0;
    		var nMaxMargin = barWidth - imgWidth;
    		
    		var nDir = 1;
    		var nStep = 5;
    		var nTimerID = 0;
    		
    		//START button
    		document.getElementById("btn_start").onclick = function() {
    			
    			if(nTimerID == 0) {
    				nTimerID = setInterval(function(){
    					var margin = parseInt(eImg.style.marginLeft);
    					if(isNaN(margin)) {
    						eImg.style.marginLeft = '0px';
    						margin = 0;
    					}
    					
    					if(nDir == 1){
    						if(margin + nStep > nMaxMargin) 
    							nDir = -1;
    					}
    					else {
    						if(margin - nStep < nMinMargin)
  							nDir = 1;
    					}
    					
    					eImg.style.marginLeft = margin + nStep*nDir + 'px';
    					
    				}, 20);
    			}
    		}
    		
    		//STOP button
    		document.getElementById("btn_stop").onclick = function() {
    			if(nTimerID) {
    				clearInterval(nTimerID);
    				nTimerID = 0;
    			}
    		}
    		
    		
    	}
    </script>
  </head>
  
  <body>	
  	<div> 
  		<h4>#img1을 #bar의 영역에서 계속 좌우로 움직이도록 만들어주세요.</h4>
  		<div id="panel">
  			<div id="bar"> </div>
  			<div id="img1">
  				<img src="fish.png">
  			</div>
  		</div>
  		<div id="nav">
  			<button id="btn_start">시작</button>
  			<button id="btn_stop">멈춤</button>
  		</div>
  	</div>       
  </body>
  </html>
  
  
  ```

  ***선생님***

  ```html
  <!DOCTYPE html  >
  <html>
  <head>
  	<meta  charset="UTF-8">
  	<title></title>
  	<style>
  		body{
  			font-size:9pt;		
  		}
  		
  		#panel{
  			width:600px;
  			height:300px;
  			border:1px solid #999;
  			position:relative;
  		}
  		
  		#bar{
  			position:absolute;
  			left:50px;
  			top:190px;
  			width:500px;
  			height:20px;
              margin-left:1px;
  			background:#F30;
  		}
  		
  		#img1{
  			position:absolute;
  			left:50px;
  			top:120px;		
  		}
  		
  		#nav{
  			text-align:center;
  			width:600px;
  		}
  	</style>
  	
  	<script>
  		var nEndX;
  		var nCurrentX;
  		var nStartX;
  		var nTimerID;
  		var nStep;
  		var objIMG;
  	
  		window.onload=function(){
  			var objBar = document.getElementById("bar");
  			
  			// 시작위치 구하기.
  			this.nStartX = objBar.offsetLeft;
  	
  			// 마지막 위치.(시작위치 + bar의 넓이 - 이미지 넓이)
  			this.nEndX = objBar.clientWidth;
  			this.nEndX += this.nStartX;		
  			this.nEndX -= 128;
  	
  			// 이미지의 현재 위치를 시작위치로 설정.
  			this.nCurrentX = this.nStartX;
  			
  			this.nStep = 2;
  			this.nTimerID = 0;
  			
  			// 계속해서 사용하게 될 이미지 엘리먼트를 변수에 저장.
  			this.objIMG = document.getElementById("img1");
  		 
  			// 시작버튼 이벤트 리스너 등록.
  			document.getElementById("btn_start").addEventListener("click",function(){
  				start();
  			},false);
  			
  			// 정지버튼 이벤트 리스너 등록.
  			document.getElementById("btn_stop").addEventListener("click",function(){
  				stopMove();
  			},false);
  		}
  		 
  		
  		// 타이머 실행.
  		function start(){
  			if(this.nTimerID==0)
  				this.nTimerID = setInterval(this.startMove,30);
  			
  		}
  		
  		// 이미지 움직이기.
  		function startMove(){
  			// nStep만큼 이동합니다.
  			this.nCurrentX += this.nStep;
  			
  			//  위치값이 마지막 위치값을 넘어가는 순간, 
  			//  시작 위치<--- 마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  			if(this.nCurrentX>this.nEndX){
  				this.nCurrentX=this.nEndX;
  				this.nStep=-2;
  			}
  			// 위치값이 시작위치값을 넘어가는 순간,
  			// 시작위치 ---->마지막 위치로 이동될수 있도록 방향을 바꿔준다.
  			if(this.nCurrentX<this.nStartX){
  				this.nCurrentX=this.nStartX;
  				this.nStep=2;
  			}
  			
  			// 최종적으로 조절된 위치값을 left에 적용시켜 준다.
  			this.objIMG.style.left=this.nCurrentX+"px";		
  		}
  		
  		// 타이머 정지시키기.
  		function stopMove(){
  			if(this.nTimerID!=0){
  				clearInterval(this.nTimerID);
  				this.nTimerID=0;
  			}
  		}
  	</script>
  </head>
  
  	<div> 
  		<h4>#img1을 #bar의 영역에서 계속 좌우로 움직이도록 만들어주세요.</h4>
  		<div id="panel">
  			<div id="bar"> </div>
  			<div id="img1">
  				<img src="fish.png">
  			</div>
  		</div>
  		<div id="nav">
  			<button id="btn_start">시작</button>
  			<button id="btn_stop">멈춤</button>
  		</div>
  	</div>       
  </body>
  </html>
  
  
  ```

  

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



- innerHTML, innerText, ***textContent(공백도 다 가져왕)***

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

  

- file 로 이미지 파일 정보 가져오기

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <script>
  
  window.onload = function(){
  	var fileElement = document.getElementById("f1");
  	fileElement.addEventListener("change", function(){
  		var files = fileElement.files;
  		var output = "";
  		for(var i=0; i<files.length; i++) {
  			var file = files[i];
  			output += "파일이름 : " + file.name + ", 크기 : " + file.size +
  				"bytes, 타입 : " + file.type + "<br>";
  				
  		}
  		
  		document.getElementById("result").innerHTML = output;
  		
  	}, false);
   
  }
  
  </script>
  </head>
  <body>
    <input id="f1" type="file" multiple accept="image/*">
    <div id="result"></div>
   </body>
  </html>
  ```



- ***Drag and Drop***

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <script>
  var dropbox;
  window.addEventListener("load", function() {
  	dropbox = document.getElementById("dropbox");
  		// 이벤트 핸들러 할당	
  	dropbox.addEventListener("drop", drop, false);
  	dropbox.addEventListener("dragenter", dragEnter, false);
  	dropbox.addEventListener("dragover", dragOver, false);
  }, false);
  
  function dragEnter(event) {
  	event.stopPropagation();
  	event.preventDefault();
  }
  
  function dragOver(event) {
  	event.stopPropagation();
  	event.preventDefault();
  }
  
  function drop(event) {
  	event.stopPropagation();
  	event.preventDefault();
  
  	var files = event.dataTransfer.files;
  	var count = files.length;
  
  	// 오직 한개 이상의 파일이 드랍된 경우에만 처리기를 호출한다.
  	if (count > 0) {
  		var file = files[0];
  		document.getElementById("droplabel").innerHTML 
  		           = "Processing "+ file.name;
  		var reader = new FileReader();
  		// 파일 리더의 이베트 핸들러 정의
  		reader.onloadend = function(event) {
  			var img = document.getElementById("preview");
  			img.src = event.target.result;//event.target는 FileReader객체
  		};
  		reader.readAsDataURL(file);
  	}
  }
  	
  </script>	
  </head>
  <body>
  <h1>Drag and Drop Demo</h1>
  	<div id="dropbox"
  		style="width: 360px; height: 80px; border: 1px solid #aaa;">
  		<span id="droplabel"> 이곳에 파일을 드랍해 주세요... </span>
  	</div>
  	<img id="preview" alt="[ preview will display here ]" />
  </body>
  </html>
  ```

  

- FileReader로 file 내용 읽기

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script>
  //1. new FileReader()
  //2. onload, onloadend이벤트에 대한 핸들러 : result속성에 저장낸 내용을 textarea에..
  //3. readAsText()사용  내용 읽기
  function readFile(){
  	var file = document.getElementById("file").files[0];
  	document.getElementById("fileName").innerHTML = file.name;
  	document.getElementById("fileSize").innerHTML = file.size+"Bytes";
  	
  	var reader = new FileReader();
  	reader.onloadend = function() {
  		document.getElementById("content").innerHTML = reader.result;
  	}
  	
  	var encodingList = document.getElementById("encoding");
  	var encoding =
  	//	encodingList.options[encodingList.selectedIndex].value;
  		encodingList.children[encodingList.selectedIndex].innerHTML;
  	console.log(file);
  	reader.readAsText(file, encoding);
  	
  }
  </script>
  </head>
  <body>
   <h1> FileReader Interface : readAsText()</h1>
         <input id="file" type="file">
         <select id="encoding">
             <option>UTF-8</option>
  		   <option>euc-kr</option>
          </select>
          <button onclick="readFile()">읽기</button><br />
          <div>
              <span id="fileName">File Name</span>
              <span id="fileSize">File Size</span>
          </div>
          <textarea id="content" readonly style="width:600px; height:400px;"></textarea>
  </body>
  </html>
  ```



- Drag & Drop 으로 element 옮기기 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  
  <meta charset="utf-8">
  <title>Insert title here</title>
  <style>
  div#Red {border:2Px solid #F00;}
  div#Blue {border:2Px solid #00F;}
  div {width:400px;height:266px;}
  a {margin:50px;display:block;}
  </style>
  <script>
  	function drag(source, event) {
  		//event.preventDefault();
  		console.log('drag');
  		event.stopPropagation();
  		event.dataTransfer.setData("text", source.id);
  	};
  	
  	function drop(source, event) {
  		//event.preventDefault();
  		console.log('drop');
  		event.stopPropagation();
  		var imgId = event.dataTransfer.getData("text");
  		source.appendChild(document.getElementById(imgId));
  	};
  </script>
  </head>
  <body>
  <div id="Red" ondrop="drop(this, event);" 
       ondragenter="return false;" 
       ondragover="return false;"></div>
  <div id="Blue" ondrop="drop(this, event);" 
  	ondragenter="return false;" 
  	ondragover="return false;"></div>
  <img draggable="true" id="textlink" 
       ondragstart="drag(this, event);" 
       src="../images/red_dragon1.jpeg"></img>
  </body>
  </html>
  ```

  

- Canvas 예제 및 내용 복사

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="utf-8">
  <title>Insert title here</title>
  <script>
  	window.addEventListener("load", function(){
  		var img = document.getElementById("scream");
  		var canvas1 = document.getElementById("drawCanvas");
  		var ctx = canvas1.getContext("2d");
  		ctx.drawImage(img, 10, 10);
  		
  	}, false);
  	
  	function fromImageData() {
  		var canvas1 = document.getElementById("drawCanvas");
  		var imgData = canvas1.toDataURL();
  		var canvas2 = document.getElementById("copyCanvas");
  		var ctx = canvas2.getContext("2d");
  		var img = new Image();
  		img.src = imgData;
  		
  		img.onload = function() {
  			ctx.drawImage(img, 50, 50);
  		};
  		
  	}
  	
  	window.addEventListener("load", function(){
  		var canvas = document.getElementById("drawCanvas2");
  		var ctx = canvas.getContext("2d");
  		var width = canvas.clientWidth;
  		var height = canvas.clientHeight;
  		
  		ctx.beginPath();
  		
  		ctx.moveTo(width*0.5, height*0.1);
  		ctx.lineTo(width*0.1, height*0.7);
  		ctx.lineTo(width*0.9, height*0.7);
  		ctx.lineTo(width*0.5, height*0.1);
  		
  		ctx.moveTo(width*0.5, height*0.9);
  		ctx.lineTo(width*0.1, height*0.3);
  		ctx.lineTo(width*0.9, height*0.3);
  		ctx.lineTo(width*0.5, height*0.9);
  		
  		ctx.stroke();
  		ctx.closePath();
  		
  		
  	}, false);
  
  </script>
  </head>
  <body>
  <h3>canvas API : Image Copy</h3>
  <img id="scream" src="../images/red_dragon1.jpeg" 
  width="220" height="277" style="display:none;">
  <canvas id="drawCanvas" width="200" height="200" style="position: relative; border: 1px solid #000;"></canvas>
  <button onclick="fromImageData();">캔버스 복사=></button>                  
  <canvas id="copyCanvas" width="300" height="300" style="position: relative; border: 1px solid #000;"></canvas>
  <hr>
  <canvas id="drawCanvas2" width="300" height="300" style="position: relative; border: 1px solid #000;"></canvas>
  </body>
  </html>
  ```



- ***Exception***

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
    <script>
      function permutation(a) {
        if(!(a instanceof Array)) {
          throw new Error(a + " is not an array");
        }
  
     	  return a;
      }
    </script>
  </head>
  <body>
    <script>
    	//permutation("ABC");
    	//x++;
    	//if( a>0 ) { a++;
    	
    	try {
    		var p = permutation(/*"abc"*/ [1,2,3,4,5]);
    		p.forEach(function(v){
    			console.log(v);
    		});
    	}
    	catch(e) {
    		alert(e);
    	}
    </script>
    
  
  </body>
  </html>
  
  ```



- innerHTML, innerText, textContent

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

  

### Exception은 책 좀 더 볼 것



- jQuery 기본 예제

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
  	/*
  	jQuery(document).ready(function(){
  		alert("ready event handler1")
  	});
  	
  	$(document).ready(function(){
  		alert("ready event handler2")
  	});
  	
  	$(function(){alert("즉시 실행될 함수")});
  	*/
  	
  	$(document).ready(function(){
  		//$('h3').css('color', 'blue').css('background', 'orange');
  		//$('*').css('color', 'blue').css('background', 'orange');
  		//$('div, p').css('color', 'blue').css('background', 'orange');
  		//$('#simple').css('color', 'blue').css('background', 'orange');
  		//$('.todo').css('color', 'blue').css('background', 'orange');
  		//$('.todo.select').css('color', 'blue').css('background', 'orange');
  		//$('body > p').css('color', 'blue').css('background', 'orange');
  		$('input[type=text]').val('Hello, jQuery..!');
  		$('input:password').css('background', 'cyan');
  		$('input:focus').css('background', 'lightgray');
  	});
  	
  	
  	
  </script>
  </head>
  <body>
  
    <h3> jQuery </h3>
    <h3 id="simple"> jQuery 는 javascript 보다 코드가 간결해서 코드량을 약 1/3로 줄여줍니다. </h3>
    <h3> jQuery 효과를 조합하면 멋진 효과를 만들 수 있습니다.</h3>
    <div class="todo"> <p>1. Lorem </p> </div>
    <p>2. Ipsum</p>
    <article class="todo select">3. Consta</article>
    <ul>
      <li>4. Melis</li>
      <li>5. Astra</li>
    </ul>
    
    text : <input type="text" /><br>
    password : <input type="password" /><br>
    e-mail : <input type="email" autofocus/><br>
    radio : <input type="radio" checked /><br>
    checkbox : <input type="checkbox" /><br>
    file : <input type="file" /><br>
    
    
  </body>
  </html>
  
  ```

  

- jQuery - eq(), nth-child()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery2</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
  	$(document).ready(function(){
  		//5초 후에 코드를 실행합니다.
  		/*
  		setTimeout(function(){
  			//변수를 선언합니다.
  			var value = $('select > option:selected').val();
  			
  			//출력합니다.
  			alert(value);
  		}, 5000);
  		*/
  		/*
  		$('tr:odd').css('background', 'orange');
  		$('tr:even').css('background', 'yellow');
  		$('tr:first').css('background', 'black').css('color', 'white');
  		
  		$('td:first').css('width', '100px').next().css('width', '70px');
  		*/
  		
  		$('tr:eq(0)').css('background', 'black').css('color', 'white');
  		$('td:nth-child(3n+1)').css('background', 'yellow');
  		$('td:nth-child(3n+2)').css('background', 'green');
  		$('td:nth-child(3n)').css('background', 'orange');
  	});
  </script>
  </head>
  <body>
  
    <select>
      <option>Apple</option>
      <option>Bag</option>
      <option>Cat</option>
      <option>Dog</option>
      <option>Elephant</option>
    </select>
    
    <hr>
    
    <table>
          <tr><th>이름</th><th>혈액형</th><th>지역</th><th>이름</th><th>혈액형</th><th>지역</th></tr>
          <tr><td>강민수</td><td>AB형</td><td>서울특별시 송파구</td><td>강민수</td><td>AB형</td><td>서울특별시 송파구</td></tr>
          <tr><td>구지연</td><td>B형</td><td>미국 캘리포니아</td>
  		<td>구지연</td><td>B형</td><td>미국 캘리포니아</td></tr>
          <tr><td>김미화</td><td>AB형</td><td>미국 메사추세츠</td>
  		<td>김미화</td><td>AB형</td><td>미국 메사추세츠</td></tr>
          <tr><td>김선화</td><td>O형</td><td>서울 강서구</td>
  		<td>김선화</td><td>O형</td><td>서울 강서구</td></tr>
          <tr><td>남기주</td><td>A형</td><td>서울 노량진구</td><td>남기주</td><td>A형</td><td>서울 노량진구</td></tr>
          <tr><td>윤하린</td><td>B형</td><td>서울 용산구</td>
  		<td>윤하린</td><td>B형</td><td>서울 용산구</td></tr>
      </table>
    
    
  </body>
  </html>
  ```

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



------

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



- Event 3  - preventDefault()

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



- Event 4 - keyup()

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
  		$('textarea').keyup(function(){
  			var inputLength = $(this).val().length;
  			var remain = 150 - inputLength;
  			
  			$('h1').html(remain);
  			
  			if(remain >= 0) {
  				$('h1').css('color', 'black');
  			}
  			else {
  				$('h1').css('color', 'red');
  			}
  		});
  	});
  </script>
  </head>
  <body>
    <div>
      <p>아무 생각 없다</p>
      <h1>150</h1>
      <textarea cols="70" rows="5"></textarea>
    </div>
  </body>
  </html>
  
  ```



- Event 5 - scroll()

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
  		var n = 0;
  		for(var i = 0; i < 20; i++) {
  			$('<h1>Infinity Scroll ' + n++ + '</h1>').appendTo('body');
  		}
  		
  		$(window).scroll(function(){
  			var scrollHeight = $(window).scrollTop() + $(window).height();
  			var documentHeight = $(document).height();
  			
  			if(scrollHeight == documentHeight) {
  				for(var i = 0; i < 10; i++) {
  					$('<h1>Infinity Scroll ' + n++ + '</h1>').appendTo('body');
  				}
  			}
  		});
  	});
  </script>
  </head>
  <body>
    
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

  

- Effect 2 - animate()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
    div{ 
      width:50px;
      height:50px;
      background:orange;
      position:relative;
    }
  </style>
  <script>
  	
  	$(document).ready(function(){
  		/*
  		$('div').hover(function(){
  			$(this).animate({left:500}, 'slow');
  		}, function() {
  			$(this).animate({left:0}, 'slow');
  		});
  		*/
  		
  		$('div').click(function(){
  			var width = $(this).css('width');
  			var height = $(this).css('height');
  			
  			$(this).animate({
  				width: parseInt(width)+50,
  				height: parseInt(height)+50
  			}, 'slow');
  		});
  	});
  </script>
  </head>
  <body>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
  </body>
  </html>
  
  ```



- Effect 3 - animate() 2

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
    div{ 
      width:50px;
      height:50px;
      background:orange;
      position:relative;
    }
  </style>
  <script>
  	
  	$(document).ready(function(){
  		$('button').click(function(){
  			var html = $(this).html();
  			var evalText = "$('div')." + html;
  			
  			eval(evalText);
  		});
  		
  		$('div').animate({
  			left: '500'
  		}, 5000).animate({
  			left: '0'
  		}, 5000);
  	});
  </script>
  </head>
  <body>
    <button>stop()</button>
    <button>stop(true)</button>
    <button>stop(false, true)</button>
    <button>stop(true, true)</button>
    <div></div>
  </body>
  </html>
  
  ```



- Effect 4 - dealy()

  ```html
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>jQuery </title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <style>
    div{ 
      width:50px;
      height:50px;
      background:orange;
      position:relative;
    }
  </style>
  <script>
  	
  	$(document).ready(function(){
  		$('div').each(function(index){
  			$(this).delay(index * 500).animate({
  				left: 500
  			}, 'slow');
  		});
  	});
  </script>
  </head>
  <body>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
    <div></div>
  </body>
  </html>
  
  ```

  

### AJAX

> Asynchronous Javascript And XML

- 비동기통신
- XMLHttpRequest 객체 이용
- DOM을 이용한 웹 페이지 동적(and 필요시 부분적)  갱신
- 최소한의 데이터 통신만 하므로 처리속도 빠름(서버 부하와 통신 트래픽 부하가 적다).
- 웹페이지 갱신을 클라이언트 측이 담당. 페이지를 전환하는 대신에 페이지 일부분만 변경하므로 고속 렌더링이 가능



##### 예제 1

***ajax1.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax처리 1</title>
<script>
	window.onload = function(){
		
		var req = new XMLHttpRequest(); 		//1. XMLHttpRequest
		
		req.onloadstart = function(){
			console.log("loadstart : 요청을 보낼 때");
		}
		
		req.onload = function(){
			console.log("load : 요청 성공, 응답 가져올 수 있을 때");
		}
		
		req.onloadend = function(){
			console.log("onloadend : 요청 완료");
		}
		
		req.onprogress = function(){
			console.log("onprogress : 데이터를 주고 받을 때");
		}
		
		req.onreadystatechange = function(){
			if(req.readyState == 4) {
				if(req.status == 200) {
					document.getElementById("view").innerHTML = req.responseText;
				}
			}
		}
		
		req.open("GET", "data.txt"); 	//2.  요청 보낼 준비
		req.send(null); 						//3. 요청 보냄
		
			
	}
	
</script>
</head>
<body>
<p id="view"></p>
</body>
</html>
```



##### 예제 2

***ajax2.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
	<title>ajax 처리 2</title>
	<style>
		.image_panel{
			border:1px solid eeeeee;
			text-align:center;
			margin:5px;
		}
		.image_panel .title{
			font-size:9pt;
			color:#ff0000;
			
		}
		
	</style>
	 
	<script src="javascript/ajax_json.js?111"></script>	
    <script>
    	
    </script> 
</head>

<body>
	<div>
		<button id="btn_load">이미지 읽어들이기</button>
	</div>
	<div id="image_container">
		<!-- 1. 이곳에 이미지를 넣어주세요-->
	</div>
	
	<!-- 2. 이 내용은 이미지 패널 템플릿입니다. -->
	<div style="display:none;" id="image_panel_template">
		<div class="image_panel">
			<img >
			<p class="title"></p>
		</div>
	</div>
</body>
</html>

```



***ajax_jason.js***

```javascript
/**
 * 
 */
var req;
window.onload = function(){
		
	document.querySelector("#btn_load").onclick = function(){
		req = new XMLHttpRequest();
		req.onreadystatechange = createImages;
		var url = "images.jsp";
		req.open("GET", url, "true");
		req.send(null);
		
	}
}

function createImages() {
	if(req.readyState == 4) {
		if(req.status == 200) {
			var obj = JSON.parse(req.responseText);
			var images = obj["rows"];
			//console.log(images);
			var strDOM = "";
			for(var i=0; i<images.length;i++) {
				var image = images[i];
				strDOM += '<div class="image_panel">';
				strDOM += '	<img src="' + image.url + '">';
				strDOM += '	<p class="title">' + image.title + '</p>';
				strDOM += '</div>';
			}
			document.querySelector("#image_container").innerHTML = strDOM;
		}
		else {
			alert("처리중 에러가 발생했습니다.");
		}
	}
}
```



***images.jsp***

```jsp
<%@ page contentType="text/plain; charset=utf-8"
  pageEncoding="utf-8"%>
{"rows":[
  {"title":"이미지1","url":"images/img1.jpg"},
  {"title":"이미지2","url":"images/img2.jpg"},
  {"title":"이미지4","url":"images/img4.jpg"},
  {"title":"이미지5","url":"images/img5.jpg"},
  {"title":"이미지3","url":"images/img3.jpg"},
  {"title":"이미지6","url":"images/img6.jpg"},
  {"title":"이미지7","url":"images/img7.jpg"},
  {"title":"이미지8","url":"images/img8.jpg"},
  {"title":"이미지10","url":"images/img10.jpg"}
]}
```



##### 예제 3

***ajax3.html***

```html
<!DOCTYPE html>
<html>
  <head>
    <meta  charset="utf-8">
    <title>부분페이지 동적 갱신</title>     
    <link rel="stylesheet" href="css/partPage.css" type="text/css" />
    <script src="javascript/partPage.js"></script>
  </head>
  <body>
    <h3>부분페이지 갱신, POST요청, XML응답처리</h3>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>우리회사</b></font></td></tr>
      <tr>
         <td><form action="#">
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" id="userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" id="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="button" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
         <td width="400"><img src="images/dog.jpg"></td>
      </tr>
      <tr><td colspan="2" align="center">찾아오시는길 |회사소개|정보보호정책</td></tr>
    </table>
  </body>
</html>
```



***partPage.js***

```javascript
/**
 * 
 */
var req;
window.onload = function(){
	req = new XMLHttpRequest();
	document.querySelector("#login").onclick = startMethod;
}

function startMethod(){
	var uid = document.getElementById("userid").value;
	var upwd = document.getElementById("userpwd").value;
	var url = "partLogin.jsp";
	req.onreadystatechange = resultProcess;
	req.open("post", url, "true");
	req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	req.send("userid="+uid+"&userpwd="+upwd);
}

function resultProcess(){
	if(req.readyState == 4) {
		if(req.status == 200) {
			confirmedProcess();
		}
	}
}

function confirmedProcess(){
	var result =req.responseXML.getElementsByTagName("result")[0].firstChild.data;
    var name = req.responseXML.getElementsByTagName("id")[0].firstChild.data;
     
    if (result == 1){//사용자 인증성공시
      var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
      str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"
    	  document.getElementById("confirmed").innerHTML = str;
    }else if(result==0){//사용자 인증실패시 - 비밀번호가 틀림
      alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value=name;
      document.getElementById("userpwd").value="";
      document.getElementById("userpwd").focus();
    }else{//사용자 인증실패시 - 아이디가가 틀림
      alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value="";
      document.getElementById("userpwd").value="";
      document.getElementById("userid").focus();
    }
}

function logoutMethod() {
	window.location.reload();
}

```



***partLogin.jsp***

```jsp
<%@ page   contentType="text/xml; charset=utf-8"     %>
<%
    request.setCharacterEncoding("utf-8"); 
    //반드시 응답되는 내용의  Content-type을 "text/xml;charset=utf-8"해야함, 생략시 결과가 표시되지 않을 수 있음
   // response.setContentType("text/xml;charset=utf-8");//응답되는 내용의 Content-type을 설정

    String outString = ""; // 요청한 페이지인 partPageDBUse.js로 리턴할  결과를 저장
    int result = 0 ;
    String id = request.getParameter("userid"); 
    String passwd = request.getParameter("userpwd"); 
     
    if(id.equals("admin")&&passwd.equals("1234")){
    	result = 1;
    }else if(id.equals("admin")){
    	result = 0;
    }else{
    	result = 2;
    }
     
    
    //userCheck()메소드의 수행후 리턴되는 결과 값에 따라 처리
    if(result==1){//사용자 인증에 성공시
		session.setAttribute("id",id);
		outString="<response><result>"+ result + "</result><id>"+ id 
				+"</id></response>";
	}else if(result==0){//사용자 인증에 실패시 - 비밀번호 틀림
		outString="<response><result>"+ result + "</result><id>"+ id 
		+"</id></response>";
    }else{//사용자 인증에 실패시 - 아이디 틀림
    	outString="<response><result>"+ result + "</result><id>"+ id 
    	+"</id></response>";
    }	
    
    out.println(outString); // outString의 내용을 요청한 페이지인 partPageDBUse.js로 응답함
    
%>
```



***partPage.css***

```css
@CHARSET "utf-8";
div#confirmed{
  width            : 250px;
  height           : 100px;
  background-color : #e0ffff;
  border-color     : #b0e0e6;
  border-style     : dotted;
}
```



### 크로스 오리진 통신

#### 예제 1

***cross1.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cross1</title>
<script>

	var name;
	var price;
	
	function show(data) {
		console.log("name: " + data.name);
		console.log("price: " + data.price);
		
		document.body.innerHTML += "name:" + data.name + "<br>";
		document.body.innerHTML += "price:" + data.price;
		
	}
	
	window.onload = function(){
		var url = "http://70.12.50.130:9000/jsonp.js";
		var script = document.createElement("script");
		script.setAttribute("src", url);
		document.getElementsByTagName("head")[0].appendChild(script);
	}
</script>
</head>
<body>

</body>
</html>

```



#### 예제 2

***cross2.html***

```html
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Communication API 예제(window.postMessage())</title>
<script type="text/javascript">
	window.onload = function(){
		setInterval(Send, 1000);
	}

	function Send() {
		var ifrm = document.getElementById("ifrm");
		var MyOrigin = location.protocol + "//" + location.host;
		var date = new Date();
		var dateStr = date.getFullYear() + "/" + (date.getMonth()+1) +
			"/" + date.getDate() + " " + date.getHours() + ":" +
			date.getMinutes() + " " + date.getSeconds();
		var number = Math.floor(Math.random() * 100);
		
		ifrm.contentWindow.postMessage({date:dateStr, number:number},
				"http://70.12.50.130:9000"
				//"http://70.12.50.140:8080"
		);
		document.getElementById("msg").innerHTML = dateStr + " 생성된 값은 '"
			+ number + "' 입니다. <br> MyOrigin : " + MyOrigin;
		;
	}

</script>
</head>
<body>
  <div id = "msg">8080<br>MyOrigin</div>
  
  <iframe id="ifrm" src="http://70.12.50.130:9000/receive.html"
    width=500 height=200></iframe>
   
   <!-- 
   <iframe id="ifrm" src="http://70.12.50.140:8080/Javascript-test/190625/receive.html"
    width=500 height=200></iframe>
   -->
</body>
</html>

```



***receive.html***

```html
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>Communication API 예제</title>
<script>
var MyOrigin = location.origin;
   console.log("receive.html: " + MyOrigin);
    window.addEventListener("message", function(e){
    	console.log("from : " + e.origin);
    	if(e.origin==MyOrigin) {
        	document.getElementById("msg").innerHTML = 
        		"e.origin : " + e.origin + " <br/> " + e.data.date 
        		+ " : 송신된 값은 " + e.data.number + " 입니다.";
         }
    }, false);
</script>
</head>
<body>
강사 서버 도메인 : http://70.12.50.130:9000 <br>
<div id = "msg">
	
</div>    
</body>
</html>

```



### jQuery Ajax

#### 예제 1

***jqueryajax.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
	$.ajax({
		url : "data.txt",
		success : function(data) {
			$('#view').html(data);
		}
	});
	
		
});

</script>
</head>
<body>
  <p id="view"></p>
</body>
</html>

```



#### 예제2

***jqueryajax2.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
<title>ajax 처리 2</title>
<style>
	.image_panel{
		border:1px solid eeeeee;
		text-align:center;
		margin:5px;
	}
	.image_panel .title{
		font-size:9pt;
		color:#ff0000;
		
	}
	
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function(){
		$("#btn_load").click(function(){
			$.getJSON("images.jsp", null, createImages);
		});
	});
	
	function createImages(data) {
		
		var images = data.rows;
		var strDOM = "";
		for(var i=0; i<images.length;i++) {
			var image = images[i];
			strDOM += '<div class="image_panel">';
			strDOM += '	<img src="' + image.url + '">';
			strDOM += '	<p class="title">' + image.title + '</p>';
			strDOM += '</div>';
		}
		
		var $imageContainer = $("#image_container");
		$imageContainer.append(strDOM);
		
		
		$(document).ajaxComplete(function(){
			console.log("ajax event: complete");
		});
		
		$(document).ajaxSend(function(){
			console.log("ajax event: send");
		});
		
		$(document).ajaxStart(function(){
			console.log("ajax event: start");
		});
		
		$(document).ajaxSuccess(function(){
			console.log("ajax event: success");
		});
	}
</script> 
</head>

<body>
	<div>
		<button id="btn_load">이미지 읽어들이기</button>
	</div>
	<div id="image_container">
		<!-- 1. 이곳에 이미지를 넣어주세요-->
	</div>
	
	<!-- 2. 이 내용은 이미지 패널 템플릿입니다. -->
	<div style="display:none;" id="image_panel_template">
		<div class="image_panel">
			<img >
			<p class="title"></p>
		</div>
	</div>
</body>
</html>

```



#### 예제 4

***jqueryajax3.html***

```html
<!DOCTYPE html>
<html>
  <head>
    <meta  charset="utf-8">
    <title>부분페이지 동적 갱신</title>     
    <link rel="stylesheet" href="css/partPage.css" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- 
    <script src="javascript/partPage.js"></script>
     -->
    <script>
    	$(document).ready(function(){
    		$('#login').click(startMethod);
    	});
    	
    	
    	function startMethod() {
    		var uid = $('#userid').val();
    		var upwd = $('#userpwd').val();
    		
    		$.ajax({
    			url : "partLogin.jsp",
    			type : "post",
    			data : {
    				'userid' : uid,
    				'userpwd' : upwd
    			},
    			success : resultProcess
    		});
    	}
    	
    	function resultProcess(data){
    		console.log(data);
    		
    		var result = $(data).find('result').text();
    		var name = $(data).find('id').text();
    		
    		if(result == 1) {
    			var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
      	      	str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"
      	    	$("#confirmed").html(str);
    		}
    		else if(result == 0) {
    			alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      	      	$("#userid").val(name);
      	      	$("#userpwd").val("");
      	      	$("#userpwd").focus();
    		}
    		else {
    			alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
  		      	$("#userid").val("");
  		      	$("#userpwd").val("");
  		      	$("#userid").focus();
    		}
    	}
    	
    	function logoutMethod() {
    		location.reload();
    	}
    	
    	
    	
    </script>
  </head>
  <body>
    <h3>부분페이지 갱신, POST요청, XML응답처리</h3>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>우리회사</b></font></td></tr>
      <tr>
         <td><form action="#">
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" id="userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" id="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="button" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
         <td width="400"><img src="images/dog.jpg"></td>
      </tr>
      <tr><td colspan="2" align="center">찾아오시는길 |회사소개|정보보호정책</td></tr>
    </table>
  </body>
</html>

```




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

### 객체

- 자바 스크립트 객체 생성 방법
  - 객체 리터럴
    - JSON 등
    - 특정 객체를 한 번만 생성해서 사용하는 경우
  - 생성자 함수:
    -  new 키워드 사용
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


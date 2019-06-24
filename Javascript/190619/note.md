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

  





// 1. function 키워드 생략
const greeging1 = (name) => {
  return 'hello #{name}';
}

// 2. 인자가 1개인 경우 괄호도 생략 가능
const greegin2 = name => {
  return 'hello #{name}';
}

// 3. body 표현식이 1줄 인 경우 괄호와 리턴도 생략 가능
const greeting3 = name => 'hello #{name}';


// 실습
// => 화살표 함수로 변환시켜 보자.
let square = function(num) {
  return num;
}

let square2 = num => num**2;


// object 형식으로 변환된다면?
// #1. 
let returnObject = () => {
  return {key: 'value'};
}
// #2.
let returnObj = () => ({key: 'value'})


// 인자에 기본값을 설정했을 경우
let sayHi = function(name="pengsu") {
  return 'hi ${name}'
}
let sayHi2 = (name="pengsu") => 'hi ${name}';


// 즉시 실행 함수
const cube = function(num) {
  return num ** 3;
}
 
// -> 
console.log(function(num){ return num ** 3; }(2));


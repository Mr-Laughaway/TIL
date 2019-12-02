// 벼열에 모든 요소에 2를 곱하여 새로운 배열로 만들기.
// before
var nubmers = [1, 2, 3]
var doubleNumbers = []


// map 사용
let NUMBERS = [2, 4, 6]
let doubleNum = []

doubleNum = NUMBERS.map(function(num) {
  return num*2;
});

doubleNum = NUMBERS.map(num => num*2);

console.log(NUMBERS);
console.log(doubleNum);


// 실습 # 1
// 숫자가 담긴 배열을 받아서
// 각 숫자들의 제곱근이 들어있는 새 배열로 만들어 보자.
const newNum = [4, 9, 16];

const roots = newNum.map(num => num ** 0.5);
console.log(roots);


// 실습 # 2
// IMAGES 배열 안에 objectemfdml height만 들어잇는 배열을 만들어보자.
const IMAGES = [
  {height: '34px', width: '39px'},
  {height: '54px', width: '22px'},
  {height: '48px', width: '22px'},
];

const heights = IMAGES.map(image => image.height);
console.log(heights);


// 실습 # 3
// { name: brand, movie: 영화 }
const brands = ["Marble", "DC"]
const movies = ["Avengers", "Batman"]

const aaa = brands.map(function(brand, i){
  return {name: brand, movie: movies[i]}
});

const bbb = brands.map( (brand, i) => ({name: brand, movie: movies[i]}))

console.log(aaa);
console.log(bbb);

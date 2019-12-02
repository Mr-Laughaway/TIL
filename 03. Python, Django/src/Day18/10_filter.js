const PRODUCTS = [
  { name: 'cucumber', type: 'vegetable'},
  { name: 'banana', type: 'fruit'},
  { name: 'carrot', type: 'vegetable'},
  { name: 'apple', type: 'fruit'},
]

const R1 = PRODUCTS.filter(p => p.type === 'fruit');
console.log(R1);


// 실습 # 1
const TestResults = [90, 85, 70, 78, 58, 86, 99, 82]
const R2 = TestResults.filter(val => val >= 80);
console.log(R2);

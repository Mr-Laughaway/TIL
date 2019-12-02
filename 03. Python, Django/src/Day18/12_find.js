let heros = [
  { name: 'Tony Stark', age: 45 },
  { name: 'Captain Ame', age: 82 },
  { name: 'Thor', age: 1500 },
  { name: 'Tony Stark', age: 25 },
]


const R = heros.find(hero => hero.name === 'Tony Stark');
console.log(R);


// 실습 # 1
// 잔액이 20000원 이상인 사람의 이름
const ACCOUNTS = [
  {name: "pengsu", money: 1200},
  {name: "bbung", money: 24000},
  {name: "pororo", money: 50000}
];

const R1 = ACCOUNTS.find( p => p.money >= 20000);
console.log(R1.name);

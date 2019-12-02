const NUMBERS = [1, 2, 3, 4, 5]

const result = NUMBERS.some(function(elem){
  return elem % 2 === 0;
});
console.log(result);

const every_result = NUMBERS.every(function(elem){
  return elem %2 === 0;
});

console.log(every_result);

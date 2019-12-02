const numbers = [1, 2, 3, 4, 5, 6, 7];
// console.log(numbers[1]);
// console.log(numbers.reverse()[0]);


numbers.push('펭');
console.log(numbers);
console.log(numbers.push('su'));

// pop
console.log(numbers.pop());

// unshift 
console.log(numbers.unshift("pengsu"));
console.log(numbers);

// shift
console.log(numbers.shift());
console.log(numbers);


// includes
console.log(numbers.includes(1))
console.log(numbers.includes(0))

// indexof
console.log(numbers.indexOf(1))
console.log(numbers.indexOf(0))

numbers.unshift(1);
console.log(numbers.indexOf(1))

// join
console.log(numbers.join('-'))
console.log(numbers.join())
console.log(numbers.join(''))

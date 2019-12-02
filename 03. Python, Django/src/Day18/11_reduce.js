const numbers = [1, 2, 3, 4,]

const R1 = numbers.reduce(function(total, num){
  return total += num;
}, 0);

const R2 = numbers.reduce( (total, num) => total += num, 0);
console.log(R1);
console.log(R2);

// 실습 # 1
// 평균 구하기
const TestResults = [90, 85, 70, 78, 58, 86, 99, 82]
const R3 = TestResults.reduce((tot, n) => tot += n, 0) / TestResults.length;
console.log(R3);


// 실습 # 2
// [{이름: 중복 횟수}, { 이름: 중복횟수}] 로 바꿔보기
const names = ['pengsu', 'bbung', 'pororo', 'bbung', 'bungaeman', 'pengsu']
const R4 = names.reduce( (allNames, name) => {
  if (name in allNames) {
    allNames[name] += 1;
  }
  else {
    allNames[name] = 1;
  }

  return allNames;
}, {});

console.log(R4);


var books = ['Learning JS', 'Learning Django']
var comics = {
  DC: ['AquaMan', 'SuperMan'],
  Marvel: ['IronMan', 'AntMan']
}
var magazines = null;

// Before
// var bookShop = {
//   books: books,
//   comics: comics,
//   magazines: magazines
// }

// console.log(bookShop);
// console.log(typeof bookShop);
// console.log(bookShop.books[0]);

// After
// 이름이 같으면 값만 넣으면 된다.
let bookShop = {
  books,
  comics,
  magazines
}
console.log(bookShop);
console.log(typeof bookShop);
console.log(bookShop.books[0]);



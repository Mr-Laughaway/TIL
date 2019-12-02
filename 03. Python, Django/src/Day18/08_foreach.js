// 예전
var colors = ['red', 'orange', 'yellow']
for (var i = 0; i < colors.length; i++) {
  console.log(colors[i]);
}

colors.forEach(function(color){
  console.log(color);
});

colors.forEach(color => console.log(color))


// 실습 -----------------------------------------------------------------------
// # 1
function handlePosts() {
  const posts = [
    {
      id: 23,
      title: "오늘의 뉴스"
    },
    {
      id: 34,
      title: "오늘의 스포츠"
    },
    {
      id:78,
      title: "오늘의 연예"
    }
  ];

  // 기존 방법
  // for(let i = 0; i < posts.length; i++) {
  //   console.log(posts[i]);
  //   console.log(posts[i].id);
  //   console.log(posts[i].title);
  // }

  // forEach 사용
  posts.forEach(elem => {
    console.log(elem);
    console.log(elem.id);
    console.log(elem.title);
  });
}

handlePosts();

// # 2.
// image 배열 안에 있느 정보를 가지고
// 넓이를 구하고 그 값을 areas에 저장해보자.
const IMAGES = [
  {height:10, width:30},
  {height:22, width:37},
  {height:54, width:42},
]

let areas = []
IMAGES.forEach(obj => areas.push(obj.height * obj.width))
console.log(areas);


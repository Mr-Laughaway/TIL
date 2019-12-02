const userName = prompt("이름이 뭐냐?")
let message;

if (userName === "점심")
  message = "곧 점심";
else if (userName === "저녁")
  message = "아직 멀었";
else 
  message = "<h1>어서오세요... $(userName)</h1>"

document.write(message);

### AJAX

> Asynchronous Javascript And XML

- 비동기통신
- XMLHttpRequest 객체 이용
- DOM을 이용한 웹 페이지 동적(and 필요시 부분적)  갱신
- 최소한의 데이터 통신만 하므로 처리속도 빠름(서버 부하와 통신 트래픽 부하가 적다).
- 웹페이지 갱신을 클라이언트 측이 담당. 페이지를 전환하는 대신에 페이지 일부분만 변경하므로 고속 렌더링이 가능



##### 예제 1

***ajax1.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax처리 1</title>
<script>
	window.onload = function(){
		
		var req = new XMLHttpRequest(); 		//1. XMLHttpRequest
		
		req.onloadstart = function(){
			console.log("loadstart : 요청을 보낼 때");
		}
		
		req.onload = function(){
			console.log("load : 요청 성공, 응답 가져올 수 있을 때");
		}
		
		req.onloadend = function(){
			console.log("onloadend : 요청 완료");
		}
		
		req.onprogress = function(){
			console.log("onprogress : 데이터를 주고 받을 때");
		}
		
		req.onreadystatechange = function(){
			if(req.readyState == 4) {
				if(req.status == 200) {
					document.getElementById("view").innerHTML = req.responseText;
				}
			}
		}
		
		req.open("GET", "data.txt"); 	//2.  요청 보낼 준비
		req.send(null); 						//3. 요청 보냄
		
			
	}
	
</script>
</head>
<body>
<p id="view"></p>
</body>
</html>
```



##### 예제 2

***ajax2.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta  charset="UTF-8">
	<title>ajax 처리 2</title>
	<style>
		.image_panel{
			border:1px solid eeeeee;
			text-align:center;
			margin:5px;
		}
		.image_panel .title{
			font-size:9pt;
			color:#ff0000;
			
		}
		
	</style>
	 
	<script src="javascript/ajax_json.js?111"></script>	
    <script>
    	
    </script> 
</head>

<body>
	<div>
		<button id="btn_load">이미지 읽어들이기</button>
	</div>
	<div id="image_container">
		<!-- 1. 이곳에 이미지를 넣어주세요-->
	</div>
	
	<!-- 2. 이 내용은 이미지 패널 템플릿입니다. -->
	<div style="display:none;" id="image_panel_template">
		<div class="image_panel">
			<img >
			<p class="title"></p>
		</div>
	</div>
</body>
</html>

```



***ajax_jason.js***

```javascript
/**
 * 
 */
var req;
window.onload = function(){
		
	document.querySelector("#btn_load").onclick = function(){
		req = new XMLHttpRequest();
		req.onreadystatechange = createImages;
		var url = "images.jsp";
		req.open("GET", url, "true");
		req.send(null);
		
	}
}

function createImages() {
	if(req.readyState == 4) {
		if(req.status == 200) {
			var obj = JSON.parse(req.responseText);
			var images = obj["rows"];
			//console.log(images);
			var strDOM = "";
			for(var i=0; i<images.length;i++) {
				var image = images[i];
				strDOM += '<div class="image_panel">';
				strDOM += '	<img src="' + image.url + '">';
				strDOM += '	<p class="title">' + image.title + '</p>';
				strDOM += '</div>';
			}
			document.querySelector("#image_container").innerHTML = strDOM;
		}
		else {
			alert("처리중 에러가 발생했습니다.");
		}
	}
}
```



***images.jsp***

```jsp
<%@ page contentType="text/plain; charset=utf-8"
  pageEncoding="utf-8"%>
{"rows":[
  {"title":"이미지1","url":"images/img1.jpg"},
  {"title":"이미지2","url":"images/img2.jpg"},
  {"title":"이미지4","url":"images/img4.jpg"},
  {"title":"이미지5","url":"images/img5.jpg"},
  {"title":"이미지3","url":"images/img3.jpg"},
  {"title":"이미지6","url":"images/img6.jpg"},
  {"title":"이미지7","url":"images/img7.jpg"},
  {"title":"이미지8","url":"images/img8.jpg"},
  {"title":"이미지10","url":"images/img10.jpg"}
]}
```



##### 예제 3

***ajax3.html***

```html
<!DOCTYPE html>
<html>
  <head>
    <meta  charset="utf-8">
    <title>부분페이지 동적 갱신</title>     
    <link rel="stylesheet" href="css/partPage.css" type="text/css" />
    <script src="javascript/partPage.js"></script>
  </head>
  <body>
    <h3>부분페이지 갱신, POST요청, XML응답처리</h3>
    <table border="1">
      <tr><td colspan="2" align="center"><font size=15><b>우리회사</b></font></td></tr>
      <tr>
         <td><form action="#">
               <div id="confirmed">
                 <table>
                    <tr>
                      <td>아이디</td>
                      <td><input type="text" id="userid" size="15" maxlength="12"/></td>
                    </tr>
                    <tr>
                      <td>비밀번호</td>
                      <td><input type="password" id="userpwd" size="15" maxlength="12"/></td>
                    </tr>
                    <tr><td colspan="2" align="center">
                        <input type="button" id="login" value="로그인" /></td>
                    </tr>
                </table>
              </div>
             </form>
         </td>
         <td width="400"><img src="images/dog.jpg"></td>
      </tr>
      <tr><td colspan="2" align="center">찾아오시는길 |회사소개|정보보호정책</td></tr>
    </table>
  </body>
</html>
```



***partPage.js***

```javascript
/**
 * 
 */
var req;
window.onload = function(){
	req = new XMLHttpRequest();
	document.querySelector("#login").onclick = startMethod;
}

function startMethod(){
	var uid = document.getElementById("userid").value;
	var upwd = document.getElementById("userpwd").value;
	var url = "partLogin.jsp";
	req.onreadystatechange = resultProcess;
	req.open("post", url, "true");
	req.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	req.send("userid="+uid+"&userpwd="+upwd);
}

function resultProcess(){
	if(req.readyState == 4) {
		if(req.status == 200) {
			confirmedProcess();
		}
	}
}

function confirmedProcess(){
	var result =req.responseXML.getElementsByTagName("result")[0].firstChild.data;
    var name = req.responseXML.getElementsByTagName("id")[0].firstChild.data;
     
    if (result == 1){//사용자 인증성공시
      var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
      str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"
    	  document.getElementById("confirmed").innerHTML = str;
    }else if(result==0){//사용자 인증실패시 - 비밀번호가 틀림
      alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value=name;
      document.getElementById("userpwd").value="";
      document.getElementById("userpwd").focus();
    }else{//사용자 인증실패시 - 아이디가가 틀림
      alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value="";
      document.getElementById("userpwd").value="";
      document.getElementById("userid").focus();
    }
}

function logoutMethod() {
	window.location.reload();
}

```



***partLogin.jsp***

```jsp
<%@ page   contentType="text/xml; charset=utf-8"     %>
<%
    request.setCharacterEncoding("utf-8"); 
    //반드시 응답되는 내용의  Content-type을 "text/xml;charset=utf-8"해야함, 생략시 결과가 표시되지 않을 수 있음
   // response.setContentType("text/xml;charset=utf-8");//응답되는 내용의 Content-type을 설정

    String outString = ""; // 요청한 페이지인 partPageDBUse.js로 리턴할  결과를 저장
    int result = 0 ;
    String id = request.getParameter("userid"); 
    String passwd = request.getParameter("userpwd"); 
     
    if(id.equals("admin")&&passwd.equals("1234")){
    	result = 1;
    }else if(id.equals("admin")){
    	result = 0;
    }else{
    	result = 2;
    }
     
    
    //userCheck()메소드의 수행후 리턴되는 결과 값에 따라 처리
    if(result==1){//사용자 인증에 성공시
		session.setAttribute("id",id);
		outString="<response><result>"+ result + "</result><id>"+ id 
				+"</id></response>";
	}else if(result==0){//사용자 인증에 실패시 - 비밀번호 틀림
		outString="<response><result>"+ result + "</result><id>"+ id 
		+"</id></response>";
    }else{//사용자 인증에 실패시 - 아이디 틀림
    	outString="<response><result>"+ result + "</result><id>"+ id 
    	+"</id></response>";
    }	
    
    out.println(outString); // outString의 내용을 요청한 페이지인 partPageDBUse.js로 응답함
    
%>
```



***partPage.css***

```css
@CHARSET "utf-8";
div#confirmed{
  width            : 250px;
  height           : 100px;
  background-color : #e0ffff;
  border-color     : #b0e0e6;
  border-style     : dotted;
}
```



### 크로스 오리진 통신

#### 예제 1

***cross1.html***

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cross1</title>
<script>

	var name;
	var price;
	
	function show(data) {
		console.log("name: " + data.name);
		console.log("price: " + data.price);
		
		document.body.innerHTML += "name:" + data.name + "<br>";
		document.body.innerHTML += "price:" + data.price;
		
	}
	
	window.onload = function(){
		var url = "http://70.12.50.130:9000/jsonp.js";
		var script = document.createElement("script");
		script.setAttribute("src", url);
		document.getElementsByTagName("head")[0].appendChild(script);
	}
</script>
</head>
<body>

</body>
</html>
```



#### 예제 2

***cross2.html***

```html
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Communication API 예제(window.postMessage())</title>
<script type="text/javascript">
	window.onload = function(){
		setInterval(Send, 1000);
	}

	function Send() {
		var ifrm = document.getElementById("ifrm");
		var MyOrigin = location.protocol + "//" + location.host;
		var date = new Date();
		var dateStr = date.getFullYear() + "/" + (date.getMonth()+1) +
			"/" + date.getDate() + " " + date.getHours() + ":" +
			date.getMinutes() + " " + date.getSeconds();
		var number = Math.floor(Math.random() * 100);
		
		ifrm.contentWindow.postMessage({date:dateStr, number:number},
				"http://70.12.50.130:9000"
				//"http://70.12.50.140:8080"
		);
		document.getElementById("msg").innerHTML = dateStr + " 생성된 값은 '"
			+ number + "' 입니다. <br> MyOrigin : " + MyOrigin;
		;
	}

</script>
</head>
<body>
  <div id = "msg">8080<br>MyOrigin</div>
  
  <iframe id="ifrm" src="http://70.12.50.130:9000/receive.html"
    width=500 height=200></iframe>
   
   <!-- 
   <iframe id="ifrm" src="http://70.12.50.140:8080/Javascript-test/190625/receive.html"
    width=500 height=200></iframe>
   -->
</body>
</html>
```



***receive.html***

```html
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<title>Communication API 예제</title>
<script>
var MyOrigin = location.origin;
   console.log("receive.html: " + MyOrigin);
    window.addEventListener("message", function(e){
    	console.log("from : " + e.origin);
    	if(e.origin==MyOrigin) {
        	document.getElementById("msg").innerHTML = 
        		"e.origin : " + e.origin + " <br/> " + e.data.date 
        		+ " : 송신된 값은 " + e.data.number + " 입니다.";
         }
    }, false);
</script>
</head>
<body>
강사 서버 도메인 : http://70.12.50.130:9000 <br>
<div id = "msg">
	
</div>    
</body>
</html>
```




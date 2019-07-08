<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html><head><title>게시판 글 수정</title></head>
<link href="css/mystyle.css" rel="stylesheet" type="text/css">
<body>

<c:if test='${empty user }'>
<div style='text-align:right'>
<a href="./login.jsp" style="font-size:small">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="./member.jsp" style="font-size:small">회원가입</a> &nbsp;&nbsp;&nbsp;&nbsp;
</div>
</c:if>
<c:if test='${not empty user }'>
<div style='text-align:right'>
${user.username}(${user.userid})님 로그인 중 &nbsp;&nbsp;&nbsp;&nbsp;
<a href="./member_edit.jsp">회원 정보 수정</a>
</div>
</c:if>

<h3 id="header">게시판 글 수정</h3>
<div id='menu'>
<%@ include file="mymenu.jsp" %>
</div>
<div id="main">
<form method='post' action='update.do'>
 
 
<table width='100%'>
 
 
<tr><td>제목</td><td>
   <input type='text' name='subject' value='${article.subject}'>
</td></tr>
 
  <tr><td>이름</td><td>
    <input type='text' name='writer' value='${article.writer}'>
  </td></tr>
  <tr><td>암호</td><td>
    <input type='password' name='password' value='${article.password}'>
  </td></tr>
  <tr><td>Email</td><td>
   <input type='text' name='email' value='${article.email}'></td>
  </tr>  
 
<tr><td>내용</td><td>
  <textarea cols='65' name='contents' 
            rows='20'>${article.contents}</textarea>
</td></tr>
<tr><td colspan='2' align='center'>
<input type='hidden' name='bid' value='${article.bid}'>
<input type='hidden' name='page' value='${page }'>
 
<input type='submit' value="글 수정 저장"> <input type='reset' value="글 수정 취소">
</td></tr>
</table>
</form>
</div>
</body>
</html>
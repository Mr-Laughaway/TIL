<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>



<html><head><title>게시판 글 작성</title></head>
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

<h3 id="header">게시판 글 작성</h3>
<div id="div_content">
<form method='post' action='./write.do ' enctype="multipart/form-data">
<table width='100%'>
 
<tr><td>제목</td><td><input type='text' name='subject' size="50"></td></tr>

  <tr><td>이름</td>
    <td><input type='text' name='writer'  ></td></tr>
  <tr><td>암호</td>
    <td><input type='password' name='password' ></td></tr>
  <tr><td>Email</td>
    <td><input type='text' name='email' size="50"></td></tr>
  


<tr><td>내용</td><td>
<textarea cols='65' name='contents' rows='20'></textarea>
</td></tr>


 
 
<tr><td>파일 첨부 </td>
    <td><input type='file' name='upload'></td></tr>
  
<tr><td colspan='2' align='center'>
<a href="./list.do">글목록</a>
<input type='submit' value="글쓰기 저장" > 
<input type='reset' value="글쓰기 취소" >
</td></tr>
</table>
</form>
</div>


</body>
</html>

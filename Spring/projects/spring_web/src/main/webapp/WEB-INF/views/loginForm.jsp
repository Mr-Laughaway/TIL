<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
  #main {
    display: inline-box;
    background: skyblue;
    width: 300px;
    padding: 20px;
  }
</style>
</head>
<body>

<div id="main">
  <h3> 로그인</h3>
  <div  id="confirmed" style="text-align : center;">
    <form method='post' action='./login.do'  >
     <table >
         <tr>
           <td style="width:100;text-align:left;">아이디</td>
           <td><input type="text" id="userid" name="userid" size="20" maxlength="15"/></td>
          </tr>
         <tr>
          <td style="width:100;text-align:left;">비밀번호</td>
            <td><input type="password" id="userpwd" name="userpwd" size="20" maxlength="15"/></td>
            </tr>
            <tr><td colspan="2" align="center">
            <input type="submit" id="login" value="로그인" />&nbsp;&nbsp;
            <a href="./join.do"  ><span style="font-size:small">회원가입</span></a>&nbsp;&nbsp;<a href=""><span style="font-size:small;">아디디/비밀번호 찾기</span></a></td>
            </tr>
          </table>
    </form>
  </div>
</div>

</body>
</html>
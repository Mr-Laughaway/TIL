<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 실패</title>
</head>
<body>

  <font color="red">${user.userid}님 아이디가 존재하지 않거나, 비밀번호 오류입니다.</font><br>
  <a href="./login.do">다시 로그인하기</a><br>
</body>
</html>
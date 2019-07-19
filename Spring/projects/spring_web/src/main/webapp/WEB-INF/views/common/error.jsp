<%@ page language="java" contentType="text/html; charset=UTF-8"
    isErrorPage="true"%> 
<!-- 페이지 선언에서 isErrorPage="true"가 선언돼야지만 exception.OOO를 사용할 수 있음 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error.jsp</title>
</head>
<body>
예외가 발생했습니다. :<br>
<%=exception.getMessage() %> <br>
${exception.message}
</body>
</html>
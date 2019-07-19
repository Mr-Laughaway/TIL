<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<style>
p { color: blue;}
</style>
<title>loginSuccess.jsp</title>
</head>
<body>
<c:if test="${!empty authInfo}">
<p> ${authInfo.userid}님 환영합니다.</p> <br>
<a href="<c:url value='/modify.do?userid=${authInfo.userid}'/>">고객정보수정</a> <br>
<a href="<c:url value='/list.do' />"> 고객 정보 리스트 </a><br>
<a href="<c:url value='/logout.do' />"> 로그아웃 </a><br>

</c:if>
</body>
</html>
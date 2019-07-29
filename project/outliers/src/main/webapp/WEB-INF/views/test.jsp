<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
  <h1>Spring + MyBatis 테스트</h1>
  <h1>안녕 세상!</h1>

  <table border="1">
  <c:forEach var="station" items="${stations }">
    <tr>
      <td>${station.ps_id} | ${station.ps_code} | ${station.name_simple} | ${station.latitude} |
       ${station.longitude} | ${station.phone}
      </td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>
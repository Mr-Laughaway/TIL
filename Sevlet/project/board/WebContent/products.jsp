<%@page import="java.util.Vector"%> 
<%@ page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%!
  //int numPerPage = BbsListAction.numPerPage;
  //int numPerBlock = BbsListAction.numPerBlock;
  int numPerPage = 10;
  int numPerBlock = 10;
   
%>
<html><head><title>상품정보</title>
<style>
  #list h3 {
    margin : 0px;
    padding : 0px;
  }
  
  #list td {
    vertical-align : top;
    border: 1px dotted black;
    padding: 10px;
  }
  
  #list p {
    font-weight: 600;
  }
  
  #list span {
    font-weight: 100;
    font-style: italic;
  }
  
  #list p {
    margin-top : 5px;
    margin-bottom : 5px;
  }

</style>
<script>
 
</script>
</head>
<link href="css/mystyle.css" rel="stylesheet" type="text/css">
<body>

<c:if test='${empty user }'>
<div style='text-align:right'>
<a href="./login.do" style="font-size:small">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="./join.do" style="font-size:small">회원가입</a> &nbsp;&nbsp;&nbsp;&nbsp;
</div>
</c:if>
<c:if test='${not empty user }'>
<div style='text-align:right'>
${user.username}(${user.userid})님 로그인 중 &nbsp;&nbsp;&nbsp;&nbsp;
<a href="./member_edit.jsp">회원 정보 수정</a>
</div>
</c:if>

<h3 id="header">게시판</h3>

<div id='menu'>
<%@ include file="mymenu.jsp" %>
</div>

<div id="main">




  <c:if test='${not empty products }'>
  <table id="list" width=100%>
    <c:forEach var="i" begin="0" end="${fn:length(products)-1 }" >
      <c:if test='${i % 3 == 0}'>
        <tr>
      </c:if>
        <td >
            <h3>${product.pname }</h3>
            <img src="images/${products[i].filename }" height=200px;>
            <p>제조사: <span>${products[i].manufacturer }</span></p>
            <p>상품설명: <span>${products[i].description }</span> </p>
            <p>상태: <span>${products[i].condition }</span></p>
            <p>가격: <span>${products[i].unitprice }</span></p>
            <p>재고: <span>${products[i].unitstock }</span></p>
            <p id="link"><a href="./productView.do?prodid=${products[i].productid }">상세보기</a></p>
        </td>
      <c:if test='${i % 3 == 0 || i == fn:length(products)-1 } '>
        </tr>
      </c:if>
    </c:forEach>
  </table>
  </c:if>



</div>

</body>
</html>
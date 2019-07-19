<%@ page   contentType="text/html; charset=utf-8"     %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta   charset=utf-8">
<title>product_list.jsp(사용자 관리)</title> 
<link rel=stylesheet href="../css/user.css" type="text/css">
<script type="text/javascript">
function productCreate() {
	/* f.action="add.do";
	f.submit(); */
	location.href = "add.do"
}

</script>

</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<form name="f" method="post" action="./add.do">
<table width=780 border=0 cellpadding=0 cellspacing=0>
<tr>
	<td width="20"></td>
	<td>
	  	<!--contents-->
	  	<table width=590 border=0 cellpadding=0 cellspacing=0>
		  	<tr>
				<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품정보 관리 - 리스트</b></td>
		  	</tr>
	  	</table>  
	  	<br>
	  
	  	<!-- list -->
	  	<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  	<tr>
				<td width=190 align=center bgcolor="E6ECDE" height="22">상품 아이디</td>
				<td width=200 align=center bgcolor="E6ECDE">상 품 명</td>
				<td width=100 align=center bgcolor="E6ECDE">가     격</td>
				<td width=100 align=center bgcolor="E6ECDE">재고 물량</td>
		  	</tr>
		   
 	<!-- 상품정보 목록를 클라이언트에게 보여주기 위하여 출력. -->

  	  	<c:forEach var="product" items="${products }">
		  	<tr>
				<td width=190 align=center bgcolor="ffffff" height="20">
					 ${product.pcode }
				</td>
				<td width=200 bgcolor="ffffff" style="padding-left:10">
					<a href="./view.do?pcode=${product.pcode }" class="user">
					  ${product.pname }
					</a>
				</td>
				<td width=100 align=center bgcolor="ffffff">
					 ${product.price }
				</td>
				<td width=100 align=center bgcolor="ffffff">
					 ${product.quant }
				</td>
		  	</tr>

        </c:forEach>
 	 	
	  	</table>
	 
	  	<!-- /list -->	 
        <br>
        <br>
		<br>
		<!-- button -->
	  	<table border="0" cellpadding="0" cellspacing="1" width="590">
			<tr>
				<td align="right">
					<input type="button" value="상품정보 추가" onClick="productCreate()">
				</td>
			</tr>
		</table>		
	</td>
</tr>
</table>  
</form>
</body>
</body>
</html>
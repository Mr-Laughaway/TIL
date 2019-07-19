<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>상품 관리</title>
<meta charset="utf-8">
<link rel=stylesheet href="./css/user.css" type="text/css">
<script type="text/javascript">
function productList() {
	f.action="list.do";
	f.submit();
}

function productModify(pcode) {
	f.action="modify.do?pcode="+pcode;
	f.submit();
}

function productRemove(pcode) {
	if ( confirm("정말 삭제하시겠습니까?") ) {
		f.action="delete.do?pcode="+pcode;
		f.submit();
	}
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품  관리 - 입력된 상품 정보</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- write Form  -->
	  <form name="f" method="post" action="UserManager">
    
      
	   
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
	  <tr style="text-align:center;">
			<td width=590 align=center bgcolor="E6ECDE" height="22"  colspan="2" >상품 정보</td>
			 
				 
			
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">상품 코드</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${product.pcode }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">상 품 명 </td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${product.pname }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">상품가격</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${product.price }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">상품수량</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${product.quant }
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">상품설명</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
				 ${product.pdesc }
			</td>
		  </tr>		
		  
	  </table>
	  
	  
	   <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr  height="40">
			<td align=center   >
			<input type="button" value="상품정보 수정" onClick="productModify(${product.pcode })"> &nbsp;
			<input type="button" value="상품정보 삭제" onClick="productRemove(${product.pcode })"> &nbsp;
			<input type="button" value="상품정보 목록" onClick="productList()">
			</td>
		  </tr>
	  </table>
	  </form>
	  <br>
	  
	  

	  </td>
	</tr>
</table>  

</body>
</html>
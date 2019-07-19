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

function productUpdate() {
	f.action="update.do";
	f.submit();
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
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>상품  관리 - 상품 정보 수정 </b></td>
		  </tr>
	  </table>  
	  <br>
	  
	<!-- write Form  -->
	  <form name="f" method="post" action="">
	 
	  <table border="0" cellpadding="0" cellspacing="1" width="640" bgcolor="BBBBBB">
	   <tr>
		    <td width=640 align=center bgcolor="ffffff"  height="22" colspan="3"  style="text-align:right;"> <span id="astrik">* </span>표시는 필수 입력 사항입니다.</td>
		    </tr>
		  <tr>
		    <td width=150 align=center bgcolor="ffffff"  height="22" rowspan="4">
		      <img src="./images/notebook.jpg" width="100" height="80" />
		     </td>
			<td width=100 align=center bgcolor="ffffff"  height="22" style="padding:5px;text-align:left;"><span id="astrik_l">* </span>상품 코드</td>
			<td width=390 bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150;background:lightgray" name="pcode" value ="${product.pcode }" readonly>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="ffffff"  height="22" style="padding:5px;text-align:left;"><span id="astrik_l">* </span>상 품 명</td>
			<td width=390  bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150;background:lightgray" name="pname" value="${product.pname }" readonly>
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center  bgcolor="ffffff" height="22" style="padding:5px;text-align:left;"><span id="astrik_l">* </span>가     격</td>
			<td width=390  bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150" name="price" value="${product.price }">
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center  bgcolor="ffffff" height="22" style="padding:5px;text-align:left;"><span id="astrik_l">* </span>수  량</td>
			<td width=390  bgcolor="ffffff" style="padding-left:10">
				<input type="text" style="width:150" name="quant" value="${product.quant }">
			</td>
		  </tr>
		  <tr>
		    <td width=150 align=center bgcolor="ffffff"  height="22" rowspan="4"> 상품 설명</td>
			<td width=100 align=center bgcolor="ffffff"  height="22" colspan="2">
			<textarea name="pdesc" cols="40" rows="10"> ${product.pdesc }</textarea>
            </td>
			 
		  </tr>		
		 
	  </table>
	
	  <br>
	  
	  <table width=640 border=0 cellpadding=0 cellspacing=0>
		  <tr  height="50">
			<td align=center  bgcolor="E6ECDE">
			<input type="button" value="상품목록 수정" onClick="productUpdate()"> &nbsp;
			<input type="button" value="상품정보 목록" onClick="productList()">
			</td>
		  </tr>
	  </table>
  
	  </td>
	</tr>
</table>  	
		   </form> 
	  </table>
	  </form>
	  <br>
	  
	  

	  </td>
	</tr>
</table>  

</body>
</html>
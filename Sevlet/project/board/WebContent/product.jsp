<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html><head><title>상품 상세 정보</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link href="css/mystyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
  function addToCart() {
    if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
      document.addForm.submit();
    } else {    
      document.addForm.reset();
    }
  }
</script>

</head>
 
<body>
 

<h3 id="header">상품 상세 정보</h3>
<div id='menu'>

<div id="menucontainer">
  <div id="shatop"></div>
  <h3 class="center">메 뉴</h3>
  <a href="./login.do?action=logout">로그아웃</a>
  <div class="blank">&nbsp;</div>
  <a href="./member_edit.jsp">정보수정</a>
  <div class="blank">&nbsp;</div>
  <a href=notice.jsp>공지사항</a>
  <div class="blank">&nbsp;</div>
  <a href=user_list.jsp>회원목록</a>
  <div class="blank">&nbsp;</div>
  <a href="./products.do">쇼핑하기</a>
  <div class="blank">&nbsp;</div> 
  <a href=Mail>전자메일</a>
  <div class="blank">&nbsp;</div>
  <a href="./list.do">게 시 판</a>
  <a href=products.do>상품리스트</a>
  <div class="blank">&nbsp;</div>
  <div class="blank">&nbsp;</div>
  <div class="blank">&nbsp;</div>  
  <div class="blank">&nbsp;</div>
  <div class="blank">&nbsp;</div>   
  
  </div>
</div>


</div>

<div id="main">
 <div class="container">
    <div class="row">
      <div class="col-md-5">
        <img src="images/${product.filename }" style="width: 100%" />
      </div>
      <div class="col-md-6">
        <h3>상품이름</h3> ${product.pname }
        <p>상품설명 : <span>${product.description }</span></p>
        <p><b>상품 코드 : </b><span class="badge badge-danger">${product.productid }  </span>
        <p><b>제조사</b> : ${product.manufacturer } 
        <p><b>분류</b> : ${product.category }
        <p><b>재고 수</b> : ${product.unitstock }
        <h4>가격 ${product.unitprice }원</h4>
        <p><form name="addForm" action="./addCart.jsp?prodid= " method="post">
          <a href="#" class="btn btn-info" onclick="addToCart()"> 상품 주문 &raquo;</a>
          <a href=" " class="btn btn-warning"> 장바구니 &raquo;</a> 
          <a href="products.do" class="btn btn-secondary"> 상품 목록 &raquo;</a>
        </form>
      </div>
    </div>
    <hr>
  </div>
</div>


</body>
</html>

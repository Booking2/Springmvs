<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  
</style>
</head>
<body>
 <table>
    <thead><tr><td>品牌名称：</td><td>商品名称：</td><td>商品状态：</td><td>商品上架时间：</td></tr></thead>
    <tbody>
      <c:forEach items="${productList}" var="product">
        <tr><td>${product.brand.brandName}</td><td><a href="${pageContext.request.contextPath}/product/reviewProduct?id=${product.id}&currentPageNo=${param.currentPageNo}">${product.productName}</a></td><td><c:if test="${product.state != true}">已下架</c:if><c:if test="${product.state == true}">热卖中</c:if></td><td><fml:formatDate value="${product.produceTime}" pattern="yyyy-MM-dd"/> </td></tr>
      </c:forEach>
    </tbody>
 </table>
  <%@ include file="../page.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  li{
     list-style-type:none; 
  }
</style>
</head>
<body>
  <form action="getaddBrandAndproduct" method="post" enctype="multipart/form-data">
    <ul>
       <li>商品名称：<input name="productName"/></li>
       <li>商品价格：<input name="price"/></li>
       <li>品牌选择：<select name="brandID">
          <option value="">==请选择==</option>
           <c:forEach items="${all}" var="brand">
             <option value="${brand.brandID}">${brand.brandName}</option>
           </c:forEach>
           
         </select> 
       </li>
                                        <!-- false：0、true：1  -->
       <li>上架情况：<input type="radio" name="state" value="false" />下架
                  <input type="radio" name="state" value="true" checked="checked"/>上架
       </li>
       <li>上传图片         <input type="file" name="picFiles"/><font color="red">${uploadPicError}</font></li>
       <li>上传图片2<input type="file" name="picFileso"/><font color="red">${uploadPicError}</font></li>
       <li><input type="submit" value="发布商品"/> </li>
    </ul>
  </form>
</body>
</html>
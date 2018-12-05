<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/statics/calendar/WdatePicker.js"></script>
<style type="text/css">
  li{
     list-style-type:none;
  }
  li img{
    height: 240px;
    width: 240px;
  }
</style>
<script src="${pageContext.request.contextPath}/statics/calendar/jquery.js"></script>
<script type="text/javascript">
        $(function() {
            $("#btnUpload").change(function() {
                var $file = $(this);
                var objUrl = $file[0].files[0];
                //获得一个http格式的url路径:mozilla(firefox)||webkit or chrome  
                var windowURL = window.URL || window.webkitURL;
                //createObjectURL创建一个指向该参数对象(图片)的URL  
                var dataURL = windowURL.createObjectURL(objUrl);
                $("#imageview").attr("src", dataURL);
            });
        });
    </script>
</head>
<body>
  <form action="${pageContext.request.contextPath}/product/molityproduct" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${reviewList.id}"/>
    <input type="hidden" name="currentPageNo" value="${param.currentPageNo}"/>
    <ul>
       <li>商品名称：<input value="${reviewList.productName}" name="productName"/></li>
       <li>商品价格：<input value="${reviewList.price}" name="price"/></li>
       <li>品牌选择：<select name="brandID">
          <option value="">==请选择==</option>
           <c:forEach items="${BrandList}" var="brand"> 
             <option <c:if test="${reviewList.brandID == brand.brandID}">selected="selected"</c:if>  value="${brand.brandID}">${brand.brandName}</option>
           </c:forEach>
         </select> 
       </li>
                   <!-- false：0(下架)、true：1(上架) --> 
       <li>上架情况：<input type="radio" name="state" value="false" <c:if test="${reviewList.state != true}">checked="checked"</c:if> />下架
                  <input type="radio" name="state" value="true"  <c:if test="${reviewList.state == true}">checked="checked"</c:if>/>上架
       </li>  
       <li>上架时间：<input name="produceTime"  value="<fml:formatDate value="${reviewList.produceTime}" pattern="yyyy-MM-dd"/>" onfocus="WdatePicker({ dateFmt : 'yyyy-MM-dd'})" readonly="readonly"/></li>
       <c:if test="${reviewList.productImg != null}"><li><img id="imageview" src="../statics/upload/${reviewList.productImg}"> </li><li><c:if test="${reviewList.natural != null}"><img  id="imageview" src="../statics/upload/${reviewList.natural}"></c:if></li></c:if>
       <c:if test="${reviewList.productImg == null}"><li><img id="imageview" > </li></c:if>
       <li>修改图片<input id="btnUpload" type="file" name="picFiles"/><font color="red">${uploadPicError}</font></li>
       <li><input type="submit" value="修改商品"/> </li>
    </ul>
  </form>
</body>
</html>
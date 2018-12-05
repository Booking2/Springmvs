<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fml" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <table>
    <thead><tr><td>用户名称</td><td>开户金额</td><td>开户时间</td><td>账号卡号</td></tr></thead> 
    <tbody>
      <c:forEach items="${getaddBanks}" var="bank"> 
         <tr>
	         <td>${bank.customerName}</td>
	         <td>${bank.currentMoney}</td>
	         <td><fml:formatDate value="${bank.produceTime}" pattern="yyyy-MM-dd"/> </td>
	         <td>${bank.cardID}</td>
         </tr>
      </c:forEach>
    </tbody>
  </table>
  <%@ include file="page.jsp"%>
</body>
</html>
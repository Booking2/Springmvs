<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/statics/calendar/WdatePicker.js"></script>
<style type="text/css">
 li{
    list-style-type: none;
 }
</style>
</head>
<body>
  <form action="${pageContext.request.contextPath}/addbank" method="post">
    <ul>
      <li>用户名称：<input name="customerName"/></li>
      <li>开户金额：<input name="currentMoney"/> </li>
      <li>开户时间：<input name="produceTime" onfocus="WdatePicker({ dateFmt : 'yyyy-MM-dd'})" readonly="readonly"/> </li>
      <li>账号卡号：<input name="cardID"/> </li>
      <li><input type="submit" value="开户"/></li>
    </ul>
  </form>
</body>
</html>
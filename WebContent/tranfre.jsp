<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="statics/calendar/jquery-3.3.1.js"></script>
<script>
		function getnamebankbyid(id,falg){
			   var bankid=$(id).val(); 
			   $.post("getbankbyid",{"id":bankid},function(res){
				    if(falg ==1){
				    	 $("#spformid").html(res.customerName);
				    }else if(falg==2){
				    	  $("#sptoid").html(res.customerName);
				    }
			 },"JSON")
		};
</script>
<style type="text/css">
  li{
   list-style-type: none; 
   margin: 10px;
 }
 #colors{
  color: green;
 }
</style>
</head>
<body>
   <form action="testMoneys"  method="post">
      <h3>${tranErr}</h3>
      <ul>
        <li>转出账户id:<input  name="formid" size="30" onchange="getnamebankbyid(this,1)" />
          <span id="spformid"></span>
        </li> 
        <li>转出de金额:<input name="currentMoney" size="30"/>RMB</li>
        <li>转入账户id:<input name="id" size="30"  onchange="getnamebankbyid(this,2)"/>
          <span id="sptoid"></span>
        </li>
        <li><input type="submit" value="转账"/></li>
      </ul>
   </form>
</body>
</html>
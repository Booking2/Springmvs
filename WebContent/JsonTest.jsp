<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="statics/calendar/jquery-3.3.1.js"></script>
<script type="text/javascript">
     $(function json(){
	  //var json = {"id":1,"name":"李四","age":18} 
	 // $("#Jsonid").html(json.id +"名称\t"+json.name);
	  var json1 = [{"id":1,"name":"李四","age":18},
		           {"id":2,"name":"张三","age":19}]
	  $.each(json1,function(index,obj){
		  alert(index)
		  $("#Jsonid2").append("<option>"+obj.name+ "</option>")
	  })  
   });  
</script> 
</head>
<body>
  <div id ="Jsonid">
    <select id="Jsonid2"> </select>
  </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>回到顶部测试</title>
<script src="statics/calendar/jquery-3.3.1.js"></script>
<script>
$(function(){
    showScroll();
     function showScroll(){
        $(window).scroll( function() { 
            var scrollValue=$(window).scrollTop();
             scrollValue > 100 ? $('div[class=scroll]').fadeIn():$('div[class=scroll]').fadeOut();
        });
           $('#scroll').click(function(){
           $("html,body").animate({scrollTop:0},200);
        });
          $("#scroll").mouseenter(function(){  //鼠标移入============
        	  $("#scroll").text("回到顶部");
          });
          $("#scroll").mouseleave(function(){  //鼠标移出
        	  $("#scroll").text("↑");
          });
     }
})
</script>
<style type="text/css">
	body, div, ul, li, a, img, h1, h2, h3, h4, h5, p, input { margin: 0; padding: 0; }
	article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block; }
	body { font-family: "微软雅黑", Verdana, Arial, Helvetica, sans-serif; position: relative; height:1600px;}
   .scroll { width: 50px; height: 50px; background: #64BFAE; color: #fff; line-height: 50px; text-align: center; position: fixed; right: 50px; bottom: 50px; cursor: pointer; font-size: 10px; }
</style>
</head>
<body>
 <div style="height:1000px"></div>
 <div class="scroll" id="scroll" style="display:none"> ↑ </div>
</body>
</html>
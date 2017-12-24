<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/10/20 0020
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>Coll欢迎您</title>
	<%@ include file="jspbase/headbase.jsp" %>
</head>
<body>
<!-- 导航栏 -->
	<div>
		<%@ include file="jspbase/nav.jsp" %>
	</div>	
  
  <div class="container top-nav">
    <div class="jumbotron">
      <h1>欢迎来到Coll网站</h1>
      <p>我是一个网址导航 网址收藏网 ! 您可以根据自己的需要调整导航排版 !</p>
      <div class="alert alert-info">在当下的浏览器都有各自的收藏栏，但存在问题，使用收藏需要我们下载该浏览器，这样对我们用户来说非常的不方便。
        尤其有时候不使用自己电脑浏览器不同时，想找自己收藏的网站，自己也记不住网址的情况下是遭的。
        本网站可以有自己的网址导航，可以删除自己不需要的网址导航信息。使互联网生活更加轻松优越！  <a class="puul-right" href='<s:url action="tocollshow" namespace="/security"/>'><i class="fa fa-eye"></i>展示</a></div>
      <div class="alert alert-danger">注：本站部分功能为测试阶段：用户名为:admin 密码:1230</div>

      <a type="button" href="" class="btn btn-primary btn-lg">
        登录了吗? <i class="fa  fa-lightbulb-o"></i>
      </a>
    </div>
  </div>
</div>

<div>
    <%@ include file="/jsps/jspbase/fixedbtn.jsp" %>
</div>
	<%@ include file="/jsps/jspbase/footer.jsp" %>

<script src="<c:url value="/js/tree.js"/>"></script>
<script>
    $(document).ready(function(){
        $("#_sendmessage").focus();
        $("#_index").addClass('active');
        importTree();
    })


</script>
</body>
</html>

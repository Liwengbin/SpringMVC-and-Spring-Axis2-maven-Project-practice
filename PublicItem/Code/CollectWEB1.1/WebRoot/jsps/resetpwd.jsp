<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>找回密码</title>
	<%@ include file="jspbase/headbase.jsp"%>
  </head>
 <body id="navbody">
 	<!-- 导航栏 -->
	<div>
		<%@ include file="jspbase/nav.jsp"%>
	</div>
	<!-- 模态框（Modal） 登录注册-->
	<div>
	<%@ include file="jspbase/mloginorsign.jsp"%>
	</div>
	
	<!-- 模态框（Modal） 文件导入/导出-->
	<div>
	<%@ include file="jspbase/importorexport.jsp"%>
	</div>
	
	<!-- 引用UC导航 -->
	<div class="container-fluid row top-nav">
		<div class="col-md-6 col-md-offset-3 check-forpwd">
			<div id="check_info">
				<ul>
					<li><label>昵称</label><input class="input-mit"><i class="chack-t"></i></li>
					<li class="change"><label>男</label><input type="radio" name="change_age" class="input-mitra"> <label>女</label><input type="radio" name="change_age" class="input-mitar"><i class="chack-t"></i></li>
					<li><label>生日</label><input class="input-mit"><i class="chack-t"></i></li>
				</ul>
			</div>
			<div id="check_url">
				<ul>
					<li><input type="checkbox"><a href="#">qwe</a></li>
					<li><input type="checkbox"><a href="#">qwe</a></li>
					<li><input type="checkbox"><a href="#">qwe</a></li>
					<li><input type="checkbox"><a href="#">qwe</a></li>
				</ul>
				<button>验证</button>
			</div>
		</div>
	</div>
	
	<div>
		<%@ include file="jspbase/fixedbtn.jsp" %>
	</div>
<script src="<c:url value="/js/tree.js"/>"></script>
<script>
	$(document).ready(function(){
	$("#_sendmessage").focus();
		importTree();
		$("#_collnav").addClass('active');
	})
</script>
</body>
</html>
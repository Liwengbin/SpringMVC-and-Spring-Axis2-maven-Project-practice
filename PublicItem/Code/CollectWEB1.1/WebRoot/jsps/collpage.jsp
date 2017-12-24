 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <title>Coll收藏</title> 
		<%@ include file="jspbase/headbase.jsp" %>
  </head>
 <body>
	
	<!-- 导航栏 -->
	<div>
		<%@ include file="jspbase/nav.jsp" %>
	</div>	
	
	<div class="container-fluid top-nav">
		<ul class="nav selfnav nav-tabs isline" style="display:block;">
			<c:forEach items="${list}" var="urlfile">
				<li class="dropdown">
				<a class="dropdown-toggle" data-toggle="dropdown" href="#" data-hover="dropdown">
				<span class="fa  fa-folder"></span>
					${urlfile.urlModel.title}
				</a>
				<ul class="dropdown-menu selfnav-navul">
					<c:forEach items="${urlfile.urllist}" var="url">
					<li class="navli"><a target="_blank" href="${url.href}"><img src="${url.logo}">${url.title}</a><span urlid-data="${url.url_id}" class="fa fa-trash-o"></span></li>
					</c:forEach>
					<li style="text-align: center;"><a class="fa fa-plus addfilebtn" loction-data="${urlfile.urlModel.loction}"></a></li>
				</ul>
			</li>
			</c:forEach>
			
			<li><a id="_addmenubtn"><span class="fa fa-chevron-right" style="color: #337ab7;"></span>添加</a></li>
			</ul>
			<input id="_loction"type="hidden" value="">
	</div>
	
	<div class="container-fluid row treeall" style="display:none;">		
		<!-- 网址推荐列表 -->
		<div class="col-md-4">
			<%@ include file="jspbase/urltable.jsp" %>
		</div>
	</div>
	
	<!-- 模态框（Modal） 登录/注册-->
	<div>
	<%@ include file="jspbase/mloginorsign.jsp" %>
	</div>

	<!-- 模态框（Modal） 文件/资料添加-->
	<div>
	<%@ include file="jspbase/mfileormenu.jsp" %>
	</div>
	
	<!-- 模态框（Modal） 文件导入/导出-->
	<div>
	<%@ include file="jspbase/importorexport.jsp" %>
	</div>
	
	<!-- 福利推荐 -->
	<div id="main_page">

	</div>
	
	<div>
		<%@ include file="jspbase/fixedbtn.jsp" %>
	</div>
	
	<!-- 版权信息 -->
	<%@ include file="/jsps/jspbase/footer.jsp" %>
<script src="<c:url value="/js/tree.js"/>"></script>
<script>

$(function () { $("[data-toggle='tooltip']").tooltip(); });


$(document).ready(function(){
	$("#_home").addClass('active');
	//监听操作按钮事件，触发时显示气泡
	$(function () { $(".popover-options i").popover({html : true });});
	addfileClick();
	addmenuClick();
	
	$("#morfbtn").attr('state','file');
	importTree();
	removeUrl();
})
</script>
</body>
</html>

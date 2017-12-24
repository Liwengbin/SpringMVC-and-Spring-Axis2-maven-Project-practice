<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
      <title>Coll导航</title>
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
			<div class="col-md-10 col-md-offset-1">
				<div class="nav" id="nav_id">
					<ul class="nav navbar-nav">
					<c:forEach items="${list}" var="navfile">
						<li num="nav_${navfile.type_id}"><lable>${navfile.type_name}</lable></li>
					</c:forEach>
					</ul>
			</div>		
			<div id="nav_file">
			<c:forEach items="${list}" var="navfile">
				<div id="nav_${navfile.type_id}" style="display: none;">
					<ul class="f-ul">
					<c:forEach items="${navfile.nawModellist}" var="file">
						<li class="row f-li">
							<div class="col-md-2"><h4>${file.type_name}</h4></div>
							<ul class="col-md-10 b-ul">
								<c:forEach items="${file.urlnavModellist}" var="url">
								<li><a href="${url.href}" target="_blank" url_id="${url.url_id}">${url.title}</a></li>
								</c:forEach>
							</ul>
						</li>
					</c:forEach>
					</ul>
				</div>
			</c:forEach>
			</div>
			</div>
	</div>
		
	<div>
		<%@ include file="jspbase/fixedbtn.jsp" %>
	</div>
		<%@ include file="/jsps/jspbase/footer.jsp" %>
	
<script src="<c:url value="/js/tree.js"/>"></script>
<script>
$(document).ready(function(){
$("#_sendmessage").focus();
	importTree();
	$("#_collnav").addClass('active');
	$('#nav_1').css('display','block');
	
	$('#nav_id li').click(function(){
		$(this).addClass('li-after').siblings('li').removeClass('li-after');
		var num = $(this).attr("num");
		$('#'+num).css('display','block').siblings('div').css('display','none');
	});	
	
	//利用ajax上传网页访问情况
	$('.f-li li a').click(function(){
		var urlid= $(this).attr("url_id");
		geturlhavior(urlid);
	});
})

</script>
</body>
</html>
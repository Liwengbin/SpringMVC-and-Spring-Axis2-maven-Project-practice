<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

	<div class="container-fluid">
		<nav class="navbar navbar-default navbar-fixed-top" style="border-color: #7777774d;background-color: #fff;">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-2" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
		     	 </button>
		     	<a id="nav_collimg" class="navbar-brand" href="#"><img src="../ico/shoucanglogo.png"></a>
		    </div>
		    
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
				<ul class="nav navbar-nav" id="ulhove">
					<li id="_home" class=""><a href='../sec/collpage'><i class="fa fa-align-justify"></i>收藏</a></li>
					<li id="_signal"><a href="#"><i class="fa fa-signal"></i>分析</a></li>
					<li id="_collnav"><a href='../pub/collnav'><i class="fa fa-paper-plane"></i>Coll导航</a></li>
					<li id="_client" class=""><a href='../sec/client'><i class="fa  fa-comments"></i>客服</a></li>
					<li id="_index" class=""><a href='../pub/index'><i class="fa fa-puzzle-piece"></i>关于</a></li>
				</ul>
				<div class="pull-right nav-btn" style="padding: 15px 0;">
			    	<c:if test="${user != null}">
								<a data-toggle="dropdown"><img src="../ico/coll.png" id="img_circle"></a>
								<ul class="dropdown-menu state-menu" role="menu" style="right: 20px;">
								    <li><a id="_cname">${user.user_name}</a></li>
									<li><a href="../sec/userdata">个人资料</a></li>
									<li class="divider" style="margin: 0;"></li>
									<li><a data-toggle="modal" data-target="#importorexport">[导入/导出]</a></li>
									<li><a id="_logout" href="../sec/logout"><span class="fa fa-power-off" style="color: red;"></span>注销</a></li>
								</ul>
					</c:if>
					
					<c:if test="${user == null}">
						 <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#myModallogin">
			              [登录/注册]<i class="fa  fa-lightbulb-o"></i>
			    		  </button>
			    		 <a class="btn btn-default navbar-btn" href="../pub/sign">[注册]</a>
					</c:if>
				</div>
			</div>
			
		</nav>
	</div>
<script>
		$(document).ready(function(){
		if($("#_cname").html()==undefined)
		{
			checkLogin();
			}
		})
</script>
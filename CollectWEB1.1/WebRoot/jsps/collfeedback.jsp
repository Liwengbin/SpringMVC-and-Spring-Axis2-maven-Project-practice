<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>Coll客服</title>
	<%@ include file="jspbase/headbase.jsp"%>
	<script src="<c:url value="/ckeditor/ckeditor.js"/>"></script>
	<link rel="stylesheet" href="<c:url value="/css/sample.css"/>">
  </head>
 <body>
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
	<!-- 反馈的建议 -->
	<div class="top-nav container-fluid ">
		<div class="panel panel-default">
		    <div class="panel-body">
		        <ul>
		        	<s:iterator value="feedbacklist">
		        	    <li>
		        	    	<div class="row p0">
				        	    <div class="col-md-1 al"><div class="alert alert-danger"><s:property value="feedname"/></div></div>
				        	    <div class="col-md-9 al alert alert-info"><s:property value="feedcontent"/></div>
				        	    <div class="col-md-1 al alert"><span id="<s:property value="feedid"/>" class="feednumbersty"><s:property value="feednumber"/></span></div>
				        	    <div class="col-md-1 al alert" style="font-size: 20px;"><span id="_addfeedbtn" class="addfeedbtn fa fa-thumbs-o-up" data-value="<s:property value="feedid"/>">顶</span></div>
		        	    	</div>
		        	    </li>
		        	</s:iterator>
		        </ul>
		        </div>
		    </div>
		</div>

	<s:form action="addfeedback" namespace="/userinfo" method="post">
	<div class="container-fluid">
		<div class="btn-group">
		    <button id="_wfk" type="button" class="btn btn-default"><span class="fa fa-pencil"></span>写反馈</button>
		    <s:submit id="_sendfk" type="button" class="btn btn-default"><span class="fa fa-send-o"></span>提交</s:submit>
		</div>
	</div>
	<!-- 输入框编辑器 -->
	<s:textfield name="feedback.feedname" type="hidden" value="匿名"></s:textfield>
	<div id="_feedtext" class="container-fluid" style="display: none;">
		<%@ include file="jspbase/feedback.jsp"%>
	</div>
	</s:form>
	<div>
		<%@ include file="jspbase/fixedbtn.jsp"%>
	</div>

<script src="<c:url value="/js/tree.js"/>"></script>
<script>
$(document).ready(function(){
$("#_client").addClass('active');
	sendwfk();
	toClient();
	importTree();
})



</script>
</body>
</html>
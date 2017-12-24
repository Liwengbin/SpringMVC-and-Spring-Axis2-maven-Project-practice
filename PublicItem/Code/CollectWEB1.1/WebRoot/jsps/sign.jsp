<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>用户注册</title>
	<%@ include file="jspbase/headbase.jsp"%>
  </head>
 <body id="sign">
 	<div class="passport-wrapper">
 		<header id="header" class="passport-header">
       	 	<div id="sign-logo"><a href="http://localhost:8080/CollectWEB1.1/sec/collpage"><img src="../ico/shoucanglogo.png"></a></div>
    	</header>
    	
    	<div>
	    	<div class="container-fluid row coll-sign">
	    		<div class="col-md-6 main-form">
	    			<h2>新用户注册</h2>
					<p></p>
					<!-- form -->
					<sf:form id="register-form" action="../pub/sign/adduser" method="post">
						<div class="form-item">
							<div class="form-cont">
								<sf:input id="sign_emailID" type="text" path="user_email" class="sign-txt" tabindex="1" placeholder="请输入邮箱号" onblur='sign_ischeckemail()'/>
								<div id="sign_error_email" class="sign-error-text"><span id="error_emailID"></span></div>
							</div>
						</div>
						<div class="form-item">
							<div class="form-cont">
								<sf:input id="sign_nameID" type="text" path="user_name" class="sign-txt" tabindex="1" placeholder="请输入昵称"/>
								<div id="sign_error_name" class="sign-error-text"><span id="error_nameID">昵称不能为空！</span></div>
							</div>
						</div>
						<div class="form-item">
							<div class="form-cont">
								<sf:input id="sign_pwd1ID" type="password" path="user_password" class="sign-txt" tabindex="1" placeholder="请输入密码"/>
								<div id="sign_error_pwd" class="sign-error-text"><span id="error_pwd1ID">密码不能为空！</span></div>
							</div>
						</div>
						<div class="form-item">
							<div class="form-cont">
								<input id="sign_pwd2ID" type="password" class="sign-txt" tabindex="1" placeholder="请再次输入密码">
								<div class="sign-error-text"><span id="error_pwd2ID">密码输入不一致！</span></div>
							</div>
						</div>

						<div class="form-item form-treaty">
							<div class="form-cont">
								<input type="checkbox" name="treaty" checked="checked" value="treaty"> 
								<span>同意</span>
								<a href="http://www.jikexueyuan.com/help/service.html" target="_blank" class="treaty">coll收藏网用户协议</a>
							</div>
						</div>
						
						<div class="form-item">
		                    <div class="form-cont">
		                        <input type="submit" id="submit" name="register" style="display: none;">
		                        <input type="button" id="sub_btn" class="coll-btn sign-btn-def" tabindex="5" value="注册">
		                    </div>
		                </div>
					</sf:form>
				</div>
				
	    		<div class="col-md-6">
		            <div class="passport-goto">已有帐号 <a href="../pub/login" tabindex="6">立即登录</a></div>
		            <div class="passport-third">
		                <header class="hd">
		                    <div class="layout-inner">
		                        <h3>快速登录</h3>
		                    </div>
		                </header>
		                <div class="links">
		                    <a href="/connect/qq"><i class="passport-icon icon-tencent"></i></a>
		                    <a href="/connect/weibo"><i class="passport-icon icon-weibo"></i></a>
		                    <a href="/connect/weixin"><i class="passport-icon icon-weixin"></i></a>
		                    <!-- <a href="/connect/eoe"><i class="passport-icon icon-eoe"></i></a> -->
		                </div>
		            </div>	
	    		</div>
	    	</div>
    	</div>
 	</div>
</body>
</html>
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
	    			<h2>用户登录</h2>
					<p></p>
					<!-- form -->
						<div class="form-item">
							<div class="form-cont">
								<input id="login_emailID" type="text" class="sign-txt" tabindex="1" placeholder="请输入邮箱号">
								<div id="login_error_email" class="sign-error-text"><span id="error_emailID"></span></div>
							</div>
						</div>

						<div class="form-item">
							<div class="form-cont">
								<input id="login_pwdID" type="password" name="phone" class="sign-txt" tabindex="1" placeholder="请输入密码">
								<div id="sign-error-password" class="sign-error-text"><span id="error_pwdID">密码不能为空</span></div>
							</div>
						</div>
						
						<div class="form-item form-sevenday">
                            <div class="form-cont clearfix">
                                <label><input type="checkbox" id="expire" class="passport-sevenday">7天内免登录</label>
                                <a href="。。/home/resetpwd" class="forget-link">忘记密码</a>
                            </div>
                        </div>
                        
						<div class="form-item">
		                    <div class="form-cont">
		                        <input type="button" id="login_btn" class="coll-btn sign-btn-def" tabindex="5" value="登录">
		                    </div>
		                    <input id="forword" type="hidden" value="${forword}" style="display: none;">
		                </div>
				</div>
				
	    		<div class="col-md-6">
		            <div class="passport-goto">没有账号? <a href="../pub/sign" tabindex="6">免费注册</a></div>
		            <div class="passport-third" style="margin-top: 40px;">
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
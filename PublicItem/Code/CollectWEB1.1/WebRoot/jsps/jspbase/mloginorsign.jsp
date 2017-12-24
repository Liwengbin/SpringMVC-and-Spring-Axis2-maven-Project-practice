<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>
<!-- 模态框（Modal） 登录注册-->
	<div class="modal fade" id="myModallogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
						<i class="fa fa-times-circle-o"></i>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						用户登录
					</h4>
				</div>
				
				<div class="login" style="display: block;">
					<div class="modal-body">
						<div class="form-group">
							<input id="login_email" type="text" class="form-control" placeholder="Email"></input>
						</div>
						<div class="form-group">
						<input id="login_password" type="password" class="form-control" placeholder="Password"></input>						
						</div>
						<div class="form-group">
							<span id="_loginmsg"></span>
						</div>
					</div>
					<div class="modal-footer form-inline">
						<div class="row">
							 <div class="col-md-6 pull-left" style="margin-top: auto;" id="_option">
								<label class="checkbox-inline pull-left">
									<a href="../home/resetpwd" class="forget-link">忘记密码</a>
								</label>
						      </div>
						      <div class="col-md-6">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<button id="_loginbtn" class="btn btn-primary">登录</button>
							 </div>
						</div>
					</div>
				</div>
			</div><!-- /.modal-content -->
		</div><!-- /.modal -->
	</div>


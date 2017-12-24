<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp" %>
<div class="fixed-btn">
    <a class="go-top" href="javascript:scroll(0,0)" title="返回顶部" style="display: inline-block;"> <i class="fa fa-angle-up"></i></a>
    
    <a class="paperplane" title="反馈" href="../sec/tofeedback"><i class="fa fa-send-o"></i></a>
    <a class="qrcode" title="微博关注"><i class="fa fa-qrcode"></i></a>
    <a class="writer" target="_blank" href="//mail.qq.com/cgi-bin/qm_share?t=qm_mailme&amp;email=liwengbincoll@foxmail.com" style="font-size: 12px;" title="Bug 反馈"><i class="fa fa-envelope-o" style="font-size: 20px;"></i></a>
   		<!-- qrcode modal -->
	    <div id="bottom-qrcode" class="modalbtn panel-modal fade in" style="display: none;">
	      <h4>微博关注</h4>
	      <div class="panel-weibo"><img alt="微博关注" class="img-responsive" src="data:image/png;base64,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"></div> 
	    </div>
</div>

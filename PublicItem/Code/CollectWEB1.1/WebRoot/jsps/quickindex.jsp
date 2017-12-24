<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>快速收藏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="description" content="网址收藏，网站推荐，为你提供更方便的网页收藏服务，不在烦恼。">
<link rel="shortcut icon" href="<c:url value="/ico/coll.png"/>" />

<style type="text/css">
body{
    font-family: "Segoe UI", Arial, "Microsoft Yahei", sans-serif;
    font-size: 85%%;
}
.show{
	width: 70%;
	margin: 0 auto;
}
.check {
    width: 70%;
    margin: 0 auto;
}
#_msg {
    position: fixed;
    margin: 0 auto;
    bottom: 50px;
    right: 50px;
    border: 1px solid #eee;
    padding: 10px;
    border-radius: 3px;
}

}
#list {
    -webkit-flex: 1;
    box-sizing: border-box;
    min-width: 0;
    padding-bottom: 5px;
    padding-top: 5px;
}
list {
    display: block;
    overflow-x: hidden;
    overflow-y: visible;
}
list > * {
    -webkit-padding-end: 196px;
    -webkit-padding-start: 48px;
    color: hsl(0, 0%, 70%);
    display: -webkit-flex;
    line-height: 28px;
    margin: 5px 0;
    overflow: visible;
    padding-bottom: 0;
    padding-top: 0;
    text-decoration: none;
    white-space: nowrap;
    position: relative;
}

list > [selected], grid > [selected] {
    background-color: #D4E7FA;
    z-index: 2;
}
list > [selected], grid > [selected], list:focus > [selected], grid:focus > [selected] {
    background-color: rgba(234,237,239,1);
    box-shadow: 0 1px rgba(0,0,0,.2) inset, -1px 1px rgba(0,0,0,.2);
}


#list .edit, #list .del {
    position: absolute;
    width: 12px;
    height: 12px;
    left: 10px;
    top: 8px;
   /* display: none; */
    cursor: pointer;
    padding: 0;
    background-position: -21px -4px;
    background-image: url("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAxCAYAAABd2WCOAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAL3SURBVFhHzZjNbtNAFIWbvoXTqCskugKx6aYkFnvaOEggaBxUCakSEr+1gUcoQm1tliCkSl3xGN121Tdg22foqtw7mXFmxsf5uXYKn/QtPJ6eOXUGp8zKP6I1xVsHlUDeCmjhaS4VtOA8ujz9kq9HB/lDfVmC721/PL6jL6eBFivcfvftHhrXugyS/GKQ5je0+Hs9VBAl3/f5Hs251ENVoIUKB2n2I0ry6yg96aP7pMuTNN9VC3vFikJkP8lf6WEEWqRw8PZrh0rlKp+K7RwcPQDzyvTTbM8uZheK0uy1nobwwx3pCZ9GSXb1+OBoY1ws+4XmkRi7WFOFihwqxk8MzdNWQyXOJkH5bz2MQMGFdiElXaN5lhj7IzOiza9BwUpBIbaMv4f8PaanGVCoUliIdXEKWHvIGU/yN3qYQaGt/oeTrpmvnL8Q60I/fKkWBpt6Uiz7o4dQoHKQZIfCQqwLv63pI6p+o38+3tz5lN3VlyhQSaXO+Z89PzF0f4ZiUFhTikFhi7qq9cfF+EGLagqhYmLsEIn/fSn/nhg/qEnFoLCmrAUKbMJaoMAmrA0KrWttUGhdGwEF17ERUHAdGwOFS20UtIDExkGL+NpfMb58fyn4JYyoBHJpSMoYl4qkEOsSbI3Wg3BU+Tc63+uEseTUxVl4bevZfX/M0iUI44t2OLoJesPSfzyDXrw/vhfXOXVZbffin/TLXQfdEZ+62GXMHJegN9rlhf1ippAa78biU5e1cNihjFzlULF27/l8py7tMN4rClAxuxDdEx9y0C98Sk/pKghfbFAWF1vs1MUuNrFmIZNDxfiJoXnaauiHz0wQ7TXxqYtTiLPoGs2zxLgfmQkrb34NClYKCrFl/D3k7zE9zYBClcJCrIu7lyZ7yCkWxjNPXah8d5KzUCHWhd9B46DypraKzTx1of14KCzEuvDbetobvdN9udl+NJx56kKlzqlQzk8M3Z+hGBTWlGJQ2KL6Xy9GMX7QotrfeX4xMXaIxIpSK62/6JGHiJOhLroAAAAASUVORK5CYII=");
}
#list .del {
    left: 26px;
    background-position: -3px -4px;
}

#list input{
	padding: 0.5em;
    color: #525050;
    width:100%;
    outline: none;
    background: #fff;
    font-weight: 500;   
    border: 1px solid #ccc;
    border-bottom: 0px;
}

list > * > button {
    -webkit-transition: opacity 150ms;
    background: #fff -webkit-canvas(drop-down-arrow) no-repeat center center;
    border: 1px solid hsl(214, 91%, 85%);
    border-radius: 3px;
    bottom: 1px;
    display: none;
    overflow: hidden;
    padding: 0;
    position: absolute;
    right: 3px;
    top: 1px;
    width: 15px;
}
list > * > .label {
    -webkit-transition: all 150ms;
    color: black;
    display: inline-block;
    width: 300px;
}
list > * > * {
    -webkit-padding-start: 20px;
    background: 0 50% no-repeat;
    box-sizing: border-box;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: pre;
}
#list .domain {
    position: absolute;
    right: 16px;
    text-align: right;
    width: 185px;
    padding: 0 10px;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
}
list:not([disabled]) > :not(.searchResultsFor):hover, grid:not([disabled]) > :not(.searchResultsFor):hover {
    background-color: rgba(234,237,239,.5);
    box-shadow: 0 1px rgba(0,0,0,.1) inset, -1px 1px rgba(0,0,0,.1);
}
list:not([disabled]) > :hover, grid:not([disabled]) > :hover {
    background-color: hsl(214, 91%, 97%);
    border-color: hsl(214, 91%, 85%);
    z-index: 1;
}
#list .edit:hover {
    background-position: -21px -34px;
}
list > * > .url {
    -webkit-flex: 1;
    direction: ltr;
    display: block;
    min-width: 0;
}
#list > :hover > .edit, #list > :hover > .del {
    display: block;
}
.add{
	width: 70%;
	margin: 0 auto;
}

.add input[type="text"] {
    padding: 0.5em;
    color: #858282;
    font-size: 16px;
    outline: none;
    background: #fff;
    font-weight: 500;
    width: 40%;
    border: none;
    min-width: 250px;
    border: 1px solid #ccc;
    /* border-radius: 0.3em; */
    -o-border-radius: 0.3em;
    -moz-border-radius: 0.3em;
    margin: 0.7em 0;
}
.add input[type="submit"] {
    font-size: 20px;
    font-weight: 300;
    color: #fff;
    cursor: pointer;
    outline: none;
    padding: 4px;
    border: 3px solid #0bd38a;
    background: #0bd38a;
    width: 15%;
}
#nav_collimg img{
	height: 50px;
	width: auto;
	margin: 0 auto;
}
.check{
	position: fixed;
    width: 100%;
    height: 100%;
    top: 0;
	background-color: rgba(158, 158, 158, 0.23);
}

.check-main{
	position: relative;
    width: 40%;
    min-width: 350px;
    margin: 200px auto;
    height: 200px;
    background-color: #fff;
}

.check-form{
	position: absolute;
    margin: 80px auto;
    left: 20%;
}
.check-form #quick_id{
	padding: 0.5em;
	outline: none;
	font-size:16px;
	letter-spacing: 1px;
	width: 200px;
    height: 40px;
}

.check-form #_check{
	width: 100px;
    height: 40px;
    outline: none;
    color: #fff;
    border: none;
    cursor:pointer;
    background-color: #0bd38a;
}
.out-put{
	float: right;
	margin-right: 20px;
	outline: none;
}
</style>

</head>

<body>
	<div class="nav">
		<div class="navbar-header">
		     <a id="nav_collimg" href="<c:url value="/pub/login"/>"><img src="<c:url value="/ico/shoucanglogo.png"/>"></a>
		     <a class="out-put" href="<c:url value="/q/out"/>">注 销</a>
		</div>
	</div>
	<div class="main">
		<div class="load"></div>
		<div class="add">
				<input type="text" class="text" text="HREF" id="_href" placeholder="网 址">
				<input type="text" text="TITLE" id="_title" placeholder="描 述">
				<input type="submit" id="_submit" value="提  交">
		</div>
		
		<div class="show">
			<list id="list">
				<c:forEach items="${list}" var="li">
					<div class="listitem" id="${li.url_id}">
						<div class="label" title="${li.title}">${li.title}</div>
						<div class="url"><a target="_blank" href="${li.href}">${li.href}</a></div>
						<span class="domain">${li.time}</span>
						<span class="edit" title="修改…"></span>
						<span class="del" title="删除"></span>
						<button tabindex="-1" class="custom-appearance menu-button"></button>
					</div>
				</c:forEach>
			</list>
		</div>
		
		<div id="_msg">
		</div>
		<div class="check" style="display: none;">
			<div class="check-main">
				<div class="check-form">
					<input type="text" id="quick_id">
					<input type="button" id="_check" value="验证 登陆码">
				</div>
			</div>
		</div>
	</div>
	
</body>
<script type="text/javascript" src="<c:url value="/js/jquery-3.2.0.min.js"/>"></script>

<script type="text/javascript">
$(document).ready(function(){
	if('${QuickModel.quick_id}'!=''){
		$("#_msg").html("已经认证！");
	}else{
		$(".check").css('display','block');
		$("#_msg").html("未登陆");
	}
})
function getRootPath(){
	return "http://localhost:8080/CollectWEB1.1"
} 
/* function getRootPath(){
	return "http://www.itart.space:8080/Coll"
} */

$(".del").click(function(){
	var parent = $(this).parent();
	if(confirm("确认删除这条记录吗？"))
    	{
    	parent.attr('id')
  		$.ajax({/*异步请求，删除记录*/
	        data:"url_id="+parent.attr('id'),
	        type:"GET", 
	        url:getRootPath()+"/q/delete",  
	        success:function(data){
	            if(data=="true"){
						parent.remove();
					}else{
						$("#_msg").html("删除 失败！");
					}
	        	}  
	        });	
    	}
});
var list_id = null;
var myid=null;
$(function(){

		
        $(document).bind("click",function(e){
            //id为menu的是菜单，id为open的是打开菜单的按钮 
	            if($(e.target).closest("#"+myid).length == 0){
	            	//点击id为menu之外且id不是不是open，则触发
	                var list_this = $("#"+myid);
	                //alert(list_id);
	                var ch_label = list_this.children('.label');
					var ch_url = list_this.children('.url');
	                
	                var title_text = ch_label.children('input').val();
					var href_text = ch_url.children('input').val();
	                
	                ch_label.empty();
					ch_url.empty();
					
					$("#"+myid).removeAttr("selected");
					ch_label.html(title_text);
					ch_url.html("<a target=\"_blank\" href=\""+href_text+"\">"+href_text+"</a>");
	                //alert(title_text+href_text);
	                myid = list_id;
	                list_id = null;
	            }	            
        })
        edit();
        add();
        check();
    })
function edit(){
		$(".edit").click(function(){
			var parent = $(this).parent();
			var ch_label = parent.children('.label');
			var ch_url = parent.children('.url');
			
			if(myid != parent.attr('id')){
				list_id = parent.attr('id');
				var title_text = ch_label.text();
				var href_text = ch_url.children('a').text();
					
				var input_title=$("<input>");
				var input_url=$("<input>");
				
				input_title.attr("type","text");
				input_url.attr("type","text");
				input_title.val(title_text);
				input_url.val(href_text);
				
				ch_label.empty();
				ch_url.empty();
				ch_label.append(input_title);
				ch_url.append(input_url);
				
				parent.attr({"selected":"selected"}).siblings('.listitem').removeAttr("selected");
			}
			//alert(title_text+href_text+"1");
		});
}

function add(){
	$("#_submit").click(function(){
		var h_text = $("#_href").val();
		var t_text = $("#_title").val();
		if($.trim(h_text) == "" || $.trim(t_text) == ""){
			$("#_msg").html("网址与关键词不能为空！");
		}else{
		
			$.ajax({/*异步请求，删除记录*/
	        data:"href="+h_text+"&title="+t_text,
	        type:"GET", 
	        url:getRootPath()+"/q/add",
	        success:function(data){
	            if(data=="true"){
						location.href=getRootPath()+"/q/index";
					}else{
						$("#_msg").html('${msg}');
					}
	        	}  
	        });	
		}
	});
}

function check(){
 
	 $(document).keydown(function(event){ 
		if(event.keyCode == 13){ //绑定回车 
			$("#_check").click(); //自动/触发登录按钮 
		} 
		}); 

	$("#_check").click(function(){
		var quick_id = $("#quick_id").val();
		//alert(quick_id);
		if($.trim(quick_id) != ""){
			$.ajax({/*异步请求，删除记录*/
	        data:"quick_id="+quick_id,
	        type:"GET", 
	        url:getRootPath()+"/q/checkquick",  
	        success:function(data){
	            if(data=="true"){
						location.href=getRootPath()+"/q/index";
					}else{
						$("#_msg").html("登陆异常！");
					}
	        	}  
	        });	
		}
	});
}
	/* $('#list .listitem').mousemove(function(){
	var outher = $(this).siblings('.listitem');	
		$(this).attr({"selected":"selected"}).siblings('.listitem').removeAttr("selected");
	}); */
</script>
</html>
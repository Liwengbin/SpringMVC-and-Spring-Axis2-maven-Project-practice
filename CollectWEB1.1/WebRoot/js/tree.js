

var imgdata;
var EXPRI_EDAYS=60;


$(document).ready(function(){
	mousel();
	})
	
/**
* 添加按钮节点点击事件
*/
function addfileClick()
{
	$('.addfilebtn').click(function() {
		var loction=$(this).attr('loction-data');//获取外键值
		$("#_loction").val(loction);
		$("#modaladdfilebtn").click();
		addfunction();
	})

}

/**
* 添加按钮节点点击事件
*/
function addmenuClick()
{
	$("#_addmenubtn").click(function() {
		$("#modaladdmenubtn").click();
		addfunction();
	})

}

/**
*  动态添加节点事件
*/
function sendwfk()
{
	$("#_wfk").click(function(){
		$("#_feedtext").css('display','block');
	});
}

/**
 * 提交用户访问网页情况
 */
function geturlhavior(url_id){
	$.ajax({
		  type:"GET",
		  data:"haviorurlid="+url_id,
		  url:"../sec/ajaxhavior",
		  error:function(data){  
	          alert("系统异常！");
	      },
		  success:function(result)
		  {
			  if(result == "true"){
				  	alert("您没有登陆哦");
			  }
		  }
		  });
}

var issign =new Array();
/**
 * 鼠标移入移除事件
 */
function mousel(){
	$(".qrcode").mouseenter(function(){
		$("#bottom-qrcode").css('display','block');
	});
	
	$(".qrcode").mouseleave(function(){
		$("#bottom-qrcode").css('display','none');
	});
	
	/*检查用户昵称是否为空*/
	$("#sign_nameID").blur(function(){
		var this_name = $("#error_nameID");
		var name = $("#sign_nameID").val().trim();
		if(name != ""){
			this_name.css('display','none');
			issign[3]="true";
		}else{
			this_name.css('display','block');
			issign[3]="false";
		}
	});
	
	/*注册时检查用户密码是否为空*/
	$("#sign_pwd1ID").blur(function(){
		var this_pwd = $("#error_pwd1ID");
		var pwd = $("#sign_pwd1ID").val().trim();
		if(pwd != ""){
			this_pwd.css('display','none');
			issign[1]="true";
		}else{
			this_pwd.css('display','block');
			issign[1]="false";
		}
	});
	
	/*登录时检查用户密码是否为空*/
	$("#login_pwdID").blur(function(){
		var this_pwd = $("#error_pwdID");
		var pwd = $("#login_pwdID").val().trim();
		if(pwd != ""){
			this_pwd.css('display','none');
		}else{
			this_pwd.css('display','block');
		}
	});
	
	/*注册时检查两次用户密码是否一致*/
	$("#sign_pwd2ID").blur(function(){
		var this_pwd = $("#error_pwd2ID");
		var pwd1 = $("#sign_pwd1ID").val().trim();
		var pwd2 = $("#sign_pwd2ID").val().trim();
		if(pwd1 == pwd2){
			this_pwd.css('display','none');
			issign[2]="true";
		}else{
			this_pwd.css('display','block');
			issign[2]="false";
		}
	});
	
	$("#sub_btn").click(function() {
		for(var i = 1;i<issign.length;i++){
			if(issign[i]=="false")
				{
					alert("用户信息有错误,请重新输入！");
					break;
				}else if(i==issign.length-1){
					$("#submit").click();
					break;
				}
		}
	});
	
	$("#login_emailID").blur(function(){
		login_ischeckemail();
	});

/*登录页面的登录*/
$("#login_btn").click(function() {
	  var em=$("#login_emailID").val();
	  var pwd=$("#login_pwdID").val();	  
	  option(em,pwd,60*24*7);//将用户名密码保存在cookie中
	  $.ajax({
	  type:"POST",
	  data:"logindata="+"{\"user_email\":\""+em+"\",\"user_password\":\""+pwd+"\"}",
	  url:"../pub/ajaxlogin",
	  error:function(data){  
          alert("系统异常请重新加载页面!");
      },
	  success:function(result)
	  {
		  if(result != "true"){
			  $("#error_pwdID").html(result);
			  $("#error_pwdID").css('display','block');
		  }else
		  {
			  window.location.href=$("#forword").val();
		  }
	  }
	  });
})
}

/*某个页面登录事件*/
$("#_loginbtn").click(function() {
	
	
	  var em=$("#login_email").val();
	  var pwd=$("#login_password").val();
	  dataurl={user_email:em,user_password:pwd};
	  $.ajax({
	  type:"POST",
	  data:"logindata="+JSON.stringify(dataurl),
	  url:"../pub/ajaxlogin",
	  success:function(result)
	  {
		  if(result == "true")
			  {
			  window.location.reload();
			  }
	  }
	  })
})

/*检查email格式是否正确*/
function ischeckemail(email){
     var reg = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
     isok= reg.test(email );
       if (!isok) {
            //document.getElementById("emailname").focus();
            return false;
        }else{
        	return true;
        }
}


/*检查注册时email格式*/
function sign_ischeckemail(){
	var email=document.getElementById("sign_emailID").value;
	var message =$("#error_emailID");
	issign[4]="false";
	if(email != ""){
		if(!ischeckemail(email))
			{
				message.html("email 格式不正确!");
				message.css('display','block');
			}else{
				$.ajax({/*异步请求，检查用户是否存在*/
			        data:"user_email="+email,
			        type:"GET", 
			        url:"../pub/signcheck",  
			        success:function(data){
			            if(data=="true"){
								message.css('display','none');
								issign[4]="true";
							}else{
								message.html("账号存在，请重新输入！");
								message.css('display','block');
							}
			        	}  
			        });	
			}
	}else{
		message.html("email 不能为空！");
		message.css('display','block');
		return false;
	}
}

/*检查登录时email格式*/
function login_ischeckemail(){
	var email=document.getElementById("login_emailID").value;
	var message =$("#error_emailID");
	if(email != ""){
		if(!ischeckemail(email))
			{
				message.html("email 格式不正确!");
				message.css('display','block');
			}else{
				message.css('display','none');
			}
	}else{
		message.html("email 不能为空！");
		message.css('display','block');
		return false;
	}
}


/*注册事件*/
$("#_signbtn").click(function() {
	
	  var em=$("#sign_email").val();
	  var na=$("#sign_name").val();
	  var pwd=$("#sign_password").val();
	  
	  dataurl={user_email:em,user_password:pwd,user_name:na};
	  $.ajax({
	  type:"POST",
	  data:"infodata="+JSON.stringify(dataurl),
	  url:"../security/sign.do",
	  success:function(result)
	  {
		  if(result != null)
			  {
			  $("#_signmsg").html(result);
			  }
		  else
			  {
			  $("#rorlbtn").click();
			  $("#login_email").val(em);
			  $("#login_password").val(pwd);
			  }
	  }
	  })
})


/*添加目录文件事件*/
$("#_submitmenu").click(function() {
	  var name=$("#_menuname").val();
	  dataurl={href:"#",title:name};
	  $.ajax({
	  type:"POST",
	  data:"menuJsondata="+JSON.stringify(dataurl),
	  url:"../userinfo/addmenu.do",
	  success:function(getmenu)
	  {  
		  $("#myModalmenu").modal('hide');//隐藏模态框
		  window.location.reload();
		//监听操作按钮事件，触发时显示气泡
		$(function () { $(".popover-options i").popover({html : true });});
	  }
	  })
})


/*添加加网址事件，异步提交*/
$("#_submiturl").click(function() {
	  var hf=$("#_url").val();
	  var tle=$("#_title").val();
	  var loc=$("#_loction").val();
	  var imglogo=$("#_logo").attr('src');
	  var ty = $("#_typelist").val();
	  dataurl={href:hf,title:tle,loction:loc,logo:imglogo,typelist:ty};
	  $.ajax({
	  type:"POST",
	  data:"urlJsondata="+JSON.stringify(dataurl),
	  url:"../sec/addurl",
	  success:function(result)
	  {
		if(result=="true"){
	  	$('#myModalfile').modal('hide');//隐藏模态框
	  	window.location.reload();
		//监听操作按钮事件，触发时显示气泡
		$(function () { $(".popover-options i").popover({html : true });});
		}else{
			//
		}
	  }
	  })
})


function removeUrl()
{
	$('.navli>span').click(function() {
		var kid = $(this).attr('urlid-data');
		if(confirm("确认删除这条收藏吗？"))
    	{
			$.ajax({
				  type:"POST",
				  data:"removekid="+kid,
				  url:"../userinfo/removeurl.do",
				  success:function(result)
				  {
				  	if(result=="success")
				  		{
				  			window.location.reload();
				  		}
				  	else
				  		{
				  		alert("删除目录失败！")
				  		}
				  }
				  })
    	}
	})
	}

/**
 * 点赞事件
 */
$(".addfeedbtn").click(function() {
	  var feedid=$(this).attr('data-value');
	  $.ajax({
	  type:"POST",
	  data:"data="+feedid,
	  url:"../userinfo/addfeednumber.do",
	  success:function(result)
	  {
		alert(result);
		$("#"+feedid).html(result);
	  }
	  })
})


/**
* 获取url利用ajax+json异步传输到服务器抓取相对应的数据返回回填事件
*/
$("#_geturl").click(function() {
	GetUrlContentClick();
})
function GetUrlContentClick()
		{
			var URL=$("#_url").val();
			if(isURL(URL))
			{
				PostUrlContent(URL);
			}
			else{
				alert("网址"+URL+"格式不正确！")
			}
		}
/**
*判断url格式是否正确
*/
function isURL(str)
		{
		var reg=new RegExp("[a-zA-z]+://[^\s]");
		return reg.test(str);
		}
/*
* 利用get请求获取响应
*/
function PostUrlContent(URL)
		{
		  $.ajax({
		  type:"GET",
		  data:"url="+URL,
		  url:"../sec/htmlMeta",
		  success:function(result)
		  {
		  	var metaobj=JSON.parse(result);
		  	document.getElementById("_title").value=metaobj[0]["title"];
		  	$("#_logo").attr('src',"data:imgge/png;base64,"+metaobj[0]["icoBase64"]);
		  	$("#_typelist").value=metaobj[0]["keyWord"];
		  }
		  })
		} 

	 
	 
//js获取项目根路径，如： http://localhost:8083/uimcardprj
function getRootPath(){
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath=window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName=window.document.location.pathname;
    var pos=curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht=curWwwPath.substring(7,pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);
    return(localhostPaht+projectName);
}

/*
 * 聊天
 * */
function toClient()
{
var id = $("#_id").val();
	var socket = new WebSocket("ws:/"+getRootPath()+"/websocket/"+id);
    // 处理服务器端发送的数据
    socket.onmessage = function(event) {
        addMessage(event.data);
    };
    
    // 点击Send按钮时的操作
    $('#_send').on('click', function() {
        //var id = $("#_id").val();
        var message = $("#_sendmessage").val();
        var forid = $("#_forid").val();
        if (message == null) {    // 判断消息输入框是否为空
           alert("消息为空！")
        } else {
            // 发送消息
            socket.send(JSON.stringify({
                content : message,
                id:id,
                forid:forid
            }));
            
            $("#_sendmessage").val("");
           //$("#_sendmessage").focus();光标停留在输入框
        }
    });
    
    function addMessage(message) {
        message = JSON.parse(message);
        
        var li=$("<li>");
        var mesdiv=$("<div>").addClass(message.isSelf ? 'mes mes-right row' : 'mes mes-left row').appendTo(li);
        
        var imgdiv=$("<div>").addClass('mes-img col-xs-2 p0').appendTo(mesdiv);
        $("<img>").attr('src','../ico/headimg6.png').addClass('img-responsive img-circle').appendTo(imgdiv);
        
        
        
        var contentdiv=$("<div>").addClass('panel panel-info col-xs-8 p0 mes-conttent').appendTo(mesdiv);
        var topdiv =$("<div>").addClass('panel-heading').css('padding','5px 15px').appendTo(contentdiv);
        $("<h3>").html(message.data).addClass('panel-title').appendTo(topdiv);
        var divcont = $("<div>").addClass('panel-body').css('padding','10px').appendTo(contentdiv);
        $("<span>").html(message.content).appendTo(divcont);
        $('.message-list').append(li);
        
        $(".client-spase").scrollTop($(".client-spase")[0].scrollHeight);
        }
}

/**
 * 返回顶部代码
 */
function pageScroll() { 
	window.scrollBy(0,-10); 
	scrolldelay = setTimeout('pageScroll()',100); 
	if(document.documentElement.scrollTop==0) clearTimeout(scrolldelay);
	} 

/*
 * 文件导入
 * 
 */
function importTree()
{
	$("#_importbtn").click(function(){
		var _this = $(".filei-mport");
		_this.click();
		
		
	});
	$(".chimport").on("change","input[type='file']",function(){
	    var filePath=$(this).val();
	    $("#_namespan").val(filePath);
	});
}

/**
 *检测是否记住cookie
 * @param em
 * @param pwd
 * @param time
 */
function option(em,pwd,time)
{
	var option=$("#expire");//不能getElementById，ById又只会读数组第一个值
	
	if(option.checked)
		{
			setCookie("login_email",em,time);
			setCookie("login_password",pwd,time);
		}
	else{
			setCookie("login_password","",time);
	}
	}

/**
 * 检查cookie中是否有我的cookie信息
 */
function checkLogin()
{
	  var username=getCookie("login_email");
	  var userpwd = getCookie("login_password");
	  
	  //alert("email="+username+","+"pwd="+userpwd);
	  if (username!="" && userpwd!="")
	  {
	    $("#login_email").val(username);
	    $("#login_password").val(userpwd);
	    $("#_loginbtn").click();
	  }
	}
/**
 * 设置cookie
 * @param cname KEY
 * @param cvalue VALUE
 * @param exdays TIME
 */
function setCookie(cname,cvalue,exdays)
{
	try {
		var d = new Date();
		  d.setTime(d.getTime()+(exdays*24*60*60*1000));
		  var expires = "expires="+d.toGMTString();
		  document.cookie = cname + "=" + cvalue + "; " + expires;
	} catch (e) {
		alert("添加Cookie失败！")
	}
}

/**
 * 取出cookie
 * @param cname
 * @returns
 */
function getCookie(cname)
{
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) 
  {
    var c = ca[i].trim();
    //alert("cookie="+c.substring(name.length,c.length));
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}

/**
 * 检查cookie
 * @param cname
 */
function checkCookie(cname)
{
  var username=getCookie(cname);
  if (username!="")
  {
    alert("Welcome again " + username);
  }
  else 
  {
    username = prompt("Please enter your name:","");
    alert("未登录！");
  }
}

/**
 * @preserve
 * Project: Bootstrap Hover Dropdown
 * Author: Cameron Spear
 * Version: v2.2.1
 * Contributors: Mattia Larentis
 * Dependencies: Bootstrap's Dropdown plugin, jQuery
 * Description: A simple plugin to enable Bootstrap dropdowns to active on hover and provide a nice user experience.
 * License: MIT
 * Homepage: http://cameronspear.com/blog/bootstrap-dropdown-on-hover-plugin/
 */
;(function ($, window, undefined) {
    // outside the scope of the jQuery plugin to
    // keep track of all dropdowns
    var $allDropdowns = $();

    // if instantlyCloseOthers is true, then it will instantly
    // shut other nav items when a new one is hovered over
    $.fn.dropdownHover = function (options) {
        // don't do anything if touch is supported
        // (plugin causes some issues on mobile)
        if('ontouchstart' in document) return this; // don't want to affect chaining

        // the element we really care about
        // is the dropdown-toggle's parent
        $allDropdowns = $allDropdowns.add(this.parent());

        return this.each(function () {
            var $this = $(this),
                $parent = $this.parent(),
                defaults = {
                    delay: 500,
                    hoverDelay: 0,
                    instantlyCloseOthers: true
                },
                data = {
                    delay: $(this).data('delay'),
                    hoverDelay: $(this).data('hover-delay'),
                    instantlyCloseOthers: $(this).data('close-others')
                },
                showEvent   = 'show.bs.dropdown',
                hideEvent   = 'hide.bs.dropdown',
                // shownEvent  = 'shown.bs.dropdown',
                // hiddenEvent = 'hidden.bs.dropdown',
                settings = $.extend(true, {}, defaults, options, data),
                timeout, timeoutHover;

            $parent.hover(function (event) {
                // so a neighbor can't open the dropdown
                if(!$parent.hasClass('open') && !$this.is(event.target)) {
                    // stop this event, stop executing any code
                    // in this callback but continue to propagate
                    return true;
                }

                openDropdown(event);
            }, function () {
                // clear timer for hover event
                window.clearTimeout(timeoutHover)
                timeout = window.setTimeout(function () {
                    $this.attr('aria-expanded', 'false');
                    $parent.removeClass('open');
                    $this.trigger(hideEvent);
                }, settings.delay);
            });

            // this helps with button groups!
            $this.hover(function (event) {
                // this helps prevent a double event from firing.
                // see https://github.com/CWSpear/bootstrap-hover-dropdown/issues/55
                if(!$parent.hasClass('open') && !$parent.is(event.target)) {
                    // stop this event, stop executing any code
                    // in this callback but continue to propagate
                    return true;
                }

                openDropdown(event);
            });

            // handle submenus
            $parent.find('.dropdown-submenu').each(function (){
                var $this = $(this);
                var subTimeout;
                $this.hover(function () {
                    window.clearTimeout(subTimeout);
                    $this.children('.dropdown-menu').show();
                    // always close submenu siblings instantly
                    $this.siblings().children('.dropdown-menu').hide();
                }, function () {
                    var $submenu = $this.children('.dropdown-menu');
                    subTimeout = window.setTimeout(function () {
                        $submenu.hide();
                    }, settings.delay);
                });
            });

            function openDropdown(event) {
                if($this.parents(".navbar").find(".navbar-toggle").is(":visible")) {
                    // If we're inside a navbar, don't do anything when the
                    // navbar is collapsed, as it makes the navbar pretty unusable.
                    return;
                }

                // clear dropdown timeout here so it doesnt close before it should
                window.clearTimeout(timeout);
                // restart hover timer
                window.clearTimeout(timeoutHover);
                
                // delay for hover event.  
                timeoutHover = window.setTimeout(function () {
                    $allDropdowns.find(':focus').blur();

                    if(settings.instantlyCloseOthers === true)
                        $allDropdowns.removeClass('open');
                    
                    // clear timer for hover event
                    window.clearTimeout(timeoutHover);
                    $this.attr('aria-expanded', 'true');
                    $parent.addClass('open');
                    $this.trigger(showEvent);
                }, settings.hoverDelay);
            }
        });
    };

    $(document).ready(function () {
        // apply dropdownHover to all elements with the data-hover="dropdown" attribute
        $('[data-hover="dropdown"]').dropdownHover();
    });
	})(jQuery, window);
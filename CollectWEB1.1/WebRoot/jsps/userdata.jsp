<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/jsps/configuration.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Coll导航</title>
<%@ include file="jspbase/headbase.jsp"%>
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
	<div class="container-fluid row"style="margin-top: 100px; position: relative;">
		<div class="col-md-7 row" id="list_info">
			<div class="col-md-6 col-md-offset-3">
				<div class="item-head"><h4>用户资料</h4></div>
				<div class="item-info"><label class="lable-info">昵称</label><input type="text" value="${userinfo.user_name}"></div>
				<div class="item-info"><label class="lable-info">邮箱</label><input type="text" value="${userinfo.user_email}"></div>
				<div class="item-info"><label class="lable-info">N零后</label><input type="text" value="90后"></div>
				<div class="item-info"><label class="lable-info">性别</label><input type="text" value="男"></div>
				<div class="item-info"><label class="lable-info">职业</label><input type="text" value="${userinfo.profession}"></div>
				<div class="item-info"><label class="lable-info">兴趣</label>
					<div id="intension">
						<c:forEach items="${userinfo.user_catitmodel}" var="catit">
						<!-- <span>${catit.catit_intension}</span> -->
						<label>${catit.catit_name}</label>
					   	</c:forEach>
				   </div>
				</div>
			</div>
		</div>
		<div class="col-md-4" style="padding:20px;">
			<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
			<div id="mainechartsleida" style="width: 100%;height:250px;"></div>
			<div id="mainechartszhex" style="width: 100%;height:250px;"></div>
		</div>
	</div>
	<!-- 版权信息 -->
	<%@ include file="/jsps/jspbase/footer.jsp" %>
	
	<script src="<c:url value="/js/tree.js"/>"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#_sendmessage").focus();
			$("#_signal").addClass('active');
		})

		// 基于准备好的dom，初始化echarts实例
		var myChartleida = echarts.init(document
				.getElementById('mainechartsleida'));
		// 基于准备好的dom，初始化echarts实例
		var myChartzhex = echarts.init(document
				.getElementById('mainechartszhex'));

		// 指定图表的配置项和数据
		var optionleida = {
			title: {
		        text: '浏览热度',
		        textStyle:{
		        	fontWeight:'normal',
		        },
		        x: '10%'
		    },
			tooltip : {
				trigger : 'axis'
			},
			legend : {
				x : 'center',
				data : [ '偏向' ]
			},
			radar : [ {
				indicator: (function (){
				var res = [];
					<c:forEach items='${userinfo.user_catitmodel}' var="catit">
						res.push({text:'${catit.catit_name}',max:100});
					</c:forEach>
				return res;
            })(),
				center : [ '50%', '50%' ],
				radius : 70
			} ],
			series : [ {
				type : 'radar',
				tooltip : {
					trigger : 'item'
				},
				itemStyle : {
					normal : {
						areaStyle : {
							type : 'default'
						}
					}
				},
				data : [ {
					value : [ 
						<c:forEach items='${userinfo.user_catitmodel}' var="catit">
						${catit.catit_intension},
						</c:forEach>
					 ],
					name : '偏向'
				} ]
			} ]
		};
		var optionzhex = {
			title: {
		        text: '浏览统计',
		        textStyle:{
		        	fontWeight:'normal',
		        },
		        x: '10%'
		    },
			tooltip : {
				trigger : 'axis'
			},

			legend : [ {
				x : 'center',
				data : [ '偏向' ]
			}, {
				data : [ '最多次数', '最低次数' ]
			} ],
			toolbox : {
				show : true,
				feature : {
					magicType : {
						type : [ 'line', 'bar' ]
					},
					restore : {},
					saveAsImage : {}
				}
			},
			grid : {
				top : '30%',
				left : '20%',
				right : '20%'
			},
			xAxis : {
				type : 'category',
				name : '天(次/天)',
				boundaryGap : false,
				data : [ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
			},
			yAxis : {
				type : 'value',
				name : '次数',
				axisLabel : {
					formatter : '{value}'
				}
			},
			series : [ {
				name : '次数',
				type : 'line',
				data : [ 2, 3, 5, 6, 4, 8, 5 ],
				markPoint : {
					data : [ {
						type : 'max',
						name : '最大值'
					}, {
						type : 'min',
						name : '最小值'
					} ]
				},
				markLine : {
					data : [ {
						type : 'average',
						name : '平均值'
					} ]
				}
			} ]
		};

		// 使用刚指定的配置项和数据显示图表。
		myChartzhex.setOption(optionzhex);
		// 使用刚指定的配置项和数据显示图表。
		myChartleida.setOption(optionleida);
	</script>
</body>
</html>
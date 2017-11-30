<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>

<title><spring:message code="sys.title" /></title>
<jsp:include page="js.jsp"></jsp:include>
</head>
<body>
	<div id="navigation">
		<!--header-->
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div class="container-fluid" id="content">
		<!-- 左边栏 -->
		<div id="left">
			<jsp:include page="left.jsp"></jsp:include>
		</div>
		<div id="main">
			<div class="container-fluid">
				<div class="page-header">
					<div class="pull-left">
						<h1></h1>
					</div>

				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="box box-color box-bordered primary span5">
							<div class="box-title">
								<h3>
									<i class="icon-table"></i> 各类别流水账情况
								</h3>
							</div>
							<div class="box-content">
								<div>
									<div id="jounal_category" style="height:250px;"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="<%=basePath%>js/echarts/echarts.js"></script>
		<script type="text/javascript">
			function showJounalCategoryPie(dataName,dataSet){
				var j_category_chart = echarts.init($('#jounal_category')[0]);
				option = {
					    title : {
					        text: '各类别流水账情况',
					        subtext: '',
					        x:'center'
					    },
					    tooltip : {
					        trigger: 'item',
					        formatter: "{a} <br/>{b} : {c}笔 ({d}%)"
					    },
					    legend: {
					        orient: 'vertical',
					        left: 'left',
					        data: dataName //['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
					    },
					    series : [
					        {
					            name: '访问来源',
					            type: 'pie',
					            radius : '55%',
					            center: ['50%', '60%'],
					            data: dataSet,
					            /* 	[
					                {value:335, name:'直接访问'},
					                {value:310, name:'邮件营销'},
					                {value:234, name:'联盟广告'},
					                {value:135, name:'视频广告'},
					                {value:1548, name:'搜索引擎'}
					            ] ,*/
					            itemStyle: {
					                emphasis: {
					                    shadowBlur: 10,
					                    shadowOffsetX: 0,
					                    shadowColor: 'rgba(0, 0, 0, 0.5)'
					                }
					            }
					        }
					    ]
					};

				// 使用刚指定的配置项和数据显示图表。
				j_category_chart.setOption(option);
			}
		</script>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalCategory",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						/* alert("初始化成功!"); */
						showJounalCategoryPie(res.data_name,res.data_set);
					}else {
						alert("初始化失败!");
					}
				},
				error : function(res) {
					alert(res);
				}
			});
		});
	</script>
</body>
</html>
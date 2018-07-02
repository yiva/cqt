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
<html class="no-js">
<head>

<title><spring:message code="sys.title" /></title>
<jsp:include page="css.jsp"></jsp:include>
</head>
<body>
	<!--header-->
	<jsp:include page="header.jsp"></jsp:include>

	<div class="container-fluid" id="main-container">
		<!-- 左边栏 -->
		<jsp:include page="left.jsp"></jsp:include>

		<div id="main-content">
			<!-- BEGIN Page Title -->
			<div class="page-title">
				<div>
					<h1>
						<i class="icon-file-alt"></i> 常青藤
					</h1>
				</div>
				<!-- END Page Title -->
			</div>
			<!-- BEGIN Breadcrumb -->
			<div id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="active"><i class="icon-home"></i> 主页</li>
				</ul>
			</div>
			<!-- END Breadcrumb -->
			
			<!-- BEGIN Main Content -->
			<div class="row-fluid">
				<div class="span12">
					<div class="box box-black span6">
						<div class="box-title">
							<h3>
								<i class="icon-table"></i> 当前余额
							</h3>
							<div class="box-tool">
                                    <a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
                                    <a data-action="close" href="#"><i class="icon-remove"></i></a>
                                </div>
						</div>
						<div class="box-content">
							<div>
								<div id="jounal_balance" style="height: 100px;">
									<h2 align="center"></h2>
								</div>
							</div>
						</div>
					</div>
					<div class="box box-black span6">
						<div class="box-title">
							<h3>
								<i class="icon-table"></i> 当月收支情况
							</h3>
							<div class="box-tool">
                                    <a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
                                    <a data-action="close" href="#"><i class="icon-remove"></i></a>
                                </div>
						</div>
						<div class="box-content">
							<div>
								<div id="jounal_current_month"
									style="height: 100px; text-align: center;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row-fluid">

				<div class="span12">
					<div class="box box-black span6">
						<div class="box-title">
							<h3>
								<i class="icon-table"></i> 各类别流水账情况
							</h3>
							<div class="box-tool">
                                    <a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
                                    <a data-action="close" href="#"><i class="icon-remove"></i></a>
                                </div>
						</div>
						<div class="box-content">
							<div>
								<div id="jounal_category" style="height: 250px;">
									<h2></h2>
								</div>
							</div>
						</div>
					</div>
					<div class="box box-black span6">
						<div class="box-title">
							<h3>
								<i class="icon-table"></i> 各月收支情况
							</h3>
							<div class="box-tool">
                                    <a data-action="collapse" href="#"><i class="icon-chevron-up"></i></a>
                                    <a data-action="close" href="#"><i class="icon-remove"></i></a>
                                </div>
						</div>
						<div class="box-content">
							<div>
								<div id="jounal_month" style="height: 250px;"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="js.jsp"></jsp:include>
	
	<script type="text/javascript" src="<%=basePath%>js/echarts/echarts.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/echarts/jounal_category.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>js/echarts/jounal_month.js"></script>
	<script type="text/javascript">
		$(function() {
			switchNavActive("#sidebar-nav-index");
			//显示余额
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalBalance",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						$('#jounal_balance > h2').text(res.data_set.ba_balance);
					}else {
						$('#jounal_balance > h2').text('暂无数据');
					}
				},
				error : function(res) {
					console.log(res);
				}
			});
			//各类占比
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalCategory",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						showJounalCategoryPie(res.data_name,res.data_set,'jounal_category');
					}else {
						console.log("初始化失败!");
					}
				},
				error : function(res) {
					console.log(res);
				}
			});
			//当年各月情况
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalMonth",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						/* alert("初始化成功!"); */
						showJounalSumMonthBar(res.data_name, res.data_set,'jounal_month');
					} else {
						console.log("初始化失败!");
					}
				},
				error : function(res) {
					console.log(res);
				}
			});
			//当月收支情况
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalCurrentMonth",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						$('#jounal_current_month').html(
								'<h4><span>当月入账：</span>'
										+ res.data_set.price_in
										+ '<span>&nbsp;&nbsp;入账笔数：</span>'
										+ res.data_set.counts_in
										+ '</h4><h4><span>当月出账：</span>'
										+ res.data_set.price_out
										+ '<span>&nbsp;&nbsp;出账笔数：</span>'
										+ res.data_set.counts_out + '</h4>');
					} else {
						$('#jounal_current_month').html('<h2>暂无数据</h2>');
					}
				},
				error : function(res) {
					console.log(res);
				}
			});
		});
	</script>
</body>
</html>
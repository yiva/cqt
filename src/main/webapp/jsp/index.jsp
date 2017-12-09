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
						<div class="box box-color box-bordered primary span6">
							<div class="box-title">
								<h3>
									<i class="icon-table"></i> 各类别流水账情况
								</h3>
							</div>
							<div class="box-content">
								<div>
									<div id="jounal_category" style="height: 250px;"></div>
								</div>
							</div>
						</div>
						<div class="box box-color box-bordered primary span6">
							<div class="box-title">
								<h3>
									<i class="icon-table"></i> 各月收支情况
								</h3>
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
	</div>
	<script type="text/javascript" src="<%=basePath%>js/echarts/echarts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/echarts/jounal_category.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/echarts/jounal_month.js"></script>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalCategory",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						showJounalCategoryPie(res.data_name,res.data_set,'jounal_category');
					}else {
						alert("初始化失败!");
					}
				},
				error : function(res) {
					alert(res);
				}
			});
			$.ajax({
				type : "GET",
				url : "<%=basePath%>chart/jounalMonth",
				data : {},
				dataType : "json",
				success : function(res) {
					if ('0' != res) {
						console.log(res)
						/* alert("初始化成功!"); */
						showJounalSumMonthBar(res.data_name, res.data_set,'jounal_month');
					} else {
						alert("初始化失败!");
					}
				},
				error : function(res) {
					alert(res);
				}
			});
		});
	</script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
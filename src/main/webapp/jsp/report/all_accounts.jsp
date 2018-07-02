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

<title>台账信息 - <spring:message code="sys.title" /></title>
<jsp:include page="../css.jsp"></jsp:include>
</head>
<body>
	<!--header-->
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container-fluid" id="main-container">
		<!-- 左边栏 -->
		<jsp:include page="../left.jsp"></jsp:include>
		<div id="main-content">
			<!-- BEGIN Page Title -->
			<div class="page-title">
				<div>
					<h1>
						<i class="icon-file-alt"></i> 台账查询
					</h1>
				</div>
				<!-- END Page Title -->
			</div>
			<!-- BEGIN Breadcrumb -->
			<div id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="active"><i class="icon-home"></i> 总台账</li>
				</ul>
			</div>
			<!-- END Breadcrumb -->
			
			<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-content">
								<div class="span12">
									<div class="box box-black">
										<div class="box-title">
											<h3>
												<i class="icon-table"></i> 总台账
											</h3>
										</div>
										<div class="box-content nopadding">
											<table
												class="table table-bordered dataTable dataTable-scroll-x">
												<thead>
													<tr>
														<th>ID</th>
														<th>主题</th>
														<th>日期</th>
														<th>收支类别</th>
														<th>摘要</th>
														<th>收支金额</th>
														<th>经手人</th>
														<th>备注</th>
														<th>台账类型</th>
														<th>学生编号</th>
														<th>创建时间</th>
														<th>更新时间</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${accountlist}" var="item">
														<tr>
															<td>${item.id}</td>
															<td>${item.ac_title}</td>
															<td>${item.ac_date}</td>
															<td>${item.ac_type}</td>
															<td>${item.ac_content}</td>
															<td>${item.ac_cost}</td>
															<td>${item.ac_handler}</td>
															<td>${item.ac_comment}</td>
															<td>${item.ac_category}</td>
															<td>${item.ac_num}</td>
															<td>${item.create_time}</td>
															<td>${item.update_time}</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>

	<jsp:include page="../js.jsp"></jsp:include>
	<!-- slimScroll -->
	<script
		src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#mkCurrentRepo").click(function() {
				$.ajax({
					type : "GET",
					url : "<%=basePath%>salary/mkCurrentRepo",
					data : {},
					dataType : "json",
					success : function(res) {
						if ('1' == res) {
							alert("初始化成功!");
							window.location.reload();
						} else if ('-1' == res) {
							alert("当月初始化数据已生成!");
						} else {
							alert("初始化失败!");
						}
					},
					error : function(res) {
						alert(res);
					}
				});
			});
		});
	</script>
</body>

</html>
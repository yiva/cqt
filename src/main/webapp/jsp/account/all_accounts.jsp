<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>当前月工资初始化 - <spring:message code="sys.title" /></title>
<jsp:include page="../js.jsp"></jsp:include>
<!-- dataTables -->
<link rel="stylesheet"
	href="<%=basePath%>css/plugins/datatable/TableTools.css">
</head>
<body>
	<div id="navigation">
		<!--header-->
		<jsp:include page="../header.jsp"></jsp:include>
	</div>
	<div class="container-fluid" id="content">
		<!-- 左边栏 -->
		<div id="left">
			<jsp:include page="../left.jsp"></jsp:include>
		</div>
		<div id="main">
			<div class="container-fluid">
				<div class="page-header"></div>
				<div class="breadcrumbs">
					<ul>
						<li><a href="#">台账查询</a> <i class="icon-angle-right"></i></li>
					</ul>
					<div class="close-bread">
						<a href="#"><i class="icon-remove"></i></a>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="box">
							<div class="box-content">
								<div class="span12">
									<div class="box box-color box-bordered primary">
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
	</div>

	<!-- slimScroll -->
	<script
		src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#mkCurrentRepo").click(function() {
				$.ajax({
					type : "GET",
					url : "<%=basePath%>
		salary/mkCurrentRepo",
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
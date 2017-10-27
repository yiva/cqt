<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>学习用品 - <spring:message code="sys.title" /></title>
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
												<i class="icon-table"></i> 学习用品转发情况
											</h3>
										</div>
										<div class="box-content nopadding">
											<table
												class="table table-bordered dataTable dataTable-scroll-x">
												<thead>
													<tr>
														<th>编号</th>
														<th>姓名</th>
														<th>资助地</th>
														<th>资助人</th>
														<th>就读学校</th>
														<th>年级</th>
														<th>采购环节</th>
														<th>采购单价</th>
														<th>转运环节</th>
														<th>转运费用</th>
														<th>学习用品转发人</th>
														<th>转发时间</th>
														<th>采购款划拨时间</th>
														<th>创建时间</th>
														<th>更新时间</th>

													</tr>
												</thead>
												<tbody>
													<c:forEach items="${articlelist}" var="item">
														<tr>
															<td>${item.art_num}</td>
															<td>${item.art_name}</td>
															<td>${item.art_loc}</td>
															<td>${item.art_reward}</td>
															<td>${item.art_school}</td>
															<td>${item.art_grade}</td>
															<td>${item.art_mode}</td>
															<td>${item.art_price}</td>
															<td>${item.art_trans}</td>
															<td>${item.art_trans_cost}</td>
															<td>${item.art_sender}</td>
															<td>${item.art_time}</td>
															<td>${item.art_remit_time}</td>
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
		</script>
</body>

</html>
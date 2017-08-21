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

<title>工资表 - <spring:message code="sys.title" /></title>
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
						<li><a href="#">当月工资表</a> <i class="icon-angle-right"></i></li>
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
												<i class="icon-table"></i> 当月工资表
											</h3>
										</div>
										<div class="box-content nopadding">
											<table
												class="table table-bordered dataTable dataTable-scroll-x">
												<thead>
													<tr>
														<th>序号</th>
														<th>部门</th>
														<th>姓名</th>
														<th>岗位工资</th>
														<th>其他</th>
														<th>资历工资</th>
														<th>回民小伙食补贴</th>
														<th>加班费</th>
														<th>事假</th>
														<th>病假</th>
														<th>应发小计</th>
														<th>失业保险</th>
														<th>养老保险</th>
														<th>企业年金</th>
														<th>医疗保险</th>
														<th>公积金</th>
														<th>税金</th>
														<th>应扣小计</th>
														<th>实发小计</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${salaryReportlist}" var="item">
														<tr>
															<td>${item.id}</td>
															<td>${item.dept}</td>
															<td>${item.employee}</td>
															<td>${item.salary_station}</td>
															<td>${item.salary_other}</td>
															<td>${item.salary_age}</td>
															<td>${item.salary_special_nation}</td>
															<td>${item.salary_overtime}</td>
															<td>${item.s_leave}</td>
															<td>${item.sick}</td>
															<td>${item.sum_salary_should}</td>
															<td>${item.unemployment}</td>
															<td>${item.s_old}</td>
															<td>${item.company_reward}</td>
															<td>${item.medical_insurance}</td>
															<td>${item.housing_fund}</td>
															<td>${item.fact_tax}</td>
															<td>${item.sum_deduction}</td>
															<td>${item.sum_fact}</td>
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
</body>

</html>
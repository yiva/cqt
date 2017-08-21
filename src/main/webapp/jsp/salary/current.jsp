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
						<li><a href="#">当月工资查询</a> <i class="icon-angle-right"></i></li>
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
												<i class="icon-table"></i> 当前月工资计算初始化表
											</h3>
											<div class="pull-right span1 offset6">
												<button class="btn btn-inverse" id="mkCurrentRepo">生成报表</button>
											</div>
										</div>
										<div class="box-content nopadding">
											<table
												class="table table-bordered dataTable dataTable-scroll-x">
												<thead>
													<tr>
														<th>ID</th>
														<th>部门</th>
														<th>姓名</th>
														<th>岗位工资</th>
														<th>其他</th>
														<th>资历工资</th>
														<th>回民小伙食补贴</th>
														<th>加班费</th>
														<th>加班天数</th>
														<th>事假</th>
														<th>事假天数</th>
														<th>病假</th>
														<th>病假天数</th>
														<th>病假不满6个月扣比例</th>
														<th>应发小计</th>
														<th>失业保险</th>
														<th>养老保险</th>
														<th>企业年金</th>
														<th>医保费</th>
														<th>公积金</th>
														<th>补扣企业年金税金</th>
														<th>津贴</th>
														<th>扣除部分</th>
														<th>应税金额</th>
														<th>税金</th>
														<th>应扣小计</th>
														<th>实发小计</th>
														<th>其他扣除</th>
														<th>备注</th>
														<th>录入时间</th>

													</tr>
												</thead>
												<tbody>
													<c:forEach items="${salarylist}" var="item">
														<tr>
															<td>${item.base_id}</td>
															<td>${item.dept}</td>
															<td>${item.name}</td>
															<td>${item.salary_station}</td>
															<td>${item.salary_other}</td>
															<td>${item.salary_age}</td>
															<td>${item.salary_special_nation}</td>
															<td>${item.salary_overtime}</td>
															<td>${item.days_overtime}</td>
															<td>${item.s_leave}</td>
															<td>${item.days_leave}</td>
															<td>${item.sick}</td>
															<td>${item.days_sick}</td>
															<td>${item.rate_days_sick_less_half_year}</td>
															<td>${item.sum_salary_should}</td>
															<td>${item.unemployment}</td>
															<td>${item.s_old}</td>
															<td>${item.company_reward}</td>
															<td>${item.medical_insurance}</td>
															<td>${item.housing_fund}</td>
															<td>${item.tax_year}</td>
															<td>${item.allowances}</td>
															<td>${item.deduction}</td>
															<td>${item.receivable_tax}</td>
															<td>${item.fact_tax}</td>
															<td>${item.sum_deduction}</td>
															<td>${item.sum_fact}</td>
															<td>${item.deduct_other}</td>
															<td>${item.comments}</td>
															<td>${item.s_date}</td>
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
					url : "<%=basePath%>salary/mkCurrentRepo",
					data : {},
					dataType : "json",
					success : function(res) {
						if('1' == res){
							alert("初始化成功!");
							window.location.reload();
						}else if('-1' == res){
							alert("当月初始化数据已生成!");
						}else{
							alert("初始化失败!");
						}
					},
					error:function(res){
						alert(res);
					}
				});
			});
		});
	</script>
</body>

</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title><spring:message code="sys.title"/></title>
<jsp:include page="js.jsp"></jsp:include>
<!-- dataTables -->
<link rel="stylesheet"
	href="<%=basePath%>css/plugins/datatable/TableTools.css">
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
				</div>
				<div class="breadcrumbs">
					<ul>
						<li><a href="#">职工资料查询</a> <i class="icon-angle-right"></i></li>
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
												<i class="icon-table"></i> 职工详细信息
											</h3>
										</div>
										<div class="box-content nopadding">
										<table class="table table-bordered dataTable dataTable-scroll-x">
												<thead>
													<tr>
														<th>ID</th>
														<th>编码</th>
														<th>编号</th>
														<th>序号</th>
														<th>姓名</th>
														<th>部门1</th>
														<th>部门2</th>
														<th>岗位名称</th>
														<th>岗位类别</th>
														<th>岗位序列</th>
														<th>职务级别</th>
														<th>性别</th>
														<th>身份证号</th>
														<th>用工形式</th>
														<th>劳动关系确定方式</th>
														<th>劳动关系主体</th>
														<th>劳动合同期</th>
														<th>合同起始时间</th>
														<th>合同到期时间</th>
														<th>独生子女生日</th>
														<th>工龄</th>
														<th>当前学历</th>
														<th>当前学位</th>
														<th>专业技术职务等级</th>
														<th>技能等级</th>
														<th>持有证件名称</th>
														<th>持有证件数量</th>
														<th>技术带头人</th>
														<th>民族</th>
														<th>出生日期</th>
														<th>年龄</th>
														<th>参加工作时间年</th>
														<th>参加工作时间月</th>
														<th>职称</th>
														<th>参加工作学历</th>
														<th>毕业院校</th>
														<th>毕业专业</th>
														<th>毕业时间</th>
														<th>毕业院校</th>
														<th>毕业专业</th>
														<th>毕业时间</th>
														<th>单项奖系数</th>
														<th>定岗岗级</th>
														<th>执行岗级</th>
														<th>薪级</th>
														<th>薪点</th>
														<th>岗位点值</th>
														<th>月度绩效执行岗级</th>
														<th>月度绩效薪级</th>
														<th>月度绩效薪点</th>
														<th>月度绩效点值</th>
														<th>绩效工资倾斜率</th>
														<th>业绩考核系数</th>
														<th>绩效兑现比率</th>
														<th>岗位工资兑现比率</th>
														<th>绩效岗级系数</th>
														<th>月平均</th>
														<th>医保基数</th>
														<th>省社平</th>
														<th>市社平</th>
														<th>失业保险单位</th>
														<th>失业保险个人</th>
														<th>养老保险单位</th>
														<th>养老保险个人</th>
														<th>企业年金单位</th>
														<th>企业年金个人</th>
														<th>医保费单位</th>
														<th>医保费个人</th>
														<th>公积金单位</th>
														<th>公积金个人</th>
														<th>其他增加点值</th>
														<th>实补扣年金税金</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${emplist}" var="item">
														<tr>
															<td>${item.id}</td>
															<td>${item.num_code}</td>
															<td>${item.sub_num}</td>
															<td>${item.sub_sub_num}</td>
															<td>${item.employee}</td>
															<td>${item.dept}</td>
															<td>${item.sub_dept}</td>
															<td>${item.job_name}</td>
															<td>${item.job_type}</td>
															<td>${item.job_queue}</td>
															<td>${item.job_level}</td>
															<td>${item.gender}</td>
															<td>${item.id_card}</td>
															<td>${item.emp_type}</td>
															<td>${item.emp_submit_type}</td>
															<td>${item.emp_parent}</td>
															<td>${item.contract_type}</td>
															<td>${item.contract_begin}</td>
															<td>${item.contract_end}</td>
															<td>${item.single_child_birthday}</td>
															<td>${item.work_age}</td>
															<td>${item.current_education}</td>
															<td>${item.current_degree}</td>
															<td>${item.tech_job_level}</td>
															<td>${item.tech_level}</td>
															<td>${item.certificates}</td>
															<td>${item.certificate_count}</td>
															<td>${item.tech_leader}</td>
															<td>${item.nation}</td>
															<td>${item.birthday}</td>
															<td>${item.age}</td>
															<td>${item.work_year}</td>
															<td>${item.work_month}</td>
															<td>${item.prof_title}</td>
															<td>${item.work_education}</td>
															<td>${item.education_school}</td>
															<td>${item.education_major}</td>
															<td>${item.education_time}</td>
															<td>${item.education_school_1}</td>
															<td>${item.education_major_1}</td>
															<td>${item.education_time_1}</td>
															<td>${item.single_rate}</td>
															<td>${item.station_level}</td>
															<td>${item.true_station_level}</td>
															<td>${item.salary_level}</td>
															<td>${item.salary_point}</td>
															<td>${item.station_point}</td>
															<td>${item.performance_station_level}</td>
															<td>${item.performance_salary_level}</td>
															<td>${item.performance_salary_point}</td>
															<td>${item.performance_point}</td>
															<td>${item.performance_rate}</td>
															<td>${item.performance_examine_rate}</td>
															<td>${item.performance_promise_rate}</td>
															<td>${item.station_salary_promise_rate}</td>
															<td>${item.performance_station_rate}</td>
															<td>${item.salary_average_monthly}</td>
															<td>${item.base_medical_insurance}</td>
															<td>${item.society_average_province}</td>
															<td>${item.society_average_city}</td>
															<td>${item.unemployment_company}</td>
															<td>${item.unemployment_person}</td>
															<td>${item.old_company}</td>
															<td>${item.old_person}</td>
															<td>${item.company_reward_company}</td>
															<td>${item.company_reward_person}</td>
															<td>${item.medical_insurance_company}</td>
															<td>${item.medical_insurance_person}</td>
															<td>${item.housing_fund_company}</td>
															<td>${item.housing_fund_person}</td>
															<td>${item.other1}</td>
															<td>${item.fact_tax_year}</td>
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
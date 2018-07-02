
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

<title>流水账审核 - <spring:message code="sys.title" /></title>
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
						<i class="icon-file-alt"></i> 流水账查询
					</h1>
				</div>
				<!-- END Page Title -->
			</div>
			<!-- BEGIN Breadcrumb -->
			<div id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="active"><i class="icon-home"></i> 流水账审核</li>
				</ul>
			</div>
			<!-- END Breadcrumb -->
			
			<div class="row-fluid">
					<div class="span12">
						<div class="box box-black">
							<div class="box-content">
								<div class="span12">
									<div class="box box-color box-bordered primary">
										<div class="box-title">
											<div class="span3">
												<h3>
													<i class="icon-table"></i> 流水账查询
												</h3>
											</div>
											<div class="pull-right">
												<button id="btn_set_status_true" class="btn btn-primary">确认</button>
												<button id="btn_del" class="btn btn-danger">删除</button>
											</div>
										</div>
										<div class="box-content nopadding">
											<table
												class="table table-bordered dataTable dataTable-scroll-x">
												<thead>
													<tr>
														<th>项目类型</th>
														<th>时间</th>
														<th>转入转出</th>
														<!-- <th>类型名</th> -->
														<th>摘要</th>
														<th>流水金额</th>
														<th>记账人</th>
														<th>进款通道</th>
														<th>款项结存</th>
														<th>提现费</th>
														<th>备注</th>
														<th>资助人</th>
														<!-- <th>资助人姓名</th> -->
														<th>学生</th>
														<!-- <th>学生姓名</th> -->
														<th>创建时间</th>
														<th>更新时间</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${jounalist}" var="item">
														<tr>
															<td>${item.ac_category}</td>
															<td>${item.ac_date}</td>
															<%-- <td>${item.ac_type}</td> --%>
															<td>${item.ac_type_name}</td>
															<td>${item.ac_content}</td>
															<td>${item.ac_price}</td>
															<td>${item.ac_operater}</td>
															<td>${item.ac_channel}</td>
															<td>${item.ac_save_style}</td>
															<td>${item.ac_poudage}</td>
															<td>${item.ac_comment}</td>
															<%-- <td>${item.ac_rewarder}</td> --%>
															<td>${item.ac_rewarder_name}</td>
															<%-- <td>${item.ac_student}</td> --%>
															<td>${item.ac_student_name}</td>
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

<jsp:include page="../css.jsp"></jsp:include>
	<!-- slimScroll -->
	<script
		src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#btn_set_status_true').click(function(){
				$.ajax({
	             	type: 'post', // 提交方式 get/post
	            		url: "<%=basePath%>report/submitJounalStatus",
	            		dataType : 'json',
	            		success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
	              // 此处可对 data 作相关处理
	              if (data == -1) {
	                alert('提交失败');
	              } else {
	                alert('提交成功！');
	                $(location).attr('href', "<%=basePath%>report/showJounals");
	              }
	            }
				});
			});
		});
	</script>
</body>

</html>
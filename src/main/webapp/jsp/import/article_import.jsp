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
<!DOCTYPE html>
<html class="no-js">
<head>

<title>学习用品报表操作 - <spring:message code="sys.title" /></title>
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
						<i class="icon-file-alt"></i> 台账导入
					</h1>
				</div>
				<!-- END Page Title -->
			</div>
			<!-- BEGIN Breadcrumb -->
			<div id="breadcrumbs">
				<ul class="breadcrumb">
					<li class="active"><i class="icon-home"></i> 学习用品录入</li>
				</ul>
			</div>
			<!-- END Breadcrumb -->
			
			<div class="row-fluid">
					<div class="span12">
						<div class="box box-black">
							<div class="box-title">
								<h3>
									<i class="icon-edit"></i>Excel导入
								</h3>
							</div>
							<div class="box-content">
								<form id="reportForm" action="#" method="post"
									enctype="mutlipart/form-data"
									class='form-horizontal form-bordered'>
									<div class="control-group">
										<label for="select" class="control-label">台账类别</label>
										<div class="controls">
											<select name="account_category" id="account_category" class='input-large'>
												<option value="all">学习用品转发汇总表</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label for="file" class="control-label">表格</label>
										<div class="controls">
											<input type="file" name="file" id="file"
												class="input-block-level">
										</div>
									</div>
									<div class="control-group">
										<label for="file" class="control-label"></label>
										<div class="controls">
											<button id="reportSubmit" class="btn btn-primary">确定</button>
											<button class="btn btn-cancel">重置</button>
										</div>
									</div>
								</form>
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
		$(function(){
			switchNavActive("#sidebar-nav-input-article");
			$('#reportSubmit').click(function(){
				$('#reportForm').submit(function() {

			        $(this).ajaxSubmit({
			            type: 'post', // 提交方式 get/post
			            url: "<%=basePath%>imptExcelWithArticle",
						dataType : 'json',
						success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
							// 此处可对 data 作相关处理
							if (data == -1) {
								alert('提交失败');
							} else {
								alert('提交成功！');
							}
						}
					});
					$(this).resetForm(); // 提交后重置表单
					return false; // 阻止表单自动提交事件
				});
			});
		});
	</script>
</body>

</html>
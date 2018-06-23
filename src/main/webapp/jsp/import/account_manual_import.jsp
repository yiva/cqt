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

<title>报表操作 - <spring:message code="sys.title" /></title>
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
						<li><a href="#">台账导入</a> <i class="icon-angle-right"></i></li>
					</ul>
					<div class="close-bread">
						<a href="#"><i class="icon-remove"></i></a>
					</div>
				</div>
				<div class="row-fluid">
					<div class="span12">
						<div class="box box-bordered">
							<div class="box-title">
								<h3>
									<i class="icon-edit"></i>Excel导入
								</h3>
							</div>
							<div class="box-content nopadding">
								<form id="reportForm" action="#" method="post"
									enctype="mutlipart/form-data"
									class='form-horizontal form-bordered'>
									<div class="control-group">
										<label for="select" class="control-label">台账类别</label>
										<div class="controls">
											<select name="account_category" id="account_category" class='input-large'>
												<option value="all">所有台账</option>
												<option value="one">一对一</option>
												<option value="gongyi">公益金</option>
												<option value="zanshang">赞赏款</option>
												<option value="xiangxue">奖学金</option>
												<option value="zhiliu">滞留助学金收支</option>
												<option value="other">其他</option>
												<option value="alone">独立流水</option>
												<option value="wqtixian">微信提现流水</option>
												<option value="wqgongzhong">微信公众号入账	</option>
												<option value="yuebao">余额宝收益</option>
												<option value="daizhu">待助</option>
												<option value="jounal">流水账</option>
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
	</div>

	<!-- slimScroll -->
	<script
		src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$('#reportSubmit').click(function(){
				/* $('#reportSubmit').attr('disabled',"true"); */
				$('#reportForm').submit(function() {

			        $(this).ajaxSubmit({
			            type: 'post', // 提交方式 get/post
			            url: "<%=basePath%>imptExcelTest",
						dataType : 'json',
						success : function(data) { // data 保存提交后返回的数据，一般为 json 数据
							// 此处可对 data 作相关处理
							if (data == -1) {
								alert('提交失败');
							} else {
								alert('提交成功！');
								$(location).attr('href', "<%=basePath%>report/showJounalsTmp");
							}
						}
					});
			        $('#reportSubmit').removeAttr("disabled");
					$(this).resetForm(); // 提交后重置表单
					return false; // 阻止表单自动提交事件
				});
			});
		});
	</script>
</body>

</html>
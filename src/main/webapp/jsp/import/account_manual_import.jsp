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
						<li><a href="#">台账录入</a> <i class="icon-angle-right"></i></li>
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
									<i class="icon-edit"></i>台账录入
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
										<label for="select" class="control-label">台账性质</label>
										<div class="controls">
											<select name="ac_type" id="ac_type" class='input-large'>
												<option value="1">转入</option>
												<option value="2">转出</option>
												<option value="3">收入</option>
												<option value="4">开支</option>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label for="input" class="control-label">主题</label>
										<div class="controls">
											<input type="text" name="ac_title" id="ac_title"
												class="input-block-level span3">
										</div>
									</div>
									<div class="control-group">
                                      <label class="control-label">日期</label>
                                      <div class="controls">
                                      		<input type="text" name="ac_date" id="ac_date"
												class="input-block-level span3">
                                      </div>
                                   </div>
									<div class="control-group">
										<label for="input" class="control-label">金额</label>
										<div class="controls">
											<input type="text" name="ac_cost" id="ac_cost"
												class="input-block-level span3">
										</div>
									</div>
									<div class="control-group">
										<label for="input" class="control-label">摘要</label>
										<div class="controls">
											<textarea name="ac_content" id="ac_content" class="span6" rows="3"></textarea>
										</div>
									</div>
									<div class="control-group">
										<label for="input" class="control-label"></label>
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
				alert();
			});
		</script>
</body>

</html>
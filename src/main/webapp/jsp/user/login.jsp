<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
	<!-- Apple devices fullscreen -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<!-- Apple devices fullscreen -->
	<meta names="apple-mobile-web-app-status-bar-style" content="black-translucent" />
	
	<title>第三通信团网上交班系统</title>

	<!-- Bootstrap -->
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
	<!-- Bootstrap responsive -->
	<link rel="stylesheet" href="<%=basePath %>css/bootstrap-responsive.min.css">
	<!-- icheck -->
	<link rel="stylesheet" href="<%=basePath %>css/plugins/icheck/all.css">
	<!-- Theme CSS -->
	<link rel="stylesheet" href="<%=basePath %>css/style.css">
	<!-- Color CSS -->
	<link rel="stylesheet" href="<%=basePath %>css/themes.css">


	<!-- jQuery -->
	<script src="<%=basePath %>js/jquery.min.js"></script>
	
	<!-- Nice Scroll -->
	<script src="<%=basePath %>js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
	<!-- Validation -->
	<script src="<%=basePath %>js/plugins/validation/jquery.validate.min.js"></script>
	<script src="<%=basePath %>js/plugins/validation/additional-methods.min.js"></script>
	<!-- icheck -->
	<script src="<%=basePath %>js/plugins/icheck/jquery.icheck.min.js"></script>
	<!-- Bootstrap -->
	<script src="<%=basePath %>js/bootstrap.min.js"></script>
	<script src="<%=basePath %>js/eakroko.js"></script>

	<!-- Favicon -->
	<link rel="shortcut icon" href="<%=basePath %>img/favicon.ico" />
	<!-- Apple devices Homescreen icon -->
	<link rel="apple-touch-icon-precomposed" href="<%=basePath %>img/apple-touch-icon-precomposed.png" />

</head>

<body class='login'>
	<div class="wrapper">
		<div class="login-body" style="padding-bottom:25px;">
			<h2>用户登录</h2>
			<form action="loginvalid.action" method='post' class='form-validate' id="test">
				<div class="control-group">
					<div class="email controls">
						<input type="text" name='username' placeholder="用户名" class='input-block-level' data-rule-required="true">
					</div>
				</div>
				<div class="control-group">
					<div class="pw controls">
						<input type="password" name="password" placeholder="密码" class='input-block-level' data-rule-required="true">
					</div>
				</div>
				<div class="submit">
					<div class="remember" style="display:none;">
						<input type="checkbox" name="remember" class='icheck-me' data-skin="square" data-color="blue" id="remember"> <label for="remember">Remember me</label>
					</div>
					<input type="submit" value="登录" class='btn btn-primary '>
				</div>
			</form>
		</div>
	</div>
</body>

</html>
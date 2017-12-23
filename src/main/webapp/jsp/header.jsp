<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<div class="container-fluid">
	<a id="brand" href="<%=basePath%>"><spring:message code="sys.title"/></a>
	<a href="#" class="toggle-nav" rel="tooltip" data-placement="bottom" title="左边缩进"><i class="icon-reorder"></i></a>
	
	<div class="user">
		
		<div class="dropdown">
			<a href="#" class='dropdown-toggle' data-toggle="dropdown">用户名<img src="<%=basePath %>img/demo/user-avatar.jpg" alt=""></a>
			<ul class="dropdown-menu pull-right">
				<li>
					<a href="#">修改密码</a>
				</li>
				<li>
					<a href="#">退出登录</a>
				</li>
			</ul>
		</div>
	</div>
</div>
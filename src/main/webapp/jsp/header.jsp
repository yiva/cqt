<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="navbar" class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<!-- BEGIN Brand -->
			<a href="<%=basePath%>" class="brand"> <small> <i
					class="icon-desktop"></i> <spring:message code="sys.title" />
			</small>
			</a>
			<!-- END Brand -->
			<!-- BEGIN Responsive Sidebar Collapse -->
			<a href="#" class="btn-navbar collapsed" data-toggle="collapse"
				data-target=".nav-collapse"> <i class="icon-reorder"></i>
			</a>
			<!-- END Responsive Sidebar Collapse -->
			<!-- BEGIN Navbar Buttons -->
			<ul class="nav flaty-nav pull-right">
				<!-- BEGIN Button User -->
				<li class="user-profile"><a data-toggle="dropdown" href="#"
					class="user-menu dropdown-toggle"> <img class="nav-user-photo"
						src="img/demo/avatar/avatar1.jpg" alt="Penny's Photo" /> <span
						class="hidden-phone" id="user_info"> 用户名 </span> <i
						class="icon-caret-down"></i>
				</a> <!-- BEGIN User Dropdown -->
					<ul class="dropdown-menu dropdown-navbar" id="user_menu">
						<li><a href="#"> <i class="icon-user"></i> 修改密码
						</a></li>
						<li class="divider"></li>
						<li><a href="#"> <i class="icon-off"></i> 退出登录
						</a></li>
					</ul> <!-- BEGIN User Dropdown --></li>
				<!-- END Button User -->
			</ul>
			<!-- END Navbar Buttons -->
		</div>
	</div>
</div>
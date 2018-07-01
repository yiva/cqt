<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
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
				class="hidden-phone" id="user_info"> Penny </span> <i
				class="icon-caret-down"></i>
		</a> <!-- BEGIN User Dropdown -->
			<ul class="dropdown-menu dropdown-navbar" id="user_menu">
				<li class="nav-header"><i class="icon-time"></i> Logined From
					20:45</li>

				<li><a href="#"> <i class="icon-cog"></i> Account Settings
				</a></li>

				<li><a href="#"> <i class="icon-user"></i> Edit Profile
				</a></li>

				<li><a href="#"> <i class="icon-question"></i> Help
				</a></li>

				<li class="divider visible-phone"></li>

				<li class="visible-phone"><a href="#"> <i
						class="icon-tasks"></i> Tasks <span class="badge badge-warning">4</span>
				</a></li>
				<li class="visible-phone"><a href="#"> <i
						class="icon-bell-alt"></i> Notifications <span
						class="badge badge-important">8</span>
				</a></li>
				<li class="visible-phone"><a href="#"> <i
						class="icon-envelope"></i> Messages <span
						class="badge badge-success">5</span>
				</a></li>

				<li class="divider"></li>

				<li><a href="#"> <i class="icon-off"></i> Logout
				</a></li>
			</ul> <!-- BEGIN User Dropdown --></li>
		<!-- END Button User -->
	</ul>
	<!-- END Navbar Buttons -->
	<div class="user">

		<div class="dropdown">
			<a href="#" class='dropdown-toggle' data-toggle="dropdown">用户名<img
				src="<%=basePath%>img/demo/user-avatar.jpg" alt=""></a>
			<ul class="dropdown-menu pull-right">
				<li><a href="#">修改密码</a></li>
				<li><a href="#">退出登录</a></li>
			</ul>
		</div>
	</div>
</div>
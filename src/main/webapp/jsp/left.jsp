<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<ul class="nav nav-list">
	<!-- BEGIN Search Form -->
	<li style="display:none;">
		<form target="#" method="GET" class="search-form">
			<span class="search-pan">
				<button type="submit">
					<i class="icon-search"></i>
				</button> <input type="text" name="search" placeholder="Search ..."
				autocomplete="off" />
			</span>
		</form>
	</li>
	<!-- END Search Form -->
	<li class="active"><a href="index.html"> <i
			class="icon-dashboard"></i> <span>Dashboard</span>
	</a></li>
	<li><a href="＃" class="dropdown-toggle"> <i
			class="icon-calendar"></i> <span>信息查询</span><b class="arrow icon-angle-right"></b>
	</a> <!-- BEGIN Submenu -->
		<ul class="submenu">
			<li><a href="<%=basePath%>report/showAccounts">台账查询</a></li>
			<li><a href="<%=basePath%>report/showArticles">学习用品查询</a></li>
			<li><a href="<%=basePath%>report/showJounals">流水账查询</a></li>
			<li><a href="<%=basePath%>report/showJounalsTmp">流水账审核</a></li>
		</ul> <!-- END Submenu --></li>

	<li><a href="#" class="dropdown-toggle"> <i class="icon-file"></i>
			<span>信息录入</span> <b class="arrow icon-angle-right"></b>
	</a> <!-- BEGIN Submenu -->
		<ul class="submenu">
			<li><a href="<%=basePath%>accountImport">台账录入</a></li>
			<li><a href="<%=basePath%>accountManualImport">手动台账录入</a></li>
			<li><a href="<%=basePath%>articleImport">学习用品录入</a></li>
		</ul> <!-- END Submenu --></li>
</ul>
<!-- BEGIN Sidebar Collapse Button -->
<div id="sidebar-collapse" class="visible-desktop">
	<i class="icon-double-angle-left"></i>
</div>
<!-- END Sidebar Collapse Button -->
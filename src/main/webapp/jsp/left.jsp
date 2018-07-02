<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!-- BEGIN Sidebar -->
<div id="sidebar" class="nav-collapse">
	<!-- BEGIN Navlist -->
	<ul class="nav nav-list">
		<li id="sidebar-nav-index" class="active"><a href="<%=basePath%>"> <i
				class="icon-dashboard"></i> <span>首页</span>
		</a></li>
		<li id="sidebar-nav-query">
		<a href="#" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span>信息查询</span> <b
				class="arrow icon-angle-right"></b>
		</a> <!-- BEGIN Submenu -->
			<ul class="submenu">
				<li id="sidebar-nav-query-accounts"><a href="<%=basePath%>report/showAccounts">台账查询</a></li>
				<li id="sidebar-nav-query-artiles"><a href="<%=basePath%>report/showArticles">学习用品查询</a></li>
				<li id="sidebar-nav-query-jounals"><a href="<%=basePath%>report/showJounals">流水账查询</a></li>
				<li id="sidebar-nav-query-jounals-tmp"><a href="<%=basePath%>report/showJounalsTmp">流水账审核</a></li>
			</ul> <!-- END Submenu -->
		</li>

		<li id="sidebar-nav-input"><a href="#" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span>信息录入</span> <b
				class="arrow icon-angle-right"></b>
		</a> <!-- BEGIN Submenu -->
			<ul class="submenu">
				<li id="sidebar-nav-input-account"><a href="<%=basePath%>accountImport">台账录入</a></li>
				<li id="sidebar-nav-input-maunal"><a href="<%=basePath%>accountManualImport">手动台账录入</a></li>
				<li id="sidebar-nav-input-article"><a href="<%=basePath%>articleImport">学习用品录入</a></li>
			</ul> <!-- END Submenu --></li>
	</ul>
	<!-- END Navlist -->

	<!-- BEGIN Sidebar Collapse Button -->
	<div id="sidebar-collapse" class="visible-desktop">
		<i class="icon-double-angle-left"></i>
	</div>
	<!-- END Sidebar Collapse Button -->
</div>
<!-- END Sidebar -->
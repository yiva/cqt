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
<div class="subnav">
	<div class="subnav-title">
		<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>信息录入</span></a>
	</div>
	<ul class="subnav-menu">
		<li><a href="<%=basePath %>report/showAccounts">台账查询</a></li>
		<li><a href="<%=basePath %>report/showArticles">学习用品查询</a></li>
		<li><a href="<%=basePath %>report/showJounals">流水账查询</a></li>
		<li><a href="<%=basePath %>report/showJounalsTmp">流水账审核</a></li>
	</ul>
	<ul class="subnav-menu">
		<li><a href="<%=basePath %>accountImport">台账录入</a></li>
		<li><a href="<%=basePath %>accountManualImport">手动台账录入</a></li>
		<li><a href="<%=basePath %>articleImport">学习用品录入</a></li>
	</ul>
</div>
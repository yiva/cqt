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
		<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>操作查询</span></a>
	</div>
	<ul class="subnav-menu">
		<li><a href="emp">职工资料查询</a></li>
		<li><a href="<%=basePath %>salary/current">当月工资查询</a></li>
		<li><a href="<%=basePath %>salary/salaryreport">当月工资表</a></li>
		<li><a href="<%=basePath %>salary/sumsalaryreport">当月工资汇总表</a></li>
		<li><a href="#">报表统计</a></li>
		<li><a href="<%=basePath %>report">报表导出</a></li>
		<li><a href="#">历史查询</a></li>
	</ul>
</div>
<div class="subnav">
	<div class="subnav-title">
		<a href="#" class='toggle-subnav'><i class="icon-angle-down"></i><span>信息录入</span></a>
	</div>
	<ul class="subnav-menu">
		<li><a href="#">职工信息录入</a></li>
		<li><a href="#">职工信息修改</a></li>
		<li><a href="<%=basePath %>report/leavein">批量修改</a></li>
		<li><a href="<%=basePath %>report/templetDown">模块下载</a></li>
	</ul>
</div>
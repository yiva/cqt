<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="description" content="">
<meta name="viewport" content="width=device-width">

<!--base css styles-->
<link rel="stylesheet" href="<%=basePath %>assets/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="<%=basePath %>assets/bootstrap/bootstrap-responsive.min.css">
<link rel="stylesheet" href="<%=basePath %>assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="<%=basePath %>assets/normalize/normalize.css">

<!--flaty css styles-->
<link rel="stylesheet" href="<%=basePath %>css/flaty.css">
<link rel="stylesheet" href="<%=basePath %>css/flaty-responsive.css">

<link rel="shortcut icon" href="<%=basePath %>img/favicon.html">

<script src="<%=basePath %>assets/modernizr/modernizr-2.6.2.min.js"></script>
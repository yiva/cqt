<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!--basic scripts-->
        
<script src="<%=basePath %>assets/jquery/jquery-1.10.1.min.js"></script>
<script src="<%=basePath %>assets/bootstrap/bootstrap.min.js"></script>
<script src="<%=basePath %>assets/nicescroll/jquery.nicescroll.min.js"></script>

<!--page specific plugin scripts-->
<script src="<%=basePath %>assets/flot/jquery.flot.js"></script>
<script src="<%=basePath %>assets/flot/jquery.flot.resize.js"></script>
<script src="<%=basePath %>assets/flot/jquery.flot.pie.js"></script>
<script src="<%=basePath %>assets/flot/jquery.flot.stack.js"></script>
<script src="<%=basePath %>assets/flot/jquery.flot.crosshair.js"></script>
<script src="<%=basePath %>assets/flot/jquery.flot.tooltip.min.js"></script>
<script src="<%=basePath %>assets/sparkline/jquery.sparkline.min.js"></script>

<!--flaty scripts-->
<script src="<%=basePath %>js/flaty.js"></script>

<!--self scripts-->
<script src="<%=basePath %>js/self.js"></script>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<!-- Apple devices fullscreen -->
<meta name="apple-mobile-web-app-capable" content="yes" />
<!-- Apple devices fullscreen -->
<meta names="apple-mobile-web-app-status-bar-style" content="black-translucent" />

<!-- Tagsinput -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/tagsinput/jquery.tagsinput.css">
<!-- multi select -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/multiselect/multi-select.css">
<!-- colorpicker -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/colorpicker/colorpicker.css">
<!-- Plupload -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/plupload/jquery.plupload.queue.css">


<!-- Bootstrap -->
<link rel="stylesheet" href="<%=basePath %>css/bootstrap.min.css">
<!-- Bootstrap responsive -->
<link rel="stylesheet" href="<%=basePath %>css/bootstrap-responsive.min.css">
<!-- jQuery UI -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/jquery-ui/smoothness/jquery-ui.css">
<link rel="stylesheet" href="<%=basePath %>css/plugins/jquery-ui/smoothness/jquery.ui.theme.css">
<!-- PageGuide -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/pageguide/pageguide.css">
<!-- Fullcalendar -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/fullcalendar/fullcalendar.css">
<link rel="stylesheet" href="<%=basePath %>css/plugins/fullcalendar/fullcalendar.print.css" media="print">
<!-- chosen -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/chosen/chosen.css">
<!-- select2 -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/select2/select2.css">
<!-- icheck -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/icheck/all.css">
<!-- Theme CSS -->
<link rel="stylesheet" href="<%=basePath %>css/style.css">
<!-- Color CSS -->
<link rel="stylesheet" href="<%=basePath %>css/themes.css">
<!-- timepicker -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/timepicker/bootstrap-timepicker.min.css">

<!-- Datepicker -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/datepicker/datepicker.css">
<!-- Daterangepicker -->
<link rel="stylesheet" href="<%=basePath %>css/plugins/daterangepicker/daterangepicker.css">


<!-- jQuery -->
<script src="<%=basePath %>js/jquery.min.js"></script>
<!-- Nice Scroll -->
<script src="<%=basePath %>js/plugins/nicescroll/jquery.nicescroll.min.js"></script>
<!-- imagesLoaded -->
<script src="<%=basePath %>js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>
<!-- jQuery UI -->
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.core.min.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.widget.min.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.mouse.min.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.draggable.min.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.resizable.min.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.sortable.min.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.spinner.js"></script>
<script src="<%=basePath %>js/plugins/jquery-ui/jquery.ui.slider.js"></script>


<!-- Theme framework 
<script src="js/eakroko.min.js"></script>-->
<script src="<%=basePath %>js/eakroko.js"></script>
<!-- Theme scripts -->
<script src="<%=basePath %>js/application.min.js"></script>
<!-- Just for demonstration -->
<script src="<%=basePath %>js/demonstration.min.js"></script>

<!-- imagesLoaded -->
<script src="<%=basePath %>js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>

<!-- Touch enable for jquery UI -->
<script src="<%=basePath %>js/plugins/touch-punch/jquery.touch-punch.min.js"></script>
<!-- slimScroll -->
<script src="<%=basePath %>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Bootstrap -->
<script src="<%=basePath %>js/bootstrap.min.js"></script>
<!-- Bootbox -->
<script src="<%=basePath %>js/plugins/bootbox/jquery.bootbox.js"></script>
<!-- Masked inputs -->
<script src="<%=basePath %>js/plugins/maskedinput/jquery.maskedinput.min.js"></script>
<!-- TagsInput -->
<script src="<%=basePath %>js/plugins/tagsinput/jquery.tagsinput.min.js"></script>
<!-- Datepicker -->
<script src="<%=basePath %>js/plugins/datepicker/bootstrap-datepicker.js"></script>
<!-- Daterangepicker -->
<script src="<%=basePath %>js/plugins/daterangepicker/daterangepicker.js"></script>
<script src="<%=basePath %>js/plugins/daterangepicker/moment.min.js"></script>
<!-- Timepicker -->
<script src="<%=basePath %>js/plugins/timepicker/bootstrap-timepicker.min.js"></script>
<!-- Colorpicker -->
<script src="<%=basePath %>js/plugins/colorpicker/bootstrap-colorpicker.js"></script>
<!-- Chosen -->
<script src="<%=basePath %>js/plugins/chosen/chosen.jquery.min.js"></script>

<!-- vmap -->
<script src="<%=basePath %>js/plugins/vmap/jquery.vmap.min.js"></script>
<script src="<%=basePath %>js/plugins/vmap/jquery.vmap.world.js"></script>
<script src="<%=basePath %>js/plugins/vmap/jquery.vmap.sampledata.js"></script>
<!-- Flot -->
<script src="<%=basePath %>js/plugins/flot/jquery.flot.min.js"></script>
<script src="<%=basePath %>js/plugins/flot/jquery.flot.bar.order.min.js"></script>
<script src="<%=basePath %>js/plugins/flot/jquery.flot.pie.min.js"></script>
<script src="<%=basePath %>js/plugins/flot/jquery.flot.resize.min.js"></script>
<!-- imagesLoaded -->
<script src="<%=basePath %>js/plugins/imagesLoaded/jquery.imagesloaded.min.js"></script>
<!-- PageGuide -->
<script src="<%=basePath %>js/plugins/pageguide/jquery.pageguide.js"></script>
<!-- FullCalendar -->
<script src="<%=basePath %>js/plugins/fullcalendar/fullcalendar.min.js"></script>
<!-- select2 -->
<script src="<%=basePath %>js/plugins/select2/select2.min.js"></script>
<!-- icheck -->
<script src="<%=basePath %>js/plugins/icheck/jquery.icheck.min.js"></script>
<!-- dataTables -->
<script src="<%=basePath %>js/plugins/datatable/jquery.dataTables.min.js"></script>
<script src="<%=basePath %>js/plugins/datatable/TableTools.min.js"></script>
<script src="<%=basePath %>js/plugins/datatable/ColReorder.min.js"></script>
<script src="<%=basePath %>js/plugins/datatable/ColVis.min.js"></script>
<script src="<%=basePath %>js/plugins/datatable/FixedColumns.min.js"></script>
<script src="<%=basePath %>js/plugins/datatable/dataTables.scroller.min.js"></script>

<!-- Form -->
<script src="<%=basePath %>js/plugins/form/jquery.form.min.js"></script>
<!-- Timepicker -->
<script src="<%=basePath %>js/plugins/timepicker/bootstrap-timepicker-24h.min.js"></script>
<script src="<%=basePath %>js/plugins/timepicker/compare.time.js"></script>



<!--[if lte IE 9]>
	<script src="js/plugins/placeholder/jquery.placeholder.min.js"></script>
	<script>
		$(document).ready(function() {
			$('input, textarea').placeholder();
		});
	</script>
<![endif]-->

<!-- Favicon -->
<link rel="shortcut icon" href="<%=basePath %>img/favicon.ico" />
<!-- Apple devices Homescreen icon -->
<link rel="apple-touch-icon-precomposed" href="<%=basePath %>img/apple-touch-icon-precomposed.png" />

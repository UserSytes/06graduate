<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<META http-equiv=Content-Type content="text/html; charset=UTF-8">
		<META http-equiv=Pragma content=no-cache>
		<META http-equiv=Cache-Control content=no-cache>
		<META http-equiv=Expires content=-1000>
		<LINK href="${ctx}/css/teacher.css" type=text/css rel=stylesheet>
		<LINK href="${ctx}/css/pagination.css" type=text/css rel=stylesheet>
		<link rel="stylesheet" href="${ctx}/css/thickbox.css" type="text/css"
			media="screen" />		
		<script type="text/javascript"
			src="${ctx}/js/jquery-1.4.1-and-plugins.min.js"></script>
	
		<script type="text/javascript" src="${ctx}/js/jquery.pagination.js"></script>
		<title>学生列表</title>
		<!--
.STYLE1 {
	color: #000000
}

.profile_pic {
	width: 60px;
	line-height: 1px;
}

.profile_pic a:hover {
	text-decoration: none;
}
-->
</style>
			<script>
		$(document).ready(function(){
			$('#demo').pagination({
				count:100,
				pageCount:10,
				imagePath:"${ctx}/commons/images",
				callback: pageselectCallback,
			});
			 
	function pageselectCallback(page_index){
		 alert(0);
	}
		});
	</script>
	</head>
	<body>
		
	<div id="demo"></div>
	</body>
</html>
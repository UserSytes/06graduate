<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<html>
	<head>
	</head>
	<body>
		<script language="javascript">
			$( function() {
			$.ajaxSetup ({
cache: false
});
		var url = "getLeftNoticeAction.action";
		$('#left-nav-bar').load(url);
		})
</script>
		<div id="left-nav-bar" class="bg_white">
			<s:include value="leftinfo.jsp"></s:include>
		</div>
	</body>
</html>

<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学精品课程-后台管理中心</title>
	<frameset rows="59,*" frameborder="no" border="0" framespacing="0">
		<frame src="superadmintop.jsp" noresize="noresize" frameborder="0"
			name="topFrame" marginwidth="0" marginheight="0" scrolling="no" />
		<frameset rows="*" cols="195,*" id="frame">
			<frame src="superadminleft.jsp" name="leftFrame" noresize="noresize"
				marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" />
			<frame src="help.jsp" name="main" marginwidth="0" marginheight="0"
				frameborder="0" scrolling="yes" />
		</frameset>

		<noframes>
			<body></body>
		</noframes>
	</frameset>
</html>
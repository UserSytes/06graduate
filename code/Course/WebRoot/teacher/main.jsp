<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>厦门大学课程平台-教师管理系统</title>
	</head>
	
	<frameset rows="90,*,30" cols="*" framespacing="0" frameborder="no"
		border="0">
		<frame src="${ctx}/teacher/top.jsp" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" />
		<frame  src="${ctx}/teacher/center.jsp" name="mainFrame" id="mainFrame" scrolling="auto"/>
		<frame src="${ctx}/teacher/down.jsp" name="bottomFrame" scrolling="No"
			noresize="noresize" id="bottomFrame" />
	</frameset>
	<noframes>
		<body >
		</body>
	</noframes>
</html>
